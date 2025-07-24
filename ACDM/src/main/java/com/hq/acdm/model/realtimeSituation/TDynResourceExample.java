package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDynResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDynResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFlightIdIsNull() {
            addCriterion("FLIGHT_ID is null");
            return (Criteria) this;
        }

        public Criteria andFlightIdIsNotNull() {
            addCriterion("FLIGHT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFlightIdEqualTo(Long value) {
            addCriterion("FLIGHT_ID =", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotEqualTo(Long value) {
            addCriterion("FLIGHT_ID <>", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThan(Long value) {
            addCriterion("FLIGHT_ID >", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FLIGHT_ID >=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThan(Long value) {
            addCriterion("FLIGHT_ID <", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThanOrEqualTo(Long value) {
            addCriterion("FLIGHT_ID <=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdIn(List<Long> values) {
            addCriterion("FLIGHT_ID in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotIn(List<Long> values) {
            addCriterion("FLIGHT_ID not in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdBetween(Long value1, Long value2) {
            addCriterion("FLIGHT_ID between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotBetween(Long value1, Long value2) {
            addCriterion("FLIGHT_ID not between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andRscTypeIsNull() {
            addCriterion("RSC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRscTypeIsNotNull() {
            addCriterion("RSC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRscTypeEqualTo(String value) {
            addCriterion("RSC_TYPE =", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeNotEqualTo(String value) {
            addCriterion("RSC_TYPE <>", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeGreaterThan(String value) {
            addCriterion("RSC_TYPE >", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RSC_TYPE >=", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeLessThan(String value) {
            addCriterion("RSC_TYPE <", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeLessThanOrEqualTo(String value) {
            addCriterion("RSC_TYPE <=", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeLike(String value) {
            addCriterion("RSC_TYPE like", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeNotLike(String value) {
            addCriterion("RSC_TYPE not like", value, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeIn(List<String> values) {
            addCriterion("RSC_TYPE in", values, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeNotIn(List<String> values) {
            addCriterion("RSC_TYPE not in", values, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeBetween(String value1, String value2) {
            addCriterion("RSC_TYPE between", value1, value2, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscTypeNotBetween(String value1, String value2) {
            addCriterion("RSC_TYPE not between", value1, value2, "rscType");
            return (Criteria) this;
        }

        public Criteria andRscCd1IsNull() {
            addCriterion("RSC_CD_1 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd1IsNotNull() {
            addCriterion("RSC_CD_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd1EqualTo(String value) {
            addCriterion("RSC_CD_1 =", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1NotEqualTo(String value) {
            addCriterion("RSC_CD_1 <>", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1GreaterThan(String value) {
            addCriterion("RSC_CD_1 >", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_1 >=", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1LessThan(String value) {
            addCriterion("RSC_CD_1 <", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_1 <=", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1Like(String value) {
            addCriterion("RSC_CD_1 like", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1NotLike(String value) {
            addCriterion("RSC_CD_1 not like", value, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1In(List<String> values) {
            addCriterion("RSC_CD_1 in", values, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1NotIn(List<String> values) {
            addCriterion("RSC_CD_1 not in", values, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1Between(String value1, String value2) {
            addCriterion("RSC_CD_1 between", value1, value2, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andRscCd1NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_1 not between", value1, value2, "rscCd1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1IsNull() {
            addCriterion("ALTERATE_START_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1IsNotNull() {
            addCriterion("ALTERATE_START_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_1 =", value, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_1 <>", value, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_1 >", value, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_1 >=", value, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_1 <", value, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_1 <=", value, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_1 in", values, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_1 not in", values, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_1 between", value1, value2, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime1NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_1 not between", value1, value2, "alterateStartTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1IsNull() {
            addCriterion("ALTERATE_END_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1IsNotNull() {
            addCriterion("ALTERATE_END_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_1 =", value, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_1 <>", value, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_1 >", value, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_1 >=", value, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_1 <", value, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_1 <=", value, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_1 in", values, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_1 not in", values, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_1 between", value1, value2, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime1NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_1 not between", value1, value2, "alterateEndTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1IsNull() {
            addCriterion("START_REAL_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1IsNotNull() {
            addCriterion("START_REAL_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1EqualTo(Date value) {
            addCriterion("START_REAL_TIME_1 =", value, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_1 <>", value, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_1 >", value, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_1 >=", value, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1LessThan(Date value) {
            addCriterion("START_REAL_TIME_1 <", value, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_1 <=", value, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1In(List<Date> values) {
            addCriterion("START_REAL_TIME_1 in", values, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_1 not in", values, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_1 between", value1, value2, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andStartRealTime1NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_1 not between", value1, value2, "startRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1IsNull() {
            addCriterion("END_REAL_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1IsNotNull() {
            addCriterion("END_REAL_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1EqualTo(Date value) {
            addCriterion("END_REAL_TIME_1 =", value, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_1 <>", value, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_1 >", value, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_1 >=", value, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1LessThan(Date value) {
            addCriterion("END_REAL_TIME_1 <", value, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_1 <=", value, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1In(List<Date> values) {
            addCriterion("END_REAL_TIME_1 in", values, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_1 not in", values, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_1 between", value1, value2, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andEndRealTime1NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_1 not between", value1, value2, "endRealTime1");
            return (Criteria) this;
        }

        public Criteria andRscCd2IsNull() {
            addCriterion("RSC_CD_2 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd2IsNotNull() {
            addCriterion("RSC_CD_2 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd2EqualTo(String value) {
            addCriterion("RSC_CD_2 =", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2NotEqualTo(String value) {
            addCriterion("RSC_CD_2 <>", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2GreaterThan(String value) {
            addCriterion("RSC_CD_2 >", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_2 >=", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2LessThan(String value) {
            addCriterion("RSC_CD_2 <", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_2 <=", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2Like(String value) {
            addCriterion("RSC_CD_2 like", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2NotLike(String value) {
            addCriterion("RSC_CD_2 not like", value, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2In(List<String> values) {
            addCriterion("RSC_CD_2 in", values, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2NotIn(List<String> values) {
            addCriterion("RSC_CD_2 not in", values, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2Between(String value1, String value2) {
            addCriterion("RSC_CD_2 between", value1, value2, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andRscCd2NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_2 not between", value1, value2, "rscCd2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2IsNull() {
            addCriterion("ALTERATE_START_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2IsNotNull() {
            addCriterion("ALTERATE_START_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_2 =", value, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_2 <>", value, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_2 >", value, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_2 >=", value, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_2 <", value, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_2 <=", value, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_2 in", values, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_2 not in", values, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_2 between", value1, value2, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime2NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_2 not between", value1, value2, "alterateStartTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2IsNull() {
            addCriterion("ALTERATE_END_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2IsNotNull() {
            addCriterion("ALTERATE_END_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_2 =", value, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_2 <>", value, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_2 >", value, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_2 >=", value, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_2 <", value, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_2 <=", value, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_2 in", values, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_2 not in", values, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_2 between", value1, value2, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime2NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_2 not between", value1, value2, "alterateEndTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2IsNull() {
            addCriterion("START_REAL_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2IsNotNull() {
            addCriterion("START_REAL_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2EqualTo(Date value) {
            addCriterion("START_REAL_TIME_2 =", value, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_2 <>", value, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_2 >", value, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_2 >=", value, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2LessThan(Date value) {
            addCriterion("START_REAL_TIME_2 <", value, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_2 <=", value, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2In(List<Date> values) {
            addCriterion("START_REAL_TIME_2 in", values, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_2 not in", values, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_2 between", value1, value2, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andStartRealTime2NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_2 not between", value1, value2, "startRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2IsNull() {
            addCriterion("END_REAL_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2IsNotNull() {
            addCriterion("END_REAL_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2EqualTo(Date value) {
            addCriterion("END_REAL_TIME_2 =", value, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_2 <>", value, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_2 >", value, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_2 >=", value, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2LessThan(Date value) {
            addCriterion("END_REAL_TIME_2 <", value, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_2 <=", value, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2In(List<Date> values) {
            addCriterion("END_REAL_TIME_2 in", values, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_2 not in", values, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_2 between", value1, value2, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andEndRealTime2NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_2 not between", value1, value2, "endRealTime2");
            return (Criteria) this;
        }

        public Criteria andRscCd3IsNull() {
            addCriterion("RSC_CD_3 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd3IsNotNull() {
            addCriterion("RSC_CD_3 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd3EqualTo(String value) {
            addCriterion("RSC_CD_3 =", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3NotEqualTo(String value) {
            addCriterion("RSC_CD_3 <>", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3GreaterThan(String value) {
            addCriterion("RSC_CD_3 >", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_3 >=", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3LessThan(String value) {
            addCriterion("RSC_CD_3 <", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_3 <=", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3Like(String value) {
            addCriterion("RSC_CD_3 like", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3NotLike(String value) {
            addCriterion("RSC_CD_3 not like", value, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3In(List<String> values) {
            addCriterion("RSC_CD_3 in", values, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3NotIn(List<String> values) {
            addCriterion("RSC_CD_3 not in", values, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3Between(String value1, String value2) {
            addCriterion("RSC_CD_3 between", value1, value2, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andRscCd3NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_3 not between", value1, value2, "rscCd3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3IsNull() {
            addCriterion("ALTERATE_START_TIME_3 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3IsNotNull() {
            addCriterion("ALTERATE_START_TIME_3 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_3 =", value, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_3 <>", value, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_3 >", value, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_3 >=", value, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_3 <", value, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_3 <=", value, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_3 in", values, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_3 not in", values, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_3 between", value1, value2, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime3NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_3 not between", value1, value2, "alterateStartTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3IsNull() {
            addCriterion("ALTERATE_END_TIME_3 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3IsNotNull() {
            addCriterion("ALTERATE_END_TIME_3 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_3 =", value, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_3 <>", value, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_3 >", value, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_3 >=", value, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_3 <", value, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_3 <=", value, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_3 in", values, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_3 not in", values, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_3 between", value1, value2, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime3NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_3 not between", value1, value2, "alterateEndTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3IsNull() {
            addCriterion("START_REAL_TIME_3 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3IsNotNull() {
            addCriterion("START_REAL_TIME_3 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3EqualTo(Date value) {
            addCriterion("START_REAL_TIME_3 =", value, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_3 <>", value, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_3 >", value, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_3 >=", value, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3LessThan(Date value) {
            addCriterion("START_REAL_TIME_3 <", value, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_3 <=", value, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3In(List<Date> values) {
            addCriterion("START_REAL_TIME_3 in", values, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_3 not in", values, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_3 between", value1, value2, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andStartRealTime3NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_3 not between", value1, value2, "startRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3IsNull() {
            addCriterion("END_REAL_TIME_3 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3IsNotNull() {
            addCriterion("END_REAL_TIME_3 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3EqualTo(Date value) {
            addCriterion("END_REAL_TIME_3 =", value, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_3 <>", value, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_3 >", value, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_3 >=", value, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3LessThan(Date value) {
            addCriterion("END_REAL_TIME_3 <", value, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_3 <=", value, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3In(List<Date> values) {
            addCriterion("END_REAL_TIME_3 in", values, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_3 not in", values, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_3 between", value1, value2, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andEndRealTime3NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_3 not between", value1, value2, "endRealTime3");
            return (Criteria) this;
        }

        public Criteria andRscCd4IsNull() {
            addCriterion("RSC_CD_4 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd4IsNotNull() {
            addCriterion("RSC_CD_4 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd4EqualTo(String value) {
            addCriterion("RSC_CD_4 =", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4NotEqualTo(String value) {
            addCriterion("RSC_CD_4 <>", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4GreaterThan(String value) {
            addCriterion("RSC_CD_4 >", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_4 >=", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4LessThan(String value) {
            addCriterion("RSC_CD_4 <", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_4 <=", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4Like(String value) {
            addCriterion("RSC_CD_4 like", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4NotLike(String value) {
            addCriterion("RSC_CD_4 not like", value, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4In(List<String> values) {
            addCriterion("RSC_CD_4 in", values, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4NotIn(List<String> values) {
            addCriterion("RSC_CD_4 not in", values, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4Between(String value1, String value2) {
            addCriterion("RSC_CD_4 between", value1, value2, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andRscCd4NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_4 not between", value1, value2, "rscCd4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4IsNull() {
            addCriterion("ALTERATE_START_TIME_4 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4IsNotNull() {
            addCriterion("ALTERATE_START_TIME_4 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_4 =", value, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_4 <>", value, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_4 >", value, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_4 >=", value, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_4 <", value, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_4 <=", value, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_4 in", values, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_4 not in", values, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_4 between", value1, value2, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime4NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_4 not between", value1, value2, "alterateStartTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4IsNull() {
            addCriterion("ALTERATE_END_TIME_4 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4IsNotNull() {
            addCriterion("ALTERATE_END_TIME_4 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_4 =", value, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_4 <>", value, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_4 >", value, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_4 >=", value, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_4 <", value, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_4 <=", value, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_4 in", values, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_4 not in", values, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_4 between", value1, value2, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime4NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_4 not between", value1, value2, "alterateEndTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4IsNull() {
            addCriterion("START_REAL_TIME_4 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4IsNotNull() {
            addCriterion("START_REAL_TIME_4 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4EqualTo(Date value) {
            addCriterion("START_REAL_TIME_4 =", value, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_4 <>", value, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_4 >", value, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_4 >=", value, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4LessThan(Date value) {
            addCriterion("START_REAL_TIME_4 <", value, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_4 <=", value, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4In(List<Date> values) {
            addCriterion("START_REAL_TIME_4 in", values, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_4 not in", values, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_4 between", value1, value2, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andStartRealTime4NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_4 not between", value1, value2, "startRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4IsNull() {
            addCriterion("END_REAL_TIME_4 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4IsNotNull() {
            addCriterion("END_REAL_TIME_4 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4EqualTo(Date value) {
            addCriterion("END_REAL_TIME_4 =", value, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_4 <>", value, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_4 >", value, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_4 >=", value, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4LessThan(Date value) {
            addCriterion("END_REAL_TIME_4 <", value, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_4 <=", value, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4In(List<Date> values) {
            addCriterion("END_REAL_TIME_4 in", values, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_4 not in", values, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_4 between", value1, value2, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andEndRealTime4NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_4 not between", value1, value2, "endRealTime4");
            return (Criteria) this;
        }

        public Criteria andRscCd5IsNull() {
            addCriterion("RSC_CD_5 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd5IsNotNull() {
            addCriterion("RSC_CD_5 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd5EqualTo(String value) {
            addCriterion("RSC_CD_5 =", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5NotEqualTo(String value) {
            addCriterion("RSC_CD_5 <>", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5GreaterThan(String value) {
            addCriterion("RSC_CD_5 >", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_5 >=", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5LessThan(String value) {
            addCriterion("RSC_CD_5 <", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_5 <=", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5Like(String value) {
            addCriterion("RSC_CD_5 like", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5NotLike(String value) {
            addCriterion("RSC_CD_5 not like", value, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5In(List<String> values) {
            addCriterion("RSC_CD_5 in", values, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5NotIn(List<String> values) {
            addCriterion("RSC_CD_5 not in", values, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5Between(String value1, String value2) {
            addCriterion("RSC_CD_5 between", value1, value2, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andRscCd5NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_5 not between", value1, value2, "rscCd5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5IsNull() {
            addCriterion("ALTERATE_START_TIME_5 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5IsNotNull() {
            addCriterion("ALTERATE_START_TIME_5 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_5 =", value, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_5 <>", value, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_5 >", value, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_5 >=", value, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_5 <", value, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_5 <=", value, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_5 in", values, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_5 not in", values, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_5 between", value1, value2, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime5NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_5 not between", value1, value2, "alterateStartTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5IsNull() {
            addCriterion("ALTERATE_END_TIME_5 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5IsNotNull() {
            addCriterion("ALTERATE_END_TIME_5 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_5 =", value, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_5 <>", value, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_5 >", value, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_5 >=", value, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_5 <", value, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_5 <=", value, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_5 in", values, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_5 not in", values, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_5 between", value1, value2, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime5NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_5 not between", value1, value2, "alterateEndTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5IsNull() {
            addCriterion("START_REAL_TIME_5 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5IsNotNull() {
            addCriterion("START_REAL_TIME_5 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5EqualTo(Date value) {
            addCriterion("START_REAL_TIME_5 =", value, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_5 <>", value, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_5 >", value, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_5 >=", value, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5LessThan(Date value) {
            addCriterion("START_REAL_TIME_5 <", value, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_5 <=", value, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5In(List<Date> values) {
            addCriterion("START_REAL_TIME_5 in", values, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_5 not in", values, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_5 between", value1, value2, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andStartRealTime5NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_5 not between", value1, value2, "startRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5IsNull() {
            addCriterion("END_REAL_TIME_5 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5IsNotNull() {
            addCriterion("END_REAL_TIME_5 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5EqualTo(Date value) {
            addCriterion("END_REAL_TIME_5 =", value, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_5 <>", value, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_5 >", value, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_5 >=", value, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5LessThan(Date value) {
            addCriterion("END_REAL_TIME_5 <", value, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_5 <=", value, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5In(List<Date> values) {
            addCriterion("END_REAL_TIME_5 in", values, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_5 not in", values, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_5 between", value1, value2, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andEndRealTime5NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_5 not between", value1, value2, "endRealTime5");
            return (Criteria) this;
        }

        public Criteria andRscCd6IsNull() {
            addCriterion("RSC_CD_6 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd6IsNotNull() {
            addCriterion("RSC_CD_6 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd6EqualTo(String value) {
            addCriterion("RSC_CD_6 =", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6NotEqualTo(String value) {
            addCriterion("RSC_CD_6 <>", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6GreaterThan(String value) {
            addCriterion("RSC_CD_6 >", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_6 >=", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6LessThan(String value) {
            addCriterion("RSC_CD_6 <", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_6 <=", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6Like(String value) {
            addCriterion("RSC_CD_6 like", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6NotLike(String value) {
            addCriterion("RSC_CD_6 not like", value, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6In(List<String> values) {
            addCriterion("RSC_CD_6 in", values, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6NotIn(List<String> values) {
            addCriterion("RSC_CD_6 not in", values, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6Between(String value1, String value2) {
            addCriterion("RSC_CD_6 between", value1, value2, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andRscCd6NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_6 not between", value1, value2, "rscCd6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6IsNull() {
            addCriterion("ALTERATE_START_TIME_6 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6IsNotNull() {
            addCriterion("ALTERATE_START_TIME_6 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_6 =", value, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_6 <>", value, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_6 >", value, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_6 >=", value, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_6 <", value, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_6 <=", value, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_6 in", values, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_6 not in", values, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_6 between", value1, value2, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime6NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_6 not between", value1, value2, "alterateStartTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6IsNull() {
            addCriterion("ALTERATE_END_TIME_6 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6IsNotNull() {
            addCriterion("ALTERATE_END_TIME_6 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_6 =", value, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_6 <>", value, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_6 >", value, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_6 >=", value, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_6 <", value, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_6 <=", value, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_6 in", values, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_6 not in", values, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_6 between", value1, value2, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime6NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_6 not between", value1, value2, "alterateEndTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6IsNull() {
            addCriterion("START_REAL_TIME_6 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6IsNotNull() {
            addCriterion("START_REAL_TIME_6 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6EqualTo(Date value) {
            addCriterion("START_REAL_TIME_6 =", value, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_6 <>", value, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_6 >", value, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_6 >=", value, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6LessThan(Date value) {
            addCriterion("START_REAL_TIME_6 <", value, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_6 <=", value, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6In(List<Date> values) {
            addCriterion("START_REAL_TIME_6 in", values, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_6 not in", values, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_6 between", value1, value2, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andStartRealTime6NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_6 not between", value1, value2, "startRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6IsNull() {
            addCriterion("END_REAL_TIME_6 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6IsNotNull() {
            addCriterion("END_REAL_TIME_6 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6EqualTo(Date value) {
            addCriterion("END_REAL_TIME_6 =", value, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_6 <>", value, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_6 >", value, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_6 >=", value, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6LessThan(Date value) {
            addCriterion("END_REAL_TIME_6 <", value, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_6 <=", value, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6In(List<Date> values) {
            addCriterion("END_REAL_TIME_6 in", values, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_6 not in", values, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_6 between", value1, value2, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andEndRealTime6NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_6 not between", value1, value2, "endRealTime6");
            return (Criteria) this;
        }

        public Criteria andRscCd7IsNull() {
            addCriterion("RSC_CD_7 is null");
            return (Criteria) this;
        }

        public Criteria andRscCd7IsNotNull() {
            addCriterion("RSC_CD_7 is not null");
            return (Criteria) this;
        }

        public Criteria andRscCd7EqualTo(String value) {
            addCriterion("RSC_CD_7 =", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7NotEqualTo(String value) {
            addCriterion("RSC_CD_7 <>", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7GreaterThan(String value) {
            addCriterion("RSC_CD_7 >", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7GreaterThanOrEqualTo(String value) {
            addCriterion("RSC_CD_7 >=", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7LessThan(String value) {
            addCriterion("RSC_CD_7 <", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7LessThanOrEqualTo(String value) {
            addCriterion("RSC_CD_7 <=", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7Like(String value) {
            addCriterion("RSC_CD_7 like", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7NotLike(String value) {
            addCriterion("RSC_CD_7 not like", value, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7In(List<String> values) {
            addCriterion("RSC_CD_7 in", values, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7NotIn(List<String> values) {
            addCriterion("RSC_CD_7 not in", values, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7Between(String value1, String value2) {
            addCriterion("RSC_CD_7 between", value1, value2, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andRscCd7NotBetween(String value1, String value2) {
            addCriterion("RSC_CD_7 not between", value1, value2, "rscCd7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7IsNull() {
            addCriterion("ALTERATE_START_TIME_7 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7IsNotNull() {
            addCriterion("ALTERATE_START_TIME_7 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7EqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_7 =", value, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7NotEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_7 <>", value, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7GreaterThan(Date value) {
            addCriterion("ALTERATE_START_TIME_7 >", value, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_7 >=", value, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7LessThan(Date value) {
            addCriterion("ALTERATE_START_TIME_7 <", value, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_START_TIME_7 <=", value, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7In(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_7 in", values, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7NotIn(List<Date> values) {
            addCriterion("ALTERATE_START_TIME_7 not in", values, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7Between(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_7 between", value1, value2, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateStartTime7NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_START_TIME_7 not between", value1, value2, "alterateStartTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7IsNull() {
            addCriterion("ALTERATE_END_TIME_7 is null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7IsNotNull() {
            addCriterion("ALTERATE_END_TIME_7 is not null");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7EqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_7 =", value, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7NotEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_7 <>", value, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7GreaterThan(Date value) {
            addCriterion("ALTERATE_END_TIME_7 >", value, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7GreaterThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_7 >=", value, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7LessThan(Date value) {
            addCriterion("ALTERATE_END_TIME_7 <", value, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7LessThanOrEqualTo(Date value) {
            addCriterion("ALTERATE_END_TIME_7 <=", value, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7In(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_7 in", values, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7NotIn(List<Date> values) {
            addCriterion("ALTERATE_END_TIME_7 not in", values, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7Between(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_7 between", value1, value2, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andAlterateEndTime7NotBetween(Date value1, Date value2) {
            addCriterion("ALTERATE_END_TIME_7 not between", value1, value2, "alterateEndTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7IsNull() {
            addCriterion("START_REAL_TIME_7 is null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7IsNotNull() {
            addCriterion("START_REAL_TIME_7 is not null");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7EqualTo(Date value) {
            addCriterion("START_REAL_TIME_7 =", value, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7NotEqualTo(Date value) {
            addCriterion("START_REAL_TIME_7 <>", value, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7GreaterThan(Date value) {
            addCriterion("START_REAL_TIME_7 >", value, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7GreaterThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_7 >=", value, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7LessThan(Date value) {
            addCriterion("START_REAL_TIME_7 <", value, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7LessThanOrEqualTo(Date value) {
            addCriterion("START_REAL_TIME_7 <=", value, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7In(List<Date> values) {
            addCriterion("START_REAL_TIME_7 in", values, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7NotIn(List<Date> values) {
            addCriterion("START_REAL_TIME_7 not in", values, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7Between(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_7 between", value1, value2, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andStartRealTime7NotBetween(Date value1, Date value2) {
            addCriterion("START_REAL_TIME_7 not between", value1, value2, "startRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7IsNull() {
            addCriterion("END_REAL_TIME_7 is null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7IsNotNull() {
            addCriterion("END_REAL_TIME_7 is not null");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7EqualTo(Date value) {
            addCriterion("END_REAL_TIME_7 =", value, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7NotEqualTo(Date value) {
            addCriterion("END_REAL_TIME_7 <>", value, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7GreaterThan(Date value) {
            addCriterion("END_REAL_TIME_7 >", value, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7GreaterThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_7 >=", value, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7LessThan(Date value) {
            addCriterion("END_REAL_TIME_7 <", value, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7LessThanOrEqualTo(Date value) {
            addCriterion("END_REAL_TIME_7 <=", value, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7In(List<Date> values) {
            addCriterion("END_REAL_TIME_7 in", values, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7NotIn(List<Date> values) {
            addCriterion("END_REAL_TIME_7 not in", values, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7Between(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_7 between", value1, value2, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andEndRealTime7NotBetween(Date value1, Date value2) {
            addCriterion("END_REAL_TIME_7 not between", value1, value2, "endRealTime7");
            return (Criteria) this;
        }

        public Criteria andRscFlagIsNull() {
            addCriterion("RSC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRscFlagIsNotNull() {
            addCriterion("RSC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRscFlagEqualTo(String value) {
            addCriterion("RSC_FLAG =", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagNotEqualTo(String value) {
            addCriterion("RSC_FLAG <>", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagGreaterThan(String value) {
            addCriterion("RSC_FLAG >", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagGreaterThanOrEqualTo(String value) {
            addCriterion("RSC_FLAG >=", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagLessThan(String value) {
            addCriterion("RSC_FLAG <", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagLessThanOrEqualTo(String value) {
            addCriterion("RSC_FLAG <=", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagLike(String value) {
            addCriterion("RSC_FLAG like", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagNotLike(String value) {
            addCriterion("RSC_FLAG not like", value, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagIn(List<String> values) {
            addCriterion("RSC_FLAG in", values, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagNotIn(List<String> values) {
            addCriterion("RSC_FLAG not in", values, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagBetween(String value1, String value2) {
            addCriterion("RSC_FLAG between", value1, value2, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andRscFlagNotBetween(String value1, String value2) {
            addCriterion("RSC_FLAG not between", value1, value2, "rscFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}