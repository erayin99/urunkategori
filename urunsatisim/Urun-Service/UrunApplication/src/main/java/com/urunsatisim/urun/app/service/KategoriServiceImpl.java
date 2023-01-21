package com.urunsatisim.urun.app.service;



import com.urunsatisim.urun.app.Entity.Kategori;
import com.urunsatisim.urun.app.exception.RecordNotFoundException;
import com.urunsatisim.urun.app.mapper.USMapper;
import com.urunsatisim.urun.app.model.KategoriDto;
import com.urunsatisim.urun.app.repository.KategoriTepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KategoriServiceImpl implements KategoriSerice {


	private final KategoriTepository kategoriTepository;
	

	@Override
	public KategoriDto saveKategori(KategoriDto requestdto) {


		Optional<Kategori> ustKategori =
				kategoriTepository.findById(requestdto.getUstkategori());
		if(ustKategori.isPresent()) {
			throw new RecordNotFoundException ("girilen ustkategori bulunamadi");
		}
			Kategori saveKategori = kategoriTepository.
					save ( USMapper.map ( requestdto, Kategori.class ) );

		return USMapper.map ( saveKategori, KategoriDto.class );

	}
	@Override
	public List<KategoriDto> getTumKategoriler() {
		List<Kategori> entities = kategoriTepository.findAll();
				if(entities.isEmpty()) {
				throw new RecordNotFoundException ( "Kategoriler bulunamadi" );
				}
		
		return USMapper.mapAll
				( entities, KategoriDto.class );
	}
	@Override
	public KategoriDto getKategoriById(Integer id) {
		Kategori kategori = kategoriTepository.findById(id)
				.orElseThrow (()-> new RecordNotFoundException ( String.format ( "kategori bulunamadi" , id) ));

		
		return USMapper.map ( kategori, KategoriDto.class );
	}
	@Override
	public KategoriDto deleteKategori(Integer id) {
		Kategori kategori =  kategoriTepository.findById(id)
				.orElseThrow (()-> new RecordNotFoundException ( String.format ( "kategori bulunamadi" , id) ));
		kategoriTepository.deleteById(id);
		return USMapper.map ( kategori, KategoriDto.class );
	}

	
}
