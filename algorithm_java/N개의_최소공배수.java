import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i=1; i<arr.length; i++) {
            answer = lcm(answer, arr[i]); //answer를  arr[0]으로 두어 바로 비교할수 있게함(진짜 말안된다 이걸 이렇게 쉽게 푸네,,,)

        }
        return answer;
    }

    public int lcm(int a, int b) { //두수의 곱을 최대공약수로 나누면 최소 공배수가 됨.
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b) {//gcd는 최대공약수를 찾는 함수
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
