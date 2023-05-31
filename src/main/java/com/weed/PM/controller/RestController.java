package com.weed.PM.controller;

import com.weed.PM.entity.Dust;
import com.weed.PM.service.DustService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    private final DustService dustService;

    @GetMapping("/api/dust")
    public ResponseEntity<List<Dust>> getAllDust() {
        List<Dust> dusts = dustService.getAllDust();
        return ResponseEntity.ok(dusts);
    }

    @PostMapping("/api/dust")
    public ResponseEntity<Dust> createDust(@RequestBody Dust dust) {
        Dust createdDust = dustService.createDust(dust);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDust);
    }
}
