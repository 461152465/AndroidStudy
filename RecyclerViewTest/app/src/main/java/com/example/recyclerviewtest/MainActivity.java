package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }



    //初始化fruitlist
    private void initFruits()
    {
        for(int i=0; i < 2; i++)
        {
            Fruit apple = new Fruit(getRandomLengthName("appler"),R.drawable.apple_pic);
            this.fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("banana"),R.drawable.banana_pic);
            this.fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("orange"),R.drawable.orange_pic);
            this.fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("watermelon"),R.drawable.watermelon_pic);
            this.fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("pear"),R.drawable.pear_pic);
            this.fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("grape"),R.drawable.grape_pic);
            this.fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("pineapple"),R.drawable.pineapple_pic);
            this.fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("strawberry"),R.drawable.strawberry_pic);
            this.fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("cherry"),R.drawable.cherry_pic);
            this.fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("mango"),R.drawable.mango_pic);
            this.fruitList.add(mango);
        }
    }

    public String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(30)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
