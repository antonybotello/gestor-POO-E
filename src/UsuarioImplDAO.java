import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImplDAO implements GenericoDAO<Usuario>{

    private Connection connection;


    
    public UsuarioImplDAO() {
        this.connection= ConnectionManager.getInstance().getConnection();
    }

    @Override
    public void add(Usuario obj) throws SQLException {
        
        String query= "INSERT INTO usuarios (documento,nombre,correo)"+
                      "VALUES (?,?,?)";
        try(
            PreparedStatement stmt= connection.prepareStatement(query)){
                stmt.setString(1, obj.getDocumento());
                stmt.setString(2, obj.getNombre());
                stmt.setString(3, obj.getCorreo());

            }
        
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios= new ArrayList<>();
        String query= "SELECT * FROM usuarios";
        try( Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);){
            while (rs.next()){
                usuarios.add(new Usuario(rs.getInt("id"),
                rs.getString("documento"),
                rs.getString("nombre"),
                rs.getString("correo")));
            }
        }
        return usuarios;
    }

    @Override
    public Usuario getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Usuario obj) {
        // TODO Auto-generated method stub
        
    }
    
    
}
