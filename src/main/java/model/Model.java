package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {

    private Usuario usuario;
    private static Connection connection = new DBConnection("usuariosmvc", "root", "").mySQLConnection();
    private ArrayList<Usuario> listaUsuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Retrieves a user whose db primary key is given as parameter for this
     * method and stores it as an attribute of this class
     *
     * @param idUser
     */
    public void getUser(int idUser) {
        PreparedStatement ps;
        try {
            String query = "Select * from usuario where pkusuario = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPkusuario(rs.getInt("pkusuario"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inserts a user object into the database
     *
     * @return
     */
    public boolean insertUser() {
        PreparedStatement ps;
        try {
            String query = "Insert into usuario (pkusuario,nombre,correo) values (?, ? , ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, usuario.getPkusuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getCorreo());
            if (ps.executeUpdate() > 0) {
                return true;
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     *
     * @return  listaUsuarios containing all the users inside the table usuario
     */
    public ArrayList<Usuario> selectTableUser() {
        PreparedStatement ps;
        listaUsuarios = new ArrayList<>();
        try {
            String query = "Select * from usuario";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaUsuarios.add(new Usuario(
                     rs.getInt("pkusuario"),
                     rs.getString("nombre"),
                     rs.getString("correo")
                ));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    /**
     *
     * @return  True if the user was found and deleted.
     *          false if no user was found with that primary key
     */
    public boolean deleteUser() {
        PreparedStatement ps;
        try{
            String query = "Delete from usuario where pkusuario = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, usuario.getPkusuario());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
