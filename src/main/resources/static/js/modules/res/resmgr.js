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
			{ label: '资源名称', name: 'name', index: 'name', width: 180 },
			{ label: '资源类别', name: 'resTypeId', index: 'res_type_id', width: 120, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '设备名称', name: 'equipId', index: 'model', width: 120, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '品牌', name: 'brand', index: 'brand', width: 100, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '系列', name: 'series', index: 'series', width: 100, formatter: function (value, options, row) {
                return value ? vm.getDataDictNameById(value) : "";
            }},
			{ label: '出厂时间', name: 'factoryTime', index: 'factory_time', width: 80 },
			{ label: '描述性位置', name: 'locationDesc', index: 'location_desc', width: 230 },
			{ label: '部门', name: 'deptName', index: 'dept_id', width: 80 },
			{ label: '责任人', name: 'responsibleName', index: 'person_responsible', width: 60 }
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

    $(".myDatetimePicker").prop("readonly", true).datetimepicker({
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

    $("button.btn-datetime").bind("click", function () {
       $(this).parent("span").prev(".myDatetimePicker").trigger("focus");
    });

    $("input[id='resMaintenance.warrantyStartDate'],input[id='resMaintenance.warrantyEndDate']").bind("change", function() {vm.calcMaintainPeriod();});
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
            deptId: null,
            deptName: null,
            personResponsible: null,
            responsibleName: null,
            factoryTime: null,
            locationId: null,
            locationName: null,
            resNameplateAttachments: [],
            resComponentList: [],
            resEquipParamList: []
		},
        resPurchase: {
            contractCompanyId: null,
            contractCompanyName: null,
            contractAttachments: []
		},
        resMaintenance: {
            maintainCompany: null,
            maintainCompanyName: null,
            maintainDeptId: null,
            maintainDeptName: null,
            personResponsible: null,
            responsibleName: null,
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
        showLocationValue: null,
        showDeptValue: null,
        showCompanyValue: null,
        dataDictList: null,
        locationTree: null,
        companyTree: null,
        responsibleTree: null,
        deptTree: null,
        empTree: null,
        maintainDeptTree: null,
        queryParam: {
		    locationId: null,
		    locationName: null,
		    name: null,
		    resTypeId: null,
            maintainCompany: null,
		    deptId: null,
            personResponsible: null,
            responsibleName: null
        }
	},
    /*components: {
        vuejsDatepicker
    },*/
    computed: {
        // 计算属性的 getter
        resTypeList: function () {
            var data = [{
                id: null,
                name: "请选择资源类别"
            }];
            if (this.dataDictList && this.dataDictList.length) {
                // this.resBaseInfo.brand = null;
                // this.resBaseInfo.series = null;
                return data.concat($.grep(this.dataDictList, function (item, i) {
                    return item.type == 'RES_TYPE'
                }));
            }
            return data;
        },
        equipList: function () {
            var data = this.getDataDictListByParentId(this.resBaseInfo.resTypeId, "SUB_SYSTEM");
            return data;
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
        }
    },
	created: function () {
        this.$token = token;
        this.initTrees();
    },
	methods: {
	    initTrees: function () {
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
                    vm.selectDept(treeNode);
                }
            });
            this.responsibleTree = new TreeSelector({
                id: "id",
                parentId: "parentDeptId",
                name: "name",
                treeId: "responsibleTree",
                url: "/resmgr/sys/sysstaff/getStaffTree",
                param: {
                    parkId: 1
                },
                onDblClick: function (event, treeId, treeNode) {
                    vm.selectResponsible(treeNode);
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
                    vm.selectCompany(treeNode);
                }
            });
        },
        handleDecimal: function (e) {
            // 通过正则过滤小数点后两位
            e.target.value = (e.target.value.match(/^\d*(\.?\d{0,1})/g)[0]) || null
        },
        resetQryCondition: function () {
            clearObjValue(this.queryParam);
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
			clearObjValue(vm.resBaseInfo);
			clearObjValue(vm.resPurchase);
			clearObjValue(vm.resMaintenance);
			clearObjValue(vm.resInstallConfig);
            $("input[id='resBaseInfo.factoryTime']").val("");
            $("input[id='resMaintenance.warrantyStartDate']").val("");
            $("input[id='resMaintenance.warrantyEndDate']").val("");
            $("#link_resBaseInfo").trigger("click");
            setTimeout(function () {
                $myValidator.resetAll();
            }, 300);
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id);
            $myValidator.resetAll();
            $("#link_resBaseInfo").trigger("click");
		},
        calcMaintainPeriod: function () {
	        var startDate = $("input[id='resMaintenance.warrantyStartDate']").val();
	        var endDate = $("input[id='resMaintenance.warrantyEndDate']").val();
            if (startDate && endDate) {
                var startTime = new Date(startDate.replace(/-/g,"/")).getTime();
                var endTime = new Date(endDate.replace(/-/g,"/")).getTime();
                var days = Math.abs((endTime - startTime)) / (1000 * 60 * 60 * 24);
                $("input[id='resMaintenance.maintainPeriod']").val(days);
                vm.resMaintenance.maintainPeriod = days;
            }
        },
		saveOrUpdate: function (event) {
			var url = vm.resBaseInfo.id == null ? "res/resmgr/save" : "res/resmgr/update";
			if (!$myValidator.validateResInfo() || !$myValidator.validatePurchase() || !$myValidator.validateMaintenance()) {
			    return;
            }
            if (!vm.checkResComponent()  || !vm.checkResEquipParam()) {
			    return;
            }
            var repeatedKeyIndex = vm.getRepeatedKeyIndex("name", vm.resBaseInfo.resComponentList);
            if (repeatedKeyIndex > 0) {
                $("#link_resBaseInfo").click();
                $("html,body").animate({scrollTop: $("#table_resComponent").offset().top}, 500);
                alert("部件列表中存在相同的部件名称", function () {
                    $("input[name='component.name']")[repeatedKeyIndex].select();
                });
			    return;
            }
            repeatedKeyIndex = vm.getRepeatedKeyIndex("name", vm.resBaseInfo.resEquipParamList);
            if (repeatedKeyIndex > 0) {
                $("#link_resInstallConfig").click();
                $("html,body").animate({scrollTop: $("#table_resEquipParam").offset().top}, 500);
                alert("参数列表中存在相同的参数名称", function () {
                    $("input[name='param.name']")[repeatedKeyIndex].select();
                });
                return;
            }
            vm.resBaseInfo.name = vm.resName;
			vm.resMaintenance.warrantyStartDate = $("input[id='resMaintenance.warrantyStartDate']").val();
			vm.resMaintenance.warrantyEndDate = $("input[id='resMaintenance.warrantyEndDate']").val();
            vm.resBaseInfo.factoryTime = $("input[id='resBaseInfo.factoryTime']").val();
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
		getInfo: function(id){
			$.get(baseURL + "res/resmgr/info/"+id, function(r){
                if(r.code === $util.HTTP_STATUS.SC_OK){
                    vm.resBaseInfo = r.resInfoDTO.resBaseInfo;
                    if (r.resInfoDTO.resPurchase) {
                        vm.resPurchase = r.resInfoDTO.resPurchase;
                    }
                    if (r.resInfoDTO.resMaintenance) {
                        vm.resMaintenance = r.resInfoDTO.resMaintenance;
                    }
                    if (r.resInfoDTO.resInstallConfig) {
                        vm.resInstallConfig = r.resInfoDTO.resInstallConfig;
                    }
                    vm.setLocationValue();
                    $("input[id='resBaseInfo.factoryTime']").val(vm.resBaseInfo.factoryTime);
                    $("input[id='resMaintenance.warrantyStartDate']").val(vm.resMaintenance.warrantyStartDate);
                    $("input[id='resMaintenance.warrantyEndDate']").val(vm.resMaintenance.warrantyEndDate);
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
                datatype: 'json',
                postData: vm.queryParam,
                page:page
            }).trigger("reloadGrid");
		},
        showLocationLayer: function(v){
            vm.showLocationValue = v;
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
            if (vm.resBaseInfo.resComponentList.length) {
                if (!vm.checkResComponent()) {
                    return;
                }
            }
            vm.resBaseInfo.resComponentList.push({});
            $myValidator.resetBySelector("#table_resComponent");
        },
        checkResComponent: function () {
	        var index = vm.resBaseInfo.resComponentList.length - 1;
            var component = vm.resBaseInfo.resComponentList[index];
            if (!component.name || !$.trim(component.name)) {
                vm.showResComponentErrorMsg("请输入部件名称", index, 1);
                return false;
            }
            if (!component.serialNo || !$.trim(component.serialNo)) {
                vm.showResComponentErrorMsg("请输入序列号", index, 2);
                return false;
            }
            return true;
        },
        showResComponentErrorMsg: function (errMsg, index, type) {
            $("#link_resBaseInfo").click();
            $("html,body").animate({scrollTop: $("#table_resComponent").offset().top}, 500);
            alert(errMsg, function () {
                $(type == 1 ? "input[name='component.name']" : "input[name='component.serialNo']")[index].focus();
            });
        },
        showResEquipParamErrorMsg: function (errMsg, index, type) {
            $("#link_resInstallConfig").click();
            $("html,body").animate({scrollTop: $("#table_resEquipParam").offset().top}, 500);
            alert(errMsg, function () {
                $(type == 1 ? "input[name='param.name']" : "input[name='param.value']")[index].focus();
            });
        },
        getRepeatedKeyIndex: function (key, data) {
            var firstValue = data[0][key];
            for (var i = 1; i < data.length; i++) {
               if (firstValue == data[i][key]) {
                   return i;
               }
            }
            return 0;
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
                if (!this.checkResEquipParam()) {
                    return;
                }
            }
            this.resBaseInfo.resEquipParamList.push({});
            //$myValidator.resetBySelector("#table_resComponent");
        },
        checkResEquipParam: function () {
	        var index = vm.resBaseInfo.resEquipParamList.length - 1;
            var equipParam = vm.resBaseInfo.resEquipParamList[index];
            if (!equipParam.name || !$.trim(equipParam.name)) {
                vm.showResEquipParamErrorMsg("请输入参数名称", index, 1);
                return false;
            }
            if (!equipParam.value || !$.trim(equipParam.value)) {
                vm.showResEquipParamErrorMsg("请输入参数值", index, 1);
                return false;
            }
            return true;
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
                if (vm.showLocationValue == 1) {
                    vm.queryParam.locationId = treeNode.id;
                    vm.queryParam.locationName = treeNode.name;
                } else {
                    vm.resBaseInfo.locationId = treeNode.id;
                    vm.resBaseInfo.locationName = treeNode.name;
                    //描述性位置值
                    vm.resBaseInfo.locationDesc = vm.locationTree.getHierarchyName({
                        id: treeNode.id,
                        key: "parentLocationId",
                        name: "name"
                    });
                }
                layer.close(layer.index);
            } else {
                alert("不能选择目录!");
            }
        },
        showDeptLayer: function(v){
            vm.showDeptValue = v;
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
                    vm.selectDept(vm.deptTree.getSelectedNodes()[0], index);
                }
            });
        },
        selectCompany: function (treeNode, index) {
            if (vm.showCompanyValue == 1) {
                vm.queryParam.maintainCompany = treeNode.id;
                vm.queryParam.maintainCompanyName = treeNode.name;
            } else if (vm.showCompanyValue == 2) {
                vm.resMaintenance.maintainCompany = treeNode.id;
                vm.resMaintenance.maintainCompanyName = treeNode.name;
            } else {
                vm.resPurchase.contractCompanyId = treeNode.id;
                vm.resPurchase.contractCompanyName = treeNode.name;
            }
            layer.close(index || layer.index);
        },
        selectDept: function (treeNode, index) {
            if (vm.showDeptValue == 1) {
                vm.queryParam.deptId = treeNode.id;
                vm.queryParam.deptName = treeNode.name;
            } else if (vm.showDeptValue == 2) {
                vm.resBaseInfo.deptId = treeNode.id;
                vm.resBaseInfo.deptName = treeNode.name;
            } else {
                vm.resMaintenance.maintainDeptId = treeNode.id;
                vm.resMaintenance.maintainDeptName = treeNode.name;
            }
            layer.close(index || layer.index);
        },
        showResponsibleLayer: function(v){
            vm.showResponsibleValue = v;
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择责任人",
                area: ['300px', '300px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#div_responsibleLayer"),
                btn: ['保存', '取消'],
                btn1: function (index) {
                    var nodes = vm.responsibleTree.getSelectedNodes();
                    vm.selectResponsible(nodes[0], index)
                }
            });
        },
        selectResponsible: function (treeNode, index) {
            if (vm.showResponsibleValue == 1) {
                vm.queryParam.personResponsible = treeNode.id;
                vm.queryParam.responsibleName = treeNode.name;
            } else if (vm.showResponsibleValue == 2) {
                vm.resBaseInfo.personResponsible = treeNode.id;
                vm.resBaseInfo.responsibleName = treeNode.name;
            } else {
                vm.resMaintenance.personResponsible = treeNode.id;
                vm.resMaintenance.responsibleName = treeNode.name;
            }
            layer.close(index || layer.index);
        },
        showCompanyLayer: function(v){
            vm.showCompanyValue = v;
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
                    vm.selectCompany(nodes[0], index)
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
                changes: ["required"],
                validateMethod: {
                    required: {
                        msg: "请输入出厂时间"
                    }
                },
                tabId: "link_resBaseInfo"
            },
            {
                selector: "input[id='resBaseInfo.factoryTime']",
                changes: ["compareDate"],
                validateMethod: {
                    compareDate: {
                        msg: "出厂时间不能大于当前时间",
                        value: "demo",
                        mode: 3
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
            },
            {
                selector: "input[id='resBaseInfo.objId']",
                blurs: ["remote"],
                noTriggerEvents: ["remote"],
                validateMethod: {
                    remote: {
                        url : baseURL + 'sys/commoncheck/checkName',
                        value: {
                            elements: ["input[id='resBaseInfo.id']", "input[id='resBaseInfo.objId']"],
                            keys: ["id", "objId"],
                            id: "id",
                            name: "objId",
                            daoName: "resBaseInfoDao",
                            noCheckWhenValueEmpty: true
                        },
                        msg: "三维图形对象ID已存在！",
                        callback: null
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
    var _validate4Maintenance = $validator.build({
        allPassRequired: true,
        items:[
            {
                selector: "input[id='resMaintenance.warrantyStartDate']",
                changes: ["compareDate"],
                validateMethod: {
                    compareDate: {
                        msg: "保修开始时间不能大于保修结束时间",
                        value: $("input[id='resMaintenance.warrantyEndDate']"),
                        mode: 1
                    }
                },
                tabId: "link_resMaintenance"
            },
            {
                selector: "input[id='resMaintenance.warrantyEndDate']",
                changes: ["compareDate"],
                validateMethod: {
                    compareDate: {
                        msg: "保修结束时间不能小于保修开始时间",
                        value: $("input[id='resMaintenance.warrantyStartDate']"),
                        mode: 2
                    }
                },
                tabId: "link_resMaintenance"
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
        validateMaintenance: function () {
            return _validate4Maintenance.validate();
        },
        resetBySelector: function (selector) {
            return _validate4ResInfo.resetBySelector(selector);
        },
        resetBySelector2: function (selector) {
            return _validate4Purchase.resetBySelector(selector);
        },
        resetAll: function () {
            _validate4ResInfo.resetAll();
            _validate4Purchase.resetAll();
            _validate4Maintenance.resetAll();
        }
    }
}();
var count = 0;