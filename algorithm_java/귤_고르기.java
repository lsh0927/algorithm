import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
  
        HashMap<Integer,Integer> map = new HashMap<>();    
        
        for(Integer key : tangerine) { //나보다 똑똑한 메소드를 쓰자!
		    map.put(key, map.getOrDefault(key, 0)+1);
	    }
       // int res[]=new int[map.size()];
        
        Integer[] values = map.values().toArray(new Integer[0]);  //겹치는 원소갯수, 즉 키의 개수만큼 배열을 만듦
       
        Arrays.sort(values,Collections.reverseOrder());
        int sum=0;
        int i=0;
        while(k>sum)
        {
            sum+=values[i];
            i++;
            
        }
        
        return i;
    }
}