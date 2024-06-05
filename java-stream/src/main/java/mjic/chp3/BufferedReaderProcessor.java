package mjic.chp3;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
interface BufferedReaderProcessor {
    //The signature of a method on a functional interface is called functional descriptor
    String process(BufferedReader bufferedReader) throws IOException;
}