package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;
import org.bson.Document;
import java.text.ParseException;
import static java.util.Arrays.asList;
import com.mongodb.client.FindIterable;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


import com.mongodb.*;

/**
 * Created by Roger on 5/1/2016.
 */
public class RegisterActivity extends Activity{
    Button bSubmit,bBack;
    EditText etFirst, etMI, etLast, etUsername, etPassword, etIlearnUser, etIlearnPass, etEmail;
    TextView tvReg, tvFName,tvInitial, tvLname, tvUser, tvPass;
    ArrayList<User> returnValues = new ArrayList<User>();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_layout);

        etFirst = (EditText)this.findViewById(R.id.etFirst);
        etMI = (EditText)this.findViewById(R.id.etMI);
        etLast = (EditText) this.findViewById(R.id.etLast);
        etUsername = (EditText) this.findViewById(R.id.etUsername);
        etPassword = (EditText) this.findViewById(R.id.etPassword);
        etIlearnUser = (EditText) this.findViewById(R.id.etIlearnUser);
        etIlearnPass = (EditText) this.findViewById(R.id.etIlearnPass);
        etEmail = (EditText) this.findViewById(R.id.etEmailReg);
        bSubmit = (Button) this.findViewById(R.id.bSubmit);
        bBack = (Button) this.findViewById(R.id.bBackReg);
        tvFName = (TextView) this.findViewById(R.id.tvF_Name);
        tvReg = (TextView) this.findViewById(R.id.tvReg);
        tvInitial = (TextView) this.findViewById(R.id.tvM_Initial);
        tvLname = (TextView) this.findViewById(R.id.tvL_Name);
        tvUser = (TextView) this.findViewById(R.id.tvUser);
        tvPass = (TextView) this.findViewById(R.id.tvPassword);

        bSubmit.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v){
                final String FirstName = etFirst.getText().toString();
                final String MiddleInitial = etMI.getText().toString();
                final String LastName = etLast.getText().toString();
                final String UserName = etUsername.getText().toString();
                final String Password = etPassword.getText().toString();
                final String IlearnUserF = etIlearnUser.getText().toString();
                final String IlearnPassF = etIlearnPass.getText().toString();
                final String EmailF = etEmail.getText().toString();

                if(UserName.length() >= 6) {
                    GetUsersAsyncTask task = new GetUsersAsyncTask();
                    try {
                        returnValues = task.execute().get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    boolean Exists = false;
                    for (User x : returnValues) {
                        if (x.getUsername().equals(UserName)) {
                            Exists = true;
                        }
                    }

                    if (Exists) {
                        Toast.makeText(RegisterActivity.this, "Username has been taken", Toast.LENGTH_LONG).show();
                    } else {
                        if (!FirstName.equals("") && !MiddleInitial.equals("") && !LastName.equals("")
                                && !UserName.equals("") && !Password.equals("") && !EmailF.equals(""))
                        {
                            User contact = new User();
                            contact.First_name = FirstName;
                            contact.Middle_initial = MiddleInitial;
                            contact.Last_name = LastName;
                            contact.Username = UserName;
                            contact.Password = Password;
                            contact.IlearnUser = IlearnUserF;
                            contact.IlearnPass = IlearnPassF;
                            contact.Email = EmailF;

                            SaveAsyncTask tsk = new SaveAsyncTask();
                            tsk.execute(contact);
                            Toast.makeText(RegisterActivity.this, "Registered Successfully. Returning to Login", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            RegisterActivity.this.startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "Please fill in all required fields", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else
                {
                    if(UserName.length() < 6) {
                        Toast.makeText(RegisterActivity.this, "Invalid Username", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                RegisterActivity.this.startActivity(i);
            }
        });
    }
}


