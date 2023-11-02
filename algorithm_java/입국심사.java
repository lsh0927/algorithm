 class Solution {
            public long solution(int n, int[] times) {
                long start = 0;
                long end=1000000000000000000L;
                
                // 조건을 만족하는 값 중 가장 작은 값을 찾는 이진 탐색을 구현해야 함
                // 범위 표기는 [start,end]가 되고, 이에 따라 end 변수에는 범위의
                // 실제 최댓값인 10억이 들어감
                
                while(end>start)
                {
                    long t= (start+end)/2;
                    //정답 검사 및 범위 좁히기
                    if(isValid(t,n,times))
                        end=t;
                    else start= t+1;
                }
                
                return start;
            }
            private boolean isValid(long t, int n, int[] times){
                long c=0;
                for (int time : times) {
                    c+=t/time;
                }
                return c>=n;
            }
        }