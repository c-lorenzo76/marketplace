package uncg.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uncg.marketplace.entity.listing.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    Optional<Listing> findByProductId(Long productId);

    List<Listing> findAllByUserId(Long user_id);
}
