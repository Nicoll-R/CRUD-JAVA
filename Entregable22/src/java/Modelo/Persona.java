/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Persona {
    int id;
    String dni;
    String nombre;
    String apellido;
    String telef;
    int id_em;
    String nom;
    String correo;
    
    public Persona() {
    }

    public Persona(String dni, String nombre, String apellido, String telef, int id_em, String nom, String correo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telef = telef;
        this.id_em = id_em;
        this.nom = nom;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }
      public int getIdem() {
        return id_em;
    }

    public void setIdem(int id) {
        this.id = id_em;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

