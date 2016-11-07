package subject;

import java.util.ArrayList;

import observer.Maker;
import observer.Observer;
import related.Material;

public class Sensor implements Subject{
	
	// ����ܰ�ȿ���� ���� �ʿ��� �ּҿ����� ���
	final static int CACAO_MIN = 10;
	final static int MILK_MIN  = 5;
	final static int SUGAR_MIN = 5;

	ArrayList<Observer> observerList;
	Material m;
	

	
	public Sensor() {
		observerList = new ArrayList<Observer>();
	}



	@Override
	public void registerObserver(Observer o) {
		observerList.add(o); 		
	}
	
	@Override
	public void removeObserver(Observer o) {
		int idx = observerList.indexOf(o);
		if(idx >= 0){
			observerList.remove(idx);
		}
	}
	
	@Override
	public void notifyObservers() {
		for(Observer o : observerList){
			
			// observer(������)�鿡�� update����(��ǰ����)�� �ʿ��� �ڿ�(������) �Ҵ�
			if(o instanceof Maker){
				((Maker) o).setMaterial(m);				
			}
			
			// observer���� ��ȣ (��ǰ �����ϵ��� ���)
			o.update();
		}
	}
	
	
	
	// ȿ����(����ܰ�) üũ ��, ������ ��ϵ� �� �����迡�� ���� ��� ����
	public void start(Material m){
		this.m = m;
		if(checkEffiency()){
			System.out.println("ȿ���� üũ.. �̻� ����!   ��ǰ ������ �����մϴ�.");
			System.out.println("�� ������ �� : " + m);
			notifyObservers();
			System.out.println(" ������ ���ƽ��ϴ�.");
			System.out.println("�� ������ �� : " + m);
		}
	}
	
	// ȿ����(����ܰ�) üũ
	private boolean checkEffiency() { // ---------ȿ���� üũ �߰� �ʿ�: ���� ��ǰ�� �󸶳� ������ �� �ִ��� �� ���� start�� ȣ������.
		if(m.getCacao() >= CACAO_MIN
		&& m.getMilk()  >= MILK_MIN
		&& m.getSugar() >= SUGAR_MIN){
			return true;
		}else{
			System.out.println("����ܰ��� ���� �ʾ� ��ǰ�� ������ �� �����ϴ�.");
			System.out.println("- ���� ������ ��� �ʹ� ���� ��ǰ�� �����ϱ� ���� �ܰ��� �ʹ� �����ϴ�.");
			System.out.println("- ���� ������ ��� : " + m);
			return false;
		}
	}
	
	

}
