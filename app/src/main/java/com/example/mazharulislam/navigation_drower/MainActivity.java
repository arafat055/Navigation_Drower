package com.example.mazharulislam.navigation_drower;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView navlist;
    private DrawerLayout drawerLayout;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navlist = (ListView) findViewById(R.id.navlist);


        String[] itemname ={
                "",
                "",
                "",
                "",
                "",
                "",
                "",

        };

        Integer[] imgid={
                R.drawable.cat_edu,
                R.drawable.cat_fun,
                R.drawable.cat_govt,
                R.drawable.cat_health,
                R.drawable.cat_job,
                R.drawable.cat_law,
                R.drawable.cat_money,

        };


       ArrayList<Integer> navArray = new ArrayList<Integer>();

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        navlist=(ListView)findViewById(R.id.navlist);
        navlist.setAdapter(adapter);

//        navArray.add(R.drawable.beauty1);
//        navArray.add(R.drawable.beauty2);
//        navArray.add(R.drawable.beauty3);
//        navArray.add(R.drawable.beauty4);
//        navArray.add(R.drawable.beauty5);
//        navArray.add(R.drawable.beauty4);
        navlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_selectable_list_item,navArray);
//        navlist.setAdapter(adapter);
        navlist.setOnItemClickListener(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragmentManager=getSupportFragmentManager();

        loadSelection(0);//here the first item is selected
    }

    private void loadSelection(int i) {

        navlist.setItemChecked(i,true);//here the first item is selected


        switch (i)
        {
            case 0:
                Home home=new Home();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,home);
                fragmentTransaction.commit();
                break;
            case 1:
                Myfragment myfragment=new Myfragment();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,myfragment);
                fragmentTransaction.commit();
                break;
            case 2:
                Myfragment1 myfragment1=new Myfragment1();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,myfragment1);
                fragmentTransaction.commit();
                break;
            case 3:
                Myfragment2 myfragment2=new Myfragment2();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,myfragment2);
                fragmentTransaction.commit();
                break;
            case 4:
                Myfragment3 myfragment3=new Myfragment3();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,myfragment3);
                fragmentTransaction.commit();
                break;
            case 5:
                Myfragment4 myfragment4=new Myfragment4();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,myfragment4);
                fragmentTransaction.commit();
                break;
            case 6:
                Myfragment5 myfragment5=new Myfragment5();
                fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentfolder,myfragment5);
                fragmentTransaction.commit();
                break;
        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;}
        else if(id== android.R.id.home){
            if(drawerLayout.isDrawerOpen(navlist))
            {
                drawerLayout.closeDrawer(navlist);
            }
            else drawerLayout.openDrawer(navlist);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadSelection(position);
        drawerLayout.closeDrawer(navlist);
    }
}
