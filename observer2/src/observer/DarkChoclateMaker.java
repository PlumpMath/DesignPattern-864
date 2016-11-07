package observer;

import related.Product;

public class DarkChoclateMaker extends Maker {
	static int CACAO_REQ = 1;
	static int MILK_REQ  = 0;
	static int SUGAR_REQ = 0;
	
	public DarkChoclateMaker() {
		super.CACAO_REQ = CACAO_REQ;
		super.MILK_REQ = MILK_REQ;
		super.SUGAR_REQ = SUGAR_REQ;
	}
	
	public DarkChoclateMaker(Product p) {
		super(p);
	}
	
	
	
	// ��ǰ�� ����� üũ (�� ������ �� �ִ���.)
	@Override
	boolean checkProduct() {
		if(p.getDarkCholate() >= DARK_CHOCOLATE_MAX){
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
			p.setDarkCholate(p.getDarkCholate() + 1);
			System.out.println("��ũ ���ݸ��� �����Ͽ����ϴ�. ���(" + p.getDarkCholate() + ")");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
