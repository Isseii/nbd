package com.example.mongodb.nbd.Controller;
import com.example.mongodb.nbd.Cases.CovidCases;
import com.example.mongodb.nbd.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }


    @GetMapping("/covidCases/all/")
    List<CovidCases> getAll(){
        return service.getAll();
    }


    @GetMapping("/covidCases/{id}/")
    CovidCases getById(@PathVariable("id") String id){
        return this.service.getById(id);
    }

    @GetMapping("/covidCases/location/{location}/")
    List<CovidCases> getAllByLocation(@PathVariable("location") String location){
        return this.service.getAllByLocation(location);
    }

    @GetMapping("/covidCases/continent/{continent}/")
    List<CovidCases> getAllByContinent(@PathVariable("continent") String continent){
        return this.service.getAllByContinent(continent);
    }

    @GetMapping("/covidCases/dateAfter/{continent}/{date}/")
    List<CovidCases> getAllByContinentAndDateAfter( @PathVariable("continent") String continent , @PathVariable("date") String date) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);

        return this.service.getAllByContinentAndDateAfter(continent,date1);
    }

    @GetMapping("/covidCases/dateBetween/{continent}/{date}&{date2}/")
    List<CovidCases> getAllByContinentAndDateAfter( @PathVariable("continent") String continent , @PathVariable("date") String date,@PathVariable("date2") String date2) throws ParseException {
        Date datePrev=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Date dateAft=new SimpleDateFormat("yyyy-MM-dd").parse(date2);

        return this.service.getAllByContinentAndDateBetween(continent,datePrev,dateAft);
    }


    @PostMapping(value = "/covidCases/add/", consumes = "application/json", produces = "application/json")
    void saveCases(@RequestBody CovidCases covidCases){
        this.service.saveCases(covidCases);
    }


    @PutMapping(path = "/covidCases/update/{id}/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CovidCases> updateCases( @PathVariable("id") String id, @RequestBody CovidCases covid){
        Optional<CovidCases> covidData = Optional.ofNullable(this.service.getById(id));

        if(covidData.isPresent()){
            return  new ResponseEntity<>(this.service.updatedCases(covid, covidData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(this.service.saveCases(covid), HttpStatus.CREATED);
        }
    }


    @DeleteMapping("/covidCases/delete/{id}")
    void deleteCases(@PathVariable("id") String id){
            this.service.deleteCase(id);
    }

    @DeleteMapping("/covidCases/delete/location/{location}/")
    void deleteCasesByLocation(@PathVariable("location") String location){
        this.service.deleteCasesByLocation(location);
    }



}


