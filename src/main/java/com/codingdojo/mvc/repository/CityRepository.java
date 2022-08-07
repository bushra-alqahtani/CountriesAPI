package com.codingdojo.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.City;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
//		7-What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? 
//		The query should return the Country Name, City Name, District, and Population.

		 @Query("SELECT t.name, t.country.name , t.district , t.population FROM City t JOIN t.country c WHERE c.name = ?1 AND t.district = ?2 AND t.population > ?3")
		 List<Object[]> joinCitiesInCountryInDistrictWithPopulation(String country , String district, Long population);
		 
//		Get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000. return the Country Name, City Name, District, and Population.
//		@Query(value="SELECT c from City c  where district = ?1 and population > ?2")
//		List<City> findCityByDistrict(String district, int population);
//
		 
}		