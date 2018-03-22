$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysdict/list',
        datatype: "json",
        colModel: [			
			{ label: 'dictId', name: 'dictId', index: 'dict_id', width: 50, key: true },
			{ label: '字典名称', name: 'dictName', index: 'dict_name', width: 80 }, 			
			{ label: '字典描述', name: 'dictDesc', index: 'dict_desc', width: 80 }, 			
			{ label: '父级字典ID', name: 'parentDictId', index: 'parent_dict_id', width: 80 }, 			
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
		sysDict: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysDict = {};
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
			var url = vm.sysDict.dictId == null ? "generator/sysdict/save" : "generator/sysdict/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysDict),
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
			var dictIds = getSelectedRows();
			if(dictIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "generator/sysdict/delete",
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
			$.get(baseURL + "generator/sysdict/info/"+dictId, function(r){
                vm.sysDict = r.sysDict;
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