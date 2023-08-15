package com.example.myfragmentproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentContainerView fragmentView;
    private Button product1,product2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentView = (FragmentContainerView) findViewById(R.id.fragmentContainerView);
        product1 = (Button) findViewById(R.id.button3);
        product2 = (Button) findViewById(R.id.button4);

        product1.setOnClickListener(this);
        product2.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId() == R.id.button3)
            loadFragment(new Product1());
        if(v.getId() == R.id.button4)
            loadFragment(new Product2());
    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transacion = fragmentManager.beginTransaction();
        transacion.setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView,fragment)
                .commit();

    }

}