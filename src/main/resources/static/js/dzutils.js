$(document).bind("ajaxSend", function () {
    $("body").mLoading();
}).bind("ajaxComplete", function () {
    $("body").mLoading("hide");
});
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
        isValueInArray: function (k, v, array) {
            for (var i = 0; i < array.length; i++) {
                if (array[i][k] == v) {
                    return true;
                }
            }
            return false;
        }
    }
}();