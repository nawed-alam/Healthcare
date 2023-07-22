package com.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {
                    "Name: Dr. Jennifer Martinez",
                    "Location: Phoenix",
                    "Exp: 28 yrs",
                    "Contact: 123-456-7890",
                    "600"
            },
            {
                    "Name: Dr. Michael Johnson",
                    "Location: Los Angeles",
                    "Exp: 20 yrs",
                    "Contact: 987-654-3210",
                    "550"
            },
            {
                    "Name: Dr. Sarah Adams",
                    "Location: Chicago",
                    "Exp: 15 yrs",
                    "Contact: 456-789-0123",
                    "500"
            },
            {
                    "Name: Dr. Robert Clark",
                    "Location: New York",
                    "Exp: 18 yrs",
                    "Contact: 789-012-3456",
                    "580"
            },
            {
                    "Name: Dr. Emily Davis",
                    "Location: Houston",
                    "Exp: 25 yrs",
                    "Contact: 234-567-8901",
                    "620"
            }
    };

    private String[][] doctor_details2 = {
            {
                    "Name: Dr. Lisa Taylor",
                    "Location: Miami",
                    "Exp: 12 yrs",
                    "Contact: 567-890-1234",
                    "300"
            },
            {
                    "Name: Dr. John Brown",
                    "Location: San Francisco",
                    "Exp: 10 yrs",
                    "Contact: 901-234-5678",
                    "280"
            },
            {
                    "Name: Dr. Samantha White",
                    "Location: Los Angeles",
                    "Exp: 8 yrs",
                    "Contact: 345-678-9012",
                    "320"
            },
            {
                    "Name: Dr. Matthew Green",
                    "Location: Chicago",
                    "Exp: 14 yrs",
                    "Contact: 789-012-3456",
                    "290"
            },
            {
                    "Name: Dr. Amanda Baker",
                    "Location: Houston",
                    "Exp: 10 yrs",
                    "Contact: 234-567-8901",
                    "270"
            }
    };

    private String[][] doctor_details3 = {
            {
                    "Name: Dr. Sarah Williams",
                    "Location: Miami",
                    "Exp: 20 yrs",
                    "Contact: 234-567-8901",
                    "700"
            },
            {
                    "Name: Dr. David Lee",
                    "Location: San Francisco",
                    "Exp: 18 yrs",
                    "Contact: 567-890-1234",
                    "650"
            },
            {
                    "Name: Dr. Emily Hernandez",
                    "Location: New York",
                    "Exp: 15 yrs",
                    "Contact: 789-012-3456",
                    "680"
            },
            {
                    "Name: Dr. Michael Taylor",
                    "Location: Los Angeles",
                    "Exp: 22 yrs",
                    "Contact: 901-234-5678",
                    "720"
            },
            {
                    "Name: Dr. Jessica Adams",
                    "Location: Chicago",
                    "Exp: 16 yrs",
                    "Contact: 345-678-9012",
                    "670"
            }
    };

    private String[][] doctor_details4 = {
            {
                    "Name: Dr. Robert Taylor",
                    "Location: Boston",
                    "Exp: 25 yrs",
                    "Contact: 345-678-9012",
                    "1000"
            },
            {
                    "Name: Dr. Jessica Clark",
                    "Location: Seattle",
                    "Exp: 22 yrs",
                    "Contact: 678-901-2345",
                    "900"
            },
            {
                    "Name: Dr. Michael Johnson",
                    "Location: San Francisco",
                    "Exp: 20 yrs",
                    "Contact: 901-234-5678",
                    "980"
            },
            {
                    "Name: Dr. Emily Adams",
                    "Location: Los Angeles",
                    "Exp: 28 yrs",
                    "Contact: 234-567-8901",
                    "1050"
            },
            {
                    "Name: Dr. Daniel Lee",
                    "Location: New York",
                    "Exp: 26 yrs",
                    "Contact: 567-890-1234",
                    "1100"
            }
    };

    private String[][] doctor_details5 = {
            {
                    "Name: Dr. Richard Hernandez",
                    "Location: Dallas",
                    "Exp: 30 yrs",
                    "Contact: 901-234-5678",
                    "800"
            },
            {
                    "Name: Dr. Emily Davis",
                    "Location: Houston",
                    "Exp: 28 yrs",
                    "Contact: 234-567-8901",
                    "750"
            },
            {
                    "Name: Dr. Michael Johnson",
                    "Location: Los Angeles",
                    "Exp: 25 yrs",
                    "Contact: 901-234-5678",
                    "780"
            },
            {
                    "Name: Dr. Jessica Adams",
                    "Location: Chicago",
                    "Exp: 24 yrs",
                    "Contact: 345-678-9012",
                    "820"
            },
            {
                    "Name: Dr. Daniel Lee",
                    "Location: San Francisco",
                    "Exp: 22 yrs",
                    "Contact: 567-890-1234",
                    "830"
            }
    };

    TextView tv;
Button btn;
String[][] doctor_details = {};
ArrayList list;
HashMap<String,String> item;
SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);

        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity( new Intent (DoctorDetailsActivity.this ,FindDoctorActivity.class));
            }
        });
list =new ArrayList();
for(int i=0;i<doctor_details.length;i++){
    item = new HashMap<String,String>();
    item.put("line1",doctor_details[i][0]);
    item.put("line2",doctor_details[i][1]);
    item.put("line3",doctor_details[i][2]);
    item.put("line4",doctor_details[i][3]);
    item.put("line5","Cons Fees :" +doctor_details[i][4]+"/-");
    list.add(item);
}
sa = new SimpleAdapter( this,list,R.layout.multiline,
        new String[]{"line1","line2","line3","line4","line5"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst  = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",doctor_details[i][0]);
                it.putExtra("text2",doctor_details[i][1]);
                it.putExtra("text3",doctor_details[i][2]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}