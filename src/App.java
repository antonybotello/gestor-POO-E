import java.util.Scanner;

import controllers.UsuarioController;
import models.Usuario;

public class App {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        UsuarioController usuarioC = new UsuarioController();

        while (true) {
            System.out.println("###########  MENÚ  ###########");
            System.out.println("### 1. Agregar Usuario     ###");
            System.out.println("### 2. Listar Usuarios     ###");
            System.out.println("### 3. Eliminar Usuarios   ###");
            System.out.println("### 4. actualizar Usuarios ###");
            System.out.println("### 0. Salir               ###");
            System.out.println("##############################");
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Digite el documento");
                    String documento = teclado.nextLine();
                    System.out.println("Digite el nombre");
                    String nombre = teclado.nextLine();
                    System.out.println("Digite el correo");
                    String correo = teclado.nextLine();

                    usuarioC.agregarUsuario(new Usuario(documento, nombre, correo));

                    break;
                case 2:
                    usuarioC.listarUsuarios();
                    break;
                case 3:
                    System.out.println("Digite el id del usuario a eliminar");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    usuarioC.eliminarUsuario(id);
                    break;
                    case 4:
                
                    teclado.nextLine();
                    // usuarioC.(id);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    return;
                default:
                    break;
            }

        }

    }

    /*
     * CREATE TABLE usuarios (
     * id INT PRIMARY KEY,
     * documento VARCHAR(10),
     * nombre VARCHAR(50),
     * email VARCHAR(50)
     * );
     * C - INSERT INTO Usuarios VALUES(1049666666,Sergio,sergio@gmail.com)
     * R - SELECT id FROM Usuarios WHERE documento='xxxxxxxxxx'
     * U - UPDATE Usuarios SET nombre= pablo WHERE id=1
     * D - DELETE FROM Usuarios WHERE id=1
     * 
     */

}
