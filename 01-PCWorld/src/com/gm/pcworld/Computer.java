package com.gm.pcworld;

public class Computer {

    private int computerId;
    private String name;
    private Monitor monitor;
    private KeyBoard keyBoard;
    private Mouse mouse;
    private static int computerCount;

    private Computer(){
        this.computerId = Computer.computerCount++;
    }

    public Computer(String name, Monitor monitor, KeyBoard keyBoard, Mouse mouse){
        this();
        this.name = name;
        this.monitor = monitor;
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerId=" + computerId +
                ", name='" + name + '\'' +
                ", monitor=" + monitor +
                ", keyBoard=" + keyBoard +
                ", mouse=" + mouse +
                '}';
    }
}
