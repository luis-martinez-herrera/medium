package com.example.performance;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PerformanceMapper {
    PerformanceMapper INSTANCE = Mappers.getMapper(PerformanceMapper.class);

    PerformanceDTO carToCarDto(PerformanceEntity car);
}