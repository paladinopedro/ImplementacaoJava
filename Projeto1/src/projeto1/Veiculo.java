/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author pedro
 */
public class Veiculo {
   private String placa;
   private int ano;
   private String cliente;
   private String marca;
   private String modelo;
   ArrayList<Locacao>ListaLocacao;
   
   public Veiculo(){
       ListaLocacao = new ArrayList();
   }
   
   public Veiculo(String placa, int ano, String cliente, String marca, String modelo){
       this.placa = placa;
       this.ano = ano;
       this.cliente = cliente;
       this.marca = marca;
       this.modelo = modelo;
       ListaLocacao = new ArrayList();
   }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ArrayList<Locacao> getListaLocacao() {
        return ListaLocacao;
    }

    public void setListaLocacao(ArrayList<Locacao> ListaLocacao) {
        this.ListaLocacao = ListaLocacao;
    }
   public void  addLocacao(Locacao L){
       L.setV(this);
       ListaLocacao.add(L);
   }
   
   public static void serializar(ArrayList<Veiculo> lista) throws IOException{
       XStream x = new XStream (new DomDriver());
       String arquivoXML = x.toXML(lista);
       File file = new File("Veiculo.txt");
       if(!file.exists()){
           file.createNewFile();
   }
       FileWriter fw = new FileWriter(file.getAbsoluteFile());
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write(arquivoXML);
       bw.close();
   }
   
   public static ArrayList<Veiculo> desrealiza() throws FileNotFoundException, IOException{
       FileReader ler = new FileReader("Veiculo.txt");
       BufferedReader reader = new BufferedReader(ler);
       String linha ="";
       String arquivo = "";
       while((linha = reader.readLine())!= null){
           arquivo += linha + "\n";
           
   }
       ArrayList<Veiculo> lista = new ArrayList<>();
       XStream x = new XStream(new DomDriver());
       lista = (ArrayList<Veiculo>) x.fromXML(arquivo);
       return lista;
   }
}
        

   

