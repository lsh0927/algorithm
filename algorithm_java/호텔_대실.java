import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {

        // [입실시간, 정리완료시간] 을 넣을 int 2차배열 생성 및 값 주입
        int[][] bookTime = new int[book_time.length][];
        for (int i = 0; i < book_time.length; i++) {
            bookTime[i] = new int[] { parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10 };
        }

        // 입실시간 오름차순 정렬
        Arrays.sort(bookTime, (a, b) -> a[0] - b[0]);

        // 현재 이용중인 방의 퇴실시간정보 사용을 위해 퇴실시간 min-heap 선언
        PriorityQueue<int[]> inUse = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;

        for (int i = 0; i < bookTime.length; i++) {

            // 다음입실시간 까지 정리가 완료되는방 poll처리
            while (!inUse.isEmpty() && inUse.peek()[1] <= bookTime[i][0]) {
                inUse.poll();
            }
            inUse.add(bookTime[i]);
            ans = Math.max(ans, inUse.size());
        }
        return ans;
    }

    // time String을 int값으로 변환
    protected int parseTime(String time) {
        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]), min = Integer.parseInt(hhmm[1]);
        return hour * 60 + min;
    }
}