package com.example.hotella.login;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotella.R;
import com.example.hotella.home.home.HomeActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.Calendar;


public class UserFragment extends Fragment {
    private Calendar calendar;
    private int year, month, dayOfMonth;
    private DatePickerDialog datePickerDialog;
    EditText userName,roomNumber,birthdate;
    Button signIn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_user, container, false);
        userName=v.findViewById(R.id.userName);
        roomNumber=v.findViewById(R.id.roomNumber);
        signIn=v.findViewById(R.id.signInBtn);
        birthdate=v.findViewById(R.id.birthDate);
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                birthdate.setText(year + "/" +"0"+ (month+1) + "/" + day);

                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup=new Intent(getActivity(), HomeActivity.class);
                startActivity(signup);;
            }
        });
        return v;
    }
    private void scanCode(){
        ScanOptions options=new ScanOptions();
        options.setPrompt("Flaş için ses açma tuşuna basınız");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher=registerForActivityResult(new ScanContract(),result -> {
       if (result.getContents()!=null){
           Toast.makeText(getActivity(),"Giriş Başarılı",Toast.LENGTH_LONG).show();
            Intent signup=new Intent(getActivity(), HomeActivity.class);
            startActivity(signup);
       }
    });
}