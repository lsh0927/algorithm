import java.util.*;

class Solution {
    
    final char[] WORDS = {'A', 'E', 'I', 'O', 'U'};
    final int MAX_LENGTH = 5;
        
    public int solution(String word) {
        int answer = 0;
        
        List<String> elements = new ArrayList<>();
        
        for(int i=0; i<WORDS.length; i++){
            dfs(elements, String.valueOf(WORDS[i]));
        }    
        
        for(int i=0; i<elements.size(); i++){
            if(elements.get(i).equals(word)){
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    void dfs(List<String> elements, String str){
        if(str.length() > MAX_LENGTH) return;
        
        if(!elements.contains(str)) elements.add(str);
    
        for(int i=0; i<WORDS.length; i++){
            dfs(elements, str+WORDS[i]);
        }
    }
}

/*

import java.lang.Math;

class Solution {
    public int solution(String word) {
        int answer = word.length();
        int pos;
        for(pos = 0; pos < word.length(); pos ++){
            char c = word.charAt(pos);
            if(c=='A') continue;
            int temp = 0;
            for(int i = 0; i <= 4-pos; i++){
                temp += Math.pow(5,i);
            }
            answer += temp*val(c);
        }
        return answer;
    }

    public int val(char c){
        if(c=='E') return 1;
        else if(c=='I') return 2;
        else if(c=='O') return 3;
        else return 4;
    }
}
 */