package com.urunsatisim.urun.app.repository;



import com.urunsatisim.urun.app.Entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KategoriTepository extends JpaRepository<Kategori, Integer>{


}
