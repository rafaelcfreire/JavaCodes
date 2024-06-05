package book.chp1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

final class FortuneServiceImpl implements FortuneService {
    private static final List<String> MESSAGES = asList(
            "Today you will have some refreshing juice", "Larry just bought your company");
    @Override
    public String randomFortune() {
        return MESSAGES.get(new Random().nextInt(MESSAGES.size()));
    }
}