$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + ' res/resattachment/list',
        datatype: "json",
        colModel: [			
			{ label: 'attachId', name: 'attachId', index: 'attach_id', width: 50, key: true },
			{ label: '附件名称', name: 'attachName', index: 'attach_name', width: 80 }, 			
			{ label: '资源ID', name: 'resId', index: 'res_id', width: 80 }, 			
			{ label: '附件大小，KB为单位', name: 'attachSize', index: 'attach_size', width: 80 }, 			
			{ label: '附件类型，如：jpg、png、pdf、xls、word、mp4等', name: 'attachType', index: 'attach_type', width: 80 }, 			
			{ label: '上传时间', name: 'uploadTime', index: 'upload_time', width: 80 }, 			
			{ label: '是否同步，1、是，0、否', name: 'isSync', index: 'is_sync', width: 80 }, 			
			{ label: '顺序', name: 'order', index: 'order', width: 80 }			
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
		resAttachment: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resAttachment = {};
		},
		update: function (event) {
			var attachId = getSelectedRow();
			if(attachId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(attachId)
		},
		saveOrUpdate: function (event) {
			var url = vm.resAttachment.attachId == null ? " res/resattachment/save" : " res/resattachment/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resAttachment),
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
			var attachIds = getSelectedRows();
			if(attachIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + " res/resattachment/delete",
                    contentType: "application/json",
				    data: JSON.stringify(attachIds),
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
		getInfo: function(attachId){
			$.get(baseURL + " res/resattachment/info/"+attachId, function(r){
                vm.resAttachment = r.resAttachment;
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