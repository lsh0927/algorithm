// import java.util.Arrays;
// import java.util.Collections;

// class Solution {
//     public String solution(int[] numbers) {
//         String answer = "";
        
//         Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
//         int []arr= new int[numbers.length];
        
//         for(int i=0;i<num.length;i++)
//         {
//             while(num[i]<10)
//             {
//                 int temp2=num[i];
//                 num[i]/=10;
//                 arr[i]=temp2%10; 
//             }
               
//         }     
        
//         Arrays.sort(num,Collections.reverseOrder());
        
//          for(int i=0;i<num.length;i++)
//         {
//             System.out.println(num[i]);     
//         }
        
//         return "";
//         //배열은 int형이지만, 정답은 string형으로 바꾸어 제출해야한다 (int의 범위초과를 고려)
     
//     }
// }

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String ans = "";
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }
}