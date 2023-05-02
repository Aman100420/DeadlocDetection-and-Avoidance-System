class deadlock
{
  public static void main(String[] args) 
  {
    final String resource1 = "JAVA PROGRAMMING";
    final String resource2 = "OPERATING SYSTEM";
    Thread t1 = new Thread() 
    {
      public void run() 
      {
        synchronized(resource1) 
        {
          System.out.println("Thread 1: Locked resource1: executed completed");
          try 
          {
            Thread.sleep(1000);
          }
          catch(Exception e) {}
          synchronized(resource2) 
          {
            System.out.println("Thread 1: Locked resource2: executed completed");
          }
        }
      }
    };
    
    Thread t2 = new Thread() 
    {
      public void run() 
      {
        synchronized(resource1) 
        {
          System.out.println("Thread 2: Locked resource1: executed completed");
          try 
          {
            Thread.sleep(1000);
          } 
          catch(Exception e) {}
          synchronized(resource2) 
          {
            System.out.println("Thread 2: Locked resource2: executed completed");
          }

        }
      }
    };

    t1.start();
    t2.start();
  }
}