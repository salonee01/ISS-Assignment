class SenderWithThreads extends Thread   
{   
  private String msg;   
  Sender sd;   
  
  // Receiver method to receive a message object and a message to be sent   
  SenderWithThreads(String m, Sender obj)  
  {   
    msg = m;  
    sd = obj;   
  }   
  
  public void run()   
  {   
    // Checks that only one thread sends a message at a time.   
    synchronized(sd)   
    {   
      // synchronizing the sender object   
      sd.SenderMsg(msg);  
    }   
  }   
}   