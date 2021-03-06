package com.example.fugg.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fugg.Activity.MainActivity;
import com.example.fugg.R;

import java.util.ArrayList;

public class notifications_adapter extends RecyclerView.Adapter<notifications_adapter.myHolder> {
    static ArrayList<com.example.fugg.classs.notifications> card;
    static OnItemClick onItemClick;
    static Context context;
   // public void setOnItemClick(OnItemClick onItemClick) {
//        this.onItemClick = onItemClick;
//    }

    public notifications_adapter(ArrayList<com.example.fugg.classs.notifications> card, Context context,OnItemClick onItemClick) {
        this.onItemClick=onItemClick;
        this.context=context;
        this.card = card;
    }
    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifi_design, parent, false);
        myHolder h = new myHolder(v);
        return h;
    }
    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int i) {
        final com.example.fugg.classs.notifications item = card.get(i);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(context,android.R.layout.simple_expandable_list_item_1,item.getArrayListlist1());
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(context,android.R.layout.simple_expandable_list_item_1,item.getArrayListlist2());
        myHolder.textViewlist1.setAdapter(adapter1);
        myHolder.textViewlist2.setAdapter(adapter2);
        myHolder.textView.setText(item.getMessage());
        myHolder.textViewtitle.setText(item.getProject_name());

        holder.bind(onItemClick,i);


//        myHolder.buttonaccept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
//        myHolder.buttonrefuse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return card.size();
    }

    public static class myHolder extends RecyclerView.ViewHolder {
        static TextView textView;
        static TextView textViewtitle;
        static Button buttonaccept;
        static Button buttonrefuse;
        static  ListView textViewlist1;
        static  ListView textViewlist2;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text1);
            textViewtitle = itemView.findViewById(R.id.titltnotifi);
            textViewlist1=itemView.findViewById(R.id.listtype);
            textViewlist2=itemView.findViewById(R.id.listmemb);
            buttonaccept=itemView.findViewById(R.id.buttonaccept);
            buttonrefuse=itemView.findViewById(R.id.buttonrefuse);
        }

     public  void bind(OnItemClick lintsne,int posation){
         buttonaccept.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.e("accept","accept");
                 onItemClick.accept();
                 buttonaccept.setEnabled(false);

             }
         });
         buttonrefuse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.e("refuse","refuse");

                 onItemClick.faild(card.get(posation).getMessage());
             }
         });
     }
    }


    public interface OnItemClick {
      //  void item(com.example.fugg.classs.notifications notiClass, int position);
        void accept();
        void  faild(String mass);
    }


}