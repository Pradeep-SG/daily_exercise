package MultiThreading.Day2;

import java.util.concurrent.*;

public class ExecutorDemo
{
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		// Step 1: Create ExecutorService with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Step 2: Define Callable tasks
		Callable<String> task1 = () -> {
			Thread.sleep(500);
			return Thread.currentThread().getName() + " → Task 1 completed";
		};

		Callable<String> task2 = () -> {
			Thread.sleep(1000);
			return Thread.currentThread().getName() + " → Task 2 completed";
		};

		Callable<String> task3 = () -> {
			Thread.sleep(1500);
			return Thread.currentThread().getName() + " → Task 3 completed";
		};

		// Step 3: Submit tasks
		Future<String> f1 = executor.submit(task1);
		Future<String> f2 = executor.submit(task2);
		Future<String> f3 = executor.submit(task3);

		// Step 4: Get and print results
		System.out.println(f1.get());
		System.out.println(f2.get());
		System.out.println(f3.get());

		// Step 5: Shutdown
		executor.shutdown();
		System.out.println("All tasks completed.");
	}
}