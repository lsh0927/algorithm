import java.util.*;
import java.util.function.Consumer;
class Solution {
            public int[] solution(String[] info, String[] query) {
                Map<String,List<Integer>> scoresMap= buildScoresMap(info);
                int[] answer = new int[query.length];
                
                for(int i=0;i<answer.length;i++){
                    //정답구하기
                    answer[i]=count(query[i],scoresMap);
                }   
                return answer;
            }
            private Map<String, List<Integer>> buildScoresMap(String[] info){
                Map<String,List<Integer>> scoresMap= new HashMap<>();
                //전처리, 조건별 리스트를 생성
                for(String s: info){
                    String[] tokens=s.split(" ");
                    int score= Integer.parseInt(tokens[tokens.length-1]);
                    //scoresMap에 추가
                    forEachKey(0,"",tokens,key->{
                        scoresMap.putIfAbsent(key,new ArrayList<>());
                        scoresMap.get(key).add(score);
                        //람다를 이용한 동작 정의
                    });
                }
                for(List<Integer> list: scoresMap.values()){
                    Collections.sort(list);
                }
                return scoresMap;
            }
            //scoresMap은 문자열로 표현한 검색조건을 key로 하고, 해당 검색 조건에 들어있는 점수들의 리스트를
            //value로 갖는 Map임
            //지원자의 정보를 순회하며 scoresMap변수에서 알맞은 조건의 리스트를 찾아 점수를 추가해야하는데
            //split()를 사용하면 좋을듯
            private void forEachKey(int index, String prefix, String[] tokens,
                                    Consumer<String> action){
                if(index== tokens.length-1){
                    action.accept(prefix);
                    //prefix가 만들어진 검색 조건
                    //점수를 검색조건에서 제외
                    return;
                }
                forEachKey(index+1,prefix+tokens[index],tokens,action);
                forEachKey(index+1,prefix+"-",tokens,action);
            }
            //tokens로 만들 수 있는 모든 조건을 찾아야 함.
            //token에는 총 4개의 조건이 있고, 각 조건마다 -도 따져야함
            //재귀 사용
            //배열의 마지막에는 지원자 점수ㅏㄱ 들어 있는데, 이는 검색 조건에 포함시키지 않기 위해 tokens.length-1까지만
            //재귀 호출을 수행
            //이 종료 조건에 도달하면 검색 조건은 prefix에 생성되어 있음.

            private int count(String query,Map<String,List<Integer>> scoresMap){
                //scoresmap이용
                //query에 맞는 지원자 수 세기
                String[] tokens=query.split(" (and )?");
                String key=String.join("",Arrays.copyOf(tokens,tokens.length-1));

                if(!scoresMap.containsKey(key)) return 0;
                List<Integer> scores=scoresMap.get(key);
                int score=Integer.parseInt(tokens[tokens.length-1]);


                return scores.size()-binarySearch(score,scoresMap.get(key));
            }
            private int binarySearch(int score, List<Integer> scores){
                int start=0;
                int end= scores.size()-1;

                while(end>start){
                    int mid=(start+end)/2;
                    if(scores.get(mid)>=score){
                        end=mid;
                    }else{
                        start=mid+1;
                    }
                }
                if(scores.get(start)<score){
                    return scores.size();
                }
                return start;
            }
        }