/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksarajawa;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Humam
 */
public class Jawaban {
    protected ArrayList<String> jawaban = new ArrayList<String>();
    private String url, user, pass;
    private Connection con;
    private Statement stmt;
    public Jawaban() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/projek_rpl";
            user = "admin";
            pass = "8sIMkcko1x8URasv";
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ujian");
            while(rs.next())
                jawaban.add(rs.getString(2));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Jawaban ans = new Jawaban();
        for(int i=0; i<ans.jawaban.size(); i++) {
            System.out.println(ans.jawaban.get(i));
        }
    }
}