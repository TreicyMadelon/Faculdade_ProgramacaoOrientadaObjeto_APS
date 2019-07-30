package aps;

import javax.swing.JTextField;

public class Produto implements CRUD {
    private String codigo;
    private String descricao;
    private double preco;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    void setCodigo(JTextField codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDescricao(JTextField descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
