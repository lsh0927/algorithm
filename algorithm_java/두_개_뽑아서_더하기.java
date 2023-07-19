import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        //만든 정수의 중복을 제거하는데 Set 사용
        // 정렬한 뒤 배열로 반환하는데 Stream을 사용
        
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
      
    }
}