package com.urunsatisim.urun.app.service;

import com.urunsatisim.urunmodel.request.UrunRequestDto;
import com.urunsatisim.urunmodel.response.UrunResponseDto;

public interface UrunService {

    UrunResponseDto getUrunById(UrunRequestDto urunRequestDto);
    UrunResponseDto addUrun(UrunRequestDto urunRequestDto);
}
