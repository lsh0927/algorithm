class Solution {
    public long solution(int price, int money, int count) {
        
        long totalcount=0;
        long totalprice=0;
        for(int i=1; i<=count; i++)
        {
            totalcount=totalcount+i;
        }
        
        totalprice=price*totalcount;
        
        if(totalprice>money)
            return totalprice-money;
        else
            return 0;
        
    }
}