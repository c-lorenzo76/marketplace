package uncg.marketplace.service.listing;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uncg.marketplace.dto.ListingDTO;
import uncg.marketplace.entity.listing.Listing;
import uncg.marketplace.repository.ListingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListingService implements ListingServiceMethods{

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ListingDTO> getAllListings() {

        return listingRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // TODO: Comes out ugly in JSON might have to figure how to fix it 
    @Override
    public List<ListingDTO> getAllListingByUserId(Long userId) {
        return listingRepository.findAllByUserId(userId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // @Override
    public Listing addListing(ListingDTO listingDTO) {
        Listing listing = convertDtoToEntity(listingDTO);
        listingRepository.save(listing);
        return listing;
    }

    @Override
    public Optional<ListingDTO> getListingById(Long id) {
        return listingRepository.findByProductId(id)
                .map(this::convertEntityToDto);

    }
    @Override
    public void saveListing(Listing listing) { listingRepository.save(listing); }
    @Override
    public void updateListing(Listing listing) { listingRepository.save(listing); }

    @Override
    public void deleteListingById(Long id) { listingRepository.deleteById(id); }

    @Override
    public ListingDTO convertEntityToDto(Listing listing) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ListingDTO listingDTO;
        listingDTO = modelMapper.map(listing, ListingDTO.class);
        return listingDTO;
    }

    @Override
    public Listing convertDtoToEntity(ListingDTO listingDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Listing listing;
        listing = modelMapper.map(listingDTO, Listing.class);
        return listing;
    }


}
