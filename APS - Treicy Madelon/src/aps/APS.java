package aps;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class APS {

    static List<Cliente> clientes;
    static List<Produto> produtos;
    static List<Pedido> pedidos;
    
    public static void main(String[] args) throws ParseException {
        int op;
        String resp;
        resp = JOptionPane.showInputDialog("Digite um número para escolher uma opção \n\n 1- Para cadastrar \n 2- Fazer pedido");
        op = Integer.parseInt(resp);  
        if (op == 1){
           MenuCad ent = new MenuCad();  //chamando Jframe
           ent.setVisible(true); 
           
        ent.setLocationRelativeTo(null); //centralizar
           
        
           
        }else if (op == 2){
            
        String textopedido;
        carregarDadosClientes();
        carregarDadosProdutos(); 
        int numeroTmp = 0;
        Random random = new Random();
        Pedido pedido = new Pedido();
        numeroTmp = random.nextInt(5000);
        pedido.setNumero(numeroTmp);

        List<String> listClientes = new ArrayList<String>();
        Iterator itec = clientes.iterator();
        while (itec.hasNext()){
            Cliente c = new Cliente();
            c = (Cliente)itec.next();
            listClientes.add(c.getNome());
        }        
        Object res = JOptionPane.showInputDialog(null, "Escolha um cliente" , "Seleçao de itens" , JOptionPane.PLAIN_MESSAGE , null , listClientes.toArray() ,"");
        String data = JOptionPane.showInputDialog("Digite a data:");
        
        pedido.setData(data);
        
        
        List<String> listProdutos = new ArrayList<String>();
        Iterator ite = produtos.iterator();
        while (ite.hasNext()){
            Produto p = new Produto();
            p = (Produto)ite.next();
            listProdutos.add(p.getDescricao()+" R$ "+p.getPreco());
            
            
        }
        listProdutos.add(""); 
        textopedido = "Número do Pedido: "+pedido.NumeroPedido()+ "\nCliente: "+res.toString()+ "\nData: " +data.toString()+ "\n\nProdutos Selecionados:\n";
        
        List<String> listProdutosSelecionados = new ArrayList<String>();
        List<String> listProdutosSelecionadosquant = new ArrayList<String>();
        
       
        
        String prod=" ";
        
        while (!prod.equals("")){
            Object res2 = JOptionPane.showInputDialog(null, textopedido, "Selecao de itens" , JOptionPane.PLAIN_MESSAGE , null , listProdutos.toArray() ,"");
            prod = res2.toString();  
            
            if (!prod.equals("")){                  
                String quant = JOptionPane.showInputDialog("Digite quantidade:");
                listProdutosSelecionados.add(prod);
                listProdutosSelecionadosquant.add(quant);
                textopedido = textopedido + prod + " Quantidade: "+ quant + "\n" ; 
                
                        }
                   }
        
        
        //Salvar
        
        
        
        Iterator iteCliente = clientes.iterator();
        while (iteCliente.hasNext()){
            Cliente c = new Cliente();
            c = (Cliente)iteCliente.next();
            if ( res.toString().equals(c.getNome())){
                pedido.setCliente(c);
            }            
        }        
        
        Iterator iteProds = produtos.iterator();
        DetalhePedido item = new DetalhePedido();
        List<DetalhePedido> items = new ArrayList<DetalhePedido>();
        
        int i=0;
        String nom;
        for(i=0; i< listProdutosSelecionados.size();i++ ){
            nom = listProdutosSelecionados.get(i).toString();
            while (iteProds.hasNext()){
                Produto p = new Produto();
                p = (Produto)iteProds.next();
                if ( nom.toString().equals(p.getDescricao())){
                    item.setProduto(p);
                    item.setQuantidade(Integer.parseInt(listProdutosSelecionadosquant.get(i)));
                    items.add(item);
                    double preco = item.obterTotal();
                    pedido.setPrecototal(preco);
                                       
                }            
            }         
        }
        pedido.setDetalhes(items);
        
       
        
    }
    }
    static private void carregarDadosClientes(){
        clientes = new ArrayList<Cliente>();       
        Cliente cliente1; 
        PF pessoaf1 = new PF ();
        pessoaf1.setNome("Joao");
        pessoaf1.setCpf("564654");        
        cliente1 = pessoaf1;

        Cliente cliente2; 
        PJ pessoaj1 = new PJ ();
        pessoaj1.setNome("Maria");
        pessoaj1.setCnpj("564654");
        cliente2 = pessoaj1;        
        clientes.add(cliente1);
        clientes.add(cliente2);
    }
    
    static private void carregarDadosProdutos(){
        produtos = new ArrayList<Produto>();
        Produto produto1; 
        Perecivel perecivel1 = new Perecivel ();
        perecivel1.setCodigo("1");
        perecivel1.setDescricao("Iogurt");        
        perecivel1.setValidade("11/11/2017");
        perecivel1.setPreco(10.00);
        produto1 = perecivel1;
       

        Produto produto2; 
        Perecivel perecivel2 = new Perecivel ();
        perecivel2.setCodigo("2");
        perecivel2.setDescricao("Carne");        
        perecivel2.setValidade("01/10/2017"); 
        perecivel2.setPreco(25.00);
        produto2 = perecivel2;
        
        Produto produto3; 
        Naoperecivel naoperecivel1 = new Naoperecivel ();
        naoperecivel1.setCodigo("3");
        naoperecivel1.setDescricao("Sal");        
        naoperecivel1.setTipo("Temperos");
        naoperecivel1.setPreco(5.00);
        produto3 = naoperecivel1;

        Produto produto4; 
        Naoperecivel naoperecivel2 = new Naoperecivel ();
        naoperecivel2.setCodigo("4");
        naoperecivel2.setDescricao("Chia");
        naoperecivel2.setTipo("Cereal");
        naoperecivel2.setPreco(5.00);
        produto4 = naoperecivel2;
        
        produtos.add(produto1);
        produtos.add(produto2);    
        produtos.add(produto3);
        produtos.add(produto4);
    }

   
    
    
    
}
