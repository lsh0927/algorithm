class Solution {
            public int[] solution(int n, int[] info) {

                HashMap<Integer,Integer> hm= new HashMap<>();
               // int sum=0; int b=0;
                int score1=0;
                for(int i=0;i<11;i++){
                    hm.put(10-i,info[i]);
//                    sum+=info[n];
//                    if(sum==n) {
//                        b=1;
//                    }
                    //개수가 n이 되면 break; -> 메모리를 위해?
                }
                for (Integer key : hm.keySet()) {
                    score1 += key;
                }
                //이제 라이언의 과녁 개수를 계산해야 함
                //첫번째: 가장 큰 점수 차로 승리할 것
                //두번째: 그 경우가 여러 가지 일 경우 가장 낮은 점수를 더 많이 맞힐 것
                //세번째: 이 점수를 맞힌 개수도 같을 경우, 계속해서 그 다음으로 낮은 점수를 더 많이 맞힌 경우를 리턴
                //우선 순위 큐를 이용?

                //가장 큰 점수 차로 승리할 방법
                //

                int[] answer = {};


                return answer;
            }
        }