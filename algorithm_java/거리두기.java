import java.util.*;
class Solution {

    int getDistance(Pair p1, Pair p2) {
        return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);        
    }

    int solve(char[][] board, ArrayList<Pair> people) {
        for(int i = 0 ; i < people.size();i++) {
            Pair p1 = people.get(i);
            for(int j = i + 1; j < people.size(); j++) {                
                Pair p2 = people.get(j);
                int distance = getDistance(p1, p2);
                if(distance < 2) return 0;
                if(distance == 2) {
                    if(p1.row == p2.row) {
                        if(board[p1.row][(p1.col + p2.col) / 2] == 'O') return 0;
                    }
                    else if(p1.col == p2.col) {
                        if(board[(p1.row + p2.row)/2][p1.col] == 'O') return 0;
                    }
                    else if(Math.abs(p1.row - p2.row) == 1 && Math.abs(p1.col - p2.col) == 1) {
                        if(board[p1.row][p2.col] != 'X' || board[p2.row][p1.col] != 'X') return 0;
                    }                    
                }
            }
        }
        return 1;
    }

    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];

        for(int i = 0 ; i < places.length; i++) {
            char[][] board = new char[5][5];
            ArrayList<Pair> people = new ArrayList();
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    board[r][c] = places[i][r].charAt(c);
                    if(board[r][c] == 'P') {
                        people.add(new Pair(r,c));
                    }
                }
            }
            answer[i] = solve(board, people);
        }        
        return answer;
    }
    class Pair {
        int row, col;
        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}


/*
 * 
 */
// public class Solution{
//     private static final int dx[]= {0,-1,1,0};
//     private static final int dy[]= {-1,0,0,1};

//     private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
//         for(int d=0; d<4; d++){
//             if(d== exclude) continue; //-> 다음 반복으로 넘어감

//             int nx=x+dx[d];
//             int ny=y+dy[d];
//             if(ny<0 || ny >=room.length || nx < 0 || nx >= room[ny].length)
//                 continue;
//             if(room[ny][nx]=='P') return true;

//         }
//         return false;
//     }
//     private boolean isDistanced(char[][] room, int x, int y){
//         for(int d=0; d<4; d++){
//             int nx= x+dx[d];
//             int ny= y+dy[d];

//             if(ny<0 || ny>=room.length ||nx<0 || nx>=room[ny].length)
//                 continue;
//             switch (room[ny][nx]) {
//                 case 'P': return false;
//                 case '0':
//                     if(isNextToVolunteer(room,nx,ny,3-d)) return false;
//                         break;
            
//             }
//         }
//         return true;
//     }

//     private boolean isDistanced(char[][]room){
//         for(int y=0;y<room.length;y++){
//             for(int x=0; x<room[y].length;x++){
//                 if(room[y][x]!='P') continue;
//                 if(!isDistanced(room,x,y)) return false;

//             }
//         }
//         return true;

//     }
//     public int[] solution(String[][] places){
//         int[] answer=new int[places.length];
//         for(int i=0;i<answer.length;i++){
//             String[] place= places[i];
//             char[][] room= new char[place.length][];
//             for(int j=0; j<room.length; j++){
//                 room[j]=place[j].toCharArray();
//             }
//             if(isDistanced(room)){
//                 answer[i]=1;
//             }else{
//                 answer[i]=0;
//             }
//         }
//         return answer;
//     }
// }

//2차
 class Solution {
            //dx,dy를 잘 응용허여 풀어야 하는 문제
            // 맨해튼 거리 1,2
            //거리 1 상하좌우
            //거리 2 맨해튼 거리 2인 위치에 도달하려면 1을 거쳐야하고
            //맨해튼 거리 1의 위치들이 파티션으로 막혀 있다면
            //맨해튼 거리 2에는 다른 응시자가 있어도 파티션에 가로막힘
            // 어떤 방향이 막혀있다면, 그 방향을 통하는 위치들을 배제하느 것이 아니라
            // 뚫려있는 방향을 검사하도록 해야 함
            //대기실의 모든 응시자 위치에 대해 반복
            //A.상하좌우 중 빈 테이블이 있는 방향에 대해 1-B로 진행
            //B.빈 테이블과 인접한 위치 중 응시자가 있다면 거리두기를 지키지 않은 것
            //모든 응시자의 위치를 검사했으나 거리두기를 지키지 않은 경우를 발견하지 못했으면
            //거리두기를 지킨 것
            private static final int dx[]={0,-1,1,0};
            private static final int dy[]={-1,0,0,1};

            public int[] solution(String[][] places) {
                int[] answer = new int[places.length];
                for (int i=0; i<answer.length;i++){
                    String[] place= places[i];
                    char[][] room= new char[place.length][];

                    for (int j=0;j<room.length;j++){
                        room[j]=place[j].toCharArray();
                    }
                    if(isDistanced(room)){
                        answer[i]=1;
                    }
                    else
                        answer[i]=0;
                }
                return answer;
            }

            //이제 각 대기살(room)이 거리두기를 지키고 있는지 확인
            private boolean isDistanced(char[][] room){
                //거리두기 검사
                for(int y=0;y< room.length;y++)
                {
                    for (int x=0;x<room[y].length;x++){
                        if(room[y][x]!= 'P')
                            continue;
                        if (!isDistanced(room,x,y))
                            return false;
                    }
                }
                return true;
            }

            //해당 대기실에서 x,y위치의 응시자가 거리두기를 지키고 있는지 검사
            private boolean isDistanced(char[][] room,int x, int y) {
                for (int d=0;d<4;d++){
                    int nx=x+dx[d];
                    int ny=y+dy[d];
                    if(ny<0 || ny>=room.length || nx<0 || nx>=room[ny].length)
                        continue;
                    //room[ny][nx]를 통해 다른 응시자에게 도달 할 수 있는지 검사

                    switch (room[ny][nx]){
                        case 'P' : return false;
                        case 'O' :
                            //인접한 곳에 다른 응시자가 있는지 검사
                            if (isNextToVolunteer(room,nx,ny,3-d))
                                return false;
                            break;

                    }
                }
                return true;
            }
            private boolean isNextToVolunteer(char[][] room, int x,int y, int exclude){
                for (int d=0; d<4; d++){
                    if(d==exclude) continue;
                    int nx= x+dx[d];
                    int ny= y+dy[d];

                    if(ny<0 ||ny>= room.length || nx<0 ||nx>=room[ny].length)
                        continue;
                    if (room[ny][nx]=='P') return true;
                }
                return false;
            }
        }