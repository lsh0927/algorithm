class Solution {
            public int solution(int[][] targets) {
                Arrays.sort(targets,(a,b)->a[0]-b[0]);
                int cnt=0;
                int last=-1;
                for(int i=0;i<targets.length;i++){
                    int[] missile=targets[i];
                    if(missile[0]>last){
                        cnt++;
                        last=missile[1]-1;
                    }
                    else if(missile[1]-1>last){
                        last=missile[1]-1;
                    }
                }
                return cnt;
            }
        }