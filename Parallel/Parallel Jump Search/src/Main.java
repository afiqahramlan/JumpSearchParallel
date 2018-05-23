
/**
 *
 * @author Faiz Ikhwan
 */

public class Main 
{       
    static public int whatToSearch;
    
    public static void main(String[] args) throws Exception
    {        
        // To calculate runtime
        long startTime = System.currentTimeMillis();
        
        whatToSearch = 1880;    // 2,880,340 
                      
        Thread t1 = new Thread(new RunnableOne());        
        Thread t2 = new Thread(new RunnableTwo());   
        t1.start();
        t2.start();        
        int index1 = RunnableOne.getResult();        
        int index2 = RunnableTwo.getResult(); 
        Thread.sleep(1000);
        int res = (index1>index2) ? index1 : index2;   
               
        System.out.println(index1>index2);
        // Print out the result
        System.out.println("\nNumber " + whatToSearch + " is at index " + res);      
                
        // To calculate runtime
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Runtime(Sec):0.0"+elapsedTime);    
    }                            
    
    // Return variable whatToSearch
    static int getWhatToSearch()
    {
        return whatToSearch;
    }                          
}
