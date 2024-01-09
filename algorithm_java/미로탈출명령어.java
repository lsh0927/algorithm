class Solution {

            private static class State{
                int x;
                int y;
                int cnt;
                public State(int x, int y,int cnt) {
                    this.x = x;
                    this.y = y;
                    this.cnt=cnt;
                }
            }

            static int[][] map;
            static StringBuilder sb;
            static List<String> resultList= new ArrayList<>();
            static int finx,finy,fincnt;
            static int bx,by;
            static int[] dx= {1,0,-1,0};
            static int[] dy= {0,1,0,-1};
            public String solution(int n, int m, int x, int y, int r, int c, int k) {

                bx=n;
                by=m;
                sb= new StringBuilder();
                map= new int[n+1][m+1];
                finx=r;
                finy=c;
                fincnt=k;
                for (int i=1;i<=n;i++){
                    for (int j=1;j<=m;j++)
                    {
                        map[i][j]=0;
                        if (i==x && j==y)
                            map[i][j]=1;
                        if (i==r && j==c)
                            map[i][j]=-1;
                    }
                }

                State state= new State(x,y,0);
                //우선순위는 d l r u
                //문자열의 큐를 만들어 최종 비교?

                bfs(state);


                for (int i=0;i< resultList.size();i++)
                {
                    System.out.println(resultList.get(i));
                }


                String answer = "";
                return answer;
            }
            private static void bfs(State state){

                Queue<State> q= new LinkedList<>();
                 q.add(state);



                while (!q.isEmpty()){

                    State s= q.poll();

                    int cx=0;
                    int cy=0;
                        for (int i=0;i<4;i++)
                        {
                             cx= s.x+dx[i];
                             cy= s.y+dy[i];

                            if (i==0){
                                sb.append("r");
                            } else if (i==1) {
                                sb.append("d");
                            } else if (i==2) {
                                sb.append("l");
                            } else if (i==3) {
                                sb.append("u");
                            }

                            if (cx>0 && cx<= bx && cy>0 && cy<=by && cx==finx &&cy==finy && fincnt==s.cnt) {
                                resultList.add(sb.toString());
                                return;
                            } else if (s.cnt>fincnt || cx<1 || cx> bx || cy<1 || cy>by) {
                                return;
                            }

                            bfs(new State(cx,cy,s.cnt+1));
                        }
                }
            }
        }