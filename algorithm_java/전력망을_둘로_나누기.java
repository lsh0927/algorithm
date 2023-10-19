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