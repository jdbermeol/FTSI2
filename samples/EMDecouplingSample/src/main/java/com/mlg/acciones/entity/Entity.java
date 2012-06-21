package com.mlg.acciones.entity;

public interface Entity<E,F> {

    F getId();

    void setId(F id);

    E toVo();
}