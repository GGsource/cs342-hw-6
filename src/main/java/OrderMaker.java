public class OrderMaker {
    Coffee myOrder = new BasicCoffee();

    public void addExtraShot() {
        myOrder = new ExtraShot(myOrder);
    }
    public void addCream() {
        myOrder = new Cream(myOrder);
    }
}
