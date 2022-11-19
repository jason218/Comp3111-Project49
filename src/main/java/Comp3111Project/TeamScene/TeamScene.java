package Comp3111Project.TeamScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


/**
 * create teamScene
 */
public class TeamScene extends Scene {

    private final TextFieldController controller;
   
    
    /**
	 * load teamScene
	 * @throws IOException When fails to load the FXML.
	 */
    
    public TeamScene() throws IOException {
    	
        super(new Label("Loading..."));
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/text-field.fxml"));
        final AnchorPane startPane = (AnchorPane)loader.load();
        this.setRoot(startPane);
        controller = loader.getController();
    }
    
    /**
	 * return Controller
	 * @return teamSceneController
	 */

    public final TextFieldController getController() {
    	
        return controller;
    }

}
