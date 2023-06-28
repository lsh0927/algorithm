import java.util.*;

class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X') {
                    grid[i][j] = -1; // 바다는 -1로 표시
                } else {
                    grid[i][j] = Character.getNumericValue(maps[i].charAt(j)); // 무인도 숫자로 표시
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) { // 무인도를 찾으면 탐색 시작
                    int maxDays = dfs(grid, visited, i, j);
                    insertSorted(results, maxDays); // 오름차순으로 삽입
                }
            }
        }

        if (results.isEmpty()) {
            results.add(-1);
        }

        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }

    private void insertSorted(List<Integer> list, int num) {
        int index = 0;
        while (index < list.size() && num > list.get(index)) {
            index++;
        }
        list.add(index, num);
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        int maxDays = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                if (grid[nx][ny] != -1 && !visited[nx][ny]) {
                    maxDays += dfs(grid, visited, nx, ny);
                }
            }
        }

        return grid[x][y] + maxDays;
    }
}
