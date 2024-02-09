package uncg.marketplace.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uncg.marketplace.entity.listing.Listing;
import uncg.marketplace.service.listing.ListingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listing")
public class ListingController {

    @Autowired
    private ListingService service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<Listing> getAllListings(){
        return service.getAllListings();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<Listing> addNewListing(@RequestBody Listing listing){
        service.addListing(listing);
        return new ResponseEntity<>(listing, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Listing> getListingById(@PathVariable Long id){
        Optional<Listing> optional = service.getListingById(id);
        Listing listing;
        if(optional.isPresent()){
            listing = optional.get();
            return new ResponseEntity<>(listing, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public List<Listing> getAllByListingId(@PathVariable Long id){
        return service.getAllListingByUserId(id);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Listing> deleteListingById(@PathVariable Long id){
        service.deleteListingById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
