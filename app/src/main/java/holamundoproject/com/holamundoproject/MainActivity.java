package holamundoproject.com.holamundoproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_reg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_reg2 = (TextView) findViewById(R.id.tv_reg2);
        tv_reg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Flecha que me indica la transición entre pantallas
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);


            }
        });
    }

    @Override
    public void onBackPressed() {
        //Ventana de confirmación de cerrado de pestaña
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("SALIR").setMessage("¿Desea salir?").setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();


            }
        }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                MainActivity.super.onBackPressed();
            }
        });


        builder.show();
    }
}