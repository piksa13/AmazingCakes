package com.example.android.amazingcakes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AmazingCakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazing_cakes);
    }

    public void email_us(View view) {

    Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");

        intent.putExtra(Intent.EXTRA_EMAIL,"yourcake@amazingcakes.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Amazing cake order");
        intent.putExtra(Intent.EXTRA_TEXT,"Hi there, \n\n Here is my order for the weeding cake. I would like two story healthy fruit cake covered in dark chocolate, no sugar, dairy or gluten.\nMy Wedding is 13th of January in Richmond Park. Please let me know whether you can make.\n\nBest, Ann ");
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(Intent.createChooser(intent, "Send Email"));}
        else {
            Toast.makeText(this, "This app can't handle email intent. Don't know why!", Toast.LENGTH_LONG).show();}
    }

    public void order(View view) {
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);}
    }

    public void phone(View view) {
        String posted_by = "0200-111-222";

        String uri = "tel:" + posted_by.trim() ;
        Intent phone_intent = new Intent(Intent.ACTION_CALL);
        phone_intent.setData(Uri.parse(uri));
        startActivity(phone_intent);
    }

}