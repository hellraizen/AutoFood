package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectaBd {
	public static Connection conectabd() throws ClassNotFoundException{
	       
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Autofood","postgres","0000");
            System.out.println("Conectado com Sucesso");
            return con;
        }
            
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, erro);
            
            return null;
        }    
        
    
}

}
