import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
       
        //배열의 원소가 있으면, k개가 찰때까지 같은 크기의 가장 많은 원소를 찾아야 함 -> key:value? 
        //for문으로 contains?(맞나..?)
        
        //k개를 채울때까지 탐색해야함->종류가 바뀔때 count++
        
        
        HashMap<Integer,Integer> map = new HashMap<>();    
        
        // for(int i=0;i<tangerine.legnth();i++)
        // {
        //     map.put(tangerine[i],a); //해시맵에 각 원소를 넣고, value를 줬음
        //     //각 원소가 들어갈 때 겹친다->count를 늘림
        //     if(map.containsKey())????
        // }
        
        for(Integer key : tangerine) { //나보다 똑똑한 메소드를 쓰자!
		    map.put(key, map.getOrDefault(key, 0)+1);
	    }
       // int res[]=new int[map.size()];
        
        Integer[] values = map.values().toArray(new Integer[0]);  //겹치는 원소갯수, 즉 키의 개수만큼 배열을 만듦
       
        Arrays.sort(values,Collections.reverseOrder());
       
        for(int q=0;q<values.length;q++)
        {
            System.out.println(values[q]);
        }
        
        //여까지 잘 댔음
        //내림차순으로 정렬한 이 배열은, 겹치는 원소의 갯수이므로, 배열의 원소의 합이 k가 되는 순간 인덱스+1을 하면댐. (혹은 k를 초과할때는 그냥 인덱스)     
        int sum=0;
        int i=0;
        while(k>sum)
        {
            sum+=values[i];
            i++;
            if(k==sum+values[i] || k<sum+values[i])
            {
                answer=i;
            }
            
        }
        
        return answer;
    }
}