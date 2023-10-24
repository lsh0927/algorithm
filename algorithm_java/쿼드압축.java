 class Solution {
            public int[] solution(int[][] arr) {

                //압축할 특정 영역을 S라 하면
                //S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킴
                //그렇지 않다면 정확히 네개의 균일한 정사각형 영역으로 쪼갠 후 각 정사각형에 대해
                //같은 방식의 압축 시도

                //재귀 정의
                //1. 상태
                //2. 종료 조건
                //3. 점화식

            Count count= count(0,0,arr.length,arr);
            return new int[] {count.zero,count.one};
            }
            private static class Count{
                public final int zero;
                public final int one;

                public Count(int zero, int one) {
                    this.zero = zero;
                    this.one = one;
                }
                public Count add(Count other){
                    return new Count(zero+ other.zero,one+ other.one);
                }
            }
            private Count count(int offsetX, int offsetY, int size, int[][]arr){
                //종료 조건: 정사각형 영역안의 모든 원소가 같은 값을 가질 떄!
                int h=size/2;
                for (int x=offsetX; x<offsetX+size;x++){
                    for (int y=offsetY; y<offsetY+size; y++){
                        if (arr[y][x]!= arr[offsetY][offsetX]){
                            return count(offsetX,offsetY,h,arr)
                                    .add(count(offsetX+h,offsetY,h,arr))
                                    .add(count(offsetX,offsetY+h,h,arr))
                                    .add(count(offsetX+h,offsetY+h,h,arr));

                        }
                    }
                }
                if (arr   [offsetY][offsetX]==1)
                    return new Count(0,1);
                return new Count(1,0);
            }
        }