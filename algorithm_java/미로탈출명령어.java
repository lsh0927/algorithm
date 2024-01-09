import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static int[][] map;
    static boolean[][][] discovered;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static String[] dword = {"r", "d", "l", "u"};
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n][m];
        x -= 1;
        y -= 1;
        r -= 1;
        c -= 1;
        String answer = bfs(x, y, r, c, k);
        return answer;
    }
    private static String bfs(int x, int y, int r, int c, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.word.compareTo(o2.word);
            }
        });
        discovered = new boolean[map.length][map[0].length][k + 1];
        pq.add(new Node("", x, y, 0));
        discovered[x][y][1] = true;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = node.x + direction[d][0];
                int ny = node.y + direction[d][1];
                if (nx == r && ny == c && node.count + 1 == k) {
                    return node.word + dword[d];
                }
                if (range(nx, ny) && node.count + 1 < k && !discovered[nx][ny][node.count + 1]) {
                    discovered[nx][ny][node.count + 1] = true;
                    pq.add(new Node(node.word + dword[d], nx, ny, node.count + 1));
                }
            }
        }
        return "impossible";
    }

    private static boolean range(int nx, int ny) {
        return 0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length;
    }

    static class Node {
        String word;
        int x, y, count;

        Node(String word, int x, int y, int count) {
            this.word = word;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}