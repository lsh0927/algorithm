import java.util.*;

class Solution {
            public int solution(int distance, int[] rocks, int n) {
                rocks= Arrays.copyOf(rocks,rocks.length+1);
                rocks[rocks.length-1]=distance;
                Arrays.sort(rocks);

                int start=1;
                int end=distance+1;
                while (end-start>1) {

                  int d=(start+end)/2;
                  if(isVaild(d,rocks,n)) {
                      start = d;
                  }
                  else {
                      end=d;
                  }
                }
                return start;
            }
            private boolean isVaild(int d, int[] rocks, int n){
                int removed=0;
                int last=0;
                for(int rock: rocks){
                    if(rock-last<d){
                        removed++;
                        continue;
                    }
                    last=rock;
                }
                return removed<=n;
            }
        }