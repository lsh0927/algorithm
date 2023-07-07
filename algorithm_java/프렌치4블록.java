import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        int a=m-1;
        int b=n-1;
        int i,j =0;
         
        while(check(board)!=0)
        { 
           
            for(i=0;i<a-1;i++){
                for(j=0;j<b-1;j++)
                    {
                        if(board[i].charAt(j).equals(board[i].charAt(j+1)) &&
                        board[i].charAt(j).equals(board[i+1].charAt(j)) &&
                        board[i].charAt(j).equals(board[i+1].charAt(j+1)))
                        {              
                            record(i,j,board);
                        }
                    }
            }
            remove(i,j);
        }      
        return answer;
    }
    static void record(int p,int q, String[] board)
    {
        String a= board[p].subString(q+1);
        String b= board[p+1].substring(q+1);
    }
    //board[i].charAt(j) board[i].charAt(j+1) board[i+1].charAt(j) board[i+1].charAt(j+1)을 없애!
    //이러면 겹치는 부분을 반영할수가 없자나..ㅠㅠ
    
    
    //문자열 배열에 지워지는 부분을 모두 0으로 표기하고, 이중 for문이 끝나면 한번에 지워지고, 그다음 문자열을 내려오게 하는 것까지 해야하는데,,, 어렵네..
    
    String modifiedString1 = "x" + array[0].substring(1);
    

}


/*
 * 
 * import java.util.*;
class Solution {
    List<List<Character>> b;
    public int solution(int m, int n, String[] board) {
        b = new ArrayList<>();
        int ans = 0;

        for(int i = 0; i < n; i ++) b.add(new ArrayList<>());
        for(int i = 0; i < n; i ++)
            for(int j = m - 1; j >= 0; j --)
                b.get(i).add(board[j].charAt(i));

        while(true){
            int cnt = 0;                  
            for(int i = 0; i < n - 1; i ++) // 조건 확인, 소문자로 변경
                for(int j = b.get(i).size() - 1 ; j > 0; j --)
                    check(i, j);

            for(int i = 0; i < n; i ++) // 소문자만 제거
                for(int j = b.get(i).size() - 1 ; j >= 0; j --)
                    if(Character.isLowerCase(b.get(i).get(j))){
                        b.get(i).remove(j);
                        cnt ++;
                    }

            if(cnt == 0) break; // 더 없으면 break
            else ans += cnt;
        }

        return ans;
    }




    public void check(int i , int j){ //인접 4칸 같은지 조건 확인 후 소문자로 바꿔줌
        if(b.get(i).size() <= 1 || j >= b.get(i + 1).size()) return;

        char cUp = Character.toUpperCase(b.get(i).get(j));
        char cLow = Character.toLowerCase(cUp);
        if((b.get(i).get(j - 1) == cUp || b.get(i).get(j - 1) == cLow)
        && (b.get(i + 1).get(j) == cUp || b.get(i + 1).get(j) == cLow)
        && (b.get(i + 1).get(j - 1) == cUp || b.get(i + 1).get(j - 1) == cLow)){
            b.get(i).set(j, cLow);
            b.get(i + 1).set(j, cLow);
            b.get(i + 1).set(j - 1, cLow);
            b.get(i).set(j - 1, cLow);
        }
    }
}
 */

 /*
  * 

  class Solution {
  public int solution(int m, int n, String[] board) {
      int answer = 0;
      char[][] boardArr = new char[m+2][n+2];
      int answerbefor = -1;
                   for(int  i =0; i<m; i++){
          for(int  j =0; j<n; j++){
          boardArr[i][j]= board[i].toCharArray()[j];
         }  
      }

      while(true){
          if(answer == answerbefor){
              break;
          }
          answerbefor = answer;

        boolean[][] boardCleaner = new boolean[m+2][n+2];
              for(int  i =0; i<m; i++){
          for(int  j =0; j<n; j++){
              if(boardArr[i][j]==boardArr[i][j+1]&&boardArr[i][j]!=' '){
                   if(boardArr[i][j]==boardArr[i+1][j+1]){
                    if(boardArr[i][j]==boardArr[i+1][j]){
                        boardCleaner[i][j] = true;
                        boardCleaner[i+1][j] = true;
                        boardCleaner[i+1][j+1] = true;
                        boardCleaner[i][j+1] = true;
                    }
                    }
              }
             //System.out.print(boardArr[i][j]    );
         }  
         //  System.out.println();
         //  System.out.println();
      }
// System.out.println();

      for(int  i =0; i<m; i++){
          for(int  j =0; j<n; j++){
              if(boardCleaner[i][j]){
                   boardArr[i][j] = ' ';
                  answer++;
                  boardCleaner[i][j] = false;
              }

         }  

      }
   //    System.out.println("anser : "+answer);
      //   for(int  i =0; i<m; i++){
      //     for(int  j =0; j<n; j++){
      //         System.out.print(boardArr[i][j] );
      //    }  
      //   //   System.out.println(); 
      // }
// System.out.println();
        for(int k = 0; k<m; k++){
        for(int  i =m; i>0; i--){
          for(int  j =0; j<n; j++){
              if(boardArr[i][j]==' '){
                  // System.out.print("!");
              boardArr[i][j] = boardArr[i-1][j];
              boardArr[i-1][j] = ' ';
              }
         }  
           //System.out.println();
      }
        }
      //      for(int  i =0; i<m; i++){
      //     for(int  j =0; j<n; j++){
      //         System.out.print(boardArr[i][j] );
      //    }  
      //      System.out.println();
      // }
      //    System.out.println();
      }

      return answer;
  }
}
  */

  //모 이런 풀이도 있다...

  /*
   * class Solution {
  public int solution(int m, int n, String[] board) {
      int answer = 0;
      char[][] boardArr = new char[m+2][n+2];
      int answerbefor = -1;
                   for(int  i =0; i<m; i++){
          for(int  j =0; j<n; j++){
          boardArr[i][j]= board[i].toCharArray()[j];
         }  
      }

      while(true){
          if(answer == answerbefor){
              break;
          }
          answerbefor = answer;

        boolean[][] boardCleaner = new boolean[m+2][n+2];
              for(int  i =0; i<m; i++){
          for(int  j =0; j<n; j++){
              if(boardArr[i][j]==boardArr[i][j+1]&&boardArr[i][j]!=' '){
                   if(boardArr[i][j]==boardArr[i+1][j+1]){
                    if(boardArr[i][j]==boardArr[i+1][j]){
                        boardCleaner[i][j] = true;
                        boardCleaner[i+1][j] = true;
                        boardCleaner[i+1][j+1] = true;
                        boardCleaner[i][j+1] = true;
                    }
                    }
              }
         }  
            }
      for(int  i =0; i<m; i++){
          for(int  j =0; j<n; j++){
              if(boardCleaner[i][j]){
                   boardArr[i][j] = ' ';
                  answer++;
                  boardCleaner[i][j] = false;
              }

         }  

      }

        for(int k = 0; k<m; k++){
        for(int  i =m; i>0; i--){
          for(int  j =0; j<n; j++){
              if(boardArr[i][j]==' '){
                  // System.out.print("!");
              boardArr[i][j] = boardArr[i-1][j];
              boardArr[i-1][j] = ' ';
              }
         }  
         
      }
        }
     
      }

      return answer;
  }
}
   *///이 풀이가 제일 맞는것 같다