package com.duy.ide.editor.theme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.duy.ide.editor.editor.R;
import com.jecelyin.editor.v2.BaseActivity;

public class ThemeActivity extends BaseActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        mRecyclerView = findViewById(R.id.recyclerView);
    }
}