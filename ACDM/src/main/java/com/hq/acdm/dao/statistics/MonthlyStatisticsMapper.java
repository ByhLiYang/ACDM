package com.hq.acdm.dao.statistics;

import com.hq.acdm.vo.statistics.monthlyStatistics.MonthlyStatisticsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/12/25 14:34
 * @Description
 */
public interface MonthlyStatisticsMapper {
    @Select({
            "select T1.FLIGHT_NO_IATA, T1.DEST_AIRPORT_IATA,T1.ZS,T2.YWS YW,T3.YWS BZC,\n" +
                    "    nvl(trunc((T2.DELAYTIME/T2.YWS)/60),'0') || ':' || nvl(MOD(trunc(T2.DELAYTIME/T2.YWS),60),'0') AVGTIME,\n" +
                    "        COALESCE(round(((ZS- nvl( T2.YWS , 0 ))/ZS) * 100, 2) || '%','0%') FXL,\n" +
                    "        COALESCE(round(((ZS- nvl( T3.YWS , 0 ))/ZS) * 100, 2) || '%','0%') ZCL  \n" +
                    "from (\n" +
                    "        select  H1.FLIGHT_NO_IATA  FLIGHT_NO_IATA,\n" +
                    "                H1.DEST_AIRPORT_IATA  DEST_AIRPORT_IATA,      \n" +
                    "               (CASE WHEN H1.YWS is null THEN 0  ELSE H1.YWS END) ZS \n" +
                    "        from (\n" +
                    "        --guozhan  ZONGSHU\n" +
                    "           SELECT AA.FLIGHT_NO_IATA,DEST_AIRPORT_IATA,count(*) YWS\n" +
                    "           FROM HISTORICAL_FLIGHT_MASTER AA\n" +
                    "      LEFT JOIN HISTORICAL_FLIGHT_ADD_DETAILS BB ON\n" +
                    "        AA.FLIGHT_NO_IATA = BB.FLIGHT_NO_IATA AND\n" +
                    "        AA.OPERATIONAL_DATE = BB.OPERATIONAL_DATE AND\n" +
                    "        AA.A_OR_D = BB.A_OR_D AND\n" +
                    "        AA.FLIGHT_REPEAT_COUNT = BB.FLIGHT_REPEAT_COUNT\n" +
                    "      LEFT JOIN (SELECT SIBT,FLIGHT_NO_IATA,OPERATIONAL_DATE,FLIGHT_REPEAT_COUNT,ALDT FROM HISTORICAL_FLIGHT_MASTER WHERE A_OR_D='A') CC ON\n" +
                    "        (BB.LNK_CARRIER_CODE || BB.LNK_FLIGHT_NO || COALESCE(BB.LNK_FLIGHT_SUFFIX,'')) = CC.FLIGHT_NO_IATA AND\n" +
                    "        BB.LNK_FLIGHT_REPEAT_COUNT = CC.FLIGHT_REPEAT_COUNT AND\n" +
                    "        BB.LNK_SCHEDULE_DATE = CC.OPERATIONAL_DATE\n" +
                    "      WHERE\n" +
                    "        AA.A_OR_D ='D' AND\n" +
                    "        nvl(BB.FLIGHT_CANCEL_CODE,' ') <> 'C' AND\n" +
                    "        nvl(BB.CODE_SHARE_STATUS,' ') <> 'SF' AND\n" +
                    "        BB.FLIGHT_CLASS_CODE IN ('L/W', 'W/Z', 'C/B') AND\n" +
                    "                TO_CHAR(AA.OPERATIONAL_DATE,'YYYY-MM-DD')>=#{startDate,jdbcType=VARCHAR} and TO_CHAR(AA.OPERATIONAL_DATE,'YYYY-MM-DD')<#{endDate,jdbcType=VARCHAR}  \n" +
                    "                  group by  AA.FLIGHT_NO_IATA,DEST_AIRPORT_IATA\n" +
                    "         ) H1  \n" +
                    "         where H1.YWS>=10\n" +
                    "           ) \n" +
                    "            T1  \n" +
                    "            --FANGXING BUZHENGCHANG\n" +
                    "           left join(\n" +
                    "           select H2.FLIGHT_NO_IATA  FLIGHT_NO_IATA,\n" +
                    "             H2.DEST_AIRPORT_IATA  DEST_AIRPORT_IATA,   \n" +
                    "           nvl(YWS , 0 ) YWS ,DELAYTIME from (\n" +
                    "           --GUOZHAN YANWU\n" +
                    "            SELECT AA.FLIGHT_NO_IATA,DEST_AIRPORT_IATA,\n" +
                    "            SUM((cast((COALESCE(AA.ATOT,sysdate)-INTERVAL '30' minute) as date)  - cast(AA.SOBT as date))*24*60) DELAYTIME\n" +
                    "            ,COUNT(*) YWS\n" +
                    "             FROM HISTORICAL_FLIGHT_MASTER AA\n" +
                    "        LEFT JOIN HISTORICAL_FLIGHT_ADD_DETAILS BB ON\n" +
                    "          AA.FLIGHT_NO_IATA = BB.FLIGHT_NO_IATA AND\n" +
                    "          AA.OPERATIONAL_DATE = BB.OPERATIONAL_DATE AND\n" +
                    "          AA.A_OR_D = BB.A_OR_D AND\n" +
                    "          AA.FLIGHT_REPEAT_COUNT = BB.FLIGHT_REPEAT_COUNT\n" +
                    "        LEFT JOIN (SELECT SIBT,FLIGHT_NO_IATA,OPERATIONAL_DATE,FLIGHT_REPEAT_COUNT,ALDT FROM HISTORICAL_FLIGHT_MASTER WHERE A_OR_D='A') CC ON\n" +
                    "          (BB.LNK_CARRIER_CODE || BB.LNK_FLIGHT_NO || COALESCE(BB.LNK_FLIGHT_SUFFIX,'')) = CC.FLIGHT_NO_IATA AND\n" +
                    "          BB.LNK_FLIGHT_REPEAT_COUNT = CC.FLIGHT_REPEAT_COUNT AND\n" +
                    "          BB.LNK_SCHEDULE_DATE = CC.OPERATIONAL_DATE\n" +
                    "        WHERE\n" +
                    "          AA.A_OR_D ='D' AND\n" +
                    "          nvl(BB.FLIGHT_CANCEL_CODE,' ') <> 'C' AND\n" +
                    "          nvl(BB.CODE_SHARE_STATUS,' ') <> 'SF' AND\n" +
                    "          BB.FLIGHT_CLASS_CODE IN ('L/W', 'W/Z', 'C/B') AND  \n" +
                    "                  TO_CHAR(AA.OPERATIONAL_DATE,'YYYY-MM-DD')>=#{startDate,jdbcType=VARCHAR} and TO_CHAR(AA.OPERATIONAL_DATE,'YYYY-MM-DD')<#{endDate,jdbcType=VARCHAR}  \n" +
                    "                  AND ((CC.ALDT+ interval '10' MINUTE > CC.SIBT AND AA.ATOT-(AA.SOBT-CC.SIBT)>=CC.ALDT+ interval '40' MINUTE)\n" +
                    "                  OR(CC.ALDT+interval '10' MINUTE<=CC.SIBT AND AA.SOBT<(AA.ATOT-interval '30' MINUTE)))\n" +
                    "                    group by  AA.FLIGHT_NO_IATA,DEST_AIRPORT_IATA\n" +
                    "                   ) H2          \n" +
                    "           ) T2\n" +
                    "              on T1.FLIGHT_NO_IATA=T2.FLIGHT_NO_IATA  and T1.DEST_AIRPORT_IATA=T2.DEST_AIRPORT_IATA              \n" +
                    "           LEFT JOIN (   ---BUZHENGCHANG\n" +
                    "            select H2.FLIGHT_NO_IATA  FLIGHT_NO_IATA,\n" +
                    "             H2.DEST_AIRPORT_IATA  DEST_AIRPORT_IATA,\n" +
                    "           (CASE WHEN H2.YWS is null THEN 0 ELSE H2.YWS  END) YWS from (\n" +
                    "           --GUOZHAN YANWU\n" +
                    "            SELECT AA.FLIGHT_NO_IATA,DEST_AIRPORT_IATA,count(*) YWS\n" +
                    "            --,SUM( TIMESTAMPDIFF(4 ,CHAR(AA.ATOT))-30 MINUTES - AA.SOBT) delaytime\n" +
                    "             FROM HISTORICAL_FLIGHT_MASTER AA\n" +
                    "        LEFT JOIN HISTORICAL_FLIGHT_ADD_DETAILS BB ON\n" +
                    "          AA.FLIGHT_NO_IATA = BB.FLIGHT_NO_IATA AND\n" +
                    "          AA.OPERATIONAL_DATE = BB.OPERATIONAL_DATE AND\n" +
                    "          AA.A_OR_D = BB.A_OR_D AND\n" +
                    "          AA.FLIGHT_REPEAT_COUNT = BB.FLIGHT_REPEAT_COUNT\n" +
                    "        LEFT JOIN (SELECT SIBT,FLIGHT_NO_IATA,OPERATIONAL_DATE,FLIGHT_REPEAT_COUNT,ALDT FROM HISTORICAL_FLIGHT_MASTER WHERE A_OR_D='A') CC ON\n" +
                    "          (BB.LNK_CARRIER_CODE || BB.LNK_FLIGHT_NO || COALESCE(BB.LNK_FLIGHT_SUFFIX,'')) = CC.FLIGHT_NO_IATA AND\n" +
                    "          BB.LNK_FLIGHT_REPEAT_COUNT = CC.FLIGHT_REPEAT_COUNT AND\n" +
                    "          BB.LNK_SCHEDULE_DATE = CC.OPERATIONAL_DATE\n" +
                    "        WHERE\n" +
                    "          AA.A_OR_D ='D' AND\n" +
                    "          nvl(BB.FLIGHT_CANCEL_CODE,' ') <> 'C' AND\n" +
                    "          nvl(BB.CODE_SHARE_STATUS,' ') <> 'SF' AND\n" +
                    "          BB.FLIGHT_CLASS_CODE IN ('L/W', 'W/Z', 'C/B') AND     \n" +
                    "                  TO_CHAR(AA.OPERATIONAL_DATE,'YYYY-MM-DD')>=#{startDate,jdbcType=VARCHAR} and TO_CHAR(AA.OPERATIONAL_DATE,'YYYY-MM-DD')<#{endDate,jdbcType=VARCHAR}                 \n" +
                    "                  AND AA.SOBT<AA.ATOT-interval '30' MINUTE\n" +
                    "                 group by  AA.FLIGHT_NO_IATA,DEST_AIRPORT_IATA\n" +
                    "                   ) H2  \n" +
                    "              )T3 on T1.FLIGHT_NO_IATA=T3.FLIGHT_NO_IATA  and T1.DEST_AIRPORT_IATA=T3.DEST_AIRPORT_IATA\n" +
                    "               order by round(((ZS- nvl(T2.YWS,0) ) * 1.0 /ZS) * 100, 2)"
    })
    List<MonthlyStatisticsVo> findMonthlyStatistics(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
