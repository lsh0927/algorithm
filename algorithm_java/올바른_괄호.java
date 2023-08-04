class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}

/*
 * import java.util.*;

class Solution {
            boolean solution(String s) {
                Stack<Character> stack= new Stack<>();
                
                for(char c:s.toCharArray()){
                    switch (c){
                        case '(' ->stack.push(c);
                        case  ')' -> {
                            if(stack.empty())
                                return false;
                            stack.pop();
                        }
                        
                    }
                }
                return stack.isEmpty();
            }
        }
 */