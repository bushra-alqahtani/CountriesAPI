package com.codingdojo.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Country;
@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	//1-What query would you run to get all the countries that speak Slovene?
	//Your query should return the name of the country, language, and language 
	//percentage. Your query should arrange the result by language percentage in descending order.
	 	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language =?1")
		List<Object[]> allcountriesSpeaksLanguage(String language);	
		

//		2-What query would you run to display the total number of cities for each country?
//		Your query should return the name of the country and the total number of cities. 
//		Your query should arrange the result by the number of cities in descending order.
		 @Query("SELECT c.name ,COUNT(t) FROM Country c JOIN c.cities t  GROUP BY c.name ORDER BY COUNT(t) DESC")
		 List<Object[]> joinCountrysAndCityOrderByCitiesCount();

		 

//		 3-What query would you run to get all the cities in Mexico with a population of greater than 500,000? 
//		 Your query should arrange the result by population in descending order.
		 @Query("SELECT c.name ,t.name , t.population FROM Country c JOIN c.cities t WHERE t.population > ?1 AND c.name=?2 ORDER BY t.population DESC")
		 List<Object[]> joinCountryAndCitiesWithPopulationGreaterThan(long population,String name);

	
//		 5-What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
		 @Query("SELECT c.name , c.surface_area  , c.population FROM Country c WHERE c.surface_area < ?1 AND c.population > ?2")
		 List<Object[]> countriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(Double surface_area,Integer population);
		 

//		 6-What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
		 @Query("SELECT c.name , c.government_form  , c.surface_area FROM Country c WHERE c.government_form = ?1 AND c.surface_area < ?2 AND c.life_expectancy > ?3")
		 List<Object[]> countriesWithGovermentAndLife_expectancy(String government_form,Double surface_area,Double life_expectancy);

 
//		 8-What query would you run to summarize the number of countries in each region?
//		 The query should display the name of the region and the number of countries.
//		 Also, the query should arrange the result by the number of countries in descending order.
		 @Query("SELECT c.region, COUNT(t) FROM Country c JOIN c.cities t GROUP BY region ORDER BY COUNT(t) DESC")
		 List<Object[]> citiesInRegion();

}
