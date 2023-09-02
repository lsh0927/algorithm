// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.StringTokenizer;


// public class Main {
//     static int N;
//     static int[] zzoknum;
//     static int count;
//     static boolean[] check;
//     public static void main(String[] args) throws IOException {
//     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st;

//     st=new StringTokenizer(br.readLine());
//     N=Integer.parseInt(st.nextToken());
//     zzoknum=new int[N];
//     check=new boolean[N];
//     st=new StringTokenizer(br.readLine());
//     for(int i=0;i<N;i++)
//     {
//         zzoknum[i]=Integer.parseInt(st.nextToken());
//         check[i]=false;
//     }

//     for(int i=0;i<N;i++)
//     {
//         if(haszzok(i))
//         {
//             count+=zzoknum[i];
//         }
//         else if(i==0){
//            check[i]=true;
//            count++;
//         }
//         else{
//             if(check[i-1]==true)
//                 continue;
//             else {
//                 check[i]=true;
//                 count++;
//             }
//         }
//     }
//         System.out.println(count);

//     }
//     static boolean haszzok(int idx){
//         if(zzoknum[idx]!=0)
//             return true;
//         else
//             return false;
//     }
// }

