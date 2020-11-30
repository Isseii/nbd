package com.example.mongodb.nbd.Service;

import com.example.mongodb.nbd.Cases.CovidCases;
import com.example.mongodb.nbd.IdGenerate.IdGenerate;
import com.example.mongodb.nbd.Repository.CovidRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public class Service {

    CovidRepository covidRepository;

    @Autowired
    public Service(CovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    public List<CovidCases> getAll(){
        return this.covidRepository.findAll();
    }

    public List<CovidCases> getAllByLocation(String location){
        return this.covidRepository.getAllByLocation(location);
    }

    public List<CovidCases> getAllByContinentAndDateAfter(String continent, Date date){
        return this.covidRepository.getAllByContinentAndDateAfter(continent,date);
    }

    public List<CovidCases> getAllByContinent(String continent){
        return this.covidRepository.getAllByContinent(continent);
    }


    public CovidCases getById(String id){
        return this.covidRepository.getBy_id(id);
    }


    public CovidCases saveCases(CovidCases covidCases) {
        covidCases.set_id(new IdGenerate().generateId());
        return this.covidRepository.save(covidCases);
    }

    public CovidCases updatedCases(CovidCases covid, Optional<CovidCases> covidObject) {

        CovidCases tmp =  covidObject.get();
        tmp.setNewCases(covid.getNewCases());
        tmp.setNewDeaths(covid.getNewDeaths());
        tmp.setNewDeathsSmoothed(covid.getNewDeathsSmoothed());
        tmp.setNewCasesSmoothed(covid.getNewCasesSmoothed());
        tmp.setTotalCases(covid.getTotalCases());
        tmp.setTotalDeaths(covid.getTotalDeaths());
        tmp.setTotalCasesPerMillion(covid.getTotalCasesPerMillion());
        tmp.setDate(covid.getDate());
        tmp.setContinent(covid.getContinent());
        tmp.setLocation(covid.getLocation());
        tmp.setNewCasesPerMillion(covid.getNewCasesPerMillion());

        return this.covidRepository.save(tmp);
    }


    public void deleteCase(String id){
        this.covidRepository.deleteBy_id(id);
    }



    public List<CovidCases> getAllByContinentAndDateBetween(String continent, Date datePrev, Date dateAft) {
        return this.covidRepository.getAllByContinentAndDateBetween(continent,datePrev,dateAft);
    }

    public void deleteCasesByLocation(String location) {
        this.covidRepository.deleteByLocation(location);
    }
}
