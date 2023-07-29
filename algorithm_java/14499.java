import javax.management.relation.Role;
import java.util.Arrays;
import java.util.*;

public class Main {
    static int [][]sp;
    static int x,y,k;
    static int N,M;
    static int []role;
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       N=sc.nextInt();
       M=sc.nextInt();
       x=sc.nextInt();
       y=sc.nextInt();
       k=sc.nextInt();
       int []cmd=new int[k];

       sp= new int[N][M];
       for(int i=0;i<N;i++)
       {
           for (int j=0; j<M;j++)
           {
               sp[i][j]=sc.nextInt();
           }
       }
        sp[x][y]=0;
       for(int q=0;q<k;q++) {cmd[q]= sc.nextInt();}

       role=new int[]{0,0,0,0,0,0};
       int i=0;
       int cnt=k;
       while(cnt>0)
       {
           cnt--;
           i++;
           rolling(sp,cmd[i],role);
            //밑면 교체까지 성공, 이제 복사 해야함. 그리고 방향 바꿨을때 그게 반영되나? 될걸?
       }
    }
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void rolling(int[][]arr, int cmd, int []role)
    {
        if(cmd==1)
        {
            x++;
            if(x>=M || y>=N || x<0 || y<0){
                x--;
                return;
            }
            swap(role,2,4);
            swap(role,0,2);
            swap(role,2,5);
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            System.out.println(role[0]);
            return;

        } else if (cmd==2) {
            x--;
            if(x>=M || y>=N || x<0 || y<0) {
                x++;
                return;
            }
            swap(role,0,5);
            swap(role,2,5);
            swap(role,2,4);
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            System.out.println(role[0]);;
            return ;
        }
        else if(cmd==3)
        {
            y++;
            if(x>=M || y>=N || x<0 || y<0) {
                y--;
                return;
            }
            int tmp=role[0];
            role[0]=role[1];
            role[1]=role[2];
            role[2]=role[3];
            role[3]=tmp;
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            System.out.println(role[0]);;
            return ;
        }
        else if(cmd==4){
            y--;
            if(x>=M || y>=N || x<0 || y<0) {
                y++;
                return;
            }
            int tmp=role[3];
            role[3]=role[2];
            role[2]=role[1];
            role[1]=role[0];
            role[0]=tmp;
            if(sp[x][y]!=0) {
                role[2] =sp[x][y];
                sp[x][y]=0;
            }
            for(int a=0;a<6;a++)
            {System.out.println("1"+role[a]);}
            return;

        }
    }
}   