package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "agencies")
@NoArgsConstructor
@Getter
@Setter
public class Agency {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "agency_gen")
    @SequenceGenerator(
            name = "address_gen",
            sequenceName = "address_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @Column(name= "phone_number")
    private String phoneNumber;
    @OneToOne
    private Address address;
    @ManyToMany
    private List<Owner> owners;
    @OneToMany (mappedBy = "agancy",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.REMOVE
    })
    private List<RentInfo> rentInfo;
}
