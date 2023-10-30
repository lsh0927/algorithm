import javax.swing.*;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Solution {
            public int solution(String[] user_id, String[] banned_id) {
                String[][] bans = Arrays.stream(banned_id)
                        .map(banned -> banned.replace('*', '.'))
                        .map(banned -> Arrays.stream(user_id)
                                .filter(id -> id.matches(banned))
                                .toArray(String[]::new))
                        .toArray(String[][]::new);

                Set<Set<String>> banSet=new HashSet<>();
                count(0,new HashSet<>(),bans,banSet);
                return banSet.size();
            }
            //상태를 이용한 메서드 선언
            private void count(int index, Set<String> banned,String[][] bans,Set<Set<String>> banSet){
                if(index==bans.length){
                    banSet.add(new HashSet<>(banned));
                    return;
                }
                for (String id: bans[index]){
                    if(banned.contains(id))
                        continue;
                    count(index+1,banned,bans,banSet);
                    banned.remove(id);
                }
            }
        }
    }
}
            //정규 표현식을 이용해 불량 사용자 아이디 목록에 해당하는 사용자 아이디를 구함
            //조합할 수 있는 경우의 수를 구해야 함.

                /*
                재귀 정의
                앞서 구한 bans를 이용해 서로 다른 사용자 아이디의 조합 개수를 세어주어야 함
                원소를 순서대로 나열하는 개수인 순열과 비슷하게 재귀로 구현되지만,
                순서가 상관없다는 점을 생각하면 Set를 이용할 수 있음

                상태: 불량 사용자 아이디 중 하나의 사용자 아이디를 선택해야 함
                따라서 불량 사용자 아이디의 순서대로 재귀를 진행할 수 있으며, 상태에는
                사용자 아이디를 선택할 불량 사용자 아이디의 인덱스와
                중복된 사용자  아이디 선택을 방지하는 Set 자료구조인 banned로 구성

                따라서 이 문제의 재귀 상태는 (index, banned)로 표기할 수 있고,
                이 상태가 나타내는 부분 문제는 banned에 포함된 사용자 아이디를 제외하고
                불량 사용자 아이디 index 부터 가능한 사용자 아이디의 조합이 됨
                 */
