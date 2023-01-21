package com.urunsatisim.urun.app.controller;


import com.urunsatisim.urun.app.model.KategoriDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/kategori")
public interface KategoriController {
	
	@PostMapping("/kategoriEkle")
	ResponseEntity<KategoriDto> kategoriEkle(@Valid @RequestBody KategoriDto Dto);
	
	@GetMapping("/tumKategoriler")
	ResponseEntity<List<KategoriDto>> getTumKategoriler();
	
	@GetMapping("/kategori/{id}")
	ResponseEntity<KategoriDto> getKategoriById(@PathVariable Integer id);
	
	@DeleteMapping("/kategorisil/{id}")
	ResponseEntity<KategoriDto> deleteKategoriById(@PathVariable Integer id);
}
