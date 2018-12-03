package Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Layout.LoginFragment;
import Layout.MapFragment;
import Objects.ClientModel;
import academy.learnprogramming.familymap.R;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iconify.with(new FontAwesomeModule());

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment loginFragment = fragmentManager.findFragmentById(R.id.firstLayout);

        if(!ClientModel.getInstance().isLoggedIn()){
            if(loginFragment == null){
                loginFragment = LoginFragment.newInstance(this);
                fragmentManager.beginTransaction()
                        .add(R.id.firstLayout, loginFragment)
                        .commit();
            }
        }


    }

    public void swapFragments(){
        MapFragment mapFragment = new MapFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.firstLayout, mapFragment);
        ft.commit();
    }


}
