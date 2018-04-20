var vm = new Vue({
	el:'#infTestApp',
	data:{
		title: null,
		param: {
			beginDate: "2018-04-01",
			endDate: "2018-04-20",
            type: 1
		}
	},
	methods: {
		query: function (event) {
			$.ajax({
				type: "POST",
			    url: baseURL + "inf/test/query",
                contentType: "application/json",
			    data: JSON.stringify(vm.param),
			    success: function(r){
			    	if(r.code === 200){
						alert('操作成功');
					}else{
						alert(r.msg);
					}
				}
			});
		}
	}
});