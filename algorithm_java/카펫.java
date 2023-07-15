class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            
            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);
                
                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}

/*
 * class Solution {
    public int[] solution(int brown, int yellow) {
        for(int width=3; width<=5000;width++){
            for(int height=3; height<=width; height++){
                int boundary = (width + height - 2) * 2; 
                int center = width * height - boundary;
                
                if (brown == boundary && yellow == center) { 
                        return new int[] {width, height};
                }
            }
        }
        return null;
    }

}
 */