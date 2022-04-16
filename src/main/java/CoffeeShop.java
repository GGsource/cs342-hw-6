import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CoffeeShop extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Who wants coffee!!!");
		primaryStage.getIcons().add(new Image("/images/ace.png"));
		
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/IntroScene.fxml"));
		Scene coffeeShopScene = new Scene(root, 600, 600);
		coffeeShopScene.getStylesheets().add("/styles/IntroStyle.css");
		primaryStage.setScene(coffeeShopScene);
		primaryStage.show();
	}

}
