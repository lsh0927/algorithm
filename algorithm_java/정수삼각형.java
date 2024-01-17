// import java.util.*;
// public class Solution {
//     private int max(int x, int y, int[][] triangle){
//         if(y== triangle.length) return 0;
//         return triangle[y][x]+Math.max(
//                 max(x,y+1,triangle),
//                 max(x+1,y+1,triangle));
//     }
    

//   public int solution(int[][] triangle){
//         return max(0,0, triangle);
//   }

// 통과하나 시간제한은 통과 x
// }

//메모이제이션 활용이 필요

import java.util.*;
public class Solution {
    private final int[][]mem= new int[501][501];
    
    private int max(int x, int y, int[][] triangle){
        if(y==triangle.length) return  0;
        if(mem[x][y]!=-1) return mem[x][y];

        return mem[x][y]= triangle[y][x]+Math.max(
                max(x,y+1,triangle),
                max(x+1,y+1,triangle));
    }


  public int solution(int[][] triangle){
        for(int[] row: mem){
            Arrays.fill(row,-1);
        }
        return max(0,0, triangle);
  }


}
//메모이제이션 배열 추가 -> 상태는 x,y 두개이므로 메모이제이션 배열은 2차원
// 각 변수의 최댓값은 500 이므로 길이가 501인 2차원 배열을 선언

//상태= (x,y) -> (x,y)를 꼭지점으로 하여 출발했을때 거쳐가는 숫자의 최댓값
// 종료 조건 (x,h)=0 -> h는 삼각혀으이 높이, 삼각형의 끝에 도달하면 더이상 경로가 없으므로 0을 반환하고 리턴
// (x,y)=[x,y]+Max((x,y+1),(x+1,y+1))

//메모이제이션 배열은 항상 유효하지 않은 값으로 초기화되어야 함 -> -1로 초기화
//재귀의 종료 조건에 메모이제이션이 되어 있는지 검사해야함
//-> 기존 종료 조건은 삼각형 끝에 도달하여 벗어났을 때를 검사하므로 유효 x
// if(mem[x][y]!=-1) return mem[x][y]