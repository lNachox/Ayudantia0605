package com.EjercicioAyudantia.ISoft.models;

import lombok.Data;

@Data
public class Tarea {

    private Long id;
    private String titulo;
    private Prioridad prioridad;
    private String fechaLimite;
    private boolean completada;

}
