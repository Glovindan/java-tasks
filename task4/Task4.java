import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    private static int[] getArrayFromFile(String filename) throws FileNotFoundException {
        File numbersFile = new File(filename);
        StringBuilder inlineArr = new StringBuilder("");

        Scanner numbersReader = new Scanner(numbersFile);

        while (numbersReader.hasNextLine()) {
            inlineArr.append(numbersReader.nextLine()).append(" ");
        }

        numbersReader.close();

        String[] arrString = inlineArr.toString().split(" ");
        int[] arrInt = new int[arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            arrInt[i] = Integer.parseInt(arrString[i]);
        }

        return arrInt;
    }
    private static int findAverage(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum / arr.length;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = getArrayFromFile(args[0]);

        int average = findAverage(arr);

        int answer = 0;
        for(int j: arr) {
            answer += Math.abs(j - average);
        }

        System.out.println(answer);
    }
}
