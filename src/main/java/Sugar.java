
public class Sugar extends CoffeeDecorator{

final static double cost = .50;
	
	Sugar(Coffee specialCoffee){
		super(specialCoffee);
	}
	
	public double makeCoffee() {
		return specialCoffee.makeCoffee()+ addSugar();
	}
	
	private double addSugar() {
		
		//System.out.println(" + sugar: $"+cost);
		
		return cost;
	}
}
