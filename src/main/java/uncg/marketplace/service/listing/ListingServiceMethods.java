package uncg.marketplace.service.listing;

import uncg.marketplace.entity.listing.Listing;

import java.util.List;
import java.util.Optional;

public interface ListingServiceMethods {

    List<Listing> getAllListings();
    List<Listing> getAllListingByUserId(Long userId);
    Optional<Listing> getListingById(Long id);
    void addListing(Listing listing);
    void saveListing(Listing listing);
    void updateListing(Listing listing);
    void deleteListingById(Long id);



}
