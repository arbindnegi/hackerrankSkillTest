package hackerrank.advanced;

public class JavaThreadDemo implements Runnable {

	public static void main(String[] args) {
		
		Thread t = new Thread(new JavaThreadDemo());
		t.run();
		t.run();
		t.start();
		
		//output: Running will be printed 3 times
	}

	@Override
	public void run() {
		
		System.out.println("Running");
	}

}
