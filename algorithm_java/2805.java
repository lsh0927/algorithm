/*
 * 시간 초과 코드
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Main {
    static int h;
    static int max=0;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();
        int[] tree=new int[N];
        for(int i=0;i<N;i++){
            tree[i]=sc.nextInt();
        }
        Arrays.sort(tree);
        int get=0;
        int index=tree.length-1;
        h=tree[index];
        while (true)
        {
            for(int i=index; i>=0;i--)
            {
                if(tree[i]>h)
                    get+=tree[i]-h;
            }
            if(get<M)
            {
                h-=1;
            }
            if(get>=M)
                break;
            get=0;
        }
        System.out.println(h);
    }
}
 */
//맞는코드

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static Integer height[];
    static long my_max = 0;    // 절단기의 최댓값 기록

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);
        int end = 0; // 나무의 최댓값 기록
        height = new Integer[n];
        String temp = br.readLine();
        String[] temp2 = temp.split(" ");        // 아래처럼 계속 split 되면 시간초과가 될 수 있습니다!!!
        // 1번만 호출하고 저장해도 충분합니다!
        /*
        for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(temp.split(" ")[i]);    => 매 반복마다 계속 split를 호출함
		}                                                            => 한번만 호출하고 그걸 써도 됨!
        */


        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(temp2[i]);            // 한번만 호출한 값을 가져다 쓰기!
            end = Math.max(end, height[i]);    // 최댓값만 알기
        }


        // Arrays.sort(height);

        // 또한 굳이 정렬할 필요도 없습니다!! 따라서 최댓값만 알아가면 됩니다.
        // 아니, 이분탐색인데 정렬할 필요가 없다니요?!!!!!!!!!!!!!
        // 라고 하실 수도 있는데, 이 문제에서 우리가 사용하는 것은,
        // 절단기로 잘라낸 나무들 "전체"의 "합"입니다.(getM 함수) 즉, height 배열의 정렬여부와는 전혀 상관 없죠.


        int start = 0;
        bs(m, start, end);    // 최저값과 최댓값을 start와 end로 설정하기
        System.out.println(my_max);        // 최종 최댓값 출력하기
    }


    /*
    	public static void bs(int m, int start, int end,long getM) {
		int mid = (start + end) / 2;
		if (getM(mid) == m||getM==getM(mid)) {
			System.out.println(mid);
			return;
		}
		if (getM(mid) > m) {
			bs(m, mid + 1, end,getM(mid));
		} else {
			bs(m, start, mid - 1,getM(mid));
		}
	}
    */

    // 위 코드의 가장 큰 문제점은 getM 함수를 지나치게 많이 호출한다는 것입니다.
    // 또한, getM(mid)의 값이 m 이상이라면, 이 mid는 가치가 있습니다. 꼭 m과 똑같을 필요가 없지요!
    // 문제에서도, 적어도 m이 필요하다 했으므로, m이 넘어도 상관없습니다!

    // 따라서, getM(mid) >= m 이라는 조건과 else로 엮는 것이 더 좋을 것 같습니다!
    // 또한, 찾았다고 해서 바로 return 해버리면 안됩니다. 그 이유는 저희는 최대 절단기 높이가 필요하기 때문입니다.
    // 아직 이 값이 최대가 아닐 수도 있는데 찾았다고 바로 끝내면 안되지요! 계속 최대를 갱신해야 합니다!

    // 또한 모든 이분탐색이 그러하듯이, 끝나는 조건 start와 end간의 관계가 들어가야겠죠.

    public static void bs(long m, long start, long end) {
        if (start > end) return;        // 더 이상은 탐색 금지!
        long mid = (start + end) / 2;
        if (getM(mid) >= m) {    // getM 함수는 1번만 호출해서 쓰자!
            if (my_max < mid) {
                my_max = mid;        // 최댓값을 갱신하자!
            }
            bs(m, mid + 1, end);    // 계속 호출해서 조사해보자!
        } else {
            bs(m, start, mid - 1);
        }
    }
    public static long getM(long mid) {
        long sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += height[i] >= mid ? (height[i] - mid) : 0;
        }
        return sum;
    }
}
