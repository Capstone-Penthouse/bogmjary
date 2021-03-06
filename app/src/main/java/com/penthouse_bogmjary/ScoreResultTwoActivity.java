package com.penthouse_bogmjary;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

public class ScoreResultTwoActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    String value;
    String uid;
    int monthMoney=0;
    int bo=0;
    int big = 0;
    String jucha;
    String animal;
    String ev;
    int iljoScore=0;
    int pyonScore=0;
    int otherScore = 0;
    int elecMoney=0;
    int gasMoney=0;
    int waterMoney=0;
    int monthlyFee=0;
    int score_month = 0;
    int real_month =0;

    TextView first_tv;
    TextView second_tv;
    TextView third_tv;
    TextView fourth_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_result_two);

        Button close_scoreresulttwoactivity_btn = findViewById(R.id.close_scoreresulttwoactivity_btn);
        first_tv = findViewById(R.id.first_info_tv);
        second_tv = findViewById(R.id.second_info_tv);
        third_tv = findViewById(R.id.third_info_tv);
        fourth_tv = findViewById(R.id.fourth_info_tv);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseUser user = mAuth.getCurrentUser();
        uid = user.getUid();

        TextView current_address_tv_score_result_two = (TextView) findViewById(R.id.current_address_tv_score_result_two);

        mDatabase.child("currentseeaddress").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                value = dataSnapshot.getValue(String.class);
                current_address_tv_score_result_two.setText(value);
                init();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        });

        close_scoreresulttwoactivity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init(){
        mDatabase.child("bookmark").child(uid).child(value).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                AllBuildingInfo group = dataSnapshot.getValue(AllBuildingInfo.class);
                elecMoney = group.getElec_y();
                gasMoney = group.getGas_y();
                waterMoney = group.getWater_y();
                int monthlyFeeImsi = group.getMonthlyFee();
                int otherScoreImsi = group.getOtherScore();
                jucha = group.getParking();
                animal = group.getAnimal();
                ev = group.getEv();
                pyonScore = group.getPyonScore();
                iljoScore = group.getSunScore();

                monthMoney = group.getMonthMoney();
                monthlyFee = monthlyFeeImsi;
                otherScore = otherScoreImsi;
                bo = group.getBo();
                big = group.getBig();
                first_tv.setText("?????? " + monthMoney +" ????????? " + bo+ " " + big + "???");
                second_tv.setText("?????? " + jucha);
                third_tv.setText("???????????? " + animal);
                fourth_tv.setText("??????????????? " + ev);

                real_month = monthlyFee*10000 + elecMoney + gasMoney + waterMoney;
                System.out.println(real_month);
                if (real_month<=470000){
                    score_month = 100;
                }
                else if (real_month<=520000){
                    score_month = 85;
                }
                else if (real_month<=570000){
                    score_month = 70;
                }
                else if (real_month<=620000){
                    score_month = 55;
                }
                else if (real_month<=670000){
                    score_month = 40;
                }
                else if (real_month<=720000){
                    score_month = 25;
                }
                else{
                    score_month = 10;
                }

                BarChart mBarChart = (BarChart) findViewById(R.id.barchart);

                mBarChart.addBar(new BarModel("?????????", iljoScore, 0xFFffb854));
                mBarChart.addBar(new BarModel("????????????", score_month,  0xFFffdd00));
                mBarChart.addBar(new BarModel("????????????", pyonScore, 0xFF81cbfc));
                mBarChart.addBar(new BarModel("??????", otherScore, 0xFF96d492));

                mBarChart.startAnimation();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
 }



