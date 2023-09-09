// import javax.print.DocFlavor;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;
// import java.util.StringTokenizer;
// import java.util.PriorityQueue;
// import java.util.Stack;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         class Solution {
//             static int ans;
//             public int solution(int[] arrayA, int[] arrayB) {
//                 Arrays.sort(arrayA);
//                 int[] numList= makeList(arrayA);

//                 if(!divide(arrayB,numList))
//                 {
//                     return ans;
//                 }
//                 else
//                     return 0;
//             }
//             //arrayB의 모든 원소가 안나누어 떨어지면
//             //통과
//             //모든 원소가 나누어 떨어지면
//             //numList의 인덱스를 증가시켜서
//             //조건을 만족하는 곳의 numList원소를 반환
//             //numList의 끝까지 증가했는데도
//             //모든 원소가 나누어 떨어지면
//             //0반환
//             public boolean divide(int[] arrayB, int[] numList) {
//                 int idx=0;
//                 while (idx< numList.length) {
//                     for (int i = 0; i < arrayB.length; i++) {
//                         if (arrayB[i]%numList[idx]!=0) {
//                             ans=numList[idx];
//                             return false;
//                         }
//                         else {
//                             idx++;
//                         }
//                     }
//                 }
//                     return true;
//             }
//             public int[] makeList(int[] a) {
//                 int min=a[0];
//                 ArrayList<Integer> arr= new ArrayList<>();
//                for(int i=0;i<a.length;i++) {
//                    for (int j = min; j > 1; j--) {
//                        if (a[i]%j==0)
//                        {
//                            if(checkk(a,a[i]))
//                             arr.add(j);
//                        }
//                    }
//                }
//                 int[] intArray = new int[arr.size()];
//                 for (int i = 0; i < arr.size(); i++) {
//                     intArray[i] = arr.get(i);
//                     System.out.println(intArray[i]);
//                     System.out.println("a");

//                 }
//                return intArray;
//             }
//             public boolean checkk(int b[], int n){
//                 for(int i=0;i<b.length;i++){
//                     if(b[i]%n!=0)
//                         return false;
//                 }
//                 return true;
//             }
//         }
//     }
// }


import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        class Solution {
            static List<Integer> list;
            public int solution(int[] arrayA, int[] arrayB) {
                int ans;

                Arrays.sort(arrayA);
                Arrays.sort(arrayB);

                list = new ArrayList<>();
                int aNum = addList(arrayA, arrayB);
                list.clear();
                int bNum = addList(arrayB, arrayA);

                ans = Math.max(aNum, bNum);
                return ans;
            }

            private static int addList(int[] arr1, int[] arr2) {
                int ans = 0;
                int len1=arr1.length;
                int len2=arr1.length;
                int Max1=arr1[len1-1];
                int Max2=arr2[len2-1];
                for(int i=1; i<=Max1; i++) {
                    int cnt = 0;
                    for(int j=0; j<len1; j++) {
                        if(arr1[j] % i == 0) 
                            cnt++;
                        else 
                            break;
                    }
                    if (cnt == len1) 
                        list.add(i);
                }
                for(int i=0; i<list.size(); i++) {
                    int cnt = 0;
                    for(int j=0; j<len2; j++) {
                        if(arr2[j] % list.get(i) != 0) 
                            cnt++;
                        else 
                            break;
                    }
                    if(cnt == len2) 
                        ans = list.get(i);
                }
                return ans;
            }
        }
    }
}
