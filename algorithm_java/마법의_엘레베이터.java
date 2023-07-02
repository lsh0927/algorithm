// import java.util.*;

// class Solution {
//     public int solution(int storey) {
//         int answer = 0;
        
//          ArrayList<Integer> digits = new ArrayList<>();

//         // 각 자리를 나누어서 ArrayList에 저장
//         while (storey > 0) {
//             int digit = storey % 10; // 가장 오른쪽 자리의 숫자 가져오기
//             digits.add(0, digit); // ArrayList의 맨 앞에 추가 (역순으로 저장)
//             storey /= 10; // 다음 자리로 이동
//         }
      
//         //이제 Arraylist의 각 자리 수를 꺼내서, 그 자리가 5보다 크거나 같으면 
//         for(int j=0; j<digits.size();j++)
//         {
//             if(digits.get(j)>5)
//             {
//                 int ch1=digits.get(j-1);
//                 ch1++;
//                 digits.set(j-1,ch1);
                
//                 int ch2=digits.get(j);
//                 ch2=10-ch2;
//                 digits.set(j,ch2);
//             }
//         }
//         for (int num : digits) {
//             System.out.println(" value "+num);
//         }
//            for (int num : digits) {
//             answer += num;
//         }
//         return answer;
//     }
// }



// import java.util.*;

// class Solution {
//     public int solution(int storey) {
//         int answer = 0;
        
//          ArrayList<Integer> digits = new ArrayList<>();

//         // 각 자리를 나누어서 ArrayList에 저장
//         while (storey > 0) {
//             int digit = storey % 10; // 가장 오른쪽 자리의 숫자 가져오기
//             digits.add(0, digit); // ArrayList의 맨 앞에 추가 (역순으로 저장)
//             storey /= 10; // 다음 자리로 이동
//         }
      
//          int answer2 = 0;
        
        
//         //이제 Arraylist의 각 자리 수를 꺼내서, 그 자리가 5보다 크거나 같으면 
//         for(int j=0; j<digits.size();j++)
//         {
//             if(digits.get(j)>5)
//             {
//                 int s=20-digits.get(j);
//                 int sa=s/10;
//                 int sb=s%10;
//                 digits.set(j,sa+sb);
//             }
//         }
       
        
        
//         for (int num : digits) {
//             System.out.println(" value "+num);
//         }
//            for (int num : digits) {
//             answer += num;
//         }
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int cmp=0;
        int res=0;
        int sum=0;
        String numberStr = String.valueOf(storey);
        int i=0;
        while(i<numberStr.length())
        {
            if(Character.getNumericValue(numberStr.charAt(i))>5)
            {  
                String subStr = numberStr.substring(i);
                cmp=Integer.parseInt(subStr);

                if(i!=0 && res==0)
                {
                    res=Integer.valueOf(numberStr)-cmp;
                }
                else if(res!=0)
                {
                    res-=cmp;
                }
                int ch=1;
                for(int k=i;k<numberStr.length();k++)
                    ch*=10;
                ch*=2;
                res+=ch-cmp;
                numberStr = String.valueOf(res);
                i++;
            }
            else{
                i++;
            }
        }
           
          int number = Integer.valueOf(numberStr);
        
            System.out.println(number);        
        
        
          while (number > 0) {
                int num = number % 10;  // 현재 자리의 숫자를 얻기 위해 10으로 나눈 나머지
                sum += num;  // 자리의 숫자를 더하기
                number /= 10;  // 다음 자리로 이동하기 위해 10으로 나누기
                answer=sum;
            }
        
        return answer;
    }
    
    
    
//     static int makearray(int storey){
//          ArrayList<Integer> arr = new ArrayList<>();
//         while (storey > 0) {
//             int arr = storey % 10; // 가장 오른쪽 자리의 숫자 가져오기
//             arr.add(0, arr); // ArrayList의 맨 앞에 추가 (역순으로 저장)
//             storey /= 10; // 다음 자리로 이동
//         }
//         return arr; 
//     }
}