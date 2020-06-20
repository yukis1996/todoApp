package jp.co.aivick.todoapp.domain;

import org.seasar.doma.Domain;

@Domain(valueType = Integer.class, factoryMethod = "valueOf", accessorMethod = "getValue")
public enum Prioritize
{
    HIGH(1, "高"),
    MIDDLE(2, "中"),
    LOW(3, "低");

    final private int code;
    final private String label;

    Prioritize(Integer
        code, String label) {
        this.code = code;
        this.label = label;
    }

    public static Prioritize valueOf(Integer code) {
        switch (code) {
            case 1:
                return HIGH;
            case 2:
                return MIDDLE;
            case 3:
                return LOW;
            default:
                throw new IllegalArgumentException("unknown prioritize type:" + code);
        }
    }

    public Integer getValue() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }
}
