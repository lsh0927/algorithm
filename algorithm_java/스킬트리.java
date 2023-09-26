class Solution {
            int answer = 0;
            int count = 0;
            char[] order; // 배열 크기를 동적으로 조정하기 위해 크기를 설정하지 않음
            ArrayList<Character> temp = new ArrayList<>();

            public int solution(String skill, String[] skill_trees) {
                order = skill.toCharArray(); // 문자열을 char 배열로 변환

                for (int i = 0; i < skill_trees.length; i++) {
                    temp = new ArrayList<>();
                    for (char c : order) {
                        temp.add(c);
                    }
                    for (int j = 0; j < skill_trees[i].length(); j++) {
                        if (check(skill_trees[i].charAt(j)))  {
                            if (!temp.contains(skill_trees[i].charAt(j))){
                                count++;
                            }
                            else if (!temp.isEmpty() && temp.get(0) == skill_trees[i].charAt(j)) {
                                count++;
                                temp.remove(0);
                            }
                            else if (temp.isEmpty())
                                count++;
                        }
                    }
                    if (count==skill_trees[i].length())
                        answer++;

                    count=0;

                    if(!temp.isEmpty())
                        temp.clear();
                }

                return answer;
            }

            public boolean check(char a) {
                for (int i = 0; i < order.length; i++) {
                    if (a == order[i])
                        return true;
                }
                return false;
            }
        }