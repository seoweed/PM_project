package com.weed.PM.service;

import com.weed.PM.entity.Dust;
import com.weed.PM.repository.DustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    // 최상위 Dust 객체 하나 가져오기
    public Dust upperDust() {
        Dust dust = dustRepository.findLastRow();
        return dust;
    }

    // 모든 먼지 class 검색
    public List<Dust> findAllDust() {
        List<Dust> all = dustRepository.findAll();
        return all;
    }
    // 상태 나타내기
    public List<String> status() {
        List<String> status = new ArrayList<>();
        List<Dust> allDust = findAllDust();
        for (Dust dust : allDust) {
            if (dust.getLevel() < 50) {
                status.add("좋음");
            } else if (dust.getLevel() < 100) {
                status.add("보통");
            }else {
                status.add("나쁨");
            }
        }
        return status;
    }

    // rest 설정
    public List<Dust> getAllDust() {
        return dustRepository.findAll();
    }

    public Dust createDust(Dust dust) {
        dust.setTime(LocalDateTime.now());
        return dustRepository.save(dust);
    }
}
