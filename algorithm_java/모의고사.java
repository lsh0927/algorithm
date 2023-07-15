import java.util.stream.IntStream;
class Solution {
    
    private static final int[][] RULES= {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}
    };
    //수포자들의 규칙이 저장, 인덱스와 문제 번호를 이용해서 수포자의 선택을 알수 있음
    private int getPicked(int person, int problem){
        int[] rule=RULES[person];
        int index= problem % rule.length;
        return rule[index];
    }
    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max=0;
        
        for(int problem=0; problem<answers.length;problem++){
            int answer= answers[problem];
            for(int person=0; person<3;person++){
                int picked= getPicked(person,problem);
                if(answer==picked){
                    if(++corrects[person]>max){
                        max=corrects[person];
                    }
                }
            }
        }
        final int maxCorrects=max;
        //IntStream을 이용한 풀이. 꼭 기억해둘것.
        return IntStream.range(0,3)
            .filter(i->corrects[i]==maxCorrects)
            .map(i->i+1)
            .toArray();
    }
    
}