package Comp3111Project;

import javafx.beans.property.SimpleStringProperty;

public class Person {

	public final SimpleStringProperty studentid;
    public final SimpleStringProperty studentname;

    public final SimpleStringProperty studentemail;
    public final SimpleStringProperty k1energy;
    public final SimpleStringProperty k2energy;
    public final SimpleStringProperty k3trick1;
    public final SimpleStringProperty k3trick2;
    public final SimpleStringProperty mypreference;
    public final SimpleStringProperty concerns;

    public Person(String student_id, String student_name, String student_email, String k1_energy, String k2_energy, String k3_trick1,
                  String k3_trick2, String my_preference, String concerns) {
        this.studentid = new SimpleStringProperty(student_id);
        this.studentname = new SimpleStringProperty(student_name);
        this.studentemail = new SimpleStringProperty(student_email);
        this.k1energy = new SimpleStringProperty(k1_energy);
        this.k2energy = new SimpleStringProperty(k2_energy);
        this.k3trick1 = new SimpleStringProperty(k3_trick1);
        this.k3trick2 = new SimpleStringProperty(k3_trick2);
        this.mypreference = new SimpleStringProperty(my_preference);
        this.concerns = new SimpleStringProperty(concerns);
    }




    public String getStudentid() {
        return studentid.get();
    }

    public void setStudentid(String val) {
        studentid.set(val);
    }

    public String getStudentname() {
        return studentname.get();
    }

    public void setStudentname(String val) {
        studentname.set(val);
    }

    public String getStudentemail() {
        return studentemail.get();
    }

    public void setStudentemail(String val) {
        studentemail.set(val);
    }


    public String getK1energy() {
        return k1energy.get();
    }

    public void setK1energy(String val) {
        k1energy.set(val);
    }

    public String getK2energy() {
        return k2energy.get();
    }

    public void setK2energy(String val) {
        k2energy.set(val);
    }

    public String getK3trick1() {
        return k3trick1.get();
    }

    public void setK3trick1(String val) {
        k3trick1.set(val);
    }

    public String getK3trick2() {
        return k3trick2.get();
    }

    public void setK3trick2(String val) {
        k3trick2.set(val);
    }

    public String getMypreference() {
        return mypreference.get();
    }

    public void setMypreference(String val) {
        mypreference.set(val);
    }

    public String getConcerns() {
        return concerns.get();
    }

    public void setConcerns(String val) {
        concerns.set(val);
    }

}
