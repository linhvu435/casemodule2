package Case.OOP;

import java.io.Serializable;

public class Food implements Serializable {
    public int FoodID;
    public String FoodName;
    public double FoodPrice;
    public int NumberFood;

    public Food() {
    }

    public Food(int foodID, String foodName, double foodPrice, int numberFood) {
        FoodID = foodID;
        FoodName = foodName;
        FoodPrice = foodPrice;
        NumberFood = numberFood;
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int foodID) {
        FoodID = foodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public double getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        FoodPrice = foodPrice;
    }

    public int getNumberFood() {
        return NumberFood;
    }

    public void setNumberFood(int numberFood) {
        NumberFood = numberFood;
    }

    @Override
    public String toString() {
        return "Food{" +
                "FoodID=" + FoodID +
                ", FoodName='" + FoodName + '\'' +
                ", FoodPrice=" + FoodPrice +
                ", NumberFood=" + NumberFood +
                '}';
    }
}
