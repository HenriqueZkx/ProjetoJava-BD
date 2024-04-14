
package controle;

import conexao.Conexao;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame 
{
    Conexao con_clientes;
    
    JPasswordField tsen;
    JLabel rusu,rsen,rtit;
    JTextField tusu;
    JButton blogar;
    
    public Login()
    {
        con_clientes = new Conexao();
        con_clientes.conecta();
        
        setTitle(" *** Login de Acesso ***");
        Container tela = getContentPane();
        tela.setLayout(null);
        
        rtit = new JLabel("Acesso ao Sistema ");
        rusu = new JLabel("Usuário: ");
        rsen = new JLabel("Senha: ");
        blogar = new JButton("Logar");
        tusu = new JTextField(10);
        tsen = new JPasswordField(10);
        
        rtit.setBounds(160,35,250,35);
        rusu.setBounds(135,110,100,20);
        rsen.setBounds(135,150,100,20);
        tusu.setBounds(185,110,50,20);
        tsen.setBounds(185,150,50,20);
        blogar.setBounds(168,210,100,20);
        
        tela.setBackground(Color.CYAN);
        
        rusu.setForeground(Color.BLUE);
        rsen.setForeground(Color.BLUE);
        rtit.setForeground(Color.BLUE);
        
        
         rtit.setFont(new Font("Arial",Font.BOLD,12));
         rusu.setFont(new Font("Arial",Font.BOLD,12));
         rsen.setFont(new Font("Arial",Font.BOLD,12));
         
        blogar.setMnemonic(KeyEvent.VK_ENTER);
        
       blogar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String pesquisa = "select * from tblusuario where usuario = '" + tusu.getText() + "'&& senha = '" + tsen.getText() + "'";
            con_clientes.executaSQL(pesquisa);

            if (con_clientes.resultset.first()) { 
                Controle mostra = new Controle();
                mostra.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                con_clientes.desconecta();
                System.exit(0);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco de dados: " + errosql.getMessage(), "Mensagem do programa", JOptionPane.ERROR_MESSAGE);
        }
    }
});

        tela.add(rtit);
        tela.add(rusu);
        tela.add(rsen);
        tela.add(tusu);
        tela.add(tsen);
        tela.add(blogar);
        
        setSize(450,350);
        setVisible(true);
        setLocationRelativeTo(null);
    }
     public static void main(String args[])
        {
            Login app = new Login();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}