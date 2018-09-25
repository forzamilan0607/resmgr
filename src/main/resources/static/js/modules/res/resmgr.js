$(document).ready(function () {
    $util.upload({
        selector: "#uploadResNameplate",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|pdf)$/,
        msg: "资源铭牌仅支持图片、office文档、pdf文件、mp4、avi视频格式文件上传！",
        callback: function (r) {
            vm.resBaseInfo.resNameplateAttachments.push(r.attachmentObj);
            if (vm.resBaseInfo.resNameplateAttachments.length) {
                $myValidator.resetBySelector("#table_resNameplate");
            }
        }
    });

    $util.upload({
        selector: "#uploadConcractAttach",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|pdf)$/,
        msg: "合同附件仅支持图片、office文档、pdf文件上传！",
        callback: function (r) {
            vm.resPurchase.contractAttachments.push(r.attachmentObj);
            if (vm.resPurchase.contractAttachments.length) {
                $myValidator.resetBySelector2("#table_contractAttach");
            }
        }
    });
    $util.upload({
        selector: "#uploadMaintainContract",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|pdf)$/,
        msg: "维保合同仅支持图片、office文档、pdf文件上传！",
        callback: function (r) {
            vm.resMaintenance.maintainContractAttachments.push(r.attachmentObj);
            /*if (vm.resMaintenance.maintainContractAttachments.length) {
                $myValidator.resetBySelector2("#table_contractAttach");
            }*/
        }
    });

    $util.upload({
        selector: "#uploadInstructions",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|mp4|avi|pdf)$/,
        msg: "资源设备说明书仅支持图片、office文档、pdf文件、mp4、avi视频格式文件上传！",
        callback: function (r) {
            vm.resMaintenance.resInstructionsAttachments.push(r.attachmentObj);
        }
    });

    $util.upload({
        selector: "#uploadPrecautions",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|mp4|avi|pdf)$/,
        msg: "注意事项仅支持图片、office文档、pdf文件、mp4、avi视频格式文件上传！",
        callback: function (r) {
            vm.resMaintenance.precautionsAttachments.push(r.attachmentObj);
        }
    });

    $util.upload({
        selector: "#uploadDrawing",
        suffixReg: /^(jpg|jpeg|png|gif)$/,
        msg: "图纸仅支持图片上传！",
        callback: function (r) {
            vm.resInstallConfig.drawingAttachments.push(r.attachmentObj);
        }
    });

    $util.upload({
        selector: "#uploadOperationSpecification",
        suffixReg: /^(jpg|jpeg|png|gif|doc|docx|xls|xlsx|csv|mp4|avi|pdf)$/,
        msg: "操作规范说明仅支持图片、office文档、pdf文件、mp4、avi视频格式文件上传！",
        callback: function (r) {
            vm.resInstallConfig.operSpecAttachments.push(r.attachmentObj);
        }
    });

    $.ajax({
        type: "POST",
        async: false,
        url: baseURL + 'sys/sysdatadict/listAll',
        contentType: "application/json",
        success: function(r){
            if(r.code === $util.HTTP_STATUS.SC_OK){
                vm.dataDictList = r.dataDictList;
            }else{
                alert(r.msg);
            }
        }
    });

    $("#jqGrid").jqGrid({
        url: baseURL + 'res/resmgr/list',
        datatype: "json",
        colModel: [
			// { label: '序号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '资源名称', name: 'name', index: 'name', width: 100 },
			// { label: '资源编码', name: 'code', index: 'code', width: 80 },
			{ label: '资源类别', name: 'resTypeId', index: 'res_type_id', width: 80, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '设备名称', name: 'equipId', index: 'model', width: 80, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '品牌', name: 'brand', index: 'brand', width: 80, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '系列', name: 'series', index: 'series', width: 80, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '出厂时间', name: 'factoryTime', index: 'factory_time', width: 80 },
			{ label: '整机序列号', name: 'serialNo', index: 'serial_no', width: 80 },
			//{ label: '资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔', name: 'nameplate', index: 'nameplate', width: 80 },
			//{ label: '所属位置', name: 'locationId', index: 'location_id', width: 80 },
			{ label: '描述性位置', name: 'locationDesc', index: 'location_desc', width: 130 },
			//{ label: '坐标位置，如：F8、H13', name: 'locationCoordinate', index: 'location_coordinate', width: 80 },
			//{ label: '三维图形对象ID', name: 'objId', index: 'obj_id', width: 80 },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 },
			{ label: '创建人', name: 'createUserName', index: 'create_user_id', width: 60 },
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 },
			{ label: '修改人', name: 'updateUserName', index: 'update_user_id', width: 60 },
			{ label: '部门', name: 'deptName', index: 'dept_id', width: 80 },
			//{ label: '资源描述', name: 'remark', index: 'remark', width: 80 },
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

    $(".myDatetimePicker").datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,//显示‘今日’按钮
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,  //Number, String. 默认值：0, 'hour'，日期时间选择器所能够提供的最精确的时间选择视图。
        clearBtn:true,//清除按钮
        forceParse: 0
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
            factoryTime: null,
            locationId: null,
            locationName: null,
            resNameplateAttachments: [],
            resComponentList: [],
            resEquipParamList: []
		},
        resPurchase: {
            contractAttachments: []
		},
        resMaintenance: {
            maintainCompany: null,
            maintainCompanyName: null,
            maintainContractAttachments: [],
            resInstructionsAttachments: [],
            precautionsAttachments: []
		},
        resInstallConfig: {
            drawingAttachments: [],
            operSpecAttachments: []
		},
		validator: {

		},
        dataDictList: null,
        locationTree: null,
        companyTree: null,
        deptTree: null,
        empTree: null,
        maintainDeptTree: null
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
            return this.getDataDictListByParentId(this.resBaseInfo.brand, "SERIES");
        },
        resName: function () {
          return $.grep(this.brandList, function (item, i) {
              return item.id == vm.resBaseInfo.brand;
          })[0].name + "/" + $.grep(this.seriesList, function (item, i) {
              return item.id == vm.resBaseInfo.series;
          })[0].name
        },
        maintainDeptData: function () {
               /*if (this.deptTree && this.deptTree.getData()) {
                   consoel.log(new Date());
                   var data = this.deptTree.getData();
                   this.maintainDeptTree = new TreeSelector({
                       id: "id",
                       parentId: "parentDeptId",
                       name: "name",
                       treeId: "maintainDeptTree",
                       data: data,
                       callback: function (event, treeId, treeNode) {
                           vm.resBaseInfo.deptId = treeNode.id;
                           vm.resBaseInfo.deptName = treeNode.name;
                           layer.close(layer.index);
                       }
                   });
               }*/

        }
    },
	created: function () {
        this.$token = token;
        this.locationTree = new TreeSelector({
            id: "id",
            parentId: "parentLocationId",
            name: "name",
            treeId: "locationTree",
            url: "/resmgr/res/location/queryLocationListByCondition",
            param: {},
            onDblClick: function (event, treeId, treeNode) {
                vm.selectLocation(treeNode);
            }
        });
        this.deptTree = new TreeSelector({
            id: "id",
            parentId: "parentDeptId",
            name: "name",
            treeId: "deptTree",
            url: "/resmgr/sys/sysdepartment/listAll",
            param: {
                parkId: 1
            },
            onDblClick: function (event, treeId, treeNode) {
                vm.resBaseInfo.deptId = treeNode.id;
                vm.resBaseInfo.deptName = treeNode.name;
                layer.close(layer.index);
            },
            callback: function (data) {
                vm.maintainDeptTree = new TreeSelector({
                    id: "id",
                    parentId: "parentDeptId",
                    name: "name",
                    treeId: "maintainDeptTree",
                    data: data,
                   /* param: {
                        parkId: 1
                    },*/
                    onDblClick: function (event, treeId, treeNode) {
                        vm.resMaintenance.maintainDeptId = treeNode.id;
                        vm.resMaintenance.maintainDeptName = treeNode.name;
                        layer.close(layer.index);
                    }
                })
            }
        });
        this.companyTree = new TreeSelector({
            id: "id",
            parentId: "parentCompanyId",
            name: "name",
            treeId: "companyTree",
            url: "/resmgr/sys/syscompany/listAll",
            param: {
                parkId: 1
            },
            onDblClick: function (event, treeId, treeNode) {
                vm.resMaintenance.maintainCompany = treeNode.id;
                vm.resMaintenance.maintainCompanyName = treeNode.name;
                layer.close(layer.index);
            }
        });
    },
	methods: {
        handleDecimal: function (e) {
            // 通过正则过滤小数点后两位
            e.target.value = (e.target.value.match(/^\d*(\.?\d{0,1})/g)[0]) || null
        },

	    getDataDictListByParentId: function (parentId, type) {
            return parentId ? $.grep(this.dataDictList, function (item, i) {
                return type ? item.type == type && item.parentId == parentId : item.parentId == parentId;
            }) : [];
        },
        getDataDictNameById: function (id, type) {
            var dataDictList = $.grep(this.dataDictList, function (item, i) {
                return type ? item.type == type && item.id == id : item.id == id;
            }) || [];
            return dataDictList.length ? dataDictList[0].name : id;
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
		saveOrUpdate: function (event) {
			var url = vm.resmgr.id == null ? "res/resmgr/save" : "res/resmgr/update";
			if (!$myValidator.validateResInfo() || !$myValidator.validatePurchase()) {
			    return;
            }
            vm.resBaseInfo.name = vm.resName();
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify({
                    resBaseInfo: vm.resBaseInfo,
                    resPurchase: vm.resPurchase,
                    resMaintenance: vm.resMaintenance,
                    resInstallConfig: vm.resInstallConfig
                }),
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
                if(r.code === $util.HTTP_STATUS.SC_OK){
                    vm.resBaseInfo = r.resInfoDTO.resBaseInfo;
                    vm.resPurchase = r.resInfoDTO.resPurchase;
                    vm.resMaintenance = r.resInfoDTO.resMaintenance;
                    vm.resInstallConfig = r.resInfoDTO.resInstallConfig;
                    vm.setLocationValue();
                }else{
                    alert(r.msg);
                }
            });
		},
        setLocationValue: function () {
            this.resBaseInfo.locationName = $.grep(this.locationTree.getData() || [], function (item, i) {
                return item.id == vm.resBaseInfo.locationId;
            })[0].name;
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
                    vm.selectLocation(vm.locationTree.getSelectedNodes()[0]);
                }
            });
        },
        addResComponent: function () {
            if (this.resBaseInfo.resComponentList.length) {
                var component = this.resBaseInfo.resComponentList[this.resBaseInfo.resComponentList.length - 1];
                if (!component.name || !$.trim(component.name)) {
                    alert("请输入部件名称");
                    return;
                }
                if (!component.serialNo || !$.trim(component.serialNo)) {
                    alert("请输入序列号");
                    return;
                }
            }
            this.resBaseInfo.resComponentList.push({});
            $myValidator.resetBySelector("#table_resComponent");
        },
        deleteResComponent: function (component, index) {
            if (!component.id && !component.name && !component.serialNo) {
                vm.resBaseInfo.resComponentList.splice(index, 1);
                return;
            }
            confirm('确定要删除部件信息？', function(){
                vm.resBaseInfo.resComponentList.splice(index, 1);
            });
        },
        showComponentLayer: function(){
            alert("showComponentLayer");
        },
        addResEquipParam: function (param) {
            if (this.resBaseInfo.resEquipParamList.length) {
                var equipParam = this.resBaseInfo.resEquipParamList[this.resBaseInfo.resEquipParamList.length - 1];
                if (!equipParam.name || !$.trim(equipParam.name)) {
                    alert("请输入参数名称");
                    return;
                }
                if (!equipParam.value || !$.trim(equipParam.value)) {
                    alert("请输入参数值");
                    return;
                }
            }
            this.resBaseInfo.resEquipParamList.push({});
            //$myValidator.resetBySelector("#table_resComponent");
        },
        deleteResEquipParam: function (equipParam, index) {
            if (!equipParam.id && !equipParam.name && !equipParam.value) {
                vm.resBaseInfo.resEquipParamList.splice(index, 1);
                return;
            }
            confirm('确定要删除参数信息？', function(){
                vm.resBaseInfo.resEquipParamList.splice(index, 1);
            });
        },
        showParamLayer: function(){
            alert("showComponentLayer");
        },
        selectLocation: function (treeNode) {
            if (treeNode.hasChildren == 0) {
                vm.resBaseInfo.locationId = treeNode.id;
                vm.resBaseInfo.locationName = treeNode.name;
                //描述性位置值
                vm.resBaseInfo.locationDesc = vm.locationTree.getHierarchyName({
                    id: treeNode.id,
                    key: "parentLocationId",
                    name: "name"
                });
                layer.close(layer.index);
            } else {
                alert("不能选择目录!");
            }
        },
        showDeptLayer: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择部门",
                area: ['300px', '300px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#div_deptLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    var nodes = vm.deptTree.getSelectedNodes();
                    vm.resBaseInfo.deptId = nodes[0].id;
                    vm.resBaseInfo.deptName = nodes[0].name;
                    layer.close(index);
                }
            });
        },
        showMaintainCompany: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择维保公司",
                area: ['300px', '300px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#div_companyLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    var nodes = vm.deptTree.getSelectedNodes();
                    vm.resMaintenance.maintainCompany = nodes[0].id;
                    vm.resMaintenance.maintainCompanyName = nodes[0].name;
                    layer.close(index);
                }
            });
        },
        showMaintainDept: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择维保部门",
                area: ['300px', '300px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#div_maintainDeptLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    var nodes = vm.deptTree.getSelectedNodes();
                    vm.resMaintenance.maintainDeptId = nodes[0].id;
                    vm.resMaintenance.maintainDeptName = nodes[0].name;
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
                        if(r.code == $util.HTTP_STATUS.SC_OK){
                            vm.deleteAttachFromList(vm.resBaseInfo.resNameplateAttachments, attachId) || vm.deleteAttachFromList(vm.resPurchase.contractAttachments, attachId) ||
                            vm.deleteAttachFromList(vm.resMaintenance.maintainContractAttachments, attachId) || vm.deleteAttachFromList(vm.resMaintenance.resInstructionsAttachments, attachId) ||
                            vm.deleteAttachFromList(vm.resMaintenance.resInstructionsAttachments, attachId)  || vm.deleteAttachFromList(vm.resInstallConfig.drawingAttachments, attachId) ||
                            vm.deleteAttachFromList(vm.resInstallConfig.operSpecAttachments, attachId);
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
                    notEqualsTo: {
                        value: null,
                        msg: "请选择资源类别"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "select[id='resBaseInfo.equipId']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: null,
                        msg: "请选择设备"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "select[id='resBaseInfo.brand']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: null,
                        msg: "请选择品牌"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "select[id='resBaseInfo.series']",
                changes: ["notEqualsTo"],
                validateMethod: {
                    notEqualsTo: {
                        value: null,
                        msg: "请选择系列"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "textarea[id='resBaseInfo.remark']",
                validateMethod: {
                    maxLength: {
                        value: 512,
                        msg: $myMsg.maxLength("资源描述", 512)
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "input[id='resBaseInfo.factoryTime']",
                blurs: ["required"],
                validateMethod: {
                    required: {
                        msg: "请输入出厂时间"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "input[id='resBaseInfo.serialNo']",
                blurs: ["required"],
                validateMethod: {
                    required: {
                        msg: "请输入整机序列号"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "#table_resNameplate",
                blurs: ["minLength"],
                validateMethod: {
                    minLength: {
                        childSelector: "#tbody_resNameplate tr",
                        value: 1,
                        msg: "请至少上传一个资源铭牌"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "#table_resComponent",
                validateMethod: {
                    minLength: {
                        childSelector: "#tbody_resComponent tr",
                        value: 1,
                        msg: "请添加部件信息"
                    }
                },
                tabId: "link_resBaseInfo"
            }
        ]
    });
    var _validate4Purchase = $validator.build({
        allPassRequired: true,
        items:[
            {
                selector: "input[id='resPurchase.contractNo']",
                changes: ["required"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入合同编号"
                    }
                },
                tabId: "link_resPurchase"
            },
            {
                selector: "input[id='resPurchase.price']",
                changes: ["required"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入采购价格"
                    }
                },
                tabId: "link_resPurchase"
            },
            {
                selector: "#table_contractAttach",
                validateMethod: {
                    minLength: {
                        childSelector: "#tbody_contractAttach tr",
                        value: 1,
                        msg: "请至少上传一个合同附件"
                    }
                },
                tabId: "link_resPurchase"
            }
        ]
    });
	return {
	    validateResInfo: function () {
            return _validate4ResInfo.validate();
        },
        validatePurchase: function () {
            return _validate4Purchase.validate();
        },
        resetBySelector: function (selector) {
            return _validate4ResInfo.resetBySelector(selector);
        },
        resetBySelector2: function (selector) {
            return _validate4Purchase.resetBySelector(selector);
        }
    }
}();
var count = 0;