import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> factorList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                factorList.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        int[] answer = factorList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}