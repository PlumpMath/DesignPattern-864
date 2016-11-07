package observer;

import related.Material;
import related.Product;

public abstract class Maker implements Observer{

	// 제품을 만들기 위해 필요한 재료량
	static int CACAO_REQ;
	static int MILK_REQ;
	static int SUGAR_REQ;

	// 생산할 수 있는 제품의 최대량
	final static int MLLK_CHOCOLATE_MAX = 1;
	final static int DARK_CHOCOLATE_MAX = 5;
	final static int CHOCOLATE_MILK_MAX = 60;

	protected Material m;
	protected Product p;

	public Material getMaterial() {
		return m;
	}

	public void setMaterial(Material m) {
		this.m = m;
	}

	public Product getProduct() {
		return p;
	}

	public void setProduct(Product p) {
		this.p = p;
	}
	
	

	public Maker() {}

	public Maker(Product p) {
		super();
		this.p = p;
	}
	
	

	// update : observer의 역할로서, subject에서 알려주면 취할 액션 정의
	@Override
	public void update() {
		while(checkMaterial() && checkProduct()){ // 원재료/생산품의 재고를 체크하여, 제품을 생산
			produce();
		}

	}
	
	// 제품을 만들 수 있을 정도로 원재료가 있는지 체크
	private boolean checkMaterial() {
		if(m.getCacao() >= CACAO_REQ
		&& m.getMilk()  >= MILK_REQ
		&& m.getSugar() >= SUGAR_REQ){
			return true;
		}else{
			System.out.println("생산기계를 Stop시킵니다.");
			System.out.println("- 원재료가 부족하여 제품을 더 이상 생산할 수 없습니다.");
			System.out.println("- 현재 원자재 재고 상황 : " + m);
			return false;
		}
	}
	
	// 각 제품의 재고량을 체크. 메이커에 따라 다르게 정의
	abstract boolean checkProduct();
	
	public void produce(){
		consumeMaterial();   // 제품을 만들기 위한 재료 소비
		generateProduct();   // 제품을 실제 생산
		doPackage();         // 제품을 포장
		viewProduceResult(); // 생산 결과 출력
	}
	
	
	private void doPackage() {
		System.out.println("생산된 제품에 대해 포장을 합니다.");
	}

	// 제품을 만들 때 드는 재료량 만큼을 원재료 재고에서 감소시킴
	private void consumeMaterial() {
		m.setCacao(m.getCacao() - CACAO_REQ);
		m.setCacao(m.getMilk()  - MILK_REQ);
		m.setCacao(m.getSugar() - SUGAR_REQ);
	}
	
	// 각 제품을 생산하는 부분. 메이커에 따라 다르게 정의
	abstract void generateProduct();

	private void viewProduceResult() {
		// 밀크초콜릿1 공장에서 밀크 초콜릿을 생산하였습니다.
		// 총 생산량.
		System.out.println("총 생산량 : " + p);
	}
}
