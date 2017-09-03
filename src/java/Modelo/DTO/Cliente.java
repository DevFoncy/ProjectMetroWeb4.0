/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Junior Alvarez
 */
public class Cliente
{
  private String login ;
  private String contraseña ;
  private String nombre ;
  private String apellidos ;
  private Date fechaNacimiento;
  private int estado;

    public Cliente()
    {
    }

    public Cliente(String login, String mdp, String nom, String prenom, Date date)
    {
        this.login = login;
        this.contraseña = mdp;
        this.nombre = nom;
        this.apellidos = prenom;
        this.fechaNacimiento = date;
    }
   
    public Cliente(String login, String mdp, String nom, String prenom, Date dtNaissance,int etat)
    {
        this.login = login;
        this.contraseña = mdp;
        this.nombre = nom;
        this.apellidos = prenom;
        this.fechaNacimiento = dtNaissance;
        this.estado=etat;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.getLogin());
        hash = 83 * hash + Objects.hashCode(this.getContraseña());
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.login, other.login))
        {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Cliente{" + "login=" + getLogin() + ", contraseña=" + getContraseña() + ", nombre=" + getNombre() + ", apellidos=" + getApellidos() + ", fechaNacimiento=" + getFechaNacimiento() + '}';
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
  
}
