package com.energias2024.consumos.Entidades;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consumo_departamentos")
public class ConsumoDepartamentos {

    @Id

    private Integer id;

    @Column(nullable = false, length = 255)
    private String departamento;

    @Column
    private Integer consumo;

    @Column
    private Integer nueva_poblacion;

    // Constructor vacío para JPA
    public ConsumoDepartamentos() {}

    // Constructor con parámetros
    public ConsumoDepartamentos(Integer id, String departamento, Integer consumo, Integer poblacion) {
        this.id = id;
        this.departamento = departamento;
        this.consumo = consumo;
        this.nueva_poblacion = poblacion;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Integer getPoblacion() {
        return nueva_poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.nueva_poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "ConsumoDepartamento{" +
                "id=" + id +
                ", departamento='" + departamento + '\'' +
                ", consumo=" + consumo +
                ", poblacion=" + nueva_poblacion + '\'' +
                '}';
    }
}
