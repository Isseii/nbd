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


    @GetMapping("/covidCases")
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

    @GetMapping("/covidCases/dateAfter/{continent}/{date}/")
    List<CovidCases> getAllByContinentAndDateAfter( @PathVariable("continent") String continent , @PathVariable("date") String date) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        System.out.println(date1);
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
            CovidCases tmp = covidData.get();
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

            return  new ResponseEntity<>(this.service.saveCases(tmp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/covidCases/{id}")
    void deleteCases(@PathVariable("id") String id){
            this.service.deleteCase(id);
    }



}


