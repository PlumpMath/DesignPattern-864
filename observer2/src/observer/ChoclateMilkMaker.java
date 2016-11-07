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
	
	
	
	// 제품의 재고량을 체크 (더 생산할 수 있는지.)
	@Override
	boolean checkProduct() {
		if(p.getCholateMilk() >= CHOCOLATE_MILK_MAX){
			System.out.println("생산기계를 Stop시킵니다.");
			System.out.println("- 더 이상 초콜릿 우유를 만들 수 없습니다.");
			return false;
		}else{
			return true;
		}
	}

	@Override
	void generateProduct() {
		// 초콜릿 우유 만드는 과정...
		try {
			System.out.println("초콜릿 우유만드는중..");
			Thread.sleep(1000);
			
			// 초콜릿 우유 생산
			p.setCholateMilk(p.getCholateMilk() + 1);
			System.out.println("초콜릿 우유를 생산하였습니다. 재고량(" + p.getCholateMilk() + ")");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
