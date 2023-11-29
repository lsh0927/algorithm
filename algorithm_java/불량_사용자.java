import java.util.*;

class Solution {
            public int solution(String[] user_id, String[] banned_id) {

               String[][] bans= Arrays.stream(banned_id)
                                .map(banned->banned.replace('*','.'))
                                .map(banned->Arrays.stream(user_id)
                                        .filter(id -> id.matches(banned))
                                        .toArray(String[]::new))
                                .toArray(String[][]::new);

                Set<Set<String>> banSet= new HashSet<>();
               count(0,new HashSet<>(),bans,banSet);
               return banSet.size();
            }
            private void count(int index,Set<String> banned,
                               String[][] bans, Set<Set<String>> banSet){
                //count의 매개변수 중, index와 banned는 상태변수
                // bans는 불량 사용자 아이디별로 매칭되는 사용자 아이디 정보
                // banSet은 찾은 조합을 저장할 매개변수

                //종료조건
                if (index== bans.length){
                    banSet.add(new HashSet<>(banned));
                    return;
                }

                //점화식
                for (String id : bans[index]) {
                    if (banned.contains(id)) continue;
                    banned.add(id);
                    count(index+1, banned,bans,banSet);
                    banned.remove(id);
                }
            }
        }
        //가능한 경우의 수
        //일부 문자를 *글자로 가려서 전달하였음
