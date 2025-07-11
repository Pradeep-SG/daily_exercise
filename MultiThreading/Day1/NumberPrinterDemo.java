package MultiThreading.Day1;

public class NumberPrinterDemo
{
	private static final Object LOCK = new Object();

	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new NumberPrinter(1, LOCK), "T1");
		Thread t2 = new Thread(new NumberPrinter(6, LOCK), "T2");
		Thread t3 = new Thread(new NumberPrinter(11, LOCK), "T3");

		t1.start();
		System.out.println(t1.getState());
		t2.start();
		System.out.println(t2.getState());
		t3.start();
		System.out.println(t3.getState());

		t1.join();
		t2.join();
		t3.join();
		System.out.println("All threads have finished execution");
	}
}
