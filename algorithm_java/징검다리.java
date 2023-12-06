import java.util.*;
class Solution {
            public int solution(int distance, int[] rocks, int n) {

                rocks= Arrays.copyOf(rocks,rocks.length+1);
                rocks[rocks.length-1]=distance;
                Arrays.sort(rocks);
                
                int start= 1;
                int end=distance+1;

                //이진 탐색 범위는 도착 지점까지 거리인, 1~distance까지임
                //[start,end)를 사용해야 함

                while (end-start>1){
                    int d= (start+end)/2;

                    //d 조건 검사 후에 범위 좁히기
                    if (isValid(d,rocks,n))
                        start=d;
                    else 
                        end=d;
                }

               return start;
            }
            private boolean isValid(int d, int[] rocks, int n){
                int removed=0; //제거한 바위 개수
                int last=0; //마지막 바위 위치
                
                //바위 위치를 모두 순회하면서, 바위 사이의 거리가 d보다 작을 경우 제거
                for (int rock : rocks) {
                    if (rock-last<d){
                        removed++;
                        continue;
                    }
                    last=rock;
                }
                return removed<=n;
            }
        }