package com.rodolfoalvarengazup.zuplottery.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rodolfoalvarengazup.zuplottery.dto.BettingDTO;
import com.rodolfoalvarengazup.zuplottery.entities.Betting;

import java.util.ArrayList;
import java.util.List;

public class BettingMapper {
    Gson gson = new Gson();

    public List<BettingDTO> convertListBettingsToListBettingDtos(List<Betting> bettings){
        List<BettingDTO> bettingDTOS = new ArrayList<>();

        bettings.forEach(bet -> {
            bettingDTOS.add(convertBettingToBettingDto(bet));
        });

        return bettingDTOS;
    }

    public BettingDTO convertBettingToBettingDto(Betting betting){
        BettingDTO bettingDTO = new BettingDTO();

        bettingDTO.setId(betting.getId());
        bettingDTO.setEmail(betting.getEmail());
        bettingDTO.setNumbers(gson.fromJson(betting.getNumbers(), new TypeToken<ArrayList<Integer>>() {}.getType()));
        bettingDTO.setCreatedAt(betting.getCreatedAt());

        return bettingDTO;
    }
}
