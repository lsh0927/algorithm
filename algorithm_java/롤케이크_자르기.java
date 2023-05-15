import java.util.HashMap;
import java.util.*;
        //케이크를 잘랐을 때, 먹을 수 있는 토핑의 개수가 동일하도록
        //1.그냥 단순 sort로 비교하면, for문으로 index가 0~999999까지,
        //배열 sort를 해가면서 count하기 위한 for문이 또 필요-> 너무 오래 걸림
        
        //2.hashmap?
        
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //i를 기준으로 두 배열로 나눔
        for(int i=0;i<topping.length;i++)
        {
            int[] first= Arrays.copyOfRange(topping, 0, i);
            int a=count(first);
            
            
            int[] second = Arrays.copyOfRange(topping, i, topping.length);
            int b=count(second);
            
            if(a==b)
                answer++;   
        }
            return answer;
    }
    
    public static int count(int[] array) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        return set.size();
    }
}


//import java.util.HashSet;

/*class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        for (int i = 1; i < topping.length; i++) {
            HashSet<Integer> firstSlice = new HashSet<>();
            HashSet<Integer> secondSlice = new HashSet<>();

            for (int j = 0; j < i; j++) {
                firstSlice.add(topping[j]);
            }

            for (int j = i; j < topping.length; j++) {
                secondSlice.add(topping[j]);
            }

            if (firstSlice.size() == secondSlice.size()) {
                answer++;
            }
        }

        return answer;
    }
}
*/


//   1번째가 내가 짠거
//   2번째가 chat gpt의 도움으로 짠것
//   그런데 둘다 타임 에러 남... 심지어 두 번째가 더 느림..