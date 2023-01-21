package com.urunsatisim.urun.app.controller;


import com.urunsatisim.urun.app.service.UrunService;
import com.urunsatisim.urunmodel.request.UrunRequestDto;
import com.urunsatisim.urunmodel.response.UrunResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/urun")
@RequiredArgsConstructor
public class UrunControllerImpl implements UrunController{

    private final UrunService urunService;

    @Override
    public ResponseEntity<UrunResponseDto> getUrunById(UrunRequestDto urunRequestDto) {
        return ResponseEntity.ok (urunService.getUrunById(urunRequestDto));
    }

    @Override
    public ResponseEntity<UrunResponseDto> addUrun(UrunRequestDto urunRequestDto) {
        return ResponseEntity.ok (urunService.addUrun(urunRequestDto));
    }
}
