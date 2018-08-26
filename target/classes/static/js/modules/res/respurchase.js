$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + ' res/respurchase/list',
        datatype: "json",
        colModel: [			
			{ label: 'purchaseId', name: 'purchaseId', index: 'purchase_id', width: 50, key: true },
			{ label: '资源ID', name: 'resId', index: 'res_id', width: 80 }, 			
			{ label: '合同单位', name: 'contractCompany', index: 'contract_company', width: 80 }, 			
			{ label: '合同编号', name: 'contractNo', index: 'contract_no', width: 80 }, 			
			{ label: '合同附件，多个附件ID以逗号分隔', name: 'contractAttach', index: 'contract_attach', width: 80 }, 			
			{ label: '合同描述', name: 'contractDesc', index: 'contract_desc', width: 80 }, 			
			{ label: '采购价格', name: 'purchasePrice', index: 'purchase_price', width: 80 }, 			
			{ label: '采购时间', name: 'purchaseDate', index: 'purchase_date', width: 80 }, 			
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
		resPurchase: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resPurchase = {};
		},
		update: function (event) {
			var purchaseId = getSelectedRow();
			if(purchaseId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(purchaseId)
		},
		saveOrUpdate: function (event) {
			var url = vm.resPurchase.purchaseId == null ? " res/respurchase/save" : " res/respurchase/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resPurchase),
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
			var purchaseIds = getSelectedRows();
			if(purchaseIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + " res/respurchase/delete",
                    contentType: "application/json",
				    data: JSON.stringify(purchaseIds),
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
		getInfo: function(purchaseId){
			$.get(baseURL + " res/respurchase/info/"+purchaseId, function(r){
                vm.resPurchase = r.resPurchase;
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