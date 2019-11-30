/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class Principal extends javax.swing.JFrame {
    ArrayList<Veiculo> ListaVeiculo;
    ArrayList<Locacao> ListaLocacao;
    String modo;
    String modoLoc;
    
    
    public void LoadTableVei(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Placa", "Ano", "Cliente", "Marca", "Modelo"},0);
        for(int i=0;i<ListaVeiculo.size();i++){
            Object linha [] = new Object[]{ListaVeiculo.get(i).getPlaca(),
                                           ListaVeiculo.get(i).getAno(),
                                           ListaVeiculo.get(i).getCliente(),
                                           ListaVeiculo.get(i).getMarca(),
                                           ListaVeiculo.get(i).getModelo()};
            modelo.addRow(linha);
        }
        tbl_veiculos.setModel(modelo);
        tbl_veiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_veiculos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbl_veiculos.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbl_veiculos.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbl_veiculos.getColumnModel().getColumn(4).setPreferredWidth(50);
        LoadCBVei();
    }
    
    public void LoadTableLoc(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código", "Data", "Cliente", "CPF", "Total", "Veículo"},0);
        for(int i=0;i<ListaLocacao.size();i++){
            Object linha [] = new Object[]{ListaLocacao.get(i).getCodigo(),
                                           ListaLocacao.get(i).getData(),
                                           ListaLocacao.get(i).getCliente(),
                                           ListaLocacao.get(i).getCpfcliente(),
                                           ListaLocacao.get(i).getTotal(),
                                           ListaLocacao.get(i).getV().getModelo()};
            modelo.addRow(linha);
        }
        tbl_locacao.setModel(modelo);
        tbl_locacao.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_locacao.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl_locacao.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl_locacao.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl_locacao.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl_locacao.getColumnModel().getColumn(5).setPreferredWidth(100);
        LoadCBVei();
    }
    
     public void LoadCBVei(){
        cb_loc_veiculo.removeAllItems();
        cb_loc_veiculo.addItem("Selecione a Placa do Veículo");
        for(int i=0;i<ListaVeiculo.size();i++){
            cb_loc_veiculo.addItem(ListaVeiculo.get(i).getPlaca());
        }
        
    }
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaVeiculo = new ArrayList();
        ListaLocacao = new ArrayList();
        modo = "Navegar";
        modoLoc = "Navegar";
        
        try{
            ListaVeiculo = Veiculo.desrealiza();
            ListaLocacao = Locacao.deserealiza();
        } catch(IOException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ManipulaInterface();
        ManipulaInterfaceLoc();
        
        LoadTableVei();
        LoadTableLoc();
        
    }

    
    public void ManipulaInterface(){
        switch(modo){
            case "Navegar":
                btn_vei_salvar.setEnabled(false);
                btn_vei_cancelar.setEnabled(false);
                c_vei_placa.setEnabled(false);
                c_vei_ano.setEnabled(false);
                c_vei_cliente.setEnabled(false);
                c_vei_marca.setEnabled(false);
                c_vei_modelo.setEnabled(false);
                btn_vei_novo.setEnabled(true);
                btn_vei_editar.setEnabled(false);
                btn_vei_excluir.setEnabled(false);
                break;
            case "Novo":
                btn_vei_salvar.setEnabled(true);
                btn_vei_cancelar.setEnabled(true);
                c_vei_placa.setEnabled(true);
                c_vei_ano.setEnabled(true);
                c_vei_cliente.setEnabled(true);
                c_vei_marca.setEnabled(true);
                c_vei_modelo.setEnabled(true);
                btn_vei_novo.setEnabled(false);
                btn_vei_editar.setEnabled(false);
                btn_vei_excluir.setEnabled(false);
                break;
            case "Editar":
                btn_vei_salvar.setEnabled(true);
                btn_vei_cancelar.setEnabled(true);
                c_vei_placa.setEnabled(true);
                c_vei_ano.setEnabled(true);
                c_vei_cliente.setEnabled(true);
                c_vei_marca.setEnabled(true);
                c_vei_modelo.setEnabled(true);
                btn_vei_novo.setEnabled(false);
                btn_vei_editar.setEnabled(false);
                btn_vei_excluir.setEnabled(false);
                break;
            case "Excluir":
                btn_vei_salvar.setEnabled(false);
                btn_vei_cancelar.setEnabled(false);
                c_vei_placa.setEnabled(false);
                c_vei_ano.setEnabled(false);
                c_vei_cliente.setEnabled(false);
                c_vei_marca.setEnabled(false);
                c_vei_modelo.setEnabled(false);
                btn_vei_novo.setEnabled(true);
                btn_vei_editar.setEnabled(false);
                btn_vei_excluir.setEnabled(false);
                break;
            case "Selecao":
                btn_vei_salvar.setEnabled(false);
                btn_vei_cancelar.setEnabled(false);
                c_vei_placa.setEnabled(false);
                c_vei_ano.setEnabled(false);
                c_vei_cliente.setEnabled(false);
                c_vei_marca.setEnabled(false);
                c_vei_modelo.setEnabled(false);
                btn_vei_novo.setEnabled(true);
                btn_vei_editar.setEnabled(true);
                btn_vei_excluir.setEnabled(true);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    public void ManipulaInterfaceLoc(){
        switch(modoLoc){
            case "Navegar":
                btn_loc_salvar.setEnabled(false);
                btn_loc_cancela.setEnabled(false);
                c_loc_cod.setEnabled(false);
                c_loc_data.setEnabled(false);
                c_loc_cliente.setEnabled(false);
                c_loc_cpf.setEnabled(false);
                c_loc_total.setEnabled(false);
                btn_loc_novo.setEnabled(true);
                btn_loc_editar.setEnabled(false);
                btn_loc_excluir.setEnabled(false);
                cb_loc_veiculo.setEnabled(false);
                break;
            case "Novo":
                btn_loc_salvar.setEnabled(true);
                btn_loc_cancela.setEnabled(true);
                c_loc_cod.setEnabled(true);
                c_loc_data.setEnabled(true);
                c_loc_cliente.setEnabled(true);
                c_loc_cpf.setEnabled(true);
                c_loc_total.setEnabled(true);
                btn_loc_novo.setEnabled(false);
                btn_loc_editar.setEnabled(false);
                btn_loc_excluir.setEnabled(false);
                cb_loc_veiculo.setEnabled(true);
                break;
            case "Editar":
                btn_loc_salvar.setEnabled(true);
                btn_loc_cancela.setEnabled(true);
                c_loc_cod.setEnabled(false);
                c_loc_data.setEnabled(true);
                c_loc_cliente.setEnabled(true);
                c_loc_cpf.setEnabled(true);
                c_loc_total.setEnabled(true);
                btn_loc_novo.setEnabled(false);
                btn_loc_editar.setEnabled(false);
                btn_loc_excluir.setEnabled(false);
                cb_loc_veiculo.setEnabled(true);
                break;
            case "Excluir":
                btn_loc_salvar.setEnabled(false);
                btn_loc_cancela.setEnabled(false);
                c_loc_cod.setEnabled(false);
                c_loc_data.setEnabled(false);
                c_loc_cliente.setEnabled(false);
                c_loc_cpf.setEnabled(false);
                c_loc_total.setEnabled(false);
                btn_loc_novo.setEnabled(true);
                btn_loc_editar.setEnabled(false);
                btn_loc_excluir.setEnabled(false);
                cb_loc_veiculo.setEnabled(false);
                break;
            case "Selecao":
                btn_loc_salvar.setEnabled(false);
                btn_loc_cancela.setEnabled(false);
                c_loc_cod.setEnabled(false);
                c_loc_data.setEnabled(false);
                c_loc_cliente.setEnabled(false);
                c_loc_cpf.setEnabled(false);
                c_loc_total.setEnabled(false);
                btn_loc_novo.setEnabled(true);
                btn_loc_editar.setEnabled(true);
                btn_loc_excluir.setEnabled(true);
                cb_loc_veiculo.setEnabled(false);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_veiculos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        c_vei_placa = new javax.swing.JTextField();
        c_vei_cliente = new javax.swing.JTextField();
        c_vei_marca = new javax.swing.JTextField();
        c_vei_modelo = new javax.swing.JTextField();
        c_vei_ano = new javax.swing.JTextField();
        btn_vei_salvar = new javax.swing.JButton();
        btn_vei_cancelar = new javax.swing.JButton();
        btn_vei_novo = new javax.swing.JButton();
        btn_vei_editar = new javax.swing.JButton();
        btn_vei_excluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_locacao = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        c_loc_cod = new javax.swing.JTextField();
        c_loc_cliente = new javax.swing.JTextField();
        c_loc_cpf = new javax.swing.JTextField();
        c_loc_total = new javax.swing.JTextField();
        c_loc_data = new javax.swing.JTextField();
        btn_loc_salvar = new javax.swing.JButton();
        btn_loc_cancela = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb_loc_veiculo = new javax.swing.JComboBox<>();
        btn_loc_novo = new javax.swing.JButton();
        btn_loc_editar = new javax.swing.JButton();
        btn_loc_excluir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_veiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Ano", "Cliente", "Marca", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_veiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_veiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_veiculos);
        if (tbl_veiculos.getColumnModel().getColumnCount() > 0) {
            tbl_veiculos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_veiculos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_veiculos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl_veiculos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl_veiculos.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Veiculos"));

        jLabel1.setText("Placa");

        jLabel2.setText("Ano");

        jLabel3.setText("Cliente");

        jLabel4.setText("Marca");

        jLabel5.setText("Modelo");

        c_vei_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vei_placaActionPerformed(evt);
            }
        });

        c_vei_ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vei_anoActionPerformed(evt);
            }
        });

        btn_vei_salvar.setText("Salvar");
        btn_vei_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vei_salvarActionPerformed(evt);
            }
        });

        btn_vei_cancelar.setText("Cancelar");
        btn_vei_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vei_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(c_vei_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(c_vei_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c_vei_ano, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_vei_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(c_vei_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_vei_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_vei_cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_vei_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_vei_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_vei_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_vei_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(c_vei_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vei_salvar)
                    .addComponent(btn_vei_cancelar))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        btn_vei_novo.setText("Novo");
        btn_vei_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vei_novoActionPerformed(evt);
            }
        });

        btn_vei_editar.setText("Editar");
        btn_vei_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vei_editarActionPerformed(evt);
            }
        });

        btn_vei_excluir.setText("Excluir");
        btn_vei_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vei_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_vei_novo)
                .addGap(84, 84, 84)
                .addComponent(btn_vei_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btn_vei_excluir)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vei_novo)
                    .addComponent(btn_vei_editar)
                    .addComponent(btn_vei_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Veiculos", jPanel1);

        tbl_locacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Data", "Cliente", "Cpf Cliente", "Total", "Veiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_locacaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_locacao);
        if (tbl_locacao.getColumnModel().getColumnCount() > 0) {
            tbl_locacao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_locacao.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_locacao.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl_locacao.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_locacao.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl_locacao.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Veiculos"));

        jLabel6.setText("Codigo");

        jLabel7.setText("Data");

        jLabel8.setText("Cliente");

        jLabel9.setText("CPF");

        jLabel10.setText("Total");

        c_loc_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_loc_codActionPerformed(evt);
            }
        });

        btn_loc_salvar.setText("Salvar");
        btn_loc_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loc_salvarActionPerformed(evt);
            }
        });

        btn_loc_cancela.setText("Cancelar");
        btn_loc_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loc_cancelaActionPerformed(evt);
            }
        });

        jLabel11.setText("Veículo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_loc_salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_loc_cancela))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_loc_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(c_loc_data, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(c_loc_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_loc_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_loc_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_loc_total, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(c_loc_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(c_loc_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(c_loc_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(c_loc_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(c_loc_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_loc_veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_loc_cancela)
                    .addComponent(btn_loc_salvar))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        btn_loc_novo.setText("Novo");
        btn_loc_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loc_novoActionPerformed(evt);
            }
        });

        btn_loc_editar.setText("Editar");
        btn_loc_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loc_editarActionPerformed(evt);
            }
        });

        btn_loc_excluir.setText("Excluir");
        btn_loc_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loc_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_loc_novo)
                .addGap(84, 84, 84)
                .addComponent(btn_loc_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btn_loc_excluir)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loc_novo)
                    .addComponent(btn_loc_editar)
                    .addComponent(btn_loc_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Locação", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_vei_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vei_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_vei_placaActionPerformed

    private void btn_vei_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vei_salvarActionPerformed
        int ano = Integer.parseInt(c_vei_ano.getText());
        if(modo.equals("Novo")){
            Veiculo V = new Veiculo(c_vei_placa.getText(),
                                ano,
                                c_vei_cliente.getText(),
                                c_vei_marca.getText(),
                                c_vei_modelo.getText());
            ListaVeiculo.add(V);
        }else if(modo.equals("Editar")){
            int index = tbl_veiculos.getSelectedRow();
            ListaVeiculo.get(index).setPlaca(c_vei_placa.getText());
            ListaVeiculo.get(index).setAno(ano);
            ListaVeiculo.get(index).setCliente(c_vei_cliente.getText());
            ListaVeiculo.get(index).setMarca(c_vei_marca.getText());
            ListaVeiculo.get(index).setModelo(c_vei_modelo.getText());
        }
        try{
            Veiculo.serializar(ListaVeiculo);
        }catch(Exception ex){   
        }
        LoadTableVei();
        modo = "Navegar";
        ManipulaInterface();
        c_vei_placa.setText("");
        c_vei_ano.setText("");
        c_vei_cliente.setText("");
        c_vei_marca.setText("");
        c_vei_modelo.setText("");
    }//GEN-LAST:event_btn_vei_salvarActionPerformed

    private void btn_vei_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vei_editarActionPerformed
        modo = "Editar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vei_editarActionPerformed

    private void btn_vei_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vei_cancelarActionPerformed
        c_vei_placa.setText("");
        c_vei_ano.setText("");
        c_vei_cliente.setText("");
        c_vei_marca.setText("");
        c_vei_modelo.setText("");
        modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vei_cancelarActionPerformed

    private void btn_vei_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vei_novoActionPerformed
        c_vei_placa.setText("");
        c_vei_ano.setText("");
        c_vei_cliente.setText("");
        c_vei_marca.setText("");
        c_vei_modelo.setText("");
        
        modo = "Novo";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vei_novoActionPerformed

    private void tbl_veiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_veiculosMouseClicked
        int index = tbl_veiculos.getSelectedRow();
        if(index >=0 && index <ListaVeiculo.size()){
          Veiculo V = ListaVeiculo.get(index);
          c_vei_placa.setText(V.getPlaca());
          c_vei_ano.setText(String.valueOf(V.getAno()));
          c_vei_cliente.setText(V.getCliente());
          c_vei_marca.setText(V.getMarca());
          c_vei_modelo.setText(V.getModelo());
          modo = "Selecao";
          ManipulaInterface();  
        }
        
    }//GEN-LAST:event_tbl_veiculosMouseClicked

    private void tbl_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_locacaoMouseClicked
        int index = tbl_locacao.getSelectedRow();
        if(index >=0 && index <ListaLocacao.size()){
          Locacao L = ListaLocacao.get(index);
          c_loc_cod.setText(String.valueOf(L.getCodigo()));
          c_loc_data.setText(L.getData());
          c_loc_cliente.setText(L.getCliente());
          c_loc_cpf.setText(L.getCpfcliente());
          c_loc_total.setText(String.valueOf(L.getTotal()));
          modoLoc = "Selecao";
          ManipulaInterfaceLoc();  
        }
    }//GEN-LAST:event_tbl_locacaoMouseClicked

    private void c_loc_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_loc_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_loc_codActionPerformed

    private void btn_loc_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loc_salvarActionPerformed

                
        if(modoLoc.equals("Novo")){
        int index = cb_loc_veiculo.getSelectedIndex();
        if( index == 0){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um Veículo");
        }else{
            Locacao L = new Locacao();
            L.setCodigo(Integer.parseInt(c_loc_cod.getText()));
            L.setData(c_loc_data.getText());
            L.setCliente(c_loc_cliente.getText());
            L.setCpfcliente(c_loc_cpf.getText());
            L.setTotal(Double.parseDouble(c_loc_total.getText()));
            L.setV(ListaVeiculo.get(index-1));
            ListaLocacao.add(L);
            ListaVeiculo.get(index-1).addLocacao(L);
        }
        }else if(modoLoc.equals("Editar")){
        int index = cb_loc_veiculo.getSelectedIndex();
        if( index == 0){
            JOptionPane.showMessageDialog(this, "Você deve selecionar um Veículo");
        }else{
            int indexTable = tbl_locacao.getSelectedRow();
            Locacao L = new Locacao();
            L.setCodigo(Integer.parseInt(c_loc_cod.getText()));
            L.setData(c_loc_data.getText());
            L.setCliente(c_loc_cliente.getText());
            L.setCpfcliente(c_loc_cpf.getText());
            L.setTotal(Double.parseDouble(c_loc_total.getText()));
            L.setV(ListaVeiculo.get(index-1));
            ListaLocacao.set(indexTable, L);
            ListaVeiculo.get(index-1).addLocacao(L);
            try{
                Locacao.serializar(ListaLocacao);
            }catch(Exception ex){
            }  
        }
        }
        try{
            Locacao.serializar(ListaLocacao);
        }catch(Exception ex){   
        }
        LoadTableLoc();
        modoLoc = "Navegar";
        ManipulaInterfaceLoc();
    }//GEN-LAST:event_btn_loc_salvarActionPerformed

    private void btn_loc_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loc_cancelaActionPerformed
        c_loc_cod.setText("");
        c_loc_data.setText("");
        c_loc_cliente.setText("");
        c_loc_cpf.setText("");
        c_loc_total.setText("");
        modoLoc = "Navegar";
        ManipulaInterfaceLoc();
    }//GEN-LAST:event_btn_loc_cancelaActionPerformed

    private void btn_loc_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loc_novoActionPerformed
        c_loc_cod.setText("");
        c_loc_data.setText("");
        c_loc_cliente.setText("");
        c_loc_cpf.setText("");
        c_loc_total.setText("");

        modoLoc = "Novo";
        ManipulaInterfaceLoc();
    }//GEN-LAST:event_btn_loc_novoActionPerformed

    private void btn_loc_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loc_editarActionPerformed
        modoLoc = "Editar";
        ManipulaInterfaceLoc();
    }//GEN-LAST:event_btn_loc_editarActionPerformed

    private void btn_loc_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loc_excluirActionPerformed
        int index = tbl_locacao.getSelectedRow();
        if(index >=0 && index<ListaLocacao.size()){
            ListaLocacao.remove(index);
            try {
                Locacao.serializar(ListaLocacao);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        LoadTableLoc();
        c_loc_cod.setText("");
        c_loc_data.setText("");
        c_loc_cliente.setText("");
        c_loc_cpf.setText("");
        c_loc_total.setText("");
        
        modoLoc = "Navegar";
        ManipulaInterfaceLoc();
    }//GEN-LAST:event_btn_loc_excluirActionPerformed

    private void btn_vei_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vei_excluirActionPerformed
        int index = tbl_veiculos.getSelectedRow();
        if(index >=0 && index<ListaVeiculo.size()){
            ListaVeiculo.remove(index);
            try {
                Veiculo.serializar(ListaVeiculo);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        LoadTableVei();
        modo = "Navegar";
        ManipulaInterface();
    }//GEN-LAST:event_btn_vei_excluirActionPerformed

    private void c_vei_anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vei_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_vei_anoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loc_cancela;
    private javax.swing.JButton btn_loc_editar;
    private javax.swing.JButton btn_loc_excluir;
    private javax.swing.JButton btn_loc_novo;
    private javax.swing.JButton btn_loc_salvar;
    private javax.swing.JButton btn_vei_cancelar;
    private javax.swing.JButton btn_vei_editar;
    private javax.swing.JButton btn_vei_excluir;
    private javax.swing.JButton btn_vei_novo;
    private javax.swing.JButton btn_vei_salvar;
    private javax.swing.JTextField c_loc_cliente;
    private javax.swing.JTextField c_loc_cod;
    private javax.swing.JTextField c_loc_cpf;
    private javax.swing.JTextField c_loc_data;
    private javax.swing.JTextField c_loc_total;
    private javax.swing.JTextField c_vei_ano;
    private javax.swing.JTextField c_vei_cliente;
    private javax.swing.JTextField c_vei_marca;
    private javax.swing.JTextField c_vei_modelo;
    private javax.swing.JTextField c_vei_placa;
    private javax.swing.JComboBox<String> cb_loc_veiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_locacao;
    private javax.swing.JTable tbl_veiculos;
    // End of variables declaration//GEN-END:variables
}
