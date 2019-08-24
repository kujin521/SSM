package main.java.com.ssm.chapter2.proxy;

import main.java.com.ssm.chapter2.reflect.ReflectServiceImpl;

public class ProxyTest {

	public static void main(String[] args) {
//		testJdkProxy();
		tesCGLIBProxy();
	}

	public static void testJdkProxy() {
		JdkProxyExample jdk = new JdkProxyExample();
		// �󶨹�ϵ����Ϊ���ڽӿ�HelloWorld�£����������������HelloWorld proxy
		HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
		// ע�⣬��ʱHelloWorld�����Ѿ���һ���������������������߼�����invoke��
		proxy.sayHelloWorld();
	}

	public static void tesCGLIBProxy() {
	    CglibProxyExample cpe = new CglibProxyExample();
	    ReflectServiceImpl obj = (ReflectServiceImpl)cpe.getProxy(ReflectServiceImpl.class);
	    obj.sayHello("����");
	}

}
