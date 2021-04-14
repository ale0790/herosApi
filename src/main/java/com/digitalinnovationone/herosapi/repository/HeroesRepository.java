package com.digitalinnovationone.herosapi.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import com.digitalinnovationone.herosapi.document.Heroes;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {


}
