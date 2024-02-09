package uncg.marketplace.service.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uncg.marketplace.entity.listing.Listing;
import uncg.marketplace.repository.ListingRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService implements ListingServiceMethods{

    @Autowired
    ListingRepository repository;
    @Override
    public List<Listing> getAllListings() { return repository.findAll(); }
    @Override
    public List<Listing> getAllListingByUserId(Long userId) { return repository.findAllByUserId(userId); }
    @Override
    public void addListing(Listing listing) { repository.save(listing); }
    @Override
    public Optional<Listing> getListingById(Long id) { return repository.findByProductId(id); }
    @Override
    public void saveListing(Listing listing) { repository.save(listing); }
    @Override
    public void updateListing(Listing listing) { repository.save(listing); }

    @Override
    public void deleteListingById(Long id) { repository.deleteById(id); }
}
