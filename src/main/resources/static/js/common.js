//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

//工具集合Tools
window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost/index.html?id=123
// T.p('id') --> 123;
var url = function(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
};
T.p = url;

//请求前缀
var baseURL = "/resmgr/";

//登录token
var token = localStorage.getItem("token");
if(token == 'null'){
    parent.location.href = baseURL + 'login.html';
}

//jquery全局配置
$.ajaxSetup({
	dataType: "json",
	cache: false,
    headers: {
        "token": token
    },
    xhrFields: {
	    withCredentials: true
    },
    complete: function(xhr) {
        //token过期，则跳转到登录页面
        if(xhr.responseJSON.code == 401){
            parent.location.href = baseURL + 'login.html';
        }
    }
});

//jqgrid全局配置
$.extend($.jgrid.defaults, {
    ajaxGridOptions : {
        headers: {
            "token": token
        }
    }
});

//权限判断
function hasPermission(permission) {
    if (window.parent.permissions.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}

//重写alert
window.alert = function(msg, callback){
	parent.layer.alert(msg, function(index){
		parent.layer.close(index);
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}

//重写confirm式样框
window.confirm = function(msg, callback){
	parent.layer.confirm(msg, {btn: ['确定','取消']},
	function(){//确定事件
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
    	alert("只能选择一条记录");
    	return ;
    }
    
    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    return grid.getGridParam("selarrrow");
}

//判断是否为空
function isBlank(value) {
    return !value || !/\S/.test(value)
}

function clearObjValue(obj) {
    if (obj && typeof obj === "object") {
        for (var attr in obj) {
            obj[attr] = null;
        }
    }
}
var $myMsg = function(){
    var tempMsgs = {
        requiredMsg : "请输入{name}",
        required4SelMsg : "请选择{name}",
        minLength : "{name}不能小于{length}位长度",
        maxLength : "{name}不能大于{length}位长度",
        rangelength : "{name}长度必须在{start}-{end}之间"
    };
    return {
        required : function(name) {
            return tempMsgs.requiredMsg.replace("{name}", name);
        },
        required4Sel : function(name) {
            return tempMsgs.required4SelMsg.replace("{name}", name);
        },
        rangelength: function(name, start, end) {
            return tempMsgs.rangelength.replace("{name}", name).replace("{start}", start).replace("{end}", end);
        },
        minLength: function(name, length) {
            return tempMsgs.minLength.replace("{name}", name).replace("{length}", length);
        },
        maxLength: function(name, length) {
            return tempMsgs.maxLength.replace("{name}", name).replace("{length}", length);
        }
    }
}();
var $util = function () {
    return {
        HTTP_STATUS: {
            SC_OK: 200,
            SC_NOT_FOUND: 404,
            SC_INTERNAL_SERVER_ERROR: 500
        },
        copyProps: function (src, target, attrList) {
            if (attrList) {
                for (var i = 0; i < attrList.length; i++) {
                    var attr = attrList[i];
                    target[attr] = src[attr];
                }
            } else {
                for (var attr in src) {
                    target[attr] = src[attr];
                }
            }
        },
        isValueInArray: function (k, v, array) {
            for (var i = 0; i < array.length; i++) {
                if (array[i][k] == v) {
                    return true;
                }
            }
            return false;
        },
        isObjAttrEquals: function (objA, objB, attrList) {
            for (var i = 0; i < attrList.length; i++) {
                var attr = attrList[i];
                if (objA[attr] != objB[attr]) {
                    return false;
                }
            }
            return true;
        },
        upload: function (conf) {
            new AjaxUpload(conf.selector, {
                action: baseURL + 'sys/oss/upload?token=' + token,
                name: 'file',
                autoSubmit: true,
                responseType: "json",
                onChange: function (file, extension) {
                    alert(file);
                },
                onSubmit: function (file, extension) {
                    if (!extension || !conf.suffixReg.test(extension.toLowerCase())) {
                        alert(conf.msg ? conf.msg : "不支持的文件格式！");
                        return false;
                    }
                    $("body").mLoading();
                },
                onComplete: function (file, r) {
                    $("body").mLoading("hide");
                    if (r.code == $util.HTTP_STATUS.SC_OK) {
                        alert(r.url);
                        // conf.attachmentList.push();
                    } else {
                        alert(r.msg);
                    }
                }
            });
        }
    }
}();
setTimeout(function () {
    $(document).bind("ajaxSend", function () {
        $("body").mLoading();
    }).bind("ajaxComplete", function () {
        $("body").mLoading("hide");
    });
}, 500);