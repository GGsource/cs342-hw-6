
public class Cream extends CoffeeDecorator{

	final static double cost = .50;
	Cream(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addCream();
	}
	
	private double addCream() {
		
		//System.out.println(" + cream: $"+cost);
		
		return cost;
	}
}
