 class Solution {

            private static final char[] CHARS="AEIOU".toCharArray();

            public int solution(String word) {
                return  generate("").indexOf(word);
                //TODO 왜 별다른 인덱스 처리 없이 ""만으로 답을 구할 수 있는가?
            }

            private List<String> generate (String word){
                ArrayList<String> words = new ArrayList<>();

                words.add(word);

                if (word.length()==5) return words;

                for (char c : CHARS) {
                    words.addAll(generate(word+c));
                }
                return words;
            }
        }