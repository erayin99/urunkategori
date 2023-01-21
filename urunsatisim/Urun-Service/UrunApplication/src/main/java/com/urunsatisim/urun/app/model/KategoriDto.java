package com.urunsatisim.urun.app.model;

import com.urunsatisim.urun.app.validation.YesNoValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KategoriDto {
	private Integer id;
	@NotNull(message = "kATEGORI ADI NULL OLAMAZ")
	@NotEmpty(message = "KATEGORI ADI BOS OLAMAZ")
	private String adi;
	@Min(value = 0, message = "ust kategori 0 dan kucuk olamaz")
	private Integer ustkategori;
	@NotNull(message = "KATEGORI AKTIF NULL OLAMAZ")
	@NotEmpty(message = "KATEGORI AKTIF BOS OLAMAZ")
	@Size(min = 1, max = 1, message = "kategori aktif E veye H olabilir")
	//@Pattern(regexp = "(E|H)$", message = "kategori aktif E veye H olabilir")
	@YesNoValidation(messgae = "kategori aktif E veye H olabilir")
	private String aktif;
	
}
