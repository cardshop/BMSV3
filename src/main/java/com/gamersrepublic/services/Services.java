package com.gamersrepublic.services;

import java.util.List;

/**
 *
 * @author jonathan
 */

public interface Services <S, ID>{
    public S find(ID id);
    public S persist(S entity);
    public S merge(S entity);
    public void remove(S entity);
    public List<S> findAll();
}

