package com.urunsatisim.urun.app.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String aktif;

    private String aciklama;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "urunkategori",
            joinColumns = @JoinColumn ( name =  "urun_id"),
            inverseJoinColumns = @JoinColumn(name = "kategori_id")
    )
    private Set<Kategori> kategoriler;




}
