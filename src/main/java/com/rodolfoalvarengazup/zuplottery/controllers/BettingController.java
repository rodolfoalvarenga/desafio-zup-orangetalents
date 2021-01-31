package com.rodolfoalvarengazup.zuplottery.controllers;

import com.rodolfoalvarengazup.zuplottery.dto.BettingDTO;
import com.rodolfoalvarengazup.zuplottery.dto.RequestParametersDto;
import com.rodolfoalvarengazup.zuplottery.services.BettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BettingController {

    @Autowired
    private BettingService bettingService;

    @PostMapping(value = "/betting", produces = "application/json")
    public ResponseEntity<BettingDTO> makeBet(@RequestBody RequestParametersDto parameters) {
        BettingDTO betting = bettingService.getBetting(parameters.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(betting);
    }

    @GetMapping(value = "/listBets", produces = "application/json")
    public ResponseEntity<List<BettingDTO>> listBets(@RequestBody RequestParametersDto parameters) {
        List<BettingDTO> bettings = bettingService.getAllBetsByEmail(parameters.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(bettings);
    }
}
