package application.model;

import lombok.Data;

@Data
public class AdverseEvent {

    private String info;
    private int yearNumber;
    private int animalDeathMinPercent = 5;
    private int animalDeathMaxPercent = 20;
}
