package com.urunsatisim.urun.app.repository;

import com.urunsatisim.urun.app.Entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {



    
}
