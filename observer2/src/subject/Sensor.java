package subject;

import java.util.ArrayList;

import observer.Maker;
import observer.Observer;
import related.Material;

public class Sensor implements Subject{
	
	// 생산단가효율을 위해 필요한 최소원자재 재고량
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
			
			// observer(생산기계)들에게 update수행(제품생산)에 필요한 자원(원자재) 할당
			if(o instanceof Maker){
				((Maker) o).setMaterial(m);				
			}
			
			// observer에게 신호 (제품 생산하도록 명력)
			o.update();
		}
	}
	
	
	
	// 효율성(생산단가) 체크 후, 센서에 등록된 각 생산기계에게 생산 명령 내림
	public void start(Material m){
		this.m = m;
		if(checkEffiency()){
			System.out.println("효율성 체크.. 이상 없음!   제품 생산을 시작합니다.");
			System.out.println("총 원자재 량 : " + m);
			notifyObservers();
			System.out.println(" 생산을 마쳤습니다.");
			System.out.println("총 원자재 량 : " + m);
		}
	}
	
	// 효율성(생산단가) 체크
	private boolean checkEffiency() { // ---------효율성 체크 추가 필요: 실제 제품을 얼마나 생산할 수 있는지 에 따라 start를 호출할지.
		if(m.getCacao() >= CACAO_MIN
		&& m.getMilk()  >= MILK_MIN
		&& m.getSugar() >= SUGAR_MIN){
			return true;
		}else{
			System.out.println("생산단가가 맞지 않아 제품을 생산할 수 없습니다.");
			System.out.println("- 현재 원자재 재고가 너무 적어 제품을 생산하기 위한 단가가 너무 높습니다.");
			System.out.println("- 현재 원자재 재고량 : " + m);
			return false;
		}
	}
	
	

}
