
public class SynchronizedMultithreading  
{   
  public static void main(String args[])   
  {   
    Sender sender = new Sender();   
    SenderWithThreads sender1 = new SenderWithThreads( "Hello " , sender);  
    SenderWithThreads sender2 =  new SenderWithThreads( "This is synchronized block ", sender);  
  
    // Start two threads of SenderWThreads type   
    sender1.start();   
    sender2.start();   
  
    // wait for threads to end   
    try  
    {   
      sender1.join();   
      sender2.join();   
    }   
    catch(Exception e)   
    {   
      System.out.println("Interrupted");   
    }   
  }   
}  