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
	
	

	// 제품의 재고량을 체크 (더 생산할 수 있는지.)
	@Override
	boolean checkProduct() {
		if(p.getMilkCholate() >= MLLK_CHOCOLATE_MAX){
			System.out.println("생산기계를 Stop시킵니다.");
			System.out.println("- 더 이상 밀크 초콜릿을 만들 수 없습니다.");
			return false;
		}else{
			return true;
		}
	}

	@Override
	void generateProduct() {
		// 밀크 초콜릿 만드는 과정...
		try {
			System.out.println("밀크 초콜릿 만드는중..");
			Thread.sleep(2000);
			
			// 밀크 초콜릿 생산
			p.setMilkCholate(p.getMilkCholate() + 1);
			System.out.println("밀크 초콜릿을 생산하였습니다. 재고량(" + p.getMilkCholate() + ")");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
