/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;

/**
 *
 * @author nuzly
 */
public interface BaseDAO<T, K extends Serializable> {

    T create(T t);
    T read(K id);
    T update(T t);
    void delete(T t);
}
