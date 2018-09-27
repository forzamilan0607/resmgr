var $myValidator = null;
function initValidator() {
    return {

	};
}
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'res/resmaintenance/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '资源ID', name: 'resId', index: 'res_id', width: 80 }, 			
			{ label: '维护单位', name: 'maintainDeptId', index: 'maintain_dept_id', width: 80 }, 			
			{ label: '责任人', name: 'personResponsible', index: 'person_responsible', width: 80 }, 			
			{ label: '保修开始日期', name: 'warrantyStartDate', index: 'warranty_start_date', width: 80 }, 			
			{ label: '保修结束日期', name: 'warrantyEndDate', index: 'warranty_end_date', width: 80 }, 			
			{ label: '维保单位', name: 'maintainCompany', index: 'maintain_company', width: 80 }, 			
			{ label: '维保周期', name: 'maintainPeriod', index: 'maintain_period', width: 80 }, 			
			{ label: '维保价格', name: 'maintainPrice', index: 'maintain_price', width: 80 }, 			
			{ label: '维保合同，多个附件ID以逗号分隔', name: 'maintainContract', index: 'maintain_contract', width: 80 }, 			
			{ label: '设备资源说明书，多个附件ID以逗号分隔', name: 'resInstructions', index: 'res_instructions', width: 80 }, 			
			{ label: '运维或保养特别提示、注意事项（文字）', name: 'precautionsText', index: 'precautions_text', width: 80 }, 			
			{ label: '运维或保养特别提示、注意事项（附件）', name: 'precautionsAttach', index: 'precautions_attach', width: 80 }, 			
			{ label: '设备状态,入库/在用/送修/注销', name: 'resStatus', index: 'res_status', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建人', name: 'createUserId', index: 'create_user_id', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '修改人', name: 'updateUserId', index: 'update_user_id', width: 80 }			
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
		resMaintenance: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resMaintenance = {};
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
		saveOrUpdate: function (event) {
			var url = vm.resMaintenance.id == null ? "res/resmaintenance/save" : "res/resmaintenance/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resMaintenance),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "res/resmaintenance/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "res/resmaintenance/info/"+id, function(r){
                vm.resMaintenance = r.resMaintenance;
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