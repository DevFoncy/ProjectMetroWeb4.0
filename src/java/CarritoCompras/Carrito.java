package CarritoCompras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Walid
 */
import Modelo.DTO.Producto;
import java.util.ArrayList;
import java.util.Collections;

public class Carrito
{

    ArrayList<CompraOnline> lignesPanier;

    public Carrito()
    {
        lignesPanier = new ArrayList<CompraOnline>();
    }

    @Override
    public String toString()
    {
        String s = "Panier : \n";
        for (CompraOnline l : lignesPanier)
        {
            s += l.toString() + "\n";
        }

        return s;

    }

    
    
    public void addProducto(Producto art)
    {
        for (CompraOnline lignePanier : lignesPanier)
        {
            if (lignePanier.getProducto().getIdproducto()== art.getIdproducto())
            {
                lignePanier.setCantidad(lignePanier.getCantidad()+ 1);
                return;
            }
        }

        lignesPanier.add(new CompraOnline(art, 1));
    }

    public void sousProducto(Producto art)
    {
        for (CompraOnline lignePanier : lignesPanier)
        {
            if (lignePanier.getProducto().getIdproducto()== art.getIdproducto())
            {
                if (lignePanier.getCantidad()> 1)
                {
                    lignePanier.setCantidad(lignePanier.getCantidad()- 1);
                } else
                {
                    lignesPanier.remove(lignePanier);
                    return ;
                }
            }
        }


    }

    public int getNumberProducto()
    {
        return lignesPanier.size();
    }

    public ArrayList<CompraOnline> getLignesPanier()
    {
        return lignesPanier;
    }

    public void removeProducto(Producto art)
    {
        for (CompraOnline lignePanier : lignesPanier)
        {
            if (lignePanier.getProducto().getIdproducto()== art.getIdproducto())
            {
                lignesPanier.remove(lignePanier);
                return ;
            }
        }

    }
    
    public void vider()
    {
        try
        {

            while (lignesPanier.get(0) != null)
            {
                lignesPanier.remove(lignesPanier.get(0));
            }

        } catch (Exception e)
        {
        }
               
    }
}
