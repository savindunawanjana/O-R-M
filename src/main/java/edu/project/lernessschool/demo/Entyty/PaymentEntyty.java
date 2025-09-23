package edu.project.lernessschool.demo.Entyty;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntyty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int payment_id;

    @ManyToOne()
    private CourseEntyty course;

    @ManyToOne()
    private StudentEntyty student;

    private Double payement;

    private String stete;

    private String date;


}
