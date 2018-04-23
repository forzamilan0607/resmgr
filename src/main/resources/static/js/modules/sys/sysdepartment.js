$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdepartment/list',
        datatype: "json",
        colModel: [			
			{ label: 'deptId', name: 'deptId', index: 'dept_id', width: 50, key: true },
			{ label: '部门名称', name: 'deptName', index: 'dept_name', width: 80 }, 			
			{ label: '公司ID', name: 'companyId', index: 'company_id', width: 80 }, 			
			{ label: '状态，1、有效，0、无效', name: 'status', index: 'status', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建人', name: 'createUserId', index: 'create_user_id', width: 80 }, 			
			{ label: '修改时间', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
			{ label: '修改人', name: 'modifyUserId', index: 'modify_user_id', width: 80 }, 			
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
		sysDepartment: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysDepartment = {};
		},
		update: function (event) {
			var deptId = getSelectedRow();
			if(deptId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(deptId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysDepartment.deptId == null ? "sys/sysdepartment/save" : "sys/sysdepartment/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysDepartment),
			    success: function(r){
			    	if(r.code == $util.HTTP_STATUS.SC_OK){
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
			var deptIds = getSelectedRows();
			if(deptIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/sysdepartment/delete",
                    contentType: "application/json",
				    data: JSON.stringify(deptIds),
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
		getInfo: function(deptId){
			$.get(baseURL + "sys/sysdepartment/info/"+deptId, function(r){
                vm.sysDepartment = r.sysDepartment;
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