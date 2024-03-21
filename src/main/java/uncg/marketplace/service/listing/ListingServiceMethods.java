package uncg.marketplace.service.listing;

import uncg.marketplace.dto.ListingDTO;
import uncg.marketplace.entity.listing.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingServiceMethods {

    List<ListingDTO> getAllListings();
    List<ListingDTO> getAllListingByUserId(Long userId);
    Optional<ListingDTO> getListingById(Long id);
    // void addListing(ListingDTO listing);
    void saveListing(Listing listing);
    void updateListing(Listing listing);
    void deleteListingById(Long id);



}
