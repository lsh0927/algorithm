class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int width=3;width<=5000; width++){
            for (int height=3; height<=width; height++){
                int boundary=(width+height-2)*2;
                int center= width*height-boundary;
                if(brown==boundary && yellow==center)
                    return new int[] {width,height};
            }
        }
        int[] answer = {};
        return answer;
    }
    //주어진 조건을 만족하는 카펫의 가로 길이와 세로 길이를 구해야 함.
    //바깥 격자의 갯수 -> (width+height-2)*2 개
    //따라서 안쪽 격자 = (width * height) - (width+height-2) * 2
}


/*2차 풀이  
 *  class Solution {
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
 */