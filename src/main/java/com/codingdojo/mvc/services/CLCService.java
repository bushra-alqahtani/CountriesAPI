package com.codingdojo.mvc.services;
	

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.mvc.repository.CityRepository;
import com.codingdojo.mvc.repository.CountryRepository;
import com.codingdojo.mvc.repository.LanguageRepository;



@Service
public class CLCService {
	
	@Autowired	
	LanguageRepository languageRepository;
	@Autowired	
	CityRepository cityRepository;
	@Autowired	
	CountryRepository countryRepository;
	
	
	// 1
		public List<Object[]> findCountriesWhereLanguage(String language) {
			return countryRepository.allcountriesSpeaksLanguage(language);
		}

	// 2
		public List<Object[]> findAllCountriesCitiesCount() {
			return countryRepository.joinCountrysAndCityOrderByCitiesCount();
		}

	// 3
		public List<Object[]> findAllCitiesInCountryWithPopulationGreaterThan(long populaiton,String name) {
			return countryRepository.joinCountryAndCitiesWithPopulationGreaterThan(populaiton, name);
		}
		
	// 4
		public List<Object[]> languagesGreaterThan(Double percentage){
			return languageRepository.joinLanguageAndCountryWithPercentageGreaterThan(percentage);
		}
	//with percentage	
		public List<Object[]> languagesWithPercentageGreaterThan(Double percentage){
			return languageRepository.languagesWithPercentageGreaterThan(percentage);
		}
	//	
		public List<Object[]> countriesWithSurfaceAreaAndPopulation(Double surface_area,Integer population){
			return countryRepository.countriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(surface_area, population);
		}
		
		//6
		public List<Object[]> countriesWithGovermentAndLife_expectancy(String government,Double surface,Double life_expectancy){
			return countryRepository.countriesWithGovermentAndLife_expectancy(government, surface, life_expectancy);
		}
		
		//7
		public List<Object[]> citiesInCountryInDistrictWithPopulation(String country , String district, Long population){
			return cityRepository.joinCitiesInCountryInDistrictWithPopulation(country, district, population);
		}
		
		// 8
		public List<Object[]> citiesInRegion (){
			return countryRepository.citiesInRegion();
		}

		
	
}
