package main.java.com.ssm.chapter2.intercept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target; //��ʵ����
    private String interceptorClass = null;//������ȫ�޶���
    
    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * ��ί�ж��󲢷���һ��������ռλ��
     *
     * @param target ��ʵ����
     * @return �������ռλ��
     */
    public static Object bind(Object target, String interceptorClass) {
        //ȡ�ô������    
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), 
                new InterceptorJdkProxy(target, interceptorClass));
    }

    @Override
    /**
     * ͨ�����������÷��������Ƚ����������.
     *
     * @param proxy --�������
     * @param method --�����������÷���
     * @param args -- �����Ĳ���
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            //û��������������ֱ�ӷ���ԭ�з���
            return method.invoke(target, args);
        }
        Object result = null;
        //ͨ����������������
        Interceptor interceptor = 
            (Interceptor) Class.forName(interceptorClass).newInstance();
        //����ǰ�÷���
        if (interceptor.before(proxy, target, method, args)) {
            //����ԭ�ж��󷽷�
            result = method.invoke(target, args);
        } else {//����falseִ��around����
            interceptor.around(proxy, target, method, args);
        }
        //���ú��÷���
        interceptor.after(proxy, target, method, args);
        return result;
    }
}