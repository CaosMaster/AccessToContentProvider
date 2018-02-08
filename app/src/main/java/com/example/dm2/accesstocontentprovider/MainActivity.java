package com.example.dm2.accesstocontentprovider;

import android.database.Cursor;
import android.icu.text.DateFormat;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] TIPO_LLAMADA= {"","entrante","saliente","perdida"};
        TextView salida = (TextView) findViewById(R.id.salida);
        Uri llamadas=Uri.parse("content://call_log//calls");

        Cursor c=getContentResolver().query(llamadas,null,null,null,null);

        while (c.moveToNext()){
            salida.append("\n"
                    + c.getString(c.getColumnIndex(CallLog.Calls.DURATION))+")"
                    + c.getString(c.getColumnIndex(CallLog.Calls.NUMBER))+", "
                    + TIPO_LLAMADA[Integer.parseInt(c.getString(c.getColumnIndex(CallLog.Calls.TYPE)))]);
        }

    }
}
