package main.java.com.ssm.chapter2.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {
    
    private List<String> productList = null;//��Ʒ�б�
    
    private static ProductList instance;//��Ψһʵ��
    
    private ProductList() {}//��������˽�л�
    
    /**
     * ȡ��Ψһʵ��
     * @return ��Ʒ�б�Ψһʵ��
     */
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }
    
    /**
     * ���ӹ۲��ߣ����̽ӿڣ�
     * @param observer �۲���
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }
    
    /**
     *  ������Ʒ
     * @param newProduct �²�Ʒ 
     */
    public void addProudct(String newProduct) {
        productList.add(newProduct);
        System.err.println("��Ʒ�б������˲�Ʒ��"+newProduct);
        this.setChanged();//���ñ��۲�������仯
        this.notifyObservers(newProduct);//֪ͨ�۲��ߣ��������²�Ʒ
    }
}
