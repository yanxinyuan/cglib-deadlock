package com.cglib.xy.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.URL;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

/**
 *
 * @author Xinyuan.Yan
 * 
 */
public class LuchMain {

	public static void main(String[] args) throws Exception {
		String className = "com.cglib.xy.sample.DoOne";
		File testJar = new File("./lib/test.jar");
		if (!testJar.exists()) throw new FileNotFoundException();
		
		UserClassLoader loader = new UserClassLoader(new URL[]{testJar.toURI().toURL()}, LuchMain.class.getClassLoader());
		Class<?> loadClass = loader.loadClass(className);
		
		MethodInterceptor interceptor = new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				return proxy.invokeSuper(obj, args);
			}
		};
		Callback[] callbacks = new Callback[] { interceptor, NoOp.INSTANCE };
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(loadClass);
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method arg0) {
				return 0;
			}
		});
		enhancer.setCallbacks(callbacks);
		enhancer.setClassLoader(loader);
		Object obj = enhancer.create();
		System.out.println(obj);
	}
}
