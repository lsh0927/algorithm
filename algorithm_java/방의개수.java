 class Solution {
            private static class Vertex{
                public final int x;
                public final int y;
                //방을 생성하는 조건을 검사하려면, 해당 좌표에 정점이 있는지 알아야함.
                //좌표 정보를 이용하여 문자열 id를 생성
                public final String id;
                //연결된 정점들을 id를 이용하여 저장
                public final Set<String> connectedVerices;
                public Vertex(int x, int y) {
                    this.x = x;
                    this.y = y;
                    this.id=id(x,y);
                    this.connectedVerices=new HashSet<>();
                }
                public static String id(int x,int y){
                    return String.format("(%d,%d)",x,y);
                }
            }
            private static final int[] dx={0,1,1,1,0,-1,-1,-1};
            private static final int[] dy={-1,-1,0,1,1,1,0,-1};

            public int solution(int[] arrows) {
                int count = 0;
                Map<String, Vertex> vertices= new HashMap<>();

                Vertex v= new Vertex(0,0);
                vertices.put(v.id,v);

                for(int d: arrows){
                    for (int i=0;i<2;i++){
                        int x=v.x+dx[d];
                        int y=v.y+dy[d];
                        String id= Vertex.id(x,y);

                        if(!vertices.containsKey(id)){
                            vertices.put(id,new Vertex(x,y));
                        }else if(!v.connectedVerices.contains(id)){
                            count++;
                        }

                        Vertex u= vertices.get(id);
                        v.connectedVerices.add(u.id);
                        u.connectedVerices.add(v.id);
                        v=vertices.get(id);
                    }
                }
                //count
                return count;
            }
        }
