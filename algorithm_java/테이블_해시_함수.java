class Solution {
            public int solution(int[][] data, int col, int row_begin, int row_end) {
                sort(data,col);
                List<Integer> mod= getResult(data,row_begin,row_end);
                return getXORResult(mod);
            }
            public static void sort(int[][]data,int col){
                Arrays.sort(data,(o1, o2) -> {
                    if(o1[col-1]==o2[col-1]){
                        return o2[0]-o1[0];
                    }
                    return o1[col-1]-o2[col-1];
                });
            }
            //튜플의 col번째 컬럼의 값을 기준으로 정렬, 혹은 첫번째 컬럼의 값을 기준으로 내림차순 정렬

            //정렬된 데이터에서 S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합으로 정의
            private static List<Integer> getResult(int[][]arr,int s, int e){
                List<Integer> result= new ArrayList<>();
                for (int i=s;i<=e;i++){
                    int sum=0;
                    for (int j=0;j<arr[0].length;j++){
                        sum+=arr[i-1][j]%i;
                    }
                    result.add(sum);
                }
                return result;
            }
            //begin<= i M=end인 모든 s_i를 누적하며 XOR한 값을 해시값으로 반환
            private static int getXORResult(List<Integer> modResult){
                int sum= modResult.get(0);
                for (int i=1; i<modResult.size();i++){
                    sum^=modResult.get(i);
                }
                return sum;
            }
        }
