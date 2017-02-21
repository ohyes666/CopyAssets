package com.tdx.demo.copyassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tdx.demo.library.PathUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PathUtil.showAndroidDir();
    }
}
