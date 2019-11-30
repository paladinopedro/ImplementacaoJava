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
public class Locacao {
    private int codigo;
    private String data;
    private String cliente;
    private String cpfcliente;
    private double total;
    private Veiculo v;
    
    public Locacao() {
    
}
    public Locacao(int codigo, String data, String cliente, String cpfcliente, double total){
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.cpfcliente = cpfcliente;
        this.total = total;
       
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Veiculo getV() {
        return v;
    }

    public void setV(Veiculo v) {
        this.v = v;
    }
    
    public static void serializar(ArrayList<Locacao> lista) throws IOException{
        XStream x = new XStream(new DomDriver());
        String arquivosXML = x.toXML(lista);
        File file = new File("Locacao.txt");
        if (!file.exists()){
           file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(arquivosXML);
        bw.close();
    }
        
    public static ArrayList<Locacao> deserealiza() throws FileNotFoundException, IOException{
        FileReader ler = new FileReader("Locacao.txt");
        BufferedReader reader = new BufferedReader(ler);
        String linha = "";
        String arquivo = "";
        while ((linha = reader.readLine())!=null){
            arquivo += linha + "\n";
        }
        ArrayList<Locacao> lista = new ArrayList<>();
        XStream x = new XStream(new DomDriver());
        lista = (ArrayList<Locacao>)x.fromXML(arquivo);
        return lista;
    }      
}
   