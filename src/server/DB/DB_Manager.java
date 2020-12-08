package server.DB;



import shared.Contatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Manager {
    public static boolean add_db(Contatto peson) {
        try {
            PreparedStatement ps = ConnessioneDB.getInstance().getConnection().prepareStatement("INSERT INTO lista (nome, telefono) values (?, ?)");
            ps.setString(1, peson.getNome());
            ps.setString(2, peson.getNum());
            ps.executeUpdate();
            ConnessioneDB.getInstance().getConnection().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean remove_db(String numt) {
        boolean check = false;
        try {
            PreparedStatement ps = ConnessioneDB.getInstance().getConnection().prepareStatement("DELETE FROM lista WHERE telefono = ?");
            System.out.println(numt);
            ps.setString(1, numt);
            if(ps.executeUpdate() != 0) {
                check = true;
            }
            ConnessioneDB.getInstance().getConnection().close();
            return check;
        } catch (Exception e) {
            return check;
        }
    }

    public static List<Contatto> getContatti_db() {
        List<Contatto> listacontatti = new ArrayList<>();
        try {
            PreparedStatement ps = ConnessioneDB.getInstance().getConnection().prepareStatement("SELECT * FROM lista");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listacontatti.add(new Contatto(rs.getString("nome"),  rs.getString("telefono")));
            }
        }catch (SQLException e){}
        try {
            ConnessioneDB.getInstance().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listacontatti;
    }
}
