import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        int []arr= new int[numbers.length];
        
        for(int i=0;i<num.length;i++)
        {
            while(num[i]<10)
            {
                int temp2=num[i];
                num[i]/=10;
                arr[i]=temp2%10; 
            }
               
        }     
        
        Arrays.sort(num,Collections.reverseOrder());
        
         for(int i=0;i<num.length;i++)
        {
            System.out.println(num[i]);     
        }
        
        return "";
        //배열은 int형이지만, 정답은 string형으로 바꾸어 제출해야한다 (int의 범위초과를 고려)
     
    }
}