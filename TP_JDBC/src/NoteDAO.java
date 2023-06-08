import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tnote");
            while (rs.next()) {
                Note note = new Note2(Note.Matiere.valueOf(rs.getString("matiere")), rs.getFloat("valeur"));
                notes.add(note);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notes;
    }

    public void ajouterNote(Note note) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("INSERT INTO tnote(matiere, valeur) VALUES(?, ?);");
            statement.setString(1, note.getMatiere().toString());
            statement.setFloat(2, note.getValeur());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifierNote(Note note) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("UPDATE tnote SET valeur=? WHERE matiere=?;");
            statement.setFloat(1, note.getValeur());
            statement.setString(2, note.getMatiere().toString());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supprimerNote(Note note) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("DELETE FROM tnote WHERE matiere=?;");
            statement.setString(1, note.getMatiere().toString());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String enumToString(Note.Matiere matiere){
        switch (matiere){
            case ANGLAIS -> {
                return "anglais";

            }
            case MATHS -> {
                return "MATHS";

            }
            case INFORMATIQUE -> {
                return "INFORMATIQUE";


            }
            default -> {
                return  "autre";
            }
        }

    }
    public void ajouteNoteEleve(int id, Note note){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement statement = con.prepareStatement("INSERT INTO televe(matiere, valeur,eleveid) VALUES(?,?,?);");
            statement.setString(1,enumToString(note.getMatiere()));
            statement.setFloat(2, note.getValeur());
            statement.setFloat(3, id);

            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Note> getNoteEtudiant(int id) {
        List<Note> noteEtudiant = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement stmt = con.prepareStatement("SELECT matiere, valeur FROM tnot WHERE eleveid = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Note note = new Note(Note.Matiere.valueOf(rs.getString("matiere")), rs.getFloat("valeur"));
                noteEtudiant.add(note);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noteEtudiant;
    }

    public List<Note> getNotesEtudiants() {
        List<Note> notesEtudiants = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/bdd_ecole", "root", "root");
            PreparedStatement stmt = con.prepareStatement("SELECT matiere, valeur FROM tnote");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Note note = new Note(Note.Matiere.valueOf(rs.getString("matiere")), rs.getFloat("valeur"));
                notesEtudiants.add(note);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notesEtudiants;
    }

}
