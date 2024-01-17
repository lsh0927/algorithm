import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        class Solution {
            static char[] a;
            static int oBcnt=0;
            static int xBcnt=0;
            public int solution(String[] board) {
                int answer = -1;
                a=new char[9];
                for (int i=0;i<3;i++){
                    String b= board[i];
                    for(int j=0;j<3;j++){
                        a[i*3+j]=b.charAt(j);
                    }
                }

                if(Bingo()){
                    if(oBingo(a)){
                        if(!xBingo(a) && (oCount(a)-xCount(a)==1 && oBcnt<2)){
                            return 1;
                        }
                        else
                            return 0;
                    }
                    else {
                        if(!oBingo(a) && (oCount(a)==xCount(a)) && xBcnt<2){
                            return 1;
                        }
                        else
                            return 0;

                    }
                }
                else{
                   if( oCount(a)-xCount(a) == 0 || oCount(a)-xCount(a) == 1)
                       return 1;
                }

                return 0;

            }
            static boolean oBingo(char[] a){
                if(a[0]=='O' &&a[1]=='O' &&a[2]=='O')
                    oBcnt++;
                if(a[0]=='O' &&a[3]=='O' &&a[5]=='O')
                    oBcnt++;
                if (a[0]=='O' &&a[4]=='O' &&a[8]=='O' )
                    oBcnt++;
                if (a[1]=='O' &&a[4]=='O' &&a[7]=='O' )
                    oBcnt++;
                if (a[2]=='O' &&a[5]=='O' &&a[8]=='O' )
                    oBcnt++;
                if (a[2]=='O' &&a[4]=='O' &&a[6]=='O' )
                    oBcnt++;
                if(a[3]=='O' &&a[4]=='O' &&a[5]=='O' )
                    oBcnt++;
                if (a[6]=='O' &&a[7]=='O' &&a[8]=='O' )
                    oBcnt++;

                if(oBcnt>0)
                    return true;
                return false;
            }
            static boolean xBingo(char[] a){
                if(a[0]=='X' &&a[1]=='X' &&a[2]=='X')
                    xBcnt++;
                if(a[0]=='X' &&a[3]=='X' &&a[5]=='X')
                    xBcnt++;
                if (a[0]=='X' &&a[4]=='X' &&a[8]=='X' )
                    xBcnt++;
                if (a[1]=='X' &&a[4]=='X' &&a[7]=='X' )
                    xBcnt++;
                if (a[2]=='X' &&a[5]=='X' &&a[8]=='X' )
                    xBcnt++;
                if (a[2]=='X' &&a[4]=='X' &&a[6]=='X' )
                    xBcnt++;
                if(a[3]=='X' &&a[4]=='X' &&a[5]=='X' )
                    xBcnt++;
                if (a[6]=='X' &&a[7]=='X' &&a[8]=='X' )
                    xBcnt++;

                if(xBcnt++>0)
                    return true;
                return false;
            }
            private boolean Bingo(){
                if(xBingo(a) || oBingo(a)){
                    return true;
                }
                return false;
            }
            static int oCount(char[] a){
                int cnt=0;
                for(int i=0;i<9;i++){
                    if(a[i]=='O')
                        cnt++;
                }
                return cnt;
            }
            static int xCount(char[] a){
                int cnt=0;
                for(int i=0;i<9;i++){
                    if(a[i]=='X')
                        cnt++;
                }
                return cnt;
            }
        }
    }
}
/*
 * class Solution {
            static char[] a;
            static int oBcnt=0;
            static int xBcnt=0;
            public int solution(String[] board) {
                int answer = -1;
                a=new char[9];
                for (int i=0;i<3;i++){
                    String b= board[i];
                    for(int j=0;j<3;j++){
                        a[i*3+j]=b.charAt(j);
                    }
                }

                if(Bingo()){
                    if(oBingo(a)){
                        if(!xBingo(a) && (oCount(a)-xCount(a)==1)){
                            return 1;
                        }
                        else
                            return 0;
                    }
                    else {
                        if(!oBingo(a) && (oCount(a)==xCount(a))){
                            return 1;
                        }
                        else
                            return 0;

                    }
                }
                else{
                   if( oCount(a)-xCount(a) == 0 || oCount(a)-xCount(a) == 1)
                       return 1;
                }

                return 0;

            }
            static boolean oBingo(char[] a){
                if(     (a[0]=='O' &&a[1]=='O' &&a[2]=='O' ) ||
                        (a[0]=='O' &&a[3]=='O' &&a[5]=='O' ) ||
                        (a[0]=='O' &&a[4]=='O' &&a[8]=='O' ) ||
                        (a[1]=='O' &&a[4]=='O' &&a[7]=='O' ) ||
                        (a[2]=='O' &&a[5]=='O' &&a[8]=='O' ) ||
                        (a[2]=='O' &&a[4]=='O' &&a[6]=='O' ) ||
                        (a[3]=='O' &&a[4]=='O' &&a[5]=='O' ) ||
                        (a[6]=='O' &&a[7]=='O' &&a[8]=='O' )
                )
                    return true;
                return false;
              
            }
            static boolean xBingo(char[] a){
                if(     (a[0]=='X' &&a[1]=='X' &&a[2]=='X' ) ||
                        (a[0]=='X' &&a[3]=='X' &&a[5]=='X' ) ||
                        (a[0]=='X' &&a[4]=='X' &&a[8]=='X' ) ||
                        (a[1]=='X' &&a[4]=='X' &&a[7]=='X' ) ||
                        (a[2]=='X' &&a[5]=='X' &&a[8]=='X' ) ||
                        (a[2]=='X' &&a[4]=='X' &&a[6]=='X' ) ||
                        (a[3]=='X' &&a[4]=='X' &&a[5]=='X' ) ||
                        (a[6]=='X' &&a[7]=='X' &&a[8]=='X' )
                )
                    return true;
                return false;
            }
            private boolean Bingo(){
                if(xBingo(a) || oBingo(a)){
                    return true;
                }
                return false;
            }
            static int oCount(char[] a){
                int cnt=0;
                for(int i=0;i<9;i++){
                    if(a[i]=='O')
                        cnt++;
                }
                return cnt;
            }
            static int xCount(char[] a){
                int cnt=0;
                for(int i=0;i<9;i++){
                    if(a[i]=='X')
                        cnt++;
                }
                return cnt;
            }
        }
 */
//이상하게 이 코드가 더 정답률 높음;;