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