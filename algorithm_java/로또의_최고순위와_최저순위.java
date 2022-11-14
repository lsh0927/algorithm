class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int answer[]= new int[2];
        int count=0;
        int rcount=0;
        for(int i=0;i<lottos.length;i++)
        {
            if(lottos[i]==0)
                count++; //알아볼수 없는 번호-> 최대 번호 일치에 이용
        }
        //두 배열의 원소를 비교, 원소가 같으면 rcount가 증가.
        for(int a=0; a<lottos.length;a++)
        {
            for(int b=0;b<win_nums.length;b++)
            {
                if(lottos[a]==win_nums[b])
                    rcount++;
            }
        }
      
            //6개 다맞춤=1
            //5개 =2
            //4개 =3
            //3개=4
            //2개 5
            //0 or 1 =6;
        
        if(count==0)
        {
            if(rcount<2)
            {
              answer[0]=6;
              answer[1]=6;
            }
            else
            {
                answer[0]=7-rcount;
                answer[1]=7-rcount;
            }
        }
        else if(count+rcount<2)
        {
            answer[0]=6;
            answer[1]=6;
        }
        else if(count==6)
        {
            answer[0]=1;
            answer[1]=6;
        }
        else
        {
            answer[0]=7-(count+rcount);
            answer[1]=7-rcount;
        }
            return answer;
    }
}