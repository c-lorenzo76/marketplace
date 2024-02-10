package uncg.marketplace.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import uncg.marketplace.entity.listing.ListingCondition;

@Data
public class ListingDTO {
    private Long productId;
    private String name;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private ListingCondition product_condition;

    private UserDTO userDTO;

}
