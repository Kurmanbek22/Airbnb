package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.enums.Gender;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_gen")
    @SequenceGenerator(
            name = "owner_gen",
            sequenceName = "owner_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "birth_date")
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany
    private List<Agency> agencies;
    @OneToMany(mappedBy = "owner",
    cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    private List<House> houses;
}
