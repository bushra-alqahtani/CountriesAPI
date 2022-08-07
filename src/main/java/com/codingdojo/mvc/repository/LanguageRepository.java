package com.codingdojo.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long>{

	
//	//What query would you run to get all languages in each country with a 
//	//percentage greater than 89%?
//	//Your query should arrange the result by percentage in descending order.
//	@Query(value="SELECT * from languages",nativeQuery=true)
//	List<Language> allLang();
//	
//	@Query(value="SELECT * from languages  where language =?1 Order by percentage desc", nativeQuery=true)
//    List<Language> findCountriesDesc(String language);
//
//	@Query(value="select l.* from countries c join languages l on c.id= l.country_id where l.percentage > ?1 order by l.percentage desc", nativeQuery=true)
//	List<Language> findLanguagesByLiteracyGT(double pct);
	//join
//		4- What query would you run to get all languages in each country with a percentage greater than 89%?
//		 Your query should arrange the result by percentage in descending order.
		 @Query("SELECT l,c FROM Language l JOIN l.country c WHERE l.percentage > ?1 ORDER BY l.percentage DESC")
		 List<Object[]> joinLanguageAndCountryWithPercentageGreaterThan(Double percentage);
	//list	
//		 What query would you run to get all languages in each country with a percentage greater than 89%?
//		 Your query should arrange the result by percentage in descending order.
		 @Query("SELECT l.country.name, l.percentage, l.language FROM Language l WHERE l. > ?1 ORDERpercentage BY l.percentage DESC")
		 List<Object[]> languagesWithPercentageGreaterThan(Double percentage);

	
}
