
/**
 *
 * @author Faiz Ikhwan
 */
public class RunnableTwo implements Runnable
{
    static public int[] arr = new int[32000000];   //32,000,000
    static int res;
    
    public void run() // Jump search algo
    {
        initInThreadTwo(1, arr.length);               
        int x = Main.getWhatToSearch();        // 20,880,340 
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
                res = -1;            
        }
        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x) 
        {
            prev++;
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n)) 
                res = -1;            
        }
        // If element is found
        if (arr[prev] == x) 
            res = prev;        
        //res = -1;  
        System.out.println("T2"+res);
    }
    
    static int getResult()
    {
        return res;
    }    
    
    static void initInThreadTwo(int start, int end)   //16,000,001 - 32,000,000 
    {
        for(int i=start; i<end-1; i++)
            arr[i] = i + 16000000;
    }
}
