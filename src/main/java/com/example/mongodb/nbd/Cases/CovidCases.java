package com.example.mongodb.nbd.Cases;
import com.example.mongodb.nbd.IdGenerate.IdGenerate;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

@Document
@Configuration
@EnableWebMvc
public class CovidCases
{
    @Id  public String _id;
    @Field  public String continent;
    @Field  public String location;
    @Field  public Date date;
    @Field  public Double totalCases;
    @Field  public Double newCases;
    @Field  public Double newCasesSmoothed;
    @Field  public Double totalDeaths;
    @Field  public Double newDeaths;
    @Field  public Double newDeathsSmoothed;
    @Field  public Double totalCasesPerMillion;
    @Field  public Double newCasesPerMillion;


    public CovidCases() {}

    public CovidCases(String _id,String continent, String location, Date date, Double totalCases,
                      Double newCases, Double newCasesSmoothed, Double totalDeaths,
                      Double newDeaths, Double newDeathsSmoothed, Double totalCasesPerMillion,
                      Double newCasesPerMillion) {
        this._id = _id;
        this.continent = continent;
        this.location = location;
        this.date = date;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.newCasesSmoothed = newCasesSmoothed;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.newDeathsSmoothed = newDeathsSmoothed;
        this.totalCasesPerMillion = totalCasesPerMillion;
        this.newCasesPerMillion = newCasesPerMillion;
    }


    public CovidCases(String continent, String location, Date date, Double totalCases, Double newCases,
                      Double newCasesSmoothed, Double totalDeaths, Double newDeaths, Double newDeathsSmoothed,
                      Double totalCasesPerMillion, Double newCasesPerMillion) {
        IdGenerate tmp = new IdGenerate();
        this._id = tmp.generateId();
        this.continent = continent;
        this.location = location;
        this.date = date;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.newCasesSmoothed = newCasesSmoothed;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.newDeathsSmoothed = newDeathsSmoothed;
        this.totalCasesPerMillion = totalCasesPerMillion;
        this.newCasesPerMillion = newCasesPerMillion;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Double totalCases) {
        this.totalCases = totalCases;
    }

    public Double getNewCases() {
        return newCases;
    }

    public void setNewCases(Double newCases) {
        this.newCases = newCases;
    }

    public Double getNewCasesSmoothed() {
        return newCasesSmoothed;
    }

    public void setNewCasesSmoothed(Double newCasesSmoothed) {
        this.newCasesSmoothed = newCasesSmoothed;
    }

    public Double getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Double totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Double getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Double newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Double getNewDeathsSmoothed() {
        return newDeathsSmoothed;
    }

    public void setNewDeathsSmoothed(Double newDeathsSmoothed) {
        this.newDeathsSmoothed = newDeathsSmoothed;
    }

    public Double getTotalCasesPerMillion() {
        return totalCasesPerMillion;
    }

    public void setTotalCasesPerMillion(Double totalCasesPerMillion) {
        this.totalCasesPerMillion = totalCasesPerMillion;
    }

    public Double getNewCasesPerMillion() {
        return newCasesPerMillion;
    }

    public void setNewCasesPerMillion(Double newCasesPerMillion) {
        this.newCasesPerMillion = newCasesPerMillion;
    }

    @Override
    public String toString() {
        return "Covid cases in "+location+" of "+continent+", at "+date+ ", total cases : "+ totalCases +", new cases : "+ newCases
             + ", new cases smoothed : "+ newCasesSmoothed +", total deaths : " + totalDeaths +", new deaths : "+
                newDeaths +", new deaths smoothed : "+ newDeathsSmoothed + ", total cases per million : "+
                totalCasesPerMillion +", new cases per million : "+ newCasesPerMillion;
    }
}
