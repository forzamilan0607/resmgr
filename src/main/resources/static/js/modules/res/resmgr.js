$(document).ready(function () {
    $util.upload({
        selector: "#uploadResNameplate",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|mp4|avi|pdf)$/,
        msg: "仅支持图片、office文档、pdf文件、mp4、avi格式文件上传！",
        attachmentList: vm.resBaseInfo.attachmentList
    });

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
        $token: null,
        resBaseInfo: {
            resTypeId: null,
            equipId: null,
            brand: null,
            deptId: 100001,
            deptName: "综合部",
            attachmentList: [
				{
				    id: 1,
					name: "煤气探测器",
					tempUrl: "/resmgr/img/image2.png",
                    url: "hangzhou.aliyuncs.com/20180916/100d2eaa90d84656aa3d28aa0b6c847f.jpg",
					type: "图片",
					size: "20 KB"
				},
				{
				    id: 7,
					name: "消防电话2",
					tempUrl: "/resmgr/img/video3.png",
                    url: "https://resmgr.oss-cn-hangzhou.aliyuncs.com/20180916/a1b30e8156db4cc1977bc8b48428818b.mp4",
					type: "视频",
					size: "20480 KB"
				},
				{
				    id: 3,
					name: "统计说明",
					tempUrl: "/resmgr/img/excel.png",
                    url: "https://resmgr.oss-cn-hangzhou.aliyuncs.com/20180916/8913dae430bb435b923f8cc030f77142.doc",
					type: "文档",
					size: "1024 KB"
				}
			]
		},
        resPurchase: {
            attachmentList: [
                {
                    name: "信息园资源设备合同",
                    tempUrl: "/resmgr/img/word.png",
                    type: "文档",
                    size: "2048 KB"
                }
			]
		},
        resMaintenance: {
            attachmentList1: [
                {
                    name: "维护保养合同123",
                    tempUrl: "/resmgr/img/word.png",
                    type: "文档",
                    size: "5778 KB"
                }
            ],
            attachmentList2: [
                {
                    name: "灭火器说明书",
                    tempUrl: "/resmgr/img/word.png",
                    type: "文档",
                    size: "8877 KB"
                }
            ],
			attachmentList3: [
                {
                    name: "维护保养注意事项",
                    tempUrl: "/resmgr/img/word.png",
                    type: "文档",
                    size: "4830 KB"
                }
            ]
		},
        resInstallConfig: {
            attachmentList1: [
                {
                    name: "图纸1",
                    tempUrl: "/resmgr/img/image3.png",
                    type: "图片",
                    size: "4830 KB"
                }
			],
            attachmentList2: [
                {
                    name: "烟感系统操作说明书",
                    tempUrl: "/resmgr/img/image3.png",
                    type: "图片",
                    size: "4830 KB"
                }
			]
		},
		validator: {

		},
        dataDictList: null
	},
    computed: {
        // 计算属性的 getter
        resTypeList: function () {
            if (this.dataDictList && this.dataDictList.length) {
                return $.grep(this.dataDictList, function (item, i) {
                    return item.type == 'RES_TYPE'
                });
            }
            return [];
        },
        equipList: function () {
            return this.getDataDictListByParentId(this.resBaseInfo.resTypeId, "SUB_SYSTEM");
        },
        brandList: function () {
            var id = this.resBaseInfo.equipId;
            return id ? $.grep(this.dataDictList, function (item, i) {
                return item.type == 'BRAND' && (item.parentIdsText && $.inArray(id + "", item.parentIdsText.split(",")) >= 0);
            }) : [];
        },
        seriesList: function () {
            return this.getDataDictListByParentId(this.resBaseInfo.brand);
        }
    },
	created: function () {
        $locationTree.init("locationTree");
        this.$token = token;
        this.initQueryDataDictList();
    },
	methods: {
	    getDataDictListByParentId: function (parentId, type) {
            return parentId ? $.grep(this.dataDictList, function (item, i) {
                return type ? item.type == type && item.parentId == parentId : item.parentId == parentId;
            }) : [];
        },
        initQueryDataDictList: function () {
            $.ajax({
                type: "POST",
                url: baseURL + 'sys/sysdatadict/listAll',
                contentType: "application/json",
                success: function(r){
                    if(r.code === $util.HTTP_STATUS.SC_OK){
                        vm.dataDictList = r.dataDictList;
                        alert("resTypeList.length = " + vm.resTypeList.length + ", equipList.length = " + vm.equipList.length);
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
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
		saveResInfo: function () {
        },
		saveOrUpdate: function (event) {
			var url = vm.resmgr.id == null ? "res/resmgr/save" : "res/resmgr/update";
			if (!$myValidator.validateResInfo()) {
			    return;
            }
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.resmgr),
			    success: function(r){
			    	if(r.code === $util.HTTP_STATUS.SC_OK){
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
        },
        /**
         * 附件预览
         */
        preview: function (attach) {
            alert(JSON.stringify(attach))
        },
        deleteAttach: function (attach) {
            var attachId = attach.id;
            confirm('确定要删除此文件吗？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/oss/delete?id=" + attachId,
                    contentType: "application/json",
                    success: function(r){
                        if(r.code == 0){
                            vm.deleteAttachFromList(vm.resBaseInfo.attachmentList, attachId) || vm.deleteAttachFromList(vm.resPurchase.attachmentList, attachId) ||
                            vm.deleteAttachFromList(vm.resMaintenance.attachmentList1, attachId) || vm.deleteAttachFromList(vm.resMaintenance.attachmentList2, attachId) ||
                            vm.deleteAttachFromList(vm.resMaintenance.attachmentList3, attachId)  || vm.deleteAttachFromList(vm.resInstallConfig.attachmentList1, attachId) ||
                            vm.deleteAttachFromList(vm.resInstallConfig.attachmentList2, attachId);
                            alert('删除成功');
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        deleteAttachFromList: function (attachmentList, attachId) {
            for (var i = 0; i < attachmentList.length; i++) {
                if (attachmentList[i].id == attachId) {
                    attachmentList.splice(i, 1);
                    return true;
                }
            }
            return false;
        }
	}
});
var $myValidator = function () {
	var _validate4ResInfo = $validator.build({
        allPassRequired: true,
        items:[
            {
                selector: "select[id='resBaseInfo.resTypeId']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请选择资源类别"
                    }
                }
            },
            {
                selector: "select[id='resBaseInfo.equipId']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: null,
                        msg: "请选择设备"
                    }
                }
            },
            {
                selector: "select[id='resBaseInfo.brand']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: null,
                        msg: "请选择品牌"
                    }
                }
            },
            {
                selector: "select[id='resBaseInfo.series']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: null,
                        msg: "请选择系列"
                    }
                }
            },
            /*{
                selector: "resBaseInfo.resTypeName",
                changes: ["notEqualsTo"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请选择状态"
                    }
                }
            },
            {
                selector: "table_dictItems",
                validateMethod: {
                    minLength: {
                        childSelector: "#tbody_dictItems tr",
                        value: 1,
                        msg: "请至少添加一个字典项值"
                    }
                }
            },*/
            {
                selector: "textarea[id='resBaseInfo.remark']",
                validateMethod: {
                    maxLength: {
                        value: 512,
                        msg: $myMsg.maxLength("资源描述", 512)
                    }
                }
            },
            {
                selector: "input[id='resBaseInfo.factoryTime']",
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入出厂时间"
                    }
                }
            },
            {
                selector: "input[id='resBaseInfo.serialNo']",
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入整机序列号"
                    }
                }
            },
            {
                selector: "table_resNameplate",
                validateMethod: {
                    minLength: {
                        childSelector: "#tbody_resNameplate tr",
                        value: 1,
                        msg: "请至少上传一个资源铭牌"
                    }
                }
            }
        ]
    });
	return {
	    validateResInfo: function () {
            return _validate4ResInfo.validate();
        },
        resetBySelector: function (selector) {
            return _validate4ResInfo.resetBySelector(selector);
        }
    }
}();
var count = 0;