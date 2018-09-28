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
                    jqObj: $(item.selector),
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
                if (item.validateMethod[eventName].mode) {
                    validateItem.mode = item.validateMethod[eventName].mode;
                }
                return validateItem;
            };
            function getErrorClass() {
                return _validateObj.config.errorClass || "validate-error";
            };
            /*function getSuccessClass() {
                return _validateObj.config.successClass || "validate-success";
            };*/
            function removeSpan(jqSpan) {
                if (jqSpan.hasClass("input-group-btn")) {
                    jqSpan.next("span").remove();
                    return false;
                } else {
                    jqSpan.remove();
                    return true;
                }
            }
            function validateOK(validateItem) {
                // validateItem.jqObj.removeClass('has-error').addClass("has-feedback has-success")
                validateItem.jqObj.removeClass(getErrorClass());
                var jqSpan = validateItem.jqObj.next("span");
                removeSpan(jqSpan);
                return true;
            };
            function validateFail(validateItem) {
                // validateItem.jqObj.removeClass("has-success").addClass("has-error has-feedback");
                validateItem.jqObj.addClass(getErrorClass());
                var jqSpan =validateItem.jqObj.next("span");
                if (removeSpan(jqSpan)) {
                    validateItem.jqObj.after('<span class="glyphicon glyphicon-remove" style="color: #a94442">&nbsp;' + validateItem.msg + '</span>');
                } else {
                    jqSpan.after('<span class="glyphicon glyphicon-remove" style="position: absolute; top: 40px; left: 0px;color: #a94442">&nbsp;' + validateItem.msg + '</span>');
                }
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
                    compareDate: function (validateItem) {
                        var value = validateItem.value instanceof jQuery ? validateItem.value.val(): validateItem.value;
                        if (validateItem.jqObj.val() && value) {
                            var datetime1 = new Date(validateItem.jqObj.val()).getTime();
                            var datetime2 = validateItem.mode == 3 ? new Date().getTime() : new Date(value).getTime();
                            switch (validateItem.mode) {
                                case 1://datetime1 不能大于 datetime2
                                case 3:
                                    return !(datetime1 > datetime2);
                                case 2: //datetime1 不能小于 datetime2
                                    return !(datetime2 > datetime1);
                            }
                        }
                        return true;
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
                                if ((r && r.code == 200) || r) {//validate ok
                                    validateOK(validateItem);
                                    _validateObj.remoteResult[validateItem.jqObj.prop("id")] = {result: true}
                                } else {
                                    validateFail(validateItem);
                                    _validateObj.remoteResult[validateItem.jqObj.prop("id")] = {result: false, msg: validateItem.msg};
                                }
                                validateItem.callback && validateItem.callback(r);
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
            };
            function dynamicBindEvent(item, triggerEventNames, eventName) {
                if (item[triggerEventNames] && item[triggerEventNames].length) {
                    $(item.selector).unbind(eventName).bind(eventName, function () {
                        $.each(item[triggerEventNames], function (index, eventItem) {
                            if (!doValidate(item, eventItem)) {
                                return false;
                            }
                        });
                    });
                }
            }
            function resetSelector(items) {
                $.each(items, function (index, item) {
                    if (item.id && !item.selector) {
                        item.selector = "#" + item.id;
                    }
                });
            };
            function scroll2Dom(item) {
                if (item.tabId && !$("#" + item.tabId).parent("li").hasClass("active")) {
                    $("#" + item.tabId).click();
                    setTimeout(function () {
                        $("html,body").animate({scrollTop: $(item.selector).offset().top}, 500);
                    }, 500)
                } else {
                    $("html,body").animate({scrollTop: $(item.selector).offset().top}, 500);
                }
            }
            var _validateObj = {
                config: validateObj,
                events: getEvents(validateObj.items),
                validateResult: true,
                remoteResult: {}
            };
            resetSelector(_validateObj.config.items);
            //初始化绑定blur事件
            $.each(_validateObj.config.items, function (index, item) {
                dynamicBindEvent(item, "blurs", "blur");
                dynamicBindEvent(item, "changes", "change");
            });
            return {
                validate: function () {
                    _validateObj.validateResult = true;
                    $.each(_validateObj.config.items, function(index, item) {
                        for (var eventName in item.validateMethod) {
                            //不需要在提交时再触发的事件
                            if (item.noTriggerEvents && $.inArray(eventName, item.noTriggerEvents) >= 0) {
                                continue;
                            }
                            if (!doValidate(item, eventName)) {
                                item.hasError = true;
                                _validateObj.validateResult = false;
                                break;
                            }
                        }
                        if (_validateObj.config.allPassRequired && !_validateObj.validateResult) {
                            scroll2Dom(item);
                            return false;
                        }
                    });
                    //如果存在remote服务错误
                    //首先校验remote方法是否有错误
                    if (_validateObj.remoteResult) {
                        for (var id in _validateObj.remoteResult) {
                            if (!_validateObj.remoteResult[id].result) {
                                _validateObj.validateResult = validateFail({
                                    jqObj: $("#" + id),
                                    msg: _validateObj.remoteResult[id].msg
                                })
                            }
                        }
                    }
                    return _validateObj.validateResult;
                },
                reset: function () {                    
                    var jqIds = $.map(_validateObj.config.items, function (item, index) {
                        return item.selector;
                    }).join(",");
                    $(jqIds).removeClass(getErrorClass()).next("span").remove();
                    _validateObj.validateResult = true;
                },
                resetById: function (id) {
                    removeSpan($("#"+ id).removeClass(getErrorClass()).next("span"));
                },
                resetBySelector: function (selector) {
                    removeSpan($(selector).removeClass(getErrorClass()).next("span"));
                },
                resetAll: function () {
                    for (var i = 0; i < _validateObj.config.items.length; i++) {
                        var item = _validateObj.config.items[i];
                        if (item.hasError) {
                            this.resetBySelector(item.selector);
                        }
                    }
                }
            }
        }
    }
}();
