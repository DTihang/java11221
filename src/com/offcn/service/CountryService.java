package com.offcn.service;

import com.offcn.bean.City;
import com.offcn.bean.Country;

import java.util.List;

public interface CountryService {
    List<Country> selectAllCountry();
    List<City>selectCityByCountryId(int CountryId);
}
