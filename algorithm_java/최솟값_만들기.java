import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int[] reverse = new int[B.length];

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < B.length; i++) {
            reverse[i] = B[B.length - 1 - i];
        }
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * reverse[i];
        }

        return answer;
    }
}