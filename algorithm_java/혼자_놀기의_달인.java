import java.util.PriorityQueue;

class Solution {

    //2 <= cards.length <= 100
    //cards[i] = i + 1번 상자에 담긴 카드에 적힌 숫자
    //cards[i] = x -> cards[x] = y -> cards[y] = i : 열려 있는 상자 까지 계속 연다. -> 1번 그룹
    //1번 그룹을 제외하고 남는 상자가 없으면 게임 종료 -> 점수 0점 획득
    //남은 상자 중 임의의 상자를 골라서 똑같이 그룹을 만듬
    //1번 그룹 x ... x n 번 그룹 = 최대 값 구하기

    private static boolean[] visited;
    private static int[] card;
    private static PriorityQueue<Integer> pq;

    public static int solution(int[] cards) {
        card = cards;
        visited = new boolean[cards.length];
        pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int count = go(i, 0);
                pq.add(count);
            }
        }

        return pq.size() < 2 ? 0 : pq.poll() * pq.poll();
    }

    private static int go(int current, int count) {
        if (!visited[current]) {
            int x = card[current];
            visited[current] = true;
            count = go(x - 1, count + 1);
        }
        return count;
    }
}

/*
 * import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int count=0;
        int count2=0;
        
        ArrayList<Integer> check= new ArrayList<>();
        ArrayList<Integer> check2= new ArrayList<>();
        ArrayList<Integer> c1= new ArrayList<>();
        ArrayList<Integer> c2= new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            check.add(cards[i]);
        }
        
        for(int a=0; a<cards.length;a++){
            int n=a;   
          
            while(check.get(n)!=0){
                if(n==0){
                    check.set(n,0);
                    n= check.get(cards[n]-1);
                    count++; 
                  }
                else{
                    check.set(n-1,0);
                    n= check.get(cards[n]-1);
                    count++; 
                }
            }    
           // c1.add(count);
            for(int v=0;v<check.size();v++)
            {
                if(check.get(v)!=0)
                    check2.add(v);
            }
            
            for(int u=0;u<check2.size();u++)
            {
                int q=u;   
                count2=0;
                while(check2.get(q)!=0){
                if(q==0){
                    check2.set(q,0);
                    q= check2.get(cards[q]-1);
                    count2++; 
                  }
                else{
                    check2.set(q-1,0);
                    q= check2.get(cards[q]-1);
                    count2++; 
                }
            }    
            c1.add(count*count2);
            }
            
        }
        
        answer=Collections.max(c1);
        
        return answer;
    }
}
 */