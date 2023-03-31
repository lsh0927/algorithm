class Solution {
    public long solution(int n) {
        long answer = 0;
        
        //거리를 나타내는 방법은 1로만 나타내기 & 1과 2사이로 나타내기 & 1를 가장 적게 사용하여 나타내기(1의 개수가 0일 수도 있음)
        //매개변수 n을 받았을때, 2로 나눈 몫과 나머지를 구하여 1과 2을 섞어서 나타낼 수 있는 방법을 따져보기
        //ex 5/2=2, 5%2=1 -> 2를 1번 쓸 수도, 2번 쓸 수도 있음 
        //1번 쓴다면 1은 4개이고,2는 1개이니까 5번, 
        //2번 쓴다면 1은 1개에 2는 2개니까 3번
        //2의 개수에 따라 나열할 수 있는 가짓수를 구할 함수 구현이 필요
        //2* 2의 개수+1 (혹은 +0)이 n이 될 때까지 함수 호출, sum에 누적 덧셈하기
        
        return answer;
    }
}
/*
 class Solution {

    long[] dp = new long[2001];

    public long solution(int n) {
        if(n==1) return 1;
        if(n==2) return 2;

        if(dp[n]!=0) return dp[n];

        long result = (solution(n-2) + solution(n-1)) % 1234567;
        dp[n] = result;
        return result;
    }

}
그냥 dp가 답이었다... 뭔가 dp같은데 그래도 다르게 풀어볼 생각하려다가 너무 멀리 온듯하다
 */