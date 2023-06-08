public class Note {
    public enum Matiere {
        MATHS, ANGLAIS, PHYSIQUE, INFORMATIQUE;
    }
    private Matiere matiere;
    private float valeur;

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }


    public Matiere getMatiere() {
        return matiere;
    }

    public float getValeur() {
        return valeur;
    }



    public Note(Matiere matiere, float valeur) {
        this.matiere = matiere;
        this.valeur = valeur;
    }


}