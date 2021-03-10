package ua.restoraunt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int id;
    private int idRestoraunt;
    private String name;
    private double price;
    private double weight;
    private double timeOfCooking;

    public Menu(int idRestoraunt, String name, double price, double weight, double timeOfCooking) {
        this.idRestoraunt = idRestoraunt;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.timeOfCooking = timeOfCooking;
    }
}
