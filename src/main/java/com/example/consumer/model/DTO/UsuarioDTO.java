package com.example.consumer.model.DTO;

public class UsuarioDTO {

    private String idUsuario;
    private String nombreCliente;
    private String palabra;

    public UsuarioDTO( String nombreCliente, String palabra){
        this.nombreCliente = nombreCliente;
        this.palabra=palabra;
    }

    public UsuarioDTO() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", palabra='" + palabra + '\'' +
                '}';
    }
}
