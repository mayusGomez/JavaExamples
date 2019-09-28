package com.gm.pcworld;

public class Order {

    private int orderId;
    private Computer computers[];
    private static int orderCount;
    private int computerCount;
    private final int MAX_COMPUTERS=5;

    public Order(){
        this.orderId = ++Order.orderCount;
        this.computers = new Computer[MAX_COMPUTERS];
    }

    public void addComputer(Computer computer){
        if (this.computerCount < this.MAX_COMPUTERS){
            this.computers[computerCount++] = computer;
        }
        else {
            System.out.println("Computers overload:" + MAX_COMPUTERS);
        }
    }

    public void showOrder(){
        System.out.println("Order number:" + this.orderId);
        System.out.println("Total computers:" + this.computerCount);
        System.out.println("Computers list:");
        System.out.println("[");
        for (int i=0; i < this.computerCount ; i++){
            System.out.println("   " + computers[i]);
            System.out.print("  |  ");
        }
        System.out.print("]");
    }

}
