package com.ijpay.interceptor;

import com.ijpay.controller.alipay.AliPayApiController;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jpay.alipay.AliPayApiConfigKit;

/**
 * @Email javen205@126.com
 * @author Javen
 */
public class AliPayApiInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		Controller controller = inv.getController();
		if (controller instanceof AliPayApiController == false)
			throw new RuntimeException("控制器需要继承 AliPayApiController");
		
		try {
			AliPayApiConfigKit.setThreadLocalAliPayApiConfig(((AliPayApiController)controller).getApiConfig());
			inv.invoke();
		}
		finally {
		}
	}

}