package ru.julia.representatives;

import java.util.Arrays;
import java.util.List;

public class ExternalRepresentatives {
    static List<String> representatives = Arrays.asList("Алексеев Алексей Алексеевич", "Владимиров Владимир Владимирович", "Дмитриев Дмитрий Дмитриевич");
    public static String randomRepresentative() {
        return representatives.get((int) (Math.random() * 3));
    }
}
