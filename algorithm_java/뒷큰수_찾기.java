class Solution {
    int a;
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        
        //자기보다 뒤에 있으면서, 자기보다 큰 가장 가까운 수를 뒷큰수라 칭함
        //모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return
        //뒷 큰수가 존재하지 않을 시 -1을 담음
        
        for(a=0;a<numbers.length-1;a++)
        {
            answer[a]=dks(numbers);
        }
        answer[numbers.length-1]=-1;
        
        return answer;
    }
    public int dks(int[] numbers){
            for(int b=a+1;b<numbers.length;b++)
            {
                if(numbers[a]<numbers[b]){
                    return numbers[b];
                }
                
            }
        
        return -1;
    }
}