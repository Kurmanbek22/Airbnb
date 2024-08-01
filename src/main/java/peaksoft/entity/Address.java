package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="address_gen")
    @SequenceGenerator(
            name ="address_gen",
            sequenceName = "address_seq",
            allocationSize=1)
    private Long id;
    private String city;
    private String region;
    private String street;

    @OneToOne(mappedBy = "address")
    private Agency agency;

}
