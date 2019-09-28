package com.gm.pcworld;

public class KeyBoard extends  InputDevice{

    private int keyBoardId;
    private static int keyBoardCount;

    public KeyBoard(String inputType, String brand){
        super(inputType, brand);
        this.keyBoardId = keyBoardCount++;
    }

    @Override
    public String toString() {
        return "KeyBoard{" +
                "keyBoardId=" + keyBoardId +
                '}';
    }
}
