package main.java.com.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public main.java.com.ssm.chapter2.reflect.ReflectServiceImpl getInstance() {
		main.java.com.ssm.chapter2.reflect.ReflectServiceImpl object = null;
		try {
			object = (main.java.com.ssm.chapter2.reflect.ReflectServiceImpl) Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl")
					.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return object;
	}

	public Object reflectMethod() {
		Object returnObj = null;
		main.java.com.ssm.chapter2.reflect.ReflectServiceImpl target = new main.java.com.ssm.chapter2.reflect.ReflectServiceImpl();
		try {
			Method method = main.java.com.ssm.chapter2.reflect.ReflectServiceImpl.class.getMethod("sayHello", String.class);
			returnObj = method.invoke(target, "����");
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException ex) {
			ex.printStackTrace();
		}
		return returnObj;
	}

	public Object reflect() {
		main.java.com.ssm.chapter2.reflect.ReflectServiceImpl object = null;
		try {
			object = (main.java.com.ssm.chapter2.reflect.ReflectServiceImpl) Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl")
					.newInstance();
			Method method = object.getClass().getMethod("sayHello", String.class);
			method.invoke(object, "����");
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
			ex.printStackTrace();
		}
		return object;
	}

}
