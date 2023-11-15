class Solution {
            public int solution(int[][] routes) {

                //끝 지점에 가까울 수록 겹칠 확률 증가, 끝 지점을 기준으로 정렬

                Arrays.sort(routes,Comparator.comparingInt(route->route[1]));

                // 단속 카메라 설치
                int count=0;
                int last= Integer.MIN_VALUE;

                for (int[] route : routes) {
                    //직접에 설치한 단속 카메라가 경로에 포함되어 있다면
                    //이미 단속 카메라를 만났으므로 스킵
                    if (last >= route[0] && last<=route[1]) continue;

                    //단속 카메라를 만나지 못한 이동 경로일 경우
                    last=route[1];
                    count++;
                }

                return count;
            }
        }