import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EleveDAO {



    public List<Eleve> getEleves() {
        List<Eleve> eleves = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM televe");
            while (rs.next()) {
                eleves.add(new Eleve(rs.getInt(1), rs.getString("nom"), rs.getString("Prenom")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eleves;
    }

    public void ajouterEleve(Eleve eleve) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("INSERT INTO televe(nom, prenom) VALUES(?, ?);");
            statement.setString(1, eleve.get_nom());
            statement.setString(2, eleve.get_premon());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifierEleve(Eleve eleve) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("UPDATE televe SET nom=?, prenom=? WHERE id=?;");
            statement.setString(1, eleve.get_nom());
            statement.setString(2, eleve.get_premon());
            statement.setInt(3, eleve.getId());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supprimerEleve(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("DELETE FROM televe WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
