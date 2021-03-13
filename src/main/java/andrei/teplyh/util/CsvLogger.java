package andrei.teplyh.util;

import java.io.*;

public class CsvLogger {
    private PrintStream printStream;
    private final String filePath = "src/test/resources/";

    public CsvLogger(String fileName) {
        String path = String.format("%s%s", filePath, fileName);
        try {
            this.printStream = new PrintStream(new FileOutputStream(path, true));
        } catch (FileNotFoundException e) {
            new File(path);
        }
    }

    public void log(Double result, String moduleName) {
        if (moduleName.contains(",")) {
            moduleName = moduleName.replace(',', '.');
        }
        printStream.printf("%f, Результат модуля %s\n", result, moduleName);
        printStream.close();
    }
}
