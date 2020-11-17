package com.example.mongodb.nbd.Service;

import com.example.mongodb.nbd.Cases.CovidCases;
import com.example.mongodb.nbd.Repository.CovidRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.Date;
import java.util.List;

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
        System.out.println(this.covidRepository.getAllByLocation(location).toString());
        return this.covidRepository.getAllByLocation(location);
    }

    public List<CovidCases> getAllByContinentAndDateAfter(String continent, Date date){
        return this.covidRepository.getAllByContinentAndDateAfter(continent,date);
    }

    public List<CovidCases> getAllByDate(Date date){
        return this.covidRepository.getAllByDate(date);
    }

    public CovidCases getById(String id){
        return this.covidRepository.getBy_id(id);
    }

    public CovidCases updateCases(String id,CovidCases covidCases) {
        this.covidRepository.getBy_id(id).setContinent(covidCases.continent);
        this.covidRepository.getBy_id(id).setLocation( covidCases.location);
        this.covidRepository.getBy_id(id).setNewDeaths( covidCases.newDeaths);
        this.covidRepository.getBy_id(id).setNewCases( covidCases.newCases);
        this.covidRepository.getBy_id(id).setTotalCases(covidCases.totalCases);
        this.covidRepository.getBy_id(id).setTotalDeaths( covidCases.totalDeaths);
        this.covidRepository.getBy_id(id).setTotalCasesPerMillion( covidCases.totalCasesPerMillion);
        this.covidRepository.getBy_id(id).setNewCasesSmoothed(covidCases.newCasesSmoothed);
        this.covidRepository.getBy_id(id).setNewDeathsSmoothed( covidCases.newDeathsSmoothed);
        this.covidRepository.getBy_id(id).setNewCasesPerMillion(covidCases.newCasesPerMillion);
        this.covidRepository.getBy_id(id).setDate( covidCases.date);


        return  this.covidRepository.getBy_id(id);
    }

    public CovidCases saveCases(CovidCases covidCases) {
        return this.covidRepository.save(covidCases);
    }

    public void deleteCase(String id){
        this.covidRepository.deleteBy_id(id);
    }

    public void saveList(List<CovidCases> covidCases){
        for (CovidCases covid : covidCases){
            saveCases(covid);
        }
    }


    public List<CovidCases> getAllByContinentAndDateBetween(String continent, Date datePrev, Date dateAft) {
        return this.covidRepository.getAllByContinentAndDateBetween(continent,datePrev,dateAft);
    }
}
