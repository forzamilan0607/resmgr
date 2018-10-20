$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'userId', index: "user_id", width: 45, key: true },
			{ label: '用户名', name: 'username', width: 75 },
			{ label: '邮箱', name: 'email', width: 90 },
			{ label: '手机号', name: 'mobile', width: 100 },
			{ label: '状态', name: 'status', width: 80, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
			{ label: '创建时间', name: 'createTime', index: "create_time", width: 80}
        ],
		viewrecords: true,
        height: 370,
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

    _validator = initValidator();
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			username: null
		},
		showList: true,
		title:null,
		roleList:{},
		user:{
			password: null,
			status: 1,
			roleIdList: []
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.roleList = {};
			vm.user = {status:1,roleIdList:[]};
            _validator.resetAll();
			//获取角色信息
			this.getRoleList();
		},
		update: function () {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
            _validator.resetAll();
			vm.showList = false;
            vm.title = "修改";
			
			vm.getUser(userId);
			//获取角色信息
			this.getRoleList();
		},
		del: function () {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == $util.HTTP_STATUS.SC_OK){
							alert('操作成功', function(){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function () {
            if(!_validator.validate()){
                return ;
            }
			var url = vm.user.userId == null ? "sys/user/save" : "sys/user/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
			    success: function (r) {
			    	if(r.code == $util.HTTP_STATUS.SC_OK){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getUser: function(userId){
			$.get(baseURL + "sys/user/info/"+userId, function(r){
				vm.user = r.user;
                vm.user.password = r.user.password.substring(0,6);
                vm.user.confirmPwd = vm.user.password;
			});
		},
		getRoleList: function(){
			$.get(baseURL + "sys/role/select", function(r){
				vm.roleList = r.list;
			});
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'username': vm.q.username},
                page:page
            }).trigger("reloadGrid");
		},
        validator2: function () {
            if(isBlank(vm.user.username)){
                alert("用户名不能为空");
                return true;
            }

            if(vm.user.userId == null && isBlank(vm.user.password)){
                alert("密码不能为空");
                return true;
            }

            if(isBlank(vm.user.email)){
                alert("邮箱不能为空");
                return true;
            }

            if(!validator.isEmail(vm.user.email)){
                alert("邮箱格式不正确");
                return true;
			}
        }
	}
});
var _validator;
function initValidator() {
    return $validator.build({
        allPassRequired: true,
        items:[
            {
                selector: "input[id='user.username']",
                blurs: ["required", "range", "remote"],
                noTriggerEvents: ["remote"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入用户名"
                    },
                    range: {
                        value: [2, 30],
                        msg: "用户名长度范围只能是2-30位之间"
                    },
                    remote: {
                        url : baseURL + 'sys/commoncheck/checkName',
                        value: {
                            elements: ["input[id='user.userId']", "input[id='user.username']"],
                            keys: ["userId", "realUsername"],
                            id: "userId",
                            daoName: "sysUserDao"
                        },
                        msg: "用户名已存在！",
                        callback: null
                    }
                }
            },
            {
                selector: "input[id='user.password']",
                blurs: ["required", "minLength"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入密码"
                    },
                    minLength: {
                        value: 6,
                        msg: "密码长度不能小于6位"
                    }
                }
            },
            {
                selector: "input[id='user.confirmPwd']",
                blurs: ["required", "equalsTo"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入确认密码"
                    },
                    equalsTo: {
                        value: $("input[id='user.password']"),
                        msg: "密码输入不一致"
                    }
                }
            },
            {
                selector: "input[id='user.email']",
                blurs: ["required", "checkEmail"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入邮箱地址"
                    },
                    checkEmail: {
                        msg: "邮箱地址格式不正确"
                    }
                }
            },
            {
                selector: "input[id='user.mobile']",
                blurs: ["required", "checkMobile"],
                validateMethod: {
                    required: {
                        value: true,
                        msg: "请输入手机号码"
                    },
                    checkMobile: {
                        msg: "手机号码格式不正确"
                    }
                }
            }
        ]
    });
}