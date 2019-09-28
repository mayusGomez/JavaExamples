package com.gm.pcworld;

public class Mouse extends InputDevice{
    private int mouseId;
    private static int mouseCount;

    public Mouse(String inputType, String brand) {
        super(inputType, brand);
        this.mouseId = Mouse.mouseCount++;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "mouseId=" + mouseId +
                '}';
    }

}
