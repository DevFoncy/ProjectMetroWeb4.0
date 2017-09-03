/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Singleton.DBConnexion;
import Modelo.DTO.Orden;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Junior Alvarez
 */
public class OrdenDAO
{

    Connection con = DBConnexion.getInstance();

    public boolean add(Orden a)
    {
        try
        {
            String req = "INSERT INTO `dbmetro`.`orden` (`login`, `precioTotal`) "
                    + "VALUES ('"+a.getLogin()+"', '"+a.getPrecioTotal()+"');";

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

    public boolean remove(int idCmd)
    {
        try
        {
            String req = "DELETE FROM orden " + "WHERE idorden = " + idCmd;

            Statement st = con.createStatement();

            int rs = st.executeUpdate(req);

            if (rs > 0)
            {
                return true;
            }

        } catch (Exception e1)
        {
            e1.printStackTrace();
        }

        return false;
    }

    public boolean validerCommande(int idOrden)
    {
        try
        {
            String req = "UPDATE `dbmetro`.`orden` SET "
                    + "`estado`='1' "
                    + "WHERE `idorden`='"+idOrden+"';";

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

     public boolean refuserCommande(int idOrden)
    {
        try
        {
            String req = "UPDATE `dbmetro`.`orden` SET "
                    + "`estado`='2' "
                    + "WHERE `idorden`='"+idOrden+"';";

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

     
    public Vector<Orden> findByLogin(String login)
    {
        String req = "SELECT* " + " FROM orden WHERE login = '" +login+"';";

        Vector<Orden> vect = null;

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

                Orden e = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getInt(5));
                

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
    
    public Vector<Orden> findAll()
    {
        String req = "SELECT* " + " FROM orden ";

        Vector<Orden> vect = null;

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

                Orden e = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getInt(5));
                

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


    
    public int getLastID()
    {
        String req = "SELECT max(idorden) FROM orden ";

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            if (rs.next())
            {
                return rs.getInt(1);
            }

        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return -1;
    }

    
    public Vector<Orden> findEnAttente()
    {
        String req = "SELECT* " + " FROM orden where estado=0";

        Vector<Orden> vect = null;

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

                Orden e = new Orden(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDouble(4), rs.getInt(5));
                

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
    
    
    
}
