package andrei.teplyh.util;

import java.io.*;
import java.util.Locale;

public class CsvLogger {
    private String filePath = "src/test/resources/";
    private final char CSV_SEPARATOR = ',';

    public CsvLogger(String fileName) {
        this.filePath = String.format("%s%s", filePath, fileName);
    }

    public void log(Double x, Double result) {
        String csvString = String.format(Locale.US, "%f%s %f\n", x, CSV_SEPARATOR, result);

        try(PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            printStream.print(csvString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
