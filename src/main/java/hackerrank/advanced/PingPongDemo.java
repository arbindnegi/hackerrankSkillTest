package hackerrank.advanced;

class PingPong {
	private volatile boolean flag = false;
	private static final int MAX_COUNT = 10;
	private volatile int count = 1;

	public synchronized void printPing() {

		while (count <= MAX_COUNT) {
			while (flag) {
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

			System.out.println(count + " Ping");
			flag = true;
			count++;
			notifyAll();
		}
	}

	public synchronized void printPong() {
		while (count <= MAX_COUNT) {
			while (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

			System.out.println(count + " Pong");
			flag = false;
			count++;
			notifyAll();
		}
	}

}

public class PingPongDemo {

	public static void main(String[] args) throws InterruptedException {
		PingPong obj = new PingPong();
		Thread pingThread = new Thread(() -> {
			obj.printPing();
		});
		Thread pongThread = new Thread(() -> {
			obj.printPong();
		});
		pingThread.start();
		pongThread.start();

		Thread.sleep(5000);

	}

}
