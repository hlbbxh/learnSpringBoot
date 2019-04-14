$.ajax({
    	url: "/hlbbxh/expection/getAjaxerror",//ajax请求地址 // 注意坑位这里要是加了项目路径需要添加项目全路径
    	type: "POST",
    	async: false,
    	success: function(data) {
    		debugger;
            if(data.status == 200 && data.msg == "OK") {
            	alert("success");
            } else {
            	alert("发生异常：" + data.msg);
            }
    	},
        error: function (response, ajaxOptions, thrownError) {
        	debugger;
        	alert("error");       
        }
    });