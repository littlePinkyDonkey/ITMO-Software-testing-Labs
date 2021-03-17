package andrei.teplyh.util;

import andrei.teplyh.AbstractFunction;
import lombok.Data;

import java.io.*;
import java.util.Locale;

@Data
public class CsvLogger {
    private String filePath = "src/test/resources/results/";
    private double step;
    private double lowerBorder;
    private double upperBorder;
    private final char CSV_SEPARATOR = ',';

    public CsvLogger(String fileName, double lowerBorder, double upperBorder, double step) {
        this.filePath = String.format("%s%s", filePath, fileName);
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
        this.step = step;
    }

    public void setFilePath(String fileName) {
        this.filePath = String.format("src/test/resources/results/%s", fileName);
    }

    public void log(AbstractFunction function) {
        String csvString = "";

        try(PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double i = lowerBorder; i < upperBorder; i += step) {
                double result = function.calculateFunction(i);
                csvString = String.format(Locale.US, "%f%s %f\n", i, CSV_SEPARATOR, result);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
