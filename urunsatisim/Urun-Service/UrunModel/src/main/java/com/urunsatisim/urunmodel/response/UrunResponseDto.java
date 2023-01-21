package com.urunsatisim.urunmodel.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrunResponseDto {


    private long id;

    private String name;

    private String aktif;

    private String aciklama;
}
