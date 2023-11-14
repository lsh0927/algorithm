class Solution {
    public String solution(String number, int k) {
        
        Stack<Character> stack= new Stack<>();

        for (Character c : number.toCharArray()) {
            
            while (k>0 && !stack.isEmpty() && c>stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while (k-- >0){
            stack.pop();
        }
        
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}