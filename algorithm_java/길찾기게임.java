import java.util.*;
class Solution {

            private static class Node{
                public final int value;
                public final int x;
                public final int y;

                public Node left;
                public Node right;

                public Node(int value, int x, int y) {
                    this.value = value;
                    this.x = x;
                    this.y = y;

                }
            }
            public int[][] solution(int[][] nodeInfo) {

                Node[] nodes= new Node[nodeInfo.length];
                for (int i=0;i< nodeInfo.length;i++){
                    nodes[i]=new Node(i+1,nodeInfo[i][0],nodeInfo[i][1]);
                }

                Arrays.sort(nodes, (a,b)-> b.y-a.y);
                //트리의 윗부분부터 순회하기 위해 y 좌표로 내림차순 정렬함

                //노드의 정보 정렬-> 배열의 첫 노드 부터 순회하며 트리를 구성할 수 있음
                
                Node root= constructTree(nodes);
                List<Integer> preorder= new ArrayList<>();
                pre(root, preorder);
    
                List<Integer> postorder= new ArrayList<>();
                post(root,postorder);

                
                return new int[][]{
                        preorder.stream().mapToInt(Integer::intValue).toArray(),
                        postorder.stream().mapToInt(Integer::intValue).toArray(),
                };
            }
            //노드의 배열을 전달받아 트리를 구성하여 루트 노드를 반환하는 메서드 작성
            private Node constructTree(Node[] nodes){
                Node root= nodes[0]; 
                
                for (int i=1;i< nodes.length;i++){
                    insert(root,nodes[i]);
                }
                //트리 구성
                return root;
            }
            private void insert(Node root, Node node){
                //x 좌표에 따라 root 노드가 나타내는 트리에 node 삽입
                if(node.x <root.x){
                    if(root.left==null)
                        root.left=node;
                    else
                        insert(root.left,node);
                }
                else {
                    if(root.right==null)
                        root.right=node;
                    else
                        insert(root.right,node);
                }
            }
            private void pre(Node node, List<Integer> visits){
                if (node==null) return;
                visits.add(node.value);
                
                pre(node.left,visits);
                pre(node.right,visits);
            }
            private void post(Node node, List<Integer> visits){
                if(node==null) return;
                
                post(node.left,visits);
                post(node.right,visits);
                visits.add(node.value);
            }
}