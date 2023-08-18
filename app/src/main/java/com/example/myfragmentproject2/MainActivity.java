package com.example.myfragmentproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FragmentContainerView fragmentView;
    private Button product1,product2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentView = (FragmentContainerView) findViewById(R.id.fragmentContainerView);
        //product1 = (Button) findViewById(R.id.button3);
        //product2 = (Button) findViewById(R.id.button4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //product1.setOnClickListener(this);
        //product2.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();

        if(item.getTitle() == getResources().getString(R.string.text1))
            loadFragment(new Product1());
        if(item.getTitle() == getResources().getString(R.string.text2))
            loadFragment(new Product2());
        return super.onOptionsItemSelected(item);


    }
    /*
    public void onClick(View v){
        if(v.getId() == R.id.button3)
            loadFragment(new Product1());
        if(v.getId() == R.id.button4)
            loadFragment(new Product2());
    }
    */

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transacion = fragmentManager.beginTransaction();
        transacion.setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView,fragment)
                .commit();

    }



}