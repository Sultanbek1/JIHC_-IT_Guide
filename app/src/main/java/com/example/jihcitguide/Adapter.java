package com.example.jihcitguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models; // this ArrayList creates a list of array which parameters define in our model class

    // now create a parameterized constructor, press alt+insert


    public Adapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null); // this line inflate our row
        return new MyHolder(view); // this will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {
        myHolder.mTitle.setText(models.get(i).getTitle()); // here i is position
        myHolder.mDes.setText(models.get(i).getDescription());
        myHolder.mImageView.setImageResource(models.get(i).getImg()); // here we used image resource
        // because we will  use images in our resource folder which is drawable


        // this method is than you can use when you want to use one activity
        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                String gTitle = models.get(position).getTitle();
                String gDesc = models.get(position).getDescription(); // these objects get out data from previous activity
                BitmapDrawable bitmapDrawable = (BitmapDrawable)myHolder.mImageView.getDrawable();
                // this will get out image from drawable

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream(); // image will get stream and bytes

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream); // it will change out img

                byte[] bytes = stream.toByteArray();

                // get out out data with intent
                Intent intent = new Intent(c, AnotherActivity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc); // get data and put in intent
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);
            }
        });

        // if you want to use different activities
//        myHolder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClickListener(View view, int position) {
//                if (models.get(position).getTitle().equals("Software engineer")) {
//                    // then you can move another activity from if body
//                }
//                if (models.get(position).getTitle().equals("Marketer")) {
//                    // then you can move another activity from if body
//                }
//                if (models.get(position).getTitle().equals("Manager")) {
//                    // then you can move another activity from if body
//                }
//                if (models.get(position).getTitle().equals("Accounter")) {
//                    // then you can move another activity from if body
//                }
//                if (models.get(position).getTitle().equals("Translator")) {
//                    // then you can move another activity from if body
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
