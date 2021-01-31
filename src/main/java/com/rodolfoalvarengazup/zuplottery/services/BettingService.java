package com.rodolfoalvarengazup.zuplottery.services;

import com.google.gson.Gson;
import com.rodolfoalvarengazup.zuplottery.dto.BettingDTO;
import com.rodolfoalvarengazup.zuplottery.entities.Betting;
import com.rodolfoalvarengazup.zuplottery.mapper.BettingMapper;
import com.rodolfoalvarengazup.zuplottery.repositories.BettingRepository;
import com.rodolfoalvarengazup.zuplottery.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BettingService {

    @Autowired
    private BettingRepository bettingRepository;

    Gson gson = new Gson();
    BettingMapper bettingMapper = new BettingMapper();
    NumberUtils numberUtils = new NumberUtils();

    @Transactional
    public BettingDTO getBetting(String email) {

        List<Integer> numbers = numberUtils.generateNumbers();

        Betting newBetting = new Betting();
        newBetting.setEmail(email);
        newBetting.setNumbers(gson.toJson(numbers));

        bettingRepository.save(newBetting);

        return bettingMapper.convertBettingToBettingDto(newBetting);
    }

    @Transactional(readOnly = true)
    public List<BettingDTO> getAllBetsByEmail(String email){
        List<Betting> bettings = bettingRepository.findAll().stream().filter(bet -> bet.getEmail().equals(email))
                .collect(Collectors.toList());
        return bettingMapper.convertListBettingsToListBettingDtos(bettings);
    }
}
