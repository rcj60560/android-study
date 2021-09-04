package com.luocj.androidstudy.baseadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.luocj.androidstudy.R;
import com.luocj.baselib.BaseAdapter;
import com.luocj.baselib.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterActivity extends AppCompatActivity {

    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(R.string.base_adapter));
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        initData();
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyBaseAdapter(R.layout.item_cell, data));

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            data.add(String.valueOf(i));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }

        public class Holder extends RecyclerView.ViewHolder {
            public Holder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

    private class MyBaseAdapter extends BaseAdapter<String, BaseViewHolder> {

        public MyBaseAdapter(int layoutId, @Nullable List<String> data) {
            super(layoutId, data);
        }

        @Override
        protected void convert(BaseViewHolder holder, String item) {
            holder.setText(R.id.textview, item);
        }
    }
}