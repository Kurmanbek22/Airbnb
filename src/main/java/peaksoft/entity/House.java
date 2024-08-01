package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.entity.enums.HouseType;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "housse")
@NoArgsConstructor
@Getter
@Setter

public class House {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "housse_gen")
    @SequenceGenerator(
            name = "house_gen",
            sequenceName = "house_seq",
            allocationSize = 1
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "house_type")
    private HouseType houseType;
    private BigDecimal price;
    private double rating;
    private String description;
    private int room;
    private boolean furniture;
    @OneToOne
    private Address address;
    @ManyToOne ( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    private Owner owner;
//@OneToMany (mappedBy = "house")
//    private List<RentInfo>rentInfos;
}
