package com.urunsatisim.urun.app.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kategori {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "adi")
	private String adi;;
	
	private Integer ustkategori;
	
	private String aktif;

	@ManyToMany(mappedBy = "kategoriler")
	private Set<Urun> urunler;
	
}
