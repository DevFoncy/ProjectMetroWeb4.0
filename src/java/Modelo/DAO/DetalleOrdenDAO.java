/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Singleton.DBConnexion;
import Modelo.DTO.DetalleOrden;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Junior Alvarez
 */
public class DetalleOrdenDAO
{

    Connection con = DBConnexion.getInstance();

    public boolean add(DetalleOrden a)
    {
        try
        {
            String req = "INSERT INTO `dbmetro`.`DETALLE_ORDEN` (`idord`, `idprod`, `nbr`) "
                    + "VALUES ('"+a.getIdorden()+"', '"+a.getIdproducto()+"', '"+a.getNbr()+"');";

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
            String req = "DELETE FROM DETALLE_ORDEN " + "WHERE idord = " + idCmd;

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

    public Vector<DetalleOrden> findAll()
    {
        String req = "SELECT* " + " FROM DETALLE_ORDEN ";

        Vector<DetalleOrden> vect = null;

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

                DetalleOrden e = new DetalleOrden(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                

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

 public Vector<DetalleOrden> findAll(int idCmd)
    {
        String req = "SELECT* " + " FROM DETALLE_ORDEN WHERE idord = "+idCmd;

        Vector<DetalleOrden> vect = null;

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

                DetalleOrden e = new DetalleOrden(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                

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

 
 
     public Vector<DetalleOrden> findById(int id)
    {
        String req = "SELECT* " + " FROM DETALLE_ORDEN where idord="+id;

        Vector<DetalleOrden> vect = null;

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

                DetalleOrden e = new DetalleOrden(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                

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
