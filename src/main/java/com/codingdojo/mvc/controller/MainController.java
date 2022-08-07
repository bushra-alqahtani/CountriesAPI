package com.codingdojo.mvc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvc.services.CLCService;

@RestController
@RequestMapping("/api")
public class MainController {
	
   @Autowired 
   CLCService clcService;

   	
       
       //1What query would you run to get all the countries that speak Slovene? 
   	   //Your query should return the name of the country, language, and language percentage. Your query should 
       //arrange the result by language percentage in descending order.
       @RequestMapping("/countries/{language}")
       public List<Object[]> countriesWhereLanguage(@PathVariable("language") String language) {
           return clcService.findCountriesWhereLanguage(language);
       }
       
       //2What query would you run to display the total number of cities
//       for each country? Your query should return the name of the country and the total number of 
//       cities. Your query should arrange the result by the number of cities in descending order.
       @RequestMapping("/countriesCities")
       public List<Object[]> allCountriesCities() {
           return clcService.findAllCountriesCitiesCount();
       }
       
       //3What query would you run to get all the cities in Mexico
       //with a population of greater than 500,000? Your query should arrange the result by population in descending order.
       @RequestMapping("/countriesCities/{population}/{country}")
       public List<Object[]> findAllCountriesCitiesCount(@PathVariable("population") long population,@PathVariable("country") String country) {
           return clcService.findAllCitiesInCountryWithPopulationGreaterThan(population, country);
       }
       
       
       //4What query would you run to get all languages in each country with a percentage
       //greater than 89%? Your query should arrange the result by percentage in descending order.
       @RequestMapping("/languages/{percentage}")
       public List<Object[]> languagesWithPercentageGreaterThan(@PathVariable("percentage") Double Percentageg){
       	return clcService.languagesWithPercentageGreaterThan(Percentageg);
       }
       
       //5What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
       @RequestMapping("/surfaceAndPopulation/{surface}/{population}")
       public List<Object[]> countriesWithSurfaceAndPopulation(@PathVariable("surface") Double surface,@PathVariable("population") Integer population){
       	return clcService.countriesWithSurfaceAreaAndPopulation(surface, population);
       }
       
       // 6 What query would you run to get countries with only Constitutional 
       //Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
       @RequestMapping("/govermentAndLife/{goverment}/{surface}/{life}")
       public List<Object[]> countriesGovermentAndLife_expectancy(@PathVariable("goverment") String goverment,@PathVariable("surface") Double surface_area,@PathVariable("life") Double life){
       	return clcService.countriesWithGovermentAndLife_expectancy(goverment,surface_area, life);
       }
       
     
       // 7-What query would you run to get all the cities of Argentina inside the 
       //Buenos Aires district and have the population greater than 500, 000? The 
       //query should return the Country Name, City Name, District, and Population
       @RequestMapping("/populationOfCitiesInBuenosAires/{countryName}/{district}/{population}")
       public List<Object[]> citiesInCountryInDistrictWithPopulation(@PathVariable("countryName") String countryName ,@PathVariable("district") String district,@PathVariable("population") Long population){
   		return clcService.citiesInCountryInDistrictWithPopulation(countryName, district, population);
   	}
       
       //8What query would you run to summarize the number of countries in each region? The query should 
//       display the name of the region and the number of countries. Also, the query should arrange the result 
//       by the number of countries in descending order.
       @RequestMapping("/citiesInRegion")
       public List<Object[]> citiesInRegion(){
       	return clcService.citiesInRegion();
       }
   }
