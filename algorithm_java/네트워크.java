 class Solution {

            // 한번의 DFS 가 독립된 방문 배열을 가지지 않음
            // 모든 노드를 순회하기 때문에 여러 DFS가 하나의 방문 배열을 공유해야함
            // 이 생각을 어떻게 해야하지?
            //computer와 연결된 모든 노드를 찾는 메서드
            private void visitAll(int computer, int[][] computers, boolean[] isvisited) {
                Stack<Integer> stack= new Stack<>();
                stack.push(computer);

                while (!stack.isEmpty()){
                    int c= stack.pop();

                    if (isvisited[c]) continue;
                    isvisited[c]=true;

                    // 전이 상태 생성
                    for (int next=0; next<computers[c].length;next++){
                        if (computers[c][next]==0) continue;
                        stack.push(next);
                    }
                }
            }



            public int solution(int n, int[][] computers) {

                boolean[] isVisited= new boolean[n];
                int answer = 0;


                for (int i=0;i<n;i++){
                    if (isVisited[i]) continue;
                    visitAll(i,computers,isVisited);
                    answer++;
                }

                return answer;
            }
        }

        import java.util.*;

class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit= new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visit[i]==false){
                answer++;
                DFS(i,computers,n);
            }
        }
        return answer;
    }
    private void DFS(int i, int[][]computers,int n){
        visit[i]=true;
        
        for(int j=0;j<n;j++){
            if(visit[j]==false && computers[i][j]==1){
                DFS(j,computers,n);
            }
        }
    }
}