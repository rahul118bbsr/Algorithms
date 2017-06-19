import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Created by aleesha on 27/05/17.
 */
public class Lambda {

    public static void main(String[] args) {

        Animal a = new Dog();
        a.print();
    }


}

class Animal {
    protected int weight = 12;
    public void print(){}
}

class Dog extends Animal {
	protected int weight = 20;
	
	public void print() {
		System.out.println(weight);
		System.out.println(super.weight);
	}
}
