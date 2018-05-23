
/**
 *
 * @author Faiz Ikhwan
 */

public class Main 
{   
    static int[] arr = new int[64000000];    //64,000,000
    static public int whatToSearch;
    
    public static void main(String[] args) throws Exception
    {        
        // To calculate runtime
        long startTime = System.currentTimeMillis();
        
        whatToSearch = 20880340;    // 20,880,340                 
        
        insertValueInArraySequential();                
        int res = jumpSearchSequential(arr, whatToSearch);        
        
        // Print out the result
        System.out.println("\nNumber " + whatToSearch + " is at index " + res);      
                
        // To calculate runtime
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Runtime(Sec):0.0"+elapsedTime);                        
    }                                
    
    // Assign sorted value in the array (uncomment if want to user sequential)
    static void insertValueInArraySequential()
    {        
        for(int i=0; i<arr.length; i++)                   
            arr[i] = i;        
    }    
       
    // Sequential jump search
    public static int jumpSearchSequential(int[] arr, int x) 
    {
        int n = arr.length;
        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));
        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) 
        {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) 
                return -1;            
        }
        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x) 
        {
            prev++;
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n)) 
                return -1;            
        }
        // If element is found
        if (arr[prev] == x) 
            return prev;        
        return -1;
    }        
}
