public class 다음_큰_숫자 {
    
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        int k=n+1;
      
       
        
        
        while(countOnes(n)!=countOnes(k))//2진수로 바꿨을때 1의 갯수가 다르고 또한 n보다 클때
        {
            k+=1;
        }
        return k;
    }
     public static int countOnes(int num) {
             int count = 0; // initialize the counter to 0

             while (num > 0) {
                if (num % 2 == 1) {
                count++; // increment the counter if the current bit is 1
                }
                num /= 2; // shift the bits to the right
            }

            return count;
            }
}