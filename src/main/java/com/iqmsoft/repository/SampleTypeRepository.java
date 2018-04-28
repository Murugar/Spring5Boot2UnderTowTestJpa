package com.iqmsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.iqmsoft.domain.SampleType;

@Repository
public interface SampleTypeRepository extends JpaRepository<SampleType, Long>{
	Optional<SampleType> findById(Long id);
}

