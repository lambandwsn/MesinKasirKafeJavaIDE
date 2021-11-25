package Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private Connection koneksi;
    
    public Connection getConnection(){
        //proses koneksi java ke database MySQL
    try{
        //inisialisasi akun database
        String url="jdbc:mysql://localhost:3306/db_sbdl";
        String username = "root";
        String password = "";
        //meregrestrasikan driver JDBC ke MySQL
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //lakukan koneksi dari java ke MySQL
        koneksi = DriverManager.getConnection(url, username, password);
    }catch(SQLException e){
        System.out.println("Koneksi gagal");
        e.printStackTrace();
    }
    return koneksi;
    }
}
