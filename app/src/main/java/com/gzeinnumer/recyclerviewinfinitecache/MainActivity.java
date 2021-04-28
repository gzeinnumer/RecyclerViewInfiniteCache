package com.gzeinnumer.recyclerviewinfinitecache;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gzeinnumer.recyclerviewinfinitecache.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DummyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniRV();
    }

    private void iniRV() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i+1));
        }
        adapter = new DummyAdapter(list);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rv.hasFixedSize();
//        binding.rv.setItemViewCacheSize(100);
        binding.rv.setItemViewCacheSize(list.size());

        getItemPerIndex();
    }

    private void getItemPerIndex() {
        for (int i = 0; i < adapter.getHolders().size(); i++) {
            DummyAdapter.MyHolder holder = adapter.getHolders().get(i);

            String data = holder.binding.tv.getText().toString();
            Log.d(getClass().getSimpleName(), "getItemPerIndex: "+data);
        }
    }
}