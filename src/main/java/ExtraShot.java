
public class ExtraShot extends CoffeeDecorator {

	final static double cost = 1.20;
	
	ExtraShot(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee() + addShot();
	}
	
	private double addShot() {
		//System.out.println(" + extra shot: $"+cost);
		
		return cost;
	}
}
