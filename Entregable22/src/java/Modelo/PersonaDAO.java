/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements Metodos{
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    @Override
    public List listar() {
         ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from asociado";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("id_asociado"));
                per.setDni(rs.getString("DNI"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setTelef(rs.getString("telefono"));
                list.add(per);
            }
        } catch (Exception e){
        }
        return list;
    }

    @Override
    public Persona list(int id) {
         String sql="select * from asociado where id_asociado="+id;
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("id_asociado"));
                p.setDni(rs.getString("DNI"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelef(rs.getString("telefono"));
            }
        } catch (Exception e){
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
         String sql="INSERT INTO `asociado`(`DNI`, `nombre`, `apellido`, `telefono`)values('"+per.getDni()+"','"+per.getNombre()+"','"+per.getApellido()+"','"+per.getTelef()+"')";
        try {
            con =cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch(Exception e){
            
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
         String sql = 
                "UPDATE `asociado` SET DNI='"+per.getDni()+"',nombre='"+per.getNombre()+"',apellido='"+per.getApellido()+"',telefono='"+per.getTelef()+"'where id_asociado="+per.getId();
        try{
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
         String sql="DELETE FROM `asociado` WHERE id_asociado="+id;
         try{
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return false;
    }

    @Override
    public int validar(Persona per) {
        int r=0;
        String sql="SELECT * FROM `persona` WHERE Nombre=? and Correo=?";
        try{
            con=cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, per.getNom());
            ps.setString(2, per.getCorreo());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setNom(rs.getString("Nombre"));
                per.setCorreo(rs.getString("Correo"));
            }
            if(r==1){
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public List buscar(String texto) {
        List<Persona> lista=new ArrayList<>();
        String sql;
        sql="SELECT * FROM `asociado` WHERE id_asociado like '%"+texto+"%' or nombre like '%"+texto+"%' or apellido like '%"+texto+"%' or DNI like '%"+texto+"%' or telefono like '%"+texto+"%'";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Persona pe = new Persona();
                pe.setId(rs.getInt("id_asociado"));
                pe.setDni(rs.getString("DNI"));
                pe.setNombre(rs.getString("nombre"));
                pe.setApellido(rs.getString("apellido"));
                pe.setTelef(rs.getString("telefono"));
                
                lista.add(pe);
            }
        } catch (Exception e){
            
        }
        return lista;
    }
    
}
