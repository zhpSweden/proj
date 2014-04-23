package us.ucsd.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public final class WebUtils {
	public static <T> T form2Bean(HttpServletRequest request, Class<T> beanClass) {		
		try {
			T bean = beanClass.newInstance();
			Enumeration<String> e = request.getParameterNames();
			while(e.hasMoreElements()) {
				String name = e.nextElement();
				String value = request.getParameter(name);
				System.out.println(name);
				System.out.println(value);
				BeanUtils.setProperty(bean, name, value); 
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
