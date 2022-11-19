package Comp3111Project.ChartScene;

import Comp3111Project.Person;
import Comp3111Project.UIApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * create controller to controller the state of chartScene
 */
public class ChartController implements Initializable {
	
	


    @FXML
    private LineChart<Number, Number> lineChart;


    /**
	 * create two XYChart.Series and add them into LineChart
	 * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
	 */
  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
        XYChart.Series<Number,Number> dataSeries1 = new XYChart.Series<Number,Number>();
        Color color = Color.RED; // or any other color

        String rgb = String.format("%d, %d, %d",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));


        XYChart.Series<Number,Number> dataSeries2 = new XYChart.Series<Number,Number>();
        dataSeries1.setName("K1");
        dataSeries2.setName("K2");
        ObservableList<Person> student_data = UIApplication.person_data;
        System.out.println(student_data);
        int count = 0;
        for (Person person : student_data) {
            dataSeries1.getData().add(new XYChart.Data<Number,Number>( count, Double.parseDouble(person.getK1energy())));
            count++;
        }
        count = 0;
        for (Person person : student_data) {
            dataSeries2.getData().add(new XYChart.Data<Number,Number>( count, Double.parseDouble(person.getK2energy())));
        }
        lineChart.getData().add(dataSeries1);
        lineChart.getData().add(dataSeries2);
    }
}
