	class Solution {
    int answer = Integer.MAX_VALUE;
    int total = 0;
    int[] visited;
    
    public int solution(int[] picks, String[] minerals) {
        visited = new int[picks.length];
 
        for (int pick : picks) {
            total += pick;
        }
 
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == visited[i]) {
                continue;
            }
            visited[i]++;
            dfs(1, 0, i, 0, picks, minerals);
            visited[i]--;
        }
 
 
        return answer;
    }
 
    private void dfs(int count, int startMineralsIdx, int pickIdx, int sum, int[] picks, String[] minerals) {
        if (answer <= sum || startMineralsIdx >= minerals.length) {
            return;
        }       
 
        int add = 0;
 
        for (int i = startMineralsIdx; i < startMineralsIdx + 5; i++) {
            if (i >= minerals.length) {
                break;
            }
 
            String mineral = minerals[i];
 
            if (pickIdx == 0) {
                add += 1;
            } else if (pickIdx == 1) {
                add += mineral.equals("diamond") ? 5 : 1;
            } else if (mineral.equals("diamond")) {
                add += 25;
            } else {
                add += mineral.equals("iron") ? 5 : 1;
            }
        }
 
        if (count >= total || startMineralsIdx + 5 >= minerals.length) {
            answer = Math.min(answer, sum + add);
            return;
        }
 
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0 || picks[i] == visited[i]) {
                continue;
            }
 
            visited[i]++;
            dfs(count + 1, startMineralsIdx + 5, i, sum + add, picks, minerals);
            visited[i]--;
        }
    }
}