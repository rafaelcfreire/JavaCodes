package mjic.chp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

final class ExecuteAroundPatternExample {
    public static String processFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/rafaelcfreire/java/workspace/java-projects-module/java-stream/target/classes/data.txt"))) {
            return reader.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/rafaelcfreire/java/workspace/java-projects-module/java-stream/target/classes/data.txt"))) {
            return processor.process(reader);
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println(processFile());
        System.out.println(processFile((processor) -> processor.readLine()));
        System.out.println(processFile((processor) -> processor.readLine() + " Adding different behavior"));
        System.out.println(processFile((processor) -> processor.readLine() + processor.readLine()));
    }
}