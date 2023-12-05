class Solution {
            public long solution(int n, int[] times) {
                long start=0;
                long end= 1000000000000000000L;
                
                
                
                while (end>start){
                    long mid=(end+start)/2;
                    
                    if (isValid(mid,n,times))
                        end=mid;
                    else 
                        start=mid+1;
                }
                return start;
            }

            private boolean isValid(long mid, int n, int[] times) {
                long c=0;
                for (int time : times) {
                    c+=mid/time;
                    
                }
                return c>=n;
            }
        }