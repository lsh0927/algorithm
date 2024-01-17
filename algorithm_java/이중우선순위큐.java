
import java.util.*;

public class Main{
    public static void main(String[] args) {

        class Solution {
            PriorityQueue<Integer> pq= new PriorityQueue<>();
            public int[] solution(String[] operations) {


                for(int i=0;i< operations.length;i++) {
                    StringTokenizer st = new StringTokenizer(operations[i]);
                    String cmd=st.nextToken();
                    if(cmd.equals("I")){
                        int num=Integer.parseInt(st.nextToken());
                        pq.add(num);
                    }
                    else {
                        if(st.nextToken().equals("1")){
                            if(pq.isEmpty())
                                continue;
                            PriorityQueue<Integer> repq = new PriorityQueue<>(pq.size(), Collections.reverseOrder());
                            repq.addAll(pq);
                            repq.poll();
                            pq = new PriorityQueue<>(repq.size(), Collections.reverseOrder());
                            pq.addAll(repq);

                        }
                        else {
                            if(pq.isEmpty())
                                continue;
                            pq.poll(); //최솟값 제거
                        }
                    }
                }
                int[] answer = {0,0};
                if(pq.size()==1){
                    int n= pq.peek();
                    answer = new int[]{n, n};
                }

                if (pq.size()>1) {
                    PriorityQueue<Integer> descendingPq = new PriorityQueue<>(pq.size(), Collections.reverseOrder());
                    descendingPq.addAll(pq);
                    int a = descendingPq.peek();
                    while (pq.size() > 1) {
                        pq.poll();
                    }
                    int b = pq.peek();
                    answer = new int[]{a, b};
                }
                return answer;
            }
        }
    }
}

