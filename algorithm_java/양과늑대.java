import java.util.*;

 class Solution {
            public int solution(int[] info, int[][] edges) {

                boolean[][] tree=new boolean[info.length][info.length];

                for (int[] edge : edges) {
                    tree[edge[0]][edge[1]]=true;
                }

                Set<Integer> nodes= new HashSet<>();
                nodes.add(0);
                
                return getMaxSheep(nodes,0,0,info,tree);
            }
            //후보 노드 구하기
            private Set<Integer> getNextNodes(int node,Set<Integer> nodes, boolean[][] tree){
                Set<Integer> nextNodes= new HashSet<>(nodes);
                nextNodes.remove(node);

                //tree 순회하며 node의 자식 노드를 nextNodes에 추가
                for (int next=0; next<tree[node].length; next++){
                    if (!tree[node][next]) continue;
                    nextNodes.add(next);
                }
                return nextNodes;
            }

            //완전탐색
            /*
            상태: (nodes, sheep,wolf)
            종료 조건: ({},sheep,wolf) =sheep
            더이상 방문할 수 없다면 현재까지의 모은 양 개수가 최대
            점화식: (nodes,sheep,wolf) =max(getNextNodes(node,nodes,tree).sheep+1,wolf
            -(getNextNode(node,nodes,tree).sheep,wolf+1)
            -0
             */


            private int getMaxSheep(Set<Integer> nodes, int sheep
            ,int wolf, int[] info, boolean[][] tree){
                int maxSheep= sheep;

                for (int node : nodes) {
                    int nextSheep= sheep;
                    int nextWolf = wolf;

                    if (info[node]==0)
                        nextSheep+=1;
                    else nextWolf+=1;

                    if (nextWolf >= nextSheep) continue;

                    int s= getMaxSheep(getNextNodes(node,nodes,tree),
                            nextSheep,nextWolf,info,tree);

                    if (s>maxSheep){
                        maxSheep=s;
                    }
                }
                return maxSheep;
            }
        }