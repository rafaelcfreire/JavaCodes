package mjic.chp12;

import java.time.LocalDate;

final class LocalDateExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 06, 24);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
    }
}