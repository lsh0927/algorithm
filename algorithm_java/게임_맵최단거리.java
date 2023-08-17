import java.util.*;
class Solution {
            public int solution(int[][] maps) {

                boolean[][] isVisited= new boolean[maps.length][maps[0].length];
                Queue<State> q= new LinkedList<>();
                q.add(new State(0,0,1));
                isVisited[0][0]=true;

                while (!q.isEmpty()){
                    State state=q.poll();

                    if(state.y== maps.length-1 && state.x == maps[state.y].length - 1)
                    {
                        return state.step;
                    }
                    for(int d=0;d<4;d++){
                        int nx= state.x+dx[d];
                        int ny= state.y+dy[d];

                        if(ny<0 || ny> maps.length ||nx < 0 || nx >= maps[ny].length){
                            continue;
                        }
                        if(maps[ny][nx]!=1){
                            continue;
                        }
                        if(isVisited[ny][nx])
                        {
                            continue;
                        }
                        isVisited[ny][nx]=true;
                        q.add(new State(nx,ny, state.step+1));
                    }
                }
                return -1;
            }
            // 2차원에서 탐색 -> 좌표 클래스
            private static class State{
                public final int x;
                public final int y;
                public final int step;

                private State(int x, int y, int step) {
                    this.x = x;
                    this.y = y;
                    this.step = step;
                }
            }
            private static final int[] dx = {0, 1, 0, -1};
            private static final int[] dy ={-1,0, 1, 0};
            //상태는 2차원 지도에서 상하좌우로 진행될 수 있음.

        }