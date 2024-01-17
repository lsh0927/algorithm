import java.util.*;

class Solution {

    
    //static boolean[][] isVisited;
    //중복 없는 경로 설정
    static String map[][];
    static int sx,sy,ex,ey,answer,total;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        
        map= new String[52][52];        
        sx=characterX; sy=characterY; ex=itemX; ey=itemY;
        answer=0;
        total=0;
        
        for(int i=0;i<52;i++)
            Arrays.fill(map[i],"");
        
        for(int[] xy: rectangle){
            int leftX=xy[0];
            int rightX=xy[2];
            int leftY=xy[1];
            int rightY=xy[3];
            
            map[leftX][leftY]="LDP";
            map[leftX][rightY]="LUP";
            map[rightX][leftY]="RDP";
            map[rightX][rightY]="RUP";
            
            
            for(int x=leftX+1; x<rightX; x++)
            {
                map[x][rightY] +="U";
                map[x][leftY] +="D";
                
            }
            for(int y=leftY+1;y<rightY;y++){
                map[leftX][y]+="L";
                map[rightX][y]+="R";
            }
            
        }
            bfs(sx,sy);
            
            return Math.min(answer,total-answer);
        
        
    }
        public void bfs(int x, int y){
            String lo=map[x][y];
            
            if(lo.equals("RU") ||lo.equals("UR") ||lo.equals("LUP") || lo.equals("U") ) x++;
            if(lo.equals("LD") ||lo.equals("DL") ||lo.equals("RDP") || lo.equals("D") ) x--;
            if(lo.equals("LU") ||lo.equals("UL") ||lo.equals("LDP") || lo.equals("L") ) y++;
            if(lo.equals("RD") ||lo.equals("DR") ||lo.equals("RUP") || lo.equals("R") ) y--;
            
            total++;
            
            if(x==ex && y==ey)
                answer=total;
            if(x==sx && y==sy)
                return;
            
            bfs(x,y);
            
        
    }
}