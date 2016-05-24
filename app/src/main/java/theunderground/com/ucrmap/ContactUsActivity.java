package theunderground.com.ucrmap;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ContactUsActivity extends Activity {
    SharedPreferences prefs = null;
    TextView mEmail = null;
    TextView mLogOut = null;
    private Button Change = null;
    private Button BackButton = null;
    private Switch NotSwitch = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    AlarmManager alarm_manager = null;
    AlarmManager[]  amArray = new AlarmManager[30];
    ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();
    ArrayList<Calendar> CalArray = new ArrayList<Calendar>();
    ArrayList<User> returnValues = new ArrayList<User>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.contact_us_activity_layout);

        mEmail = (TextView)findViewById(R.id.emailLink);
        mLogOut = (TextView)findViewById(R.id.logOutText);
        Change = (Button) findViewById(R.id.bChange);
        BackButton = (Button) findViewById(R.id.bBackSet);
        NotSwitch = (Switch) findViewById(R.id.swNot);
        //alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //intent Receiver
        final Intent intent1 = new Intent(ContactUsActivity.this, AlarmReceiver.class);
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
                    CurrentUser.setClass1Time(x.getClass1Time());
                    CurrentUser.setClass1Day(x.getClass1Day());
                    CurrentUser.setClass2Time(x.getClass2Time());
                    CurrentUser.setClass2Day(x.getClass2Day());
                    CurrentUser.setClass3Time(x.getClass3Time());
                    CurrentUser.setClass3Day(x.getClass3Day());
                    CurrentUser.setClass4Time(x.getClass4Time());
                    CurrentUser.setClass4Day(x.getClass4Day());
                    CurrentUser.setClass5Time(x.getClass5Time());
                    CurrentUser.setClass5Day(x.getClass5Day());
                    CurrentUser.setClass6Time(x.getClass6Time());
                    CurrentUser.setClass6Day(x.getClass6Day());
                    CurrentUser.setClass7Time(x.getClass7Time());
                    CurrentUser.setClass7Day(x.getClass7Day());
                    CurrentUser.setClass8Time(x.getClass8Time());
                    CurrentUser.setClass8Day(x.getClass8Day());
                    CurrentUser.setClass9Time(x.getClass9Time());
                    CurrentUser.setClass9Day(x.getClass9Day());
                    CurrentUser.setClass10Time(x.getClass10Time());
                    CurrentUser.setClass10Day(x.getClass10Day());
                }
            }
        }

        String class1 = CurrentUser.getClass1Time();
        String class2 = CurrentUser.getClass2Time();
        String class3 = CurrentUser.getClass3Time();
        String class4 = CurrentUser.getClass4Time();
        String class5 = CurrentUser.getClass5Time();
        String class6 = CurrentUser.getClass6Time();
        String class7 = CurrentUser.getClass7Time();
        String class8 = CurrentUser.getClass8Time();
        String class9 = CurrentUser.getClass9Time();
        String class10 = CurrentUser.getClass10Time();
        final String[] tokenClass1 = class1.split("[ :-]");
        final String[] tokenClass2 = class2.split("[ :-]");
        final String[] tokenClass3 = class3.split("[ :-]");
        final String[] tokenClass4 = class4.split("[ :-]");
        final String[] tokenClass5 = class5.split("[ :-]");
        final String[] tokenClass6 = class6.split("[ :-]");
        final String[] tokenClass7 = class7.split("[ :-]");
        final String[] tokenClass8 = class8.split("[ :-]");
        final String[] tokenClass9 = class9.split("[ :-]");
        final String[] tokenClass10 = class10.split("[ :-]");
        final Calendar calendarTrial = Calendar.getInstance();

        if(!class1.equals(""))
        {
            int class1hr = Integer.parseInt(tokenClass1[0]);
            int class1min = Integer.parseInt(tokenClass1[1]);
            if(!tokenClass1[0].equals("11") && !tokenClass1[0].equals("12") && tokenClass1[4].equals("pm"))
            {
                class1hr = class1hr + 12;
            }
            else if(tokenClass1[0].equals("11") && tokenClass1[4].equals("pm"))
            {
                class1hr = 11;
            }
            else if(tokenClass1[0].equals("11") && tokenClass1[4].equals("am"))
            {
                class1hr = 23;
            }
            else if(tokenClass1[0].equals("12") && tokenClass1[4].equals("am"))
            {
                class1hr = 0;
            }
            else if(tokenClass1[0].equals("12") && tokenClass1[4].equals("pm"))
            {
                class1hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass1Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass1Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class1hr);
                    tmp.set(Calendar.MINUTE, class1min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass1Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class1hr);
                    tmp.set(Calendar.MINUTE, class1min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass1Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class1hr);
                    tmp.set(Calendar.MINUTE, class1min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass1Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class1hr);
                    tmp.set(Calendar.MINUTE, class1min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass1Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class1hr);
                    tmp.set(Calendar.MINUTE, class1min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class2.equals(""))
        {
            int class2hr = Integer.parseInt(tokenClass2[0]);
            int class2min = Integer.parseInt(tokenClass2[1]);
            if(!tokenClass2[0].equals("11") && !tokenClass2[0].equals("12") && tokenClass2[4].equals("pm"))
            {
                class2hr = class2hr + 12;
            }
            else if(tokenClass2[0].equals("11") && tokenClass2[4].equals("pm"))
            {
                class2hr = 11;
            }
            else if(tokenClass2[0].equals("11") && tokenClass2[4].equals("am"))
            {
                class2hr = 23;
            }
            else if(tokenClass2[0].equals("12") && tokenClass2[4].equals("am"))
            {
                class2hr = 0;
            }
            else if(tokenClass2[0].equals("12") && tokenClass2[4].equals("pm"))
            {
                class2hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass2Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass2Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class2hr);
                    tmp.set(Calendar.MINUTE, class2min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass2Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class2hr);
                    tmp.set(Calendar.MINUTE, class2min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass2Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class2hr);
                    tmp.set(Calendar.MINUTE, class2min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass2Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class2hr);
                    tmp.set(Calendar.MINUTE, class2min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass2Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class2hr);
                    tmp.set(Calendar.MINUTE, class2min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class3.equals(""))
        {
            int class3hr = Integer.parseInt(tokenClass3[0]);
            int class3min = Integer.parseInt(tokenClass3[1]);
            if(!tokenClass3[0].equals("11") && !tokenClass3[0].equals("12") && tokenClass3[4].equals("pm"))
            {
                class3hr = class3hr + 12;
            }
            else if(tokenClass3[0].equals("11") && tokenClass3[4].equals("pm"))
            {
                class3hr = 11;
            }
            else if(tokenClass3[0].equals("11") && tokenClass3[4].equals("am"))
            {
                class3hr = 23;
            }
            else if(tokenClass3[0].equals("12") && tokenClass3[4].equals("am"))
            {
                class3hr = 0;
            }
            else if(tokenClass3[0].equals("12") && tokenClass3[4].equals("pm"))
            {
                class3hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass3Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass3Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class3hr);
                    tmp.set(Calendar.MINUTE, class3min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass3Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class3hr);
                    tmp.set(Calendar.MINUTE, class3min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass3Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class3hr);
                    tmp.set(Calendar.MINUTE, class3min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass3Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class3hr);
                    tmp.set(Calendar.MINUTE, class3min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass3Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class3hr);
                    tmp.set(Calendar.MINUTE, class3min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class4.equals(""))
        {
            int class4hr = Integer.parseInt(tokenClass4[0]);
            int class4min = Integer.parseInt(tokenClass4[1]);
            if(!tokenClass4[0].equals("11") && !tokenClass4[0].equals("12") && tokenClass4[4].equals("pm"))
            {
                class4hr = class4hr + 12;
            }
            else if(tokenClass4[0].equals("11") && tokenClass4[4].equals("pm"))
            {
                class4hr = 11;
            }
            else if(tokenClass4[0].equals("11") && tokenClass4[4].equals("am"))
            {
                class4hr = 23;
            }
            else if(tokenClass4[0].equals("12") && tokenClass4[4].equals("am"))
            {
                class4hr = 0;
            }
            else if(tokenClass4[0].equals("12") && tokenClass4[4].equals("pm"))
            {
                class4hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass4Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass4Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class4hr);
                    tmp.set(Calendar.MINUTE, class4min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass4Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class4hr);
                    tmp.set(Calendar.MINUTE, class4min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass4Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class4hr);
                    tmp.set(Calendar.MINUTE, class4min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass4Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class4hr);
                    tmp.set(Calendar.MINUTE, class4min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass4Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class4hr);
                    tmp.set(Calendar.MINUTE, class4min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class5.equals(""))
        {
            int class5hr = Integer.parseInt(tokenClass5[0]);
            int class5min = Integer.parseInt(tokenClass5[1]);
            if(!tokenClass5[0].equals("11") && !tokenClass5[0].equals("12") && tokenClass5[4].equals("pm"))
            {
                class5hr = class5hr + 12;
            }
            else if(tokenClass5[0].equals("11") && tokenClass5[4].equals("pm"))
            {
                class5hr = 11;
            }
            else if(tokenClass5[0].equals("11") && tokenClass5[4].equals("am"))
            {
                class5hr = 23;
            }
            else if(tokenClass5[0].equals("12") && tokenClass5[4].equals("am"))
            {
                class5hr = 0;
            }
            else if(tokenClass5[0].equals("12") && tokenClass5[4].equals("pm"))
            {
                class5hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass5Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass5Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class5hr);
                    tmp.set(Calendar.MINUTE, class5min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass5Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class5hr);
                    tmp.set(Calendar.MINUTE, class5min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass5Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class5hr);
                    tmp.set(Calendar.MINUTE, class5min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass5Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class5hr);
                    tmp.set(Calendar.MINUTE, class5min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass5Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class5hr);
                    tmp.set(Calendar.MINUTE, class5min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class6.equals(""))
        {
            int class6hr = Integer.parseInt(tokenClass6[0]);
            int class6min = Integer.parseInt(tokenClass6[1]);
            if(!tokenClass6[0].equals("11") && !tokenClass6[0].equals("12") && tokenClass6[4].equals("pm"))
            {
                class6hr = class6hr + 12;
            }
            else if(tokenClass6[0].equals("11") && tokenClass6[4].equals("pm"))
            {
                class6hr = 11;
            }
            else if(tokenClass6[0].equals("11") && tokenClass6[4].equals("am"))
            {
                class6hr = 23;
            }
            else if(tokenClass6[0].equals("12") && tokenClass6[4].equals("am"))
            {
                class6hr = 0;
            }
            else if(tokenClass6[0].equals("12") && tokenClass6[4].equals("pm"))
            {
                class6hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass6Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass6Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class6hr);
                    tmp.set(Calendar.MINUTE, class6min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass6Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class6hr);
                    tmp.set(Calendar.MINUTE, class6min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass6Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class6hr);
                    tmp.set(Calendar.MINUTE, class6min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass6Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class6hr);
                    tmp.set(Calendar.MINUTE, class6min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass6Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class6hr);
                    tmp.set(Calendar.MINUTE, class6min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class7.equals(""))
        {
            int class7hr = Integer.parseInt(tokenClass7[0]);
            int class7min = Integer.parseInt(tokenClass7[1]);
            if(!tokenClass7[0].equals("11") && !tokenClass7[0].equals("12") && tokenClass7[4].equals("pm"))
            {
                class7hr = class7hr + 12;
            }
            else if(tokenClass7[0].equals("11") && tokenClass7[4].equals("pm"))
            {
                class7hr = 11;
            }
            else if(tokenClass7[0].equals("11") && tokenClass7[4].equals("am"))
            {
                class7hr = 23;
            }
            else if(tokenClass7[0].equals("12") && tokenClass7[4].equals("am"))
            {
                class7hr = 0;
            }
            else if(tokenClass7[0].equals("12") && tokenClass7[4].equals("pm"))
            {
                class7hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass7Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass7Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class7hr);
                    tmp.set(Calendar.MINUTE, class7min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass7Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class7hr);
                    tmp.set(Calendar.MINUTE, class7min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass7Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class7hr);
                    tmp.set(Calendar.MINUTE, class7min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass7Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class7hr);
                    tmp.set(Calendar.MINUTE, class7min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass7Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class7hr);
                    tmp.set(Calendar.MINUTE, class7min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class8.equals(""))
        {
            int class8hr = Integer.parseInt(tokenClass8[0]);
            int class8min = Integer.parseInt(tokenClass8[1]);
            if(!tokenClass8[0].equals("11") && !tokenClass8[0].equals("12") && tokenClass8[4].equals("pm"))
            {
                class8hr = class8hr + 12;
            }
            else if(tokenClass8[0].equals("11") && tokenClass8[4].equals("pm"))
            {
                class8hr = 11;
            }
            else if(tokenClass8[0].equals("11") && tokenClass8[4].equals("am"))
            {
                class8hr = 23;
            }
            else if(tokenClass8[0].equals("12") && tokenClass8[4].equals("am"))
            {
                class8hr = 0;
            }
            else if(tokenClass8[0].equals("12") && tokenClass8[4].equals("pm"))
            {
                class8hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass8Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass8Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class8hr);
                    tmp.set(Calendar.MINUTE, class8min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass8Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class8hr);
                    tmp.set(Calendar.MINUTE, class8min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass8Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class8hr);
                    tmp.set(Calendar.MINUTE, class8min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass8Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class8hr);
                    tmp.set(Calendar.MINUTE, class8min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass8Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class8hr);
                    tmp.set(Calendar.MINUTE, class8min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class9.equals(""))
        {
            int class9hr = Integer.parseInt(tokenClass9[0]);
            int class9min = Integer.parseInt(tokenClass9[1]);
            if(!tokenClass9[0].equals("11") && !tokenClass9[0].equals("12") && tokenClass9[4].equals("pm"))
            {
                class9hr = class9hr + 12;
            }
            else if(tokenClass9[0].equals("11") && tokenClass9[4].equals("pm"))
            {
                class9hr = 11;
            }
            else if(tokenClass9[0].equals("11") && tokenClass9[4].equals("am"))
            {
                class9hr = 23;
            }
            else if(tokenClass9[0].equals("12") && tokenClass9[4].equals("am"))
            {
                class9hr = 0;
            }
            else if(tokenClass9[0].equals("12") && tokenClass9[4].equals("pm"))
            {
                class9hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass9Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass9Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class9hr);
                    tmp.set(Calendar.MINUTE, class9min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass9Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class9hr);
                    tmp.set(Calendar.MINUTE, class9min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass9Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class9hr);
                    tmp.set(Calendar.MINUTE, class9min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass9Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class9hr);
                    tmp.set(Calendar.MINUTE, class9min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass9Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class9hr);
                    tmp.set(Calendar.MINUTE, class9min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }
        if(!class10.equals(""))
        {
            int class10hr = Integer.parseInt(tokenClass10[0]);
            int class10min = Integer.parseInt(tokenClass10[1]);
            if(!tokenClass10[0].equals("11") && !tokenClass10[0].equals("12") && tokenClass10[4].equals("pm"))
            {
                class10hr = class10hr + 12;
            }
            else if(tokenClass10[0].equals("11") && tokenClass10[4].equals("pm"))
            {
                class10hr = 11;
            }
            else if(tokenClass10[0].equals("11") && tokenClass10[4].equals("am"))
            {
                class10hr = 23;
            }
            else if(tokenClass10[0].equals("12") && tokenClass10[4].equals("am"))
            {
                class10hr = 0;
            }
            else if(tokenClass10[0].equals("12") && tokenClass10[4].equals("pm"))
            {
                class10hr = 12;
            }
            for( int i = 0; i < CurrentUser.getClass1Day().length(); ++i)
            {
                Calendar tmp = Calendar.getInstance();
                if(CurrentUser.getClass10Day().charAt(i) == 'M')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class10hr);
                    tmp.set(Calendar.MINUTE, class10min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass10Day().charAt(i) == 'T')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class10hr);
                    tmp.set(Calendar.MINUTE, class10min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass10Day().charAt(i) == 'W')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class10hr);
                    tmp.set(Calendar.MINUTE, class10min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass10Day().charAt(i) == 'R')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class10hr);
                    tmp.set(Calendar.MINUTE, class10min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
                else if(CurrentUser.getClass10Day().charAt(i) == 'F')
                {
                    tmp.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                    tmp.set(Calendar.HOUR_OF_DAY, class10hr);
                    tmp.set(Calendar.MINUTE, class10min);
                    tmp.set(Calendar.MILLISECOND, 0);

                    CalArray.add(tmp);
                }
            }

        }

        NotSwitch.setChecked(true);
        NotSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(ContactUsActivity.this, "Notifications On", Toast.LENGTH_SHORT).show();
                    for(int i = 0; i < CalArray.size() ; ++i)
                    {
                        PendingIntent pi = PendingIntent.getBroadcast(ContactUsActivity.this, i, intent1, 0);
                        amArray[i] = (AlarmManager) getSystemService(ALARM_SERVICE);
                        amArray[i].set(AlarmManager.RTC_WAKEUP, CalArray.get(i).getTimeInMillis() - 600000, pi);

                        intentArray.add(pi);
                    }

                }else{
                    Toast.makeText(ContactUsActivity.this, "Notifications Off", Toast.LENGTH_SHORT).show();
                    //cancels alarm
                    if(intentArray.size() > 0)
                    {
                        for(int i = 0; i < intentArray.size(); ++i)
                        {
                            amArray[i].cancel(intentArray.get(i));
                        }
                    }
                }
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactUsActivity.this, AccountActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ContactUsActivity.this.startActivity(i);
            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactUsActivity.this, UpdateIlearnActivity.class);
                ContactUsActivity.this.startActivity(i);
            }
        });

        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Something to do
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",getString(R.string.support_email), null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear out the shared preferences.
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(LoginActivity.USER_ID_PREF, null);
                editor.putBoolean(LoginActivity.LOGGED_IN_PREF, false);
                editor.commit();

                Intent i = new Intent(ContactUsActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

    }
}

