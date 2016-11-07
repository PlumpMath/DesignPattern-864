package observer;

import related.Product;

public class MilkChoclateMaker extends Maker {
	static int CACAO_REQ = 1;
	static int MILK_REQ  = 1;
	static int SUGAR_REQ = 1;
	
	public MilkChoclateMaker() {
		super.CACAO_REQ = CACAO_REQ;
		super.MILK_REQ = MILK_REQ;
		super.SUGAR_REQ = SUGAR_REQ;
	}
	
	public MilkChoclateMaker(Product p) {
		super(p);
		super.CACAO_REQ = CACAO_REQ;
		super.MILK_REQ = MILK_REQ;
		super.SUGAR_REQ = SUGAR_REQ;
	}
	
	

	// ��ǰ�� ����� üũ (�� ������ �� �ִ���.)
	@Override
	boolean checkProduct() {
		if(p.getMilkCholate() >= MLLK_CHOCOLATE_MAX){
			System.out.println("�����踦 Stop��ŵ�ϴ�.");
			System.out.println("- �� �̻� ��ũ ���ݸ��� ���� �� �����ϴ�.");
			return false;
		}else{
			return true;
		}
	}

	@Override
	void generateProduct() {
		// ��ũ ���ݸ� ����� ����...
		try {
			System.out.println("��ũ ���ݸ� �������..");
			Thread.sleep(2000);
			
			// ��ũ ���ݸ� ����
			p.setMilkCholate(p.getMilkCholate() + 1);
			System.out.println("��ũ ���ݸ��� �����Ͽ����ϴ�. ���(" + p.getMilkCholate() + ")");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
