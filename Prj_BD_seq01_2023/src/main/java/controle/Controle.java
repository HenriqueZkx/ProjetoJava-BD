package controle;

import java.sql.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.table.DefaultTableModel;


public class Controle extends JFrame{
    
            Conexao con_cliente;
            JTextField textcodigo, textnome, textemail, textpesquisar;
            JLabel Titulo,rCodigo, rNomeCli, rEmail, rTel, Data, rPesquisar;
            JFormattedTextField tel, data;
            MaskFormatter mTel, mData;
            JButton butprimeiro,butultimo, butproximo, butanterior;
            JButton bNovoRegistror,bAlterar,bGravar,bExcluir;
            JButton pesquisar,sair;
            JTable tblclientes; 
            JScrollPane scp_tabela; 
    
            
            
    
            public Controle(){
                    setTitle("Conexão Java com SQL");
                    setSize(900, 600);
                    setResizable(false);
                    setLayout(null);
                    Container tela = getContentPane();
            
                    
                    tela.setBackground(Color.CYAN);
                    
                    
                    con_cliente = new Conexao();
                    con_cliente.conecta();
                    
                   
                    
                    
                    
                    Titulo = new JLabel("Formulário");
                    rCodigo = new JLabel("Código:");
                    rNomeCli = new JLabel ("Nome:");
                    rEmail = new JLabel ("Email:");
                    Data = new JLabel ("Data:");
                    rTel = new JLabel ("Telefone:");
                    
                           
                           
                    textcodigo = new JTextField(5);
                    textnome = new JTextField(50);
                    textemail = new JTextField(80);
                           
                           
                           
                    try{
                        mTel = new MaskFormatter("(##)#####-####");
                        mData = new MaskFormatter("##/##/####");
                    }
                    catch(ParseException excp){
                           
                    }
                           
                    tel = new JFormattedTextField(mTel);
                    data = new JFormattedTextField(mData);
                          
                          
                          
                    Titulo.setBounds(420,10,200,20);
                    Titulo.setForeground(Color.BLUE);
                          
                          
                          
                    rCodigo.setBounds(50,40,100,20);
                    rCodigo.setForeground(Color.BLUE);
                    rCodigo.setFont(new Font("Arial",Font.BOLD,12));
                    textcodigo.setBounds(100,41,100,18);                          
                          
                          
                    rNomeCli.setBounds(50,90,100,20);
                    rNomeCli.setForeground(Color.BLUE);
                    rNomeCli.setFont(new Font("Arial",Font.BOLD,12));
                    textnome.setBounds(100,91,180,18);
                          
                                                    
                    Data.setBounds(50,140,100,20);
                    Data.setForeground(Color.BLUE);
                    Data.setFont(new Font("Arial",Font.BOLD,12));
                    data.setBounds(100,141,130,20);
                    data.setHorizontalAlignment(JFormattedTextField.CENTER);     
                           
                           
                    rTel.setBounds(50,190,100,20);
                    rTel.setForeground(Color.BLUE);
                    rTel.setFont(new Font("Arial",Font.BOLD,12));
                    tel.setBounds(120,191,100,18);
                          
                          
                          
                    rEmail.setBounds(50,240,150,20);
                    rEmail.setForeground(Color.BLUE);
                    rEmail.setFont(new Font("Arial",Font.BOLD,12));
                    textemail.setBounds(120,241,110,18);
                          
                          
                    rPesquisar = new JLabel("Pesquise:");
                    textpesquisar = new JTextField(5);
                    pesquisar = new JButton("Pesquisar");
                            
                    butprimeiro = new JButton("Primeiro");
                    butanterior = new JButton("Anterior");
                    butultimo = new JButton("Ultimo");
                    butproximo = new JButton("Proximo");
                            
                            
                    bNovoRegistror = new JButton("Novo Registro");
                    bAlterar = new JButton("Alterar");
                    bGravar = new JButton("Gravar");
                    bExcluir = new JButton("Excluir");
                    sair = new JButton("Sair");
                          
                    rPesquisar.setBounds(200,530,200,20);
                    textpesquisar.setBounds(280,530,350,20);
                    pesquisar.setBounds(650,530,130,20);
                           
                    rPesquisar.setForeground(Color.BLUE);
                           
                    butprimeiro.setBounds(50,280,110,20);
                    butultimo.setBounds(170,280,110,20);
                    butproximo.setBounds(290,280,110,20);
                    butanterior.setBounds(410,280,110,20);
                           
                           
                           
                    bNovoRegistror.setBounds(680,40,130,20);
                    bAlterar.setBounds(680,140,130,20);
                    bGravar.setBounds(680,90,130,20);
                    bExcluir.setBounds(680,190,130,20);
                           
                    sair.setBounds(530,280,80,20);
                            
                           
                    butprimeiro.setBackground(new Color(0,191,255));
                    butultimo.setBackground(new Color(0,191,255));
                    butproximo.setBackground(new Color(0,191,255));
                    butanterior.setBackground(new Color(0,191,255));
                           
                    bNovoRegistror.setBackground(new Color(0,191,255));
                    bAlterar.setBackground(new Color(0,191,255));
                    bGravar.setBackground(new Color(0,191,255));
                    bExcluir.setBackground(new Color(0,191,255));
                    pesquisar.setBackground(new Color(0,191,255));
                           
                    sair.setBackground(new Color(0,191,255));
                           
                           
                           
                           
                           
                        sair.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                                int opcaosair;
                                                    Object[]botoessair={"Sim","Não"};
                                                    opcaosair = JOptionPane.showOptionDialog(null,"Você deseja mesmo sair?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoessair,botoessair[0]);
                                                     if(opcaosair==JOptionPane.YES_NO_OPTION)System.exit(0);   
                            }
                        }
                    );
                           
                        butprimeiro.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                try{
                                    con_cliente.resultset.first();
                                        mostrar_Dados();
                                }catch(SQLException erro){
                                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro");
                                }
                            }
                        }
                    );
            
                        butanterior.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                try{
                                    if(con_cliente.resultset.isFirst()){
                                            JOptionPane.showMessageDialog(null, "Você se encontra no primeiro registro");}
                                    else{
                                        con_cliente.resultset.previous();   
                                            mostrar_Dados();}  
                                   }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro");
                                        }
                            }
                        }
                    );
            
                        butproximo.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                try{
                                    if(con_cliente.resultset.isLast()){
                                        JOptionPane.showMessageDialog(null, "Você se encontra no último registro");}
                                    else{
                                        con_cliente.resultset.next();
                                            mostrar_Dados();}
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro");
                                        }
                            }
                        }
                    );
            
                        butultimo.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                try{
                                    con_cliente.resultset.last();
                                        mostrar_Dados();
                                }catch(SQLException erro){
                                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro");
                                    }
                                }
                        }
                    );
         
                        bNovoRegistror.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                textcodigo.setText(""); 
                                textnome.setText("");
                                textemail.setText("");
                                tel.setText("");
                                data.setText("");
                                textcodigo.requestFocus(); 
                            }
                        }
                    );
            
                        bGravar.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                String nome = textnome.getText();
                                String dtnasc = data.getText();
                                String telefone = tel.getText();
                                String email = textemail.getText();
                    
                                try {
                                    String insert_sql="insert into tbclientes (nome, dt_nasc, telefone, email) values ('" + nome + "','" + dtnasc + "','" + telefone + "','" + email + "')";
                                    con_cliente.statement.executeUpdate(insert_sql);
                                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        
                                    con_cliente.executaSQL("select * from tbclientes order by cod");
                                    preencherTabela();
                                }catch(SQLException errosql){
                                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                                    }
                            }
                        }
                    );
             
            
                        bAlterar.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                String nome = textnome.getText();
                                String data_nasc = data.getText();
                                String telefone = tel.getText();
                                String email = textemail.getText();
                                String sql;
                                String msg="";
                    
                            try {
                                if(textcodigo.getText().equals("")){
                                    sql="insert into tbclientes (nome, dt_nasc, telefone, email) values ('" + nome + "','" + data_nasc + "','" + telefone + "','" + email + "')";
                                    msg="Gravação de um novo registro";
                                    }
                                else{
                                    sql="update tbclientes set nome='" + nome + "',dt_nasc='" + data_nasc + "', telefone='" + telefone + "', email='" + email + "' where cod = " + textcodigo.getText();
                                    msg="Alteração de registro";
                                }
                        
                                con_cliente.statement.executeUpdate(sql);
                                JOptionPane.showMessageDialog(null, msg,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        
                                con_cliente.executaSQL("select * from tbclientes order by cod");
                                preencherTabela();
                        
                                }catch(SQLException errosql){
                                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                                    }
                            }
                        }
                    );
                 
                        bExcluir.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                String sql=""; 
                                try{
                                    int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão",JOptionPane.YES_NO_OPTION,3);
                                        if (resposta==0){
                                        sql = "delete from tbclientes where cod = " + textcodigo.getText();
                                        int excluir = con_cliente.statement.executeUpdate(sql);
                                        if(excluir ==1){
                                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!!", "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
                                                con_cliente.executaSQL("select * from tbclientes order by cod");
                                                con_cliente.resultset.first();
                                                preencherTabela();
                                                posicionarRegistro();
                                            }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!!","Menssagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }
                                }catch (SQLException excecao){
                                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+excecao,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                                    }
                            }
                        }
                    );
            
                        pesquisar.addActionListener( new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    String pesquisa = "select * from tbclientes where nome like '" + textpesquisar.getText() + "%'";
                                        con_cliente.executaSQL(pesquisa);
                                if(con_cliente.resultset.first()){
                                preencherTabela(); 
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!! :\n ","Mensagem do Programa,",JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }catch(SQLException errosql){
                                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                                    }
                            }
                        }
                    );      
                           
                            
                          
                        tblclientes = new JTable();
                        scp_tabela=  new JScrollPane();
                        tela.add(tblclientes);
                        tela.add(scp_tabela);
                            
                        tblclientes.setBounds(100,320,550,200);
                        scp_tabela.setBounds(100,320,550,200);
                            
                        tblclientes.setBackground(new Color(0,191,255));
                        scp_tabela.setBackground(new Color(213,204,254));
                            
            
                        tblclientes.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                        tblclientes.setFont (new Font("Arial",1,12));
            
            
                        tblclientes.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {null,null,null,null,null},
                                {null,null,null,null,null},
                                {null,null,null,null,null},
                                {null,null,null,null,null}
                            },
                            new String [] {"Código","Nome", "Data Nascimento", "Telefone", "Email" }
                        ){
                            boolean[] canEdit = new boolean []{
                                false,false,false,false,false
                            };
                                @Override
                            public boolean isCellEditable(int rowIndex, int columnindex){
                                return canEdit [columnindex];         
                            };
                        }
                    ); 
              
                        scp_tabela.setViewportView(tblclientes);
                        tblclientes.setAutoCreateRowSorter(true); 
                          
                          
                          
                          
                    
                   
                        
                        tela.add(Titulo);
                        tela.add(rCodigo);
                        tela.add(textcodigo);
                        tela.add(rNomeCli);
                        tela.add(textnome);
                        tela.add(rEmail);
                        tela.add(textemail);
                        tela.add(rTel);
                        tela.add(tel);
                        tela.add(Data);
                        tela.add(data);
                         
                        tela.add(rPesquisar);
                        tela.add(textpesquisar);
                        tela.add(pesquisar);
                              
                        tela.add(butprimeiro);
                        tela.add(butultimo);
                        tela.add(butproximo);
                        tela.add(butanterior);
                              
                        tela.add(bNovoRegistror);
                        tela.add(bAlterar);
                        tela.add(bGravar);
                        tela.add(bExcluir);
                              
                        tela.add(sair);
                              
                        
                    
                        setLocationRelativeTo(null);
                        setVisible(true);
                    
                    
                        con_cliente.executaSQL("select * from tbclientes order by cod");
                        preencherTabela();
                        posicionarRegistro();
                
            }
            
    public void preencherTabela(){
    tblclientes.getColumnModel().getColumn(0).setPreferredWidth(80);
    tblclientes.getColumnModel().getColumn(1).setPreferredWidth(170);
    tblclientes.getColumnModel().getColumn(2).setPreferredWidth(130);
    tblclientes.getColumnModel().getColumn(3).setPreferredWidth(100);
    tblclientes.getColumnModel().getColumn(4).setPreferredWidth(150);

    DefaultTableModel modelo = (DefaultTableModel) tblclientes.getModel();
    modelo.setNumRows(0);

    try {
        con_cliente.resultset.beforeFirst();
        while (con_cliente.resultset.next()) {
            modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod"),  
                    con_cliente.resultset.getString("nome"), 
                    con_cliente.resultset.getString("dt_nasc"), 
                    con_cliente.resultset.getString("telefone"), 
                    con_cliente.resultset.getString("email") 
            });
        }
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
    }
}

    public void posicionarRegistro() {
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
       public void mostrar_Dados(){
       try{
        textcodigo.setText(con_cliente.resultset.getString("cod")); 
        textnome.setText(con_cliente.resultset.getString("nome"));
        data.setText(con_cliente.resultset.getString("dt_nasc"));
        tel.setText(con_cliente.resultset.getString("telefone"));
        textemail.setText(con_cliente.resultset.getString("email"));
       }catch(SQLException erro){
       JOptionPane.showMessageDialog(null,"Não localizou dados: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);    
       }     
    }
            
        public static void main(String[] args) {
        
            Controle app = new Controle();
            app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}