package related;

public class Material {
	private int cacao;
	private int milk;
	private int sugar;
	
	public Material(int cacao, int milk, int sugar) {
		super();
		this.cacao = cacao;
		this.milk = milk;
		this.sugar = sugar;
	}
	
	public int getCacao() {
		return cacao;
	}
	public void setCacao(int cacao) {
		this.cacao = cacao;
	}
	public int getMilk() {
		return milk;
	}
	public void setMilk(int milk) {
		this.milk = milk;
	}
	public int getSugar() {
		return sugar;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("īī��-").append(cacao)
				.append(" / ����-").append(milk)
				.append(" / ����-").append(sugar).toString();
	}
}
