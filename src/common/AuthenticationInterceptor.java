package common;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

public class AuthenticationInterceptor implements Interceptor {
	public void destroy() {
	}

    public void init() {
	}

    public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map session = actionInvocation.getInvocationContext().getSession();
		if (session.get("username") == null) {
			return "loginAction";
		}
		else {
			return actionInvocation.invoke();
		}
	}
}