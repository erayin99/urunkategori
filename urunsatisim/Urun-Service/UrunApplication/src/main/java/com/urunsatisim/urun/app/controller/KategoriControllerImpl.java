package com.urunsatisim.urun.app.controller;




import com.urunsatisim.urun.app.model.KategoriDto;
import com.urunsatisim.urun.app.service.KategoriSerice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class KategoriControllerImpl implements KategoriController {

	private final KategoriSerice kateSerice;

	@Override
	public ResponseEntity<KategoriDto> kategoriEkle(@Valid @RequestBody KategoriDto Dto) {
		
		return ResponseEntity.ok (kateSerice.saveKategori(Dto));
	}

	@Override
	public ResponseEntity<List<KategoriDto>> getTumKategoriler() {
		
		return ResponseEntity.ok (kateSerice.getTumKategoriler());
	}

	@Override
	public ResponseEntity<KategoriDto> getKategoriById(Integer id) {
		
		return ResponseEntity.ok (kateSerice.getKategoriById(id));
	}

	@Override
	public ResponseEntity<KategoriDto> deleteKategoriById(Integer id) {
		
		return ResponseEntity.ok (kateSerice.deleteKategori(id));
	}
	

	
	

}
