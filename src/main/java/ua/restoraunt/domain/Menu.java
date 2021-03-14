package ua.restoraunt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Integer id;
    private Integer idRestoraunt;
    private String name;
    private Double price;
    private Double weight;
    private Double timeOfCooking;

    public Menu(Integer idRestoraunt, String name, Double price, Double weight, Double timeOfCooking) {
        this.idRestoraunt = idRestoraunt;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.timeOfCooking = timeOfCooking;
    }
}
