import java.util.concurrent.*;
 import java.util.Random;      

 public class MyExecutor {
	 public static void main(String args[]) {
		 Random random = new Random();

		 // Create an executor that holds 4 threads
		 ExecutorService executor =  Executors.newFixedThreadPool(4);

		 // Buffer wait time by 600ms
		 int waitTime = 600;

		 for (int i = 0; i < 10; i++) {
			 String taskName = "Task Print: " + i;
			 // Set time as random integer with 500 as max value
			 int time = random.nextInt(500);
			 // Sum up wait times to know when to shutdown
			 waitTime += time;
			 // Give task to runnable
			 Runnable runner = new TaskPrint(taskName, time);
			 System.out.println("Adding: " + taskName + " / " + time);
			 executor.execute(runner);
		 }

		 try {
			 // Sleep thread before shutting down executor 
			 // to make sure all threads are done with tasks
			 Thread.sleep(waitTime);
			 executor.shutdown();
			 // Wait termination with wait time to ensure termination
			 executor.awaitTermination (waitTime, TimeUnit.MILLISECONDS);
		 }
		 catch (InterruptedException ignored) {
		 }
	 }
 }   