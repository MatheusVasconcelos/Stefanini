package com.example.jpadm.projetoinicial.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.jpadm.projetoinicial.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_list)
    Button btList;

    String mTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


     /*   if (savedInstanceState!= null savedInstanceState.containsKey("tag")){
            mTag = savedInstanceState.getString("tag");
        }else {
            mTag = "MAIN ACTIVITY";
        }*/


      //  Toast.makeText(this, mTag,Toast.LENGTH_LONG).show();



    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {

        mTag += "HORIZONTAL";
        outState.putString("tag", mTag);

        super.onSaveInstanceState(outState);
    }*/

    public void chamarSegundaTela(View view) {

        Intent intent = new Intent(this, CadasterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.bt_list)
    public void demandList(Button button) {

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gp, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.item_gp:
                Intent intent = new Intent(this, GerenteProjetoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


}
