import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class CoffeeController implements Initializable {

    @FXML
    private ListView<String> totalListView;
    @FXML
    private VBox introBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    //On New Order being pressed:
    public void newOrder(ActionEvent e) throws IOException {
        //Load orderScene and set it as the new root
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/OrderScene.fxml"));
        Parent orderBox = loader.load();
        introBox.getScene().setRoot(orderBox);

    }

    //When an addon is pressed add it to the listview:
    public void pressed(ActionEvent e) {
        Button sourceButton = (Button)e.getSource();
        totalListView.getItems().add("Button pressed: " + sourceButton.getText());
        //In order to make the list autoscroll and show the newest entry:
        totalListView.scrollTo(totalListView.getItems().size());
    }
    //Delete current order:
    public void deleteOrder(ActionEvent e) {
        //Clears the list
        totalListView.getItems().clear();
    }
}
