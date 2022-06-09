package com.penthouse_bogmjary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder>{

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private ArrayList<AllBuildingInfo> mLstAllBuildingInfo;

    private Context mContext;
    public BookmarkAdapter(Context context, ArrayList<AllBuildingInfo> mLstAllBuildingInfo){
        this.mLstAllBuildingInfo = mLstAllBuildingInfo;
        this.mContext = context;
    }

    @NonNull
    @Override
    public BookmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_list_view, parent, false);
        return new BookmarkAdapter.ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter.ViewHolder holder, int position) {
        holder.tv_address_bookmark.setText(mLstAllBuildingInfo.get(position).getBuildingAddress());
        holder.tv_binfo_bookmark.setText(mLstAllBuildingInfo.get(position).getBo() + "/" +mLstAllBuildingInfo.get(position).getMonthMoney() + ", " +
                mLstAllBuildingInfo.get(position).getBig() + "평, " + "주차" + mLstAllBuildingInfo.get(position).getParking() + ", " +"애완동물, " + mLstAllBuildingInfo.get(position).getAnimal() +
                ", "+ "E/V "+mLstAllBuildingInfo.get(position).getEv());
        holder.tv_bscore_bookmark.setText(String.valueOf(mLstAllBuildingInfo.get(position).getFinalScore()) + "점");
    }

    @Override
    public int getItemCount() {
        return mLstAllBuildingInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView tv_address_bookmark;
        protected TextView tv_binfo_bookmark;
        protected TextView tv_bscore_bookmark;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tv_address_bookmark = itemView.findViewById(R.id.tv_address_bookmark);
            tv_binfo_bookmark = itemView.findViewById(R.id.tv_binfo_bookmark);
            tv_bscore_bookmark = itemView.findViewById(R.id.tv_bscore_bookmark);
            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance().getReference();
            FirebaseUser user = mAuth.getCurrentUser();
            String uid = user.getUid();
            itemView.setOnClickListener(new View.OnClickListener(){
               @Override
                public void onClick(View view){
                    int currentPos = getAdapterPosition();
                    if(currentPos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(mContext, SubMainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        AllBuildingInfo allBuildingInfo = mLstAllBuildingInfo.get(currentPos);
                        mDatabase.child("currentseeaddress").child(uid).setValue(allBuildingInfo.getBuildingAddress())
                                .addOnSuccessListener(new OnSuccessListener<Void>() { //데이터베이스에 넘어간 이후 처리
                                    @Override
                                    public void onSuccess(Void aVoid) {}
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {}
                                });
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
