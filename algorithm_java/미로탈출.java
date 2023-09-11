import java.util.*;
class Solution {
            final int[] dx={1,-1,0,0};
            final int[] dy={0,0,-1,1};

             int n,m;

            private class Node{
                int x,y,cnt;

                Node(int x,int y){
                    this.x=x;
                    this.y=y;
                    this.cnt=0;

                }

                Node(int x, int y, int cnt) {
                    this.x = x;
                    this.y = y;
                    this.cnt = cnt;
                }
            }

            

            public int solution(String[] maps) {
                int answer = -1;

                n=maps.length;
                m=maps[0].length();

                Node Start= null;
                Node L= null;
                Node Exit=null;

                char[][]map= new char[n][m];
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        map[i][j]=maps[i].charAt(j);

                        if(map[i][j]=='S'){
                            Start= new Node(i,j);
                        }
                        else if(map[i][j] == 'L'){
                            L = new Node(i, j);
                        }else if(map[i][j] == 'E'){
                            Exit = new Node(i, j);
                        }
                    }
                }

                int a= bfs(map,Start,L);

                if(a!=-1){
                     int b= bfs(map,L,Exit);
                    if(b!=-1){
                        answer=a+b;
                    }
                }

                return answer;
            }

            private int bfs(char[][] map, Node start, Node d) {
                Queue<Node> q= new LinkedList<>();
                q.add(start);
                boolean[][] visit= new boolean[n][m];
                visit[start.x][start.y]=true;

                while(!q.isEmpty()){
                    Node cur= q.poll();

                    if(map[cur.x][cur.y]==map[d.x][d.y]){
                        return cur.cnt;
                    }

                    for(int i=0;i<4;i++){
                        int nx= cur.x+dx[i];
                        int ny= cur.y+dy[i];


                    if (!Check(nx,ny) || map[nx][ny]  == 'X' ||
                    visit[nx][ny])
                        continue;

                    visit[nx][ny]= true;

                    q.add(new Node(nx,ny,cur.cnt+1));
                    }

                }
                return -1;
            }
    private boolean Check(int x, int y){
                return (x>=0 && y>=0 && x<n && y<m);
            }
        }

