package fpij.chp3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

final class ListFiles {
    public static void main(String[] args) throws IOException {
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
}
