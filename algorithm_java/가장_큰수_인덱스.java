class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int max=0;
        int a=0;
        
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>=max)
            {    
                max=array[i];
                a=i;
            }
        }
        answer[0]=max;
        answer[1]=a;
        return answer;
    }
}