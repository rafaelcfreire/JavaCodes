package mjic.chp12;

import java.time.Instant;

final class InstantExample {
    public static void main(String[] args) {
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3, 0));
    }
}