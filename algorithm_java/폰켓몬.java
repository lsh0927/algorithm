import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], 1);

        return map.size() > nums.length / 2 ? nums.length / 2 : map.size();
    }
}
