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