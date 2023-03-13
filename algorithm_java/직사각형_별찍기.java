import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i=0;i<b;i++)
        {
            for(int j=0;j<a;j++)
            {
                System.out.print("*");
            }
             System.out.println();
        }
        
    }
}

/*
print : 괄호안 내용을 단순히 출력. 개행문자(=줄바꿈문자=\n) 포함안됨.
printf : C에서의 printf와 동일. %d, %s 등을 쓰기위해 사용. 개행문자 포함X
println : 괄호안 내용을 출력한 후 마지막에 개행문자가 포함되어 있어 출력후 한 줄 띄워짐.
 */