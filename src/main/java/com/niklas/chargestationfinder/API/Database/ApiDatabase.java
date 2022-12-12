package com.niklas.chargestationfinder.API.Database;


import com.niklas.chargestationfinder.API.Station.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiDatabase extends MongoRepository<Station, String> {

}
