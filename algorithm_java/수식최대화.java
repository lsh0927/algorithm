import java.util.*; 
class Solution {
            private static final String[][] precedences={
                "+-*".split(""),
                "+*-".split(""),
                "-+*".split(""),
                "-*+".split(""),
                "*+-".split(""),
                "*-+".split(""),
            };

            public long solution(String expression) {

                StringTokenizer st= new StringTokenizer(expression,"+-*",true);
                List<String> tokens= new ArrayList<>();

                while (st.hasMoreTokens())
                    tokens.add(st.nextToken());

                long max=0;
                for (String[] precedence : precedences) {
                    long value= Math.abs(calculate(new ArrayList<>(tokens),precedence));
                    if (value>max)
                        max=value;
                }
                return max;
            }
            private long calculate(long lhs, long rhs, String op){
                return switch (op){
                    case "+" -> lhs+rhs;
                    case "-" -> lhs-rhs;
                    case "*" -> lhs*rhs;
                    default -> 0;
                };
            }
            private long calculate(List<String> tokens, String[] precedence) {
                for (String op : precedence) {
                    for (int i = 0; i < tokens.size(); i++) {
                        if (tokens.get(i).equals(op)) {
                            long lhs = Long.parseLong(tokens.get(i - 1));
                            long rhs = Long.parseLong(tokens.get(i + 1));
                            long result = calculate(lhs, rhs, op);

                            tokens.remove(i - 1);
                            tokens.remove(i - 1);
                            tokens.remove(i - 1);
                            tokens.add(i - 1, String.valueOf(result));
                            i -= 2;
                        }
                    }
                }
                return Long.parseLong(tokens.get(0));
            }
        }