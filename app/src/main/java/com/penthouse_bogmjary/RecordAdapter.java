package com.penthouse_bogmjary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    private ArrayList<String> mLstFolderDate;
    private Context mContext;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    public RecordAdapter(Context context, ArrayList<String> mLstFolderDate){
        this.mLstFolderDate = mLstFolderDate;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sample, parent, false);
        return new ViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.ViewHolder holder, int position){
        holder.tv_address.setText(mLstFolderDate.get(position));
    }

    @Override
    public int getItemCount(){
        return mLstFolderDate.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView tv_address;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tv_address = itemView.findViewById(R.id.tv_address);
            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance().getReference();
            FirebaseUser user = mAuth.getCurrentUser();
            String uid = user.getUid();
            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        String s = mLstFolderDate.get(pos);
                        mDatabase.child("currentseeaddress").child(uid).setValue(s)
                                .addOnSuccessListener(new OnSuccessListener<Void>() { //데이터베이스에 넘어간 이후 처리
                                    @Override
                                    public void onSuccess(Void aVoid) {}
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {}
                                });
                        Intent intent = new Intent(mContext, SubMainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
