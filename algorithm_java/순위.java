import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        class Solution {
            public int solution(int n, int[][] results) {
                int answer = 0;

                boolean[][] graph= new boolean[n][n];
                for(int[] edge:results){
                    int u=edge[0]-1;
                    int v=edge[1]-1;
                    graph[u][v]=true;
                }
                //경기 결과를 그래프로 나타냄
                //
                int count=0;
                for(int u=0;u<n;u++){
                    int wins=countForward(u,graph,new boolean[n])-1;
                    int loses=countBackward(u,graph,new boolean[n])-1;
                    if(wins+loses+1 ==n)
                        count++;
                }
                return count;
            }
            private int countForward(int u, boolean[][]graph, boolean[] isVisited){
                int count=1;
                for(int v=0;v<graph[u].length;v++){
                    if(!graph[u][v]||isVisited[v]) continue;
                    isVisited[v]=true;
                    count+=countForward(v,graph,isVisited);
                }

                //재귀 진행
                return count;
            }
            private int countBackward(int u, boolean[][]graph, boolean[] isVisited){
                int count=1;

                for(int v=0;v<graph.length;v++){
                    if(!graph[v][u]||isVisited[v]) continue;
                    isVisited[v]=true;
                    count+=countBackward(v,graph,isVisited);
                }

                //재귀 진행
                return count;
            }
        }
    }

}
//선수의 수 n,
//경기 결과
// 입력으로 들어온 경기 결과로 그래프를 구성, 재귀를 이용하여 화살표를 따라가면서 이긴선수 수와, 진 선수 수를 세야함
//그래프는 2차원 불리안 배열

//아직 이해가 잘 안댄다 

//2번째 시도. DFS로 진사람을 정점으로 정하고 그 사람이 이겻는지를 확인해서 깊이 우선 탐색을 한다.