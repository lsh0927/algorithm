class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int a = count(i); //배열에 limit,power를 반영해 넣으려 했으나, 사실 result는 합계이므로 만들 필요 x
            if(a>limit){
                answer += power;
            }else{
                answer += a;
            }
        }
        return answer;
    }
    public int count(int N){//약수의 개수를 리턴(구글링)
        int count = 0;
        
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N) 
                count++;
            else if (N % i == 0) 
                count += 2;
        }
        return count;
    }
}