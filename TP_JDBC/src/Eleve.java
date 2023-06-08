import java.util.ArrayList;
import java.util.List;

public class Eleve {

    private String _nom ;

    private String _premon;
    private List<Note> notes;
    private int id;


    public Eleve( String nom, String prenom) {
        this._nom = nom;
        this._premon = prenom;
        this.notes = new ArrayList<>();
    }

    public String get_premon() {
        return _premon;
    }

    public String get_nom() {
        return _nom;
    }


    public void set_premon(String _premon) {
        this._premon = _premon;
    }

    public void set_nom(String _nom) {
        this._nom = _nom;
    }
    public List<Note> getNotes() {
        return notes;
    }
    public void ajouterNote(Note note) {
        notes.add(note);
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "_nom='" + _nom + '\'' +
                ", id=" + id +
                ", _premon='" + _premon + '\'' +
                '}';
    }

}
