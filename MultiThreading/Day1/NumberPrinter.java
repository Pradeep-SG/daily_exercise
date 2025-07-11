package MultiThreading.Day1;

public class NumberPrinter implements Runnable{
	private final int start;
	private final Object lock;

	NumberPrinter(int start, Object lock)
	{
		this.start = start;
		this.lock = lock;
	}

	@Override public void run()
	{
		synchronized(lock)
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
}
