package Model; /**
 * Created by Cesar on 02/09/2015.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager{

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./candidsDB";
    private static final String DB_USERNAME = "test";
    private static final String DB_PASSWORD = "";
    private Connection connection;
    private Statement stmt;

    private static final String CREATE_TABLE = "CREATE TABLE CANDIDS "
            + "(candid bigint auto_increment NOT NULL PRIMARY KEY, "
            + " candName VARCHAR(255), "
            + " candAfil VARCHAR(255), "
            + " candVotes int)";

    public DatabaseManager() {
        openConnection();
    }

    public void openConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = connection.createStatement();
            stmt.execute(CREATE_TABLE);
            System.out.println("created new DB");
        } catch (Exception ex) {
            System.out.println("Connected to Existing");
        }
    }

    public void addCandid(String s){
        try {
            String sql = "INSERT INTO CANDIDS (candName,candVotes) VALUES ('"+s+"', '0')";
            stmt.execute(sql);
        } catch (SQLException e) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean addVote(int id){
        try {
            String sql = "UPDATE CANDIDS set candVotes = candVotes + 1 where candid = '" + id + "'";
            stmt.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList getCandids(){
        ArrayList<Object[]> candids = new ArrayList<>();

        try {
            String sql = "SELECT * FROM CANDIDS";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String[] candid = new String[4];
                candid[0] = rs.getString("candid");
                candid[1] = rs.getString("candName");
                candid[2] = rs.getString("candAfil");
                candid[3] = rs.getString("candVotes");
                candids.add(candid);
            }
            return candids;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candids;
    }
}
