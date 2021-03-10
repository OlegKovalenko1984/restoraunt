package ua.restoraunt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restoraunt {
    private int id;
    private String name;
    private boolean hasDelivery;
    private String linkToSite;
    private int countOfEmployers;
    private boolean isAlcoholAllowed;
    private boolean hasSummerPlatform;
    private String timeOfWork;

    public Restoraunt(String name, boolean hasDelivery, String linkToSite, int countOfEmployers, boolean isAlcoholAllowed, boolean hasSummerPlatform, String timeOfWork) {
        this.name = name;
        this.hasDelivery = hasDelivery;
        this.linkToSite = linkToSite;
        this.countOfEmployers = countOfEmployers;
        this.isAlcoholAllowed = isAlcoholAllowed;
        this.hasSummerPlatform = hasSummerPlatform;
        this.timeOfWork = timeOfWork;
    }
}
