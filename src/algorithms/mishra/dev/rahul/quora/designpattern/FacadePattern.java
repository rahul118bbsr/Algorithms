/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.designpattern;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-Jul-2017 9:10:29 AM
 *
 */
public class FacadePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Computer().start();
	}

}

class Computer {
	private Processor processor;
	private HardDrive hardDrive;
	private Memory memory;
	
	public Computer() {
		this.processor = new Processor();
		this.hardDrive = new HardDrive();
		this.memory = new Memory();
	}
	
	public void start() {
		processor.run();
		hardDrive.bootUp();
		memory.load();
	}
	
}

class HardDrive {
	public void bootUp() {
		System.out.println("Hard Drive is Booting up");
	}
}

class Processor {
	public void run() {
		System.out.println("Processor is starting");
	}
}

class Memory {
	public void load() {
		System.out.println("Loading System Memory");
	}
}
