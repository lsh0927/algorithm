class Solution {

    public long solution(int w, int h) {
        long count = 0;
        for(int x=0; x<w; x++){
            count += Math.ceil((double)h*(x+1)/w)-Math.floor((double)h*x/w);
        }
        return (long)h*w-count;
    }
}