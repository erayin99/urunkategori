package com.urunsatisim.urun.app.service;


import com.urunsatisim.urun.app.Entity.Kategori;
import com.urunsatisim.urun.app.Entity.Urun;
import com.urunsatisim.urun.app.mapper.USMapper;
import com.urunsatisim.urun.app.model.KategoriDto;
import com.urunsatisim.urun.app.repository.UrunRepository;
import com.urunsatisim.urunmodel.request.UrunRequestDto;
import com.urunsatisim.urunmodel.response.UrunResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UrunServiceImpl implements UrunService{

    private final UrunRepository urunRepository;

    private final KategoriSerice kategoriSerice;

    @Override
    public UrunResponseDto getUrunById(UrunRequestDto urunRequestDto) {
        Urun urun =  urunRepository.findById ( urunRequestDto.getId ())
               .orElseThrow (NoSuchElementException::new);
        ModelMapper modelMapper = new ModelMapper ();

        return modelMapper.map ( urun, UrunResponseDto.class );
    }

    @Override
    public UrunResponseDto addUrun(UrunRequestDto urunRequestDto) {
        ModelMapper modelMapper = new ModelMapper ();
        Set<Kategori> kategoriler = new HashSet<> ();
        urunRequestDto.getKategoriids ().forEach ( k->{
           KategoriDto kategoriDto =  kategoriSerice.getKategoriById ( k );
           kategoriler.add ( USMapper.map ( kategoriDto, Kategori.class ));
        } );
        Urun eklenecekurun = modelMapper.map ( urunRequestDto, Urun.class );
        eklenecekurun.setKategoriler ( kategoriler );
         Urun eklenenurun =  urunRepository.save (  eklenecekurun);
        return modelMapper.map ( eklenenurun, UrunResponseDto.class );
    }
}
