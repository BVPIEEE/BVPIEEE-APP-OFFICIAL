package com.bvpieee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvpieee.adapters.DeveloperDetailAdapter;
import com.bvpieee.models.DeveloperDetailModel;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDetails extends AppCompatActivity {

    private RecyclerView developerRv;
    private List<DeveloperDetailModel> developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_details);

        developer = new ArrayList<>();

        developer.add(new DeveloperDetailModel("Tanishq Sehgal", "Chairperson, BVPIEEE CS", R.drawable.tanishqsehghal, "https://www.linkedin.com/in/tanishq-sehgal-a86bbb184/", "mailto:tsgl7246@gmail.com"));
        developer.add(new DeveloperDetailModel("Saksham Pruthi", "Vice-Chairperson, BVPIEEE CS", R.drawable.sakshampruthi, "https://www.linkedin.com/in/sakshampruthi", "mailto:saksham.0804@gmail.com"));
        developer.add(new DeveloperDetailModel("Sajal Jain", "Head- App Development", R.drawable.sajaljain, "https://www.linkedin.com/in/sajal-jain-1a4163177", "mailto:sjain30sept@gmail.com"));
        developer.add(new DeveloperDetailModel("Shubham Kumar", "Creativity Head, BVPIEEE CS", R.drawable.shubhamkumar, "https://www.linkedin.com/in/shubham-kumar-707a94194/", "mailto:shubhamkrpisces@gmail.com"));


        developerRv = findViewById(R.id.DeveloperRV);
        DeveloperDetailAdapter developerDetailAdapter = new DeveloperDetailAdapter(this, developer);
        developerRv.setAdapter(developerDetailAdapter);
        developerRv.setLayoutManager(new LinearLayoutManager(this));
    }
}