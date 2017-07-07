package algorithms.mishra.dev.rahul;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Person p6 = new Person();
		Person p7 = new Person();
		Person p8 = new Person();
		
		System.out.println(Person.instanceCount_S);
		System.out.println(p1.instanceCount_I);
		
	}

}

class Person {
	static int instanceCount_S;
	 int instanceCount_I;
	
	public Person() {
		//
		instanceCount_S++;
		instanceCount_I++;
	}
}