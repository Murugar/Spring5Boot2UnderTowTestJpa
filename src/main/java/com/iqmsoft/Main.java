package com.iqmsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.domain.Sample;
import com.iqmsoft.domain.SampleType;
import com.iqmsoft.repository.SampleRepository;
import com.iqmsoft.repository.SampleTypeRepository;

@SpringBootApplication
public class Main implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Autowired
	SampleRepository sampleRepository;
	
	@Autowired
	SampleTypeRepository sampletypeRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SampleType s = new SampleType("type1");
		SampleType s1 = new SampleType("type2");
		SampleType s2 = new SampleType("type3");
		SampleType s3 = new SampleType("type4");
		
		sampletypeRepository.save(s);
		sampletypeRepository.save(s1);
		sampletypeRepository.save(s2);
		sampletypeRepository.save(s3);
		
		sampleRepository.save(new Sample("Test1", true, 10, s));
		sampleRepository.save(new Sample("Test2", false, 11, s1));
		sampleRepository.save(new Sample("Test3", true, 12, s1));
		sampleRepository.save(new Sample("Test4", false, 13, s2));
		sampleRepository.save(new Sample("Test5", true, 14, s2));
		sampleRepository.save(new Sample("Test6", true, 15, s3));
		sampleRepository.save(new Sample("Test7", true, 17, s3));
		sampleRepository.save(new Sample("Test8", true, 18, s3));
		sampleRepository.save(new Sample("Test9", true, 19, s3));
		sampleRepository.save(new Sample("Test10", true, 20, s3));
		
		logger.info("Sample Test Data saved");		
	}
}
