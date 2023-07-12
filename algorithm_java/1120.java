import java.util.*;

public class Main {

    public static void main(String[] args) {
        int count;
        Scanner sc = new Scanner(System.in);

        String x = sc.next();
        String y = sc.next();

        int s = x.length();
        int ss = y.length() - x.length();

        for (int i = 0; i <= ss; i++) {
            count = 0; // count 초기화

            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) != y.charAt(i+j)) { // 수정: y의 문자를 올바르게 비교
                    count++;
                }
            }
            if(s > count){
                s= count;
            }
        }

        System.out.println(s);
    }
}
