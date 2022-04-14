import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class CoffeeController implements Initializable {

    @FXML
    ListView<String> totalListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    public void pressed(ActionEvent e) {
        Button sourceButton = (Button)e.getSource();
        totalListView.getItems().add("Button pressed: " + sourceButton.getText());
    }
    public void newOrder(ActionEvent e) {
        //Clears the list
        totalListView.getItems().clear();
    }
}
