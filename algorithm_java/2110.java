import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;
    static int[] house;
    static int max=0;

    static int result;
    public static void main(String[] args)  throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        house=new int[N];
        for(int i=0;i<N;i++)
            house[i]=Integer.parseInt(br.readLine());

        Arrays.sort(house);

        int lo=1; //최소 거리가 가질 수 있는 최솟값
        int hi= house[N-1]-house[0]+1;
        //최소거리가 가질 수 있는 최대값

        while(lo<hi)
        {
            int mid=(hi+lo)/2;
            //가운데 지정과 배열정렬은 이분 탐색에서 필수라고 생각하자
            if(canInstall(mid)<C) {
                //mid 거리에 대해 설치 가능한 공유기 개수가 M개수에 못 미치면
                //거리를 좁혀서 M을 채워야하니깐
                hi = mid;
            }
            else {
                //설치 개수가 M이상이면
                // 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를 찾아냄
                lo=mid+1;

            }
        }
        //upperBound는 탐색값을 초과하는 첫번째 값을 가리키므로
        //1을 빼줘야 최대값이 됨

        // *참고 Lower Bound는 '원하는 값 k 이상이 처음 나오는 위치를 찾는 과정
        System.out.println(lo-1);

    }
    static int canInstall(int dis){
        //첫번째 집은 무조건 설치한다는 가정
        //?
        int count=1;
        int lastlocate=house[0];
        for(int i=1; i<house.length;i++){
            int locate=house[i];

            //현재 탐색하는 집의 위치와 직접에 설치했던 집의 위치간 거리가
            //최소 거리보다 크거나 같을 때  공유기 설치 개수를 늘려주고
            //마지막 설치 위치 갱신

            if(locate-lastlocate>=dis){
                count++;
                lastlocate=locate;
            }
        }
        return count;
    }
}


/**
 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고,
 * 집 여러개가 같은 좌표를 가지는 일은 없다.
 *
 * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
 * 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에,
 * 한 집에는 공유기를 하나만 설치할 수 있고,
 * 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
 *
 * C개의 공유기를 N개의 집에 적당히 설치해서,
 * 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 */

/**
* 첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과
 * 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
 * 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi
 * (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.
**/

/**첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
 *
 *  sort.
 *  int len= arr[arr.length-1]-arr[0]
 *  int diff= arr[i]-arr[i-1]
 *  diff 중 그 값이 가장 ...
 *
 *

 //5 3
 //1
 //2
 //8
 //4
 //9

 //출력 3

 .1 .2 3 .4 5 6 7 .8 .9

 12345678910111213,,,,,,,

 //
 1569101218
 3
 1   6   12  18

 //
 **/