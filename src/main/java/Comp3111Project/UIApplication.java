package Comp3111Project;



import java.io.*;

import Comp3111Project.ChartScene.ChartScene;
import Comp3111Project.TeamScene.TeamScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class UIApplication extends Application {
	 static File selectedFile;

	    Scene primaryScene;

	    private TableView<Statistics> stat_table = new TableView<Statistics>();
	    private TableView<Person> person_table = new TableView<Person>();

	    //    private final ObservableList<Statistics> stat_data = FXCollections.observableArrayList(
//	            new Statistics("Total Number of Students", "100"),
//	            new Statistics("K1_Energy(Average, Min, Max)", "(59.8, 10, 80)"),
//	            new Statistics("K2_Energy(Average, Min, Max)", "(62.3, 40, 85)"), new Statistics("K3_Tick1 = 1", "12"),
//	            new Statistics("K3_Tick2 = 1", "3"), new Statistics("My_Preference = 1", "19"));
	    private final ObservableList<Statistics> stat_data = FXCollections.observableArrayList();


	    public final static ObservableList<Person> person_data = FXCollections.observableArrayList();

	    public static final String delimiter = ",";

	    //public final String K1_AVG = null;

	    public static void read(String csvFile) {

	        System.out.print("\n");
	        try {
	            File file = new File(csvFile);
	            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
	            BufferedReader br = new BufferedReader(isr);
	            String line = " ";
	            String[] tempArr;
	            br.readLine(); // skip the first line
	            while ((line = br.readLine()) != null) {
	                tempArr = line.split(delimiter);
	                String temptemp = "";
	                String displayName = "";
	                String displayEmail ="";
	                for(int i=0;i<tempArr.length;i++)
	                {   temptemp = tempArr[1]+tempArr[2];
	                    displayName = temptemp.substring(1, temptemp.length() - 1);
//	                 if(temptemp.startsWith(""")){temptemp.replace(""","");
//	                     System.out.println(temptemp);
//	                 }
	                    displayEmail = tempArr[3].substring(1, temptemp.length() - 1);
	                }
	                person_data.add(new Person(tempArr[0], displayName, displayEmail, tempArr[4], tempArr[5], tempArr[6],
	                        tempArr[7], tempArr[8], tempArr[9]));
	            }
	            br.close();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
	    
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage_stat) throws Exception {
		stage_stat.setTitle("Multiple Scenes");

        Group group1 = new Group();
        Scene scene1 = new Scene(group1, 300, 250);
        primaryScene = scene1;

        // Fill in the scene1






//        stage_stat.setScene(scene_stat);
//        stage_stat.show();
        //Group group2 = new Group();
//        Button btnExit = new Button();
//        btnExit.setLayoutX(400);
//        btnExit.setLayoutY(10);
//        btnExit.setText("Back");
//        btnExit.setOnAction(e -> {stage_stat.setScene(scene1);stage_stat.show();});
        //group2.getChildren().add(btnExit);

        Scene scene_stat = new Scene(new Group());
        stage_stat.setTitle("ATU system");
        stage_stat.setWidth(400);
        stage_stat.setHeight(500);


        final Label label_stat = new Label("Statistics");
        label_stat.setFont(new Font("Arial", 20));

        stat_table.setEditable(true);

        TableColumn<Statistics, String> entry_column = new TableColumn<Statistics, String>("Entry");
        entry_column.setMinWidth(100);
        entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));

        TableColumn<Statistics, String> value_column = new TableColumn<Statistics, String>("Value");
        value_column.setMinWidth(200);
        value_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("value"));

        stat_table.setItems(stat_data);
        stat_table.getColumns().addAll(entry_column, value_column);
        stat_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox_stat = new VBox();
        vbox_stat.setSpacing(5);
        vbox_stat.setPadding(new Insets(10, 10, 10, 10));
        vbox_stat.getChildren().addAll(label_stat, stat_table);

        ((Group) scene_stat.getRoot()).getChildren().addAll(vbox_stat);
        //((Group) scene_stat.getRoot()).getChildren().addAll(btnExit);

//        stage_stat.setScene(scene_stat);
//        stage_stat.show();

        Stage stage_person = new Stage();
        Scene scene_person = new Scene(new Group());
        stage_person.setTitle("Table of statistics data");
        stage_person.setWidth(450);
        stage_person.setHeight(500);

        final Label label_person = new Label("Person");
        label_person.setFont(new Font("Arial", 20));

        person_table.setEditable(true);

        TableColumn<Person, String> studentid_column = new TableColumn<Person, String>("Student_ID");
        studentid_column.setMinWidth(100);
        studentid_column.setCellValueFactory(new PropertyValueFactory<Person, String>("studentid"));

        TableColumn<Person, String> studentname_column = new TableColumn<Person, String>("Student_Name");
        studentname_column.setMinWidth(200);
        studentname_column.setCellValueFactory(new PropertyValueFactory<Person, String>("studentname"));

        TableColumn<Person, String> studentemail_column = new TableColumn<Person, String>("Student_Email");
        studentemail_column.setMinWidth(200);
        studentemail_column.setCellValueFactory(new PropertyValueFactory<Person, String>("studentemail"));

        TableColumn<Person, String> k1energy_column = new TableColumn<Person, String>("K1_Energy");
        k1energy_column.setMinWidth(100);
        k1energy_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k1energy"));

        TableColumn<Person, String> k2energy_column = new TableColumn<Person, String>("k2_Energy");
        k2energy_column.setMinWidth(100);
        k2energy_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k2energy"));

        TableColumn<Person, String> k3trick1_column = new TableColumn<Person, String>("K3_Trick1");
        k3trick1_column.setMinWidth(100);
        k3trick1_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k3trick1"));

        TableColumn<Person, String> k3trick2_column = new TableColumn<Person, String>("K3_Trick2");
        k3trick2_column.setMinWidth(100);
        k3trick2_column.setCellValueFactory(new PropertyValueFactory<Person, String>("k3trick2"));

        TableColumn<Person, String> mypreference_column = new TableColumn<Person, String>("My_Preference");
        mypreference_column.setMinWidth(100);
        mypreference_column.setCellValueFactory(new PropertyValueFactory<Person, String>("mypreference"));

        TableColumn<Person, String> concerns_column = new TableColumn<Person, String>("Concerns");
        concerns_column.setMinWidth(100);
        concerns_column.setCellValueFactory(new PropertyValueFactory<Person, String>("concerns"));

        person_table.setItems(person_data);
        person_table.getColumns().addAll(studentid_column, studentname_column, studentemail_column,k1energy_column, k2energy_column,
                k3trick1_column, k3trick2_column, mypreference_column, concerns_column);
        person_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox_person = new VBox();
        vbox_person.setSpacing(5);
        vbox_person.setPadding(new Insets(10, 10, 10, 10));
        vbox_person.getChildren().addAll(label_person, person_table);

        ((Group) scene_person.getRoot()).getChildren().addAll(vbox_person);

//        stage_person.setScene(scene_person);
//        stage_person.show();





        Button btn2 = new Button();
        btn2.setLayoutX(135);
        btn2.setLayoutY(200);
        btn2.setText("view student info");
        Stage person_stage = new Stage();
        person_stage.setScene(scene_person);
        btn2.setOnAction(e ->
                //stage_stat.setScene(scene_person)
                person_stage.show()
        );
        //group1.getChildren().add(btn2);

        Button btn3 = new Button();
        btn3.setLayoutX(135);
        btn3.setLayoutY(240);
        btn3.setText("view general statistics");
        Stage stats_Stage = new Stage();
        btn3.setOnAction(e -> {
        	String numOfStudents = String.valueOf(person_data.size());
            //String K1_Energy_stats = "("+
            //int test = Integer.valueOf(String.valueOf(person_data.get(0).k1energy));
            double K1_AVG = 0;
            double K1_MIN = Double.parseDouble(person_data.get(0).k1energy.getValue());
            double K1_MAX = Double.parseDouble(person_data.get(0).k1energy.getValue());
            for(int i=0; i< person_data.size();i++)
            {
                K1_AVG += Double.parseDouble(person_data.get(i).k1energy.getValue());
                if(K1_MIN>Double.parseDouble(person_data.get(i).k1energy.getValue()))
                {
                    K1_MIN = Double.parseDouble(person_data.get(i).k1energy.getValue());
                }
                if(K1_MAX<Double.parseDouble(person_data.get(i).k1energy.getValue())){
                    K1_MAX = Double.parseDouble(person_data.get(i).k1energy.getValue());
                };
            }

            double K2_AVG = 0;
            double K2_MIN = Double.parseDouble(person_data.get(0).k2energy.getValue());
            double K2_MAX = Double.parseDouble(person_data.get(0).k2energy.getValue());
            for(int i=0; i< person_data.size();i++)
            {
                K2_AVG += Double.parseDouble(person_data.get(i).k2energy.getValue());
                if(K2_MIN>Double.parseDouble(person_data.get(i).k2energy.getValue()))
                {
                    K2_MIN = Double.parseDouble(person_data.get(i).k2energy.getValue());
                }
                if(K2_MAX<Double.parseDouble(person_data.get(i).k2energy.getValue())){
                    K2_MAX = Double.parseDouble(person_data.get(i).k2energy.getValue());
                };
            }

            K2_AVG = K2_AVG/person_data.size();


            Integer K3_TICK_1 = 0;
            Integer K3_TICK_2 = 0;
            for(int i=0; i< person_data.size();i++)
            {
                K3_TICK_1 += Integer.parseInt(person_data.get(i).k3trick1.getValue());
                K3_TICK_2 += Integer.parseInt(person_data.get(i).k3trick2.getValue());
            }

            Integer MY_PREFERENCE = 0;

            for(int i=0; i< person_data.size();i++)
            {

                MY_PREFERENCE += Integer.parseInt(person_data.get(i).mypreference.getValue());
            }

            stat_data.add(new Statistics("Total Number of Students", numOfStudents));
            stat_data.add(new Statistics("K1_Energy(Average, Min, Max)", "(" + String.valueOf(K1_MIN) + ", " + String.valueOf(K1_AVG) + ", " +String.valueOf(K1_MAX) + ")"));//"(59.8, 10, 80)"
            stat_data.add(new Statistics("K2_Energy(Average, Min, Max)", "(" + String.valueOf(K2_MIN) + ", " + String.valueOf(K2_AVG) + ", " +String.valueOf(K2_MAX) + ")"));
            stat_data.add(new Statistics("K3_Tick1 = 1", K3_TICK_1.toString()));
            stat_data.add(new Statistics("K3_Tick2 = 1", K3_TICK_2.toString()));
            stat_data.add(new Statistics("My_Preference = 1", MY_PREFERENCE.toString()));
//            new Statistics("K2_Energy(Average, Min, Max)", "(62.3, 40, 85)"), new Statistics("K3_Tick1 = 1", "12"),
//            new Statistics("K3_Tick2 = 1", "3"), new Statistics("My_Preference = 1", "19"));
            stats_Stage.setScene(scene_stat);
            stats_Stage.show();
            //stage_stat.setScene(scene_stat);
        });

        Button btn4 = new Button();
        btn4.setLayoutX(135);
        btn4.setLayoutY(280);
        btn4.setText("Search your own team");
        btn4.setOnAction(e ->
                //stage_stat.setScene(scene_person)
                {
                    try {
                        Stage stage4= new Stage();
                        stage4.setTitle("ATU System");
                        stage4.setScene(new TeamScene());
                        stage4.show();
                    }catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );

        Button btn5 = new Button();
        btn5.setLayoutX(135);
        btn5.setLayoutY(320);
        btn5.setText("Search Line Chart");
        btn5.setOnAction(e ->
                        //stage_stat.setScene(scene_person)
                {
                    try {
                        Stage stage5= new Stage();
                        stage5.setTitle("ATU System");
                        ChartScene chartScene = new ChartScene();
                        stage5.setScene(chartScene);
                        stage5.show();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );

        Label mainLabel = new Label("Please Choose your File (.csv)");
        mainLabel.setLayoutX(50);
        mainLabel.setLayoutY(110);
        mainLabel.setFont(new Font("Arial", 18));
        mainLabel.setTextFill(Color.RED);



        Button btn1 = new Button();
        btn1.setLayoutX(100);
        btn1.setLayoutY(138);
        btn1.setText("Choose a file");
        btn1.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            selectedFile = fileChooser.showOpenDialog(null);

//            Label file_name = new Label(selectedFile.getName());
//            file_name.setLayoutX(60);
//            file_name.setLayoutY(105);
//            file_name.setFont(new Font("Arial", 10));
//            group1.getChildren().add(file_name);
            btn1.setText(selectedFile.getName());



//            try {
//                HelloApplication.read(selectedFile.toString());
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
            UIApplication.read(selectedFile.toString());
            //System.out.println(selectedFile.toString());

            //stage_stat.setScene(scene_stat);
        });
        Label selectedFileLabel = new Label("File:");
        selectedFileLabel.setLayoutX(50);
        selectedFileLabel.setLayoutY(140);
        selectedFileLabel.setFont(new Font("Arial", 15));



        Label Welcome = new Label("Welcome to ATU!");
        Welcome.setLayoutX(40);
        Welcome.setLayoutY(40);
        Welcome.setFont(new Font("Arial", 40));
        Welcome.setTextFill(Color.ORANGE);

        Label Input = new Label("Statistics:");
        Input.setLayoutX(50);
        Input.setLayoutY(200);
        Input.setFont(new Font("Arial", 15));
        Welcome.setTextFill(Color.ORANGE);


        Label search = new Label("Search:");
        search.setLayoutX(50);
        search.setLayoutY(280);
        search.setFont(new Font("Arial", 15));


        group1.getChildren().add(Welcome);
        group1.getChildren().add(mainLabel);
        group1.getChildren().add(selectedFileLabel);
        group1.getChildren().add(btn1);
        group1.getChildren().add(btn2);
        group1.getChildren().add(btn3);
        group1.getChildren().add(Input);
        group1.getChildren().add(btn4);
        group1.getChildren().add(btn5);
        group1.getChildren().add(search);


        stage_stat.setScene(scene1);
        stage_stat.show();

	}

	public static void run(String arg[]) {
		Application.launch(arg);
	}
}
