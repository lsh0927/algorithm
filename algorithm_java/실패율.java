import java.util.*;

class Solution {
    
    //배열에 원소가 있음을 확인하는 방법
    //contains 함수-> list로 변환이 필요
    //hashmap의 containsKey 메소드 활용?
    
    
    public int[] solution(int N, int[] stages) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Double> ans = new HashMap<>();

        for (int stage : stages) {
            int count = map.containsKey(stage) ? map.get(stage) + 1 : 1; //값이 겹치면 count=map.get(stage) 없으면 count=1;
            map.put(stage,count); //map에 값 대입
        }

        int total = stages.length; 
        for (int i = 1; i <= N; i++) {
            if (map.containsKey(i)) { //key가 map에 있으면
                int cnt = map.get(i); //cnt가 그 값을 가지고
                ans.put(i,  (double) cnt / total); //anw에는 실패율을 계산하여 put
                total -= cnt; //총 길이는 줄어듦(cnt는 겹치는 값, 즉 이미 전 단계에서 실패한? 스테이지이므로 다음 실패울을 계산할때 도전자의 수에서 빠져야 할듯)
            } else {
                ans.put(i, 0.0);
            }
        }

        List<Integer> list = sortByValue(ans); //몬소리고 진짜;
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i); //리스트에서 값을 가져와 answer에 저장
        }
        return answer; //리턴이 두개나 있네..
    }

    public static List<Integer> sortByValue(final Map<Integer,Double> map) { //머라카노 ㅡㅡ
        List<Integer> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list, (Comparator) (o1, o2) -> { //리스트 정렬
            Object v1 = map.get(o1);//객체를 정해주나?
            Object v2 = map.get(o2); 
            return ((Comparable) v2).compareTo(v1);
        });
        return list; //으아아
    }
}
