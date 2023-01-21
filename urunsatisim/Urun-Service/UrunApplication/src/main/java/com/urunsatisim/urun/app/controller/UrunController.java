package com.urunsatisim.urun.app.controller;

import com.urunsatisim.urunmodel.request.UrunRequestDto;
import com.urunsatisim.urunmodel.response.UrunResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UrunController {

    @GetMapping("/urun/{id}")
    ResponseEntity<UrunResponseDto> getUrunById(UrunRequestDto urunRequestDto);

    @PostMapping("/urunEkle")
    ResponseEntity<UrunResponseDto> addUrun(@RequestBody @Valid UrunRequestDto urunRequestDto);

}
