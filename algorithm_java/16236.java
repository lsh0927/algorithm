
import java.util.*;
public class Main  {

    static int sp[][];
    static int size=2;
    static int count=0;
    static int count1;
    static int count2;
    static int N;
    static int x,y;
    public static void main(String[] args)  {

        Scanner sc= new Scanner(System.in);
        N= sc.nextInt();
        sp=new int[N+2][N+2];

        //본래 영역보다 상하좌우 1칸씩 증가, 접근 가능 여부 판단하는
        //bfs 실행시 이용
        for(int a=0;a<N+2;a++){sp[0][a]= Integer.MAX_VALUE;}
        for(int b=0;b<N+2;b++){sp[N+1][b]= Integer.MAX_VALUE;}
        for(int c=0; c<N+2;c++){sp[c][0]=Integer.MAX_VALUE;}
        for(int d=0; d<N+2;d++){sp[d][N+1]=Integer.MAX_VALUE;}

        for(int i=1;i<N+1;i++)
        {for(int j=1;j<N+1;j++)
            {
                sp[i][j]=sc.nextInt();
                if(sp[i][j]==9)
                {
                    x=i;
                    y=j; //상어의 위치 획득!
                }
            }
        }

        //자기보다 크기가 작은 물고기가 있고, 거기까지 가는 경로에 자기보다 큰 물고기가 없는 경우 반복
        //
        while(check(sp).size()>0 && cango(check(sp))){
            if(count1==1)
                eat(sp,x,y);
            else
            {
                decide();
                eat(sp,x,y);
            }

        }

        System.out.println(count);
    }
    static List<int[]> check(int[][] arr)
    {
        List<int[]> resultList = new ArrayList<>();
        for(int i=1;i<N+1;i++)
        {
            for(int j=1; j<N+1;j++){
                if(arr[i][j]<size)
                {
                    int []result= {i,j};
                    resultList.add(result);
                }
            }
        }
        return resultList;
    }
    static boolean cango(List<int[]> arr, int x,int y){
        for(int[] a : arr){
            if(sp[a[0]][a[1]+1] >size && sp[a[0]][a[1]-1]>size &&sp[a[0]-1][a[1]] >size && sp[a[0]+1][a[1]]>size) 
                return false;
            }
        }
    }
}
//bfs를 이용해서 최소거리? 를 따져봐야할 거 같은데, 
//본인보다 작은 물고기의 좌표를 받아 그 좌표까지 도달 가능한지 따지는 로직을 구현하기가 어렵다...
//결국 또 재귀네 