class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        //문자열 객체를 이용한 풀이
        
        String str= Long.toString(n);
        String reserved= new StringBuilder(str).reverse().toString();
        
        char[] arr= reserved.toCharArray();
        
        int[] result=new int[arr.length];
        for(int i=0; i<result.length; i++)
        {
            result[i]= arr[i]-'0';
        }
        return result;
        
        //StringBuilder와 해당하는 메소드를 이용한 풀이
        
       
    }
}