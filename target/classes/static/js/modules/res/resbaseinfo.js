$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + ' res/resbaseinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'resId', name: 'resId', index: 'res_id', width: 50, key: true },
			{ label: '资源类别', name: 'resType', index: 'res_type', width: 80 }, 			
			{ label: '品牌', name: 'brand', index: 'brand', width: 80 }, 			
			{ label: '系列', name: 'series', index: 'series', width: 80 }, 			
			{ label: '型号', name: 'model', index: 'model', width: 80 }, 			
			{ label: '出厂时间', name: 'factoryTime', index: 'factory_time', width: 80 }, 			
			{ label: '整机序列号', name: 'serialNo', index: 'serial_no', width: 80 }, 			
			{ label: '主要部件信息', name: 'componentInfo', index: 'component_info', width: 80 }, 			
			{ label: '资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔', name: 'resNameplate', index: 'res_nameplate', width: 80 }, 			
			{ label: '描述性位置，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面', name: 'positionDesc', index: 'position_desc', width: 80 }, 			
			{ label: '坐标位置，如：F8、H13', name: 'positionCoordinate', index: 'position_coordinate', width: 80 }, 			
			{ label: '三维图形对象ID', name: 'objId', index: 'obj_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建人', name: 'createUserId', index: 'create_user_id', width: 80 }, 			
			{ label: '修改时间', name: 'modifyTime', index: 'modify_time', width: 80 }, 			
			{ label: '修改人', name: 'modifyUserId', index: 'modify_user_id', width: 80 }, 			
			{ label: '部门ID', name: 'deptId', index: 'dept_id', width: 80 }, 			
			{ label: '责任人', name: 'personResponsible', index: 'person_responsible', width: 80 }, 			
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
		resBaseInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resBaseInfo = {};
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
			var url = vm.resBaseInfo.resId == null ? " res/resbaseinfo/save" : " res/resbaseinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resBaseInfo),
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
			var resIds = getSelectedRows();
			if(resIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + " res/resbaseinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(resIds),
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
		getInfo: function(resId){
			$.get(baseURL + " res/resbaseinfo/info/"+resId, function(r){
                vm.resBaseInfo = r.resBaseInfo;
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