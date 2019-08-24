package main.java.com.ssm.chapter2.builder;

public class TicketHelper {

	public void buildAdult(String info) {
		System.err.println("����������Ʊ�߼���" + info);
	}

	public void buildChildrenForSeat(String info) {
		System.err.println("����������ͯƱ�߼���" + info);
	}

	public void buildchildrenNoSeat(String info) {
		System.err.println("����������ͯƱ�߼���" + info);
	}

	public void buildElderly(String info) {
		System.err.println("������������Ʊ�߼���" + info);
	}

	public void buildSoldier(String info) {
		System.err.println("�������˼������Ʊ�߼���" + info);
	}
}
