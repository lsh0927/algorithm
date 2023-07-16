import java.util.Scanner;
import java.util.*;

public class Main {
    static int n,k,count=0,weight;
    static int[] kit;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        k=sc.nextInt();
        visited=new boolean[n];
        kit=new int[n];
        for(int i=0;i<n;i++)
            kit[i]=sc.nextInt();

        dfs(0,500); // 초기 중량 500으로 시작
        System.out.println(count);
    }

    static void dfs(int depth, int weight) {
        // n일차까지 마쳤다면 경우의 수 증가
        if(depth==n) {
            count+=1;
            return;
        }

        // n개의 키트중 선택
        for(int i=0;i<n;i++) {
            // 아직 사용하지 않은 운동 키드이면서 중량이 500 밑으로 떨어지지 않는다면
            if(!visited[i]&&(weight-k+kit[i])>=500) {
                visited[i]=true; // 사용처리
                dfs(depth+1,weight-k+kit[i]); // 깊이를 1 증가, 변화된 중량으로 재귀호출
                visited[i]=false; // 다음 경우의 수를 위해 값 초기화
            }
        }
    }
}
// 1번째 줄에는 N과 K
// 2번째 줄에는 중량 키트의 무게
// 1일 차부터 N일까지 항상  중량 + map의 원소 -K>=500
// 백트래킹 문제 dfs..