/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seed.shopping.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:tiayo.pro@gmail.com">Ulrich TIAYO NGNINGAHE</a>
 * @param <T>
 */
public abstract class AbstractDataManager<T> {

    private final List<T> objects = new ArrayList<>();

    /**
     * Enregistre une nouvelle entrée de l'objet passé en paramètre dans la
     * liste existante
     *
     * @param object entrée à enregistrer
     */
    public void create(T object) {
        objects.add(getNewInstance(object));
    }

    /**
     * Fourni la liste des objets enregistrés
     *
     * @return liste de tous les objets enregistrés
     */
    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        objects.forEach((obj) -> {
            result.add(getNewInstance(obj));
        });
        return result;
    }

    /**
     * Fourni une nouvelle instance de l'objet comprenant exactement les mêmes
     * données. Implémentation manuelle du clone.
     *
     * @param object
     * @return
     */
    protected abstract T getNewInstance(T object);

}
