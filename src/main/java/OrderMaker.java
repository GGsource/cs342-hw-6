public class OrderMaker {
    Coffee myOrder;

    OrderMaker() {
        myOrder = new BasicCoffee();
    }

    public void addExtraShot() {
        myOrder = new ExtraShot(myOrder);
    }
    public void addCream() {
        myOrder = new Cream(myOrder);
    }
    public void addSugar() {
        myOrder = new Sugar(myOrder);
    }
    public void addLemonJuice() {
        myOrder = new LemonJuice(myOrder);
    }
    public void addCaramel() {
        myOrder = new Caramel(myOrder);
    }
    public void addNuclearWase() {
        myOrder = new NuclearWaste(myOrder);
    }
    public double getTotal() {
        return myOrder.makeCoffee();
    }
    public void clear() {
        myOrder = new BasicCoffee();
    }
}
