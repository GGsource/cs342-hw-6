
public class LemonJuice extends CoffeeDecorator{

    private double cost = .75;
        
        LemonJuice(Coffee specialCoffee){
            super(specialCoffee);
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee()+ addLemonJuice();
        }
        
        private double addLemonJuice() {
            
            //System.out.println(" + Lemon Juice: $"+cost);
            
            return cost;
        }
    }
    