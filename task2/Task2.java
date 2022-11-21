import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    private static int checkPoint(float pointX, float pointY, float circleX, float circleY, float circleRadius) {
        float equation = (float) (Math.pow((pointX - circleX), 2) + Math.pow((pointY - circleY), 2));
        float radiusSquare = (float) Math.pow(circleRadius, 2);
        if(equation == radiusSquare) return 0;
        if(equation < radiusSquare) return 1;
        return 2;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File circleCoordinatesFile = new File(args[0]);
        File pointsCoordinatesFile = new File(args[1]);
        StringBuilder answer = new StringBuilder(new String());

        Scanner circleReader = new Scanner(circleCoordinatesFile);

        //Read circle center coordinate
        String[] circleCoordinates = circleReader.nextLine().split(" ");
        float circleX = Float.parseFloat(circleCoordinates[0]);
        float circleY = Float.parseFloat(circleCoordinates[1]);

        //Read circle radius
        float circleRadius = circleReader.nextFloat();

        circleReader.close();

        Scanner pointsReader = new Scanner(pointsCoordinatesFile);
        while (pointsReader.hasNextLine()) {
            String[] pointCoordinates = pointsReader.nextLine().split(" ");
            float pointX = Float.parseFloat(pointCoordinates[0]);
            float pointY = Float.parseFloat(pointCoordinates[1]);
            int isInside = checkPoint(pointX, pointY, circleX, circleY, circleRadius);
            answer.append(isInside).append("\n");
        }
        System.out.println(answer);
    }
}
