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
		WeatherStation weatherStation = new WeatherStation();
		WeatherObserver wo1 = new Observer1();
		WeatherObserver wo2 = new Observer2();
		
		weatherStation.register(wo1);
		weatherStation.register(wo2);
		weatherStation.setTemp(20);
		weatherStation.deregister(wo1);
		weatherStation.setTemp(40);
	}

}

interface WeatherSubject {
	void register(WeatherObserver weatherObserver);
	void deregister(WeatherObserver weatherObserver);
	void doNotify();
	
}

interface WeatherObserver {
	void doUpdate(int temp);
}

class WeatherStation implements WeatherSubject {
	private Set<WeatherObserver> obervers;
	private int temp;
	
	public WeatherStation() {
		obervers = new HashSet<>();
	}

	@Override
	public void register(WeatherObserver weatherObserver) {
		obervers.add(weatherObserver);
	}

	@Override
	public void deregister(WeatherObserver weatherObserver) {
		obervers.remove(weatherObserver);
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

class Observer1 implements WeatherObserver {

	@Override
	public void doUpdate(int temp) {
		System.out.println("Observer1 has detected change in temperature: " + temp);
	}
}

class Observer2 implements WeatherObserver {
	@Override
	public void doUpdate(int temp) {
		System.out.println("Observer2 has detected change in temperature: " + temp);
	}
}

