import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x =sc.nextInt();
        int y =sc.nextInt();
        int count=0;

        while(x != y) {
            x = x/2 + x%2;
            y = y/2 + y%2;
            count++;
        }
        System.out.println(count);

    }
    }








//시간 초과 코드

// import java.util.*;

// public class Main {


//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         int count=1;

//         int N = scanner.nextInt();
//         int x = scanner.nextInt();
//         int y = scanner.nextInt();

//         if(x%2!=0 && x+1==y) {
//             System.out.println(1);
//             return;
//         }

//         while(N>1){
//             if(N%2==0)
//             {
//                 N/=2;
//                 x=round(x);
//                 y=round(y);
//                 count++;
//                 if(x%2!=0 && x+1==y)
//                     break;
//             }
//             else{
//                 N=(N-1/2);
//                 x=round(x);
//                 y=round(y);
//                 count++;
//                 if(x%2!=0 && x+1==y)
//                     break;
//             }
//         }

//         System.out.println(count);

//     }
//     public static int round(int n){
//         return (n+1)/2;
//     }
// }