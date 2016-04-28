package kz.tezdet.lessons.hibernate.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long testId ;
    @Column(name = "subject")
    private String subject ;
    @Column(name = "max_marks")
    private String maxMarks ;
    @Column(name="marks_obtained")
    private String marksObtained ;
    @Column(name = "result")
    private String result ;

    @ManyToMany(mappedBy = "tests")
    private Set<Student> students = new HashSet<Student>() ;

    public Test(){

    }

    public Test(String subject, String maxMarks,
                String marksObtained, String result) {
        this.subject = subject;
        this.maxMarks = maxMarks;
        this.marksObtained = marksObtained;
        this.result = result;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
