package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileDemo extends AppCompatActivity {
    EditText name,data;
    File file,f1,f2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_demo);
        checkAndRequestPermission();
        name=findViewById(R.id.fname);
        data=findViewById(R.id.fdata);
        file= Environment.getExternalStorageDirectory();
        f1=new File(file,"FirstActivityEICT");
        if (!f1.exists())
        {
            f1.mkdir();
            Toast.makeText(this, "Folder Created", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Already Exists", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkAndRequestPermission() {
        int read= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int write= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> list=new ArrayList<String>();
        if (read != PackageManager.PERMISSION_GRANTED)
        {
            list.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (list.size()>0)
        {
            ActivityCompat.requestPermissions(this,list.toArray(new String[list.size()]),200);
            return false;
        }
        return true;
    }

    public void addFile(View view){
        try {
            String fname=name.getText().toString();
            String fdata=data.getText().toString();
            FileOutputStream fos=new FileOutputStream(f1.getAbsolutePath()+File.separator);
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
            data.setText("");
            name.setText("");
            } catch (Exception e)
                {

                }
    }
    public void searchFile(View view) {
        try {
           String fname=name.getText().toString();
           String fdata="";
           f2=new File(f1,fname);
           if (f2.exists())
           {
               FileInputStream fis=new FileInputStream(f2.getAbsolutePath());
               int i;
               while ((i=fis.read())>-1)
               {
                   fdata+=(char)i;
               }
             data.setText(fdata);
           }
           else
           {
               Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show();
           }
        }catch (Exception e)
        {

        }

    }
}