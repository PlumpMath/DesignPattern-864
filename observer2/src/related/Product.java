package related;

public class Product {
	private int milkCholate;
	private int darkCholate;
	private int cholateMilk;
	
	public Product(int milkCholate, int darkCholate, int cholateMilk) {
		super();
		this.milkCholate = milkCholate;
		this.darkCholate = darkCholate;
		this.cholateMilk = cholateMilk;
	}
	
	public int getMilkCholate() {
		return milkCholate;
	}
	public void setMilkCholate(int milkCholate) {
		this.milkCholate = milkCholate;
	}
	public int getDarkCholate() {
		return darkCholate;
	}
	public void setDarkCholate(int darkCholate) {
		this.darkCholate = darkCholate;
	}
	public int getCholateMilk() {
		return cholateMilk;
	}
	public void setCholateMilk(int cholateMilk) {
		this.cholateMilk = cholateMilk;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("��ũ���ݸ�-").append(milkCholate)
				.append(" / ��ũ���ݸ�-").append(darkCholate)
				.append(" / ���ݸ�����-").append(cholateMilk).toString();
	}

}
