public class Caramel extends CoffeeDecorator{
	final static double cost = .99;
	
	Caramel(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addCaramel();
	}
	
	private double addCaramel() {
		//System.out.println(" + caramel: $"+cost);
		
		return cost;
	}
}
