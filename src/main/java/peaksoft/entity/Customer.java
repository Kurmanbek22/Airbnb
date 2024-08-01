package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.enums.FamilyStatus;
import peaksoft.entity.enums.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_gen")
    @SequenceGenerator(
            name = "customer_gen",
            sequenceName = "customer_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String nationality;
    @Enumerated(EnumType.STRING)
    @Column(name = "family_status")
    private FamilyStatus familyStatus;
    @OneToMany (mappedBy = "customer")
    private List<RentInfo> rentInfos;
}
