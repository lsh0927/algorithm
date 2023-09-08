import java.util.*;
 
 class Solution {
     static class test implements Comparable<test>{
        int s,p;
        String name;

        public test(String name, int s, int p ) {
            this.s = s;
            this.p = p;
            this.name = name;
        }
        @Override
        public int compareTo(test o){
            return this.s-o.s;
        }
    }

    static PriorityQueue<test> q= new PriorityQueue<>();
    static Stack<test> stack= new Stack<>();
    static int cnt=0;
    static String ans[];

    static void run(test a, int NextT){
        int DoneT= a.s+a.p;

        if(DoneT>NextT)
        {
            a.p = DoneT - NextT;
            stack.add(a);
        }
        else {
            ans[cnt++]=a.name;
            if(DoneT == NextT) {
                return;
            }else if(!stack.isEmpty()){
                a = stack.pop();
                a.s = DoneT;
                run(a, NextT);
            }
        }
    }
            public String[] solution(String[][] plans) {
                ans = new String[plans.length];
                for(int i=0; i< plans.length; i++){
                    String[] tmp = plans[i][1].split(":");
                    int time = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
                    q.add(new test(plans[i][0], time, Integer.parseInt(plans[i][2])));
                }

                while(!q.isEmpty()){
                    test qq = q.poll();
                    if(q.isEmpty()){
                        run(qq, Integer.MAX_VALUE);
                    }else{
                        run(qq, q.peek().s);
                    }
                }
                return ans;
            }
        }