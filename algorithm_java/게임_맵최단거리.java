 class Solution {

            private static class State{
                public final int x;
                public final int y;
                public final int step;

                public State(int x, int y, int step) {
                    this.x = x;
                    this.y = y;
                    this.step = step;
                }
            }
            private static final int[] dx= {0,1,0,-1};
            private static final int[] dy= {-1,0,1,0};


            public int solution(int[][] maps) {
                boolean[][] isVisited = new boolean[maps.length][maps[0].length];

                Queue<State> q = new LinkedList<>();
                q.add(new State(0, 0, 1));
                isVisited[0][0] = true;

                while (!q.isEmpty()) {
                    State state = q.poll();
                    if (state.y == maps.length - 1 && state.x == maps[state.y].length - 1) {
                        return state.step;
                    }
                    for (int d = 0; d < 4; d++) {
                        int nx = state.x + dx[d];
                        int ny = state.y + dy[d];

                        if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[ny].length) {
                            continue;
                        }
                        if (maps[ny][nx] != 1)
                            continue;
                        if (isVisited[ny][nx])
                            continue;


                        isVisited[ny][nx] = true;
                        q.add(new State(nx, ny, state.step + 1));
                    }
                }
                        return -1;
                    

                }
            }



            /* 큐 안쓰고 이상하게 풀려고 도전한 모스읍..... 다 까먹어버렸다 하 
             *  class Solution {
            public static boolean[][] visited;
            public static int[][] cant;
            public static int count=0;
            public static int n,m;
            public static int dx[]= {0,1,0,-1};
            public static int dy[]= {-1,0,1,0};
            public class State{
                int x;
                int y;
                public State(int x, int y) {
                    this.x = x;
                    this.y = y;
                }
            }

            public int solution(int[][] maps) {
                n= maps.length;
                m= maps[0].length;
                visited= new boolean[m][n];

                State state= new State(0,0);


                bfs(state,count,maps);
                return  count;
            }

            private void bfs(State state, int c,int[][] maps) {
                while (state.x<m && state.y<n && state.y>=0 && state.x>=0 && maps[state.x][state.y]==1 ){

                    if (state.x==m && state.y==n)
                        break;
                    
                    if (visited[state.x][state.y])
                    {
                        continue;
                    }
                    else {
                        visited[state.x][state.y]=true;
                    }
                    for (int i=0;i<4;i++){
                        state.x+=dx[i];
                        state.y+=dy[i];
                        count+=1;
                        bfs(state,count,maps);
                    }
                }
            }
        }
             */


             import java.util.*;
 
 class Solution {

            public static int dx[]= {0,1,0,-1};
            public static int dy[]= {-1,0,1,0};
            public class State{
                int x;
                int y;
                public State(int x, int y) {
                    this.x = x;
                    this.y = y;
                }
            }

            public int solution(int[][] maps) {
                int n= maps.length;
                int m= maps[0].length;

                Queue<State> q= new LinkedList<>();
                q.add(new State(0,0));

                boolean[][] visited= new boolean[n][m];
                visited[0][0]=true;

                State state;
                while (!q.isEmpty()){
                    state=q.poll();
                    int bx=state.x;
                    int by= state.y;
                    for (int i=0;i<4;i++){

                        int nx=bx+dx[i];
                        int ny=by+dy[i];
                        if (nx>=0 && ny>=0 && nx<n && ny<m){
                            if (visited[nx][ny]==false && maps[nx][ny]>0)
                            {
                                visited[nx][ny]=true;
                                maps[nx][ny]=maps[bx][by]+1;
                               q.add(new State(nx, ny));
                            }
                        }
                    }
                }
                return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
            }
        }   