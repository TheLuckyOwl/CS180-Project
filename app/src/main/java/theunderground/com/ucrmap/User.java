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
    public String Email = "";
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
    public String[] friend1 = new String[]{"","NO"};
    public String[] friend2 = new String[]{"","NO"};
    public String[] friend3 = new String[]{"","NO"};
    public String[] friend4 = new String[]{"","NO"};
    public String[] friend5 = new String[]{"","NO"};
    public String[] friend6 = new String[]{"","NO"};
    public String[] friend7 = new String[]{"","NO"};
    public String[] friend8 = new String[]{"","NO"};
    public String[] friend9 = new String[]{"","NO"};
    public String[] friend10 = new String[]{"","NO"};

    //strings for single fields
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
    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }

    //string arrays for embeded classes
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

    //strings for embeded Friends Names
    public String getFriend1Name(){ return friend1[0]; }
    public void setFriend1Name(String name) { this.friend1[0] = name; }
    public String getFriend2Name(){ return friend2[0]; }
    public void setFriend2Name(String name) { this.friend2[0] = name; }
    public String getFriend3Name(){ return friend3[0]; }
    public void setFriend3Name(String name) { this.friend3[0] = name; }
    public String getFriend4Name(){ return friend4[0]; }
    public void setFriend4Name(String name) { this.friend4[0] = name; }
    public String getFriend5Name(){ return friend5[0]; }
    public void setFriend5Name(String name) { this.friend5[0] = name; }
    public String getFriend6Name(){ return friend6[0]; }
    public void setFriend6Name(String name) { this.friend6[0] = name; }
    public String getFriend7Name(){ return friend7[0]; }
    public void setFriend7Name(String name) { this.friend7[0] = name; }
    public String getFriend8Name(){ return friend8[0]; }
    public void setFriend8Name(String name) { this.friend8[0] = name; }
    public String getFriend9Name(){ return friend9[0]; }
    public void setFriend9Name(String name) { this.friend9[0] = name; }
    public String getFriend10Name(){ return friend10[0]; }
    public void setFriend10Name(String name) { this.friend10[0] = name; }

    //Strings for embeded Friends Access
    public String getFriend1Access() { return friend1[1]; }
    public void setFriend1Accesss(String access) { this.friend1[1] = access; }
    public String getFriend2Access() { return friend2[1]; }
    public void setFriend2Accesss(String access) { this.friend2[1] = access; }
    public String getFriend3Access() { return friend3[1]; }
    public void setFriend3Accesss(String access) { this.friend3[1] = access; }
    public String getFriend4Access() { return friend4[1]; }
    public void setFriend4Accesss(String access) { this.friend4[1] = access; }
    public String getFriend5Access() { return friend5[1]; }
    public void setFriend5Accesss(String access) { this.friend5[1] = access; }
    public String getFriend6Access() { return friend6[1]; }
    public void setFriend6Accesss(String access) { this.friend6[1] = access; }
    public String getFriend7Access() { return friend7[1]; }
    public void setFriend7Accesss(String access) { this.friend7[1] = access; }
    public String getFriend8Access() { return friend8[1]; }
    public void setFriend8Accesss(String access) { this.friend8[1] = access; }
    public String getFriend9Access() { return friend9[1]; }
    public void setFriend9Accesss(String access) { this.friend9[1] = access; }
    public String getFriend10Access() { return friend10[1]; }
    public void setFriend10Accesss(String access) { this.friend10[1] = access; }



}
