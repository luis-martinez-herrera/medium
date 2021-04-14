package com.example.performance;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceService {
    private final PerformanceRepository performanceRepository;
    private final PerformanceMapper performanceMapper;

    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
        this.performanceMapper = PerformanceMapper.INSTANCE;
    }

    public List<PerformanceDTO> getAll(){
        List<PerformanceEntity> performanceEntities = performanceRepository.findAll();
        System.out.println(performanceEntities.size());
        List<PerformanceDTO> performanceDTOS = performanceEntities.stream().map(performanceMapper::carToCarDto).collect(Collectors.toList());
        return performanceDTOS;
    }
}
