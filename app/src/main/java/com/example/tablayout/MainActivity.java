package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem t1,t2,t3;
    AdapterClass adapterClass;
    WebView webview;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab1);
        viewPager = findViewById(R.id.viewpager);
        t1= findViewById(R.id.status);
        t2= findViewById(R.id.home);
        t3= findViewById(R.id.calls);

   /*     webview = findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://www.google.com/");  */

        adapterClass = new AdapterClass(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapterClass);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2)
                    adapterClass.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Listens for scroll or page change
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate= getMenuInflater();
        inflate.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.account:
                Intent intent1 = new Intent(MainActivity.this ,Account.class);
                startActivity(intent1);
                return true;

            case R.id.web:
                Intent intent2 = new Intent(MainActivity.this ,Web.class);
                startActivity(intent2);
                return true;

            case R.id.chat:
                Intent intent3 = new Intent(MainActivity.this ,Chats.class);
                startActivity(intent3);
                return true;

            case R.id.storage:
                Intent intent4 = new Intent(MainActivity.this ,Storage.class);
                startActivity(intent4);
                return true;

            case R.id.help:
                Intent intent5 = new Intent(MainActivity.this ,Help.class);
                startActivity(intent5);
                return true;

            default:
                return super.onOptionsItemSelected(item);



        }
    }
}