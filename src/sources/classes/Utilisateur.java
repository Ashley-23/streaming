package sources.classes;


import java.util.Date;

public class Utilisateur {
    public String login;
    public String email;
    public String rib;
    public String mot_de_passe;
    public Date dateNaiss;

//    GETTERS


    public String getLogin() {
        return login;
    }

    public String getEmail(){
        return email;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getRib() {
        return rib;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

//    SETTERS

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDateNaiss(Date dateNaiss){
        this.dateNaiss = dateNaiss;
    }

    public void setRib(String rib){
        this.rib = rib;
    }

    public void setMot_de_passe(String mot_de_passe){
        this.mot_de_passe = mot_de_passe;
    }
}