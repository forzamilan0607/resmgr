var vm = new Vue({
    el:'#sysDictApp',
    data:{
        showList: true,
        title: null,
        sysDict: {
            status: "-1",
            dictItems: []
        },
        sysDictItem: {

        }
    },
    created: function (){
        console.log(JSON.stringify(this.sysDict));
    },
    methods: {
        query: function () {
            vm.reload();
        },
        validate: function () {
            if (!_validate4AddDict.form()) {
                return false;
            }
            if (!this.sysDict.status || this.sysDict.status == "-1") {
                alert("请选择状态");
                return false;
            }
            if (!$.isArray(this.sysDict.dictItems) || !this.sysDict.dictItems.length) {
                alert("请添加字典值");
                return false;
            }
            return true;
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

            vm.getInfo(dictId)
        },
        saveOrUpdate: function (event) {
            if (!this.validate()) {
                return;
            }
            var url = vm.sysDict.dictId == null ? "sys/sysdict/save" : "sys/sysdict/update";
            //校验
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.sysDict),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                            vm.sysDict = {};
                            _validate4AddDict.reset();
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
                        if(r.code == 0){
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
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                page:page
            }).trigger("reloadGrid");
        },
        addDictItem: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "添加字典项",
                area: ['450px', '330px'],
                // shade: 0,
                // shadeClose: false,
                content: jQuery("#dictItemsLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    if (isBlank(vm.sysDictItem.dictItemName)) {
                        alert("字典项名称不能为空！");
                        return;
                    }
                    //判断名称是否已经存在
                    if ($util.isValueInArray("dictItemName", vm.sysDictItem.dictItemName, vm.sysDict.dictItems)) {
                        alert("字典项名称已存在，请重新输入！");
                        return;
                    }
                    if (isBlank(vm.sysDictItem.dictItemValue)) {
                        alert("字典项值不能为空！");
                        return;
                    }
                    //判断值是否已经存在
                    if ($util.isValueInArray("dictItemValue", vm.sysDictItem.dictItemValue, vm.sysDict.dictItems)) {
                        alert("字典项值已存在，请重新输入！");
                        return;
                    }
                    vm.sysDict.dictItems.push($.extend({}, vm.sysDictItem));
                    //关闭layer之前清空字典项
                    clearObjValue(vm.sysDictItem);
                    layer.close(index);
                }
            });
        },
        delDictItem: function(index){
            this.sysDict.dictItems.splice(index, 1);
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
                    alert(JSON.stringify(vm.sysDictItem));
                    //layer.close(index);
                }
            });
        }
    }
});

var _validate4AddDict;
function validate4AddDict() {
    //自定义正则表达示验证方法
    $.validator.addMethod("checkDictKey",function(value,element,params){
        return this.optional(element)||(/^([A-Z]{2,15}_[A-Z]{2,15}|[A-Z]{2,20})$/g.test(value));
    },"*请输入正确的QQ号码！");
    return $("#register-form").validate({
        rules: {
            status: {
                required: true
            },
            dictName: {
                required: true,
                rangelength: [2, 32]
            },
            dictKey: {
                required: true,
                rangelength: [2, 32],
                checkDictKey: true,
                remote:{
                    type: "POST",
                    url: baseURL + 'sys/sysdict/checkDictKey', //请求地址
                    data:{
                        dictKey:function(){ return $("#dictKey").val(); }
                    }
                }
            },
            dictDesc: {
                maxlength: 50
            }
        },
        messages: {
            dictName: {
                required: $myMsg.required("字典名称"),
                rangelength: $myMsg.rangelength("字典名称", 2, 32)
            },
            dictKey: {
                required: $myMsg.required("字典KEY"),
                rangelength: $myMsg.rangelength("字典key", 2, 32),
                checkDictKey: "字典KEY只能是大写字母，请参考：CUSTLEVEL或CUST_LEVEL",
                remote: "该字典KEY已存在"
            },
            status: $myMsg.required4Sel("状态"),
            dictDesc: {
                maxlength: $myMsg.maxLength("字典名称", 50)
            }
        },
        onkeyup:false,
        errorElement : 'span',
        errorClass : 'help-block',
        errorPlacement : function(error, element) {
            element.next().remove();
            element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
            element.closest('.form-group').append(error);
        },
        highlight : function(element) {
            $(element).closest('.form-group').addClass('has-error has-feedback');
        },
        success : function(label) {
            var elem = label.closest('.form-group').find("input");
            if (elem.length == 0) {
                elem = label.closest('.form-group').find("textarea");
            }
            elem.next().remove();
            elem.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
            label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
            label.remove();
        },
        submitHandler: function(form) {
            console.log(JSON.stringify(form));
        }
    });
}
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdict/list',
        datatype: "json",
        colModel: [			
			{ label: '字典ID', name: 'dictId', index: 'dict_id', width: 50, key: true },
			{ label: '字典名称', name: 'dictName', index: 'dict_name', width: 80 }, 			
			{ label: '字典KEY', name: 'dictName', index: 'dict_key', width: 80 },
			{ label: '字典描述', name: 'dictDesc', index: 'dict_desc', width: 80 },
			{ label: '父级字典', name: 'parentDictId', index: 'parent_dict_id', width: 80 },
			{ label: '状态', name: 'status', index: 'status', width: 80 },
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
    _validate4AddDict = validate4AddDict();
});
