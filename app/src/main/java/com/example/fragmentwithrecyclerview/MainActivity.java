package com.example.fragmentwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.Gravity.BOTTOM;
import static android.view.Gravity.FILL_HORIZONTAL;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    TextView name, number;
    EditText etName, etNumber;
    Button Addbtn;

    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.name);
        etName= findViewById(R.id.etName);
        number = findViewById(R.id.number);
        etNumber = findViewById(R.id.etNumber);
        Addbtn = findViewById(R.id.addbtn);

        fragmentManager= this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

        Addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                }else {
                    ApplicationClass.people.add(new Person(etName.getText().toString().trim(), etNumber.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Success Fully Added", Toast.LENGTH_SHORT).show();
                    etName.setText(null);
                    etNumber.setText(null);
                    listFrag.notifyDataChanged();
                }
            }
        });

    }

    @Override
    public void onItemClicked(int index) {
        name.setText(ApplicationClass.people.get(index).getName());
        number.setText(ApplicationClass.people.get(index).getNumber());
        String message= "Item Clicked!";
        showToast(message);
    }

    public void showToast(String message){
        View view= getLayoutInflater().inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.layoutId));
        TextView textView= view.findViewById(R.id.textView2);
        textView.setText(message);

        Toast toast= new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.setGravity(BOTTOM|FILL_HORIZONTAL, 0, 0);
        toast.show();
    }
}