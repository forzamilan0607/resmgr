$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdict/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '字典名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80 },
			{ label: '字典描述', name: 'dictDesc', index: 'dict_desc', width: 200 },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#sysDictApp',
	data:{
        showList: true,
        title: null,
        sysDict: {
            status: "1",
            dictItems: []
        },
        sysDictItem: {},
        srcSysDict: null,
        isChangedDictItems: false
	},
    created: function (){
        console.log("created");
    },
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysDict = {
                status: "1",
                dictItems: []
            };
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
        isUpdateAction: function () {
            return vm.sysDict.id != null;
        },
		saveOrUpdate: function (event) {
			var url = vm.sysDict.id == null ? "sys/sysdict/save" : "sys/sysdict/update";
            var url = vm.isUpdateAction() ? "sys/sysdict/update" : "sys/sysdict/save";
            if (vm.isUpdateAction()) {
                vm.sysDict.changedDictItems = vm.isChangedDictItems;
                if (!vm.isChangedDictItems && $util.isObjAttrEquals(vm.srcSysDict, vm.sysDict, ["name", "status", "dictDesc"])) {
                    alert("当前未做任何修改！");
                    return;
                }
            }
            if (!_validate4AddDict.validate()) {
                return;
            }
            //校验
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.sysDict),
                success: function(r){
                    if(r.code == $util.HTTP_STATUS.SC_OK){
                        alert('操作成功', function(index){
                            vm.reload();
                            //更新字典树
                            // vm.updateDictTree();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
		},
		del: function (event) {
            var dictIds = getSelectedRows();
            if(dictIds == null){
                return ;
            }
            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/sysdict/delete",
                    contentType: "application/json",
                    data: JSON.stringify(dictIds),
                    success: function(r){
                        if(r.code == $util.HTTP_STATUS.SC_OK){
                            alert('操作成功', function(index){
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
		},
		getInfo: function(id){
			$.get(baseURL + "sys/sysdict/info/" + id, function(r){
                vm.sysDict = r.sysDict;
            });
		},
		reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                page:page
            }).trigger("reloadGrid");
            vm.sysDict = {};
            $("span.glyphicon-remove,span.glyphicon-ok").remove();
            $(".has-success").removeClass("has-success");
            $(".has-error").removeClass("has-error");
		},
        addOrUpdateDictItem: function(itemIndex){
            var isUpdateAction = itemIndex != -1;
            vm.sysDictItem = isUpdateAction ? $.extend({}, vm.sysDict.dictItems[itemIndex]) : {};
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: isUpdateAction ? "修改字典项" : "添加字典项",
                area: ['450px', '330px'],
                // shade: 0,
                // shadeClose: false,
                content: jQuery("#dictItemsLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    vm.isChangedDictItems = false;
                    if ($validator.isBlank(vm.sysDictItem.name)) {
                        alert("字典项名称不能为空！");
                        return;
                    }
                    var data = $.grep(vm.sysDict.dictItems, function(item, i){return i != itemIndex;});
                    //判断名称是否已经存在
                    if ($util.isValueInArray("name", vm.sysDictItem.name, data)) {
                        alert("字典项名称已存在，请重新输入！");
                        return;
                    }
                    if ($validator.isBlank(vm.sysDictItem.value)) {
                        alert("字典项值不能为空！");
                        return;
                    }
                    if (!$validator.checkKey(vm.sysDictItem.value)) {
                        alert("字典项值只能输入数字或字母");
                        return;
                    }
                    //判断值是否已经存在
                    if ($util.isValueInArray("value", vm.sysDictItem.value, data)) {
                        alert("字典项值已存在，请重新输入！");
                        return;
                    }
                    if (itemIndex == -1) {
                        vm.sysDict.dictItems.push($.extend({}, vm.sysDictItem));
                        vm.isChangedDictItems = true;
                        _validate4AddDict.resetById("table_dictItems");
                    } else {
                        if (!$util.isObjAttrEquals(vm.sysDictItem, vm.sysDict.dictItems[itemIndex], ["name", "value", "extValue1", "extValue2"])) {
                            vm.isChangedDictItems = true;
                        }
                        $util.copyProps(vm.sysDictItem, vm.sysDict.dictItems[itemIndex]);
                    }
                    //关闭layer之前清空字典项
                    clearObjValue(vm.sysDictItem);
                    layer.close(index);
                }
            });
        },
        delDictItem: function(index){
            if (vm.isUpdateAction()) {
                if (vm.sysDict.dictItems[index].id) {
                    vm.isChangedDictItems = true;
                }
                //修改字典操作时，删除字典项值需要调用后台接口查询字典项是否有引用，否则不允许删除
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/sysdict/isCanDelDictItem",
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysDict.dictItems[index].id),
                    success: function(result){
                        if(result){
                            this.sysDict.dictItems.splice(index, 1);
                        } else{
                            alert("当前字典项值存在引用，不能删除！");
                        }
                    }
                });
            } else {
                this.sysDict.dictItems.splice(index, 1);
            }
        }
	}
});
var _validate4AddDict;
function initValidator() {
    return $validator.build({
        allPassRequired: false,
        items:[
            {
                id: "name",
                blurs: ["required", "range", "remote"],
                noTriggerEvents: ["remote"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入字典名称"
                    },
                    range: {
                        value: [2, 32],
                        msg: "字典名称长度范围只能是2-32位之间"
                    },
                    remote: {
                        url : baseURL + 'sys/sysdict/checkDictName',
                        value: ["name", "id"],
                        msg: "该字典名称已存在！",
                        callback: null
                    }
                }
            },
            {
                id: "status",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: "-1",
                        msg: "请选择状态"
                    }
                }
            },
            {
                id: "table_dictItems",
                validateMethod: {
                    minLength: {
                        childSelector: "#tbody_dictItems tr",
                        value: 1,
                        msg: "请至少添加一个字典项值"
                    }
                }
            },
            {
                id: "dictDesc",
                validateMethod: {
                    maxLength: {
                        value: 100,
                        msg: $myMsg.maxLength("字典名称", 100)
                    }
                }
            }
        ]
    });
};
$(function () {
    _validate4AddDict = initValidator();
});