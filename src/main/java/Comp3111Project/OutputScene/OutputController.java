package Comp3111Project.OutputScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * create controller to controller the state of outputScene
 */
public class OutputController implements Initializable  {
	
	

    @FXML
    private Text K1;

    @FXML
    private Text K2;

    @FXML
    private Text name1;

    @FXML
    private Text name2;

    @FXML
    private Text name3;
    
    @FXML
    private Text name4;

    @FXML
    private Text search_id;
    
    @FXML
    private Text search_name;

    @FXML
    private Text teamNo;


    private String search;

    //private Object[] teamList = new Object[4];

    private int teamId;

    //private String[] nameList = new String[4];
    
    /**
  	 * initialize outputScene
  	 * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
  	 */
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.teamNo.setText("-----");
        this.name4.setText("-----");
        this.name2.setText("-----");
        this.name1.setText("-----");
        this.name3.setText("-----");
        this.K1.setText("-----");
        this.K2.setText("-----");
        this.search_name.setText("-----");
        this.search_id.setText("-----");
    }

    /**
	 * set textFieldInputResult
	 * @param result inputFieldResult
	 */
    
    public void setSearch(String result) {
    	
        search = result;
        //setScene();
    }
    
    /**
	 * update Scene
	 */

    public void setScene(){
    	
        this.teamNo.setText("1");
        this.name4.setText(search);
        this.name2.setText("CHRYSANTHEMUM, Achillobator");
        this.name1.setText("CHRYSANTHEMUM, Achillobator");
        this.name3.setText("CHRYSANTHEMUM, Achillobator");
        this.K1.setText("50");
        this.K2.setText("50");
    }
    
    /**
	 * check for valid input
	 * @param search check the inputField whether it is valid input or valid format
	 * @return -1 for invalid input or invalid format 0 for nameInput 1 for studentIDInput
	 */

    public  int checkForValidInput(String search){
        if (search.matches("[0-9]+")){
            if (search.length() !=8) {
                return -1;
            }
            return 1;
            // return checkForExistingStudentID(search);
        }
        if (checkForFormat(search)==1){
            return 1;
            // return checkForExistingStudentName(search);
        }
        return -1;
    }

//    public int checkForExistingStudentID(String search){
//        for (Team team: teamList) {
//            for (Student student : team.getStudentList()) {
//                if (student.getID() == search) {
//                    this.teamNo.setText(team.getID());
//                    this.name3_id.setText(search);
//                    for (int i=0; i<team.getStudentList().length(); i++) {
//                        nameList[i] = nameList.getStudentList()[i].getName();
//                    }
//                    this.name2.setText(nameList[0]);
//                    this.name1.setText(nameList[1]);
//                    this.name3.setText(nameList[2]);
//                    this.K1.setText(team.getK1());
//                    this.K2.setText(team.getK2());
//                    return 1;
//                }
//            }
//        }
//        return 0;
//    }
//
//    public int checkForExistingStudentName(String search){
//        for (Team team: teamList) {
//            for (Student student : team.getStudentList()) {
//                if (student.getName() == search) {
//                    this.teamNo.setText(team.getID());
//                    this.name3_id.setText(search);
//                    for (int i=0; i<team.getStudentList().length(); i++) {
//                        nameList[i] = nameList.getStudentList()[i].getName();
//                    }
//                    this.name2.setText(nameList[0]);
//                    this.name1.setText(nameList[1]);
//                    this.name3.setText(nameList[2]);
//                    this.K1.setText(team.getK1());
//                    this.K2.setText(team.getK2());
//                    return 1;
//                }
//            }
//        }
//        return 0;
//    }
    
    /**
	 * check for valid input
	 * @param search check the inputField whether it is valid format
	 * @return -1 for invalid format 1 for valid format
	 */
    
	public  int checkForFormat(String search){
        List<String> stringList = new ArrayList<>();
        char[] charSearch = search.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<charSearch.length;i++) {
        	if (charSearch[i]==' '||charSearch[i]==',') {
        		stringList.add(sb.toString());
        		sb.setLength(0);
        		if (charSearch[i]==' ') {
        			continue;
        		}
        		sb.append(charSearch[i]);
        		continue;
        	}
        	if (i==charSearch.length-1) {
        		sb.append(charSearch[i]);
        		stringList.add(sb.toString());
        	}
        	sb.append(charSearch[i]);
        }
        if (stringList.size()!=3) {
        	return -1;
        }
        else {
        	if (!stringList.get(0).matches("[a-zA-Z]+")) {
        		return -1;
        	}
        	if (!stringList.get(2).matches("[a-zA-Z]+")) {
        		return -1;
        	}
        	return 1;
        }
    }
	


}
