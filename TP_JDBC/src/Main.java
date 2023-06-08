import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        afficherEleves();
        new EleveDAO().ajouterEleve(new Eleve("test","test"));
        new EleveDAO().ajouterEleve(new Eleve("test2","test2"));
        new EleveDAO().ajouterEleve(new Eleve("test3","test3"));
        new NoteDAO().getNoteEtudiant(1);

        afficherEleves();
        new EleveDAO().supprimerEleve(0);
        afficherEleves();

    }
public static void afficherEleves(){
    List<Eleve> eleves = new EleveDAO().getEleves();
    eleves.stream().forEach(eleve->System.out.println(eleve.toString()));
        }
}