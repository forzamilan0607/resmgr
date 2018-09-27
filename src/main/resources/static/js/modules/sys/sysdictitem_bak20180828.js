var vm = new Vue({
	el:'#infTestApp',
	data:{
		title: null,
		param: {
			beginDate: "2018-04-01",
			endDate: "2018-04-20",
            type: 1
		},
		jsonObj: {
			data: "{\"stationNo\":\"100\",\"channel\":1}"
		}
	},
	methods: {
		query: function (event) {
			$.ajax({
				type: "POST",
			    url: baseURL + "inf/test/query",
                contentType: "application/json",
			    data: JSON.stringify(vm.jsonObj),
			    success: function(r){
			    	alert(JSON.stringify(r));
				}
			});
		}
	}
});