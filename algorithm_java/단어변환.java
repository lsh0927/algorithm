import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        class Solution {
            //초기 상태부터 목표 단계 까지 최단 경로를 찾는 문제이므로 BFS로 접근 가능

            public int solution(String begin, String target, String[] words) {
                boolean[] isVisited= new boolean[words.length];

                Queue<State> q=new LinkedList<>();
                q.add(new State(begin,0));
                //초기 상태 단어는 begin이며, 변환 횟수가 0이기 때문에 step은 0이 됨

                //탐색 진행
                while(!q.isEmpty())
                {
                    State state=q.poll();
                    
                    if(state.word.equals(target)){
                        return state.step;
                    }
                    
                    for(int i=0;i< words.length;i++){
                        String next= words[i];
                        
                        if(!isConvertable(state.word,next)){
                            continue;
                            
                        }
                        if(isVisited[i])
                            continue;
                        
                        isVisited[i]=true;
                        q.add(new State(next, state.step+1));
                    }
                }

                return  0;
            }

            //두 단어는 하나의 문자만 다를때 변환 가능 하므로, 이를 검사하는 isConvertable()매서드 작성
            private  boolean isConvertable(String src, String dst){
                 char[] srcArr=src.toCharArray();
                 char[] dstArr=dst.toCharArray();

                 int diff=0;
                 for(int i=0;i< srcArr.length;i++)
                 {
                     if(srcArr[i]!=dstArr[i])
                         diff++;
                 }
                 return diff==1;
            }
            //최단 경로 길이=== 단어를 변환하는 횟수가 이에 해당
            private static class State{
                public final String word;
                public final int step;

                private State(String word, int step) {
                    this.word = word;
                    this.step = step;
                }
            }//변환 횟수 step은 정답을 구하고자 추적하는 변수일 뿐, 상태변수는 아님.
            //따라서 이후 상태에 대한 중복 검사는 word로만 함

        }
    }
}
