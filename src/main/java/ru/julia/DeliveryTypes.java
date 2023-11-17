package ru.julia;

/**
 * Класс перечисляет способы доставки
 */
public enum DeliveryTypes {
    MAIL("почтой"),
    EMAIL("эл.почтой"),
    PIGEON("голубем"),
    UZEDO("юзедой");
    private final String value;
    DeliveryTypes(String value) {
      this.value = value;
    }
    public String getValue() {
        return value;
    }
}
