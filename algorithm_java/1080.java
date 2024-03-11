import java.util.*;
import java.io.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st=new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A=new int[N][M];
        int[][] B=new int[N][M];

        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for(int j=0;j<M;j++) {
                A[i][j]=input.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for(int j=0;j<M;j++) {
                B[i][j]=input.charAt(j)-'0';
            }
        }

        int cnt=0;
        if(N>=3&&M>=3) {
            for(int i=0;i<N-2;i++) {
                for(int j=0;j<M-2;j++) {
                    if(A[i][j]!=B[i][j]) {
                        for(int x=i;x<i+3;x++) {
                            for(int y=j;y<j+3;y++) {
                                if(A[x][y]==0) A[x][y]=1;
                                else A[x][y]=0;
                            }
                        }
                        cnt++;
                    }
                }
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(A[i][j]!=B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }
}