class Solution {
            public long solution(int[] sequence) {

                int len = sequence.length;

                List<Integer> p1= new ArrayList<>();
                List<Integer> p2= new ArrayList<>();

                for (int i=0;i<len;i++){
                    if (i%2==0)
                    {
                        p1.add(1);
                        p2.add(-1);
                    }
                    else {
                        p1.add(-1);
                        p2.add(1);
                    }
                }
                List<Integer> list= new ArrayList<>();
                List<Integer> list2= new ArrayList<>();

                for (int i=0;i<len;i++){
                    list.add(sequence[i]* p1.get(i));
                    list2.add(sequence[i]* p2.get(i));
                }
                //투 포인터를 못쓰게 한듯

                //대신 list와 list2의 원소값이 양수인 곳에서 시작해서 양수인 곳까지 더하고,
                //그 뒤에 다시 양수가 나타나는 부분을 계속 더해서 다른 list에 추가한뒤에 비교하면 될거 같음
                int index=0;
                int index2=0;
               int sum=0;
               int sum2=0;

               List<Integer> f= new ArrayList<>();
               List<Integer> f2= new ArrayList<>();

                int l = Math.max(list.size(), list2.size()); // 더 긴 리스트의 길이를 기준으로 삼습니다.
                for (int i = 0; i < l; i++) {
                    // 첫 번째 리스트 처리
                    if (i < list.size()) { // 리스트의 범위를 넘지 않도록 확인
                        if (list.get(i) <= 0) {
                            f.add(sum);
                            sum = 0;
                        } else {
                            sum += list.get(i);
                        }
                    }

                    // 두 번째 리스트 처리
                    if (i < list2.size()) { // 리스트의 범위를 넘지 않도록 확인
                        if (list2.get(i) <= 0) {
                            f2.add(sum2);
                            sum2 = 0;
                        } else {
                            sum2 += list2.get(i);
                        }
                    }
                }

               int result= Collections.max(f);
               int result2= Collections.max(f2);

                return (result > result2) ? result : result2;

            }
        }