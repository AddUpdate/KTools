package com.jiangkang.ktools.widget;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.jiangkang.ktools.R;
import com.jiangkang.tools.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class ThemeActivity extends AppCompatActivity {

    @BindView(R.id.rc_theme)
    RecyclerView mRcTheme;

    private TextAdapter mAdapter;

    private List<String> mThemeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);

        initViews();

        loadData();

        bindDataToView();

    }

    private void bindDataToView() {
        mAdapter = new TextAdapter(this,mThemeList);
       mAdapter.setOnItemClickListener(new TextAdapter.onItemClickListener() {
           @Override
           public void onClick(TextAdapter.ViewHolder holder, int position) {
               ToastUtils.showShortToast(String.valueOf(position));
           }
       });
        mRcTheme.setAdapter(mAdapter);
    }

    private void loadData() {
        mThemeList = new ArrayList<>();
        mThemeList.add(0,"Theme");
    }

    private void initViews() {
        mRcTheme.setLayoutManager(new LinearLayoutManager(this));

    }
}
