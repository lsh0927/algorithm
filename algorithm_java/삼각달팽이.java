class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        //문제 풀이 흐름
       
        //3.b 오른쪽으로 이동하면서 채우기
        //3.c 왼쪽 위로 이동하면서 채우기
        //4 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환
        
       // 1->n*n 차원 배열 선언
        int[][] triangle= new int [n][n];
        int v=1; //채워 넣을 숫자, 기록할 때마다 1증가
        
        
       //2. 숫자를 채울 현재 위치를 (0,0)으로 설정 
        int x=0;
        int y=0;
        //3. 방향에 따라 이동할 수 없을 때까지 반복하면서 숫자 채우기
        while(true){
            while(true){  //아래로 이동
                triangle[y][x]=v++;
                if(y+1 ==n || triangle[y+1][x]!=0)
                    break;
                y+=1;
            }
            if(x+1 == n|| triangle[y][x+1]!=0) //아래로 진행하는 마지막 경우인 경우
                break;
            x+=1;
            while(true){ //오른쪽으로 이동
                triangle[y][x]=v++;
                if(x+1 ==n || triangle[y][x+1]!=0)
                    break;
                x+=1;
            }
            if(triangle[y-1][x-1]!=0)
                break;
            x-=1;
            y-=1;
               //왼쪽 위로 이동
            while(true){
                triangle[y][x]=v++;
                if(triangle[y-1][x-1]!=0) break;
                x-=1;
                y-=1;
            }
            if(y+1==n || triangle[y+1][x]!=0) break;
            y+=1;   
        }
        
        //triangle에 모든 숫자가 채워짐-> 1차원 배열로 구성하여 반환하면 됨.
        //v에는 채워넣은 마지막 숫자+1이 들어있으므로 v-1이 채워넣은 숫자 갯수가 됨.
        //따라서 1차원 배열은 v-1의 크기로 선언 가능
        int[] result= new int[v-1];
        
        //2차원 배열에서는 삼각형이 왼쪽으로 몰려있는 직각 삼각형 모양-> 이중 반복문으로 1차원 배열에 숫자를 넣어줄 수 있음
        //중요
        int index=0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<=i; j++){
                result[index++]=triangle[i][j];
            }
        }
        
        
       

        
        return result;
    }
}

/* 더 깔끔한 코드-> 변화량 dx,dy이용
public class Solution{
    private static final int[] dx={0,1,-1}; //아래, 오른쪽, 왼쪽 위로 이동시 x변화량
    private static final int[] dy={1,0,-1}; //아래, 오른쪽, 왼쪽 위로 이동시 y변화량

    public int[] solution(int n){
        int [][]triangle= new int [n][n];
        int v=1;
        int x,y=0;
        int d=0;

        while(true){
            triangle[y][x]=v++;
            int nx= x+dx[d];
            int ny= y+dy[d];

            if(nx ==n || ny || n ||nx==-1 ||ny -1 ||triangle[ny][nx]!=0){
                d=(d+1)%3;
                nx=x+dx[d];
                ny=y+dy[d];
                if(nx==n || ny==n || nx==-1 ||ny ==-1 ||triangle[ny][nx]!=0)
                    break;
            }
            x=nx;
            y=ny;
        }
        int [] result= new int[v-1];
        int index=0;
        for(int i=0; i<n; i++){
            for(int j=0;j<=i;j++)
            {
                result[index++]=triangle[i][j];
            }
        }
    }
}
 * 
 */