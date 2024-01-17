import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        //수의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 정수를 배열로 입력
        String[] input = br.readLine().split(" ");

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        //조건에 맞는 정렬
        sortOdd(numbers,N);
        sortEven(numbers,N);


        //결과 출력
        for (int num : numbers) {
            System.out.print(num + " ");
        }
}
    private static void sortEven(int[] numbers, int N) {
        for (int i = 1; i < N; i += 2) {
            for (int j = i + 2; j < N; j += 2) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }              
            }
        }
    }
    private static void sortOdd(int[] numbers,int N) {
        //
        for (int i = 0; i < N; i += 2) {
            for (int j = i + 2; j < N; j += 2) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }      
    }
}
