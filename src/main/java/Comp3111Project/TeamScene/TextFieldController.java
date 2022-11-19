package Comp3111Project.TeamScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;
import Comp3111Project.OutputScene.OutputScene;


/**
 * create controller to controller the state of textFieldScene
 */
public class TextFieldController   {
	


    @FXML
    private Text field_title;

    @FXML
    private Button go_button;

    @FXML
    private TextField inputField;

    @FXML
    private Text title;

    private  String inputResult;





    /**
	 * @param event user click button, if valid inputField -> create outputScene , otherwise it will call new Alert()
	 * @throw IO exception for creating outputScene
	 */
    
    @FXML
    void search(ActionEvent event) throws IOException {
    	
    	 this.setInputResult(inputField.getCharacters().toString());
         Stage outputStage = new Stage();
         outputStage.setTitle("ATU System");
         OutputScene outputScene = new OutputScene();
         int result = outputScene.getController().checkForValidInput(inputResult);
         if ( result == -1) {
             Alert alertMessage = new Alert(Alert.AlertType.NONE);
             alertMessage.setAlertType(Alert.AlertType.ERROR);
             alertMessage.setTitle("Invalid Input");
             alertMessage.setContentText("Please provide valid input.");
             alertMessage.show();
         } else if (result == 0) {
             Alert alertMessage = new Alert(Alert.AlertType.NONE);
             alertMessage.setAlertType(Alert.AlertType.ERROR);
             alertMessage.setTitle("Not Found");
             alertMessage.setContentText("There is no existing record.");
             alertMessage.show();
         } else {
             outputStage.setScene(outputScene);
             outputStage.show();
         }

    }
    /**
	 * return inputResult
	 * @return inputFieldResult
	 */
    
    public String getInputResult() {
    	
        return inputResult;
    }
    /**
	 * set inputResult
	 * @param result update the instance inputResult as result of inputField
	 */
    public void setInputResult(String result) {
    	
    	inputResult = result;
    }


}
