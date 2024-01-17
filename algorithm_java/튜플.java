import java.util.*;
class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}

/*
 Set<String> set = new HashSet<>(); : HashSet 객체인 set을 생성합니다. 이 set은 중복을 허용하지 않는 특징을 가지며, 추출한 숫자를 저장할 때 사용됩니다.

String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , "); : 주어진 문자열 s에서 "{", "}" 문자를 공백으로 대체하고, 양쪽의 공백을 제거한 후 " , "를 구분자로 하여 문자열을 나눠서 arr 배열에 저장합니다.

Arrays.sort(arr, (a, b)->{return a.length() - b.length();}); : arr 배열을 정렬합니다. 이 때, 람다식을 사용하여 문자열의 길이를 기준으로 정렬합니다. 길이가 짧은 순서대로 정렬됩니다.

int[] answer = new int[arr.length]; : 결과를 저장할 배열인 answer를 생성합니다. 이 배열의 크기는 arr 배열의 길이와 동일합니다.

int idx = 0; : answer 배열의 인덱스를 나타내는 변수 idx를 초기화합니다.

for(String s1 : arr) : arr 배열의 각 요소에 대해 반복합니다.

for(String s2 : s1.split(",")) : 현재 요소 s1을 ","를 구분자로 하여 문자열을 나눠서 s2에 저장합니다.

if(set.add(s2)) answer[idx++] = Integer.parseInt(s2); : set에 s2를 추가하고, 추가가 성공적으로 이뤄진 경우 (중복이 아닌 경우) s2를 정수형으로 변환하여 answer 배열에 저장하고, idx를 증가시킵니다.

반복이 완료되면 answer 배열에 중복되지 않는 숫자가 저장되어 반환됩니다.

코드의 주요 로직은 중복을 허용하지 않는 Set을 사용하여 중복되지 않는 숫자를 추출하는 것입니다. 숫자 추출 후, 길이에 따라 정렬된 배열을 반환합니다.








 */