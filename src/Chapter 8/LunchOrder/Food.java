
public class Food {
    
    private int fat, carbs, fiber;
    private double price;


    public Food(double price, int fat, int carbs, int fiber) {
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
        this.price = price;
    }

    public int getFat() {
        return(fat);
    }
    
    public int getCarbs() {
        return(carbs);
    }
    
    public int getFiber() {
        return(fiber);
    }

    public double getPrice() {
        return(price);
    }
    


}
