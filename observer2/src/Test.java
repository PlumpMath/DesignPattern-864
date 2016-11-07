import observer.ChoclateMilkMaker;
import observer.DarkChoclateMaker;
import observer.Maker;
import observer.MilkChoclateMaker;
import related.Material;
import related.Product;
import subject.Sensor;

public class Test {

	public static void main(String[] args) {
		// step 0. 세팅
		Sensor sensor = init();
		
		// step1. 수행
		sensor.start(new Material(30, 20, 10));
		

	}
	
	// 세팅
	private static Sensor init() {
		// 생산품들 놔둘 곳
		Product productBox1 = new Product(0, 0, 0);
		
		// 생산기계들 세팅
		Maker milkChocolateMaker1 = new MilkChoclateMaker(productBox1);
		Maker darkChocolateMaker1 = new DarkChoclateMaker(productBox1);
		Maker chocolateMilkMaker1 = new ChoclateMilkMaker(productBox1);
		
		// 센서 세팅
		Sensor materialSensor = new Sensor();
		
		// 센서에 생산기계들 등록
		materialSensor.registerObserver(milkChocolateMaker1);
		materialSensor.registerObserver(darkChocolateMaker1);
		
		return materialSensor;
	}

}
