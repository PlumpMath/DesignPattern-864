package observer;

import related.Material;
import related.Product;

public abstract class Maker implements Observer{

	// ��ǰ�� ����� ���� �ʿ��� ��ᷮ
	static int CACAO_REQ;
	static int MILK_REQ;
	static int SUGAR_REQ;

	// ������ �� �ִ� ��ǰ�� �ִ뷮
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
	
	

	// update : observer�� ���ҷμ�, subject���� �˷��ָ� ���� �׼� ����
	@Override
	public void update() {
		while(checkMaterial() && checkProduct()){ // �����/����ǰ�� ��� üũ�Ͽ�, ��ǰ�� ����
			produce();
		}

	}
	
	// ��ǰ�� ���� �� ���� ������ ����ᰡ �ִ��� üũ
	private boolean checkMaterial() {
		if(m.getCacao() >= CACAO_REQ
		&& m.getMilk()  >= MILK_REQ
		&& m.getSugar() >= SUGAR_REQ){
			return true;
		}else{
			System.out.println("�����踦 Stop��ŵ�ϴ�.");
			System.out.println("- ����ᰡ �����Ͽ� ��ǰ�� �� �̻� ������ �� �����ϴ�.");
			System.out.println("- ���� ������ ��� ��Ȳ : " + m);
			return false;
		}
	}
	
	// �� ��ǰ�� ����� üũ. ����Ŀ�� ���� �ٸ��� ����
	abstract boolean checkProduct();
	
	public void produce(){
		consumeMaterial();   // ��ǰ�� ����� ���� ��� �Һ�
		generateProduct();   // ��ǰ�� ���� ����
		doPackage();         // ��ǰ�� ����
		viewProduceResult(); // ���� ��� ���
	}
	
	
	private void doPackage() {
		System.out.println("����� ��ǰ�� ���� ������ �մϴ�.");
	}

	// ��ǰ�� ���� �� ��� ��ᷮ ��ŭ�� ����� ����� ���ҽ�Ŵ
	private void consumeMaterial() {
		m.setCacao(m.getCacao() - CACAO_REQ);
		m.setCacao(m.getMilk()  - MILK_REQ);
		m.setCacao(m.getSugar() - SUGAR_REQ);
	}
	
	// �� ��ǰ�� �����ϴ� �κ�. ����Ŀ�� ���� �ٸ��� ����
	abstract void generateProduct();

	private void viewProduceResult() {
		// ��ũ���ݸ�1 ���忡�� ��ũ ���ݸ��� �����Ͽ����ϴ�.
		// �� ���귮.
		System.out.println("�� ���귮 : " + p);
	}
}
