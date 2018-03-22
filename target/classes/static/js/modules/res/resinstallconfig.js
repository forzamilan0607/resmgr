$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + ' res/resinstallconfig/list',
        datatype: "json",
        colModel: [			
			{ label: 'configId', name: 'configId', index: 'config_id', width: 50, key: true },
			{ label: '资源ID', name: 'resId', index: 'res_id', width: 80 }, 			
			{ label: '图纸，多个附件ID以逗号分隔', name: 'drawing', index: 'drawing', width: 80 }, 			
			{ label: '操作规范说明', name: 'operationSpecificationText', index: 'operation_specification_text', width: 80 }, 			
			{ label: '操作规范说明（附件），多个附件ID以逗号分隔', name: 'operationSpecificationAttach', index: 'operation_specification_attach', width: 80 }, 			
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
		resInstallConfig: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resInstallConfig = {};
		},
		update: function (event) {
			var configId = getSelectedRow();
			if(configId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(configId)
		},
		saveOrUpdate: function (event) {
			var url = vm.resInstallConfig.configId == null ? " res/resinstallconfig/save" : " res/resinstallconfig/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resInstallConfig),
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
			var configIds = getSelectedRows();
			if(configIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + " res/resinstallconfig/delete",
                    contentType: "application/json",
				    data: JSON.stringify(configIds),
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
		getInfo: function(configId){
			$.get(baseURL + " res/resinstallconfig/info/"+configId, function(r){
                vm.resInstallConfig = r.resInstallConfig;
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