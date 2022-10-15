import java.util.*;

class Solution {
    public Boolean isPrime(int x){
        int i;
        int count=0;
        for(i=1;i<=x;i++)
        {
            if(x%i==0)
                count++;      
        }
         if(count==2)
             return true;
         else
             return false;
    }
    public int[] solution(int n) {
       
        List<Integer> list = new ArrayList<>();
        
        int i;
        
        for(i=1;i<=n;i++)
        {
            if(isPrime(i)==true)
            {
                if(n%i==0)
                {
                   list.add(i);
                }
            }
        }
    
        int[] arr1 = new int[list.size()];
        
         for (int a = 0 ; a < list.size() ; a++)
             {
                 arr1[a] = list.get(a).intValue();
             }
       
       
         return arr1;
    }
    
}


