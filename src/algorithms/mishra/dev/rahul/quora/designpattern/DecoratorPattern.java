/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.designpattern;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-Jul-2017 9:03:44 AM
 *
 */
public class DecoratorPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Car car = new SportsCar(new LuxuryCar(new BasicCar()));
		car.assemble();
	}
}

interface Car {
	void assemble();
}

class BasicCar implements Car {
	@Override
	public void assemble() {
		System.out.println("Assembling Basic Car");
	}
}

class CarDecorator implements Car {
	protected Car car;
	
	@Override
	public void assemble() {
		car.assemble();
	}
}

class SportsCar extends CarDecorator {
	public SportsCar(Car car) {
		this.car = car;
	}
	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Assembling Sports Car");
	}
}

class LuxuryCar extends CarDecorator {
	public LuxuryCar(Car car) {
		this.car = car;
	}
	
	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Assembling Luxury Car");
	}
}