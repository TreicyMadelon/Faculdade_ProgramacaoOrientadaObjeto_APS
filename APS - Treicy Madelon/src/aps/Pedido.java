package aps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido implements CRUD{

    private int numero;
    private String data;
    private double precototal;
    private Cliente cliente;
    private List<DetalhePedido> detalhes;
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPrecototal() {
        return precototal;
        
    }

    public void setPrecototal(double precototal) {
        precototal += precototal;
        this.precototal = precototal;
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalhePedido> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<DetalhePedido> detalhes) {
        this.detalhes = detalhes;
    }
    
    public int NumeroPedido(){
        return numero;
    
    }
    
    @Override
    public void Adicionar() {
        
    }

    @Override
    public void Buscar() {
        
    }

    @Override
    public void Alterar() {
        
    }

    @Override
    public void Eliminar() {
        
    }

    void setNumero(Random random) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
