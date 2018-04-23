var $validator = function(){
    return {
        isBlank: function (value) {
            return !value || !/\S/.test(value)
        },
        checkKey: function (value) {
            return /^[0-9a-zA-Z]+$/.test(value);
        },
        checkMobile: function (telNum) {
            if (!telNum || !/^1[3|4|5|7|8][0-9]{9}$/.test(telNum)) {
                return {
                    msg: "手机号码格式不正确",
                    result: false
                };
            } else {
                return {
                    msg: "SUCCESS",
                    result: true
                };
            }
        },
        checkEmail: function (email) {
            if (!email || email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) !== -1) {
                return {
                    msg: "EMAIL格式不正确",
                    result: false
                };
            } else {
                return {
                    msg: "SUCCESS",
                    result: true
                };
            }
        },
        checkUserName: function (userName) {
            if (!userName) {
                return {
                    msg: "用户名格式不正确",
                    result: false
                };
            }
            var regCode = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]|\|·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
            //var regCN = /[\u4e00-\u9fa5]/;
            var user_name = (userName + "").replace(/^\s+|\s+$/g, "");
            if (user_name.length < 4) {
                return {
                    msg: "用户名长度不能少于4位",
                    result: false
                };
                document.getElementById("labuname").innerHTML = "<font color='red'><b>×用户名长度不能少于4位！<b></font>";
                return false;
            } else if (regCode.test(user_name)) {
                return {
                    msg: "用户名不能包含特殊字符",
                    result: false
                };
            } else {
                return {
                    msg: "SUCCESS",
                    result: true
                };
            }
        },
        checkPwd: function (pwd) {
            if (!pwd || pwd.length == 0) {
                return {
                    msg: "密码未输入",
                    result: false
                };
            } else if (pwd.length < 6 || pwd.length > 16) {
                return {
                    msg: "密码长度只能6－16位字符",
                    result: false
                };
            } else {
                return {
                    msg: "SUCCESS",
                    result: true
                };
            }
        },
        build: function (validateObj) {
            function buildValidateItem(item, eventName) {
                var validateItem = {
                    jqObj: $("#" + item.id),
                    value: item.validateMethod[eventName].value,
                    msg: item.validateMethod[eventName].msg
                }
                if (item.validateMethod[eventName].url) {
                    validateItem.url = item.validateMethod[eventName].url;
                }
                if (item.validateMethod[eventName].callback) {
                    validateItem.callback = item.validateMethod[eventName].callback;
                }
                if (item.validateMethod[eventName].childSelector) {
                    validateItem.childSelector = item.validateMethod[eventName].childSelector;
                }
                return validateItem;
            };
            function getErrorClass() {
                return _validateObj.config.errorClass || "validate-error";
            };
            /*function getSuccessClass() {
                return _validateObj.config.successClass || "validate-success";
            };*/
            function validateOK(validateItem) {
                // validateItem.jqObj.removeClass('has-error').addClass("has-feedback has-success")
                validateItem.jqObj.removeClass(getErrorClass());
                validateItem.jqObj.next("span").remove();
                return true;
            };
            function validateFail(validateItem) {
                // validateItem.jqObj.removeClass("has-success").addClass("has-error has-feedback");
                validateItem.jqObj.addClass(getErrorClass());
                validateItem.jqObj.next("span").remove();
                // validateItem.jqObj.after("<span>" + validateItem.msg + "</span>");
                validateItem.jqObj.after('<span class="glyphicon glyphicon-remove" style="color: #a94442">&nbsp;' + validateItem.msg + '</span>');
                return false;
            };
            function getEvents(validateItems){
                var eventMap = {};
                $.each(validateItems, function(index, item) {
                    for (var attr in item.validateMethod) {
                        if (!eventMap[attr]) {
                            eventMap[attr] = attr;
                        }
                    }
                });
                var events = {
                    required: function (validateItem) {
                        return !$validator.isBlank(validateItem.jqObj.val());
                    },
                    minLength: function (validateItem) {
                        return (validateItem.childSelector ? $(validateItem.childSelector).length : validateItem.jqObj.val().length) >= validateItem.value;
                    },
                    maxLength: function (validateItem) {
                        return (validateItem.childSelector ? $(validateItem.childSelector).length : validateItem.jqObj.val().length) <= validateItem.value;
                    },
                    range: function (validateItem) {
                        return validateItem.jqObj.val().length >= validateItem.value[0] && validateItem.jqObj.val().length <= validateItem.value[1];
                    },
                    equalsTo: function (validateItem) {
                        var value = validateItem.value instanceof jQuery ? validateItem.value.val(): validateItem.value;
                        return validateItem.jqObj.val() == value;
                    },
                    notEqualsTo: function (validateItem) {
                        var value = validateItem.value instanceof jQuery ? validateItem.value.val(): validateItem.value;
                        return validateItem.jqObj.val() != value;
                    },
                    checkReg: function (validateItem) {
                        if (!validateItem.jqObj.val()) {
                            return true;
                        }
                        var result = validateItem.value.test(validateItem.jqObj.val());
                        alert(result + "=" + validateItem.jqObj.val());
                        return result;
                    },
                    remote: function (validateItem) {
                        var param = {};
                        if ($.isArray(validateItem.value)) {
                            $.each(validateItem.value, function (index, item) {
                                param[item] = $("#" + item).val();
                            })
                        } else {
                            param = validateItem.value;
                        }
                        $.ajax({
                            type: "POST",
                            url: validateItem.url,
                            contentType: "application/json",
                            data: JSON.stringify(param),
                            success: function(r) {
                                validateItem.callback && validateItem.callback(r);
                                if ((r && r.code == 0) || r) {//validate ok
                                    validateOK(validateItem);
                                    _validateObj.remoteResult = true;
                                } else {
                                    validateFail(validateItem);
                                    _validateObj.remoteResult = false;
                                }
                            }
                        });
                        return true;
                    }
                };
                for (var eventName in eventMap) {
                    if (events[eventName]) {
                        eventMap[eventName] = events[eventName];
                    }
                }
                return eventMap;
            };
            function doValidate(item, eventName) {
                var validateItem = buildValidateItem(item, eventName);
                if (!_validateObj.events[eventName](validateItem)) {
                    //校验失败
                    return validateFail(validateItem);
                } else { // 校验成功
                    return validateOK(validateItem);
                }
                return _validateObj.validateResult;
            };
            function dynamicBindEvent(item, triggerEventNames, eventName) {
                if (item[triggerEventNames] && item[triggerEventNames].length) {
                    $("#" + item.id).unbind(eventName).bind(eventName, function () {
                        $.each(item[triggerEventNames], function (index, eventItem) {
                            if (!doValidate(item, eventItem)) {
                                return false;
                            }
                        });
                    });
                }
            }
            var _validateObj = {
                config: validateObj,
                events: getEvents(validateObj.items),
                validateResult: true,
                remoteResult: true
            };
            //初始化绑定blur事件
            $.each(_validateObj.config.items, function (index, item) {
                dynamicBindEvent(item, "blurs", "blur");
                dynamicBindEvent(item, "changes", "change");
            });
            return {
                validate: function () {
                    _validateObj.validateResult = true;
                    $.each(_validateObj.config.items, function(index, item) {
                        if (_validateObj.config.allPassRequired && !_validateObj.validateResult) {
                            return false;
                        }
                        for (var eventName in item.validateMethod) {
                            //不需要在提交时再触发的事件
                            if (item.noTriggerEvents && $.inArray(eventName, item.noTriggerEvents) >= 0) {
                                continue;
                            }
                            if (!doValidate(item, eventName)) {
                                _validateObj.validateResult = false;
                                break;
                            }
                        }
                    });
                    return _validateObj.validateResult && _validateObj.remoteResult;
                },
                reset: function () {                    
                    var jqIds = $.map(_validateObj.config.items, function (item, index) {
                        return "#" + item.id;
                    }).join(",");
                    $(jqIds).removeClass(getErrorClass()).next("span").remove();
                    _validateObj.validateResult = true;
                },
                resetById: function (id) {
                    $("#"+ id).removeClass(getErrorClass()).next("span").remove();
                }
            }
        }
    }
}();
