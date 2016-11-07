import observer.ChoclateMilkMaker;
import observer.DarkChoclateMaker;
import observer.Maker;
import observer.MilkChoclateMaker;
import related.Material;
import related.Product;
import subject.Sensor;

public class Test {

	public static void main(String[] args) {
		// step 0. ����
		Sensor sensor = init();
		
		// step1. ����
		sensor.start(new Material(30, 20, 10));
		

	}
	
	// ����
	private static Sensor init() {
		// ����ǰ�� ���� ��
		Product productBox1 = new Product(0, 0, 0);
		
		// ������� ����
		Maker milkChocolateMaker1 = new MilkChoclateMaker(productBox1);
		Maker darkChocolateMaker1 = new DarkChoclateMaker(productBox1);
		Maker chocolateMilkMaker1 = new ChoclateMilkMaker(productBox1);
		
		// ���� ����
		Sensor materialSensor = new Sensor();
		
		// ������ ������� ���
		materialSensor.registerObserver(milkChocolateMaker1);
		materialSensor.registerObserver(darkChocolateMaker1);
		
		return materialSensor;
	}

}
