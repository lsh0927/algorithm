class Solution {
            public int[] solution(String s) {
                int[] answer = {};

                int loop=0;
                int removed=0;
                //s가 1이 될때까지 반복하며 loop,removed 누적

                while (!s.equals("1")){
                    int zeros= countZeros(s);
                    loop+=1;
                    removed+=zeros;
                    
                    int ones=s.length()-zeros;
                    s=Integer.toString(ones,2);
                }
                
                
                return new int[] {loop,removed};
            }
            private int countZeros(String s){
                int zeros=0;
                for (char c : s.toCharArray())
                if(c=='0')
                    zeros++;
                return zeros;
            }
        }