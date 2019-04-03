package com.wj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.openxu.cview.chart.bean.ChartLable;
import com.openxu.cview.chart.piechart.PieChartLayout;
import com.openxu.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {
    private PieChartLayout pieChart2;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        pieChart2 = (PieChartLayout)findViewById(R.id.pieChart2);
    }

    @Override
    protected void initData() {
        //RGB颜色数组
         int[][] colorRgb = {
                {0, 0, 0},   //    UIColorFromRGB(0xD95F5B),
                {255, 0, 91},     //    UIColorFromRGB(0x7189E6),
                {255, 255, 0},    //    UIColorFromRGB(0x5AB9C7),
                {255, 0, 255},   //   UIColorFromRGB(0xB096D5),
                {107, 186, 151},   //    UIColorFromRGB(0x6BBA97),
                {91, 164, 231},    //    UIColorFromRGB(0x5BA4E7),
                {220, 170, 97},//    UIColorFromRGB(0xDCAA61),
                {125, 171, 88},//    UIColorFromRGB(0x7DAB58),
                {233, 200, 88},//    UIColorFromRGB(0xE9C858),
                {213, 150, 196},//    UIColorFromRGB(0xd596c4)
                {220, 127, 104},//    UIColorFromRGB(0xDC7F68),
        };

        //请求数据
        List<PieBean> datalist = new ArrayList<>();

        List<ChartLable> tableList = new ArrayList<>();
        tableList.add(new ChartLable("建筑", DensityUtil.sp2px(this, 12), getResources().getColor(R.color.text_color_light_gray)));
        tableList.add(new ChartLable("性质", DensityUtil.sp2px(this, 12), getResources().getColor(R.color.text_color_light_gray)));

        pieChart2.setRingWidth(DensityUtil.dip2px(this, 20));
        pieChart2.setTagModul(PieChartLayout.TAG_MODUL.MODUL_LABLE);      //在lable后面显示tag
        pieChart2.setDebug(false);
        pieChart2.setLoading(true);
        pieChart2.setArrColorRgb(colorRgb);
        //请求数据
        datalist.clear();
        datalist.add(new PieBean(20, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(10, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(30, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(8, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(15, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(15, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(15, "销售销售销售销售销售销售"));
        datalist.add(new PieBean(15, "销售销售销售销售销售销售"));
        pieChart2.setLoading(false);
        pieChart2.setRectRaidus(100);
        pieChart2.setChartData(PieBean.class, "Numner", "Name",datalist ,tableList);
    }

    @Override
    protected void setEvent() {

    }
}
