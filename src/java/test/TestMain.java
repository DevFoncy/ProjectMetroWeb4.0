/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import Modelo.DAO.ProductoDAO;
import Modelo.DAO.ClienteDAO;
import Modelo.DTO.Cliente;

/**
 *
 * @author Walid
 */
public class TestMain 
{
    public static void main(String[] args) 
    {
        ProductoDAO dao = new ProductoDAO();
        ClienteDAO daoC = new ClienteDAO();
        
        for (Cliente client : daoC.findAll())
        {
            System.out.println(client);
        }
        
        System.out.println(dao.findByID(1));
        
        System.out.println("#END#");
    }
}
