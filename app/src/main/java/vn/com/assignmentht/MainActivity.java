package vn.com.assignmentht;

import android.app.Dialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import vn.com.assignmentht.sqlite.Database;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager paper;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        paper=(ViewPager) findViewById(R.id.view_paper);
        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
        paper.setAdapter(adapter);
        //paper.setCurrentItem(3);
        paper.setCurrentItem(2);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               database =new Database(MainActivity.this);
               if(paper.getCurrentItem()==0){
                   final Dialog dialog=new Dialog(MainActivity.this);
                   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                   dialog.setContentView(R.layout.dialog_thu);

                   final EditText edt_khoanthu=(EditText)dialog.findViewById(R.id.edtkhoanthu);
                   final EditText edt_loaithu=(EditText)dialog.findViewById(R.id.edtloaithu);
                   Button btnvaothu=(Button)dialog.findViewById(R.id.btnvaothu);
                   btnvaothu.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           String a=edt_khoanthu.getText().toString();
                           String b=edt_loaithu.getText().toString();
                           String c=new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                           if(a.isEmpty() || b.isEmpty()){
                               Toast.makeText(MainActivity.this,"Vui long khong de trong thong tin",Toast.LENGTH_SHORT).show();

                           }else {
                               database.SendData("INSERT INTO THU VALUES (' " + c +"','"+ a + " ','"+ b +"',NULL)");
                               PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
                               paper.setAdapter(adapter);
                               paper.setCurrentItem(2);
                               Toast.makeText(MainActivity.this,"Them du lieu thanh cong",Toast.LENGTH_SHORT).show();
                               dialog.dismiss();
                           }
                       }
                   });
                   dialog.show();
               }else  if(paper.getCurrentItem()==1){
                   final Dialog dialog=new Dialog(MainActivity.this);
                   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                   dialog.setContentView(R.layout.dialog_chi);

                   final EditText edt_khoanchi=(EditText) dialog.findViewById(R.id.edtkhoanchi);
                   final EditText edt_loaichi=(EditText) dialog.findViewById(R.id.edtloaichi);
                   Button btnvaochi=(Button)dialog.findViewById(R.id.btnvaochi);
                   btnvaochi.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           String a=edt_khoanchi.getText().toString();
                           String b=edt_loaichi.getText().toString();
                           String c=new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
                           if(a.isEmpty() || b.isEmpty()){
                               Toast.makeText(MainActivity.this,"Vui long khong de trong thong tin",Toast.LENGTH_SHORT).show();

                           }else {
                               database.SendData("INSERT INTO CHI VALUES (' " + a +"','"+ b + " ','"+ c +"',NULL)");
                               PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
                               paper.setAdapter(adapter);
                               paper.setCurrentItem(1);
                               Toast.makeText(MainActivity.this,"Them du lieu thanh cong",Toast.LENGTH_SHORT).show();
                               dialog.dismiss();
                           }
                       }
                   });
                   dialog.show();
               }
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_khoanthu) {
            PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(0);
            // Handle the camera action
        } else if (id == R.id.nav_khoanchi) {
            PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(1);

        } else if (id == R.id.nav_thongke) {
            PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(2);

        } else if (id == R.id.nav_gioithieu) {
            PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
            paper.setAdapter(adapter);
            paper.setCurrentItem(3);

        } else if (id == R.id.nav_thoat) {
finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
