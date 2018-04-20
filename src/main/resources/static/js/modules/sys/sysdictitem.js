var vm = new Vue({
	el:'#infTestApp',
	data:{
		title: null,
		param: {
			beginDate: "2018-04-01",
			endDate: "2018-04-20"
		}
	},
	methods: {
		saveOrUpdate: function (event) {
			$.ajax({
				type: "POST",
			    url: baseURL + "inf/test/query",
                contentType: "application/json",
			    data: JSON.stringify(vm.param),
			    success: function(r){
			    	if(r.code === 200){
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
			var dictItemIds = getSelectedRows();
			if(dictItemIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/sysdictitem/delete",
                    contentType: "application/json",
				    data: JSON.stringify(dictItemIds),
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
		getInfo: function(dictItemId){
			$.get(baseURL + "sys/sysdictitem/info/"+dictItemId, function(r){
                vm.sysDictItem = r.sysDictItem;
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