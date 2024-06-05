package fpij.chp3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class ListSubDirs {
    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        File[] filesInCurrentDir = new File(".").listFiles();
        for (File file : filesInCurrentDir) {
            Optional<File[]> filesInSubdir = Optional.ofNullable(file.listFiles());
            filesInSubdir.ifPresentOrElse((allFiles) -> files.addAll(Arrays.asList(allFiles)), () -> files.add(file));
        }
        System.out.println("Count: "+files.size());

        List<File> filesFlatMap = Stream.of(new File(".").listFiles())
                .flatMap(file -> file.listFiles() == null ?
                        Stream.of(file) : Stream.of(file.listFiles()))
                .collect(Collectors.toUnmodifiableList());
    }
}
