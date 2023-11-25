import java.util.stream.IntStream;
 class Solution {

            private static final int[][] rules= {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};

            private int getPicked(int person, int problem){
                int[] rule=rules[person];
                int index= problem % rule.length;
                return rule[index];

                //몇 번을 찍었는지 알 수 있음

            }

            public int[] solution(int[] answers) {

                int[] corrects= new int[3];
                int max=0;

                for (int problem=0;problem< answers.length;problem++){
                    int answer= answers[problem];


                    //이제 정답이 맞는지 세면 됨

                    for (int person=0;person<3;person++){
                        int picked=getPicked(person,problem);
                        if (answer==picked)
                            if (++corrects[person]>max)
                                max=corrects[person];
                    }
                }

                //IntStream을 이용하여 최대값 리턴
                final int maxCorrect=max;
                
                return IntStream.range(0,3)
                        .filter(i->corrects[i]==maxCorrect)
                        .map(i->i+1)
                        .toArray();
            }
        }