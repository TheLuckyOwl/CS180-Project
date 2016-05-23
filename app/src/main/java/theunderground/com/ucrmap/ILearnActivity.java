package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ILearnActivity extends Activity {
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilearn_activity_layout);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for(User x: returnValues)
        {
            {
                if(x.getUsername().equals(LoggedinUser))
                {
                    CurrentUser.setIlearnUser(x.getIlearnUser());
                    CurrentUser.setIlearnPass(x.getIlearnPass());
                }
            }
        }

        String url = "https://ilearn.ucr.edu/webapps/bb-auth-provider-cas-bb_bb60/execute/casLogin?cmd=login&authProviderId=_102_1&redirectUrl=https%3A%2F%2Filearn.ucr.edu%2F\"";
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.loadUrl(url);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setDomStorageEnabled(true);


        //view.setInitialScale(1);
        view.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                final String password = CurrentUser.getIlearnPass();  //TODO replace from database
                final String uname = CurrentUser.getIlearnUser();       //TODO replace from database

                view.loadUrl("javascript: {" +
                        "document.getElementById('username').value = '"+ uname +"';" +
                        "document.getElementById('password').value = '"+password+"';" +
                        "var frms = document.getElementsByName('loginForm');" +
                        "frms[0].submit(); };");
            }

        });
    }
}