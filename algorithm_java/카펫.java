 class Solution {
            public int[] solution(int brown, int yellow) {
                
                for (int x=3;x<=5000;x++){
                    for (int y=3;y<=x;y++){
                        int side=(x+y-2)*2;
                        int center=(x*y)-side;
                        
                        if (brown==side && center==yellow)
                            return new int[] {x,y};
                    }
                }
                
                return new int[] {0,0};
            }
        }