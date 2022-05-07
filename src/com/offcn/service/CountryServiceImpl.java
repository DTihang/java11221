package com.offcn.service;

import com.offcn.bean.City;
import com.offcn.bean.Country;
import com.offcn.dao.CountryDao;
import com.offcn.dao.CountryDaoImpl;

import java.util.List;

public class CountryServiceImpl implements CountryService{
    CountryDao cd=new CountryDaoImpl();
    @Override
    public List<Country> selectAllCountry() {
        return cd.selectAllCountry();
    }

    @Override
    public List<City> selectCityByCountryId(int CountryId) {
        return cd.selectCityByCountryId(CountryId);
    }
}
