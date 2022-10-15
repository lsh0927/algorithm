class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        ArrayList<Integer> nn = new ArrayList<Integer>(); 
        
       for(int a=1;a<n;a++)
       {
           while(n>0)
           {
               for(int b=1;b<a-1;b++)
               {
                   if(a%b!=0)
               {
                   nn.add(b);
               }
               n--;
               }
           }
       }        
       for(int i=0;i<b.length;i++)
       {  
           if(n%b[i])
               answer.add(i,b[i]);           
       }
        return answer;
    }
}