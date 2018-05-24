
/**
 *
 * @author Faiz Ikhwan
 * Parallel
 */

public class Main 
{       
    static public int whatToSearch;
    
    public static void main(String[] args) throws Exception
    {        
        // To calculate runtime
        long startTime = System.currentTimeMillis();
        
        whatToSearch = 32000000;    // 20,880,340 
        
        try
        {
            Thread t1 = new Thread(new RunnableOne());        
            Thread t2 = new Thread(new RunnableTwo());   
            t1.start();
            t2.start(); 
        
            // Waiting for thread1 and thread2 to die
            while (true) 
            {
                try 
                {
                    t1.join();
                    t2.join();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();}
            }
        
            int index1 = RunnableOne.getResult();        
            int index2 = RunnableTwo.getResult();        
            int res;
            String position;
            if (index1>index2)
            {
                res = index1;
                position = "Thread 1";
            }
            else
            {
                res = index2+RunnableTwo.arr.length;
                position = "Thread 2";
            }        
                       
            // Print out the result
            System.out.println("\nNumber " + whatToSearch + " found at position " + res+" by "+position);      
    
        }catch(ArrayIndexOutOfBoundsException aioobe){}
        
                
        // To calculate runtime
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Runtime(millisecond):"+elapsedTime);    
    }                            
    
    // Return variable whatToSearch
    static int getWhatToSearch()
    {
        return whatToSearch;
    }                          
}
