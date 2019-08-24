package main.java.com.ssm.chapter2.builder;

public class BuilderTest {
	public static void main(String[] args) {
		TicketHelper helper = new TicketHelper();
		helper.buildAdult("����Ʊ");
		helper.buildChildrenForSeat("������ͯ");
		helper.buildchildrenNoSeat("��Ʊ��ͯ");
		helper.buildElderly("����Ʊ");
		helper.buildSoldier("����Ʊ");
		Object ticket = TicketBuilder.builder(helper);
	}
}
