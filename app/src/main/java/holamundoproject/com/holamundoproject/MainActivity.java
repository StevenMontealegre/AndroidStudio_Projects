package holamundoproject.com.holamundoproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_reg2;
    private Button btn_login;
    private EditText et_user, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user = findViewById(R.id.et_user);
        et_password = findViewById(R.id.et_password);


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

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Profile.class);
                i.putExtra("nombre", et_user.getText().toString());
                i.putExtra("contra", et_password.getText().toString());
                startActivity(i);
            }
        });

        builder.show();
    }
}