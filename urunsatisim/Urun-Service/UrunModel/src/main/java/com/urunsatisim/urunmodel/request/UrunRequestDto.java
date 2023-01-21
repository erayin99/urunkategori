package com.urunsatisim.urunmodel.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrunRequestDto {

    private long id;

    @NotEmpty
    private String name;

    @Pattern(regexp = "(E|H)$", message = "kategori aktif E veye H olabilir")
    private String aktif;

    @NotEmpty
    private String aciklama;

    @NotEmpty(message = "kategori alani bos birakilamaz")
    private Set<@NotNull(message = "kategori id girilmeli") Integer> kategoriids;
}
