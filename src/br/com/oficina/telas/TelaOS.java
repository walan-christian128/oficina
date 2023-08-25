package br.com.oficina.telas;

import br.com.oficina.DAO.ClientesDAO;
import br.com.oficina.DAO.ModeloDAO;
import br.com.oficina.DAO.OSDAO;
import br.com.oficina.DAO.ProdutosDAO;
import br.com.oficina.DAO.itenOSDAO;
import br.com.oficina.model.Clientes;
import br.com.oficina.model.Modelo;
import br.com.oficina.model.OS;
import br.com.oficina.model.Produtos;
import br.com.oficina.model.intesOS;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walan
 */
public class TelaOS extends javax.swing.JFrame {

    private String tipo;

    DefaultTableModel addOSpecas;

    public TelaOS() {
        initComponents();

        getContentPane().setBackground(new Color(255, 255, 255));
        setIconImage(
                Toolkit.getDefaultToolkit().getImage(TelaOS.class.getResource("/br/com/oficina/icon/3605320_maintenance_mechanic_repair_spanner_support_icon.png")));
        setTitle("telaOS");
        this.setLocationRelativeTo(null);

    }

    public void listar() {
        ClientesDAO dao = new ClientesDAO();
        List<Clientes> list = dao.listaClientes();
        DefaultTableModel dados = (DefaultTableModel) tabelcliOS.getModel();
        dados.setNumRows(0);
        for (Clientes c : list) {
            dados.addRow(new Object[]{
                c.getIdcli(),
                c.getNomecli(),
                c.getEndereco(),
                c.getFonecli(),
                c.getEmailcli()

            });

        }

    }

    public void listaProdutos() {
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.pesquisarProdutos();
        DefaultTableModel dados = (DefaultTableModel) tbProduOs.getModel();
        dados.setNumRows(0);
        for (Produtos p : lista) {
            dados.addRow(new Object[]{
                p.getIdprod(),
                p.getDescricaoprod(),
                p.getPreco(),
                p.getQtd()

            });
        }

    }

    private void addItensOs() {
        DefaultTableModel tbProduOsModel = (DefaultTableModel) tbProduOs.getModel();
        DefaultTableModel tblOSModel = (DefaultTableModel) tblOS.getModel();

        int selectedRow = tbProduOs.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        // Pega os dados da linha selecionada na tabela tbProduOs
        Object[] rowData = new Object[tblOSModel.getColumnCount()]; // Ajuste isso para o número de colunas na tblOS
        for (int i = 0; i < tblOSModel.getColumnCount() - 1; i++) {
            rowData[i] = tbProduOsModel.getValueAt(selectedRow, i);
        }

        // Solicita ao usuário que digite o número do modelo
        String codigo = JOptionPane.showInputDialog("DIGITE A QUANTIDADE DE PEÇAS QUE VAI SER UTILIZADAS");

        // Adiciona o valor digitado como a última coluna
        rowData[tblOSModel.getColumnCount() - 1] = codigo;

        // Adiciona os dados à tabela tblOS
        tblOSModel.addRow(rowData);

    }

    private void removeSelectedRow() {
        DefaultTableModel tbProduOsModel = (DefaultTableModel) tblOS.getModel();

        int selectedRow = tblOS.getSelectedRow();
        int resposta = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA REMOVER O ITEM DA LISTA?", "EXCLUSÃO", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            if (selectedRow == -1) {
                return;
            }

        }// Remove a linha selecionada da tabela tbProduOs
        tbProduOsModel.removeRow(selectedRow);

    }

    private void limparTabelaCampos() {
        ((DefaultTableModel) tblOS.getModel()).setRowCount(0);
        txtDataOs.setText(null);
        txtDataOs.setText(null);
        txtcliid.setText(null);
        TXTNUMEROOS1.setText(null);
        txtTecnico.setText(null);
        cmbMod.setSelectedItem(null);
        txtdesCliente.setText(null);
        txtservexc.setText(null);
        txtValor.setText(null);

    }

    public void retornaClienteOS() {
        OSDAO dao = new OSDAO();

    }

     private void pesquisarOD() {
        String isOs = JOptionPane.showInputDialog("DIGITE O NUMERO NA ORDEM");
        OS os = new OS();
        OSDAO dao = new OSDAO();
        os = dao.pesquisaOS(isOs);

        if (os != null) {
            TXTNUMEROOS1.setText(String.valueOf(os.getId()));
            txtDataOs.setText(os.getData());
            cmbStatus.setSelectedItem(os.getStatus());

            Modelo mod = new Modelo();
            ModeloDAO daoMod = new ModeloDAO();

            mod = daoMod.pesquisarModeloo(os.getModelo().getDescricacao());

            cmbMod.getModel().setSelectedItem(mod);

            txtTecnico.setText(os.getTecnico());
            txtdesCliente.setText(os.getDescricao_cliente());
            txtservexc.setText(os.getServico_executado());
            txtValor.setText(String.valueOf(os.getValor()));
            txtcliid.setText(String.valueOf(os.getCliente().getIdcli()));

            if ("Orçamento".equals(os.getTipo())) {
                rborcamento.setSelected(true);
            } else if ("Autorizada".equals(os.getTipo())) {
                rbautorizada.setSelected(true);
            }
            intesOS i = new intesOS();
            if (i != null) {
                List<Produtos> lista = dao.retornaProdutosOS(isOs);

                if (lista != null) {
                    DefaultTableModel dados = (DefaultTableModel) tblOS.getModel();
                    dados.setNumRows(0);

                    for (Produtos p : lista) {
                        dados.addRow(new Object[]{
                            p.getIdprod(),
                            p.getDescricaoprod(),
                            p.getPreco(),
                            i.getQtd_os()
                        });
                    }
                }

            }

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXTNUMEROOS1 = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        txtclios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelcliOS = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtcliid = new javax.swing.JTextField();
        rborcamento = new javax.swing.JRadioButton();
        rbautorizada = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtDataOs = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbMod = new javax.swing.JComboBox();
        txtdesCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtservexc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOS = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProduOs = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnRemo1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAdd2 = new javax.swing.JButton();
        btnRemo2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ORDEM");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("ORDEM"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("N°");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Tipo:");

        TXTNUMEROOS1.setEditable(false);
        TXTNUMEROOS1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TXTNUMEROOS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTNUMEROOS1ActionPerformed(evt);
            }
        });

        cmbStatus.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "REALIZADO", "AGUARDADO ANALÍSE", "AGUARDANDO PAGAMENTO", "AGUARDANDO PEÇA", "AUTORIZADO", "NÃO AUTORIZADO " }));

        tabelcliOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOME", "ENDEREÇO", "FONE", "E-MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelcliOS.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelcliOSAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelcliOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelcliOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelcliOS);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Cliente:");

        txtcliid.setEditable(false);
        txtcliid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout txtcliosLayout = new javax.swing.GroupLayout(txtclios);
        txtclios.setLayout(txtcliosLayout);
        txtcliosLayout.setHorizontalGroup(
            txtcliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtcliosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtcliid, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtcliosLayout.setVerticalGroup(
            txtcliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtcliosLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(txtcliosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(txtcliosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcliid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(rborcamento);
        rborcamento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rborcamento.setText("Orçamento");
        rborcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rborcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbautorizada);
        rbautorizada.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rbautorizada.setText("Autorizada");
        rbautorizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbautorizadaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Data:");

        txtDataOs.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Modelo:");

        txtTecnico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Tecnico/Mecanico");

        cmbMod.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbMod.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmbModAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cmbMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModActionPerformed(evt);
            }
        });

        txtdesCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Descrição do cliente:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Serviço executado/ou a ser executado: ");

        txtValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Valor:");

        txtservexc.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Pecas a serem utilizadas:");

        tblOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Preço", "QTD"
            }
        ));
        tblOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblOS);

        tbProduOs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Preço", "QTD"
            }
        ));
        tbProduOs.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbProduOsAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbProduOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProduOsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProduOs);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Pecas em estoque:");

        btnRemo1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnRemo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/delete.png"))); // NOI18N
        btnRemo1.setToolTipText("Remover");
        btnRemo1.setBorder(null);
        btnRemo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnRemo1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemo1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnAdd.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/update.png"))); // NOI18N
        btnAdd.setToolTipText("Atualizar");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnRemo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/read.png"))); // NOI18N
        btnRemo.setToolTipText("Pesquisar");
        btnRemo.setBorder(null);
        btnRemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/ok.png"))); // NOI18N
        btnSalvar.setToolTipText("Confirma");
        btnSalvar.setBorder(null);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAdd2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/add.png"))); // NOI18N
        btnAdd2.setToolTipText("Nova ");
        btnAdd2.setBorder(null);
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        btnRemo2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnRemo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/oficina/icon/delete.png"))); // NOI18N
        btnRemo2.setToolTipText("Remover");
        btnRemo2.setBorder(null);
        btnRemo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnRemo2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTecnico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmbMod, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtservexc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnAdd2, btnRemo, btnRemo2, btnSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbMod))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtservexc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemo2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnAdd2, btnRemo, btnRemo2, btnSalvar});

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("SITUAÇÃO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTNUMEROOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDataOs, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rborcamento)
                                .addGap(18, 18, 18)
                                .addComponent(rbautorizada)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtclios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(520, 520, 520))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTNUMEROOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rborcamento)
                            .addComponent(rbautorizada)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtclios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXTNUMEROOS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTNUMEROOS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTNUMEROOS1ActionPerformed

    private void tabelcliOSAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelcliOSAncestorAdded
        listar();
    }//GEN-LAST:event_tabelcliOSAncestorAdded

    private void btnRemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoActionPerformed
        pesquisarOD();

    }//GEN-LAST:event_btnRemoActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemo1ActionPerformed
        removeSelectedRow();
    }//GEN-LAST:event_btnRemo1ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            OS os = new OS();

            // Validando campos obrigatórios
            if (cmbStatus.getSelectedItem() == null || txtTecnico.getText().isEmpty()
                    || cmbMod.getSelectedItem() == null || txtdesCliente.getText().isEmpty()
                    || txtservexc.getText().isEmpty() || txtValor.getText().isEmpty()
                    || txtcliid.getText().isEmpty() || tipo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS DADOS OBRIGATORIOS.");
                return; // Sai do método caso haja campos vazios
            }

            os.setStatus(cmbStatus.getSelectedItem().toString());
            os.setTecnico(txtTecnico.getText());

            Modelo mod = (Modelo) cmbMod.getSelectedItem();
            os.setModelo(mod);
            os.setDescricao_cliente(txtdesCliente.getText());
            os.setServico_executado(txtservexc.getText());

            // Validando formato numérico do valor
            try {
                os.setValor(Double.valueOf(txtValor.getText().replace(",", ".")));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "DIGITE O VALOR CORRETO.");
                return; // Sai do método se o valor não for numérico
            }

            String idcliente = txtcliid.getText();
            int idCliente;
            try {
                idCliente = Integer.parseInt(idcliente);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "INDENTIFICAÇÃO DO CLIENTE INVALIDA.");
                return; // Sai do método se o ID do cliente não for numérico
            }

            // Criar um objeto Cliente e obter os detalhes do cliente do banco de dados
            ClientesDAO dao_cli = new ClientesDAO();
            Clientes cli = dao_cli.retornaCliente(idCliente);
            if (cli == null) {
                JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO.");
                return; // Sai do método se o cliente não for encontrado
            }

            os.setCliente(cli);
            if(rborcamento.isSelected()){
                tipo = "Orçamento";
            } else if (rbautorizada.isSelected()) {
                tipo = "Autorizada";   
            }
            os.setTipo(tipo);

            ProdutosDAO daoProdutos = new ProdutosDAO();
            itenOSDAO daoit = new itenOSDAO();
            OSDAO dao = new OSDAO();
            dao.cadstrarOs(os);
            os.setId(dao.retornaultimaOS());

            for (int i = 0; i < tblOS.getRowCount(); i++) {
                int qtd_estoque, qtd_comprada, qtd_atualizada;
                Produtos objp = new Produtos();
                intesOS it = new intesOS();

                objp.setIdprod(Integer.parseInt(tblOS.getValueAt(i, 0).toString()));

                qtd_estoque = daoProdutos.retornaEstoqueAtual(objp.getIdprod());
                qtd_comprada = Integer.parseInt(tblOS.getValueAt(i, 3).toString());
                qtd_atualizada = qtd_estoque - qtd_comprada;

                daoProdutos.baixaEstoque(objp.getIdprod(), qtd_atualizada);

                it.setProduto(objp);
                it.setQtd_os(Integer.parseInt(tblOS.getValueAt(i, 3).toString()));

                it.setOs(os);
                daoit.cadastraIntesOs(it);
            }

            JOptionPane.showMessageDialog(null, "ORDEM GERADA COM SUCESSO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO A CADASTRAR ORDEM: " + e.getMessage());
        }
        limparTabelaCampos();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemo2ActionPerformed

    private void rborcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rborcamentoActionPerformed
     tipo = "Orçamento";
                
    }//GEN-LAST:event_rborcamentoActionPerformed

    private void rbautorizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbautorizadaActionPerformed
     tipo = "Autorizada";     
    }//GEN-LAST:event_rbautorizadaActionPerformed

    private void cmbModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbModActionPerformed

    private void cmbModAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmbModAncestorAdded
        ModeloDAO mod = new ModeloDAO();
        List<Modelo> lis = mod.listaModelo();
        cmbMod.removeAll();

        for (Modelo m : lis) {
            cmbMod.addItem(m);
        }

    }//GEN-LAST:event_cmbModAncestorAdded

    private void tabelcliOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelcliOSMouseClicked

        int setar = tabelcliOS.getSelectedRow();
        txtcliid.setText(tabelcliOS.getModel().getValueAt(setar, 0).toString());
    }//GEN-LAST:event_tabelcliOSMouseClicked

    private void tbProduOsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbProduOsAncestorAdded
        listaProdutos();
    }//GEN-LAST:event_tbProduOsAncestorAdded

    private void tbProduOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProduOsMouseClicked
        addItensOs();
    }//GEN-LAST:event_tbProduOsMouseClicked

    private void tblOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblOSMouseClicked

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
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOS().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTNUMEROOS1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnRemo;
    private javax.swing.JButton btnRemo1;
    private javax.swing.JButton btnRemo2;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbMod;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbautorizada;
    private javax.swing.JRadioButton rborcamento;
    private javax.swing.JTable tabelcliOS;
    private javax.swing.JTable tbProduOs;
    private javax.swing.JTable tblOS;
    private javax.swing.JTextField txtDataOs;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtcliid;
    private javax.swing.JPanel txtclios;
    private javax.swing.JTextField txtdesCliente;
    private javax.swing.JTextField txtservexc;
    // End of variables declaration//GEN-END:variables
}
