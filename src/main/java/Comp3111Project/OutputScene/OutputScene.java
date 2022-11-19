package Comp3111Project.OutputScene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

/**
 * create outputScene
 */
public class OutputScene extends Scene {
	

	
    private  OutputController controller;
    /**
	 * load outputScene
	 * @throws IOException When fails to load the FXML.
	 */
    public OutputScene() throws IOException {
    	
        super(new Label("Loading..."));
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/team-output.fxml"));
        final AnchorPane startPane = (AnchorPane)loader.load();
        this.setRoot(startPane);
        controller = loader.getController();
    }
    
    /**
	 * return Controller
	 *  @return outputController
	 */

    public final  OutputController getController() {
    	
        return controller;
    }

}
