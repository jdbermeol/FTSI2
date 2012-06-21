/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mlg.aciones.presentation.lists.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author tuareg
 */
public class ModeloLista<T> extends AbstractListModel{


    private List<T> contenido;

    public ModeloLista(List<T> contenido){
        super();
        this.contenido = contenido;
    }

    public int getSize() {
        return contenido.size();
    }

    public T getElementAt(int index) {
        return  (T) contenido.get(index);
    }

}
