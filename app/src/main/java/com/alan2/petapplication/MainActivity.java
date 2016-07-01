package com.alan2.petapplication;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alan2.petapplication.adapter.MascotaAdaptador;
import com.alan2.petapplication.adapter.PageAdapter;
import com.alan2.petapplication.fragment.PerfilMascotaFragment;
import com.alan2.petapplication.fragment.RecyclerViewPrincipalFragment;
import com.alan2.petapplication.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setToolbar();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar !=null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewPrincipalFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.corgi_48);
    }


    /*private void setToolbar(){
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbarMain);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Petagram");
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_raiting:
                Intent intent = new Intent(MainActivity.this, RaitingMascotaActivity.class);
                startActivity(intent);
                break;
            case R.id.action_contacto:
                Intent intent1 = new Intent(this, ContactoActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_acercade:
                Intent intent2 = new Intent(this, AcercaDeActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
