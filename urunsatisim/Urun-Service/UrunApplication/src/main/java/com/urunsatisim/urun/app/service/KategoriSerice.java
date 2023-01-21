package com.urunsatisim.urun.app.service;



import com.urunsatisim.urun.app.model.KategoriDto;


import java.util.List;


public interface KategoriSerice {
	
	KategoriDto saveKategori(KategoriDto requestdto);

	List<KategoriDto> getTumKategoriler();;

	KategoriDto getKategoriById(Integer id);
	
	KategoriDto deleteKategori(Integer id);
	

}
