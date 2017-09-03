/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Singleton.DBConnexion;
import Modelo.DTO.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Junior Alvarez
 */
public class ProductoDAO
{

    Connection con = DBConnexion.getInstance();

    public boolean add(Producto a)
    {
        try
        {
            String req = "INSERT INTO PRODUCTOS(`idproducto`, `nombre`, `descripcion`, `precio`, `imagen`, `cantidad`)"
                    + " VALUES (NULL , '" + a.getNombre()+ "', '" + a.getDescripcion()+ "', '" + a.getPrecio()+ "', '" + a.getImagen()+ "', '" + a.getCantidad()+ "');";

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

    public boolean remove(int idProducto)
    {
        try
        {
            String req = "DELETE FROM PRODUCTOS " + "WHERE idproducto = " + idProducto;

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

    public boolean update(Producto a)
    {
        try
        {
            String req = "UPDATE `dbmetro`.`productos` "
                    + "SET `nombre`='" + a.getNombre()+ "', "
                    + "`descripcion`='" + a.getDescripcion()+ "', "
                    + "`precio`='" + a.getPrecio()+ "', "
                    + "`imagen`='" + a.getImagen()+ "', "
                    + "`cantidad`='" + a.getCantidad()+ "' "
                    + "WHERE `idproducto`='" + a.getIdproducto()+ "';";

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

    public Producto findByID(int id)
    {
        String req = "SELECT* " + " FROM PRODUCTOS " + " WHERE IDPRODUCTO = " + id;

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            Producto e = null;

            if (rs.next())
            {
                e = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getInt(6),
                        rs.getDate(7));
            }
            return e;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public Vector<Producto> findAll()
    {
        String req = "SELECT* " + " FROM PRODUCTOS ";

        Vector<Producto> vect = null;

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

                Producto e = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getInt(6),
                        rs.getDate(7));

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

    
    public Vector<Producto> findAll(String key)
    {
        String req = "SELECT* " + " FROM PRODUCTOS WHERE NOMBRE like '%"+key+"%'";

        Vector<Producto> vect = null;

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

                Producto e = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getInt(6),
                        rs.getDate(7));

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

     public Vector<Producto> findRandom(int numMax)
    {
        String req = "SELECT* " + " FROM PRODUCTOS ORDER BY RAND() LIMIT " + numMax;

        Vector<Producto> vect = null;

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

                Producto e = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getString(5), rs.getInt(6),
                        rs.getDate(7));

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
