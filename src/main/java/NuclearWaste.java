public class NuclearWaste extends CoffeeDecorator {
    final static double cost = 49999.99;

    NuclearWaste(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addNuclearWaste();
    }

    private double addNuclearWaste() {
        //System.out.println(" + nuclear waste: $" + cost);

        return cost;
    }
}
