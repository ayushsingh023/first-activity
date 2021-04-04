package com.example.firstactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.firstactivity.model.Employee;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class EmployeeRegistration extends AppCompatActivity implements View.OnClickListener{
    EditText name,add,age,blood,id;
    Button regButton,select;
    ImageView imageView;
    public static final int PIC_REQ=1111;
    private Uri imageuri;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    StorageReference sr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);
        id=findViewById(R.id.eid);
        name=findViewById(R.id.ename);
        add=findViewById(R.id.eadd);
        age=findViewById(R.id.eage);
        blood=findViewById(R.id.ebg);
        regButton=findViewById(R.id.register);
        select=findViewById(R.id.selectpic);
        imageView=findViewById(R.id.image);
        regButton.setOnClickListener(this);
        select.setOnClickListener(this);
        sr= FirebaseStorage.getInstance().getReference("EmployeePic");
        dbr=FirebaseDatabase.getInstance().getReference("EmployeeDetails");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.selectpic:
                openFileChooser();
                break;
            case R.id.register:
                registerEmployee();
                break;
        }
    }
    private void registerEmployee()
    {
        if (imageuri!=null)
        {
            StorageReference storageReference=sr.child(System.currentTimeMillis()+"."+getFileExcention(imageuri));
            storageReference.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    },1000);
                    Task<Uri> result=taskSnapshot.getMetadata().getReference().getDownloadUrl();
                    result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Employee employee=new Employee(name.getText().toString(),add.getText().toString(),
                                    blood.getText().toString(),uri.toString(),Integer.parseInt(id.getText().toString()),
                                    Integer.parseInt(age.getText().toString()));
                            String key=dbr.push().getKey();
                            dbr.child(key).setValue(employee);
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }
    }

    private String getFileExcention(Uri uri) {
        ContentResolver cr=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton().getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
    private void openFileChooser()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PIC_REQ);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==PIC_REQ && resultCode==RESULT_OK && data!=null)
        {
            imageuri=data.getData();
            Picasso.get().load(imageuri).into(imageView);
            //Picasso.with(this).load(imageuri).into(imageView);
        }
    }
}