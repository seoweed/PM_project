package com.weed.PM.controller;

import com.weed.PM.entity.Dust;
import com.weed.PM.service.DustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DustController {
    private final DustService dustService;


    @GetMapping("/past-dust")
    public String dust(Model model) throws Exception {
        List<Dust> dusts = dustService.findAllDust();
        List<Float> dustLevels = new ArrayList<>();
        List<LocalDateTime> dustTimes = new ArrayList<>();
        if (!dusts.isEmpty()) {
            model.addAttribute("dusts", dusts);
        } else {
            Exception exception = new Exception("먼지 리스트가 없습니다.");
            throw exception;
        }

        return "pastDust";
    }
}
