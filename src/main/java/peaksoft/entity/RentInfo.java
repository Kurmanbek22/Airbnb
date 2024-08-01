package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rent_infois")
@NoArgsConstructor
@Getter
@Setter
public class RentInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rent_info_gen")
    @SequenceGenerator(
            name = "rent_Info_gen",
            sequenceName = "rent_info_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "check_in_date")
    private Date checkInDate;
    @Column(name = "check_out_date")
    private Date checkOutDate;
    @ManyToOne (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Agency agency;

}
