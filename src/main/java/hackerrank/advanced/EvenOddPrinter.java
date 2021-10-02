package hackerrank.advanced;

class EvenOdd {
	private volatile boolean flag = false;
	private static final int MAX_COUNT = 10;
	private volatile int count = 1;

	public synchronized void printOdd() {

		while (count <= MAX_COUNT) {
			while (flag) {
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

			System.out.println(count);
			flag = true;
			count++;
			notifyAll();
		}
	}

	public synchronized void printEven() {
		while (count <= MAX_COUNT) {
			while (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

			System.out.println(count);
			flag = false;
			count++;
			notifyAll();
		}
	}

}

public class EvenOddPrinter {

	public static void main(String[] args) throws InterruptedException {
		EvenOdd obj = new EvenOdd();
		Thread oddTask = new Thread(() -> {
			obj.printOdd();
		});
		Thread evenTask = new Thread(() -> {
			obj.printEven();
		});
		oddTask.start();
		evenTask.start();

		Thread.sleep(5000);

	}

}
