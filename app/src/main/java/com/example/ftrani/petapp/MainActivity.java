package com.example.ftrani.petapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.ftrani.petapp.adapter.MascotaAdaptador;
import com.example.ftrani.petapp.adapter.PageAdapter;
import com.example.ftrani.petapp.fragment.PerfilFragment;
import com.example.ftrani.petapp.fragment.RecyclerViewFragment;
import com.example.ftrani.petapp.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setupViewPager();

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = null;

        switch(item.getItemId()){
            case R.id.mnuAcerca:
                i = new Intent(this, AcercaActivity.class);
                break;
            case R.id.mnuContacto:
                i = new Intent(this, ContactoActivity.class);
                break;
            case R.id.mnuFavoritos:
                i = new Intent(this, FavoritosActivity.class);
                break;

        }

        startActivity(i);

        return super.onOptionsItemSelected(item);
    }



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setupViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home2);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet2);
    }
}
