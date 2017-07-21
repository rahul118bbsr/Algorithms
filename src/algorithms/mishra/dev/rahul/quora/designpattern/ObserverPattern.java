/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.designpattern;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-Jul-2017 10:37:29 AM
 *
 */
public class ObserverPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Station weatherStation = new Station();
		Observer wo1 = new Observer1();
		Observer wo2 = new Observer2();
		
		weatherStation.register(wo1);
		weatherStation.register(wo2);
		weatherStation.setTemp(20);
		weatherStation.deregister(wo1);
		weatherStation.setTemp(40);
	}

}

interface Subject {
	void register(Observer observer);
	void deregister(Observer observer);
	void doNotify();
	
}

interface Observer {
	void doUpdate(int temp);
}

class Station implements Subject {
	private Set<Observer> obervers;
	private int temp;
	
	public Station() {
		obervers = new HashSet<>();
	}

	@Override
	public void register(Observer observer) {
		obervers.add(observer);
	}

	@Override
	public void deregister(Observer observer) {
		obervers.remove(observer);
	}

	@Override
	public void doNotify() {
		System.out.println("Detected change in temperature. Notifying all oberservers...");
		obervers.forEach(o -> o.doUpdate(temp));
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
		doNotify();
	}
}

class Observer1 implements Observer {

	@Override
	public void doUpdate(int temp) {
		System.out.println("Observer1 has detected change in temperature: " + temp);
	}
}

class Observer2 implements Observer {
	@Override
	public void doUpdate(int temp) {
		System.out.println("Observer2 has detected change in temperature: " + temp);
	}
}

