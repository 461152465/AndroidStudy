package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitlist = new ArrayList<Fruit>();
    //private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitlist);


        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    //初始化fruitlist
    private void initFruits()
    {
        for(int i=0; i < 2; i++)
        {
            Fruit apple = new Fruit("apple",R.drawable.apple_pic);
            this.fruitlist.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.banana_pic);
            this.fruitlist.add(banana);
            Fruit orange = new Fruit("orange",R.drawable.orange_pic);
            this.fruitlist.add(orange);
            Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon_pic);
            this.fruitlist.add(watermelon);
            Fruit pear = new Fruit("pear",R.drawable.pear_pic);
            this.fruitlist.add(pear);
            Fruit grape = new Fruit("grape",R.drawable.grape_pic);
            this.fruitlist.add(grape);
            Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
            this.fruitlist.add(pineapple);
            Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry_pic);
            this.fruitlist.add(strawberry);
            Fruit cherry = new Fruit("cherry",R.drawable.cherry_pic);
            this.fruitlist.add(cherry);
            Fruit mango = new Fruit("mango",R.drawable.mango_pic);
            this.fruitlist.add(mango);
        }
    }

}
