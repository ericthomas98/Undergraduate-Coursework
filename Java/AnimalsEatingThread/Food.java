public class Food {

   synchronized void eat(long sleep) {
       try {
           Thread.sleep(sleep);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}