package com.hq.acdm.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class test {

    public static void main(String[] args) {

        //折线图数据
        DefaultCategoryDataset lineDataset = new DefaultCategoryDataset();
        //添加数据
        lineDataset.addValue(14, "实际架次", "7");
        lineDataset.addValue(27, "实际架次", "8");
        lineDataset.addValue(28, "实际架次", "9");
        lineDataset.addValue(28, "实际架次", "10");
        lineDataset.addValue(31, "实际架次", "11");
        lineDataset.addValue(33, "实际架次", "12");
        lineDataset.addValue(30, "实际架次", "13");
        lineDataset.addValue(34, "实际架次", "14");
        lineDataset.addValue(25, "实际架次", "15");
        lineDataset.addValue(37, "实际架次", "16");
        lineDataset.addValue(31, "实际架次", "17");
        lineDataset.addValue(32, "实际架次", "18");
        lineDataset.addValue(32, "实际架次", "19");
        lineDataset.addValue(29, "实际架次", "20");
        lineDataset.addValue(31, "实际架次", "21");
        lineDataset.addValue(25, "实际架次", "22");
        lineDataset.addValue(14, "实际架次", "23");


        //柱状图数据
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //添加数据
        dataset.addValue(12, "计划架次", "7");
        dataset.addValue(25, "计划架次", "8");
        dataset.addValue(29, "计划架次", "9");
        dataset.addValue(32, "计划架次", "10");
        dataset.addValue(30, "计划架次", "11");
        dataset.addValue(36, "计划架次", "12");
        dataset.addValue(34, "计划架次", "13");
        dataset.addValue(34, "计划架次", "14");
        dataset.addValue(25, "计划架次", "15");
        dataset.addValue(27, "计划架次", "16");
        dataset.addValue(33, "计划架次", "17");
        dataset.addValue(33, "计划架次", "18");
        dataset.addValue(32, "计划架次", "19");
        dataset.addValue(28, "计划架次", "20");
        dataset.addValue(31, "计划架次", "21");
        dataset.addValue(21, "计划架次", "22");
        dataset.addValue(19, "计划架次", "23");

        //生成的柱状图
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                "",//X轴的标签
                "",//Y轴的标签
                dataset, //图标显示的数据集合
                PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
                true,//是否显示子标题
                false,//是否生成提示的标签
                false); //是否生成URL链接

        /*
         * 处理图形上的乱码
         */

        //处理主标题的乱码
        chart.getTitle().setFont(new Font("黑体",Font.BOLD,18));
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,18));
        chart.getLegend().setPosition(RectangleEdge.TOP);
        //设置背景色
        chart.setBackgroundPaint(Color.white);

        //做文字渲染参数的修改
        //chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        System.out.println("4");
        //获取图表区域对象
        CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();
       //设置画布背景色
        categoryPlot.setBackgroundPaint(Color.white);
        //设置网格竖线颜色
        //categoryPlot.setDomainGridlinePaint(Color.blue);
        //categoryPlot.setDomainGridlinesVisible(true);
        //设置网格横线颜色
        categoryPlot.setRangeGridlinePaint(Color.gray);
        categoryPlot.setRangeGridlinesVisible(true);
        //获取X轴的对象
        CategoryAxis categoryAxis3D = categoryPlot.getDomainAxis();

        //获取Y轴的对象
        NumberAxis numberAxis3D = (NumberAxis)categoryPlot.getRangeAxis();

        //处理X轴上的乱码
        categoryAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,14));

        //处理X轴外的乱码
        categoryAxis3D.setLabelFont(new Font("黑体",Font.BOLD,14));

        //处理Y轴上的乱码
        numberAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,14));

        //处理Y轴外的乱码
        numberAxis3D.setLabelFont(new Font("黑体",Font.BOLD,14));

        //自定义Y轴上显示的刻度，以10作为1格
        numberAxis3D.setAutoTickUnitSelection(false);
        NumberTickUnit unit = new NumberTickUnit(10);
        numberAxis3D.setRange(0,50);
        numberAxis3D.setTickUnit(unit);
        numberAxis3D.setRange(0,50);

        //numberAxis3D.set
        //获取绘图区域对象
        CategoryItemRenderer barRenderer3D = categoryPlot.getRenderer();

        //设置柱形图的宽度
        //barRenderer3D.setMaximumBarWidth(0.07);


        //在图形上显示数字
        barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        barRenderer3D.setBaseItemLabelsVisible(true);
        barRenderer3D.setBaseItemLabelFont(new Font("黑体",Font.BOLD,12));
       // barRenderer3D.setBaseItemLabelPaint(Color.blue);
        barRenderer3D.setSeriesPaint(0, new Color(142,180,227));
       barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BOTTOM_CENTER));
      // barRenderer3D.setItemLabelAnchorOffset(10);

        /*
         * 放折线图数据
         */
        categoryPlot.setDataset(1, lineDataset);
        //设置折线
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        lineandshaperenderer.setBaseItemLabelsVisible(true);
        lineandshaperenderer.setBaseSeriesVisible(true);
        lineandshaperenderer.setBaseItemLabelPaint(Color.RED);
        lineandshaperenderer.setSeriesPaint(0, Color.RED);
        lineandshaperenderer.setBaseItemLabelFont(new Font("黑体",Font.BOLD,12));

        categoryPlot.setRenderer(1, lineandshaperenderer);
        // 柱状图和纵轴紧靠
        categoryAxis3D.setLowerMargin(0.0);

        //categoryAxis3D.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        //折线在柱面前面显示
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

        /*
         * 在E盘目录下生成图片
         */
        File file = new File("C:\\ACDM\\A.png");
        try {
            ChartUtilities.saveChartAsJPEG(file, 1,chart, 455, 245);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
