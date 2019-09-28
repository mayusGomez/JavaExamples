package pcworld;

import com.gm.pcworld.*;

public class PCWorld {
    public static void main(String[] args) {
        //Create Toshiba 1
        Mouse mouse1 = new Mouse("usb", "Toshiba");
        KeyBoard keyBoard1 = new KeyBoard("wireless", "Toshiba");
        Monitor monitor1 = new Monitor("Toshiba", 23);
        Computer computerToshiba = new Computer("Toshiba", monitor1, keyBoard1, mouse1);

        // Create HP
        Mouse mouse2 = new Mouse("usb", "HP");
        KeyBoard keyBoard2 = new KeyBoard("wireless", "HP");
        Monitor monitor2 = new Monitor("HP", 32);
        Computer computerHP = new Computer("HP", monitor2, keyBoard2, mouse2);

        // Clon
        Computer computerClon = new Computer("Clon", monitor2, keyBoard2, mouse1);

        // Create Order
        Order order = new Order();
        order.addComputer(computerToshiba);
        order.addComputer(computerHP);
        order.addComputer(computerClon);

        order.showOrder();

    }
}
