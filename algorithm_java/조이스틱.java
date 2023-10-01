 class Solution {
            public int solution(String name) {
                int cost = 0;

                for(int i = 0; i<name.length(); i++){
                    int diff = name.charAt(i) - 'A';
                    if(diff > 13)
                        diff = 26 - diff;
                    cost += diff;
                }

                int front = 0;
                int end = front;
                while(end < name.length() && name.charAt(end) == 'A')
                    end++;

                int minVerCost = 0;
                while(end < name.length()){
                    int backDistance = name.length() - end;
                    int verCost = front + backDistance;
                    if(front < backDistance)
                        verCost += front;
                    else
                        verCost += backDistance;
                    if(minVerCost == 0)
                        minVerCost = verCost;
                    else if(minVerCost > verCost)
                        minVerCost = verCost;

                    front = end;
                    end++;
                    while(end < name.length() && name.charAt(end) == 'A')
                        end++;
                }
                if(front < minVerCost)
                    minVerCost = front;

                cost += minVerCost;

                return cost;
            }
        }