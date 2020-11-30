package com.example.mongodb.nbd.Repository;

import com.example.mongodb.nbd.Cases.CovidCases;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CovidRepository extends MongoRepository<CovidCases,String> {

    List<CovidCases> getAllByLocation(String location);
    List<CovidCases> getAllByContinent(String continent);
    List<CovidCases> getAllByContinentAndDateAfter(String continent, Date date);
    CovidCases getBy_id(String id);
    void deleteBy_id(String id);
    void deleteByLocation(String location);
    List<CovidCases> getAllByContinentAndDateBetween(String continent, Date datePrev, Date dateAft);

}
