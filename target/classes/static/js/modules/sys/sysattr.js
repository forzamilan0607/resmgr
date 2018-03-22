$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysattr/list',
        datatype: "json",
        colModel: [			
			{ label: 'attrId', name: 'attrId', index: 'attr_id', width: 50, key: true },
			{ label: '属性名称', name: 'attrName', index: 'attr_name', width: 80 }, 			
			{ label: '属性类别，如：文本、数字、邮件、IP地址、下拉框等', name: 'attrType', index: 'attr_type', width: 80 }, 			
			{ label: '数据来源，1、属性值表 2、字典表 3、业务表', name: 'dataSource', index: 'data_source', width: 80 }, 			
			{ label: '正则表达式', name: 'regExpression', index: 'reg_expression', width: 80 }, 			
			{ label: '数据来源=2时为字典KEY，=3时为业务表SQL', name: 'queryText', index: 'query_text', width: 80 }, 			
			{ label: '状态，1、有效，0、无效', name: 'status', index: 'status', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '是否同步，1、是，0、否', name: 'isSync', index: 'is_sync', width: 80 }			
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
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		sysAttr: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysAttr = {};
		},
		update: function (event) {
			var attrId = getSelectedRow();
			if(attrId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(attrId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysAttr.attrId == null ? "generator/sysattr/save" : "generator/sysattr/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysAttr),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var attrIds = getSelectedRows();
			if(attrIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "generator/sysattr/delete",
                    contentType: "application/json",
				    data: JSON.stringify(attrIds),
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
		getInfo: function(attrId){
			$.get(baseURL + "generator/sysattr/info/"+attrId, function(r){
                vm.sysAttr = r.sysAttr;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});