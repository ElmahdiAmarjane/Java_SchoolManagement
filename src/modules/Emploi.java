package modules;

import java.time.LocalDate;
import java.util.List;

public class Emploi {

    private int id;
    private LocalDate date;
    private String cni_user;
    private String filier_titel;
    private String jour;

    // Lundi
    private List<String> H_8_10_element_lundi;
    private List<String> H_8_10_prof_lundi;
    private List<String> H_8_10_salle_lundi;

    private List<String> H_10_12_element_lundi;
    private List<String> H_10_12_prof_lundi;
    private List<String> H_10_12_salle_lundi;

    private List<String> H_2_4_element_lundi;
    private List<String> H_2_4_prof_lundi;
    private List<String> H_2_4_salle_lundi;

    private List<String> H_4_6_element_lundi;
    private List<String> H_4_6_prof_lundi;
    private List<String> H_4_6_salle_lundi;

    // Mardi
    private List<String> H_8_10_element_mardi;
    private List<String> H_8_10_prof_mardi;
    private List<String> H_8_10_salle_mardi;

    private List<String> H_10_12_element_mardi;
    private List<String> H_10_12_prof_mardi;
    private List<String> H_10_12_salle_mardi;

    private List<String> H_2_4_element_mardi;
    private List<String> H_2_4_prof_mardi;
    private List<String> H_2_4_salle_mardi;

    private List<String> H_4_6_element_mardi;
    private List<String> H_4_6_prof_mardi;
    private List<String> H_4_6_salle_mardi;

    // Mercredi
    private List<String> H_8_10_element_mercredi;
    private List<String> H_8_10_prof_mercredi;
    private List<String> H_8_10_salle_mercredi;

    private List<String> H_10_12_element_mercredi;
    private List<String> H_10_12_prof_mercredi;
    private List<String> H_10_12_salle_mercredi;

    private List<String> H_2_4_element_mercredi;
    private List<String> H_2_4_prof_mercredi;
    private List<String> H_2_4_salle_mercredi;

    private List<String> H_4_6_element_mercredi;
    private List<String> H_4_6_prof_mercredi;
    private List<String> H_4_6_salle_mercredi;

    // Jeudi
    private List<String> H_8_10_element_jeudi;
    private List<String> H_8_10_prof_jeudi;
    private List<String> H_8_10_salle_jeudi;

    private List<String> H_10_12_element_jeudi;
    private List<String> H_10_12_prof_jeudi;
    private List<String> H_10_12_salle_jeudi;

    private List<String> H_2_4_element_jeudi;
    private List<String> H_2_4_prof_jeudi;
    private List<String> H_2_4_salle_jeudi;

    private List<String> H_4_6_element_jeudi;
    private List<String> H_4_6_prof_jeudi;
    private List<String> H_4_6_salle_jeudi;

    // Vendredi
    private List<String> H_8_10_element_vendredi;
    private List<String> H_8_10_prof_vendredi;
    private List<String> H_8_10_salle_vendredi;

    private List<String> H_10_12_element_vendredi;
    private List<String> H_10_12_prof_vendredi;
    private List<String> H_10_12_salle_vendredi;

    private List<String> H_2_4_element_vendredi;
    private List<String> H_2_4_prof_vendredi;
    private List<String> H_2_4_salle_vendredi;

    private List<String> H_4_6_element_vendredi;
    private List<String> H_4_6_prof_vendredi;
    private List<String> H_4_6_salle_vendredi;

    public Emploi() {}

    // Générer les getters et setters pour tous les champs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCni_user() {
        return cni_user;
    }

    public void setCni_user(String cni_user) {
        this.cni_user = cni_user;
    }

    public String getFilier_titel() {
        return filier_titel;
    }

    public void setFilier_titel(String filier_titel) {
        this.filier_titel = filier_titel;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

	public List<String> getH_8_10_element_lundi() {
		return H_8_10_element_lundi;
	}

	public void setH_8_10_element_lundi(List<String> h_8_10_element_lundi) {
		H_8_10_element_lundi = h_8_10_element_lundi;
	}

	public List<String> getH_8_10_prof_lundi() {
		return H_8_10_prof_lundi;
	}

	public void setH_8_10_prof_lundi(List<String> h_8_10_prof_lundi) {
		H_8_10_prof_lundi = h_8_10_prof_lundi;
	}

	public List<String> getH_8_10_salle_lundi() {
		return H_8_10_salle_lundi;
	}

	public void setH_8_10_salle_lundi(List<String> h_8_10_salle_lundi) {
		H_8_10_salle_lundi = h_8_10_salle_lundi;
	}

	public List<String> getH_10_12_element_lundi() {
		return H_10_12_element_lundi;
	}

	public void setH_10_12_element_lundi(List<String> h_10_12_element_lundi) {
		H_10_12_element_lundi = h_10_12_element_lundi;
	}

	public List<String> getH_10_12_prof_lundi() {
		return H_10_12_prof_lundi;
	}

	public void setH_10_12_prof_lundi(List<String> h_10_12_prof_lundi) {
		H_10_12_prof_lundi = h_10_12_prof_lundi;
	}

	public List<String> getH_10_12_salle_lundi() {
		return H_10_12_salle_lundi;
	}

	public void setH_10_12_salle_lundi(List<String> h_10_12_salle_lundi) {
		H_10_12_salle_lundi = h_10_12_salle_lundi;
	}

	public List<String> getH_2_4_element_lundi() {
		return H_2_4_element_lundi;
	}

	public void setH_2_4_element_lundi(List<String> h_2_4_element_lundi) {
		H_2_4_element_lundi = h_2_4_element_lundi;
	}

	public List<String> getH_2_4_prof_lundi() {
		return H_2_4_prof_lundi;
	}

	public void setH_2_4_prof_lundi(List<String> h_2_4_prof_lundi) {
		H_2_4_prof_lundi = h_2_4_prof_lundi;
	}

	public List<String> getH_2_4_salle_lundi() {
		return H_2_4_salle_lundi;
	}

	public void setH_2_4_salle_lundi(List<String> h_2_4_salle_lundi) {
		H_2_4_salle_lundi = h_2_4_salle_lundi;
	}

	public List<String> getH_4_6_element_lundi() {
		return H_4_6_element_lundi;
	}

	public void setH_4_6_element_lundi(List<String> h_4_6_element_lundi) {
		H_4_6_element_lundi = h_4_6_element_lundi;
	}

	public List<String> getH_4_6_prof_lundi() {
		return H_4_6_prof_lundi;
	}

	public void setH_4_6_prof_lundi(List<String> h_4_6_prof_lundi) {
		H_4_6_prof_lundi = h_4_6_prof_lundi;
	}

	public List<String> getH_4_6_salle_lundi() {
		return H_4_6_salle_lundi;
	}

	public void setH_4_6_salle_lundi(List<String> h_4_6_salle_lundi) {
		H_4_6_salle_lundi = h_4_6_salle_lundi;
	}

	public List<String> getH_8_10_element_mardi() {
		return H_8_10_element_mardi;
	}

	public void setH_8_10_element_mardi(List<String> h_8_10_element_mardi) {
		H_8_10_element_mardi = h_8_10_element_mardi;
	}

	public List<String> getH_8_10_prof_mardi() {
		return H_8_10_prof_mardi;
	}

	public void setH_8_10_prof_mardi(List<String> h_8_10_prof_mardi) {
		H_8_10_prof_mardi = h_8_10_prof_mardi;
	}

	public List<String> getH_8_10_salle_mardi() {
		return H_8_10_salle_mardi;
	}

	public void setH_8_10_salle_mardi(List<String> h_8_10_salle_mardi) {
		H_8_10_salle_mardi = h_8_10_salle_mardi;
	}

	public List<String> getH_10_12_element_mardi() {
		return H_10_12_element_mardi;
	}

	public void setH_10_12_element_mardi(List<String> h_10_12_element_mardi) {
		H_10_12_element_mardi = h_10_12_element_mardi;
	}

	public List<String> getH_10_12_prof_mardi() {
		return H_10_12_prof_mardi;
	}

	public void setH_10_12_prof_mardi(List<String> h_10_12_prof_mardi) {
		H_10_12_prof_mardi = h_10_12_prof_mardi;
	}

	public List<String> getH_10_12_salle_mardi() {
		return H_10_12_salle_mardi;
	}

	public void setH_10_12_salle_mardi(List<String> h_10_12_salle_mardi) {
		H_10_12_salle_mardi = h_10_12_salle_mardi;
	}

	public List<String> getH_2_4_element_mardi() {
		return H_2_4_element_mardi;
	}

	public void setH_2_4_element_mardi(List<String> h_2_4_element_mardi) {
		H_2_4_element_mardi = h_2_4_element_mardi;
	}

	public List<String> getH_2_4_prof_mardi() {
		return H_2_4_prof_mardi;
	}

	public void setH_2_4_prof_mardi(List<String> h_2_4_prof_mardi) {
		H_2_4_prof_mardi = h_2_4_prof_mardi;
	}

	public List<String> getH_2_4_salle_mardi() {
		return H_2_4_salle_mardi;
	}

	public void setH_2_4_salle_mardi(List<String> h_2_4_salle_mardi) {
		H_2_4_salle_mardi = h_2_4_salle_mardi;
	}

	public List<String> getH_4_6_element_mardi() {
		return H_4_6_element_mardi;
	}

	public void setH_4_6_element_mardi(List<String> h_4_6_element_mardi) {
		H_4_6_element_mardi = h_4_6_element_mardi;
	}

	public List<String> getH_4_6_prof_mardi() {
		return H_4_6_prof_mardi;
	}

	public void setH_4_6_prof_mardi(List<String> h_4_6_prof_mardi) {
		H_4_6_prof_mardi = h_4_6_prof_mardi;
	}

	public List<String> getH_4_6_salle_mardi() {
		return H_4_6_salle_mardi;
	}

	public void setH_4_6_salle_mardi(List<String> h_4_6_salle_mardi) {
		H_4_6_salle_mardi = h_4_6_salle_mardi;
	}

	public List<String> getH_8_10_element_mercredi() {
		return H_8_10_element_mercredi;
	}

	public void setH_8_10_element_mercredi(List<String> h_8_10_element_mercredi) {
		H_8_10_element_mercredi = h_8_10_element_mercredi;
	}

	public List<String> getH_8_10_prof_mercredi() {
		return H_8_10_prof_mercredi;
	}

	public void setH_8_10_prof_mercredi(List<String> h_8_10_prof_mercredi) {
		H_8_10_prof_mercredi = h_8_10_prof_mercredi;
	}

	public List<String> getH_8_10_salle_mercredi() {
		return H_8_10_salle_mercredi;
	}

	public void setH_8_10_salle_mercredi(List<String> h_8_10_salle_mercredi) {
		H_8_10_salle_mercredi = h_8_10_salle_mercredi;
	}

	public List<String> getH_10_12_element_mercredi() {
		return H_10_12_element_mercredi;
	}

	public void setH_10_12_element_mercredi(List<String> h_10_12_element_mercredi) {
		H_10_12_element_mercredi = h_10_12_element_mercredi;
	}

	public List<String> getH_10_12_prof_mercredi() {
		return H_10_12_prof_mercredi;
	}

	public void setH_10_12_prof_mercredi(List<String> h_10_12_prof_mercredi) {
		H_10_12_prof_mercredi = h_10_12_prof_mercredi;
	}

	public List<String> getH_10_12_salle_mercredi() {
		return H_10_12_salle_mercredi;
	}

	public void setH_10_12_salle_mercredi(List<String> h_10_12_salle_mercredi) {
		H_10_12_salle_mercredi = h_10_12_salle_mercredi;
	}

	public List<String> getH_2_4_element_mercredi() {
		return H_2_4_element_mercredi;
	}

	public void setH_2_4_element_mercredi(List<String> h_2_4_element_mercredi) {
		H_2_4_element_mercredi = h_2_4_element_mercredi;
	}

	public List<String> getH_2_4_prof_mercredi() {
		return H_2_4_prof_mercredi;
	}

	public void setH_2_4_prof_mercredi(List<String> h_2_4_prof_mercredi) {
		H_2_4_prof_mercredi = h_2_4_prof_mercredi;
	}

	public List<String> getH_2_4_salle_mercredi() {
		return H_2_4_salle_mercredi;
	}

	public void setH_2_4_salle_mercredi(List<String> h_2_4_salle_mercredi) {
		H_2_4_salle_mercredi = h_2_4_salle_mercredi;
	}

	public List<String> getH_4_6_element_mercredi() {
		return H_4_6_element_mercredi;
	}

	public void setH_4_6_element_mercredi(List<String> h_4_6_element_mercredi) {
		H_4_6_element_mercredi = h_4_6_element_mercredi;
	}

	public List<String> getH_4_6_prof_mercredi() {
		return H_4_6_prof_mercredi;
	}

	public void setH_4_6_prof_mercredi(List<String> h_4_6_prof_mercredi) {
		H_4_6_prof_mercredi = h_4_6_prof_mercredi;
	}

	public List<String> getH_4_6_salle_mercredi() {
		return H_4_6_salle_mercredi;
	}

	public void setH_4_6_salle_mercredi(List<String> h_4_6_salle_mercredi) {
		H_4_6_salle_mercredi = h_4_6_salle_mercredi;
	}

	public List<String> getH_8_10_element_jeudi() {
		return H_8_10_element_jeudi;
	}

	public void setH_8_10_element_jeudi(List<String> h_8_10_element_jeudi) {
		H_8_10_element_jeudi = h_8_10_element_jeudi;
	}

	public List<String> getH_8_10_prof_jeudi() {
		return H_8_10_prof_jeudi;
	}

	public void setH_8_10_prof_jeudi(List<String> h_8_10_prof_jeudi) {
		H_8_10_prof_jeudi = h_8_10_prof_jeudi;
	}

	public List<String> getH_8_10_salle_jeudi() {
		return H_8_10_salle_jeudi;
	}

	public void setH_8_10_salle_jeudi(List<String> h_8_10_salle_jeudi) {
		H_8_10_salle_jeudi = h_8_10_salle_jeudi;
	}

	public List<String> getH_10_12_element_jeudi() {
		return H_10_12_element_jeudi;
	}

	public void setH_10_12_element_jeudi(List<String> h_10_12_element_jeudi) {
		H_10_12_element_jeudi = h_10_12_element_jeudi;
	}

	public List<String> getH_10_12_prof_jeudi() {
		return H_10_12_prof_jeudi;
	}

	public void setH_10_12_prof_jeudi(List<String> h_10_12_prof_jeudi) {
		H_10_12_prof_jeudi = h_10_12_prof_jeudi;
	}

	public List<String> getH_10_12_salle_jeudi() {
		return H_10_12_salle_jeudi;
	}

	public void setH_10_12_salle_jeudi(List<String> h_10_12_salle_jeudi) {
		H_10_12_salle_jeudi = h_10_12_salle_jeudi;
	}

	public List<String> getH_2_4_element_jeudi() {
		return H_2_4_element_jeudi;
	}

	public void setH_2_4_element_jeudi(List<String> h_2_4_element_jeudi) {
		H_2_4_element_jeudi = h_2_4_element_jeudi;
	}

	public List<String> getH_2_4_prof_jeudi() {
		return H_2_4_prof_jeudi;
	}

	public void setH_2_4_prof_jeudi(List<String> h_2_4_prof_jeudi) {
		H_2_4_prof_jeudi = h_2_4_prof_jeudi;
	}

	public List<String> getH_2_4_salle_jeudi() {
		return H_2_4_salle_jeudi;
	}

	public void setH_2_4_salle_jeudi(List<String> h_2_4_salle_jeudi) {
		H_2_4_salle_jeudi = h_2_4_salle_jeudi;
	}

	public List<String> getH_4_6_element_jeudi() {
		return H_4_6_element_jeudi;
	}

	public void setH_4_6_element_jeudi(List<String> h_4_6_element_jeudi) {
		H_4_6_element_jeudi = h_4_6_element_jeudi;
	}

	public List<String> getH_4_6_prof_jeudi() {
		return H_4_6_prof_jeudi;
	}

	public void setH_4_6_prof_jeudi(List<String> h_4_6_prof_jeudi) {
		H_4_6_prof_jeudi = h_4_6_prof_jeudi;
	}

	public List<String> getH_4_6_salle_jeudi() {
		return H_4_6_salle_jeudi;
	}

	public void setH_4_6_salle_jeudi(List<String> h_4_6_salle_jeudi) {
		H_4_6_salle_jeudi = h_4_6_salle_jeudi;
	}

	public List<String> getH_8_10_element_vendredi() {
		return H_8_10_element_vendredi;
	}

	public void setH_8_10_element_vendredi(List<String> h_8_10_element_vendredi) {
		H_8_10_element_vendredi = h_8_10_element_vendredi;
	}

	public List<String> getH_8_10_prof_vendredi() {
		return H_8_10_prof_vendredi;
	}

	public void setH_8_10_prof_vendredi(List<String> h_8_10_prof_vendredi) {
		H_8_10_prof_vendredi = h_8_10_prof_vendredi;
	}

	public List<String> getH_8_10_salle_vendredi() {
		return H_8_10_salle_vendredi;
	}

	public void setH_8_10_salle_vendredi(List<String> h_8_10_salle_vendredi) {
		H_8_10_salle_vendredi = h_8_10_salle_vendredi;
	}

	public List<String> getH_10_12_element_vendredi() {
		return H_10_12_element_vendredi;
	}

	public void setH_10_12_element_vendredi(List<String> h_10_12_element_vendredi) {
		H_10_12_element_vendredi = h_10_12_element_vendredi;
	}

	public List<String> getH_10_12_prof_vendredi() {
		return H_10_12_prof_vendredi;
	}

	public void setH_10_12_prof_vendredi(List<String> h_10_12_prof_vendredi) {
		H_10_12_prof_vendredi = h_10_12_prof_vendredi;
	}

	public List<String> getH_10_12_salle_vendredi() {
		return H_10_12_salle_vendredi;
	}

	public void setH_10_12_salle_vendredi(List<String> h_10_12_salle_vendredi) {
		H_10_12_salle_vendredi = h_10_12_salle_vendredi;
	}

	public List<String> getH_2_4_element_vendredi() {
		return H_2_4_element_vendredi;
	}

	public void setH_2_4_element_vendredi(List<String> h_2_4_element_vendredi) {
		H_2_4_element_vendredi = h_2_4_element_vendredi;
	}

	public List<String> getH_2_4_prof_vendredi() {
		return H_2_4_prof_vendredi;
	}

	public void setH_2_4_prof_vendredi(List<String> h_2_4_prof_vendredi) {
		H_2_4_prof_vendredi = h_2_4_prof_vendredi;
	}

	public List<String> getH_2_4_salle_vendredi() {
		return H_2_4_salle_vendredi;
	}

	public void setH_2_4_salle_vendredi(List<String> h_2_4_salle_vendredi) {
		H_2_4_salle_vendredi = h_2_4_salle_vendredi;
	}

	public List<String> getH_4_6_element_vendredi() {
		return H_4_6_element_vendredi;
	}

	public void setH_4_6_element_vendredi(List<String> h_4_6_element_vendredi) {
		H_4_6_element_vendredi = h_4_6_element_vendredi;
	}

	public List<String> getH_4_6_prof_vendredi() {
		return H_4_6_prof_vendredi;
	}

	public void setH_4_6_prof_vendredi(List<String> h_4_6_prof_vendredi) {
		H_4_6_prof_vendredi = h_4_6_prof_vendredi;
	}

	public List<String> getH_4_6_salle_vendredi() {
		return H_4_6_salle_vendredi;
	}

	public void setH_4_6_salle_vendredi(List<String> h_4_6_salle_vendredi) {
		H_4_6_salle_vendredi = h_4_6_salle_vendredi;
	}

    
}
