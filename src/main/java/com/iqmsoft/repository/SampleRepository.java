package com.iqmsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iqmsoft.domain.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>{
	Optional<Sample> findById(Long id);
}
