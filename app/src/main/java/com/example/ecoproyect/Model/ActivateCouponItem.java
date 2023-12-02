package com.example.ecoproyect.Model;

public class ActivateCouponItem {
    String codigo;
    int canjeable;
    String nombreTienda;
    String descripcion;
    int puntos;
    String nombreUsuario;
    String email;

    public ActivateCouponItem(String codigo, int canjeable, String nombreTienda, String descripcion, int puntos, String nombreUsuario, String email) {
        this.codigo = codigo;
        this.canjeable = canjeable;
        this.nombreTienda = nombreTienda;
        this.descripcion = descripcion;
        this.puntos = puntos;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCanjeable() {
        return canjeable;
    }

    public void setCanjeable(int canjeable) {
        this.canjeable = canjeable;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
