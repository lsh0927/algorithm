// class Solution
// {
//     public int solution(int n, int a, int b)
//     {
//         int answer = 0;
//         while(n>2)
//         {
//             if(a<n/2+1 && b>n/2-1){
//                 answer=(int)baselog(n,2); //casting 필요
//                 return answer;
//             }
//             else{
//                 //꼭 배열로 바꾸지 않아도 해결할 방법이 있지 않을까..?
//                 //n을 n/2로 바꾸면서 a와 b도 같이 줄어든다면,,?
//                 n=n/2;
//                 a=devide(a);
//                 b=devide(b);
//             }   
//         }
//         return answer+1;
//     }
//     static double baselog(double x, double base)
//     {
//         return Math.log10(x) / Math.log10(base);
//     }
//     static int devide(int q)
//     {
//         if(q%2!=0)
//         {
//             return (q+1)/2;
//         }
//         else
//         {
//             return q=q/2;
//         }
//     }
// }

class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;
        while(a != b)
        {
            a = a/2 + a%2;
            b = b/2 + b%2;
            round++;
        }
        return round;
    }
}
//하 더 간단하면서 좋은 풀이가 있는데 이걸 어케 생각해내야하지
// class Solution
// {
//     public int solution(int n, int a, int b)
//     {
//         return Integer.toBinaryString((a-1)^(b-1)).length();
//     }
// }
//tq이건 또 뭐야..