import java.util.*;
class Solution {
            ArrayList<Integer>[] graph;
            boolean[] visit;
            int count;

            public int solution(int n, int[][] wires) {
                int answer = Integer.MAX_VALUE;
                int edgeIdx = 0;
                graph = new ArrayList[n+1];
                while (edgeIdx < n - 1) {
                    for (int i = 1; i <= n; i++) {
                        graph[i] = new ArrayList<>();
                    }

                    for (int i = 0; i < wires.length; i++) {
                        if (i == edgeIdx) continue;

                        int a = wires[i][0];
                        int b = wires[i][1];

                        graph[a].add(b);
                        graph[b].add(a);
                    }

                    visit = new boolean[n+1];
                    visit[1] = true;
                    count = 1;
                    dfs(1);
                    answer = Math.min(answer, Math.abs(n - 2 * count));
                    edgeIdx++;
                }
                return answer;
            }

            public void dfs(int cur) {
                for (int n : graph[cur]) {
                    if (!visit[n]) {
                        visit[n] = true;
                        count++;
                        dfs(n);
                    }
                }
            }
        }



/*
import java.util.*;

public class Main {

    public static void main(String[] args) {
        class Solution {
            public int solution(int n, int[][] wires) {

                List<Integer> list= new ArrayList<>();
                int first=0;
                int second=0;
                for (int[] wire : wires) {
                    for (int i=1; i<=n; i++){
                       list.add(wire[0]);
                       list.add(wire[1]);
                    }
                }

                first=getValue(list);
                while (list.contains(first))
                    list.remove(first);
                
                second=getValue(list);


                return first-second;
            }

            private int getValue(List<Integer> list) {
                int max=0;

                for (Integer integer : list) {
                    int count= Collections.frequency(list,integer);
                    if (max<count)
                        max=count;
                }
                return max;
            }
        }
    }
}

 */        


 import java.util.*;

public class Solution {

    private final List<List<Integer>> adj = new ArrayList<>();
    private boolean[] check;

    public int solution(int n, int[][] wires) {
        int[][] tower = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            adj.get(wire[0]).add(wire[1]);
            adj.get(wire[1]).add(wire[0]);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> list = adj.get(i);
            Arrays.fill(check, false);
            check[i] = true;
            for (Integer j : list) {
                tower[i][j] = count(j) + 1; // i번 타워에서 j번 타워방향 자식들의 수
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (tower[i][j] != 0) {
                    // i번 타워에서 j번 타워방향 자식들 수와
                    // j번 타워에서 i번 타워방향 자식들 수의 차이 최소값 구하기
                    min = Math.min(Math.abs(tower[i][j] - tower[j][i]), min);
                }
            }
        }
        return min;
    }

    private int count(int num) {
        int sum = 0;
        check[num] = true;
        List<Integer> list = adj.get(num);
        for (Integer next : list) {
            if (!check[next]) {
                sum += count(next);
            }
        }
        return sum + (list.size() - 1); // 진행방향 타워 하나 빼주기
    }


}

/*
 *   *
 * import java.util.*;

public class Main {

    public static void main(String[] args) {
        class Solution {

            static public boolean[][] edges;
            static public boolean[] visited;
            static int N;

            public int solution(int n, int[][] wires) {

                N = n + 1;
                int M = wires.length;
                edges = new boolean[N][N];
                visited = new boolean[N];


                for (int i = 0; i < M; i++) {
                    int a = wires[i][0];
                    int b = wires[i][1];

                    edges[a][b] = true;
                    edges[b][a] = true;

                }

                int res = Integer.MAX_VALUE;

                for (int i = 0; i < M; i++) {
                    Arrays.fill(visited, false);
                    int a = wires[i][0];
                    int b = wires[i][1];
                    edges[a][b] = false;
                    edges[b][a] = false;

                    int aCnt = dfs(a, 0);
                    int bCnt = dfs(b, 0);
                    res = Math.min(res, Math.abs(aCnt - bCnt));

                    edges[a][b] = true;
                    edges[b][a] = true;

                }

                return res;
            }
            public int dfs(int cur, int cnt){
                if (visited[cur])
                    return 0;
                visited[cur]=true;

                int sum=1;

                for (int i=0;i<N;i++){
                    if (!edges[cur][i]){
                        continue;
                    }
                    sum+=dfs(i,cnt+1);
                }
                visited[cur]=false;
                return sum;
            }
        }
    }
}
 */