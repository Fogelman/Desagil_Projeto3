package com.example.jorge.projeto3;



import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //EditText num, msg;
    String num, msg;
    Button btnSend, btnMorse, btnSpace, btnDelete, btnUp, btnDown, btnDicionario;
    TextView morseView,txtNome,txtNum,txt1,txt2,txt3,txt4,txt5;
    EditText editText;

    private int SEND_SMS_PERMISSION_CODE = 1;
    private String oldMorse;
    private Translator translator = new Translator();
    int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //num = (EditText)findViewById(R.id.num);
        //msg = (EditText)findViewById(R.id.msg);
        num = "995966586";
        msg = "Preciso de ajuda!";
        ArrayList<String> nomeList = new ArrayList<String>();
        final ArrayList<String> numeroList = new ArrayList<String>();
        nomeList.add("Cuidador");
        nomeList.add("David");
        nomeList.add("Bruno");
        nomeList.add("Gustavo");
        nomeList.add("Jorge");
        numeroList.add("995966586");
        numeroList.add("995966586");
        numeroList.add("995966586");
        numeroList.add("972020099");

        btnDicionario = (Button)findViewById(R.id.btnDicionario);
        btnSend = (Button)findViewById(R.id.btnSend);
        btnMorse = (Button)findViewById(R.id.btnMorse);
        morseView = (TextView)findViewById(R.id.morseView);
        btnSpace = (Button)findViewById(R.id.btnSpace);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        txtNome = (TextView)findViewById(R.id.textView11);
        txtNum = (TextView)findViewById(R.id.textView10);
        btnUp = (Button)findViewById(R.id.button);
        btnDown = (Button)findViewById(R.id.button2);
        final EditText editText = (EditText)findViewById(R.id.editText);
        txt1 = (TextView) findViewById((R.id.textView13));
        txt2 = (TextView) findViewById((R.id.textView10));
        txt3 = (TextView) findViewById((R.id.textView12));
        txt4 = (TextView) findViewById((R.id.textView11));
        final ArrayList<TextView> txtList = new ArrayList<TextView>();
        txtList.add(txt1);
        txtList.add(txt2);
        txtList.add(txt3);
        txtList.add(txt4);

        int counter = 0;

        btnDicionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListViewLoader.class));
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count <=0 ){
                    count = 0;

                }

                else {
                    count -= 1;
                }
                for (int z = 0;z<4;z++){
                    if (z == count){
                        txtList.get(z).setSelected(true);
                        txtList.get(z).setBackgroundColor(Color.BLUE);
                    }
                    else{
                        txtList.get(z).setSelected(false);
                        txtList.get(z).setBackgroundColor(Color.WHITE);
                    }
                }
                num = numeroList.get(count);

            }
        });
        btnDown.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (count>=3){
                    count = 3;
                }
                else{
                    count +=1;
                }
                for (int u = 0;u<4;u++){
                    if (u == count){
                        txtList.get(u).setSelected(true);
                        txtList.get(u).setBackgroundColor(Color.BLUE);
                    }
                    else{
                        txtList.get(u).setSelected(false);
                        txtList.get(u).setBackgroundColor(Color.WHITE);
                    }
                }
                num = numeroList.get(count);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED){

                    sendSms();
                }
                else{

                    requestSmsPermission();
                }

            }
        });

        btnMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                morseView.append(".");
            }
        });

        btnMorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                morseView.append("-");
                return true;
            }
        });

        btnSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.append(" ");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                    editText.setText(str);
                    editText.setSelection(editText.getText().length());
                }
            }
        });


    Thread thread = new Thread(){
        @Override
        public void run (){

           oldMorse = morseView.getText().toString();
            while(!isInterrupted()){
                try {
                    Thread.sleep(750);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String newMorse = morseView.getText().toString();
                            if (newMorse.length() >0 &&  newMorse.length() == oldMorse.length()){

                                char character = translator.morseToChar(newMorse);
                                if (character != ' '){
                                    editText.append(String.valueOf(character));

                                }
                                morseView.setText("");

                            }
                             oldMorse = morseView.getText().toString();

                        }
                    });
                }
                catch (InterruptedException e){
                    e.printStackTrace();

                }

            }
        }
    };

    thread.start();

    }

    private void requestSmsPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)){
        new AlertDialog.Builder(this)
                .setTitle("Permission neeeded")
                .setMessage("Permissão necessária para enviar sms")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_CODE);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_CODE);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == SEND_SMS_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.w("MainActivity","Permission denied");
            }
        }
    }

    private void sendSms() {
        //String numero = num.getText().toString();
        EditText msg = (EditText)findViewById(R.id.editText);

        String mensagem = msg.getText().toString();
        msg.setText("");
        String numero = num;

        if (mensagem.length() == 0) {
            mensagem = "Preciso de ajuda!!";
        }
        Log.w("MensagemEnviada",mensagem);
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(numero, null, mensagem, null, null);

        Toast.makeText(getApplicationContext(), "Mensagem enviada", Toast.LENGTH_LONG).show();

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
}