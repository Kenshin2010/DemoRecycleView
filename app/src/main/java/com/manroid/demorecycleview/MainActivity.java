package com.manroid.demorecycleview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view();
    }
    public void view(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);



//        DividerItemDecoration decoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(decoration);
        //custom divider

        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        decoration.setDrawable(drawable);
        recyclerView.addItemDecoration(decoration);


        //remove item

        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ArrayList<DataShop> arrayList  = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.user,"Nguyen Van A"));
        arrayList.add(new DataShop(R.drawable.user,"Nguyen Van B"));
        arrayList.add(new DataShop(R.drawable.user,"Nguyen Van C"));
        arrayList.add(new DataShop(R.drawable.user,"Nguyen Van D"));
        ShopAdapter shopAdapter = new ShopAdapter(arrayList,this);
        recyclerView.setAdapter(shopAdapter);
    }
}
