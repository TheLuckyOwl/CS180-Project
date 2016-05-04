package theunderground.com.ucrmap;

/**
 * Created by Roger on 5/2/2016.
 */
public class User {
    public String doc_id;
    public String First_name;
    public String Middle_initial;
    public String Last_name;
    public String Username;
    public String Password;

    public String getDoc_id() {
        return doc_id;
    }
    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }
    public String getFirst_name() {
        return First_name;
    }
    public void setFirst_name(String firstname){
        this.First_name = firstname;
    }
    public String getMiddle_initial() {
        return Middle_initial;
    }
    public void setMiddle_initial(String mid){
        this.Middle_initial = mid;
    }
    public String getLast_name() {
        return Last_name;
    }
    public void setLast_name(String lastname) {
        this.Last_name = lastname;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        this.Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
}
