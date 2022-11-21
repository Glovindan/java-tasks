import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final int M = Integer.parseInt(args[1]);
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }
        StringBuilder answer = new StringBuilder(new String());
        int index = 0;
        do {
            answer.append(array[index]);
            index = (index + M - 1) % N;
        } while (index != 0);

        System.out.println(answer);
    }
}
