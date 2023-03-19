import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder M = new StringBuilder(s);
        int i = 0;
        int length = M.length();
        while (i < length - 1) { //앞에서대로 처리하는게 문제가 되면, binary 탐색 같은걸로 겹치는 문자열을 찾아야하나?
            
            if (M.charAt(i) == M.charAt(i + 1)) {
                M.deleteCharAt(i);
                M.deleteCharAt(i);
                length = M.length();
                i=0;
            }
            else{
                i++;
            }
        }

        if (M.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}