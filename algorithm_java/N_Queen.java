class Solution {
            //백트래킹
            //배열의 행에 대한 값은 퀸이 놓여져 있는 열을 의미
            static int [] board;
            static int answer = 0;

            public int solution(int n) {e
                board=new int[n];

                backTracking(0,n);
                return answer;
            }
            private static boolean vaild(int i){
                for(int j=0;j<i;j++){
                    if(board[i]==board[j]) return false;
                    if (Math.abs(i-j)==Math.abs(board[i]-board[j])) return false;
                }
                return true;
            }
            private static void backTracking(int depth, int n){
                if (depth==n){ //행
                    answer++;
                    return;
                }
                for (int i=0;i<n;i++){
                    board[depth]=i; //헤딩 depth(행)과 i열에 퀸을 놓을수 있는지 확인
                    if (vaild(depth)){
                        backTracking(depth+1,n);
                    }
                }
            }
        }