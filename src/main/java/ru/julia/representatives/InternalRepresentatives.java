package ru.julia.representatives;

import java.util.Arrays;
import java.util.List;

public class InternalRepresentatives {
    static List<String> representatives = Arrays.asList("Петров Петр Петрович", "Иванов Иван Иванович",
            "Сидоров Сидр Сидорович", "Александров Александр Александрович");

    public static String randomRepresentative() {
        return representatives.get((int) (Math.random() * 4));
    }
}
