import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = "";

        // n을 k진수로 변환하는 경우
        // 변환된 수 안에 소수(primenum을 출력)
        s = decimalToBaseK(n, k);
        System.out.println(s);

        // s에 k진수가 이제 담겼고, 이것을 0을 기준으로 나눠야함.
        // 나누는 기준은 0p0, p0, 0p, p (p는 소수)
        String[] parts = s.split("0");

        for (String part : parts) {
            if (part.equals("")) { // 입력된 문자열이 빈 문자열인 경우
                continue; // 다음 문자열로 이동
            }
            int num = Integer.parseInt(part);
            if (num <= 1) { // 음수와 1은 소수가 아님
                continue;
            }
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public static String decimalToBaseK(int num, int k) {
        if (k == 1) {
            return "1".repeat(num);
        }
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = num % k;
            sb.append(remainder);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
