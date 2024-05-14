package sources.classes;


import java.util.Date;

public class Utilisateur {
    public String email;
    public String rib;
    public Date dateNaiss;

//    GETTERS

    public String getEmail(){
        return email;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getRib() {
        return rib;
    }

//    SETTERS

    public void setEmail(String email){
        this.email = email;
    }

    public void setDateNaiss(Date dateNaiss){
        this.dateNaiss = dateNaiss;
    }

    public void setRib(String rib){
        this.rib = rib;
    }
}