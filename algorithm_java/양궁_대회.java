import java.util.*;  
    /*
           점수는 0~10까지 11개, 중복 조합 계산시 190000이하로 완전탐색이 좋음
         */

        //1. 기준 정하기
        class Solution {
            public int[] solution(int n, int[] info) {
                int[] ryan= ryan(0,new int[11],n, info);
                
                if (ryan==null)
                    return new int[] {-1};
                
                return ryan;
                
            }

            //점수 차를 비교
            private int scoreDiff(int[] apeach, int[] ryan){
                int diff=0;

                for (int i=0;i<apeach.length;i++){
                    if (apeach[i]==0 && ryan[i]==0)
                        continue;

                    if (apeach[i]>=ryan[i]){
                        diff-=10-i;
                    }
                    else {
                        diff+=10-i;
                    }
                }

                return diff;
            }
            //더 낮은 점수를 더 많이 맞춘 경우 채택
            // 더 낮은 점수가 들어있는 점수 배열의 뒤쪽부터 순회
            private boolean isPrior(int[] base, int[] comp){
                for (int i=10; i>=0;i--){
                    if (comp[i]==base[i])continue;
                    return comp[i]>base[i];
                }
                return false;
            }

            //2. 완전 탐색
            //앞서 정의한 두 메서드를 사용하여 가장 우선순위가 높은 경우
            /*
            상태 정의와 종료조건, 점화식 정의
             */

            /*
            상태: (index,hits,n)
            배열 hits의 index번째 부터 N개의 화살을 쏠 때
            가장 우선순위가 높은 과녁 점수 배열
             */

            /*
            종료 조건:
            모든 점수에 대한 화살 개수가 정해지면 종료
            쏘지 않고 남은 화살이 있다면 무효->null 반환
            모든 화살을 소모했다면 라이언이 이기는 경우에만 배열 hits 반환
             */

            /*
            점화식 정의
             */

            private int[] ryan(int index, int[] hits, int n, int[] apeach){

                if (index== hits.length){
                    if (n>0) return null;
                    if (scoreDiff(apeach,hits )<=0)
                        return null;
                    return Arrays.copyOf(hits,hits.length);

                }

                int maxDiff=0;
                int[] result= null;


                for (int hit=0;hit<= n; hit++){
                    hits[index]=hit;
                    int[] ryan=ryan(index+1,hits,n-hit, apeach);
                    if (ryan==null)
                        continue;

                    int diff= scoreDiff(apeach,ryan);
                    if (diff>maxDiff || (diff ==maxDiff && isPrior(result,ryan))){
                        maxDiff=diff;
                        result=ryan;
                    }
                }

                return result;
            }
        }


