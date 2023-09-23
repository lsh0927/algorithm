class Solution {
            public int[] solution(String[] gems) {
                int start=0;
                int end= gems.length-1;
               
                Set<String> gemSet= new HashSet<>(List.of(gems));
                int s=0;
                int e=s;
                Map<String, Integer> includes= new HashMap<>();
                includes.put(gems[s],1);

                //한 종류의 보석이 구간 내 얼마나 많이 포홤되어 있는지 나타냄
                //처음에는 배열의 가장 앞에 있는 보석을 하나 포함하고 있음

                while (s< gems.length){
                    //구간 검사
                    if(includes.keySet().size()== gemSet.size()){
                        //모든 보석 포함시
                        if(e-s<end-start){
                            start=s;
                            end=e;
                        }
                        includes.put(gems[s],includes.get(gems[s])-1);
                        if(includes.get(gems[s])==0){
                            includes.remove(gems[s]);
                        }
                        s++;
                    }
                    else if(e< gems.length-1){
                        e++;
                        includes.put(gems[e],includes.getOrDefault(gems[e],0)+1);
                    }else {
                        break;
                    }
                }
                return new int[] {start+1, end+1};
            }
        }