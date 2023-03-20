class Solution{
    public long solution(int num) {
        long answer = 0;
        if(num<2){
            answer=num;
        }
        else{
            answer=solution(num-1)+solution(num-2);
        }
        return answer;
    }
}