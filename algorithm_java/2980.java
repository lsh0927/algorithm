import javax.management.relation.Role;
import java.util.Arrays;
import java.util.*;

public class Main {
    static siginfo []sig;
    static int L;
    static int sec=0;
    static int lo=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        L= sc.nextInt();
        sig = new siginfo[N];
        for (int i = 0; i < N; i++) {
            sig[i] = new siginfo(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        for(int k=0;k<N;k++) {
            if(k==0)
                circulate(sig[k].D, sig[k].R, sig[k].G);
            else if(k==N-1) {
                circulate(sig[k].D , sig[k].R, sig[k].G);
                sec += L - sig[k].D;
            }
            else{
                circulate(sig[k].D, sig[k].R, sig[k].G);

            }
        }
        System.out.println(sec);
    }
    public static class siginfo{ //신호등 클래스 지정
        int D;
        int R;
        int G;
        public siginfo(int d, int r, int g) {
            this.D = d;
            this.R = r;
            this.G = g;
        }
    }
    public static int circulate(int D, int R, int G){  //해당 신호등과 그 전 신호등 사이의 거리, 기다리는 시간을 계산하고 
        //현재 위치 재설정
        int signal=R+G;
        int cd=D-lo;
        lo=D;
        sec+=cd;
        if(sec%signal<R)
            sec+=R-(sec%signal);
        ;
        return sec;
    }
}   