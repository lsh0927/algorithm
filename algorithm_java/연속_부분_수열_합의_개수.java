class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        for(int i=1;i<elements.length();i++)
        {
            //i=1~배열 원소 개수-1까지 배열의 원소를, 연속해서 더한 결과 값이 나옴
            // 원형 수열이어야 함. 
            //for문을 빠져나오면, 배열의 모든 합을 더해서 결과값을 넣어야함.
            //hashmap을 이용하면 되지 않을까??
            
            //-> 정리: i=1~i=length-1까지, 모든 수열은 length가지이다. 단지 겹치는 부분이 있을 뿐
            //        -> for문으로 put을 다 하고, key를 받아와서 answer로 리턴
            //        ->경우의 수는 legnth개인데, 겹치는 거 생각안하고 묶으면, //근데 원형큐를 써야할거 같은데
            
            
            
            HashMap<Integer,Integer> map = new HashMap<>();    
            for(Integer key : elements) { 
		        map.put(key, map.getOrDefault(key, 0)+1);
	        }
        
        }
        return answer;
    }
}