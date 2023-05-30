package com.weed.PM.service;

import com.weed.PM.entity.Dust;
import com.weed.PM.repository.DustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DustService {
    private final DustRepository dustRepository;

    // 먼지 class 저장
    public Long save(Dust dust) {
        dustRepository.save(dust);
        return dust.getId();
    }

    // 먼지 class 검색
    public Dust findDust(Long id) {
        Optional<Dust> byId = dustRepository.findById(id);
        Dust dust = byId.get();
        return dust;
    }
    // 모든 먼지 class 검색
    public List<Dust> findAllDust() {
        List<Dust> all = dustRepository.findAll();
        return all;
    }

}
