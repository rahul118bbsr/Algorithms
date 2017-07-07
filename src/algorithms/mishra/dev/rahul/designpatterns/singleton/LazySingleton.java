/**
 * 
 */
package algorithms.mishra.dev.rahul.designpatterns.singleton;

import java.util.Objects;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-Jun-2017 9:00:19 PM
 *
 */
public class LazySingleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = Person.getInstance();
		Person p2 = Person.getInstance();
		System.out.println(p1 == p2);
		p1.setName("Rahul");
		System.out.println(p1 == p2);
		System.out.println(p1.getName() + " " + p2.getName());
	}

}

class Person {
	private String name;
	private int age;
	private int weight;
	private String city;
	private static Person person;
	
	private Person(){
		if(person != null) {
			throw new RuntimeException("Don't break it via Reflection");
		}
	}
	
	private Person(String name, int age, int weight, String city) {
		if(person != null) {
			throw new RuntimeException("Don't break it via Reflection");
		}
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.city = city;
	}
	
	public static Person getInstance() {
		if(Objects.isNull(person)) {
			person = new Person();
		}
		return person;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getWeight() {
		return weight;
	}

	public String getCity() {
		return city;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}