package jo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Classe représentant les Jeux Olympiques
public class JeuxOlympiques {

    private int annee; // L'année des Jeux Olympiques
    @SuppressWarnings("rawtypes")
    private List<Epreuve> lesEpreuves; // Liste des épreuves des Jeux Olympiques

    /**
     * Constructeur de la classe JeuxOlympiques.
     * 
     * @param annee L'année des Jeux Olympiques.
     */
    public JeuxOlympiques(int annee) {
        this.annee = annee;
        this.lesEpreuves = new ArrayList<>();
    }

    /**
     * Renvoie l'année des Jeux Olympiques.
     * 
     * @return int L'année des Jeux Olympiques.
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Renvoie toutes les épreuves des Jeux Olympiques.
     * 
     * @return List<Epreuve> Liste de toutes les épreuves des Jeux Olympiques.
     */
    @SuppressWarnings("rawtypes")
    public List<Epreuve> getEpreuves() {
        return this.lesEpreuves;
    }

    /**
     * Ajoute une épreuve à la liste des épreuves des Jeux Olympiques.
     * 
     * @param epv L'épreuve à ajouter.
     */
    public void addEpreuve(@SuppressWarnings("rawtypes") Epreuve epv) {
        this.lesEpreuves.add(epv);
    }

    /**
     * Calcule le nombre de médailles par pays.
     * 
     * @return HashMap<Pays, Classement>> Nombre de médailles par pays.
     */
    public HashMap<Pays, Classement> medaillesParPays() {
        HashMap<Pays, Classement> res = new HashMap<>();
        // Parcours de toutes les épreuves
        for (@SuppressWarnings("rawtypes") Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            @SuppressWarnings("unchecked")
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                Pays p = participant.getPays();
                Classement c = p.getClassement();
                if (!(res.containsKey(p))){
                    res.put(p, c);
                }
            }
        }
        return res;
    }

    
    /**
     * Renvoie la liste des pays classés par nombre de médailles d'or.
     * 
     * @return List<Pays> Liste des pays classés par nombre de médailles d'or.
     */
    public List<Pays> medaillesOr() {
        List<Pays> res = new ArrayList<>();
        HashMap<Pays, Integer> medaillesOr = new HashMap<>();
        
        // Parcours de toutes les épreuves
        for (@SuppressWarnings("rawtypes") Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            @SuppressWarnings("unchecked")
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                Pays p = participant.getPays();
                int i = p.getClassement().getOr();
                if (!(medaillesOr.containsKey(p))){
                    medaillesOr.put(p, i);
                }
            }   
        }
        res.addAll(medaillesOr.keySet());
        res.sort((p1, p2) -> medaillesOr.get(p2).compareTo(medaillesOr.get(p1))); // Tri des pays en fonction du nombre de médailles d'or
        return res;
    }


    /**
     * Renvoie la liste des pays classés par nombre total de médailles.
     * 
     * @return List<Pays> Liste des pays classés par nombre total de médailles.
     */
    public List<Pays> medaillesTotales() {
        List<Pays> res = new ArrayList<>();
        HashMap<Pays, Integer> medaillesTotales = new HashMap<>();
        
        // Parcours de toutes les épreuves
        for (@SuppressWarnings("rawtypes") Epreuve epv : this.lesEpreuves) {
            // Obtention de tous les participants de l'épreuve
            @SuppressWarnings("unchecked")
            List<Participant> participants = epv.getParticipants();
            // Parcours de tous les participants
            for (Participant participant : participants) {
                // Si le participant est une équipe
                Pays p = participant.getPays();
                int i = p.getClassement().totalMedailles();
                if (!(medaillesTotales.containsKey(p))){
                    medaillesTotales.put(p, i);
                }
            }
        }
        // Tri des pays en fonction du nombre total de médailles
        res.addAll(medaillesTotales.keySet());
        res.sort((p1, p2) -> medaillesTotales.get(p2).compareTo(medaillesTotales.get(p1)));
        return res;
    }

    @Override
    /**
     * Vérifie si cet objet est égal à l'objet spécifié.
     * 
     * @param o l'objet à comparer avec cet objet
     * @return true si les objets sont égaux, false sinon
     */
    public boolean equals(Object o){
        if (o == null){return false;}
        if (this == o){return true;}
        if (!(o instanceof JeuxOlympiques)){return false;}
        JeuxOlympiques jo = (JeuxOlympiques) o;
        return this.annee == jo.getAnnee() && this.lesEpreuves.equals(jo.getEpreuves());
    }

    @Override
    /**
     * Retourne une valeur de hachage pour cet objet.
     * 
     * @return un int représentant la valeur de hachage
     */
    public int hashCode(){
        return (31 * this.annee * this.lesEpreuves.size()) / 17 ;
    }

    @Override
    /**
     * Renvoie une représentation sous forme de chaîne de caractères de cet objet.
     * 
     * @return une chaîne de caractères représentant les attributs de l'objet
     */
    public String toString() {
        return "Jeux Olympique de " + this.annee;
    }

    //public void (String chemin)load_csv{
        // Chargement d'un fichier CSV où chaque ligne est une liste
        //List<List<String>> records = new ArrayList<>();
        //try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            //String line;
            //while ((line = br.readLine()) != null) {
                //String[] values = line.split(",");
                //records.add(Arrays.asList(values));
    //}
        //} catch (IOException e) {
           // System.out.println("Fichier invalide");
       //}
        // Création des instances de class
      //  for (List<String> liste : records){
      //      Sexe sexe;
     //       if (liste.get(2).equals("homme")){
      //          sexe = Sexe.HOMME;
        //    }
          //  else{
              //  sexe = Sexe.FEMME;
            //}
        //    Athlete ath = new Athlete(liste.get(0), liste.get(1), sexe, Integer.valueOf(liste.get(5)), Integer.valueOf(liste.get(6)), Integer.valueOf(liste.get(7)), 1, new Pays(liste.get(8)));
        //}
    //}

    public void load_database(){

    }

    public void save_database(){

    }
}





