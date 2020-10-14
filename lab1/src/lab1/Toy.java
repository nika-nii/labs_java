package lab1;

abstract class Toy extends Product{
    public boolean canBuy(int money){
        if (money > getCost()){
            return true;
        }
        return false;
    };
}