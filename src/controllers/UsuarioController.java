package controllers;

import java.sql.SQLException;
import java.util.List;

import models.Usuario;
import models.UsuarioImplDAO;

public class UsuarioController {
    private UsuarioImplDAO usuarioDAO= new UsuarioImplDAO();



    public void agregarUsuario(Usuario usuario) throws SQLException{
        try {
            usuarioDAO.add(usuario);
            System.out.println("Exito al agregar Usuario!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al agregar Usuario!");
        }
    }
    public void listarUsuarios() throws SQLException{
        try{
            List<Usuario> usuarios= usuarioDAO.getAll();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error al listar Usuarios!");

        }
    }
    public void eliminarUsuario(int id) throws SQLException{
        try {
            usuarioDAO.delete(id);
            System.out.println("Exito al eliminar Usuario!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar Usuario!");
        }
    }
    public void actualizarUsuario(Usuario usuario) throws SQLException{
        try {
            usuarioDAO.update(usuario);
            System.out.println("Exito al actualizar Usuario!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar Usuario!");
        }
    }
    
}
