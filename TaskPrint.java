public class TaskPrint implements Runnable {
     private final String name;
     private final int delay;

     public TaskPrint(String name, int delay) {
       this.name = name;
       this.delay = delay;
     }
     public void run() {
       System.out.println("Starting: " + name + " Inside : " + Thread.currentThread().getName());
       try {
         Thread.sleep(delay);
       } catch (InterruptedException ignored) {
       }
       System.out.println("Done with: " + name + " Inside : " + Thread.currentThread().getName());
     }
   } 