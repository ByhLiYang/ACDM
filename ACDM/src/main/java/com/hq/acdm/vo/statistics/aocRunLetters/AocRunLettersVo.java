package com.hq.acdm.vo.statistics.aocRunLetters;

import lombok.Data;

/**
 * AOC运行快报 VO
 */
@Data
public class AocRunLettersVo {
    private String FLIGHT_NUM;//计划执行航班
    private String ALREADY_NUM;//实际航班数
    private String RELEASE;//放行率
    private String NORMAL;///正常率
    private String GWFlight;//公务机数量
    private String PASSENGER_NUM;//旅客数量
    private String SFFX;//始发放行率
    private String KQ;//靠桥率
    private String JHZS;//京沪航班总数
    private String JHZC;//京沪快线放行正常数
    private String JHBZC;
    private String JHNORMAL;
    private String A;
    private String B;
    private String C;
    private String D;










}
