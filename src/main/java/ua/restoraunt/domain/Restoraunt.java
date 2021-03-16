package ua.restoraunt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restoraunt {
    private Integer id;
    private String name;
    private Boolean hasDelivery;
    private String linkToSite;
    private Integer countOfEmployers;
    private Boolean isAlcoholAllowed;
    private Boolean hasSummerPlatform;
    private String timeOfWork;

    public Restoraunt(String name, Boolean hasDelivery, String linkToSite, Integer countOfEmployers, Boolean isAlcoholAllowed, Boolean hasSummerPlatform, String timeOfWork) {
        this.name = name;
        this.hasDelivery = hasDelivery;
        this.linkToSite = linkToSite;
        this.countOfEmployers = countOfEmployers;
        this.isAlcoholAllowed = isAlcoholAllowed;
        this.hasSummerPlatform = hasSummerPlatform;
        this.timeOfWork = timeOfWork;
    }
}
