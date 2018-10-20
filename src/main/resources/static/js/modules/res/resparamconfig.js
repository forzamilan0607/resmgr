$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + ' res/resparamconfig/list',
        datatype: "json",
        colModel: [			
			{ label: 'resId', name: 'resId', index: 'res_id', width: 50, key: true },
			{ label: '属性ID', name: 'attrId', index: 'attr_id', width: 80 }, 			
			{ label: '属性值', name: 'attrValue', index: 'attr_value', width: 80 }, 			
			{ label: '是否同步，1、是，0、否', name: 'isSync', index: 'is_sync', width: 80 }			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		resParamConfig: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resParamConfig = {};
		},
		update: function (event) {
			var resId = getSelectedRow();
			if(resId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(resId)
		},
		saveOrUpdate: function (event) {
			var url = vm.resParamConfig.resId == null ? " res/resparamconfig/save" : " res/resparamconfig/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resParamConfig),
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
			var resIds = getSelectedRows();
			if(resIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + " res/resparamconfig/delete",
                    contentType: "application/json",
				    data: JSON.stringify(resIds),
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
		getInfo: function(resId){
			$.get(baseURL + " res/resparamconfig/info/"+resId, function(r){
                vm.resParamConfig = r.resParamConfig;
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