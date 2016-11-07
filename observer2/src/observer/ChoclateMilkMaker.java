package observer;

import related.Product;

public class ChoclateMilkMaker extends Maker {
	static int CACAO_REQ = 1;
	static int MILK_REQ  = 1;
	static int SUGAR_REQ = 0;
	
	public ChoclateMilkMaker() {
		super.CACAO_REQ = CACAO_REQ;
		super.MILK_REQ = MILK_REQ;
		super.SUGAR_REQ = SUGAR_REQ;
	}
	
	public ChoclateMilkMaker(Product p) {
		super(p);
	}
	
	
	
	// ��ǰ�� ����� üũ (�� ������ �� �ִ���.)
	@Override
	boolean checkProduct() {
		if(p.getCholateMilk() >= CHOCOLATE_MILK_MAX){
			System.out.println("�����踦 Stop��ŵ�ϴ�.");
			System.out.println("- �� �̻� ���ݸ� ������ ���� �� �����ϴ�.");
			return false;
		}else{
			return true;
		}
	}

	@Override
	void generateProduct() {
		// ���ݸ� ���� ����� ����...
		try {
			System.out.println("���ݸ� �����������..");
			Thread.sleep(1000);
			
			// ���ݸ� ���� ����
			p.setCholateMilk(p.getCholateMilk() + 1);
			System.out.println("���ݸ� ������ �����Ͽ����ϴ�. ���(" + p.getCholateMilk() + ")");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
