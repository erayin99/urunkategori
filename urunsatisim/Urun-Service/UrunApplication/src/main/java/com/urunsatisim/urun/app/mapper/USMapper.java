package com.urunsatisim.urun.app.mapper;

import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class USMapper {

    private static final ModelMapper MODEL_MAPPER;

    static{
        MODEL_MAPPER = new ModelMapper ();

    }

    private USMapper(){}

    public static <D, T> D map(T entity, Class<D> outClass){

        return MODEL_MAPPER.map ( entity, outClass );

    }

    public static <S, D> D map(S source, D destination){
        MODEL_MAPPER.map ( source, destination );

        return destination;
    }

    public static <D, T>List<D> mapAll(Collection<T> entityList, Class<D> outClass){
        return entityList.stream ()
                .map ( entity -> map(entity, outClass) )
                .collect ( Collectors.toList () );


    }





}
