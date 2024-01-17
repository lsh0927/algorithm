import java.util.*;
import java.util.stream.Collectors;
 
class Solution {
            public int solution(String number) {
                List<Integer> numbers= number.chars()
                        .map(c->c-'0')
                        .boxed()
                        .collect(Collectors.toList());
                return getPrimes(0,numbers).size();
            }

            private Set<Integer> getPrimes(int num, List<Integer>numbers){
                //종료 조건 및 점화식 구현
                if (numbers.isEmpty()){
                    //num의 소수 여부에 따라 적절한 집합 반환
                    if (isPrime(num))
                        return Set.of(num);
                    return Set.of();
                }
                Set<Integer> primes= new HashSet<>();
                //점화식 구현
                if (isPrime(num))
                    primes.add(num);

                //상태 전이 구현
                for (int i=0; i<numbers.size();i++)
                {
                    //numbers.get(i)로 상태 전이 진행
                    int nextAcc= num*10+numbers.get(i);
                    List<Integer> nextNumbers= new ArrayList<>(numbers);
                    nextNumbers.remove(i);

                    primes.addAll(getPrimes(nextAcc,nextNumbers));
                }
                return primes;
            }
            private boolean isPrime(int n) {
                if (n <= 1) return false;
                for (int i = 2; i * i <= n; i++) {
                    if (n % i == 0)
                        return false;
                }
                return true;
            }
        }
        /*
         * 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {



        class Solution {
            static String[] arr;
            static int count=0;
            static boolean[] check= new boolean[7];

            static List<Integer> arr2= new ArrayList<>();

            public static boolean isPrime(int num){
                if (num==0)
                    return false;
                if (num==1)
                    return false;
                for (int i=2;i*i<=num; i++){
                    if(num%i ==0)
                        return false;
                }
                return true;
            }

            public int solution(String numbers) {
                String tmp="";

                for (int i=1; i<=numbers.length();i++)
                {
                    makePrime(numbers,tmp,i);
                }
                return count;
            }
            public static void makePrime(String n, String tmp, int len){
                if (tmp.length()==len){
                    if (!arr2.contains(Integer.parseInt(tmp)))
                    {
                        arr2.add(Integer.parseInt(tmp));
                        if (isPrime(Integer.parseInt(tmp)))
                            count++;
                    }
                    return;
                }

                for (int j=0; j<n.length();j++){
                    if (check[j]) continue;
                    tmp+=n.charAt(j);

                    check[j]=true;
                    makePrime(n,tmp,len);
                    check[j]=false;

                    tmp=tmp.substring(0,tmp.length()-1);
                }
            }
        }
    }
}

         */