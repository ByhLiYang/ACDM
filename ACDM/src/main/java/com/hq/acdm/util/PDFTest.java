package com.hq.acdm.util;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFTest {
    private static final String FILE_URL = "C:\\ACDM\\";
    private static final int alarmNum = 123;

    public static void main(String[] args) {
       Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE_URL + "hello01.pdf"));
            document.open();

            s2(document);

            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
  private static void s2(Document document) throws Exception{


        java.text.DecimalFormat  df  =new  java.text.DecimalFormat("0.00");
        JFreeChart chart = null;

        String[] rowKeys = new String[]{"请求总量","接通总量","20秒应答量"};
        String[] columnKeys =null;
        double[][] data = null;

        String[] rowKeys1 = new String[]{"人工接通率","服务水平","服务水平下线"};
        String[] columnKeys1 =null;
        double[][] data1 = null;
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
      int days = 0;
      GregorianCalendar calender = new GregorianCalendar();

          java.util.Date date1 = format.parse("20201201");
          java.util.Date date2 = format.parse("20201217");

          calender.setTime(date1);

          days = (int) ((date2.getTime() - date1.getTime()) / 86400000);
      System.out.println(days+"日");
          columnKeys = new String[days+1];
          data = new double[3][days+1];

          columnKeys1 = new String[days+1];
          data1 = new double[3][days+1];


          columnKeys[0] = "20201201".substring(4);
          columnKeys1[0] ="20201201".substring(4);

          for (int i = 1; i <= days; i++) {
              calender.add(5, 1);
              columnKeys[i]=format.format(calender.getTime()).substring(4);
              columnKeys1[i]=format.format(calender.getTime()).substring(4);
          }



              int count = 0;

                  for (int n=0 ; n<columnKeys.length ; n++) {
                      System.out.println(columnKeys[n]);
                      System.out.println(columnKeys1[n]);
                          data[0][n] = new Integer(n).doubleValue();
                          data[1][n] = new Integer(n).doubleValue();
                          data[2][n] = new Integer(n)/100;

                          data1[0][n] = new Integer(n).doubleValue()/new Integer(n).doubleValue();
                          data1[1][n] = new Integer(n).doubleValue()/100/new Integer(n).doubleValue();
                          data1[2][n] = 0.7D;

                          continue;
                      }






        try {


//数据集1（柱状）
            CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                    rowKeys, columnKeys, data);
            //数据集2（曲线）
            CategoryDataset dataset1 = DatasetUtilities.createCategoryDataset(
                    rowKeys1, columnKeys1, data1);


//创建一个chart对象
            chart = ChartFactory.createBarChart3D("全部技能组10010热线整体情况统计("+"202001".substring(0,6)+")", "时间", "话务量", dataset,
                    PlotOrientation.VERTICAL, true, false, false);

// 图像区域对象
            CategoryPlot plot = chart.getCategoryPlot();

//获取数据轴X轴对象
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLowerMargin(0.02D);//数据轴左边距
            domainAxis.setUpperMargin(0.02D);//右边距

//获取图像区域样式对象
            BarRenderer3D renderer = new BarRenderer3D();



//获取Y轴对象(默认的是Y轴左边对象)
            ValueAxis rAxis = plot.getRangeAxis();
            rAxis.setLowerMargin(0.02D);//数据轴左边距
            rAxis.setUpperMargin(0.02D);//右边距


//解决字体模糊
            chart.getRenderingHints().put(
                    RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_OFF
            );


            //获取数据轴对象
            NumberAxis numberaxis3 = new NumberAxis("百分比");
            numberaxis3.setNumberFormatOverride(NumberFormat.getPercentInstance());//设置风格以百分数
            numberaxis3.setAutoRange(false);
            numberaxis3.setLowerMargin(0.02D);//数据轴左边距
            numberaxis3.setUpperMargin(0.02D);//右边距

            //把该数据轴放置到右边的Y轴
            plot.setRangeAxis(1, numberaxis3);
            plot.setDataset(1, dataset1);//设置数据集索引
            plot.mapDatasetToRangeAxis(1,1);//将该索引映射到axis 第一个参数指数据集的索引,第二个参数为坐标轴的索引
            //曲线样式对象

            LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
            //第一条曲线样式

            lineandshaperenderer.setSeriesPaint(0, new Color(255,0,255));//桃红

            // 第二条曲线样式
            lineandshaperenderer.setSeriesPaint(1, new Color(0,0,255));//墨绿6

            //第三条曲线样式
            lineandshaperenderer.setSeriesPaint(2, Color.BLACK);//墨绿6
            lineandshaperenderer.setShapesVisible(true);

            //设置某坐标轴索引上数据集的显示样式
            plot.setRenderer(1, lineandshaperenderer);

            //设置2个图像的显示顺序:DatasetRenderingOrder.FORWARD:表示后者放在前面；   DatasetRenderingOrder.REVERSE：表示后者放在后面
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);





            //*----------设置标题字体--------------------------*//*
            TextTitle textTitle = chart.getTitle();
            textTitle.setFont(new Font("黑体", Font.PLAIN, 20));

            domainAxis.setTickLabelFont(new Font("sans-serif",Font.PLAIN,11));

            domainAxis.setLabelFont(new Font("宋体",Font.PLAIN,12));

            rAxis.setTickLabelFont(new Font("sans-serif",Font.PLAIN,12));
            //*------设置Y轴的标题文字------------*//*
            rAxis.setLabelFont(new Font("黑体",Font.PLAIN,12));



            //设置X轴下面显示文字的字体
           chart.getLegend().setItemFont(new Font("宋体",Font.PLAIN,12));
            renderer.setItemMargin(0.0);
            renderer.setItemLabelsVisible(true);



            //这一部分很重要。当柱体太小时候。数值不能显示，那么只有改边显示的位置
            renderer.setBaseItemLabelGenerator(new   org.jfree.chart.labels.StandardCategoryItemLabelGenerator());//显示每个柱的数值
            renderer.setBaseItemLabelsVisible(true);

            //设置不能在柱子上正常显示的那些数值的显示方式，将这些数值显示在柱子外面
            ItemLabelPosition itemLabelPositionFallback=new ItemLabelPosition(
                    ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_LEFT,
                    TextAnchor.HALF_ASCENT_LEFT,-0.0D);
            //设置当不能正常显示柱状值的时候
            renderer.setPositiveItemLabelPositionFallback(itemLabelPositionFallback);
            renderer.setNegativeItemLabelPositionFallback(itemLabelPositionFallback);


            plot.setRenderer(renderer);




           int  width=1200;
            FileOutputStream fos_jpg = null;

                fos_jpg=new FileOutputStream("C:\\ACDM\\项目状态分布1.jpg");

                ChartUtilities.writeChartAsJPEG(fos_jpg, chart, width, 480);
           // ChartUtils.writeChartAsJPEG(fos, 0.7f, lineChart, 600, 300);
               // response.getOutputStream().flush();
                //response.getOutputStream().close();
                //out.clear();
               // out = pageContext.pushBody();


        } catch (Exception e) {
            //out.println("最外面出错了");
            e.printStackTrace();
        }
    }

   /* private static void s1(Document document) throws Exception{
    //设置中文样式（不设置，中文将不会显示）
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese_title = new Font(bfChinese, 20, Font.BOLD, BaseColor.RED);
        Font fontChinese_content = new Font(bfChinese, 10, Font.NORMAL, BaseColor.BLACK);
        Paragraph paragraph_title = new Paragraph("这是一个标题", fontChinese_title);
                paragraph_title.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph paragraph_title_1 = new Paragraph("01总概括", fontChinese_content);
                paragraph_title_1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        Paragraph paragraph_content = new Paragraph("本期发生告警数量一共"+alarmNum+"次", fontChinese_content);
                paragraph_content.setFirstLineIndent(20);
                document.add(paragraph_title);
                document.add(paragraph_title_1);
                document.add(paragraph_content);
                document.newPage();
    //            Image img = Image.getInstance(FILE_URL+"N03S{0KBD3NLW8(M}G0{UMR.png");
    //            img.setAlignment(Image.ALIGN_CENTER);
    //            img.scaleAbsolute(328, 370);
    //            document.add(img);
        *//**
         * 生成统计图
         *//*
        PieDataset dataset = pieDataSet();
        JFreeChart chart = ChartFactory.createPieChart3D(
                " 项目进度分布", // chart title
                dataset,// data
                true,// include legend
                true,
                false
        );
        PiePlot3D plot=(PiePlot3D)chart.getPlot();
        //设置Label字体
                plot.setLabelFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 12));
        //设置legend字体
                chart.getLegend().setItemFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 12));
        // 图片中显示百分比:默认方式
        //plot.setLabelGenerator(new StandardPieSectionLabelGenerator(StandardPieToolTipGenerator.DEFAULT_TOOLTIP_FORMAT));
        // 图片中显示百分比:自定义方式，{0} 表示选项， {1} 表示数值， {2} 表示所占比例 ,小数点后两位
                plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
        // 图例显示百分比:自定义方式， {0} 表示选项， {1} 表示数值， {2} 表示所占比例
                plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})"));
        // 设置背景色为白色
                chart.setBackgroundPaint(Color.white);
        // 指定图片的透明度(0.0-1.0)
                plot.setForegroundAlpha(1.0f);
        // 指定显示的饼图上圆形(false)还椭圆形(true)
                plot.setCircular(true);
        // 设置图标题的字体
        java.awt.Font font = new java.awt.Font(" 黑体",java.awt.Font.CENTER_BASELINE,20);
        TextTitle title = new TextTitle("项目状态分布");
                title.setFont(font);
                chart.setTitle(title);
        FileOutputStream fos_jpg = null;
                try {
            fos_jpg=new FileOutputStream("C:\\ACDM\\项目状态分布.jpg");
            ChartUtils.writeChartAsJPEG(fos_jpg,0.7f,chart,800,1000,null);
            fos_jpg.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

                document.newPage();
        Paragraph pieParagraph = new Paragraph("02、饼状图测试", fontChinese_content);
                pieParagraph.setAlignment(Paragraph.ALIGN_LEFT);
                document.add(pieParagraph);
        Image pieImage = Image.getInstance("C:\\ACDM\\项目状态分布.jpg");
                pieImage.setAlignment(Image.ALIGN_CENTER);
                pieImage.scaleAbsolute(328, 370);
                document.add(pieImage);

        *//**
         * 折线图
         *//*
        CategoryDataset lineDataset = lineDataset();
        JFreeChart lineChart = ChartFactory.createLineChart("java图书销量",
                "java图书",
                "销量",
                lineDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
        );
                lineChart.getLegend().setItemFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 16));
        //获取title
                lineChart.getTitle().setFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 16));

        //获取绘图区对象
        CategoryPlot linePlot = lineChart.getCategoryPlot();
                linePlot.setBackgroundAlpha(0.1f);

        //获取坐标轴对象
        CategoryAxis lineAxis = linePlot.getDomainAxis();
        //设置坐标轴字体
                lineAxis.setLabelFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 12));
        //设置坐标轴标尺值字体（x轴）
                lineAxis.setTickLabelFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 12));
        //获取数据轴对象（y轴）
        ValueAxis rangeAxis = linePlot.getRangeAxis();
                rangeAxis.setLabelFont(new java.awt.Font("微软雅黑", java.awt.Font.BOLD, 12));


        *//*
         * 生成图片
         *//*
        FileOutputStream fos = null;
                try {
            fos = new FileOutputStream("C:\\ACDM\\java图书销量.jpg");
            ChartUtils.writeChartAsJPEG(fos, 0.7f, lineChart, 600, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Paragraph lineParagraph = new Paragraph("02、折线图测试", fontChinese_content);
                lineParagraph.setAlignment(Paragraph.ALIGN_LEFT);
                document.add(lineParagraph);
        Image image = Image.getInstance("C:\\ACDM\\java图书销量.jpg");
                image.setAlignment(Image.ALIGN_CENTER);
                image.scaleAbsolute(600, 300);
                document.add(image);

                System.out.println("over");
  }*/

   /* private static CategoryDataset lineDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        //添加第一季度数据
        dataSet.addValue(6000, "第一季度", "J2SE类");
        dataSet.addValue(3000, "第一季度", "J2ME类");
        dataSet.addValue(12000, "第一季度", "J2EE类");
        //添加第二季度数据
        dataSet.addValue(8000, "第二季度", "J2SE类");
        dataSet.addValue(4000, "第二季度", "J2ME类");
        dataSet.addValue(6000, "第二季度", "J2EE类");
        //添加第三季度数据
        dataSet.addValue(5000, "第三季度", "J2SE类");
        dataSet.addValue(4000, "第三季度", "J2ME类");
        dataSet.addValue(8000, "第三季度", "J2EE类");
        //添加第四季度数据
        dataSet.addValue(8000, "第四季度", "J2SE类");
        dataSet.addValue(2000, "第四季度", "J2ME类");
        dataSet.addValue(9000, "第四季度", "J2EE类");
        return dataSet;
    }

    private static PieDataset pieDataSet() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(" 市场前期", new Double(10));
        dataset.setValue(" 立项", new Double(15));
        dataset.setValue(" 计划", new Double(10));
        dataset.setValue(" 需求与设计", new Double(10));
        dataset.setValue(" 执行控制", new Double(35));
        dataset.setValue(" 收尾", new Double(10));
        dataset.setValue(" 运维",new Double(10));
        return dataset;
    }

    private static CategoryDataset createDataset1()

    {

        String s = "S1";

        String s1 = "S2";

        String s2 = "S3";

        String s3 = "Category 1";

        String s4 = "Category 2";

        String s5 = "Category 3";

        String s6 = "Category 4";

        String s7 = "Category 5";

        String s8 = "Category 6";

        String s9 = "Category 7";

        String s10 = "Category 8";

        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

        defaultcategorydataset.addValue(1.0D, s, s3);

        defaultcategorydataset.addValue(4D, s, s4);

        defaultcategorydataset.addValue(3D, s, s5);

        defaultcategorydataset.addValue(5D, s, s6);

        defaultcategorydataset.addValue(5D, s, s7);

        defaultcategorydataset.addValue(7D, s, s8);

        defaultcategorydataset.addValue(7D, s, s9);

        defaultcategorydataset.addValue(8D, s, s10);

        defaultcategorydataset.addValue(5D, s1, s3);

        defaultcategorydataset.addValue(7D, s1, s4);

        defaultcategorydataset.addValue(6D, s1, s5);

        defaultcategorydataset.addValue(8D, s1, s6);

        defaultcategorydataset.addValue(4D, s1, s7);

        defaultcategorydataset.addValue(4D, s1, s8);

        defaultcategorydataset.addValue(2D, s1, s9);

        defaultcategorydataset.addValue(1.0D, s1, s10);

        defaultcategorydataset.addValue(4D, s2, s3);

        defaultcategorydataset.addValue(3D, s2, s4);

        defaultcategorydataset.addValue(2D, s2, s5);

        defaultcategorydataset.addValue(3D, s2, s6);

        defaultcategorydataset.addValue(6D, s2, s7);

        defaultcategorydataset.addValue(3D, s2, s8);

        defaultcategorydataset.addValue(4D, s2, s9);

        defaultcategorydataset.addValue(3D, s2, s10);

        return defaultcategorydataset;

    }

    private static CategoryDataset createDataset2()

    {

        String s = "S4";

        String s1 = "Category 1";

        String s2 = "Category 2";

        String s3 = "Category 3";

        String s4 = "Category 4";

        String s5 = "Category 5";

        String s6 = "Category 6";

        String s7 = "Category 7";

        String s8 = "Category 8";

        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

        defaultcategorydataset.addValue(15D, s, s1);

        defaultcategorydataset.addValue(24D, s, s2);

        defaultcategorydataset.addValue(31D, s, s3);

        defaultcategorydataset.addValue(25D, s, s4);

        defaultcategorydataset.addValue(56D, s, s5);

        defaultcategorydataset.addValue(37D, s, s6);

        defaultcategorydataset.addValue(77D, s, s7);

        defaultcategorydataset.addValue(18D, s, s8);

        return defaultcategorydataset;

    }*/


}