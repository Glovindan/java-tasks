import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task3 {
    private static void insertResults(Tests tests, Values values) {
        if(tests.values != null) {
            for (Tests item: tests.values) {
                insertResults(item, values);
            }
        }

        for (Values.TestsResult result: values.values) {
            if(result.id == tests.id) {
                tests.value = result.value;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String testsFilename = args[0];
        String valuesFilename = args[1];
        Gson gson = new Gson();

        //input
        Tests tests = gson.fromJson(new FileReader(testsFilename), Tests.class);
        Values testsResults = gson.fromJson(new FileReader(valuesFilename), Values.class);
        insertResults(tests, testsResults);

        String json = gson.toJson(tests);
        // output
        BufferedWriter writer = new BufferedWriter(new FileWriter("report.json"));
        writer.write(json);
        writer.close();
    }
}
