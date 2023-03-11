class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        //같은 1단계 맞나 왜케 난이도 차이 심함?
        //substring 0,length-4해서 다 *로 바꾸면 될듯
        //ㅋㅋ 안댐
        int len=phone_number.length();
        StringBuffer sb = new StringBuffer(); //StringBuffer 를 이용하자!
         sb.append(phone_number);
        
        for(int i=0;i<len-4;i++)
         sb.replace(i,i+1,"*");
        
         answer = sb.toString(); //항상 타입을 신경 쓸것
        return answer;
        
        //원래 였으면 배열로 split해서 접근했을텐데, 버퍼를 이용한다는 걸 알고나니 더 편한 느낌
    }
}
// class Solution { 다른 사람의 풀이
//     public String solution(String phone_number) {
//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        return String.valueOf(ch);
//     }
//   }
  