class Solution {
            public int solution(String name) {
                char[] nameArr=name.toCharArray();
                int cost=0;
                for(int i=0;i<name.length();i++){
                    cost+=compareAlphabet(name.charAt(i));
                }
                int front =0;
                int end=front;
                while (end<name.length() && name.charAt(end)=='A')
                    end++;
                int minVerCost=0;
                while (end<name.length()) {
                    int backDistance = name.length() - end;
                    int verCost = front + backDistance;
                    if (front < backDistance)
                        verCost += front;
                    else
                        verCost += backDistance;
                    if (minVerCost == 0)
                        minVerCost = verCost;
                    else if (minVerCost > verCost) {
                        minVerCost = verCost;
                    }

                    front = end;
                    end++;
                    while (end < name.length() && name.charAt(end) == 'A')
                        end++;
                }
                if(front<minVerCost)
                    minVerCost=front;

                cost+= minVerCost;
                return cost;
            }
            public int compareAlphabet(char alp){//현재 커서 위치
                int count=0;
                if(alp-'A'>13) count=26-(alp-'a');
                else count=alp-'a';
                return count;
            }
        }