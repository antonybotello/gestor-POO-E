package models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.SQLError;

import utils.*;

public class UsuarioImplDAO implements GenericoDAO<Usuario> {

    private Connection connection;

    public UsuarioImplDAO() {
        this.connection = ConnectionManager.getInstance().getConnection();
    }

    @Override
    public void add(Usuario obj) throws SQLException {

        String query = "INSERT INTO usuarios (documento,nombre,correo)" +
                "VALUES (?,?,?)";
        try (
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, obj.getDocumento());
            stmt.setString(2, obj.getNombre());
            stmt.setString(3, obj.getCorreo());
            stmt.executeUpdate();

        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE idUsuarios=?";
        try (
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();

        }

    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("idUsuarios"),
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("correo")));
            }
        }
        return usuarios;
    }

    @Override
    public Usuario getById(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE idUsuarios=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("idUsuarios"));
                    usuario.setDocumento(rs.getString("documento"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));

                    return usuario;
                }
            }
        }
        return null;
    }

    

    @Override
    public void update(Usuario obj) throws SQLException {
        String query = "UPDATE usuarios SET nombre=?, correo=? WHERE idUsuarios=?";
        try (
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, obj.getNombre());
            stmt.setString(2, obj.getCorreo());
            stmt.setInt(3, obj.getId());
            stmt.executeUpdate();

        }

    }

}
