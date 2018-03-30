$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/sysattrvalue/list',
        datatype: "json",
        colModel: [			
			{ label: 'attrValueId', name: 'attrValueId', index: 'attr_value_id', width: 50, key: true },
			{ label: '属性ID', name: 'attrId', index: 'attr_id', width: 80 }, 			
			{ label: '属性值', name: 'attrValue', index: 'attr_value', width: 80 }, 			
			{ label: '顺序', name: 'sortOrder', index: 'sort_order', width: 80 },
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
            order: "sortOrder"
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
		sysAttrValue: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysAttrValue = {};
		},
		update: function (event) {
			var attrValueId = getSelectedRow();
			if(attrValueId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(attrValueId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysAttrValue.attrValueId == null ? "sys/sysattrvalue/save" : "sys/sysattrvalue/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysAttrValue),
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
			var attrValueIds = getSelectedRows();
			if(attrValueIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/sysattrvalue/delete",
                    contentType: "application/json",
				    data: JSON.stringify(attrValueIds),
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
		getInfo: function(attrValueId){
			$.get(baseURL + "sys/sysattrvalue/info/"+attrValueId, function(r){
                vm.sysAttrValue = r.sysAttrValue;
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