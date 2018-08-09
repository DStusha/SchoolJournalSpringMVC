package lab.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "subjects")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idsubject")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subject", insertable = true,updatable = true, length = 40)
    private String name;

    @Column(name = "homework", insertable = true,updatable = true, length = 100)
    private String homework;

    @Column(name = "mark",insertable = true,updatable = true, nullable = true)
    private Integer mark;

    @Column(name = "idschoolday")
    private Integer schoolday;

    @Column(name = "numlesson")
    private Integer numlesson;

    public Subject(){}

    public Subject( String subject, String homework, int schoolday, int numlesson){
        this.name = subject;
        this.homework = homework;
        this.schoolday = schoolday;
        this.numlesson = numlesson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String subject) {
        this.name = subject;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {

        this.mark = mark;
    }

    public Integer getSchoolday() {
        return schoolday;
    }

    public void setSchoolday( Integer schoolday) {
        this.schoolday = schoolday;
    }

    public Integer getNumlesson() {
        return numlesson;
    }

    public void setNumlesson(Integer numlesson) {
        this.numlesson = numlesson;
    }
}
