package concesionario.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class consultaMarca extends conexion {
    
public boolean agregarMarca(marca mar){
        PreparedStatement ps = null;
        Connection con = establecerConexion();
        
        String sql = "INSERT INTO marca (id, nombre, observacion) VALUES (?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(2,  mar.getNombre());
            ps.setString(3, mar.getObservacion());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{        
            try {
                con.close();
            } catch(SQLException e) {
            System.err.println(e);      
          }
        }
    }
    
public boolean modificarMarca(marca mar){
        PreparedStatement ps = null;
        Connection con = establecerConexion();
        
        String sql = "UPDATE marca SET nombre=?, observacion=? WHERE id=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, mar.getId());
            ps.setString(2,  mar.getNombre());
            ps.setString(3, mar.getObservacion());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{        
            try {
                con.close();
            } catch(SQLException e) {
            System.err.println(e);      
          }
        }
    }
    
public boolean eliminarMarca(marca mar){
        PreparedStatement ps = null;
        Connection con = establecerConexion();
        
        String sql = "DELETE FROM marca SET WHERE id=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, mar.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{        
            try {
                con.close();
            } catch(SQLException e) {
            System.err.println(e);      
          }
        }
    }
    
public boolean buscarMarca(marca mar){
       ResultSet rs = null;
         
        PreparedStatement ps = null;
        Connection con = establecerConexion();
        
        String sql = "SELECT * FROM marca SET WHERE  marca=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(2, mar.getNombre());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                mar.setId(Integer.parseInt(rs.getString("id")));
                mar.setNombre(rs.getString("nombre"));
                mar.setObservacion(rs.getString("observacion"));
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{        
            try {
                con.close();
            } catch(SQLException e) {
            System.err.println(e);      
          }
        }
    }
}
