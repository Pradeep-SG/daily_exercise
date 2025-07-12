package MultiThreading.Day2;

import java.util.*;
import java.util.concurrent.*;

public class ExecutorInvokeAllDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService executor = Executors.newFixedThreadPool(3);

		Callable<String> task1 = () -> {
			Thread.sleep(5000);
			return Thread.currentThread().getName() + " → Task 1 done";
		};

		Callable<String> task2 = () -> {
			Thread.sleep(10000);
			return Thread.currentThread().getName() + " → Task 2 done";
		};

		Callable<String> task3 = () -> {
			Thread.sleep(8000);
			return Thread.currentThread().getName() + " → Task 3 done";
		};

		List<Callable<String>> tasks = Arrays.asList(task1, task2, task3);

		// Submit all tasks at once
		List<Future<String>> results = executor.invokeAll(tasks);

		for(Future<String> future : results)
		{
			try
			{
				System.out.println(future.get());
			}
			catch(ExecutionException e)
			{
				System.out.println("Task failed: " + e.getCause());
			}
		}

		executor.shutdown();
	}
}