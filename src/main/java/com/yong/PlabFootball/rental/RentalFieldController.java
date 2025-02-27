package com.yong.PlabFootball.rental;

import com.yong.PlabFootball.rental.dto.RentalFieldDto;
import com.yong.PlabFootball.rental.dto.request.CreateRentalFieldRequest;
import com.yong.PlabFootball.rental.service.CreateRentalFieldService;
import com.yong.PlabFootball.rental.service.SearchRentalFieldService;
import com.yong.PlabFootball.stadium.dto.StadiumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rental/fields")
public class RentalFieldController {

    private final CreateRentalFieldService createRentalFieldService;
    private final SearchRentalFieldService searchRentalFieldService;

    @PostMapping
    public RentalFieldDto createRentalField(CreateRentalFieldRequest request) {
        return createRentalFieldService.CreateRentalField(request);
    }

    @GetMapping
    public List<StadiumDto> searchAllRentalFieldsInStadium() {
        return searchRentalFieldService.searchAllRentalFieldsInStadium();
    }
}
