package lab.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schooldays")
public class SchoolDay implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idschoolday")
    private Integer id;

    @Column(name = "day")
    private String day;

    @Column(name = "class")
    private int studClass;

    public  SchoolDay(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id= id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStudClass() {
        return studClass;
    }

    public void setStudClass(int studClass) {
        this.studClass = studClass;
    }
}
