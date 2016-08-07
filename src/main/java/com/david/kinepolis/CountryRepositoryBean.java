package com.david.kinepolis;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by David on 7/08/2016.
 */
public class CountryRepositoryBean implements CountryRepository {

    private EntityManager em;

    public CountryRepositoryBean(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Country> findAllCountries() {
        return em.createQuery("select c from SN_CNT", Country.class).getResultList();
    }
}
