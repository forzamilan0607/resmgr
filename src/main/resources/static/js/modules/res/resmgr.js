$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'res/resmgr/list',
        datatype: "json",
        colModel: [
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '资源名称', name: 'name', index: 'name', width: 80 },
			{ label: '资源编码', name: 'code', index: 'code', width: 80 },
			{ label: '资源类别', name: 'resTypeId', index: 'res_type_id', width: 80 },
			{ label: '品牌', name: 'brand', index: 'brand', width: 80 },
			{ label: '系列', name: 'series', index: 'series', width: 80 },
			{ label: '型号', name: 'model', index: 'model', width: 80 },
			{ label: '出厂时间', name: 'factoryTime', index: 'factory_time', width: 80 },
			{ label: '整机序列号', name: 'serialNo', index: 'serial_no', width: 80 },
			{ label: '主要部件信息', name: 'componentInfo', index: 'component_info', width: 80 },
			{ label: '资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔', name: 'nameplate', index: 'nameplate', width: 80 },
			{ label: '位置ID，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面', name: 'locationId', index: 'location_id', width: 80 },
			{ label: '描述性位置', name: 'locationDesc', index: 'location_desc', width: 80 },
			{ label: '坐标位置，如：F8、H13', name: 'locationCoordinate', index: 'location_coordinate', width: 80 },
			{ label: '三维图形对象ID', name: 'objId', index: 'obj_id', width: 80 },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 },
			{ label: '创建人', name: 'createUserId', index: 'create_user_id', width: 80 },
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 },
			{ label: '修改人', name: 'updateUserId', index: 'update_user_id', width: 80 },
			{ label: '部门ID', name: 'deptId', index: 'dept_id', width: 80 },
			{ label: '资源描述', name: 'remark', index: 'remark', width: 80 },
			{ label: '责任人', name: 'personResponsible', index: 'person_responsible', width: 80 }
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

    $.datetimepicker.setLocale('zh');

    $('.myDatetimePicker').datetimepicker({
        i18n:{
            zh:{
                months:[
                    '一月','二月','三月','四月',
                    '五月','六月','七月','八月',
                    '九月','十月','十一月','十二月',
                ],
                dayOfWeek:[
                    "星期天", "星期一", "星期二", "星期三",
                    "星期四", "星期五", "星期六"
                ]
            }
        },
        timepicker:false,
        format:'Y-m-d'
    });
});
var vm = new Vue({
	el:'#resMgrApp',
	data:{
		showList: true,
		title: null,
        resBaseInfo: {
            attachmentList: [
				{
					name: "煤气探测器",
					url: "http://localhost:8080/resmgr/img/image2.png",
					type: "图片",
					size: "20 KB"
				},
				{
					name: "消防电话2",
					url: "http://localhost:8080/resmgr/img/video3.png",
					type: "视频",
					size: "20480 KB"
				},
				{
					name: "统计说明",
					url: "http://localhost:8080/resmgr/img/excel.png",
					type: "文档",
					size: "1024 KB"
				}
			]
		},
        resPurchase: {
            attachmentList: [
                {
                    name: "信息园资源设备合同",
                    url: "http://localhost:8080/resmgr/img/word.png",
                    type: "文档",
                    size: "2048 KB"
                }
			]
		},
        resMaintenance: {
            attachmentList1: [
                {
                    name: "维护保养合同123",
                    url: "http://localhost:8080/resmgr/img/word.png",
                    type: "文档",
                    size: "5778 KB"
                }
            ],
            attachmentList2: [
                {
                    name: "灭火器说明书",
                    url: "http://localhost:8080/resmgr/img/word.png",
                    type: "文档",
                    size: "8877 KB"
                }
            ],
			attachmentList3: [
                {
                    name: "维护保养注意事项",
                    url: "http://localhost:8080/resmgr/img/word.png",
                    type: "文档",
                    size: "4830 KB"
                }
            ]
		},
        resInstallConfig: {
            attachmentList1: [
                {
                    name: "图纸1",
                    url: "http://localhost:8080/resmgr/img/image3.png",
                    type: "图片",
                    size: "4830 KB"
                }
			],
            attachmentList2: [
                {
                    name: "烟感系统操作说明书",
                    url: "http://localhost:8080/resmgr/img/image3.png",
                    type: "图片",
                    size: "4830 KB"
                }
			]
		}
	},
	created: function () {
        $locationTree.init("locationTree");
    },
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.resmgr = {};
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
			var url = vm.resmgr.id == null ? "res/resmgr/save" : "res/resmgr/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resmgr),
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
				    url: baseURL + "res/resmgr/delete",
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
			$.get(baseURL + "res/resmgr/info/"+id, function(r){
                vm.resmgr = r.resmgr;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        showLocationLayer: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择具体位置",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#div_locationLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    var nodes = $locationTree.getSelectedNodes();
                    alert(JSON.stringify(nodes));
                    // vm.sysDict.parentDictId = nodes[0].dictId;
                    // vm.sysDict.parentDictName = nodes[0].dictName;
                    layer.close(index);
                }
            });
        }
	}
});