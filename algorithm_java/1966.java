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


    /*
     * 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {

    static int t;
    static int n;
    static int m;

    static Queue<Integer> queue;
    static Queue<Integer> idxqueue;
    public static void main(String[] args) throws IOException {

       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());

       t=Integer.parseInt(st.nextToken());

       for (int i=0;i<t;i++){
           st= new StringTokenizer(br.readLine());
           n=Integer.parseInt(st.nextToken());
           m=Integer.parseInt(st.nextToken());
//           int[] P= new int[N];
          queue= new LinkedList<>();
          idxqueue= new LinkedList<>();

           st= new StringTokenizer(br.readLine());
           for (int j=0;j<n;j++) {
//               P[j]=Integer.parseInt(st.nextToken());
               queue.offer(Integer.parseInt(st.nextToken()));
               idxqueue.offer(j);
           }
           Print();
       }
    }
    private static void Print(){
        /*
        현재 큐의 가장 앞에 있는 문서의 중요도를 확인
        나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
        이 문서를 큐의 가장 뒤에 재배치한다.
        그렇지 않으면 바로 인쇄를 한다

        6 0
        1' 1 9 1 1 1
        이라면,
        9 1 1 1 1' 1 이렇게 재배치가 된 다음
        5번째로 출력을 할것이다.
         */
        int count=1; //몇번째 인쇄인가

        while (!queue.isEmpty()){
            int max= Collections.max(queue); //현재 최우선 문서
            int cur= queue.poll();  //현재 문서
            int curIdx= idxqueue.poll(); //현재 인덱스

            //인쇄가능함
            if (cur==max){
                //찾는 문서라면 몇번째인지 출력해야함
                if (curIdx==m){
                    System.out.println(count);
                    break;
                }
                count++; //
            }
            else {
                //인쇄 못하면 다시 맨 뒤에 넣음
                queue.offer(cur);
                idxqueue.offer(curIdx);
            }
        }

    }

}

     */