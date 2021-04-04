package com.example.firstactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstactivity.model.Employee;
import com.example.firstactivity.model.EmployeeAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeRecord extends AppCompatActivity {
    RecyclerView rcv;
    EmployeeAdapter ea;
    DatabaseReference dbr;
    FirebaseDatabase fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_record);
        rcv=findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        fd=FirebaseDatabase.getInstance();
        dbr=fd.getReference("EmployeeDetails");
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseRecyclerAdapter<Employee,EmployeeAdapter> frc=new FirebaseRecyclerAdapter<Employee, EmployeeAdapter>
                (Employee.class,
                R.layout.employee_view_record,
                        EmployeeAdapter.class,dbr) {
            @Override
            protected void populateViewHolder(EmployeeAdapter employeeAdapter, Employee employee, int i) {
                employeeAdapter.setView(EmployeeRecord.this,employee);
            }
        };
        rcv.setAdapter(frc);
    }
}