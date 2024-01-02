import com.sun.source.tree.BreakTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        class Solution {
            int answer = 0, n = 0;
            int[][] wh = {{1, 0, -1, 0}, {0, 1, 0, -1}}, board;

            StringBuilder sb = new StringBuilder();
            List<String> empty = new ArrayList<>();

            public int solution(int[][] game_board, int[][] table) {
                n = game_board.length;
                board = game_board;

                // 빈 칸을 문자열로 만들어 저장
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(board[i][j] == 0) {
                            sb = new StringBuilder();
                            dfs(i, j, 1);
                            empty.add(sb.toString());
                        }
                    }
                }

                // dfs를 쓰기 위해 table의 값들을 -1
                for(var t : table) {
                    for(int i = 0; i < n; i++) {
                        t[i]--;
                    }
                }
                board = table;

                // table을 90도씩 돌리면서 확인해본다.
                for(int r = 0; r < 4; r++) {
                    rotate();
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < n; j++) {
                            if(board[i][j] != -1) {
                                sb = new StringBuilder();
                                dfs(i, j, board[i][j] ^ 1);
                                // 존재한다면 퍼즐 조각 만큼 answer에 더해줌
                                int idx = empty.indexOf(sb.toString());
                                if(idx != -1) {
                                    empty.remove(idx);
                                    answer += sb.toString().replaceAll("[()]", "").length() + 1;
                                    dfs(i, j, -1);
                                }
                            }
                        }
                    }
                }
                return answer;
            }

            void rotate() {
                int[][] rotate = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        rotate[i][j] = board[n - j - 1][i];
                    }
                }
                board = rotate;
            }

            void dfs(int a, int b, int v) {
                board[a][b] = v;
                sb.append("(");
                for(int i = 0; i < 4; i++) {
                    int x = a + wh[0][i], y = b + wh[1][i];
                    if(0 <= x && 0 <= y && x < n && y < n && board[x][y] != board[a][b] && board[x][y] != -1) {
                        sb.append(i);
                        dfs(x, y, v);
                    }
                }
                sb.append(")");
            }
        }
    }
}