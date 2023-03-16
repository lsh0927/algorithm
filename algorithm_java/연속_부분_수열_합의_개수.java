import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int start = 1;
        while(start < elements.length){
            for (int i = 0; i < elements.length; i++){
                int value = 0;
                for (int j = i; j < i+start; j++){
                    value += elements[j%elements.length];
                }
                set.add(value);
            }
            start++;
        }
        int sum = 0;
        for (int i = 0; i < elements.length; i++)
            sum += elements[i];

        set.add(sum);

        return set.size();
    }
}
