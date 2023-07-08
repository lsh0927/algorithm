class Solution {
    static public int solution(String[] want, int[] number, String[] discount) {
     int answer = 0;
     for(int i=0;i<discount.length-9;i++) {
         int j;
         for(j=0;j<want.length;j++) {
             int check=0;
             for(int k=i;k<i+10;k++) {
                 if(discount[k].equals(want[j])) check++;
             }        
             if(check<number[j]) {
                  break;
             }
         }
        if(j==want.length) answer ++;
     }
     return answer;
 }
}

/*
 * import java.util.*;

class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            int left = 0;
            int right = 9;
            Map<String, Integer> map = new HashMap<>();
            for(int i =0;i<10;i++) map.put(discount[i], map.getOrDefault(discount[i],0)+1);
            while(right < discount.length){
                if(check(map,want,number)) answer++;

                right++;
                if(right < discount.length)
                    map.put(discount[right], map.getOrDefault(discount[right],0)+1);
                map.put(discount[left],map.get(discount[left])-1);
                left++;
            }

            return answer;
        }
        private boolean check(Map<String,Integer> map,String[] want,int[] number){
            for(int i =0;i<want.length;i++){
                if(map.getOrDefault(want[i],0) != number[i]) return false;
            }
            return true;
        }
    }
 */