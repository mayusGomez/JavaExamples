package com.gm.pcworld;

/**
 * This Class allow to create computers objects, each object must have a Moninor, KeyBoard and a Mouse.
 */

public class Computer {

    /**
     * computer identification
     */
    private int computerId;
    /**
     * computer description
     */
    private String name;
    /**
     * Monitor object to compound the computer
     */
    private Monitor monitor;
    /**
     * Keyboard object to compound the computer
     */
    private KeyBoard keyBoard;
    /**
     * Mouse object to compound the computer
     */
    private Mouse mouse;
    /**
     * Control the number of computers created
     */
    private static int computerCount;

    /**
     * Private constructor. Assign the computer identification and increment the counter.
     */
    private Computer(){
        this.computerId = Computer.computerCount++;
    }

    /**
     * Public Contructor. receive the necessary attributes to build de computer object
     * @param name Computer's description
     * @param monitor Monitor Object
     * @param keyBoard KeyBoard Object
     * @param mouse Mouse Object
     */
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
