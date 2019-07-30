package aps;

public class DetalhePedido extends Produto {
    private Produto produto;
    private int quantidade;
    private double precounitario;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

   public double obterPrecoUnitario(){
   double p = this.getPreco();
   return p;
}
   public double obterTotal(){
   return this.obterPrecoUnitario() * this.getQuantidade(); 
       
       
   }
    
}
