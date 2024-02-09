package uncg.marketplace.entity.listing;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uncg.marketplace.entity.user.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private ListingCondition product_condition;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;






}
