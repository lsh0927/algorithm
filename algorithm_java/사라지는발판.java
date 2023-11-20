import java.util.*;

class Solution {
            /*
            플레이어의 전략
            (x,y)에서 이동할 수 있는 경우
            (x,y-1), (x,y+1), (x-1,y), (x+1,y)

            재귀적으로 경기 결과를 구해 나갈 수 있음
            재귀 상태는 플레이어 위치 player, 상대방 위치 opponent, 발판 상태 board

            상태: (player,opponent,board)  player 승리 여부와 최적 이동 횟수
            종료 조건: board[player.y][player.x] == 0 -> {lose,0}
            player 이동 불가->{lose,0}

            현재 위치에 발판이 없거나, 이동할 수 있는 발판이 없는 경우

            점화식
            (player,opponent,board)= (opponent,player(up||down||left||right),board)에서
             승리하는 경우는 그 중 최소 이동 횟수
             승리하는 경우가 없으면 최대 이동 횟수
            */
            private static final int[] dx={0,0,-1,1};
            private static final int[] dy={-1,1,0,0};
            
            private static class Coord{
                public final int x;
                public final int y;

                public Coord(int x, int y) {
                    this.x = x;
                    this.y = y;
                }
            }
            //플레이어 위치를 나타낼 클래스

            private static class Result{
                public final boolean win;
                public final int turns;

                public Result(boolean win, int turns) {
                    this.win = win;
                    this.turns = turns;
                }
            }

            public int solution(int[][] board, int[] aloc, int[] bloc) {

                    return game(new Coord(aloc[1],aloc[0]),
                            new Coord(bloc[1],bloc[0]),board).turns;
            }

            private Result game(Coord player, Coord opponent, int[][] board){
                if (board[player.y][player.x]==0){
                    return new Result(false,0);
                }
                //종료조건 1

                boolean win=false;
                int winTurns= Integer.MAX_VALUE;
                int loseTurns= Integer.MIN_VALUE;
                
                board[player.y][player.x]=0;
                
                //재귀호출
                for (int d=0;d<4;d++){
                    int nx= player.x+dx[d];
                    int ny= player.y+dy[d];
                    
                    if (ny<0 || ny>= board.length || nx<0  || nx >= board[ny].length)
                        continue;
                    if (board[ny][nx]==0)
                        continue;
                    
                    Result result=game(opponent,new Coord(nx,ny),board);
                    
                    if (!result.win){
                        win=true;
                        winTurns=Math.min(winTurns, result.turns);
                    } else if (!win) {
                        loseTurns=Math.max(loseTurns, result.turns);
                    }
                }
                
                board[player.y][player.x]=1;
                
                if (win){
                    return new Result(true,winTurns+1);
                }
                
                if (loseTurns==Integer.MIN_VALUE){
                    return new Result(false,0);
                }
                return new Result(false,loseTurns+1);
            }
        }