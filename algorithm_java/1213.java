import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str= br.readLine();
        char[] answer = new char[str.length()];
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }

        boolean check = false;
        for(int a : map.values()) {
            if(a % 2 != 0) {
                if(check) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                check = true;
            }
        }

        char temp = 'a';
        int sidx = 0, eidx = str.length()-1;

        int idx = 0;
        char[] arr = new char[map.size()];
        for(Character c: map.keySet()) {
            arr[idx++] = c;
        }
        Arrays.sort(arr);

        for(char c: arr) {
            //짝수개이면
            if(map.get(c) % 2 == 0) {
                for(int i = 0; i < map.get(c); i+=2) {
                    answer[sidx++] = c;
                    answer[eidx--] = c;
                }
            }else {
                for(int i = 0; i < map.get(c) - 1; i+=2) {
                    answer[sidx++] = c;
                    answer[eidx--] = c;
                }
                temp = c;
            }
        }

        if(temp != 'a')
            answer[sidx] = temp;
        for(char c : answer)
            System.out.print(c);
    }

}