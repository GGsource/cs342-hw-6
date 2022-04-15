import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class CoffeeController implements Initializable {
    OrderMaker myOrder;

    @FXML
    private ListView<String> orderListView;
    @FXML
    private VBox introRoot;
    @FXML
    private VBox orderRoot;
    @FXML
    private VBox totalRoot;
    @FXML
    private Label finalOrderLabel;
    @FXML
    private Label totalLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myOrder = new OrderMaker();
    }

    //On New Order being pressed:
    public void startOrder(ActionEvent e) throws IOException {
        //Load orderScene and set it as the new root
        FXMLLoader orderLoader = new FXMLLoader(getClass().getResource("/FXML/OrderScene.fxml"));
        Parent orderBox = orderLoader.load();
        introRoot.getScene().setRoot(orderBox);
        //get successor Controller to affect next scene before we enter it
        CoffeeController orderController = orderLoader.getController();
        //Clear in case this isn't our first time ordering
        orderController.deleteOrder(e);
    }

    //OnAction Methods for all our Coffee Addons
    public void whip(ActionEvent e) {
        myOrder.addCream();
        orderListView.getItems().add(" + cream: $0.50");
        autoScroll();
    }
    public void boost(ActionEvent e) {
        myOrder.addExtraShot();
        orderListView.getItems().add(" + extra shot: $1.20");
        autoScroll();
    }
    public void sweeten(ActionEvent e) {
        myOrder.addSugar();
        orderListView.getItems().add(" + sugar: $0.50");
        autoScroll();
    }
    public void embitter(ActionEvent e) {
        myOrder.addLemonJuice();
        orderListView.getItems().add(" + lemon juice: $0.75");
        autoScroll();
    }
    public void caramelize(ActionEvent e) {
        myOrder.addCaramel();
        orderListView.getItems().add(" + caramel: $0.99");
        autoScroll();
    }
    public void nuke(ActionEvent e) {
        myOrder.addNuclearWase();
        orderListView.getItems().add(" + nuclear waste: $49999.99");
        autoScroll();
    }
    //Delete current order to restart selection
    public void deleteOrder(ActionEvent e) {
        //Clears the list
        orderListView.getItems().clear();
        //Start coffee fresh
        myOrder.clear();
        orderListView.getItems().add("Black Coffee: $3.99");
    }
    //Confirm the current choice and move onto total Screen
    public void confirmOrder(ActionEvent e) throws IOException {
        //Order is confirmed, take us to total screen
        FXMLLoader totalLoader = new FXMLLoader(getClass().getResource("/FXML/TotalScene.fxml"));
        Parent totalBox = totalLoader.load();
        orderRoot.getScene().setRoot(totalBox);
        CoffeeController totalController = totalLoader.getController();

        //Set changes on the new scene
        
        //Display final order
        String finalOrderString = "You chose:\n";
        for (String s : orderListView.getItems()) {
            finalOrderString += s + "\n";
        }
        totalController.finalOrderLabel.setText(finalOrderString);
        //Display Total cost
        totalController.totalLabel.setText("Your final total is: $" + myOrder.getTotal());
    }

    //Total Scene OnAction Methods
    public void newOrder(ActionEvent e) throws IOException {
        //Send us back to the Order Scene and clear it
        FXMLLoader newOrderLoader = new FXMLLoader(getClass().getResource("/FXML/OrderScene.fxml"));
        Parent orderBox = newOrderLoader.load();
        totalRoot.getScene().setRoot(orderBox);
        CoffeeController newOrdeController = newOrderLoader.getController();
        newOrdeController.deleteOrder(e);
    }
    public void quit(ActionEvent e) {
        //Close the window and end the process
        Platform.exit();
        System.exit(0);
    }

    //Helper function
    private void autoScroll() {
        //Set the scroll to the newest item so we can always see most recent
        orderListView.scrollTo(orderListView.getItems().size());
    }
}
