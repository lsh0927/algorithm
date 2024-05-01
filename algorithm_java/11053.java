import java.io.*;
import java.util.*;

class Main {


    static int dp[][];
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr= new int[t];
        StringTokenizer st= new StringTokenizer(br.readLine());

        for (int i=0;i<t;i++){
           arr[i]=Integer.parseInt(st.nextToken());
        }
       Arrays.sort(arr);

        // 배열을 List<Integer>로 변환
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            list.add(value);
        }
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set.size());
    }
}

//dp를 사용하지 않고, 중복값 제거로 구한 정답. 이걸 구하는게 아닌가봄