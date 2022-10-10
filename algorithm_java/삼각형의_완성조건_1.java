class Solution {
    public int solution(int[] sides) {
    int a=sides.length;
    int max=0;
    int i=0;
    for(int b=0;b<a;b++)
    {
        if(sides[b]>=max)
        max=sides[b];
    }
    if(sides[0]==max)
    {
        if(sides[1]+sides[2]>max)
        return 1;
        else
        return 2;
    }
    else if(sides[1]==max)
    {
        if(sides[0]+sides[2]>max)
        return 1;
        else
        return 2;
    }
    else if(sides[2]==max)
    {
        if(sides[0]+sides[1]>max)
        return 1;
        else
        return 2;
    }
        return 0;
}
       
    
}