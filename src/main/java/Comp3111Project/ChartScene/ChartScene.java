package Comp3111Project.ChartScene;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * create chartScene
 */
public class ChartScene extends Scene {
	
	
    private final ChartController controller;
    
    
    /**
	 * load chartScene
	 * @throws IOException When fails to load the FXML.
	 */

    public ChartScene() throws IOException {
 
        super(new Label("Loading..."));
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/chart-output.fxml"));
        final StackPane startPane = (StackPane)loader.load();
        this.setRoot(startPane);
        controller = loader.getController();
    }
    
    /**
	 * return controller
	 * @return chartScene controller
	 */
    
    public final ChartController getController() {
        return controller;
    }
}
