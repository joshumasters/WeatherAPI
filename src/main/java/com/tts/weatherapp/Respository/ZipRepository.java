package com.tts.weatherapp.Respository;


import com.tts.weatherapp.models.Request;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipRepository extends CrudRepository<Request, Long> {

    
}
