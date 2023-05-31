package com.weed.PM.controller;

import com.weed.PM.entity.Dust;
import com.weed.PM.repository.DustRepository;
import com.weed.PM.service.DustService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dust")
public class DustController {
    private final DustService dustService;

    @GetMapping("")
    public String dust() {
        return "dust-main";
    }

    @GetMapping("/current")
    public String dustCurrent() {
        return "currentDust";
    }



    @GetMapping("/past")
    public String dustPast(Model model) throws Exception {
        List<Dust> dusts = dustService.findAllDust();
        Collections.reverse(dusts);
        List<String> status = dustService.status();
        Collections.reverse(status);
        if (!dusts.isEmpty()) {
            model.addAttribute("dusts", dusts);
            model.addAttribute("status", status);
        } else {
            Exception exception = new Exception("먼지 리스트가 없습니다.");
            throw exception;
        }
        return "pastDust";
    }

    @GetMapping("/save")
    public String dustSave() {
        return "dustSave";
    }

    @PostMapping("/save")
    public String dustSave(@RequestParam float dustLevel) {
        Dust dust = new Dust();
        dust.setLevel(dustLevel);
        dust.setTime(LocalDateTime.now());
        dustService.save(dust);
        return "redirect:/";

    }
}
