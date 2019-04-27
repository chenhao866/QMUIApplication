package com.zzas.qmuiapplication;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

//引入对应包
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main0Activity extends AppCompatActivity {

    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        View root = LayoutInflater.from(this).inflate(R.layout.activity_main0, null);
        ButterKnife.bind(this, root);
        initTopBar();
        setContentView(root);
    }

    private void initTopBar() {
        mTopBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);//配置的样式，当点击返回时动画流畅
            }
        });
        mTopBar.setTitle("沉浸式状态栏示例");
    }
}
