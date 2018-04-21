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
        }
    }
}();