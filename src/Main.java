import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[]arr = new int[n + 1];

        Calculate(arr, n);

        System.out.println(arr[n]);
        PrintSequence(arr, n);
    }

    public static void Calculate(int[]arr, int n){
        arr[1] = 0;

        for (int i = 2; i <= n; i++){
            arr[i] = arr[i - 1] + 1;

            if (i % 2 == 0){
                if (arr[i / 2] + 1 < arr[i]){
                    arr[i] = arr[i / 2] + 1;
                }
            }

            if (i % 3 == 0){
                if (arr[i / 3] + 1 < arr[i]){
                    arr[i] = arr[i / 3] + 1;
                }
            }
        }
    }

    public static void PrintSequence(int[]arr, int n){
        int[]sequence = new int[arr[n] + 1];
        int i = arr[n];
        sequence[i] = n;
        i--;

        for (int j = n - 1; j >= 0; j--){
            if (arr[j] == arr[sequence[i + 1]] - 1){
                if (sequence[i + 1] == j + 1 || sequence[i + 1] / 2.0 == j || sequence[i + 1] / 3.0 == j){
                    sequence[i] = j;
                    i--;
                }
            }
        }

        for (int j = 0; j <= arr[n]; j++){
            System.out.print(sequence[j] + " ");
        }
    }
}
