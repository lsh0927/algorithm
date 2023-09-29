class Solution {
            public int[] solution(long begin, long end) {
                int[] answer =new int[(int)(end - begin) + 1];

                for(int i=(int)begin,idx=0; i<=end;i++){
                       answer[idx++]= getMaxNum(i);
                }

                return answer;
            }

            public static int getMaxNum(int n){
                if(n==1){
                    return 0;
                }
                List<Integer> list= new ArrayList<>();
                for (int i=2; i<=Math.sqrt(n); i++){
                    if(n%i==0){
                        list.add(i);
                        if(n/i<=10000000)
                            return n/i;
                    }
                }
                if (!list.isEmpty())
                    return list.get(list.size()-1);

                return 1;
            }
        }