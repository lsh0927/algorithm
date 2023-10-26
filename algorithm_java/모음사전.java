class Solution {
            //상태 (word) : word 로 시작하는 모든 단어
            // 이 상태는 word 로 시작하는 모든 단어를 반환
            // 종료조건 (길이가 5인 word) = word
            // 점화식 (word) = [word] + (word +'A')+(word +'E')+(word +'I')+(word +'O')+(word +'U')

            private static final char[] CHARS= "AEIOU".toCharArray();

            public int solution(String word) {
                List<String> words= new ArrayList<>();
                generate("",words);
                return words.indexOf(word);
            }
            private void generate(String word,List<String> words){
                words.add(word);
                if (word.length()==5) return;
                for (char c: CHARS){
                    generate(word+c,words);
                }
            }
        }