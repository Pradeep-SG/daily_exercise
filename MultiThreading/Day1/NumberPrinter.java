package MultiThreading.Day1;

public class NumberPrinter implements Runnable{
	private static final Object LOCK = new Object();
	private int start;

	NumberPrinter(int start)
	{
		this.start = start;
	}

	@Override public void run()
	{
		synchronized(LOCK)
		{
			for(int i = start; i < start + 5; i++)
			{
				System.out.println(Thread.currentThread().getName() + " -> " + i);
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException e)
				{
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		Thread t1 = new Thread(new NumberPrinter(1), "T1");
		Thread t2 = new Thread(new NumberPrinter(6), "T2");
		Thread t3 = new Thread(new NumberPrinter(11), "T3");

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
