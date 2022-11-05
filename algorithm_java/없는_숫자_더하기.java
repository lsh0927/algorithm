class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
     
        int sum=0;
        
        for(int i=0;i<numbers.length;i++)
        { 
            sum+=numbers[i];
        }
        answer=45-sum; //0~9까지의 합은 45
        return answer;
    }
}
