package fpij.chp3;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

final class ListSelectFiles {
    public static void main(String[] args) throws IOException {
        final String[] files = new File("/Users/rafaelcfreire/java/workspace/JavaCodes/java-stream/src/main/java/fpij/chp3").list(new FilenameFilter() {
            @Override
            public boolean accept(final File dir, final String name) {
                return name.endsWith(".java");
            }
        });

        final String[] filesTwo = new File("/Users/rafaelcfreire/java/workspace/JavaCodes/java-stream/src/main/java/fpij/chp3").list((dir, name) -> name.endsWith(".java"));

        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }

        Files.newDirectoryStream(Paths.get("."), path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
}
