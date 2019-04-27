package com.zzas.qmuiapplication;


import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;


import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;




public class Main1Activity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

   private QMUIGroupListView mGroupListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mGroupListView =findViewById(R.id.groupListView);
        initUserInfo();//初始化列表
    }
    //初始化用户中心
    private void initUserInfo() {
        //Item1
        QMUICommonListItemView normalItem = mGroupListView.createItemView("Item 1");
        Drawable drawable0 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
        normalItem.setImageDrawable(drawable0);//添加图片
        normalItem.setOrientation(QMUICommonListItemView.ACCESSORY_TYPE_NONE);//右侧什么不显示
        normalItem.setTag(1);//标记标签，确定点击的是哪个item，一般使用数据id
        //Item2
        QMUICommonListItemView itemVersion = mGroupListView.createItemView("Item 2");
        Drawable drawable1 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
        itemVersion.setImageDrawable(drawable1);//添加图片
        itemVersion.setDetailText("标准版");//默认右侧显示DetailText文字
        itemVersion.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);//显示箭头样式
        itemVersion.setTag(2);
        //Item3
        QMUICommonListItemView itemExpireDate = mGroupListView.createItemView("Item 3");
        Drawable drawable2 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
        itemExpireDate.setImageDrawable(drawable2);//添加图片
        itemExpireDate.setOrientation(QMUICommonListItemView.VERTICAL);//设置下面显示DetailText文字
        itemExpireDate.setDetailText("在标题下方的详细信息");
        itemExpireDate.setTag(3);
        //Item4
        QMUICommonListItemView itemLogout = mGroupListView.createItemView("Item 4");
        itemLogout.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        Drawable drawable3 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
        itemLogout.setImageDrawable(drawable3);//添加图片
        itemLogout.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);//设置右侧显示开关样式
        itemLogout.getTextView().setTextColor(getResources().getColor(R.color.qmui_config_color_red));//设置文本颜色
        itemLogout.getSwitch().setChecked(true);//设置开关状态
        itemLogout.getSwitch().setTag(4);//给开关添加一个标签，用于区分点击的是哪一个开关按钮，一半传入数据id
        itemLogout.getSwitch().setOnCheckedChangeListener(this);//给开关添加点击事件
        //Item5
        QMUICommonListItemView itemLogout5 = mGroupListView.createItemView("Item 5");
        itemLogout5.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        Drawable drawable5 = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
        itemLogout5.setImageDrawable(drawable5);//添加图片
        itemLogout5.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);//设置右侧显示开关样式
        itemLogout5.getTextView().setTextColor(getResources().getColor(R.color.qmui_config_color_red));//设置文本颜色
        itemLogout5.getSwitch().setTag(5);
        itemLogout5.getSwitch().setOnCheckedChangeListener(this);//给开关添加点击事件
        //将显示添加到列表；ps:样式和添加可以用for循环动态添加
        QMUIGroupListView.newSection(Main1Activity.this)
                .setTitle("用户中心")
                .addItemView(normalItem, this)
                .addItemView(itemVersion, this)
                .addItemView(itemExpireDate, this)
                .addItemView(itemLogout, this)
                .addItemView(itemLogout5, this)
                .addTo(mGroupListView);
    }



    //开关点击事件
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(Main1Activity.this, "状态为" +isChecked+"；标签值是"+ buttonView.getTag().toString(), Toast.LENGTH_SHORT).show();
    }

    //item点击事件
    @Override
    public void onClick(View v) {
        QMUICommonListItemView viewList = (QMUICommonListItemView) v;
        String nameStr = viewList.getText().toString();//所点击item的文本信息
        int TAG = (int)viewList.getTag();//所点击item的标签值
        switch (TAG) {
            case 1:
                Toast.makeText(Main1Activity.this,"您点击了" +nameStr+"；标签值是"+TAG,Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(Main1Activity.this,"您点击了" +nameStr+"；标签值是"+TAG,Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(Main1Activity.this,"您点击了" +nameStr+"；标签值是"+TAG,Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
