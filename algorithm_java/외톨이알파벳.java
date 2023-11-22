 class Solution {
            public String solution(String input_string) {

                input_string= "."+ input_string+".";
                StringBuilder sb= new StringBuilder();


                /*
                많은 문자열을 연결하면, 많은 중간 문자열 객체가 생성되어 비효율적인 코드가 생성된다
                ->왜?
                Java 에서 String 객체는 변경이 불가능
                하나의 문자열을 다른 문자열과 연결하면 새 문자열이 생성되고,
                이전 문자열은 가비지 컬렉터로 들어감
                */

                for (char c= 'a'; c<='z';c++){
                    if (input_string.split(c+"+").length<3){
                        continue;
                    }
                    sb.append(c);
                }


                if (sb.length()==0) return "N";
                return sb.toString();
            }
        }