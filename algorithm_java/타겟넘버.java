import java.util.*;

class Solution {
    //DFS
    
    public static class State{
        int acc;
        int step;
        
        public State (int acc, int step){
            this.acc=acc;
            this.step=step;
        }
    }
    static int count=0;
    static int t;
    public int solution(int[] numbers, int target) {
        
        State state=new State(0,0);
        
        int len= numbers.length;
        
        dfs(state,len,numbers,target);
        //현재 상태는 누적합 0, 인덱스 0;
        
        
        int answer = count;
        return answer;
    }
    private static void dfs(State state,int len,int[] numbers, int target){
        
        if(state.step==len)
        {
            if(state.acc==target)
            {
                count++;
                return;
            }
            return;
        }

        state.acc-=numbers[state.step++];
        dfs(state,len,numbers,target);
        state.acc+=numbers[state.step++];
        
    }
}