package CarritoCompras;


import Modelo.DTO.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior Alvarez
 */

public class CompraOnline
{

        private Producto producto;
        private int cantidad;

        public CompraOnline(Producto art, int qte) 
        {    
                this.producto = art;
                this.cantidad = qte;
        }

        public Producto getProducto() {
                return producto;
        }

        public void setProducto(Producto article) {
                this.producto = article;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setCantidad(int cantidad) {
                this.cantidad = cantidad;
        }

        @Override
        public boolean equals(Object arg0) 
        {
                if(arg0 instanceof CompraOnline){
                        if(this.producto.equals(((CompraOnline) arg0).producto) && this.cantidad ==((CompraOnline) arg0).cantidad)
                                return true;
                        else
                                return false;
                }else
                        return false;
        }

        @Override
        public int hashCode() 
        {
                return producto.hashCode();
        }

        @Override
        public String toString() {
                return "LigneCommande : "+producto.toString()+" | "+this.cantidad;
        }

}

