class Solution {
    public int[] solution(int money) {
        int answer[] = new int[2]; //배열 생성
        
        int a,b=0;
        
        a=money/5500;
        b=money%5500;
        
        answer[0]=a;
        answer[1]=b;
        
        
        return answer;
    }
}