package com.weed.PM.service;

import com.weed.PM.entity.Dust;
import com.weed.PM.repository.DustRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DustServiceTest {
    @Autowired DustRepository dustRepository;
    @Autowired DustService dustService;

    @Test
    public void 먼지_저장() throws Exception {
        // given
        Dust dust = new Dust();
        dust.setTime(LocalDateTime.now());
        dust.setLevel(40.56f);
        // when
        Long dustId = dustService.save(dust);
        // then
        Dust reDust = dustRepository.findById(dustId).get();
        Assertions.assertThat(reDust.getId()).isEqualTo(dust.getId());

    }

    @Test
    public void 먼지_단일_조회() throws Exception {
        // given
        Dust dust1 = new Dust();
        dust1.setTime(LocalDateTime.now());
        dust1.setLevel(40.56f);
        Long save1 = dustService.save(dust1);


        Dust dust2 = new Dust();
        dust2.setTime(LocalDateTime.now());
        dust2.setLevel(25.6f);
        Long save2 = dustService.save(dust2);

        // when
        Dust findDust = dustService.findDust(dust2.getId());

        // then
        Dust dust = dustRepository.findById(findDust.getId()).get();
        Assertions.assertThat(dust2).isEqualTo(dust);

    }

}