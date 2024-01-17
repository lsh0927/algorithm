import java.util.ArrayList;
import java.util.List;

class Solution {
    private static List<int[]> ansList;

    public static int[][] solution(int n) {

        ansList = new ArrayList<>();
        
        dfs(n, 1,3, 2);


        int[][] answer = new int[ansList.size()][];

        for(int i=0; i<ansList.size(); i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }

    private static void dfs(int n, int start, int to, int mid) {
        if(n == 1){
            ansList.add(new int[]{start, to});
            return;
        }
        // 1번 기둥의 n-1개를 3번을 걸쳐 2번으로 이동시킴
        dfs(n-1, start, mid, to);

        // 가장 큰 n을 1에서 3으로 이동시킴
        ansList.add(new int[]{start, to});

        // 2번의 기둥의 n-1개를 1번을 걸쳐 3번으로 이동시킴
        dfs(n-1, mid, to, start);
    }
}


/*
 * import java.util.*;
class Solution {

            //상태: (n,from, to)
            //n개의 원반을 기둥 from에서 기둥 to로 옮기는 과정
            // 종료 조건 (1,from,to) = [[from,to]]
            //점화식 (n,from,to)=(n-1,from,empty)+(1,from,to)+(n-1,empty,to)
            //단 empty=6-from-to

            public int[][] solution(int n) {
                return hanoi(n,1,3).toArray(new int[0][]);
            }
            private List<int[]> hanoi(int n, int from, int to){
                //상태를 매개변수로 받음
                //종료 조건은 n값이 1일때 from-> to로 이동시키는 것만 포함한 과정을 반환
                if(n==1)
                    return List.of(new int[] {from,to});

                int empty=6-from-to;

                List<int[]> result= new ArrayList<>();
                result.addAll(hanoi(n-1,from,empty));
                result.addAll(hanoi(1,from,to));
                result.addAll(hanoi(n-1,empty,to));
                return result;
            }
        }
 */