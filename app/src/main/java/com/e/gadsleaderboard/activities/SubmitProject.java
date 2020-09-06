package com.e.gadsleaderboard.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.DialogCompat;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.e.gadsleaderboard.R;
import com.e.gadsleaderboard.alerts.ErrorAlert;
import com.e.gadsleaderboard.alerts.SubmitAlert;
import com.e.gadsleaderboard.alerts.SuccessAlert;
import com.e.gadsleaderboard.model.URL;
import com.e.gadsleaderboard.model.VolleySingleton;

import java.util.HashMap;
import java.util.Map;

public class SubmitProject extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btn;
    SubmitAlert alert;
    EditText textfirstname, textemail, textlastname, textlink;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_project);
        toolbar = findViewById(R.id.toolBar);
        alert = new SubmitAlert();
        textfirstname = findViewById(R.id.fname);
        textlastname = findViewById(R.id.lname);
        textemail = findViewById(R.id.email);
        textlink = findViewById(R.id.github);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_title);
        getSupportActionBar().setSubtitle(R.string.toolbar_subtitle);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setIcon(R.drawable.ic_gadslogosmall);
        btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert.show(getSupportFragmentManager(), "");

            }
        });


    }

    public void submitProject() {
        final String fname = textfirstname.getText().toString();
        final String lname = textlastname.getText().toString();
        final String email = textemail.getText().toString();
        final String gitlink = textlink.getText().toString();

        request = new StringRequest(Request.Method.POST, URL.PROJECT_SUBMIT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                final SuccessAlert succesDialog = new SuccessAlert();
                succesDialog.show(getSupportFragmentManager(), "success");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        succesDialog.dismiss();
                    }
                }, 3000);

                textfirstname.setText("");
                textlastname.setText("");
                textemail.setText("");
                textlink.setText("");

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                final ErrorAlert errorDialog = new ErrorAlert();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        errorDialog.dismiss();
                    }
                }, 3000);



            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("entry.1877115667", fname);
                params.put("entry.2006916086", lname);
                params.put("entry.1824927963", email);
                params.put("entry.284483984", gitlink);

                return params;
            }
        };

        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);


    }

    public boolean checkInput() {
        if (textfirstname.getText().toString().isEmpty() ||
                textlastname.getText().toString().isEmpty() ||
                textemail.getText().toString().isEmpty() ||
                textlink.getText().toString().isEmpty()) {
            return false;
        }else{
            return true;
        }
    }
}
