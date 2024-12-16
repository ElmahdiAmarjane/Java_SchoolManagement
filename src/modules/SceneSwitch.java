package modules;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class SceneSwitch {

    public SceneSwitch(Pane currentPane, String fxml) throws IOException {
        // Load the new FXML content as a Pane
        Pane nextPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));

        // Clear current children and set the new content
        currentPane.getChildren().clear();
        currentPane.getChildren().setAll(nextPane);
    }
}
