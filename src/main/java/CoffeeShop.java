import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeShop extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Who wants coffee!!!");
		
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/IntroScene.fxml"));
		Scene coffeeShopScene = new Scene(root, 600, 600);
		primaryStage.setScene(coffeeShopScene);
		primaryStage.show();
		
		Coffee order = new Sugar(new Cream( new ExtraShot(new BasicCoffee())));
		
		double cost = order.makeCoffee();
		System.out.println("Total: "+cost);
	}

}
