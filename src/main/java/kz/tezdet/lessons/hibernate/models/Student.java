package kz.tezdet.lessons.hibernate.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId ;
    @Column(name = "firstname")
    private String firstName ;
    @Column(name = "lastname")
    private String lastName ;
    @Column(name = "email")
    private String email ;
    @Column(name = "phone")
    private String phone ;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_test",joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name="test_id"))
    private Set<Test> tests = new HashSet<Test>() ;

    public Student(){

    }

    public Student(String firstName, String lastName,
                   String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}
