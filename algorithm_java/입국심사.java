import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

        class Solution {
            public long solution(int n, int[] times) {
                long start=1;
                long end=1000000000000000000L;
                while(end>start){
                    long t=(start+end)/2;
                    if(isVaild(t,n,times)){
                        end=t;
                    }
                    else {
                        start=t+1;
                    }
                }
                return start;
            }
            private boolean isVaild(long t, int n, int[] times)
            {
                long c=0;
                for(int time: times){
                    c+=t/time;
                }
                return c>=n;
            }
        }

 