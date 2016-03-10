package com.example.jpadm.guiadepaises.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.jpadm.guiadepaises.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_dialog)
    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_paises_lista:
                Toast.makeText(getBaseContext(), "Lista", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_paises_grade:

                Toast.makeText(getBaseContext(), "Grade", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }

    @OnClick(R.id.btn_dialog)
    public void chamaDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Clicou!");
        builder.setMessage("Parabéns, você clicou " + "\n Quer se desfazer do dialog?");

        builder.setPositiveButton("Sim!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "você fechou =(", Toast.LENGTH_LONG).show();


            }
        });

        builder.setNegativeButton("Não!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Acreditei em você =(", Toast.LENGTH_LONG).show();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
