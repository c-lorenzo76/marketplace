package uncg.marketplace.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uncg.marketplace.dto.ListingDTO;
import uncg.marketplace.dto.RegisterDTO;
import uncg.marketplace.dto.UserDTO;
import uncg.marketplace.entity.listing.Listing;
import uncg.marketplace.entity.user.User;
import uncg.marketplace.entity.user.UserRole;

@Component
public class MapperConfig {

    @Autowired
    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Converts registerDTO to a User
     * @param registerDTO
     * @return user
     */
    public User convertRegisterDtoToUser(RegisterDTO registerDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user;
        user = modelMapper.map(registerDTO, User.class);
        user.setRole(UserRole.USER);
        return user;
    }

    /**
     * Converts a Listing to a ListingDTO
     * @param listing
     * @return ListingDTO
     */
    public ListingDTO convertListingToListingDto(Listing listing) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ListingDTO listingDTO;
        listingDTO = modelMapper.map(listing, ListingDTO.class);
        return listingDTO;
    }


    /**
     * Converts a ListingDTO to a Listing.
     * @param listingDTO
     * @return Listing
     */
    public Listing convertListingDtoToListing(ListingDTO listingDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Listing listing;
        listing = modelMapper.map(listingDTO, Listing.class);
        return listing;
    }


    /**
     * ADMIN ONLY
     * Converts User to UserDTO,
     * Purpose is to convert user entity to userDto
     * @param user
     * @return userDTO
     */
    public UserDTO convertUserToUserDto(User user){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserDTO userDTO;
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    /**
     * ADMIN ONLY
     * Converts UserDTO to User,
     * Purpose is to display only necessary params from User.
     *
     * @param userDTO Necessary fields for listing from user
     * @return user
     */
    public User convertUserDtoToUser(UserDTO userDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user;
        user = modelMapper.map(userDTO, User.class);
        return user;
    }


}
