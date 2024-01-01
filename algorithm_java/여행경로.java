import java.util.*;
 
class Solution {


            List<Stack<String>> result;
            String[][] tickets;

            public String[] solution(String[][] tickets) {
               result= new ArrayList<>();
               this.tickets=tickets;
               //TODO this?


               boolean[] visited= new boolean[tickets.length];
               Stack<String> st= new Stack<>();
               st.push("ICN");

               //스택에 초기값 푸시

               dfs(visited,st,0);
               //방문 여부,스택, len을 dfs의 파라미터로

                if (result.size()>1){
                    Collections.sort(result, new Comparator<Stack<String>>() {
                        @Override
                        public int compare(Stack<String> o1, Stack<String> o2) {
                            for (int i = 0; i < o1.size(); i++) {
                                String s1 = o1.get(i);
                                String s2 = o2.get(i);

                                if (!s1.equals(s2))
                                    return s1.compareTo(s2);
                            }
                            return 0;
                        }
                    });
                }
                //result는 String 스택의 리스트 였음
                Stack<String> res= result.remove(0);
                String[] answer= new String[res.size()];

                for (int i=0;i<answer.length;i++){
                    answer[i]= res.get(i);
                }

                return answer;
            }

            public void dfs(boolean[] visited,Stack<String> st, int len){
                if (len== tickets.length){
                    Stack<String> res= new Stack<>();

                    for (String s : st) {
                        res.push(s);
                    }

                    result.add(res);
                    return;
                }

                String arrive= st.peek();

                for (int i=0;i< tickets.length;i++){
                    String[] tic= tickets[i];


                    if (!visited[i] && arrive.equals(tic[0])) {

                        st.push(tic[1]);
                        visited[i]=true;

                        dfs(visited,st,len+1);

                        visited[i]=false;
                        st.pop();
                    }
                }
            }
        }


        /*
         * import java.util.*;

  class Solution {

            static boolean[] visit;
            static ArrayList<String> list= new ArrayList<>();

            public String[] solution(String[][] tickets) {
                visit= new boolean[tickets.length];
                DFS(0,"ICN","ICN",tickets);
                Collections.sort(list);
                String[] temp= list.get(0).split(" ");
                return temp;
            }

            private static void DFS(int cnt, String icn,String word, String[][] tickets){
                if (cnt==tickets.length){
                    list.add(word);
                }
                else {
                    for (int i=0; i< tickets.length ; i++){
                        if (!visit[i] && tickets[i][0].equals(icn)){
                            visit[i]=true;
                            DFS(cnt+1,tickets[i][1],word+" "+tickets[i][1],tickets);
                            visit[i]=false;
                        }
                    }
                }
            }
        }
         */