package ru.julia.representatives;

import java.util.Arrays;
import java.util.List;

public class InternalRepresentatives {
    List<String> representatives = Arrays.asList("Петров Петр Петрович", "Иванов Иван Иванович",
                                                "Сидоров Сидр Сидорович", "Александров Александр Александрович");
    public String randomRepresentative() {
        return representatives.get((int) (Math.random() * 4));
    }
}
