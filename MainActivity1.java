package com.example.myapplication.work1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {
GridView  gridView;
ArrayList<String> list;
ArrayAdapter<String> adapter;

String[] names={"Spanish","Budget","Healthy Pasta","British Food","Roast","Mojito"};
int[] images={R.drawable.spanish,R.drawable.budget,R.drawable.healthy_pasta,R.drawable.british_food,R.drawable.roast,R.drawable.mojito};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        gridView=findViewById(R.id.gridview1);
       SearchView mySeachView=(SearchView)findViewById(R.id.searchview) ;
      ListView  myList=(ListView)findViewById(R.id.myList);
      list=new ArrayList<String>();



      list.add("Spanish");
      list.add("Budget");
      list.add("Healthy pasta");
      list.add("British food");
      list.add("Roast");
      list.add("Mojito");


      adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
      myList.setAdapter(adapter);

      mySeachView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String s) {
              return false;
          }

          @Override
          public boolean onQueryTextChange(String s) {
              adapter.getFilter().filter(s);
              return false;
          }
      });



        CustomAdapter customAdapter=new CustomAdapter(names,images,this);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
              String selectedName =names[i];
              int selectedImage =images[i];
              startActivity(new Intent(MainActivity1.this,ClickedItemActivity.class).putExtra("name",selectedName).putExtra("image",selectedImage));
            }
        });
    }
    public class CustomAdapter extends BaseAdapter{
        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater =(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view==null){
                view=layoutInflater.inflate(R.layout.row_items,viewGroup,false);
            }
            TextView tvName =view.findViewById(R.id.tvName1);
            ImageView imageView=view.findViewById(R.id.imageView1);

            tvName.setText(imageNames[i]);
            imageView.setImageResource(Integer.parseInt(String.valueOf(imagesPhoto[i])));
            return view;
        }
    }
}