package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

    private String user;
    private String email;
    private String pkUsername;
    private static Connection connection = new DBConnection("usuariosmvc","root","").mySQLConnection();

    public void getUser(int idUser){
        PreparedStatement ps;
        try{
            String query = "Select * from usuario where pkusuario = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
