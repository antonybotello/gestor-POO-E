import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario miUsuario= new Usuario("1049666666", "Pepe", "p@g");
        UsuarioImplDAO usuarioDAO= new UsuarioImplDAO();
        try{
            usuarioDAO.add(miUsuario);
            List<Usuario> usuarios= usuarioDAO.getAll();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error al agregar Usuario!");

        }

    }

    /*
    CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    documento VARCHAR(10),
    nombre VARCHAR(50),
    email VARCHAR(50)
    );
     * C - INSERT INTO Usuarios VALUES(1049666666,Sergio,sergio@gmail.com)
     * R - SELECT id FROM Usuarios WHERE documento='xxxxxxxxxx'
     * U - UPDATE Usuarios SET nombre= pablo WHERE id=1
     * D - DELETE FROM Usuarios WHERE id=1
     * 
     */

}
