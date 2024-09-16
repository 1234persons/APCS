public class PiggyBank {
    double money;
    public PiggyBank() {
        money = 0;
    }

    public void addPennies(double numPennies) {
        money += numPennies*.01;
    }
    
    public void addNickels(double numNickels) {
        money += numNickels*.05;
    }
    
    public void addDimes(double numDimes) {
        money += numDimes*.10;
    }
    
    public void addQuarters(double numQuarters) {
        money += numQuarters*.25;
    }
    
    public void withdrawal(double amount) {
        money -= amount;
    }


    public double getMoney() {
        return(money);
    }

}
