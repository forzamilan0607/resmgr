var $sysDictTree = function () {
    return {
        treeObj: null,
        srcData: null,
        config: {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "dictId",
                    pIdKey: "parentDictId",
                    rootPId: -1
                },
                key: {
                    url:"nourl",
                    name: "dictName"
                }
            }
        },
        init: function () {
            $.ajax({
                type: "POST",
                url: baseURL + "sys/sysdict/querySysDictListByCondition",
                contentType: "application/json",
                data: JSON.stringify({}),
                success: function(r){
                    if(r.code == $util.HTTP_STATUS.SC_OK){
                        $sysDictTree.srcData = $.extend({}, r.data);
                        $sysDictTree.treeObj = $.fn.zTree.init($("#parentDicTree"), $sysDictTree.config, r.data);
                    }else{
                        alert(r.msg);
                    }
                    // var node = ztree.getNodeByParam("dictId", parentId).getNodeByParam("dictId", parentId);
                    // this.treeObj.selectNode(node);
                }
            });
            // vm.menu.parentName = node.name;
        }
    }
}();
var vm = new Vue({
    el:'#sysDictApp',
    data:{
        showList: true,
        title: null,
        sysDict: {
            status: "1",
            // parentDictName: "abc",
            dictItems: []
        },
        sysDictItem: {},
        srcSysDict: null,
        isChangedDictItems: false
    },
    created: function (){
        $sysDictTree.init();
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
        },
        update: function (event) {
            var dictId = getSelectedRow();
            if(dictId == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";
            vm.getInfo(dictId);
        },
        isUpdateAction: function () {
          return vm.sysDict.dictId != null;
        },
        saveOrUpdate: function (event) {
            var url = vm.isUpdateAction() ? "sys/sysdict/update" : "sys/sysdict/save";
            if (vm.isUpdateAction()) {
                vm.sysDict.changedDictItems = vm.isChangedDictItems;
                if (!vm.isChangedDictItems && $util.isObjAttrEquals(vm.srcSysDict, vm.sysDict, ["dictName", "status", "dictDesc"])) {
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
                            vm.updateDictTree();
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
        getInfo: function(dictId){
            $.get(baseURL + "sys/sysdict/info/"+dictId, function(r){
                vm.sysDict = r.sysDict;
                vm.srcSysDict = $.extend({}, vm.sysDict);
                var nodes = $sysDictTree.treeObj.getSelectedNodes();
                $.each(nodes, function (index, node) {
                    if (node.dictId == vm.sysDict.dictId || node.parentDictId == vm.sysDict.dictId) {
                        $sysDictTree.treeObj.removeNode(node);
                    }
                });
            });
        },
        updateDictTree: function () {
          if (this.isUpdateAction()) {
              var node = $sysDictTree.treeObj.getNodeByTId(this.sysDict.dictId);
              node.dictName = this.sysDict.dictName;

          } else {
              $sysDictTree.treeObj.addNodes(null, {
                  dictId: this.sysDict.dictId,
                  dictName: this.sysDict.dictName,
                  parentId: this.sysDict.parentDictId
              });
          }
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
                    if ($validator.isBlank(vm.sysDictItem.dictItemName)) {
                        alert("字典项名称不能为空！");
                        return;
                    }
                    var data = $.grep(vm.sysDict.dictItems, function(item, i){return i != itemIndex;});
                    //判断名称是否已经存在
                    if ($util.isValueInArray("dictItemName", vm.sysDictItem.dictItemName, data)) {
                        alert("字典项名称已存在，请重新输入！");
                        return;
                    }
                    if ($validator.isBlank(vm.sysDictItem.dictItemValue)) {
                        alert("字典项值不能为空！");
                        return;
                    }
                    if (!$validator.checkKey(vm.sysDictItem.dictItemValue)) {
                        alert("字典项值只能输入数字或字母");
                        return;
                    }
                    //判断值是否已经存在
                    if ($util.isValueInArray("dictItemValue", vm.sysDictItem.dictItemValue, data)) {
                        alert("字典项值已存在，请重新输入！");
                        return;
                    }
                    if (itemIndex == -1) {
                        vm.sysDict.dictItems.push($.extend({}, vm.sysDictItem));
                        vm.isChangedDictItems = true;
                        _validate4AddDict.resetById("table_dictItems");
                    } else {
                        if (!$util.isObjAttrEquals(vm.sysDictItem, vm.sysDict.dictItems[itemIndex], ["dictItemName", "dictItemValue", "extValue1", "extValue2"])) {
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
                if (vm.sysDict.dictItems[index].dictItemId) {
                    vm.isChangedDictItems = true;
                }
                //修改字典操作时，删除字典项值需要调用后台接口查询字典项是否有引用，否则不允许删除
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/sysdict/isCanDelDictItem",
                    contentType: "application/json",
                    data: JSON.stringify(vm.sysDict.dictItems[index].dictItemId),
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
        },
        showParentDict: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择菜单",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#parentDicLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    var nodes = $sysDictTree.treeObj.getSelectedNodes();
                    vm.sysDict.parentDictId = nodes[0].dictId;
                    vm.sysDict.parentDictName = nodes[0].dictName;
                    layer.close(index);
                }
            });
        }
    }
});

var _validate4AddDict;
function initValidator() {
    return $validator.build({
        allPassRequired: false,
        items:[
            {
                id: "dictName",
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
                        value: ["dictName", "dictId"],
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
                        value: 50,
                        msg: $myMsg.maxLength("字典名称", 50)
                    }
                }
            }
        ]
    });
};
$(function () {
    _validate4AddDict = initValidator();
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdict/list',
        datatype: "json",
        colModel: [			
			{ label: '字典ID', name: 'dictId', index: 'dict_id', width: 50, key: true },
			{ label: '字典名称', name: 'dictName', index: 'dict_name', width: 80 }, 			
			{ label: '字典描述', name: 'dictDesc', index: 'dict_desc', width: 80 },
			{ label: '父级字典', name: 'parentDictId', index: 'parent_dict_id', width: 80 },
			{ label: '状态', name: 'status', index: 'status', width: 80 },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }
        ],
		viewrecords: true,
        height: 370,
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
