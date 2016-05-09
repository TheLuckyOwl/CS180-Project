package theunderground.com.ucrmap;

import java.io.StringBufferInputStream;

/**
 * Created by Roger on 5/2/2016. edited 5/8/2016
 */
public class User {
    public String doc_id = "";
    public String First_name = "";
    public String Middle_initial = "";
    public String Last_name = "";
    public String Username = "";
    public String Password = "";
    public String IlearnUser = "";
    public String IlearnPass = "";
    public String[] Class1  = new String[]{"", "",""};
    public String[] Class2  = new String[]{"", "",""};
    public String[] Class3  = new String[]{"", "",""};
    public String[] Class4  = new String[]{"", "",""};
    public String[] Class5  = new String[]{"", "",""};
    public String[] Class6  = new String[]{"", "",""};
    public String[] Class7  = new String[]{"", "",""};
    public String[] Class8  = new String[]{"", "",""};
    public String[] Class9  = new String[]{"", "",""};
    public String[] Class10  = new String[]{"", "",""};

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
    public String getIlearnUser() {
        return IlearnUser;
    }
    public void setIlearnUser(String ilearnUser) {
        this.IlearnUser = ilearnUser;
    }
    public String getIlearnPass() {
        return IlearnPass;
    }
    public void setIlearnPass(String ilearnPass) {
        this.IlearnPass = ilearnPass;
    }
    public String getClass1Data(){return Class1[0];}
    public void setClass1Data(String data){this.Class1[0] = data;}
    public String getClass1Day(){return Class1[1];}
    public void setClass1Day(String day){this.Class1[1] = day;}
    public String getClass1Time(){return Class1[2];}
    public void setClass1Time(String time){this.Class1[2] = time;}
    public String getClass2Data(){return Class2[0];}
    public void setClass2Data(String data){this.Class2[0] = data;}
    public String getClass2Day(){return Class2[1];}
    public void setClass2Day(String day){this.Class2[1] = day;}
    public String getClass2Time(){return Class2[2];}
    public void setClass2Time(String time){this.Class2[2] = time;}
    public String getClass3Data(){return Class3[0];}
    public void setClass3Data(String data){this.Class3[0] = data;}
    public String getClass3Day(){return Class3[1];}
    public void setClass3Day(String day){this.Class3[1] = day;}
    public String getClass3Time(){return Class3[2];}
    public void setClass3Time(String time){this.Class3[2] = time;}
    public String getClass4Data(){return Class4[0];}
    public void setClass4Data(String data){this.Class4[0] = data;}
    public String getClass4Day(){return Class4[1];}
    public void setClass4Day(String day){this.Class4[1] = day;}
    public String getClass4Time(){return Class4[2];}
    public void setClass4Time(String time){this.Class4[2] = time;}
    public String getClass5Data(){return Class5[0];}
    public void setClass5Data(String data){this.Class5[0] = data;}
    public String getClass5Day(){return Class5[1];}
    public void setClass5Day(String day){this.Class5[1] = day;}
    public String getClass5Time(){return Class5[2];}
    public void setClass5Time(String time){this.Class5[2] = time;}
    public String getClass6Data(){return Class6[0];}
    public void setClass6Data(String data){this.Class6[0] = data;}
    public String getClass6Day(){return Class6[1];}
    public void setClass6Day(String day){this.Class6[1] = day;}
    public String getClass6Time(){return Class6[2];}
    public void setClass6Time(String time){this.Class6[2] = time;}
    public String getClass7Data(){return Class7[0];}
    public void setClass7Data(String data){this.Class7[0] = data;}
    public String getClass7Day(){return Class7[1];}
    public void setClass7Day(String day){this.Class7[1] = day;}
    public String getClass7Time(){return Class7[2];}
    public void setClass7Time(String time){this.Class7[2] = time;}
    public String getClass8Data(){return Class8[0];}
    public void setClass8Data(String data){this.Class8[0] = data;}
    public String getClass8Day(){return Class8[1];}
    public void setClass8Day(String day){this.Class8[1] = day;}
    public String getClass8Time(){return Class8[2];}
    public void setClass8Time(String time){this.Class8[2] = time;}
    public String getClass9Data(){return Class9[0];}
    public void setClass9Data(String data){this.Class9[0] = data;}
    public String getClass9Day(){return Class9[1];}
    public void setClass9Day(String day){this.Class9[1] = day;}
    public String getClass9Time(){return Class9[2];}
    public void setClass9Time(String time){this.Class9[2] = time;}
    public String getClass10Data(){return Class10[0];}
    public void setClass10Data(String data){this.Class10[0] = data;}
    public String getClass10Day(){return Class10[1];}
    public void setClass10Day(String day){this.Class10[1] = day;}
    public String getClass10Time(){return Class10[2];}
    public void setClass10Time(String time){this.Class10[2] = time;}
}
