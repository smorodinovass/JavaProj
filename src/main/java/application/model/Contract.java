package application.model;

import lombok.Data;

@Data
public class Contract {

    private int id;
    private int contractDurationInYears;

    private int numberOfYoungAnimalsSold;
    private int numberOfAdultAnimalsSold;
    private int numberOfOldAnimalsSold;

    private int youngAnimalSellingCost;
    private int adultAnimalSellingCost;
    private int oldAnimalSellingCost;

    private int costOfFeedNeedsToPurchased;

    private int unsoldAnimalForfeit;
}
