import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int N,M;
        int s = sc.nextInt();

        for(int a=0;a<s;a++) {
            N = sc.nextInt();
            M = sc.nextInt();
            LinkedList<int[]> queue = new LinkedList<>();
            for (int k = 0; k < N; k++) {
                queue.offer(new int[]{k, sc.nextInt()});
            }
            int count=0;
            while (!queue.isEmpty()){
                int[] front=queue.poll();
                boolean isMax=true;

                // 큐에 남아있는 원소들과 중요도를 비교
                for(int i = 0; i < queue.size(); i++) {

                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    if(front[1] < queue.get(i)[1]) {

                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
                        queue.offer(front);
                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        // front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }
                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(isMax == false) {
                    continue;
                }
                // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
                count++;
                if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }

            }
            sb.append(count).append('\n');
            }
        System.out.println(sb);
        }
    }

