/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Singleton.DBConnexion;
import Modelo.DTO.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Junior Alvarez
 */
public class ClienteDAO{
    Connection con = DBConnexion.getInstance();

    public boolean add(Cliente a)
    {
        try
        {
            String req = "INSERT INTO `dbmetro`.`clientes` (`login`, `contraseña`, `nombre`, `apellidos`, `fechaNacimiento`)"
                    + " VALUES ('" + a.getLogin() + "', '" + a.getContraseña()+ "', '" + a.getNombre()+ "', '" + a.getApellidos()+ "', '" + a.getFechaNacimiento()+ "');";

            Statement st = con.createStatement();
            int rs = st.executeUpdate(req);
            if (rs > 0){
                return true;
            }

        } catch (Exception e1){
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return false;
    }

    public boolean remove(String login)
    {
        try
        {
            String req = "DELETE FROM clientes " + "WHERE login = " + login;
            Statement st = con.createStatement();
            int rs = st.executeUpdate(req);
            if (rs > 0){
                return true;
            }
        } catch (Exception e1){
            e1.printStackTrace();
        }

        return false;
    }

    public boolean update(Cliente a)
    {
        try
        {
            String req = "UPDATE `dbmetro`.`clientes` "
                    + "SET `contraseña`='" + a.getContraseña()+ "', "
                    + "`nombre`='" + a.getNombre()+ "', "
                    + "`apellidos`='" + a.getApellidos()+ "' "
                    + "WHERE `login`='" + a.getLogin() + "';";

            System.out.println(req);

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

    public Cliente findByAuthentification(String log, String pass)
    {
        String req = "SELECT* " + " FROM clientes " + " WHERE login = '" + log + "' AND contraseña = '" + pass + "';";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            Cliente e = null;

            if (rs.next())
            {
              e = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));

            }
            return e;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public Vector<Cliente> findAll()
    {
        String req = "SELECT* " + " FROM clientes ";

        Vector<Cliente> vect = null;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next())
            {

                if (vect == null)
                {
                    vect = new Vector<>();
                }

                Cliente e = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));

                vect.add(e);
            }

            return vect;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public boolean bloquer(String login)
    {
        try
        {
            String req = "UPDATE clientes SET "
                    + "estado=0"
                    + " WHERE login='" + login + "';";

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

    public boolean modifier(Cliente a)
    {
        try
        {
            String req = "UPDATE `dbmetro`.`clientes` SET "
                    + "`contraseña`='" + a.getContraseña()+ "', "
                    + "`nombre`='" + a.getNombre()+ "', "
                    + "`apellidos`='" + a.getApellidos()+ "', "
                    + "`fechaNacimiento`='" + a.getFechaNacimiento()+ "', "
                    + "`estado`=" + a.getEstado()+ "  "
                    + "WHERE `login`='" + a.getLogin() + "';";

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return false;
    }

    
    
        public Cliente findByLogin(String log)
    {
        String req = "SELECT* " + " FROM clientes " + " WHERE login = '" + log + "';";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            Cliente e = null;

            if (rs.next())
            {
                //public Cliente(String login, String mdp, String nom, String prenom, Date dtNaissance)
                
                e = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
                
            }
            return e;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
    
}
