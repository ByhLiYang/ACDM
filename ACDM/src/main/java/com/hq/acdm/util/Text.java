package com.hq.acdm.util;


import com.hq.acdm.vo.dynamicFlight.AirPlanFoodVo;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.springframework.util.ResourceUtils;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public class Text {
    public static void main(String[] args) {
        String endtime="";
        if (endtime.compareTo( "14:25")<0)
            endtime="14:25";
        System.out.println(endtime);

    }
    public static void s5(){

        XLSReader mainReader = null;

        try {
            InputStream is = new FileInputStream("C:\\ACDM\\csConfig.xml");
            InputStream inputXML = new BufferedInputStream(is);

            mainReader = ReaderBuilder.buildFromXML(inputXML);
            InputStream is2 = new FileInputStream("C:\\ACDM\\hotelInfo.xls");
            InputStream inputXLS = new BufferedInputStream(is2);
            List<AirPlanFoodVo> airPlanFoodList = new ArrayList<>();
            Map<String, Object> beans = new HashMap();
            beans.put("airPlanFoodList", airPlanFoodList);
            XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
            System.out.println(airPlanFoodList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
    public static void s4(){
        //优化方法days天数
        int days = 0;
        int year=2100;
        int month=2;
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            days = 31;
        }else if (month==4||month==6||month==9||month==11){
            days = 30;
        }else if (month==2){
            if( year%4==0&&year%100!=0||year%400==0){
                days = 29;
            }else {
                days = 28;
            }
        }else {
            System.out.println("请输入正确的月份");
        }
        System.out.println(year+"年"+month+"月"+"这个月有"+days+"天");

    }
    public static void s3(){
        try {
            Document document = new Document();
//Step 2—Get a PdfWriter instance.
            PdfWriter.getInstance(document, new FileOutputStream("C:\\ACDM\\" + "createSamplePDF.pdf"));
//Step 3—Open the Document.
            document.open();
            Font fontZH = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.RED);
            //fontZH=new Font();
//Step 4—Add content.
            PdfPTable table = new PdfPTable(7);
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("机场运量统计",fontZH));
            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式

            cell.setColspan(7);

            table.addCell(cell);

            table.addCell("项目");
            table.addCell("12月3日");
            table.addCell("同比");
            table.addCell("月度累计");
            table.addCell("同比");
            table.addCell("年度累计");
            table.addCell("同比");

            table.addCell("运输量(架次)");
            table.addCell("505");
            table.addCell("-");
            table.addCell("1494");
            table.addCell("-");
            table.addCell("4056");
            table.addCell("-");

            table.addCell("人数(万)");
            table.addCell("1.2222");
            table.addCell("-");
            table.addCell("6.8607");
            table.addCell("-");
            table.addCell("22.5527");
            table.addCell("-");

//100%
            table.setWidthPercentage(100);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            document.add(table);
            document.add(new Paragraph("\n"));



            document.add(table);
            document.add(new Paragraph("\n"));


            document.add(table);
            document.add(new Paragraph("\n"));



//Step 5—Close the Document.
            document.close();
        }catch (Exception e){

        }

    }

    public static void s2(){
//通过实体类实现comparable接口来实现内部排序
        Person a = new Person("张三",23);
        Person b = new Person("王五",43);
        Person c = new Person("李四",12);
        List<Person> plist = new ArrayList<Person>();
        plist.add(a);
        plist.add(b);
        plist.add(c);
        Collections.sort(plist);
        for(Person info : plist){
            System.out.println(info.getName()+"--------"+info.getAge());
        }
    }
    public static void s1() {
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("4");
        list.add("23");
//Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int x1 = Integer.parseInt(o1);
                int x2 = Integer.parseInt(o2);
                return x1>x2?1:(x1==x2?0:-1);
            }
        });
        for(String info : list){
            System.out.println(info);
        }
    }

    /**
     * 根据pdf模板输出流
     * @param templateFilePath
     * @param templateFileName
     * @param resultMap
     * @return
     */
    public static ByteArrayOutputStream createPdfStream(String templateFilePath, String templateFileName,
                                                        Map<String, Object> resultMap,ByteArrayOutputStream ba) {


        try {

            PdfReader reader = new PdfReader(templateFilePath + "\\" + templateFileName);
            PdfStamper stamp = new PdfStamper(reader, ba);

            //使用字体
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.RED);
            Font fontZH = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,10f, Font.NORMAL, BaseColor.RED);
            ;
            /* 获取模版中的字段 */
            AcroFields form = stamp.getAcroFields();
            form.addSubstitutionFont(bf);
            //填充表单
            if (resultMap != null) {
                for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
                    //form.setFieldProperty(entry.getKey(), "textfont", bf, null);
                    //form.setFieldProperty(entry.getKey(), "textcolor ", BaseColor.RED, null);
                   // form.setFieldProperty(entry.getKey(), "textsize ", BaseColor.RED, null);
                    //Color custom = new Color(228,102,0);
                    //fields.setFieldProperty("text_2", "bordercolor", custom, null);
                    //form.setFieldProperty(entry.getKey(), "bordercolor ", BaseColor.RED, null);
                    if (entry.getValue()!=null)
                    form.setField(entry.getKey(), entry.getValue().toString());
                }
            }

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
            JFreeChart chart = ChartFactory.createBarChart3D(
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
            chart.getTitle().setFont(new java.awt.Font("黑体", java.awt.Font.BOLD,18));
            chart.getLegend().setItemFont(new java.awt.Font("黑体", java.awt.Font.BOLD,18));
            chart.getLegend().setPosition(RectangleEdge.TOP);
            //获取图表区域对象
            CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();

            //获取X轴的对象
            CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();

            //获取Y轴的对象
            NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();

            //处理X轴上的乱码
            categoryAxis3D.setTickLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,10));

            //处理X轴外的乱码
            categoryAxis3D.setLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,10));

            //处理Y轴上的乱码
            numberAxis3D.setTickLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,10));

            //处理Y轴外的乱码
            numberAxis3D.setLabelFont(new java.awt.Font("黑体", java.awt.Font.BOLD,10));

            //自定义Y轴上显示的刻度，以10作为1格
            numberAxis3D.setAutoTickUnitSelection(false);
            NumberTickUnit unit = new NumberTickUnit(10);
            numberAxis3D.setRange(0,50);
            numberAxis3D.setTickUnit(unit);

            //获取绘图区域对象
            BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();

            //设置柱形图的宽度
            barRenderer3D.setMaximumBarWidth(0.07);

            //在图形上显示数字
            barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            barRenderer3D.setBaseItemLabelsVisible(true);
            barRenderer3D.setBaseItemLabelFont(new java.awt.Font("宋体", java.awt.Font.BOLD,10));
            // barRenderer3D.setBaseItemLabelPaint(Color.blue);
            barRenderer3D.setSeriesPaint(0, new Color(142,180,227));
            barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BOTTOM_CENTER));
            barRenderer3D.setItemLabelAnchorOffset(10);

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

            categoryPlot.setRenderer(1, lineandshaperenderer);
            // 柱状图和纵轴紧靠
            categoryAxis3D.setLowerMargin(0.0);

            categoryAxis3D.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
            //折线在柱面前面显示
            categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

            /*
             * 在E盘目录下生成图片
             */
            File file = new File("C:\\ACDM\\A.png");
            try {
                ChartUtilities.saveChartAsJPEG(file, chart, 460, 250);
            } catch (IOException e) {
                e.printStackTrace();
            }

            PushbuttonField ad = form.getNewPushbuttonFromField("af_image");
            ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
            ad.setProportionalIcon(true);
            ad.setImage(Image.getInstance("C:\\ACDM\\A.png"));
            form.replacePushbuttonField("af_image", ad.getField());

            stamp.setFormFlattening(true);//不能编辑
            stamp.close();

            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        }
        return ba;
    }

    public static void b1(){
        //1.准备数据源
        Map<String, Object> resultMap=new HashMap<>();
        //机场运量统计
        resultMap.put("yltj0",null);
        resultMap.put("yltj1","yltj1");
        resultMap.put("yltj2","yltj2");
        resultMap.put("yltj3","yltj3");
        resultMap.put("yltj4","yltj4");
        resultMap.put("yltj5","yltj5");
        resultMap.put("yltj6","yltj6");
        resultMap.put("yltj7","yltj7");
        resultMap.put("yltj8","yltj8");
        resultMap.put("yltj9","yltj9");
        resultMap.put("yltj10","yltj10");
        resultMap.put("yltj11","yltj11");
        resultMap.put("yltj12","yltj12");
        resultMap.put("yltj13","(2020年12月2号)");

        //【航班正常性统计
        resultMap.put("hbzcxtj0","12月2号");
        resultMap.put("hbzcxtj1","hbzcxtj1");
        resultMap.put("hbzcxtj2","hbzcxtj2");
        resultMap.put("hbzcxtj3","hbzcxtj3");
        resultMap.put("hbzcxtj4","hbzcxtj4");
        resultMap.put("hbzcxtj5","hbzcxtj5");
        resultMap.put("hbzcxtj6","hbzcxtj6");
        resultMap.put("hbzcxtj7","hbzcxtj7");
        resultMap.put("hbzcxtj8","hbzcxtj8");
        resultMap.put("hbzcxtj9","hbzcxtj9");
        resultMap.put("hbzcxtj10","hbzcxtj10");
        resultMap.put("hbzcxtj11","hbzcxtj11");
        resultMap.put("hbzcxtj12","hbzcxtj12");
        resultMap.put("hbzcxtj13","hbzcxtj13");
        resultMap.put("hbzcxtj14","hbzcxtj14");
        resultMap.put("hbzcxtj15","hbzcxtj15");
        resultMap.put("hbzcxtj16","hbzcxtj16");
        resultMap.put("hbzcxtj17","hbzcxtj17");
        resultMap.put("hbzcxtj18","hbzcxtj18");

        //延误原因统计
        resultMap.put("ywyy0","ywyy0");
        resultMap.put("ywyy1","ywyy1");
        resultMap.put("ywyy2","ywyy2");
        resultMap.put("ywyy3","ywyy3");
        resultMap.put("ywyy4","ywyy4");
        resultMap.put("ywyy5","ywyy5");
        resultMap.put("ywyy6","ywyy6");
        resultMap.put("ywyy7","ywyy7");
        resultMap.put("ywyy8","ywyy8");
        resultMap.put("ywyy9","ywyy9");
        resultMap.put("ywyy10","ywyy10");
        resultMap.put("ywyy11","ywyy11");
        resultMap.put("ywyy12","22");

        //航班进程质量管控
        resultMap.put("jczljg0","12月2号");
        resultMap.put("jczljg1","jczljg1");
        resultMap.put("jczljg2","jczljg2");
        resultMap.put("jczljg3","jczljg3");
        resultMap.put("jczljg4","实际小时起降架次\n平均进港滑行时间\n平均出港滑行时间");
        resultMap.put("jczljg5","jczljg5");
        resultMap.put("jczljg6","jczljg6");
        resultMap.put("jczljg7","jczljg7");
        resultMap.put("jczljg8","jczljg8");

        //加权平均值排名
        resultMap.put("fxzclpm0","12月2号");
        resultMap.put("fxzclpm1","fxzclpm1");
        resultMap.put("fxzclpm2","fxzclpm2");
        resultMap.put("fxzclpm3","fxzclpm3");
        resultMap.put("fxzclpm4","fxzclpm4");
        resultMap.put("fxzclpm5","fxzclpm5");
        resultMap.put("fxzclpm6","月度累计");
        resultMap.put("fxzclpm7","fxzclpm7");
        resultMap.put("fxzclpm8","fxzclpm8");
        resultMap.put("fxzclpm9","fxzclpm9");
        resultMap.put("fxzclpm10","fxzclpm10");
        resultMap.put("fxzclpm11","fxzclpm11");

        //航班正常管理提示
        resultMap.put("flTips","民航局航班正常统计系统显示:11月份武汉天河机场航班正常性加权平均值达到93.84％，预计排名全" +
                "国24个二千万级以上机场第5名，实现了2020年5-11月份连续7个月排名全国前5名！\n");
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
//3.输出填充后的文件
        String newPadPath="C:\\ACDM"+"\\11.pdf";
        try (
        //2.根据模板填充数据源
        ByteArrayOutputStream pdf = createPdfStream(ResourceUtils.getFile("classpath:template").getAbsolutePath(), "cs.pdf", resultMap,ba);



                FileOutputStream out = new FileOutputStream(newPadPath)) {

            out.write(pdf.toByteArray());
            out.flush();
            out.close();
            pdf.close();
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
