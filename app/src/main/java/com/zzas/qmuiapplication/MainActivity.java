package com.zzas.qmuiapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button bt_01;
    private Button bt_02;//对话框
    private Button bt_03;//listView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_01=findViewById(R.id.bt_01);
        bt_01.setOnClickListener(this);
        bt_02=findViewById(R.id.bt_02);
        bt_02.setOnClickListener(this);
        bt_03=findViewById(R.id.bt_03);
        bt_03.setOnClickListener(this);
    }
    //弹出对话框
    protected void Onbt_02(){

        QMUIDialog qmuiDialog = new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("QMUI对话框标题")
                .setMessage("这是QMUI框架对话框的内容")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();

                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }






    @Override
    public void onClick(View v) {
        if (v.equals(bt_01)){
            Intent intent=new Intent(MainActivity.this,Main0Activity.class);
            startActivity(intent);
        }else if (v.equals(bt_02)){
            Onbt_02();
        }else if (v.equals(bt_03)){
            Intent intent=new Intent(MainActivity.this,Main1Activity.class);
            startActivity(intent);
        }
    }
}
