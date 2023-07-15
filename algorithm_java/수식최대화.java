import java.util.*;
class Solution {
   
    // +, -, * 총 3가지 연산자이므로 가능한 경우의 수는 6가지 밖에 없고
    // 따라서 재귀보다 나열이 더 빠를 수 있음
    private static final String[][] precedences={
         "+-*".split(""), //["+","-","*"]와 같은 문자열 배열이 생성
         "+*-".split(""),
         "-+*".split(""),
         "-*+".split(""),
         "*+-".split(""),
         "*-+".split(""),
    };
    private long calculate(long lhs, long rhs, String op){
        return switch (op){
                case "+" ->lhs + rhs;
                case "-" ->lhs - rhs;
                case "*" ->lhs * rhs;
                default -> 0;
        }; //식이 주어지면 계산하는 함수
    }
  
    
    private long calculate(List<String> tokens, String[] precedence) { 
        for(String op: precedence){
            for(int i=0;i<tokens.size();i++){
                if(tokens.get(i).equals(op)){
                    long lhs=Long.parseLong(tokens.get(i-1));
                    long rhs=Long.parseLong(tokens.get(i+1));
                    long result= calculate(lhs,rhs,op);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1,String.valueOf(result));
                    i-=2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
         //문자열의 splitO 메서드를 사용하여 연산자를 기준으로 문자열을 분리한다면 연산자와 숫자는 나눌 수 있지만 분리 기준인 연산자는 잃게 됩니다. 따라서 이 문제에서는 StringTokenizer 클래스로 다음과 같이 문자열을 분리합니다.
    StringTokenizer tokenizer= new StringTokenizer(expression,"+-*",true);
    List<String> tokens= new ArrayList<>();
    while(tokenizer.hasMoreTokens()){
        tokens.add(tokenizer.nextToken());
    }
        long max=0;
        for(String[] precedence: precedences){
            long value= Math.abs(calculate(new ArrayList<>(tokens),precedence));
            if(value >max){
                max=value;
            }
        }
        return max;
    }
}


 //등장하는 연산자 개수를 M이라고 하면, 순서를 정하는 경우의 수는 M!가 되어 전체 시간 복잡 도는 O(N3M!)가 됩니다. N의 최댓값은 100, M의 최댓값은 3이므로 이를 대입해서 계산하면 6,000,000이 되어 제한 시간 안에 충분히 계산되는 시간 복잡도를 얻을 수 있습니다.
    
    //배열이나 ArrayList를 사용하면 하나의 연산자를 계산할 때 해당 연산자 뒤에 있는 모든 문자를 당겨 와야 하므 로 추가적인 0(N)0| 발생합니다. 이 문제는 N0| 작기 때문에 시간 복잡도에 문제없었습니다. LinkedList를 사용하면 리스트 중간의 원소 삽입이나 제거가 0(1) 만에 되므로 LinkedList와 Iterator를 사 용하면 전체 시간 복잡도를 O(N2M!)로 줄일 수 있습니다.