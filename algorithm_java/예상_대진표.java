class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(n>2)
        {
            if(a<n/2+1 && b>n/2-1){
                answer=(int)baselog(n,2); //casting 필요
                return answer;
            }
            else{
                //꼭 배열로 바꾸지 않아도 해결할 방법이 있지 않을까..?
                //n을 n/2로 바꾸면서 a와 b도 같이 줄어든다면,,?
                n=n/2;
                a=devide(a);
                b=devide(b);
            }   
        }
        return answer+1;
    }
    static double baselog(double x, double base)
    {
        return Math.log10(x) / Math.log10(base);
    }
    static int devide(int q)
    {
        if(q%2!=0)
        {
            return (q+1)/2;
        }
        else
        {
            return q=q/2;
        }
    }
}