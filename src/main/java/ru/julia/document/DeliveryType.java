package ru.julia.document;

/**
 * Класс перечисляет способы доставки
 */
public enum DeliveryType {
    MAIL("почтой"),
    EMAIL("эл.почтой"),
    PIGEON("голубем"),
    UZEDO("юзедой");
    private final String value;
    DeliveryType(String value) {
      this.value = value;
    }
    public String getValue() {
        return value;
    }
}
