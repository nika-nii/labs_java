package ru.bstu.iitus.vt41.kid.enums;

import ru.bstu.iitus.vt41.kid.products.*;

public enum ProductType {

    CAMERA(1, Camera.class, "Камера"),
    CHEESE(2, Cheese.class, "Сыр"),
    RUBIKSCUBE(3, RubiksCube.class, "Кубик Рубика"),
    TV(4, Tv.class, "Телевизор");

    private Integer type;
    private String label;
    private Class<? extends Product> productClass;

    ProductType(int i, Class<? extends Product> productClass, String label) {
        type = i;
        this.productClass = productClass;
        this.label = label;
    }

    public Integer getType() {
        return this.type;
    }

    public String getLabel() {
        return this.label;
    }

    public Class<? extends Product> getProductClass() {
        return this.productClass;
    }

    public static ProductType val(Integer type) {
        for (ProductType p : values()) {
            if (p.getType().equals(type)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Было введено неверное значение!");
    }

    public static String getInputMessage() {
        String message = "";
        for (ProductType t : ProductType.values()) {
            message += String.format("%d: %s ", t.type, t.label);
        }
        return message;
    }

    public static ProductType valueof(Integer val) {
        for (ProductType p : ProductType.values()) {
            if (p.getType().equals(val)) return p;
        }
        return null;
    }
}
