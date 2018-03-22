$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdictitem/list',
        datatype: "json",
        colModel: [			
			{ label: 'dictItemId', name: 'dictItemId', index: 'dict_item_id', width: 50, key: true },
			{ label: '字典ID', name: 'dictId', index: 'dict_id', width: 80 }, 			
			{ label: '字典项值', name: 'dictItemValue', index: 'dict_item_value', width: 80 }, 			
			{ label: '扩展值1', name: 'extValue1', index: 'ext_value1', width: 80 }, 			
			{ label: '扩展值2', name: 'extValue2', index: 'ext_value2', width: 80 }, 			
			{ label: '排序', name: 'order', index: 'order', width: 80 }, 			
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
		sysDictItem: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysDictItem = {};
		},
		update: function (event) {
			var dictItemId = getSelectedRow();
			if(dictItemId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(dictItemId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysDictItem.dictItemId == null ? "generator/sysdictitem/save" : "generator/sysdictitem/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysDictItem),
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
			var dictItemIds = getSelectedRows();
			if(dictItemIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "generator/sysdictitem/delete",
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
			$.get(baseURL + "generator/sysdictitem/info/"+dictItemId, function(r){
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