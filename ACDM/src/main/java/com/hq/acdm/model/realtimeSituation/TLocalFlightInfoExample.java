package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TLocalFlightInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLocalFlightInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andFlightIdEqualTo(Integer value) {
            addCriterion("FLIGHT_ID =", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotEqualTo(Integer value) {
            addCriterion("FLIGHT_ID <>", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThan(Integer value) {
            addCriterion("FLIGHT_ID >", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLIGHT_ID >=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThan(Integer value) {
            addCriterion("FLIGHT_ID <", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdLessThanOrEqualTo(Integer value) {
            addCriterion("FLIGHT_ID <=", value, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdIn(List<Integer> values) {
            addCriterion("FLIGHT_ID in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotIn(List<Integer> values) {
            addCriterion("FLIGHT_ID not in", values, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdBetween(Integer value1, Integer value2) {
            addCriterion("FLIGHT_ID between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andFlightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FLIGHT_ID not between", value1, value2, "flightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdIsNull() {
            addCriterion("ASSOCIATED_FLIGHT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdIsNotNull() {
            addCriterion("ASSOCIATED_FLIGHT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdEqualTo(Integer value) {
            addCriterion("ASSOCIATED_FLIGHT_ID =", value, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdNotEqualTo(Integer value) {
            addCriterion("ASSOCIATED_FLIGHT_ID <>", value, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdGreaterThan(Integer value) {
            addCriterion("ASSOCIATED_FLIGHT_ID >", value, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ASSOCIATED_FLIGHT_ID >=", value, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdLessThan(Integer value) {
            addCriterion("ASSOCIATED_FLIGHT_ID <", value, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdLessThanOrEqualTo(Integer value) {
            addCriterion("ASSOCIATED_FLIGHT_ID <=", value, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdIn(List<Integer> values) {
            addCriterion("ASSOCIATED_FLIGHT_ID in", values, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdNotIn(List<Integer> values) {
            addCriterion("ASSOCIATED_FLIGHT_ID not in", values, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdBetween(Integer value1, Integer value2) {
            addCriterion("ASSOCIATED_FLIGHT_ID between", value1, value2, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andAssociatedFlightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ASSOCIATED_FLIGHT_ID not between", value1, value2, "associatedFlightId");
            return (Criteria) this;
        }

        public Criteria andFfidIsNull() {
            addCriterion("FFID is null");
            return (Criteria) this;
        }

        public Criteria andFfidIsNotNull() {
            addCriterion("FFID is not null");
            return (Criteria) this;
        }

        public Criteria andFfidEqualTo(String value) {
            addCriterion("FFID =", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidNotEqualTo(String value) {
            addCriterion("FFID <>", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidGreaterThan(String value) {
            addCriterion("FFID >", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidGreaterThanOrEqualTo(String value) {
            addCriterion("FFID >=", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidLessThan(String value) {
            addCriterion("FFID <", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidLessThanOrEqualTo(String value) {
            addCriterion("FFID <=", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidLike(String value) {
            addCriterion("FFID like", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidNotLike(String value) {
            addCriterion("FFID not like", value, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidIn(List<String> values) {
            addCriterion("FFID in", values, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidNotIn(List<String> values) {
            addCriterion("FFID not in", values, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidBetween(String value1, String value2) {
            addCriterion("FFID between", value1, value2, "ffid");
            return (Criteria) this;
        }

        public Criteria andFfidNotBetween(String value1, String value2) {
            addCriterion("FFID not between", value1, value2, "ffid");
            return (Criteria) this;
        }

        public Criteria andAirlinesIsNull() {
            addCriterion("AIRLINES is null");
            return (Criteria) this;
        }

        public Criteria andAirlinesIsNotNull() {
            addCriterion("AIRLINES is not null");
            return (Criteria) this;
        }

        public Criteria andAirlinesEqualTo(String value) {
            addCriterion("AIRLINES =", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesNotEqualTo(String value) {
            addCriterion("AIRLINES <>", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesGreaterThan(String value) {
            addCriterion("AIRLINES >", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesGreaterThanOrEqualTo(String value) {
            addCriterion("AIRLINES >=", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesLessThan(String value) {
            addCriterion("AIRLINES <", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesLessThanOrEqualTo(String value) {
            addCriterion("AIRLINES <=", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesLike(String value) {
            addCriterion("AIRLINES like", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesNotLike(String value) {
            addCriterion("AIRLINES not like", value, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesIn(List<String> values) {
            addCriterion("AIRLINES in", values, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesNotIn(List<String> values) {
            addCriterion("AIRLINES not in", values, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesBetween(String value1, String value2) {
            addCriterion("AIRLINES between", value1, value2, "airlines");
            return (Criteria) this;
        }

        public Criteria andAirlinesNotBetween(String value1, String value2) {
            addCriterion("AIRLINES not between", value1, value2, "airlines");
            return (Criteria) this;
        }

        public Criteria andPlanTimeIsNull() {
            addCriterion("PLAN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPlanTimeIsNotNull() {
            addCriterion("PLAN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTimeEqualTo(Date value) {
            addCriterion("PLAN_TIME =", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotEqualTo(Date value) {
            addCriterion("PLAN_TIME <>", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeGreaterThan(Date value) {
            addCriterion("PLAN_TIME >", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PLAN_TIME >=", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeLessThan(Date value) {
            addCriterion("PLAN_TIME <", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeLessThanOrEqualTo(Date value) {
            addCriterion("PLAN_TIME <=", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeIn(List<Date> values) {
            addCriterion("PLAN_TIME in", values, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotIn(List<Date> values) {
            addCriterion("PLAN_TIME not in", values, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeBetween(Date value1, Date value2) {
            addCriterion("PLAN_TIME between", value1, value2, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotBetween(Date value1, Date value2) {
            addCriterion("PLAN_TIME not between", value1, value2, "planTime");
            return (Criteria) this;
        }

        public Criteria andFlnoIsNull() {
            addCriterion("FLNO is null");
            return (Criteria) this;
        }

        public Criteria andFlnoIsNotNull() {
            addCriterion("FLNO is not null");
            return (Criteria) this;
        }

        public Criteria andFlnoEqualTo(String value) {
            addCriterion("FLNO =", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoNotEqualTo(String value) {
            addCriterion("FLNO <>", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoGreaterThan(String value) {
            addCriterion("FLNO >", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoGreaterThanOrEqualTo(String value) {
            addCriterion("FLNO >=", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoLessThan(String value) {
            addCriterion("FLNO <", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoLessThanOrEqualTo(String value) {
            addCriterion("FLNO <=", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoLike(String value) {
            addCriterion("FLNO like", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoNotLike(String value) {
            addCriterion("FLNO not like", value, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoIn(List<String> values) {
            addCriterion("FLNO in", values, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoNotIn(List<String> values) {
            addCriterion("FLNO not in", values, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoBetween(String value1, String value2) {
            addCriterion("FLNO between", value1, value2, "flno");
            return (Criteria) this;
        }

        public Criteria andFlnoNotBetween(String value1, String value2) {
            addCriterion("FLNO not between", value1, value2, "flno");
            return (Criteria) this;
        }

        public Criteria andExecDateIsNull() {
            addCriterion("EXEC_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExecDateIsNotNull() {
            addCriterion("EXEC_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExecDateEqualTo(Date value) {
            addCriterionForJDBCDate("EXEC_DATE =", value, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EXEC_DATE <>", value, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateGreaterThan(Date value) {
            addCriterionForJDBCDate("EXEC_DATE >", value, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EXEC_DATE >=", value, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateLessThan(Date value) {
            addCriterionForJDBCDate("EXEC_DATE <", value, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EXEC_DATE <=", value, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateIn(List<Date> values) {
            addCriterionForJDBCDate("EXEC_DATE in", values, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EXEC_DATE not in", values, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EXEC_DATE between", value1, value2, "execDate");
            return (Criteria) this;
        }

        public Criteria andExecDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EXEC_DATE not between", value1, value2, "execDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateIsNull() {
            addCriterion("FLIGHT_IDENTY_MANAGE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateIsNotNull() {
            addCriterion("FLIGHT_IDENTY_MANAGE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateEqualTo(Date value) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE =", value, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE <>", value, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateGreaterThan(Date value) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE >", value, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE >=", value, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateLessThan(Date value) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE <", value, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE <=", value, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateIn(List<Date> values) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE in", values, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE not in", values, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE between", value1, value2, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andFlightIdentyManageDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FLIGHT_IDENTY_MANAGE_DATE not between", value1, value2, "flightIdentyManageDate");
            return (Criteria) this;
        }

        public Criteria andDOrAIsNull() {
            addCriterion("D_OR_A is null");
            return (Criteria) this;
        }

        public Criteria andDOrAIsNotNull() {
            addCriterion("D_OR_A is not null");
            return (Criteria) this;
        }

        public Criteria andDOrAEqualTo(String value) {
            addCriterion("D_OR_A =", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrANotEqualTo(String value) {
            addCriterion("D_OR_A <>", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrAGreaterThan(String value) {
            addCriterion("D_OR_A >", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrAGreaterThanOrEqualTo(String value) {
            addCriterion("D_OR_A >=", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrALessThan(String value) {
            addCriterion("D_OR_A <", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrALessThanOrEqualTo(String value) {
            addCriterion("D_OR_A <=", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrALike(String value) {
            addCriterion("D_OR_A like", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrANotLike(String value) {
            addCriterion("D_OR_A not like", value, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrAIn(List<String> values) {
            addCriterion("D_OR_A in", values, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrANotIn(List<String> values) {
            addCriterion("D_OR_A not in", values, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrABetween(String value1, String value2) {
            addCriterion("D_OR_A between", value1, value2, "dOrA");
            return (Criteria) this;
        }

        public Criteria andDOrANotBetween(String value1, String value2) {
            addCriterion("D_OR_A not between", value1, value2, "dOrA");
            return (Criteria) this;
        }

        public Criteria andFlightTaskIsNull() {
            addCriterion("FLIGHT_TASK is null");
            return (Criteria) this;
        }

        public Criteria andFlightTaskIsNotNull() {
            addCriterion("FLIGHT_TASK is not null");
            return (Criteria) this;
        }

        public Criteria andFlightTaskEqualTo(String value) {
            addCriterion("FLIGHT_TASK =", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskNotEqualTo(String value) {
            addCriterion("FLIGHT_TASK <>", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskGreaterThan(String value) {
            addCriterion("FLIGHT_TASK >", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskGreaterThanOrEqualTo(String value) {
            addCriterion("FLIGHT_TASK >=", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskLessThan(String value) {
            addCriterion("FLIGHT_TASK <", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskLessThanOrEqualTo(String value) {
            addCriterion("FLIGHT_TASK <=", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskLike(String value) {
            addCriterion("FLIGHT_TASK like", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskNotLike(String value) {
            addCriterion("FLIGHT_TASK not like", value, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskIn(List<String> values) {
            addCriterion("FLIGHT_TASK in", values, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskNotIn(List<String> values) {
            addCriterion("FLIGHT_TASK not in", values, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskBetween(String value1, String value2) {
            addCriterion("FLIGHT_TASK between", value1, value2, "flightTask");
            return (Criteria) this;
        }

        public Criteria andFlightTaskNotBetween(String value1, String value2) {
            addCriterion("FLIGHT_TASK not between", value1, value2, "flightTask");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNull() {
            addCriterion("ATTRIBUTE is null");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNotNull() {
            addCriterion("ATTRIBUTE is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeEqualTo(String value) {
            addCriterion("ATTRIBUTE =", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotEqualTo(String value) {
            addCriterion("ATTRIBUTE <>", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThan(String value) {
            addCriterion("ATTRIBUTE >", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE >=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThan(String value) {
            addCriterion("ATTRIBUTE <", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThanOrEqualTo(String value) {
            addCriterion("ATTRIBUTE <=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLike(String value) {
            addCriterion("ATTRIBUTE like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotLike(String value) {
            addCriterion("ATTRIBUTE not like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeIn(List<String> values) {
            addCriterion("ATTRIBUTE in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotIn(List<String> values) {
            addCriterion("ATTRIBUTE not in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotBetween(String value1, String value2) {
            addCriterion("ATTRIBUTE not between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountIsNull() {
            addCriterion("TAKEOFF_LANDIN_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountIsNotNull() {
            addCriterion("TAKEOFF_LANDIN_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountEqualTo(Integer value) {
            addCriterion("TAKEOFF_LANDIN_COUNT =", value, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountNotEqualTo(Integer value) {
            addCriterion("TAKEOFF_LANDIN_COUNT <>", value, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountGreaterThan(Integer value) {
            addCriterion("TAKEOFF_LANDIN_COUNT >", value, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TAKEOFF_LANDIN_COUNT >=", value, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountLessThan(Integer value) {
            addCriterion("TAKEOFF_LANDIN_COUNT <", value, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountLessThanOrEqualTo(Integer value) {
            addCriterion("TAKEOFF_LANDIN_COUNT <=", value, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountIn(List<Integer> values) {
            addCriterion("TAKEOFF_LANDIN_COUNT in", values, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountNotIn(List<Integer> values) {
            addCriterion("TAKEOFF_LANDIN_COUNT not in", values, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountBetween(Integer value1, Integer value2) {
            addCriterion("TAKEOFF_LANDIN_COUNT between", value1, value2, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andTakeoffLandinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TAKEOFF_LANDIN_COUNT not between", value1, value2, "takeoffLandinCount");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNull() {
            addCriterion("AGENCY is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNotNull() {
            addCriterion("AGENCY is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyEqualTo(String value) {
            addCriterion("AGENCY =", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotEqualTo(String value) {
            addCriterion("AGENCY <>", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThan(String value) {
            addCriterion("AGENCY >", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("AGENCY >=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThan(String value) {
            addCriterion("AGENCY <", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThanOrEqualTo(String value) {
            addCriterion("AGENCY <=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLike(String value) {
            addCriterion("AGENCY like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotLike(String value) {
            addCriterion("AGENCY not like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyIn(List<String> values) {
            addCriterion("AGENCY in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotIn(List<String> values) {
            addCriterion("AGENCY not in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyBetween(String value1, String value2) {
            addCriterion("AGENCY between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotBetween(String value1, String value2) {
            addCriterion("AGENCY not between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoIsNull() {
            addCriterion("CRAFT_TYPE_ICAO is null");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoIsNotNull() {
            addCriterion("CRAFT_TYPE_ICAO is not null");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO =", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoNotEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO <>", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoGreaterThan(String value) {
            addCriterion("CRAFT_TYPE_ICAO >", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoGreaterThanOrEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO >=", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoLessThan(String value) {
            addCriterion("CRAFT_TYPE_ICAO <", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoLessThanOrEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO <=", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoLike(String value) {
            addCriterion("CRAFT_TYPE_ICAO like", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoNotLike(String value) {
            addCriterion("CRAFT_TYPE_ICAO not like", value, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoIn(List<String> values) {
            addCriterion("CRAFT_TYPE_ICAO in", values, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoNotIn(List<String> values) {
            addCriterion("CRAFT_TYPE_ICAO not in", values, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoBetween(String value1, String value2) {
            addCriterion("CRAFT_TYPE_ICAO between", value1, value2, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoNotBetween(String value1, String value2) {
            addCriterion("CRAFT_TYPE_ICAO not between", value1, value2, "craftTypeIcao");
            return (Criteria) this;
        }

        public Criteria andRegnIsNull() {
            addCriterion("REGN is null");
            return (Criteria) this;
        }

        public Criteria andRegnIsNotNull() {
            addCriterion("REGN is not null");
            return (Criteria) this;
        }

        public Criteria andRegnEqualTo(String value) {
            addCriterion("REGN =", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnNotEqualTo(String value) {
            addCriterion("REGN <>", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnGreaterThan(String value) {
            addCriterion("REGN >", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnGreaterThanOrEqualTo(String value) {
            addCriterion("REGN >=", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnLessThan(String value) {
            addCriterion("REGN <", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnLessThanOrEqualTo(String value) {
            addCriterion("REGN <=", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnLike(String value) {
            addCriterion("REGN like", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnNotLike(String value) {
            addCriterion("REGN not like", value, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnIn(List<String> values) {
            addCriterion("REGN in", values, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnNotIn(List<String> values) {
            addCriterion("REGN not in", values, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnBetween(String value1, String value2) {
            addCriterion("REGN between", value1, value2, "regn");
            return (Criteria) this;
        }

        public Criteria andRegnNotBetween(String value1, String value2) {
            addCriterion("REGN not between", value1, value2, "regn");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdIsNull() {
            addCriterion("NORMAL_FLIGHT_STAT_CD is null");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdIsNotNull() {
            addCriterion("NORMAL_FLIGHT_STAT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdEqualTo(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD =", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdNotEqualTo(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD <>", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdGreaterThan(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD >", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdGreaterThanOrEqualTo(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD >=", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdLessThan(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD <", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdLessThanOrEqualTo(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD <=", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdLike(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD like", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdNotLike(String value) {
            addCriterion("NORMAL_FLIGHT_STAT_CD not like", value, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdIn(List<String> values) {
            addCriterion("NORMAL_FLIGHT_STAT_CD in", values, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdNotIn(List<String> values) {
            addCriterion("NORMAL_FLIGHT_STAT_CD not in", values, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdBetween(String value1, String value2) {
            addCriterion("NORMAL_FLIGHT_STAT_CD between", value1, value2, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andNormalFlightStatCdNotBetween(String value1, String value2) {
            addCriterion("NORMAL_FLIGHT_STAT_CD not between", value1, value2, "normalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdIsNull() {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdIsNotNull() {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdEqualTo(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD =", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdNotEqualTo(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD <>", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdGreaterThan(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD >", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdGreaterThanOrEqualTo(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD >=", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdLessThan(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD <", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdLessThanOrEqualTo(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD <=", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdLike(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD like", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdNotLike(String value) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD not like", value, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdIn(List<String> values) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD in", values, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdNotIn(List<String> values) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD not in", values, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdBetween(String value1, String value2) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD between", value1, value2, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andAbnormalFlightStatCdNotBetween(String value1, String value2) {
            addCriterion("ABNORMAL_FLIGHT_STAT_CD not between", value1, value2, "abnormalFlightStatCd");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("IS_VIP is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("IS_VIP is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(String value) {
            addCriterion("IS_VIP =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(String value) {
            addCriterion("IS_VIP <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(String value) {
            addCriterion("IS_VIP >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(String value) {
            addCriterion("IS_VIP >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(String value) {
            addCriterion("IS_VIP <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(String value) {
            addCriterion("IS_VIP <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLike(String value) {
            addCriterion("IS_VIP like", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotLike(String value) {
            addCriterion("IS_VIP not like", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<String> values) {
            addCriterion("IS_VIP in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<String> values) {
            addCriterion("IS_VIP not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(String value1, String value2) {
            addCriterion("IS_VIP between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(String value1, String value2) {
            addCriterion("IS_VIP not between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andVipNumberIsNull() {
            addCriterion("VIP_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andVipNumberIsNotNull() {
            addCriterion("VIP_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andVipNumberEqualTo(Integer value) {
            addCriterion("VIP_NUMBER =", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotEqualTo(Integer value) {
            addCriterion("VIP_NUMBER <>", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberGreaterThan(Integer value) {
            addCriterion("VIP_NUMBER >", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIP_NUMBER >=", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberLessThan(Integer value) {
            addCriterion("VIP_NUMBER <", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberLessThanOrEqualTo(Integer value) {
            addCriterion("VIP_NUMBER <=", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberIn(List<Integer> values) {
            addCriterion("VIP_NUMBER in", values, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotIn(List<Integer> values) {
            addCriterion("VIP_NUMBER not in", values, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberBetween(Integer value1, Integer value2) {
            addCriterion("VIP_NUMBER between", value1, value2, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("VIP_NUMBER not between", value1, value2, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andSobtIsNull() {
            addCriterion("SOBT is null");
            return (Criteria) this;
        }

        public Criteria andSobtIsNotNull() {
            addCriterion("SOBT is not null");
            return (Criteria) this;
        }

        public Criteria andSobtEqualTo(Date value) {
            addCriterion("SOBT =", value, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtNotEqualTo(Date value) {
            addCriterion("SOBT <>", value, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtGreaterThan(Date value) {
            addCriterion("SOBT >", value, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtGreaterThanOrEqualTo(Date value) {
            addCriterion("SOBT >=", value, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtLessThan(Date value) {
            addCriterion("SOBT <", value, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtLessThanOrEqualTo(Date value) {
            addCriterion("SOBT <=", value, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtIn(List<Date> values) {
            addCriterion("SOBT in", values, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtNotIn(List<Date> values) {
            addCriterion("SOBT not in", values, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtBetween(Date value1, Date value2) {
            addCriterion("SOBT between", value1, value2, "sobt");
            return (Criteria) this;
        }

        public Criteria andSobtNotBetween(Date value1, Date value2) {
            addCriterion("SOBT not between", value1, value2, "sobt");
            return (Criteria) this;
        }

        public Criteria andSibtIsNull() {
            addCriterion("SIBT is null");
            return (Criteria) this;
        }

        public Criteria andSibtIsNotNull() {
            addCriterion("SIBT is not null");
            return (Criteria) this;
        }

        public Criteria andSibtEqualTo(Date value) {
            addCriterion("SIBT =", value, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtNotEqualTo(Date value) {
            addCriterion("SIBT <>", value, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtGreaterThan(Date value) {
            addCriterion("SIBT >", value, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtGreaterThanOrEqualTo(Date value) {
            addCriterion("SIBT >=", value, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtLessThan(Date value) {
            addCriterion("SIBT <", value, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtLessThanOrEqualTo(Date value) {
            addCriterion("SIBT <=", value, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtIn(List<Date> values) {
            addCriterion("SIBT in", values, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtNotIn(List<Date> values) {
            addCriterion("SIBT not in", values, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtBetween(Date value1, Date value2) {
            addCriterion("SIBT between", value1, value2, "sibt");
            return (Criteria) this;
        }

        public Criteria andSibtNotBetween(Date value1, Date value2) {
            addCriterion("SIBT not between", value1, value2, "sibt");
            return (Criteria) this;
        }

        public Criteria andEobtIsNull() {
            addCriterion("EOBT is null");
            return (Criteria) this;
        }

        public Criteria andEobtIsNotNull() {
            addCriterion("EOBT is not null");
            return (Criteria) this;
        }

        public Criteria andEobtEqualTo(Date value) {
            addCriterion("EOBT =", value, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtNotEqualTo(Date value) {
            addCriterion("EOBT <>", value, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtGreaterThan(Date value) {
            addCriterion("EOBT >", value, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtGreaterThanOrEqualTo(Date value) {
            addCriterion("EOBT >=", value, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtLessThan(Date value) {
            addCriterion("EOBT <", value, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtLessThanOrEqualTo(Date value) {
            addCriterion("EOBT <=", value, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtIn(List<Date> values) {
            addCriterion("EOBT in", values, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtNotIn(List<Date> values) {
            addCriterion("EOBT not in", values, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtBetween(Date value1, Date value2) {
            addCriterion("EOBT between", value1, value2, "eobt");
            return (Criteria) this;
        }

        public Criteria andEobtNotBetween(Date value1, Date value2) {
            addCriterion("EOBT not between", value1, value2, "eobt");
            return (Criteria) this;
        }

        public Criteria andEibtIsNull() {
            addCriterion("EIBT is null");
            return (Criteria) this;
        }

        public Criteria andEibtIsNotNull() {
            addCriterion("EIBT is not null");
            return (Criteria) this;
        }

        public Criteria andEibtEqualTo(Date value) {
            addCriterion("EIBT =", value, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtNotEqualTo(Date value) {
            addCriterion("EIBT <>", value, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtGreaterThan(Date value) {
            addCriterion("EIBT >", value, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtGreaterThanOrEqualTo(Date value) {
            addCriterion("EIBT >=", value, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtLessThan(Date value) {
            addCriterion("EIBT <", value, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtLessThanOrEqualTo(Date value) {
            addCriterion("EIBT <=", value, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtIn(List<Date> values) {
            addCriterion("EIBT in", values, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtNotIn(List<Date> values) {
            addCriterion("EIBT not in", values, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtBetween(Date value1, Date value2) {
            addCriterion("EIBT between", value1, value2, "eibt");
            return (Criteria) this;
        }

        public Criteria andEibtNotBetween(Date value1, Date value2) {
            addCriterion("EIBT not between", value1, value2, "eibt");
            return (Criteria) this;
        }

        public Criteria andAobtIsNull() {
            addCriterion("AOBT is null");
            return (Criteria) this;
        }

        public Criteria andAobtIsNotNull() {
            addCriterion("AOBT is not null");
            return (Criteria) this;
        }

        public Criteria andAobtEqualTo(Date value) {
            addCriterion("AOBT =", value, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtNotEqualTo(Date value) {
            addCriterion("AOBT <>", value, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtGreaterThan(Date value) {
            addCriterion("AOBT >", value, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtGreaterThanOrEqualTo(Date value) {
            addCriterion("AOBT >=", value, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtLessThan(Date value) {
            addCriterion("AOBT <", value, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtLessThanOrEqualTo(Date value) {
            addCriterion("AOBT <=", value, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtIn(List<Date> values) {
            addCriterion("AOBT in", values, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtNotIn(List<Date> values) {
            addCriterion("AOBT not in", values, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtBetween(Date value1, Date value2) {
            addCriterion("AOBT between", value1, value2, "aobt");
            return (Criteria) this;
        }

        public Criteria andAobtNotBetween(Date value1, Date value2) {
            addCriterion("AOBT not between", value1, value2, "aobt");
            return (Criteria) this;
        }

        public Criteria andAibtIsNull() {
            addCriterion("AIBT is null");
            return (Criteria) this;
        }

        public Criteria andAibtIsNotNull() {
            addCriterion("AIBT is not null");
            return (Criteria) this;
        }

        public Criteria andAibtEqualTo(Date value) {
            addCriterion("AIBT =", value, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtNotEqualTo(Date value) {
            addCriterion("AIBT <>", value, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtGreaterThan(Date value) {
            addCriterion("AIBT >", value, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtGreaterThanOrEqualTo(Date value) {
            addCriterion("AIBT >=", value, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtLessThan(Date value) {
            addCriterion("AIBT <", value, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtLessThanOrEqualTo(Date value) {
            addCriterion("AIBT <=", value, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtIn(List<Date> values) {
            addCriterion("AIBT in", values, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtNotIn(List<Date> values) {
            addCriterion("AIBT not in", values, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtBetween(Date value1, Date value2) {
            addCriterion("AIBT between", value1, value2, "aibt");
            return (Criteria) this;
        }

        public Criteria andAibtNotBetween(Date value1, Date value2) {
            addCriterion("AIBT not between", value1, value2, "aibt");
            return (Criteria) this;
        }

        public Criteria andEldtIsNull() {
            addCriterion("ELDT is null");
            return (Criteria) this;
        }

        public Criteria andEldtIsNotNull() {
            addCriterion("ELDT is not null");
            return (Criteria) this;
        }

        public Criteria andEldtEqualTo(Date value) {
            addCriterion("ELDT =", value, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtNotEqualTo(Date value) {
            addCriterion("ELDT <>", value, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtGreaterThan(Date value) {
            addCriterion("ELDT >", value, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtGreaterThanOrEqualTo(Date value) {
            addCriterion("ELDT >=", value, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtLessThan(Date value) {
            addCriterion("ELDT <", value, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtLessThanOrEqualTo(Date value) {
            addCriterion("ELDT <=", value, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtIn(List<Date> values) {
            addCriterion("ELDT in", values, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtNotIn(List<Date> values) {
            addCriterion("ELDT not in", values, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtBetween(Date value1, Date value2) {
            addCriterion("ELDT between", value1, value2, "eldt");
            return (Criteria) this;
        }

        public Criteria andEldtNotBetween(Date value1, Date value2) {
            addCriterion("ELDT not between", value1, value2, "eldt");
            return (Criteria) this;
        }

        public Criteria andEtotIsNull() {
            addCriterion("ETOT is null");
            return (Criteria) this;
        }

        public Criteria andEtotIsNotNull() {
            addCriterion("ETOT is not null");
            return (Criteria) this;
        }

        public Criteria andEtotEqualTo(Date value) {
            addCriterion("ETOT =", value, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotNotEqualTo(Date value) {
            addCriterion("ETOT <>", value, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotGreaterThan(Date value) {
            addCriterion("ETOT >", value, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotGreaterThanOrEqualTo(Date value) {
            addCriterion("ETOT >=", value, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotLessThan(Date value) {
            addCriterion("ETOT <", value, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotLessThanOrEqualTo(Date value) {
            addCriterion("ETOT <=", value, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotIn(List<Date> values) {
            addCriterion("ETOT in", values, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotNotIn(List<Date> values) {
            addCriterion("ETOT not in", values, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotBetween(Date value1, Date value2) {
            addCriterion("ETOT between", value1, value2, "etot");
            return (Criteria) this;
        }

        public Criteria andEtotNotBetween(Date value1, Date value2) {
            addCriterion("ETOT not between", value1, value2, "etot");
            return (Criteria) this;
        }

        public Criteria andAldtIsNull() {
            addCriterion("ALDT is null");
            return (Criteria) this;
        }

        public Criteria andAldtIsNotNull() {
            addCriterion("ALDT is not null");
            return (Criteria) this;
        }

        public Criteria andAldtEqualTo(Date value) {
            addCriterion("ALDT =", value, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtNotEqualTo(Date value) {
            addCriterion("ALDT <>", value, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtGreaterThan(Date value) {
            addCriterion("ALDT >", value, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtGreaterThanOrEqualTo(Date value) {
            addCriterion("ALDT >=", value, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtLessThan(Date value) {
            addCriterion("ALDT <", value, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtLessThanOrEqualTo(Date value) {
            addCriterion("ALDT <=", value, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtIn(List<Date> values) {
            addCriterion("ALDT in", values, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtNotIn(List<Date> values) {
            addCriterion("ALDT not in", values, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtBetween(Date value1, Date value2) {
            addCriterion("ALDT between", value1, value2, "aldt");
            return (Criteria) this;
        }

        public Criteria andAldtNotBetween(Date value1, Date value2) {
            addCriterion("ALDT not between", value1, value2, "aldt");
            return (Criteria) this;
        }

        public Criteria andAtotIsNull() {
            addCriterion("ATOT is null");
            return (Criteria) this;
        }

        public Criteria andAtotIsNotNull() {
            addCriterion("ATOT is not null");
            return (Criteria) this;
        }

        public Criteria andAtotEqualTo(Date value) {
            addCriterion("ATOT =", value, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotNotEqualTo(Date value) {
            addCriterion("ATOT <>", value, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotGreaterThan(Date value) {
            addCriterion("ATOT >", value, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotGreaterThanOrEqualTo(Date value) {
            addCriterion("ATOT >=", value, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotLessThan(Date value) {
            addCriterion("ATOT <", value, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotLessThanOrEqualTo(Date value) {
            addCriterion("ATOT <=", value, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotIn(List<Date> values) {
            addCriterion("ATOT in", values, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotNotIn(List<Date> values) {
            addCriterion("ATOT not in", values, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotBetween(Date value1, Date value2) {
            addCriterion("ATOT between", value1, value2, "atot");
            return (Criteria) this;
        }

        public Criteria andAtotNotBetween(Date value1, Date value2) {
            addCriterion("ATOT not between", value1, value2, "atot");
            return (Criteria) this;
        }

        public Criteria andShareFlnoIsNull() {
            addCriterion("SHARE_FLNO is null");
            return (Criteria) this;
        }

        public Criteria andShareFlnoIsNotNull() {
            addCriterion("SHARE_FLNO is not null");
            return (Criteria) this;
        }

        public Criteria andShareFlnoEqualTo(String value) {
            addCriterion("SHARE_FLNO =", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoNotEqualTo(String value) {
            addCriterion("SHARE_FLNO <>", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoGreaterThan(String value) {
            addCriterion("SHARE_FLNO >", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoGreaterThanOrEqualTo(String value) {
            addCriterion("SHARE_FLNO >=", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoLessThan(String value) {
            addCriterion("SHARE_FLNO <", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoLessThanOrEqualTo(String value) {
            addCriterion("SHARE_FLNO <=", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoLike(String value) {
            addCriterion("SHARE_FLNO like", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoNotLike(String value) {
            addCriterion("SHARE_FLNO not like", value, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoIn(List<String> values) {
            addCriterion("SHARE_FLNO in", values, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoNotIn(List<String> values) {
            addCriterion("SHARE_FLNO not in", values, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoBetween(String value1, String value2) {
            addCriterion("SHARE_FLNO between", value1, value2, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andShareFlnoNotBetween(String value1, String value2) {
            addCriterion("SHARE_FLNO not between", value1, value2, "shareFlno");
            return (Criteria) this;
        }

        public Criteria andAdepIsNull() {
            addCriterion("ADEP is null");
            return (Criteria) this;
        }

        public Criteria andAdepIsNotNull() {
            addCriterion("ADEP is not null");
            return (Criteria) this;
        }

        public Criteria andAdepEqualTo(String value) {
            addCriterion("ADEP =", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotEqualTo(String value) {
            addCriterion("ADEP <>", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepGreaterThan(String value) {
            addCriterion("ADEP >", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepGreaterThanOrEqualTo(String value) {
            addCriterion("ADEP >=", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepLessThan(String value) {
            addCriterion("ADEP <", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepLessThanOrEqualTo(String value) {
            addCriterion("ADEP <=", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepLike(String value) {
            addCriterion("ADEP like", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotLike(String value) {
            addCriterion("ADEP not like", value, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepIn(List<String> values) {
            addCriterion("ADEP in", values, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotIn(List<String> values) {
            addCriterion("ADEP not in", values, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepBetween(String value1, String value2) {
            addCriterion("ADEP between", value1, value2, "adep");
            return (Criteria) this;
        }

        public Criteria andAdepNotBetween(String value1, String value2) {
            addCriterion("ADEP not between", value1, value2, "adep");
            return (Criteria) this;
        }

        public Criteria andAdesIsNull() {
            addCriterion("ADES is null");
            return (Criteria) this;
        }

        public Criteria andAdesIsNotNull() {
            addCriterion("ADES is not null");
            return (Criteria) this;
        }

        public Criteria andAdesEqualTo(String value) {
            addCriterion("ADES =", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotEqualTo(String value) {
            addCriterion("ADES <>", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesGreaterThan(String value) {
            addCriterion("ADES >", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesGreaterThanOrEqualTo(String value) {
            addCriterion("ADES >=", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesLessThan(String value) {
            addCriterion("ADES <", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesLessThanOrEqualTo(String value) {
            addCriterion("ADES <=", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesLike(String value) {
            addCriterion("ADES like", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotLike(String value) {
            addCriterion("ADES not like", value, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesIn(List<String> values) {
            addCriterion("ADES in", values, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotIn(List<String> values) {
            addCriterion("ADES not in", values, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesBetween(String value1, String value2) {
            addCriterion("ADES between", value1, value2, "ades");
            return (Criteria) this;
        }

        public Criteria andAdesNotBetween(String value1, String value2) {
            addCriterion("ADES not between", value1, value2, "ades");
            return (Criteria) this;
        }

        public Criteria andStartStationIsNull() {
            addCriterion("START_STATION is null");
            return (Criteria) this;
        }

        public Criteria andStartStationIsNotNull() {
            addCriterion("START_STATION is not null");
            return (Criteria) this;
        }

        public Criteria andStartStationEqualTo(String value) {
            addCriterion("START_STATION =", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationNotEqualTo(String value) {
            addCriterion("START_STATION <>", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationGreaterThan(String value) {
            addCriterion("START_STATION >", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationGreaterThanOrEqualTo(String value) {
            addCriterion("START_STATION >=", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationLessThan(String value) {
            addCriterion("START_STATION <", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationLessThanOrEqualTo(String value) {
            addCriterion("START_STATION <=", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationLike(String value) {
            addCriterion("START_STATION like", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationNotLike(String value) {
            addCriterion("START_STATION not like", value, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationIn(List<String> values) {
            addCriterion("START_STATION in", values, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationNotIn(List<String> values) {
            addCriterion("START_STATION not in", values, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationBetween(String value1, String value2) {
            addCriterion("START_STATION between", value1, value2, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartStationNotBetween(String value1, String value2) {
            addCriterion("START_STATION not between", value1, value2, "startStation");
            return (Criteria) this;
        }

        public Criteria andStartSobtIsNull() {
            addCriterion("START_SOBT is null");
            return (Criteria) this;
        }

        public Criteria andStartSobtIsNotNull() {
            addCriterion("START_SOBT is not null");
            return (Criteria) this;
        }

        public Criteria andStartSobtEqualTo(Date value) {
            addCriterion("START_SOBT =", value, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtNotEqualTo(Date value) {
            addCriterion("START_SOBT <>", value, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtGreaterThan(Date value) {
            addCriterion("START_SOBT >", value, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_SOBT >=", value, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtLessThan(Date value) {
            addCriterion("START_SOBT <", value, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtLessThanOrEqualTo(Date value) {
            addCriterion("START_SOBT <=", value, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtIn(List<Date> values) {
            addCriterion("START_SOBT in", values, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtNotIn(List<Date> values) {
            addCriterion("START_SOBT not in", values, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtBetween(Date value1, Date value2) {
            addCriterion("START_SOBT between", value1, value2, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSobtNotBetween(Date value1, Date value2) {
            addCriterion("START_SOBT not between", value1, value2, "startSobt");
            return (Criteria) this;
        }

        public Criteria andStartSibtIsNull() {
            addCriterion("START_SIBT is null");
            return (Criteria) this;
        }

        public Criteria andStartSibtIsNotNull() {
            addCriterion("START_SIBT is not null");
            return (Criteria) this;
        }

        public Criteria andStartSibtEqualTo(Date value) {
            addCriterion("START_SIBT =", value, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtNotEqualTo(Date value) {
            addCriterion("START_SIBT <>", value, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtGreaterThan(Date value) {
            addCriterion("START_SIBT >", value, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_SIBT >=", value, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtLessThan(Date value) {
            addCriterion("START_SIBT <", value, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtLessThanOrEqualTo(Date value) {
            addCriterion("START_SIBT <=", value, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtIn(List<Date> values) {
            addCriterion("START_SIBT in", values, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtNotIn(List<Date> values) {
            addCriterion("START_SIBT not in", values, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtBetween(Date value1, Date value2) {
            addCriterion("START_SIBT between", value1, value2, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartSibtNotBetween(Date value1, Date value2) {
            addCriterion("START_SIBT not between", value1, value2, "startSibt");
            return (Criteria) this;
        }

        public Criteria andStartEobtIsNull() {
            addCriterion("START_EOBT is null");
            return (Criteria) this;
        }

        public Criteria andStartEobtIsNotNull() {
            addCriterion("START_EOBT is not null");
            return (Criteria) this;
        }

        public Criteria andStartEobtEqualTo(Date value) {
            addCriterion("START_EOBT =", value, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtNotEqualTo(Date value) {
            addCriterion("START_EOBT <>", value, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtGreaterThan(Date value) {
            addCriterion("START_EOBT >", value, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_EOBT >=", value, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtLessThan(Date value) {
            addCriterion("START_EOBT <", value, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtLessThanOrEqualTo(Date value) {
            addCriterion("START_EOBT <=", value, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtIn(List<Date> values) {
            addCriterion("START_EOBT in", values, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtNotIn(List<Date> values) {
            addCriterion("START_EOBT not in", values, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtBetween(Date value1, Date value2) {
            addCriterion("START_EOBT between", value1, value2, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEobtNotBetween(Date value1, Date value2) {
            addCriterion("START_EOBT not between", value1, value2, "startEobt");
            return (Criteria) this;
        }

        public Criteria andStartEibtIsNull() {
            addCriterion("START_EIBT is null");
            return (Criteria) this;
        }

        public Criteria andStartEibtIsNotNull() {
            addCriterion("START_EIBT is not null");
            return (Criteria) this;
        }

        public Criteria andStartEibtEqualTo(Date value) {
            addCriterion("START_EIBT =", value, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtNotEqualTo(Date value) {
            addCriterion("START_EIBT <>", value, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtGreaterThan(Date value) {
            addCriterion("START_EIBT >", value, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_EIBT >=", value, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtLessThan(Date value) {
            addCriterion("START_EIBT <", value, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtLessThanOrEqualTo(Date value) {
            addCriterion("START_EIBT <=", value, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtIn(List<Date> values) {
            addCriterion("START_EIBT in", values, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtNotIn(List<Date> values) {
            addCriterion("START_EIBT not in", values, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtBetween(Date value1, Date value2) {
            addCriterion("START_EIBT between", value1, value2, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartEibtNotBetween(Date value1, Date value2) {
            addCriterion("START_EIBT not between", value1, value2, "startEibt");
            return (Criteria) this;
        }

        public Criteria andStartAobtIsNull() {
            addCriterion("START_AOBT is null");
            return (Criteria) this;
        }

        public Criteria andStartAobtIsNotNull() {
            addCriterion("START_AOBT is not null");
            return (Criteria) this;
        }

        public Criteria andStartAobtEqualTo(Date value) {
            addCriterion("START_AOBT =", value, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtNotEqualTo(Date value) {
            addCriterion("START_AOBT <>", value, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtGreaterThan(Date value) {
            addCriterion("START_AOBT >", value, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_AOBT >=", value, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtLessThan(Date value) {
            addCriterion("START_AOBT <", value, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtLessThanOrEqualTo(Date value) {
            addCriterion("START_AOBT <=", value, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtIn(List<Date> values) {
            addCriterion("START_AOBT in", values, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtNotIn(List<Date> values) {
            addCriterion("START_AOBT not in", values, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtBetween(Date value1, Date value2) {
            addCriterion("START_AOBT between", value1, value2, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAobtNotBetween(Date value1, Date value2) {
            addCriterion("START_AOBT not between", value1, value2, "startAobt");
            return (Criteria) this;
        }

        public Criteria andStartAibtIsNull() {
            addCriterion("START_AIBT is null");
            return (Criteria) this;
        }

        public Criteria andStartAibtIsNotNull() {
            addCriterion("START_AIBT is not null");
            return (Criteria) this;
        }

        public Criteria andStartAibtEqualTo(Date value) {
            addCriterion("START_AIBT =", value, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtNotEqualTo(Date value) {
            addCriterion("START_AIBT <>", value, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtGreaterThan(Date value) {
            addCriterion("START_AIBT >", value, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtGreaterThanOrEqualTo(Date value) {
            addCriterion("START_AIBT >=", value, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtLessThan(Date value) {
            addCriterion("START_AIBT <", value, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtLessThanOrEqualTo(Date value) {
            addCriterion("START_AIBT <=", value, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtIn(List<Date> values) {
            addCriterion("START_AIBT in", values, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtNotIn(List<Date> values) {
            addCriterion("START_AIBT not in", values, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtBetween(Date value1, Date value2) {
            addCriterion("START_AIBT between", value1, value2, "startAibt");
            return (Criteria) this;
        }

        public Criteria andStartAibtNotBetween(Date value1, Date value2) {
            addCriterion("START_AIBT not between", value1, value2, "startAibt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltIsNull() {
            addCriterion("BCK_OR_ALT is null");
            return (Criteria) this;
        }

        public Criteria andBckOrAltIsNotNull() {
            addCriterion("BCK_OR_ALT is not null");
            return (Criteria) this;
        }

        public Criteria andBckOrAltEqualTo(String value) {
            addCriterion("BCK_OR_ALT =", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltNotEqualTo(String value) {
            addCriterion("BCK_OR_ALT <>", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltGreaterThan(String value) {
            addCriterion("BCK_OR_ALT >", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltGreaterThanOrEqualTo(String value) {
            addCriterion("BCK_OR_ALT >=", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltLessThan(String value) {
            addCriterion("BCK_OR_ALT <", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltLessThanOrEqualTo(String value) {
            addCriterion("BCK_OR_ALT <=", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltLike(String value) {
            addCriterion("BCK_OR_ALT like", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltNotLike(String value) {
            addCriterion("BCK_OR_ALT not like", value, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltIn(List<String> values) {
            addCriterion("BCK_OR_ALT in", values, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltNotIn(List<String> values) {
            addCriterion("BCK_OR_ALT not in", values, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltBetween(String value1, String value2) {
            addCriterion("BCK_OR_ALT between", value1, value2, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andBckOrAltNotBetween(String value1, String value2) {
            addCriterion("BCK_OR_ALT not between", value1, value2, "bckOrAlt");
            return (Criteria) this;
        }

        public Criteria andAltAdesIsNull() {
            addCriterion("ALT_ADES is null");
            return (Criteria) this;
        }

        public Criteria andAltAdesIsNotNull() {
            addCriterion("ALT_ADES is not null");
            return (Criteria) this;
        }

        public Criteria andAltAdesEqualTo(String value) {
            addCriterion("ALT_ADES =", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesNotEqualTo(String value) {
            addCriterion("ALT_ADES <>", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesGreaterThan(String value) {
            addCriterion("ALT_ADES >", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesGreaterThanOrEqualTo(String value) {
            addCriterion("ALT_ADES >=", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesLessThan(String value) {
            addCriterion("ALT_ADES <", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesLessThanOrEqualTo(String value) {
            addCriterion("ALT_ADES <=", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesLike(String value) {
            addCriterion("ALT_ADES like", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesNotLike(String value) {
            addCriterion("ALT_ADES not like", value, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesIn(List<String> values) {
            addCriterion("ALT_ADES in", values, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesNotIn(List<String> values) {
            addCriterion("ALT_ADES not in", values, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesBetween(String value1, String value2) {
            addCriterion("ALT_ADES between", value1, value2, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltAdesNotBetween(String value1, String value2) {
            addCriterion("ALT_ADES not between", value1, value2, "altAdes");
            return (Criteria) this;
        }

        public Criteria andAltSibtIsNull() {
            addCriterion("ALT_SIBT is null");
            return (Criteria) this;
        }

        public Criteria andAltSibtIsNotNull() {
            addCriterion("ALT_SIBT is not null");
            return (Criteria) this;
        }

        public Criteria andAltSibtEqualTo(Date value) {
            addCriterion("ALT_SIBT =", value, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtNotEqualTo(Date value) {
            addCriterion("ALT_SIBT <>", value, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtGreaterThan(Date value) {
            addCriterion("ALT_SIBT >", value, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtGreaterThanOrEqualTo(Date value) {
            addCriterion("ALT_SIBT >=", value, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtLessThan(Date value) {
            addCriterion("ALT_SIBT <", value, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtLessThanOrEqualTo(Date value) {
            addCriterion("ALT_SIBT <=", value, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtIn(List<Date> values) {
            addCriterion("ALT_SIBT in", values, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtNotIn(List<Date> values) {
            addCriterion("ALT_SIBT not in", values, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtBetween(Date value1, Date value2) {
            addCriterion("ALT_SIBT between", value1, value2, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltSibtNotBetween(Date value1, Date value2) {
            addCriterion("ALT_SIBT not between", value1, value2, "altSibt");
            return (Criteria) this;
        }

        public Criteria andAltEldtIsNull() {
            addCriterion("ALT_ELDT is null");
            return (Criteria) this;
        }

        public Criteria andAltEldtIsNotNull() {
            addCriterion("ALT_ELDT is not null");
            return (Criteria) this;
        }

        public Criteria andAltEldtEqualTo(Date value) {
            addCriterion("ALT_ELDT =", value, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtNotEqualTo(Date value) {
            addCriterion("ALT_ELDT <>", value, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtGreaterThan(Date value) {
            addCriterion("ALT_ELDT >", value, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtGreaterThanOrEqualTo(Date value) {
            addCriterion("ALT_ELDT >=", value, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtLessThan(Date value) {
            addCriterion("ALT_ELDT <", value, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtLessThanOrEqualTo(Date value) {
            addCriterion("ALT_ELDT <=", value, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtIn(List<Date> values) {
            addCriterion("ALT_ELDT in", values, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtNotIn(List<Date> values) {
            addCriterion("ALT_ELDT not in", values, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtBetween(Date value1, Date value2) {
            addCriterion("ALT_ELDT between", value1, value2, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltEldtNotBetween(Date value1, Date value2) {
            addCriterion("ALT_ELDT not between", value1, value2, "altEldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtIsNull() {
            addCriterion("ALT_ALDT is null");
            return (Criteria) this;
        }

        public Criteria andAltAldtIsNotNull() {
            addCriterion("ALT_ALDT is not null");
            return (Criteria) this;
        }

        public Criteria andAltAldtEqualTo(Date value) {
            addCriterion("ALT_ALDT =", value, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtNotEqualTo(Date value) {
            addCriterion("ALT_ALDT <>", value, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtGreaterThan(Date value) {
            addCriterion("ALT_ALDT >", value, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtGreaterThanOrEqualTo(Date value) {
            addCriterion("ALT_ALDT >=", value, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtLessThan(Date value) {
            addCriterion("ALT_ALDT <", value, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtLessThanOrEqualTo(Date value) {
            addCriterion("ALT_ALDT <=", value, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtIn(List<Date> values) {
            addCriterion("ALT_ALDT in", values, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtNotIn(List<Date> values) {
            addCriterion("ALT_ALDT not in", values, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtBetween(Date value1, Date value2) {
            addCriterion("ALT_ALDT between", value1, value2, "altAldt");
            return (Criteria) this;
        }

        public Criteria andAltAldtNotBetween(Date value1, Date value2) {
            addCriterion("ALT_ALDT not between", value1, value2, "altAldt");
            return (Criteria) this;
        }

        public Criteria andExitIsNull() {
            addCriterion("EXIT is null");
            return (Criteria) this;
        }

        public Criteria andExitIsNotNull() {
            addCriterion("EXIT is not null");
            return (Criteria) this;
        }

        public Criteria andExitEqualTo(Integer value) {
            addCriterion("EXIT =", value, "exit");
            return (Criteria) this;
        }

        public Criteria andExitNotEqualTo(Integer value) {
            addCriterion("EXIT <>", value, "exit");
            return (Criteria) this;
        }

        public Criteria andExitGreaterThan(Integer value) {
            addCriterion("EXIT >", value, "exit");
            return (Criteria) this;
        }

        public Criteria andExitGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXIT >=", value, "exit");
            return (Criteria) this;
        }

        public Criteria andExitLessThan(Integer value) {
            addCriterion("EXIT <", value, "exit");
            return (Criteria) this;
        }

        public Criteria andExitLessThanOrEqualTo(Integer value) {
            addCriterion("EXIT <=", value, "exit");
            return (Criteria) this;
        }

        public Criteria andExitIn(List<Integer> values) {
            addCriterion("EXIT in", values, "exit");
            return (Criteria) this;
        }

        public Criteria andExitNotIn(List<Integer> values) {
            addCriterion("EXIT not in", values, "exit");
            return (Criteria) this;
        }

        public Criteria andExitBetween(Integer value1, Integer value2) {
            addCriterion("EXIT between", value1, value2, "exit");
            return (Criteria) this;
        }

        public Criteria andExitNotBetween(Integer value1, Integer value2) {
            addCriterion("EXIT not between", value1, value2, "exit");
            return (Criteria) this;
        }

        public Criteria andExotIsNull() {
            addCriterion("EXOT is null");
            return (Criteria) this;
        }

        public Criteria andExotIsNotNull() {
            addCriterion("EXOT is not null");
            return (Criteria) this;
        }

        public Criteria andExotEqualTo(Integer value) {
            addCriterion("EXOT =", value, "exot");
            return (Criteria) this;
        }

        public Criteria andExotNotEqualTo(Integer value) {
            addCriterion("EXOT <>", value, "exot");
            return (Criteria) this;
        }

        public Criteria andExotGreaterThan(Integer value) {
            addCriterion("EXOT >", value, "exot");
            return (Criteria) this;
        }

        public Criteria andExotGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXOT >=", value, "exot");
            return (Criteria) this;
        }

        public Criteria andExotLessThan(Integer value) {
            addCriterion("EXOT <", value, "exot");
            return (Criteria) this;
        }

        public Criteria andExotLessThanOrEqualTo(Integer value) {
            addCriterion("EXOT <=", value, "exot");
            return (Criteria) this;
        }

        public Criteria andExotIn(List<Integer> values) {
            addCriterion("EXOT in", values, "exot");
            return (Criteria) this;
        }

        public Criteria andExotNotIn(List<Integer> values) {
            addCriterion("EXOT not in", values, "exot");
            return (Criteria) this;
        }

        public Criteria andExotBetween(Integer value1, Integer value2) {
            addCriterion("EXOT between", value1, value2, "exot");
            return (Criteria) this;
        }

        public Criteria andExotNotBetween(Integer value1, Integer value2) {
            addCriterion("EXOT not between", value1, value2, "exot");
            return (Criteria) this;
        }

        public Criteria andAxitIsNull() {
            addCriterion("AXIT is null");
            return (Criteria) this;
        }

        public Criteria andAxitIsNotNull() {
            addCriterion("AXIT is not null");
            return (Criteria) this;
        }

        public Criteria andAxitEqualTo(Integer value) {
            addCriterion("AXIT =", value, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitNotEqualTo(Integer value) {
            addCriterion("AXIT <>", value, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitGreaterThan(Integer value) {
            addCriterion("AXIT >", value, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitGreaterThanOrEqualTo(Integer value) {
            addCriterion("AXIT >=", value, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitLessThan(Integer value) {
            addCriterion("AXIT <", value, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitLessThanOrEqualTo(Integer value) {
            addCriterion("AXIT <=", value, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitIn(List<Integer> values) {
            addCriterion("AXIT in", values, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitNotIn(List<Integer> values) {
            addCriterion("AXIT not in", values, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitBetween(Integer value1, Integer value2) {
            addCriterion("AXIT between", value1, value2, "axit");
            return (Criteria) this;
        }

        public Criteria andAxitNotBetween(Integer value1, Integer value2) {
            addCriterion("AXIT not between", value1, value2, "axit");
            return (Criteria) this;
        }

        public Criteria andAxotIsNull() {
            addCriterion("AXOT is null");
            return (Criteria) this;
        }

        public Criteria andAxotIsNotNull() {
            addCriterion("AXOT is not null");
            return (Criteria) this;
        }

        public Criteria andAxotEqualTo(Integer value) {
            addCriterion("AXOT =", value, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotNotEqualTo(Integer value) {
            addCriterion("AXOT <>", value, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotGreaterThan(Integer value) {
            addCriterion("AXOT >", value, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotGreaterThanOrEqualTo(Integer value) {
            addCriterion("AXOT >=", value, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotLessThan(Integer value) {
            addCriterion("AXOT <", value, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotLessThanOrEqualTo(Integer value) {
            addCriterion("AXOT <=", value, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotIn(List<Integer> values) {
            addCriterion("AXOT in", values, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotNotIn(List<Integer> values) {
            addCriterion("AXOT not in", values, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotBetween(Integer value1, Integer value2) {
            addCriterion("AXOT between", value1, value2, "axot");
            return (Criteria) this;
        }

        public Criteria andAxotNotBetween(Integer value1, Integer value2) {
            addCriterion("AXOT not between", value1, value2, "axot");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNull() {
            addCriterion("DELAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNotNull() {
            addCriterion("DELAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeEqualTo(Integer value) {
            addCriterion("DELAY_TIME =", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotEqualTo(Integer value) {
            addCriterion("DELAY_TIME <>", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThan(Integer value) {
            addCriterion("DELAY_TIME >", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELAY_TIME >=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThan(Integer value) {
            addCriterion("DELAY_TIME <", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThanOrEqualTo(Integer value) {
            addCriterion("DELAY_TIME <=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIn(List<Integer> values) {
            addCriterion("DELAY_TIME in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotIn(List<Integer> values) {
            addCriterion("DELAY_TIME not in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeBetween(Integer value1, Integer value2) {
            addCriterion("DELAY_TIME between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("DELAY_TIME not between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andStandIsNull() {
            addCriterion("STAND is null");
            return (Criteria) this;
        }

        public Criteria andStandIsNotNull() {
            addCriterion("STAND is not null");
            return (Criteria) this;
        }

        public Criteria andStandEqualTo(String value) {
            addCriterion("STAND =", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotEqualTo(String value) {
            addCriterion("STAND <>", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandGreaterThan(String value) {
            addCriterion("STAND >", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandGreaterThanOrEqualTo(String value) {
            addCriterion("STAND >=", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLessThan(String value) {
            addCriterion("STAND <", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLessThanOrEqualTo(String value) {
            addCriterion("STAND <=", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandLike(String value) {
            addCriterion("STAND like", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotLike(String value) {
            addCriterion("STAND not like", value, "stand");
            return (Criteria) this;
        }

        public Criteria andStandIn(List<String> values) {
            addCriterion("STAND in", values, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotIn(List<String> values) {
            addCriterion("STAND not in", values, "stand");
            return (Criteria) this;
        }

        public Criteria andStandBetween(String value1, String value2) {
            addCriterion("STAND between", value1, value2, "stand");
            return (Criteria) this;
        }

        public Criteria andStandNotBetween(String value1, String value2) {
            addCriterion("STAND not between", value1, value2, "stand");
            return (Criteria) this;
        }

        public Criteria andGateIsNull() {
            addCriterion("GATE is null");
            return (Criteria) this;
        }

        public Criteria andGateIsNotNull() {
            addCriterion("GATE is not null");
            return (Criteria) this;
        }

        public Criteria andGateEqualTo(String value) {
            addCriterion("GATE =", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateNotEqualTo(String value) {
            addCriterion("GATE <>", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateGreaterThan(String value) {
            addCriterion("GATE >", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateGreaterThanOrEqualTo(String value) {
            addCriterion("GATE >=", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateLessThan(String value) {
            addCriterion("GATE <", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateLessThanOrEqualTo(String value) {
            addCriterion("GATE <=", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateLike(String value) {
            addCriterion("GATE like", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateNotLike(String value) {
            addCriterion("GATE not like", value, "gate");
            return (Criteria) this;
        }

        public Criteria andGateIn(List<String> values) {
            addCriterion("GATE in", values, "gate");
            return (Criteria) this;
        }

        public Criteria andGateNotIn(List<String> values) {
            addCriterion("GATE not in", values, "gate");
            return (Criteria) this;
        }

        public Criteria andGateBetween(String value1, String value2) {
            addCriterion("GATE between", value1, value2, "gate");
            return (Criteria) this;
        }

        public Criteria andGateNotBetween(String value1, String value2) {
            addCriterion("GATE not between", value1, value2, "gate");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNull() {
            addCriterion("CHECK_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIsNotNull() {
            addCriterion("CHECK_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeEqualTo(Date value) {
            addCriterion("CHECK_START_TIME =", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotEqualTo(Date value) {
            addCriterion("CHECK_START_TIME <>", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThan(Date value) {
            addCriterion("CHECK_START_TIME >", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_START_TIME >=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThan(Date value) {
            addCriterion("CHECK_START_TIME <", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_START_TIME <=", value, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeIn(List<Date> values) {
            addCriterion("CHECK_START_TIME in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotIn(List<Date> values) {
            addCriterion("CHECK_START_TIME not in", values, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_START_TIME between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_START_TIME not between", value1, value2, "checkStartTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("CHECK_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("CHECK_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterion("CHECK_END_TIME =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterion("CHECK_END_TIME <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterion("CHECK_END_TIME >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_END_TIME >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterion("CHECK_END_TIME <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_END_TIME <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterion("CHECK_END_TIME in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterion("CHECK_END_TIME not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_END_TIME between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_END_TIME not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCobtIsNull() {
            addCriterion("COBT is null");
            return (Criteria) this;
        }

        public Criteria andCobtIsNotNull() {
            addCriterion("COBT is not null");
            return (Criteria) this;
        }

        public Criteria andCobtEqualTo(Date value) {
            addCriterion("COBT =", value, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtNotEqualTo(Date value) {
            addCriterion("COBT <>", value, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtGreaterThan(Date value) {
            addCriterion("COBT >", value, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtGreaterThanOrEqualTo(Date value) {
            addCriterion("COBT >=", value, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtLessThan(Date value) {
            addCriterion("COBT <", value, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtLessThanOrEqualTo(Date value) {
            addCriterion("COBT <=", value, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtIn(List<Date> values) {
            addCriterion("COBT in", values, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtNotIn(List<Date> values) {
            addCriterion("COBT not in", values, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtBetween(Date value1, Date value2) {
            addCriterion("COBT between", value1, value2, "cobt");
            return (Criteria) this;
        }

        public Criteria andCobtNotBetween(Date value1, Date value2) {
            addCriterion("COBT not between", value1, value2, "cobt");
            return (Criteria) this;
        }

        public Criteria andCtotIsNull() {
            addCriterion("CTOT is null");
            return (Criteria) this;
        }

        public Criteria andCtotIsNotNull() {
            addCriterion("CTOT is not null");
            return (Criteria) this;
        }

        public Criteria andCtotEqualTo(Date value) {
            addCriterion("CTOT =", value, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotNotEqualTo(Date value) {
            addCriterion("CTOT <>", value, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotGreaterThan(Date value) {
            addCriterion("CTOT >", value, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotGreaterThanOrEqualTo(Date value) {
            addCriterion("CTOT >=", value, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotLessThan(Date value) {
            addCriterion("CTOT <", value, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotLessThanOrEqualTo(Date value) {
            addCriterion("CTOT <=", value, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotIn(List<Date> values) {
            addCriterion("CTOT in", values, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotNotIn(List<Date> values) {
            addCriterion("CTOT not in", values, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotBetween(Date value1, Date value2) {
            addCriterion("CTOT between", value1, value2, "ctot");
            return (Criteria) this;
        }

        public Criteria andCtotNotBetween(Date value1, Date value2) {
            addCriterion("CTOT not between", value1, value2, "ctot");
            return (Criteria) this;
        }

        public Criteria andTobtIsNull() {
            addCriterion("TOBT is null");
            return (Criteria) this;
        }

        public Criteria andTobtIsNotNull() {
            addCriterion("TOBT is not null");
            return (Criteria) this;
        }

        public Criteria andTobtEqualTo(Date value) {
            addCriterion("TOBT =", value, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtNotEqualTo(Date value) {
            addCriterion("TOBT <>", value, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtGreaterThan(Date value) {
            addCriterion("TOBT >", value, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtGreaterThanOrEqualTo(Date value) {
            addCriterion("TOBT >=", value, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtLessThan(Date value) {
            addCriterion("TOBT <", value, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtLessThanOrEqualTo(Date value) {
            addCriterion("TOBT <=", value, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtIn(List<Date> values) {
            addCriterion("TOBT in", values, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtNotIn(List<Date> values) {
            addCriterion("TOBT not in", values, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtBetween(Date value1, Date value2) {
            addCriterion("TOBT between", value1, value2, "tobt");
            return (Criteria) this;
        }

        public Criteria andTobtNotBetween(Date value1, Date value2) {
            addCriterion("TOBT not between", value1, value2, "tobt");
            return (Criteria) this;
        }

        public Criteria andTtotIsNull() {
            addCriterion("TTOT is null");
            return (Criteria) this;
        }

        public Criteria andTtotIsNotNull() {
            addCriterion("TTOT is not null");
            return (Criteria) this;
        }

        public Criteria andTtotEqualTo(Date value) {
            addCriterion("TTOT =", value, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotNotEqualTo(Date value) {
            addCriterion("TTOT <>", value, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotGreaterThan(Date value) {
            addCriterion("TTOT >", value, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotGreaterThanOrEqualTo(Date value) {
            addCriterion("TTOT >=", value, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotLessThan(Date value) {
            addCriterion("TTOT <", value, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotLessThanOrEqualTo(Date value) {
            addCriterion("TTOT <=", value, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotIn(List<Date> values) {
            addCriterion("TTOT in", values, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotNotIn(List<Date> values) {
            addCriterion("TTOT not in", values, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotBetween(Date value1, Date value2) {
            addCriterion("TTOT between", value1, value2, "ttot");
            return (Criteria) this;
        }

        public Criteria andTtotNotBetween(Date value1, Date value2) {
            addCriterion("TTOT not between", value1, value2, "ttot");
            return (Criteria) this;
        }

        public Criteria andATobtIsNull() {
            addCriterion("A_TOBT is null");
            return (Criteria) this;
        }

        public Criteria andATobtIsNotNull() {
            addCriterion("A_TOBT is not null");
            return (Criteria) this;
        }

        public Criteria andATobtEqualTo(Date value) {
            addCriterion("A_TOBT =", value, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtNotEqualTo(Date value) {
            addCriterion("A_TOBT <>", value, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtGreaterThan(Date value) {
            addCriterion("A_TOBT >", value, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtGreaterThanOrEqualTo(Date value) {
            addCriterion("A_TOBT >=", value, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtLessThan(Date value) {
            addCriterion("A_TOBT <", value, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtLessThanOrEqualTo(Date value) {
            addCriterion("A_TOBT <=", value, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtIn(List<Date> values) {
            addCriterion("A_TOBT in", values, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtNotIn(List<Date> values) {
            addCriterion("A_TOBT not in", values, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtBetween(Date value1, Date value2) {
            addCriterion("A_TOBT between", value1, value2, "aTobt");
            return (Criteria) this;
        }

        public Criteria andATobtNotBetween(Date value1, Date value2) {
            addCriterion("A_TOBT not between", value1, value2, "aTobt");
            return (Criteria) this;
        }

        public Criteria andDobtIsNull() {
            addCriterion("DOBT is null");
            return (Criteria) this;
        }

        public Criteria andDobtIsNotNull() {
            addCriterion("DOBT is not null");
            return (Criteria) this;
        }

        public Criteria andDobtEqualTo(Date value) {
            addCriterion("DOBT =", value, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtNotEqualTo(Date value) {
            addCriterion("DOBT <>", value, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtGreaterThan(Date value) {
            addCriterion("DOBT >", value, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtGreaterThanOrEqualTo(Date value) {
            addCriterion("DOBT >=", value, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtLessThan(Date value) {
            addCriterion("DOBT <", value, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtLessThanOrEqualTo(Date value) {
            addCriterion("DOBT <=", value, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtIn(List<Date> values) {
            addCriterion("DOBT in", values, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtNotIn(List<Date> values) {
            addCriterion("DOBT not in", values, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtBetween(Date value1, Date value2) {
            addCriterion("DOBT between", value1, value2, "dobt");
            return (Criteria) this;
        }

        public Criteria andDobtNotBetween(Date value1, Date value2) {
            addCriterion("DOBT not between", value1, value2, "dobt");
            return (Criteria) this;
        }

        public Criteria andFctIsNull() {
            addCriterion("FCT is null");
            return (Criteria) this;
        }

        public Criteria andFctIsNotNull() {
            addCriterion("FCT is not null");
            return (Criteria) this;
        }

        public Criteria andFctEqualTo(Date value) {
            addCriterion("FCT =", value, "fct");
            return (Criteria) this;
        }

        public Criteria andFctNotEqualTo(Date value) {
            addCriterion("FCT <>", value, "fct");
            return (Criteria) this;
        }

        public Criteria andFctGreaterThan(Date value) {
            addCriterion("FCT >", value, "fct");
            return (Criteria) this;
        }

        public Criteria andFctGreaterThanOrEqualTo(Date value) {
            addCriterion("FCT >=", value, "fct");
            return (Criteria) this;
        }

        public Criteria andFctLessThan(Date value) {
            addCriterion("FCT <", value, "fct");
            return (Criteria) this;
        }

        public Criteria andFctLessThanOrEqualTo(Date value) {
            addCriterion("FCT <=", value, "fct");
            return (Criteria) this;
        }

        public Criteria andFctIn(List<Date> values) {
            addCriterion("FCT in", values, "fct");
            return (Criteria) this;
        }

        public Criteria andFctNotIn(List<Date> values) {
            addCriterion("FCT not in", values, "fct");
            return (Criteria) this;
        }

        public Criteria andFctBetween(Date value1, Date value2) {
            addCriterion("FCT between", value1, value2, "fct");
            return (Criteria) this;
        }

        public Criteria andFctNotBetween(Date value1, Date value2) {
            addCriterion("FCT not between", value1, value2, "fct");
            return (Criteria) this;
        }

        public Criteria andRpotIsNull() {
            addCriterion("RPOT is null");
            return (Criteria) this;
        }

        public Criteria andRpotIsNotNull() {
            addCriterion("RPOT is not null");
            return (Criteria) this;
        }

        public Criteria andRpotEqualTo(Date value) {
            addCriterion("RPOT =", value, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotNotEqualTo(Date value) {
            addCriterion("RPOT <>", value, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotGreaterThan(Date value) {
            addCriterion("RPOT >", value, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotGreaterThanOrEqualTo(Date value) {
            addCriterion("RPOT >=", value, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotLessThan(Date value) {
            addCriterion("RPOT <", value, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotLessThanOrEqualTo(Date value) {
            addCriterion("RPOT <=", value, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotIn(List<Date> values) {
            addCriterion("RPOT in", values, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotNotIn(List<Date> values) {
            addCriterion("RPOT not in", values, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotBetween(Date value1, Date value2) {
            addCriterion("RPOT between", value1, value2, "rpot");
            return (Criteria) this;
        }

        public Criteria andRpotNotBetween(Date value1, Date value2) {
            addCriterion("RPOT not between", value1, value2, "rpot");
            return (Criteria) this;
        }

        public Criteria andApotIsNull() {
            addCriterion("APOT is null");
            return (Criteria) this;
        }

        public Criteria andApotIsNotNull() {
            addCriterion("APOT is not null");
            return (Criteria) this;
        }

        public Criteria andApotEqualTo(Date value) {
            addCriterion("APOT =", value, "apot");
            return (Criteria) this;
        }

        public Criteria andApotNotEqualTo(Date value) {
            addCriterion("APOT <>", value, "apot");
            return (Criteria) this;
        }

        public Criteria andApotGreaterThan(Date value) {
            addCriterion("APOT >", value, "apot");
            return (Criteria) this;
        }

        public Criteria andApotGreaterThanOrEqualTo(Date value) {
            addCriterion("APOT >=", value, "apot");
            return (Criteria) this;
        }

        public Criteria andApotLessThan(Date value) {
            addCriterion("APOT <", value, "apot");
            return (Criteria) this;
        }

        public Criteria andApotLessThanOrEqualTo(Date value) {
            addCriterion("APOT <=", value, "apot");
            return (Criteria) this;
        }

        public Criteria andApotIn(List<Date> values) {
            addCriterion("APOT in", values, "apot");
            return (Criteria) this;
        }

        public Criteria andApotNotIn(List<Date> values) {
            addCriterion("APOT not in", values, "apot");
            return (Criteria) this;
        }

        public Criteria andApotBetween(Date value1, Date value2) {
            addCriterion("APOT between", value1, value2, "apot");
            return (Criteria) this;
        }

        public Criteria andApotNotBetween(Date value1, Date value2) {
            addCriterion("APOT not between", value1, value2, "apot");
            return (Criteria) this;
        }

        public Criteria andAsatIsNull() {
            addCriterion("ASAT is null");
            return (Criteria) this;
        }

        public Criteria andAsatIsNotNull() {
            addCriterion("ASAT is not null");
            return (Criteria) this;
        }

        public Criteria andAsatEqualTo(Date value) {
            addCriterion("ASAT =", value, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatNotEqualTo(Date value) {
            addCriterion("ASAT <>", value, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatGreaterThan(Date value) {
            addCriterion("ASAT >", value, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatGreaterThanOrEqualTo(Date value) {
            addCriterion("ASAT >=", value, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatLessThan(Date value) {
            addCriterion("ASAT <", value, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatLessThanOrEqualTo(Date value) {
            addCriterion("ASAT <=", value, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatIn(List<Date> values) {
            addCriterion("ASAT in", values, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatNotIn(List<Date> values) {
            addCriterion("ASAT not in", values, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatBetween(Date value1, Date value2) {
            addCriterion("ASAT between", value1, value2, "asat");
            return (Criteria) this;
        }

        public Criteria andAsatNotBetween(Date value1, Date value2) {
            addCriterion("ASAT not between", value1, value2, "asat");
            return (Criteria) this;
        }

        public Criteria andRunwayIsNull() {
            addCriterion("RUNWAY is null");
            return (Criteria) this;
        }

        public Criteria andRunwayIsNotNull() {
            addCriterion("RUNWAY is not null");
            return (Criteria) this;
        }

        public Criteria andRunwayEqualTo(String value) {
            addCriterion("RUNWAY =", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayNotEqualTo(String value) {
            addCriterion("RUNWAY <>", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayGreaterThan(String value) {
            addCriterion("RUNWAY >", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayGreaterThanOrEqualTo(String value) {
            addCriterion("RUNWAY >=", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayLessThan(String value) {
            addCriterion("RUNWAY <", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayLessThanOrEqualTo(String value) {
            addCriterion("RUNWAY <=", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayLike(String value) {
            addCriterion("RUNWAY like", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayNotLike(String value) {
            addCriterion("RUNWAY not like", value, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayIn(List<String> values) {
            addCriterion("RUNWAY in", values, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayNotIn(List<String> values) {
            addCriterion("RUNWAY not in", values, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayBetween(String value1, String value2) {
            addCriterion("RUNWAY between", value1, value2, "runway");
            return (Criteria) this;
        }

        public Criteria andRunwayNotBetween(String value1, String value2) {
            addCriterion("RUNWAY not between", value1, value2, "runway");
            return (Criteria) this;
        }

        public Criteria andErslIsNull() {
            addCriterion("ERSL is null");
            return (Criteria) this;
        }

        public Criteria andErslIsNotNull() {
            addCriterion("ERSL is not null");
            return (Criteria) this;
        }

        public Criteria andErslEqualTo(Date value) {
            addCriterion("ERSL =", value, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslNotEqualTo(Date value) {
            addCriterion("ERSL <>", value, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslGreaterThan(Date value) {
            addCriterion("ERSL >", value, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslGreaterThanOrEqualTo(Date value) {
            addCriterion("ERSL >=", value, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslLessThan(Date value) {
            addCriterion("ERSL <", value, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslLessThanOrEqualTo(Date value) {
            addCriterion("ERSL <=", value, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslIn(List<Date> values) {
            addCriterion("ERSL in", values, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslNotIn(List<Date> values) {
            addCriterion("ERSL not in", values, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslBetween(Date value1, Date value2) {
            addCriterion("ERSL between", value1, value2, "ersl");
            return (Criteria) this;
        }

        public Criteria andErslNotBetween(Date value1, Date value2) {
            addCriterion("ERSL not between", value1, value2, "ersl");
            return (Criteria) this;
        }

        public Criteria andArslIsNull() {
            addCriterion("ARSL is null");
            return (Criteria) this;
        }

        public Criteria andArslIsNotNull() {
            addCriterion("ARSL is not null");
            return (Criteria) this;
        }

        public Criteria andArslEqualTo(Date value) {
            addCriterion("ARSL =", value, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslNotEqualTo(Date value) {
            addCriterion("ARSL <>", value, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslGreaterThan(Date value) {
            addCriterion("ARSL >", value, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslGreaterThanOrEqualTo(Date value) {
            addCriterion("ARSL >=", value, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslLessThan(Date value) {
            addCriterion("ARSL <", value, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslLessThanOrEqualTo(Date value) {
            addCriterion("ARSL <=", value, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslIn(List<Date> values) {
            addCriterion("ARSL in", values, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslNotIn(List<Date> values) {
            addCriterion("ARSL not in", values, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslBetween(Date value1, Date value2) {
            addCriterion("ARSL between", value1, value2, "arsl");
            return (Criteria) this;
        }

        public Criteria andArslNotBetween(Date value1, Date value2) {
            addCriterion("ARSL not between", value1, value2, "arsl");
            return (Criteria) this;
        }

        public Criteria andElswIsNull() {
            addCriterion("ELSW is null");
            return (Criteria) this;
        }

        public Criteria andElswIsNotNull() {
            addCriterion("ELSW is not null");
            return (Criteria) this;
        }

        public Criteria andElswEqualTo(Date value) {
            addCriterion("ELSW =", value, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswNotEqualTo(Date value) {
            addCriterion("ELSW <>", value, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswGreaterThan(Date value) {
            addCriterion("ELSW >", value, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswGreaterThanOrEqualTo(Date value) {
            addCriterion("ELSW >=", value, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswLessThan(Date value) {
            addCriterion("ELSW <", value, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswLessThanOrEqualTo(Date value) {
            addCriterion("ELSW <=", value, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswIn(List<Date> values) {
            addCriterion("ELSW in", values, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswNotIn(List<Date> values) {
            addCriterion("ELSW not in", values, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswBetween(Date value1, Date value2) {
            addCriterion("ELSW between", value1, value2, "elsw");
            return (Criteria) this;
        }

        public Criteria andElswNotBetween(Date value1, Date value2) {
            addCriterion("ELSW not between", value1, value2, "elsw");
            return (Criteria) this;
        }

        public Criteria andAlswIsNull() {
            addCriterion("ALSW is null");
            return (Criteria) this;
        }

        public Criteria andAlswIsNotNull() {
            addCriterion("ALSW is not null");
            return (Criteria) this;
        }

        public Criteria andAlswEqualTo(Date value) {
            addCriterion("ALSW =", value, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswNotEqualTo(Date value) {
            addCriterion("ALSW <>", value, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswGreaterThan(Date value) {
            addCriterion("ALSW >", value, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswGreaterThanOrEqualTo(Date value) {
            addCriterion("ALSW >=", value, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswLessThan(Date value) {
            addCriterion("ALSW <", value, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswLessThanOrEqualTo(Date value) {
            addCriterion("ALSW <=", value, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswIn(List<Date> values) {
            addCriterion("ALSW in", values, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswNotIn(List<Date> values) {
            addCriterion("ALSW not in", values, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswBetween(Date value1, Date value2) {
            addCriterion("ALSW between", value1, value2, "alsw");
            return (Criteria) this;
        }

        public Criteria andAlswNotBetween(Date value1, Date value2) {
            addCriterion("ALSW not between", value1, value2, "alsw");
            return (Criteria) this;
        }

        public Criteria andStdcIsNull() {
            addCriterion("STDC is null");
            return (Criteria) this;
        }

        public Criteria andStdcIsNotNull() {
            addCriterion("STDC is not null");
            return (Criteria) this;
        }

        public Criteria andStdcEqualTo(Date value) {
            addCriterion("STDC =", value, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcNotEqualTo(Date value) {
            addCriterion("STDC <>", value, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcGreaterThan(Date value) {
            addCriterion("STDC >", value, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcGreaterThanOrEqualTo(Date value) {
            addCriterion("STDC >=", value, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcLessThan(Date value) {
            addCriterion("STDC <", value, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcLessThanOrEqualTo(Date value) {
            addCriterion("STDC <=", value, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcIn(List<Date> values) {
            addCriterion("STDC in", values, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcNotIn(List<Date> values) {
            addCriterion("STDC not in", values, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcBetween(Date value1, Date value2) {
            addCriterion("STDC between", value1, value2, "stdc");
            return (Criteria) this;
        }

        public Criteria andStdcNotBetween(Date value1, Date value2) {
            addCriterion("STDC not between", value1, value2, "stdc");
            return (Criteria) this;
        }

        public Criteria andEtdoIsNull() {
            addCriterion("ETDO is null");
            return (Criteria) this;
        }

        public Criteria andEtdoIsNotNull() {
            addCriterion("ETDO is not null");
            return (Criteria) this;
        }

        public Criteria andEtdoEqualTo(Date value) {
            addCriterion("ETDO =", value, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoNotEqualTo(Date value) {
            addCriterion("ETDO <>", value, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoGreaterThan(Date value) {
            addCriterion("ETDO >", value, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoGreaterThanOrEqualTo(Date value) {
            addCriterion("ETDO >=", value, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoLessThan(Date value) {
            addCriterion("ETDO <", value, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoLessThanOrEqualTo(Date value) {
            addCriterion("ETDO <=", value, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoIn(List<Date> values) {
            addCriterion("ETDO in", values, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoNotIn(List<Date> values) {
            addCriterion("ETDO not in", values, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoBetween(Date value1, Date value2) {
            addCriterion("ETDO between", value1, value2, "etdo");
            return (Criteria) this;
        }

        public Criteria andEtdoNotBetween(Date value1, Date value2) {
            addCriterion("ETDO not between", value1, value2, "etdo");
            return (Criteria) this;
        }

        public Criteria andAtdoIsNull() {
            addCriterion("ATDO is null");
            return (Criteria) this;
        }

        public Criteria andAtdoIsNotNull() {
            addCriterion("ATDO is not null");
            return (Criteria) this;
        }

        public Criteria andAtdoEqualTo(Date value) {
            addCriterion("ATDO =", value, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoNotEqualTo(Date value) {
            addCriterion("ATDO <>", value, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoGreaterThan(Date value) {
            addCriterion("ATDO >", value, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoGreaterThanOrEqualTo(Date value) {
            addCriterion("ATDO >=", value, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoLessThan(Date value) {
            addCriterion("ATDO <", value, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoLessThanOrEqualTo(Date value) {
            addCriterion("ATDO <=", value, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoIn(List<Date> values) {
            addCriterion("ATDO in", values, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoNotIn(List<Date> values) {
            addCriterion("ATDO not in", values, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoBetween(Date value1, Date value2) {
            addCriterion("ATDO between", value1, value2, "atdo");
            return (Criteria) this;
        }

        public Criteria andAtdoNotBetween(Date value1, Date value2) {
            addCriterion("ATDO not between", value1, value2, "atdo");
            return (Criteria) this;
        }

        public Criteria andEtdcIsNull() {
            addCriterion("ETDC is null");
            return (Criteria) this;
        }

        public Criteria andEtdcIsNotNull() {
            addCriterion("ETDC is not null");
            return (Criteria) this;
        }

        public Criteria andEtdcEqualTo(Date value) {
            addCriterion("ETDC =", value, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcNotEqualTo(Date value) {
            addCriterion("ETDC <>", value, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcGreaterThan(Date value) {
            addCriterion("ETDC >", value, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcGreaterThanOrEqualTo(Date value) {
            addCriterion("ETDC >=", value, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcLessThan(Date value) {
            addCriterion("ETDC <", value, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcLessThanOrEqualTo(Date value) {
            addCriterion("ETDC <=", value, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcIn(List<Date> values) {
            addCriterion("ETDC in", values, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcNotIn(List<Date> values) {
            addCriterion("ETDC not in", values, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcBetween(Date value1, Date value2) {
            addCriterion("ETDC between", value1, value2, "etdc");
            return (Criteria) this;
        }

        public Criteria andEtdcNotBetween(Date value1, Date value2) {
            addCriterion("ETDC not between", value1, value2, "etdc");
            return (Criteria) this;
        }

        public Criteria andAtdcIsNull() {
            addCriterion("ATDC is null");
            return (Criteria) this;
        }

        public Criteria andAtdcIsNotNull() {
            addCriterion("ATDC is not null");
            return (Criteria) this;
        }

        public Criteria andAtdcEqualTo(Date value) {
            addCriterion("ATDC =", value, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcNotEqualTo(Date value) {
            addCriterion("ATDC <>", value, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcGreaterThan(Date value) {
            addCriterion("ATDC >", value, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcGreaterThanOrEqualTo(Date value) {
            addCriterion("ATDC >=", value, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcLessThan(Date value) {
            addCriterion("ATDC <", value, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcLessThanOrEqualTo(Date value) {
            addCriterion("ATDC <=", value, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcIn(List<Date> values) {
            addCriterion("ATDC in", values, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcNotIn(List<Date> values) {
            addCriterion("ATDC not in", values, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcBetween(Date value1, Date value2) {
            addCriterion("ATDC between", value1, value2, "atdc");
            return (Criteria) this;
        }

        public Criteria andAtdcNotBetween(Date value1, Date value2) {
            addCriterion("ATDC not between", value1, value2, "atdc");
            return (Criteria) this;
        }

        public Criteria andEtfoIsNull() {
            addCriterion("ETFO is null");
            return (Criteria) this;
        }

        public Criteria andEtfoIsNotNull() {
            addCriterion("ETFO is not null");
            return (Criteria) this;
        }

        public Criteria andEtfoEqualTo(Date value) {
            addCriterion("ETFO =", value, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoNotEqualTo(Date value) {
            addCriterion("ETFO <>", value, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoGreaterThan(Date value) {
            addCriterion("ETFO >", value, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoGreaterThanOrEqualTo(Date value) {
            addCriterion("ETFO >=", value, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoLessThan(Date value) {
            addCriterion("ETFO <", value, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoLessThanOrEqualTo(Date value) {
            addCriterion("ETFO <=", value, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoIn(List<Date> values) {
            addCriterion("ETFO in", values, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoNotIn(List<Date> values) {
            addCriterion("ETFO not in", values, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoBetween(Date value1, Date value2) {
            addCriterion("ETFO between", value1, value2, "etfo");
            return (Criteria) this;
        }

        public Criteria andEtfoNotBetween(Date value1, Date value2) {
            addCriterion("ETFO not between", value1, value2, "etfo");
            return (Criteria) this;
        }

        public Criteria andAtfoIsNull() {
            addCriterion("ATFO is null");
            return (Criteria) this;
        }

        public Criteria andAtfoIsNotNull() {
            addCriterion("ATFO is not null");
            return (Criteria) this;
        }

        public Criteria andAtfoEqualTo(Date value) {
            addCriterion("ATFO =", value, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoNotEqualTo(Date value) {
            addCriterion("ATFO <>", value, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoGreaterThan(Date value) {
            addCriterion("ATFO >", value, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoGreaterThanOrEqualTo(Date value) {
            addCriterion("ATFO >=", value, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoLessThan(Date value) {
            addCriterion("ATFO <", value, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoLessThanOrEqualTo(Date value) {
            addCriterion("ATFO <=", value, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoIn(List<Date> values) {
            addCriterion("ATFO in", values, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoNotIn(List<Date> values) {
            addCriterion("ATFO not in", values, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoBetween(Date value1, Date value2) {
            addCriterion("ATFO between", value1, value2, "atfo");
            return (Criteria) this;
        }

        public Criteria andAtfoNotBetween(Date value1, Date value2) {
            addCriterion("ATFO not between", value1, value2, "atfo");
            return (Criteria) this;
        }

        public Criteria andEtfcIsNull() {
            addCriterion("ETFC is null");
            return (Criteria) this;
        }

        public Criteria andEtfcIsNotNull() {
            addCriterion("ETFC is not null");
            return (Criteria) this;
        }

        public Criteria andEtfcEqualTo(Date value) {
            addCriterion("ETFC =", value, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcNotEqualTo(Date value) {
            addCriterion("ETFC <>", value, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcGreaterThan(Date value) {
            addCriterion("ETFC >", value, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcGreaterThanOrEqualTo(Date value) {
            addCriterion("ETFC >=", value, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcLessThan(Date value) {
            addCriterion("ETFC <", value, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcLessThanOrEqualTo(Date value) {
            addCriterion("ETFC <=", value, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcIn(List<Date> values) {
            addCriterion("ETFC in", values, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcNotIn(List<Date> values) {
            addCriterion("ETFC not in", values, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcBetween(Date value1, Date value2) {
            addCriterion("ETFC between", value1, value2, "etfc");
            return (Criteria) this;
        }

        public Criteria andEtfcNotBetween(Date value1, Date value2) {
            addCriterion("ETFC not between", value1, value2, "etfc");
            return (Criteria) this;
        }

        public Criteria andAtfcIsNull() {
            addCriterion("ATFC is null");
            return (Criteria) this;
        }

        public Criteria andAtfcIsNotNull() {
            addCriterion("ATFC is not null");
            return (Criteria) this;
        }

        public Criteria andAtfcEqualTo(Date value) {
            addCriterion("ATFC =", value, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcNotEqualTo(Date value) {
            addCriterion("ATFC <>", value, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcGreaterThan(Date value) {
            addCriterion("ATFC >", value, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcGreaterThanOrEqualTo(Date value) {
            addCriterion("ATFC >=", value, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcLessThan(Date value) {
            addCriterion("ATFC <", value, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcLessThanOrEqualTo(Date value) {
            addCriterion("ATFC <=", value, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcIn(List<Date> values) {
            addCriterion("ATFC in", values, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcNotIn(List<Date> values) {
            addCriterion("ATFC not in", values, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcBetween(Date value1, Date value2) {
            addCriterion("ATFC between", value1, value2, "atfc");
            return (Criteria) this;
        }

        public Criteria andAtfcNotBetween(Date value1, Date value2) {
            addCriterion("ATFC not between", value1, value2, "atfc");
            return (Criteria) this;
        }

        public Criteria andEsrIsNull() {
            addCriterion("ESR is null");
            return (Criteria) this;
        }

        public Criteria andEsrIsNotNull() {
            addCriterion("ESR is not null");
            return (Criteria) this;
        }

        public Criteria andEsrEqualTo(Date value) {
            addCriterion("ESR =", value, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrNotEqualTo(Date value) {
            addCriterion("ESR <>", value, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrGreaterThan(Date value) {
            addCriterion("ESR >", value, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrGreaterThanOrEqualTo(Date value) {
            addCriterion("ESR >=", value, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrLessThan(Date value) {
            addCriterion("ESR <", value, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrLessThanOrEqualTo(Date value) {
            addCriterion("ESR <=", value, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrIn(List<Date> values) {
            addCriterion("ESR in", values, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrNotIn(List<Date> values) {
            addCriterion("ESR not in", values, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrBetween(Date value1, Date value2) {
            addCriterion("ESR between", value1, value2, "esr");
            return (Criteria) this;
        }

        public Criteria andEsrNotBetween(Date value1, Date value2) {
            addCriterion("ESR not between", value1, value2, "esr");
            return (Criteria) this;
        }

        public Criteria andAsrIsNull() {
            addCriterion("ASR is null");
            return (Criteria) this;
        }

        public Criteria andAsrIsNotNull() {
            addCriterion("ASR is not null");
            return (Criteria) this;
        }

        public Criteria andAsrEqualTo(Date value) {
            addCriterion("ASR =", value, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrNotEqualTo(Date value) {
            addCriterion("ASR <>", value, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrGreaterThan(Date value) {
            addCriterion("ASR >", value, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrGreaterThanOrEqualTo(Date value) {
            addCriterion("ASR >=", value, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrLessThan(Date value) {
            addCriterion("ASR <", value, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrLessThanOrEqualTo(Date value) {
            addCriterion("ASR <=", value, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrIn(List<Date> values) {
            addCriterion("ASR in", values, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrNotIn(List<Date> values) {
            addCriterion("ASR not in", values, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrBetween(Date value1, Date value2) {
            addCriterion("ASR between", value1, value2, "asr");
            return (Criteria) this;
        }

        public Criteria andAsrNotBetween(Date value1, Date value2) {
            addCriterion("ASR not between", value1, value2, "asr");
            return (Criteria) this;
        }

        public Criteria andEerIsNull() {
            addCriterion("EER is null");
            return (Criteria) this;
        }

        public Criteria andEerIsNotNull() {
            addCriterion("EER is not null");
            return (Criteria) this;
        }

        public Criteria andEerEqualTo(Date value) {
            addCriterion("EER =", value, "eer");
            return (Criteria) this;
        }

        public Criteria andEerNotEqualTo(Date value) {
            addCriterion("EER <>", value, "eer");
            return (Criteria) this;
        }

        public Criteria andEerGreaterThan(Date value) {
            addCriterion("EER >", value, "eer");
            return (Criteria) this;
        }

        public Criteria andEerGreaterThanOrEqualTo(Date value) {
            addCriterion("EER >=", value, "eer");
            return (Criteria) this;
        }

        public Criteria andEerLessThan(Date value) {
            addCriterion("EER <", value, "eer");
            return (Criteria) this;
        }

        public Criteria andEerLessThanOrEqualTo(Date value) {
            addCriterion("EER <=", value, "eer");
            return (Criteria) this;
        }

        public Criteria andEerIn(List<Date> values) {
            addCriterion("EER in", values, "eer");
            return (Criteria) this;
        }

        public Criteria andEerNotIn(List<Date> values) {
            addCriterion("EER not in", values, "eer");
            return (Criteria) this;
        }

        public Criteria andEerBetween(Date value1, Date value2) {
            addCriterion("EER between", value1, value2, "eer");
            return (Criteria) this;
        }

        public Criteria andEerNotBetween(Date value1, Date value2) {
            addCriterion("EER not between", value1, value2, "eer");
            return (Criteria) this;
        }

        public Criteria andAerIsNull() {
            addCriterion("AER is null");
            return (Criteria) this;
        }

        public Criteria andAerIsNotNull() {
            addCriterion("AER is not null");
            return (Criteria) this;
        }

        public Criteria andAerEqualTo(Date value) {
            addCriterion("AER =", value, "aer");
            return (Criteria) this;
        }

        public Criteria andAerNotEqualTo(Date value) {
            addCriterion("AER <>", value, "aer");
            return (Criteria) this;
        }

        public Criteria andAerGreaterThan(Date value) {
            addCriterion("AER >", value, "aer");
            return (Criteria) this;
        }

        public Criteria andAerGreaterThanOrEqualTo(Date value) {
            addCriterion("AER >=", value, "aer");
            return (Criteria) this;
        }

        public Criteria andAerLessThan(Date value) {
            addCriterion("AER <", value, "aer");
            return (Criteria) this;
        }

        public Criteria andAerLessThanOrEqualTo(Date value) {
            addCriterion("AER <=", value, "aer");
            return (Criteria) this;
        }

        public Criteria andAerIn(List<Date> values) {
            addCriterion("AER in", values, "aer");
            return (Criteria) this;
        }

        public Criteria andAerNotIn(List<Date> values) {
            addCriterion("AER not in", values, "aer");
            return (Criteria) this;
        }

        public Criteria andAerBetween(Date value1, Date value2) {
            addCriterion("AER between", value1, value2, "aer");
            return (Criteria) this;
        }

        public Criteria andAerNotBetween(Date value1, Date value2) {
            addCriterion("AER not between", value1, value2, "aer");
            return (Criteria) this;
        }

        public Criteria andEscIsNull() {
            addCriterion("ESC is null");
            return (Criteria) this;
        }

        public Criteria andEscIsNotNull() {
            addCriterion("ESC is not null");
            return (Criteria) this;
        }

        public Criteria andEscEqualTo(Date value) {
            addCriterion("ESC =", value, "esc");
            return (Criteria) this;
        }

        public Criteria andEscNotEqualTo(Date value) {
            addCriterion("ESC <>", value, "esc");
            return (Criteria) this;
        }

        public Criteria andEscGreaterThan(Date value) {
            addCriterion("ESC >", value, "esc");
            return (Criteria) this;
        }

        public Criteria andEscGreaterThanOrEqualTo(Date value) {
            addCriterion("ESC >=", value, "esc");
            return (Criteria) this;
        }

        public Criteria andEscLessThan(Date value) {
            addCriterion("ESC <", value, "esc");
            return (Criteria) this;
        }

        public Criteria andEscLessThanOrEqualTo(Date value) {
            addCriterion("ESC <=", value, "esc");
            return (Criteria) this;
        }

        public Criteria andEscIn(List<Date> values) {
            addCriterion("ESC in", values, "esc");
            return (Criteria) this;
        }

        public Criteria andEscNotIn(List<Date> values) {
            addCriterion("ESC not in", values, "esc");
            return (Criteria) this;
        }

        public Criteria andEscBetween(Date value1, Date value2) {
            addCriterion("ESC between", value1, value2, "esc");
            return (Criteria) this;
        }

        public Criteria andEscNotBetween(Date value1, Date value2) {
            addCriterion("ESC not between", value1, value2, "esc");
            return (Criteria) this;
        }

        public Criteria andAscIsNull() {
            addCriterion("ASC is null");
            return (Criteria) this;
        }

        public Criteria andAscIsNotNull() {
            addCriterion("ASC is not null");
            return (Criteria) this;
        }

        public Criteria andAscEqualTo(Date value) {
            addCriterion("ASC =", value, "asc");
            return (Criteria) this;
        }

        public Criteria andAscNotEqualTo(Date value) {
            addCriterion("ASC <>", value, "asc");
            return (Criteria) this;
        }

        public Criteria andAscGreaterThan(Date value) {
            addCriterion("ASC >", value, "asc");
            return (Criteria) this;
        }

        public Criteria andAscGreaterThanOrEqualTo(Date value) {
            addCriterion("ASC >=", value, "asc");
            return (Criteria) this;
        }

        public Criteria andAscLessThan(Date value) {
            addCriterion("ASC <", value, "asc");
            return (Criteria) this;
        }

        public Criteria andAscLessThanOrEqualTo(Date value) {
            addCriterion("ASC <=", value, "asc");
            return (Criteria) this;
        }

        public Criteria andAscIn(List<Date> values) {
            addCriterion("ASC in", values, "asc");
            return (Criteria) this;
        }

        public Criteria andAscNotIn(List<Date> values) {
            addCriterion("ASC not in", values, "asc");
            return (Criteria) this;
        }

        public Criteria andAscBetween(Date value1, Date value2) {
            addCriterion("ASC between", value1, value2, "asc");
            return (Criteria) this;
        }

        public Criteria andAscNotBetween(Date value1, Date value2) {
            addCriterion("ASC not between", value1, value2, "asc");
            return (Criteria) this;
        }

        public Criteria andEecIsNull() {
            addCriterion("EEC is null");
            return (Criteria) this;
        }

        public Criteria andEecIsNotNull() {
            addCriterion("EEC is not null");
            return (Criteria) this;
        }

        public Criteria andEecEqualTo(Date value) {
            addCriterion("EEC =", value, "eec");
            return (Criteria) this;
        }

        public Criteria andEecNotEqualTo(Date value) {
            addCriterion("EEC <>", value, "eec");
            return (Criteria) this;
        }

        public Criteria andEecGreaterThan(Date value) {
            addCriterion("EEC >", value, "eec");
            return (Criteria) this;
        }

        public Criteria andEecGreaterThanOrEqualTo(Date value) {
            addCriterion("EEC >=", value, "eec");
            return (Criteria) this;
        }

        public Criteria andEecLessThan(Date value) {
            addCriterion("EEC <", value, "eec");
            return (Criteria) this;
        }

        public Criteria andEecLessThanOrEqualTo(Date value) {
            addCriterion("EEC <=", value, "eec");
            return (Criteria) this;
        }

        public Criteria andEecIn(List<Date> values) {
            addCriterion("EEC in", values, "eec");
            return (Criteria) this;
        }

        public Criteria andEecNotIn(List<Date> values) {
            addCriterion("EEC not in", values, "eec");
            return (Criteria) this;
        }

        public Criteria andEecBetween(Date value1, Date value2) {
            addCriterion("EEC between", value1, value2, "eec");
            return (Criteria) this;
        }

        public Criteria andEecNotBetween(Date value1, Date value2) {
            addCriterion("EEC not between", value1, value2, "eec");
            return (Criteria) this;
        }

        public Criteria andAecIsNull() {
            addCriterion("AEC is null");
            return (Criteria) this;
        }

        public Criteria andAecIsNotNull() {
            addCriterion("AEC is not null");
            return (Criteria) this;
        }

        public Criteria andAecEqualTo(Date value) {
            addCriterion("AEC =", value, "aec");
            return (Criteria) this;
        }

        public Criteria andAecNotEqualTo(Date value) {
            addCriterion("AEC <>", value, "aec");
            return (Criteria) this;
        }

        public Criteria andAecGreaterThan(Date value) {
            addCriterion("AEC >", value, "aec");
            return (Criteria) this;
        }

        public Criteria andAecGreaterThanOrEqualTo(Date value) {
            addCriterion("AEC >=", value, "aec");
            return (Criteria) this;
        }

        public Criteria andAecLessThan(Date value) {
            addCriterion("AEC <", value, "aec");
            return (Criteria) this;
        }

        public Criteria andAecLessThanOrEqualTo(Date value) {
            addCriterion("AEC <=", value, "aec");
            return (Criteria) this;
        }

        public Criteria andAecIn(List<Date> values) {
            addCriterion("AEC in", values, "aec");
            return (Criteria) this;
        }

        public Criteria andAecNotIn(List<Date> values) {
            addCriterion("AEC not in", values, "aec");
            return (Criteria) this;
        }

        public Criteria andAecBetween(Date value1, Date value2) {
            addCriterion("AEC between", value1, value2, "aec");
            return (Criteria) this;
        }

        public Criteria andAecNotBetween(Date value1, Date value2) {
            addCriterion("AEC not between", value1, value2, "aec");
            return (Criteria) this;
        }

        public Criteria andEsctIsNull() {
            addCriterion("ESCT is null");
            return (Criteria) this;
        }

        public Criteria andEsctIsNotNull() {
            addCriterion("ESCT is not null");
            return (Criteria) this;
        }

        public Criteria andEsctEqualTo(Date value) {
            addCriterion("ESCT =", value, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctNotEqualTo(Date value) {
            addCriterion("ESCT <>", value, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctGreaterThan(Date value) {
            addCriterion("ESCT >", value, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctGreaterThanOrEqualTo(Date value) {
            addCriterion("ESCT >=", value, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctLessThan(Date value) {
            addCriterion("ESCT <", value, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctLessThanOrEqualTo(Date value) {
            addCriterion("ESCT <=", value, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctIn(List<Date> values) {
            addCriterion("ESCT in", values, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctNotIn(List<Date> values) {
            addCriterion("ESCT not in", values, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctBetween(Date value1, Date value2) {
            addCriterion("ESCT between", value1, value2, "esct");
            return (Criteria) this;
        }

        public Criteria andEsctNotBetween(Date value1, Date value2) {
            addCriterion("ESCT not between", value1, value2, "esct");
            return (Criteria) this;
        }

        public Criteria andAsctIsNull() {
            addCriterion("ASCT is null");
            return (Criteria) this;
        }

        public Criteria andAsctIsNotNull() {
            addCriterion("ASCT is not null");
            return (Criteria) this;
        }

        public Criteria andAsctEqualTo(Date value) {
            addCriterion("ASCT =", value, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctNotEqualTo(Date value) {
            addCriterion("ASCT <>", value, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctGreaterThan(Date value) {
            addCriterion("ASCT >", value, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctGreaterThanOrEqualTo(Date value) {
            addCriterion("ASCT >=", value, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctLessThan(Date value) {
            addCriterion("ASCT <", value, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctLessThanOrEqualTo(Date value) {
            addCriterion("ASCT <=", value, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctIn(List<Date> values) {
            addCriterion("ASCT in", values, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctNotIn(List<Date> values) {
            addCriterion("ASCT not in", values, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctBetween(Date value1, Date value2) {
            addCriterion("ASCT between", value1, value2, "asct");
            return (Criteria) this;
        }

        public Criteria andAsctNotBetween(Date value1, Date value2) {
            addCriterion("ASCT not between", value1, value2, "asct");
            return (Criteria) this;
        }

        public Criteria andEfctIsNull() {
            addCriterion("EFCT is null");
            return (Criteria) this;
        }

        public Criteria andEfctIsNotNull() {
            addCriterion("EFCT is not null");
            return (Criteria) this;
        }

        public Criteria andEfctEqualTo(Date value) {
            addCriterion("EFCT =", value, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctNotEqualTo(Date value) {
            addCriterion("EFCT <>", value, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctGreaterThan(Date value) {
            addCriterion("EFCT >", value, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctGreaterThanOrEqualTo(Date value) {
            addCriterion("EFCT >=", value, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctLessThan(Date value) {
            addCriterion("EFCT <", value, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctLessThanOrEqualTo(Date value) {
            addCriterion("EFCT <=", value, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctIn(List<Date> values) {
            addCriterion("EFCT in", values, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctNotIn(List<Date> values) {
            addCriterion("EFCT not in", values, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctBetween(Date value1, Date value2) {
            addCriterion("EFCT between", value1, value2, "efct");
            return (Criteria) this;
        }

        public Criteria andEfctNotBetween(Date value1, Date value2) {
            addCriterion("EFCT not between", value1, value2, "efct");
            return (Criteria) this;
        }

        public Criteria andAfctIsNull() {
            addCriterion("AFCT is null");
            return (Criteria) this;
        }

        public Criteria andAfctIsNotNull() {
            addCriterion("AFCT is not null");
            return (Criteria) this;
        }

        public Criteria andAfctEqualTo(Date value) {
            addCriterion("AFCT =", value, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctNotEqualTo(Date value) {
            addCriterion("AFCT <>", value, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctGreaterThan(Date value) {
            addCriterion("AFCT >", value, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctGreaterThanOrEqualTo(Date value) {
            addCriterion("AFCT >=", value, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctLessThan(Date value) {
            addCriterion("AFCT <", value, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctLessThanOrEqualTo(Date value) {
            addCriterion("AFCT <=", value, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctIn(List<Date> values) {
            addCriterion("AFCT in", values, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctNotIn(List<Date> values) {
            addCriterion("AFCT not in", values, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctBetween(Date value1, Date value2) {
            addCriterion("AFCT between", value1, value2, "afct");
            return (Criteria) this;
        }

        public Criteria andAfctNotBetween(Date value1, Date value2) {
            addCriterion("AFCT not between", value1, value2, "afct");
            return (Criteria) this;
        }

        public Criteria andEsbtIsNull() {
            addCriterion("ESBT is null");
            return (Criteria) this;
        }

        public Criteria andEsbtIsNotNull() {
            addCriterion("ESBT is not null");
            return (Criteria) this;
        }

        public Criteria andEsbtEqualTo(Date value) {
            addCriterion("ESBT =", value, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtNotEqualTo(Date value) {
            addCriterion("ESBT <>", value, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtGreaterThan(Date value) {
            addCriterion("ESBT >", value, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtGreaterThanOrEqualTo(Date value) {
            addCriterion("ESBT >=", value, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtLessThan(Date value) {
            addCriterion("ESBT <", value, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtLessThanOrEqualTo(Date value) {
            addCriterion("ESBT <=", value, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtIn(List<Date> values) {
            addCriterion("ESBT in", values, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtNotIn(List<Date> values) {
            addCriterion("ESBT not in", values, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtBetween(Date value1, Date value2) {
            addCriterion("ESBT between", value1, value2, "esbt");
            return (Criteria) this;
        }

        public Criteria andEsbtNotBetween(Date value1, Date value2) {
            addCriterion("ESBT not between", value1, value2, "esbt");
            return (Criteria) this;
        }

        public Criteria andAsbtIsNull() {
            addCriterion("ASBT is null");
            return (Criteria) this;
        }

        public Criteria andAsbtIsNotNull() {
            addCriterion("ASBT is not null");
            return (Criteria) this;
        }

        public Criteria andAsbtEqualTo(Date value) {
            addCriterion("ASBT =", value, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtNotEqualTo(Date value) {
            addCriterion("ASBT <>", value, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtGreaterThan(Date value) {
            addCriterion("ASBT >", value, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtGreaterThanOrEqualTo(Date value) {
            addCriterion("ASBT >=", value, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtLessThan(Date value) {
            addCriterion("ASBT <", value, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtLessThanOrEqualTo(Date value) {
            addCriterion("ASBT <=", value, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtIn(List<Date> values) {
            addCriterion("ASBT in", values, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtNotIn(List<Date> values) {
            addCriterion("ASBT not in", values, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtBetween(Date value1, Date value2) {
            addCriterion("ASBT between", value1, value2, "asbt");
            return (Criteria) this;
        }

        public Criteria andAsbtNotBetween(Date value1, Date value2) {
            addCriterion("ASBT not between", value1, value2, "asbt");
            return (Criteria) this;
        }

        public Criteria andLcbtIsNull() {
            addCriterion("LCBT is null");
            return (Criteria) this;
        }

        public Criteria andLcbtIsNotNull() {
            addCriterion("LCBT is not null");
            return (Criteria) this;
        }

        public Criteria andLcbtEqualTo(Date value) {
            addCriterion("LCBT =", value, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtNotEqualTo(Date value) {
            addCriterion("LCBT <>", value, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtGreaterThan(Date value) {
            addCriterion("LCBT >", value, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtGreaterThanOrEqualTo(Date value) {
            addCriterion("LCBT >=", value, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtLessThan(Date value) {
            addCriterion("LCBT <", value, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtLessThanOrEqualTo(Date value) {
            addCriterion("LCBT <=", value, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtIn(List<Date> values) {
            addCriterion("LCBT in", values, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtNotIn(List<Date> values) {
            addCriterion("LCBT not in", values, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtBetween(Date value1, Date value2) {
            addCriterion("LCBT between", value1, value2, "lcbt");
            return (Criteria) this;
        }

        public Criteria andLcbtNotBetween(Date value1, Date value2) {
            addCriterion("LCBT not between", value1, value2, "lcbt");
            return (Criteria) this;
        }

        public Criteria andEebtIsNull() {
            addCriterion("EEBT is null");
            return (Criteria) this;
        }

        public Criteria andEebtIsNotNull() {
            addCriterion("EEBT is not null");
            return (Criteria) this;
        }

        public Criteria andEebtEqualTo(Date value) {
            addCriterion("EEBT =", value, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtNotEqualTo(Date value) {
            addCriterion("EEBT <>", value, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtGreaterThan(Date value) {
            addCriterion("EEBT >", value, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtGreaterThanOrEqualTo(Date value) {
            addCriterion("EEBT >=", value, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtLessThan(Date value) {
            addCriterion("EEBT <", value, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtLessThanOrEqualTo(Date value) {
            addCriterion("EEBT <=", value, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtIn(List<Date> values) {
            addCriterion("EEBT in", values, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtNotIn(List<Date> values) {
            addCriterion("EEBT not in", values, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtBetween(Date value1, Date value2) {
            addCriterion("EEBT between", value1, value2, "eebt");
            return (Criteria) this;
        }

        public Criteria andEebtNotBetween(Date value1, Date value2) {
            addCriterion("EEBT not between", value1, value2, "eebt");
            return (Criteria) this;
        }

        public Criteria andAebtIsNull() {
            addCriterion("AEBT is null");
            return (Criteria) this;
        }

        public Criteria andAebtIsNotNull() {
            addCriterion("AEBT is not null");
            return (Criteria) this;
        }

        public Criteria andAebtEqualTo(Date value) {
            addCriterion("AEBT =", value, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtNotEqualTo(Date value) {
            addCriterion("AEBT <>", value, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtGreaterThan(Date value) {
            addCriterion("AEBT >", value, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtGreaterThanOrEqualTo(Date value) {
            addCriterion("AEBT >=", value, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtLessThan(Date value) {
            addCriterion("AEBT <", value, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtLessThanOrEqualTo(Date value) {
            addCriterion("AEBT <=", value, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtIn(List<Date> values) {
            addCriterion("AEBT in", values, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtNotIn(List<Date> values) {
            addCriterion("AEBT not in", values, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtBetween(Date value1, Date value2) {
            addCriterion("AEBT between", value1, value2, "aebt");
            return (Criteria) this;
        }

        public Criteria andAebtNotBetween(Date value1, Date value2) {
            addCriterion("AEBT not between", value1, value2, "aebt");
            return (Criteria) this;
        }

        public Criteria andEcdtIsNull() {
            addCriterion("ECDT is null");
            return (Criteria) this;
        }

        public Criteria andEcdtIsNotNull() {
            addCriterion("ECDT is not null");
            return (Criteria) this;
        }

        public Criteria andEcdtEqualTo(Date value) {
            addCriterion("ECDT =", value, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtNotEqualTo(Date value) {
            addCriterion("ECDT <>", value, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtGreaterThan(Date value) {
            addCriterion("ECDT >", value, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtGreaterThanOrEqualTo(Date value) {
            addCriterion("ECDT >=", value, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtLessThan(Date value) {
            addCriterion("ECDT <", value, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtLessThanOrEqualTo(Date value) {
            addCriterion("ECDT <=", value, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtIn(List<Date> values) {
            addCriterion("ECDT in", values, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtNotIn(List<Date> values) {
            addCriterion("ECDT not in", values, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtBetween(Date value1, Date value2) {
            addCriterion("ECDT between", value1, value2, "ecdt");
            return (Criteria) this;
        }

        public Criteria andEcdtNotBetween(Date value1, Date value2) {
            addCriterion("ECDT not between", value1, value2, "ecdt");
            return (Criteria) this;
        }

        public Criteria andAcdtIsNull() {
            addCriterion("ACDT is null");
            return (Criteria) this;
        }

        public Criteria andAcdtIsNotNull() {
            addCriterion("ACDT is not null");
            return (Criteria) this;
        }

        public Criteria andAcdtEqualTo(Date value) {
            addCriterion("ACDT =", value, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtNotEqualTo(Date value) {
            addCriterion("ACDT <>", value, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtGreaterThan(Date value) {
            addCriterion("ACDT >", value, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtGreaterThanOrEqualTo(Date value) {
            addCriterion("ACDT >=", value, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtLessThan(Date value) {
            addCriterion("ACDT <", value, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtLessThanOrEqualTo(Date value) {
            addCriterion("ACDT <=", value, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtIn(List<Date> values) {
            addCriterion("ACDT in", values, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtNotIn(List<Date> values) {
            addCriterion("ACDT not in", values, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtBetween(Date value1, Date value2) {
            addCriterion("ACDT between", value1, value2, "acdt");
            return (Criteria) this;
        }

        public Criteria andAcdtNotBetween(Date value1, Date value2) {
            addCriterion("ACDT not between", value1, value2, "acdt");
            return (Criteria) this;
        }

        public Criteria andEedtIsNull() {
            addCriterion("EEDT is null");
            return (Criteria) this;
        }

        public Criteria andEedtIsNotNull() {
            addCriterion("EEDT is not null");
            return (Criteria) this;
        }

        public Criteria andEedtEqualTo(Date value) {
            addCriterion("EEDT =", value, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtNotEqualTo(Date value) {
            addCriterion("EEDT <>", value, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtGreaterThan(Date value) {
            addCriterion("EEDT >", value, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtGreaterThanOrEqualTo(Date value) {
            addCriterion("EEDT >=", value, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtLessThan(Date value) {
            addCriterion("EEDT <", value, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtLessThanOrEqualTo(Date value) {
            addCriterion("EEDT <=", value, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtIn(List<Date> values) {
            addCriterion("EEDT in", values, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtNotIn(List<Date> values) {
            addCriterion("EEDT not in", values, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtBetween(Date value1, Date value2) {
            addCriterion("EEDT between", value1, value2, "eedt");
            return (Criteria) this;
        }

        public Criteria andEedtNotBetween(Date value1, Date value2) {
            addCriterion("EEDT not between", value1, value2, "eedt");
            return (Criteria) this;
        }

        public Criteria andAedtIsNull() {
            addCriterion("AEDT is null");
            return (Criteria) this;
        }

        public Criteria andAedtIsNotNull() {
            addCriterion("AEDT is not null");
            return (Criteria) this;
        }

        public Criteria andAedtEqualTo(Date value) {
            addCriterion("AEDT =", value, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtNotEqualTo(Date value) {
            addCriterion("AEDT <>", value, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtGreaterThan(Date value) {
            addCriterion("AEDT >", value, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtGreaterThanOrEqualTo(Date value) {
            addCriterion("AEDT >=", value, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtLessThan(Date value) {
            addCriterion("AEDT <", value, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtLessThanOrEqualTo(Date value) {
            addCriterion("AEDT <=", value, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtIn(List<Date> values) {
            addCriterion("AEDT in", values, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtNotIn(List<Date> values) {
            addCriterion("AEDT not in", values, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtBetween(Date value1, Date value2) {
            addCriterion("AEDT between", value1, value2, "aedt");
            return (Criteria) this;
        }

        public Criteria andAedtNotBetween(Date value1, Date value2) {
            addCriterion("AEDT not between", value1, value2, "aedt");
            return (Criteria) this;
        }

        public Criteria andAactIsNull() {
            addCriterion("AACT is null");
            return (Criteria) this;
        }

        public Criteria andAactIsNotNull() {
            addCriterion("AACT is not null");
            return (Criteria) this;
        }

        public Criteria andAactEqualTo(Date value) {
            addCriterion("AACT =", value, "aact");
            return (Criteria) this;
        }

        public Criteria andAactNotEqualTo(Date value) {
            addCriterion("AACT <>", value, "aact");
            return (Criteria) this;
        }

        public Criteria andAactGreaterThan(Date value) {
            addCriterion("AACT >", value, "aact");
            return (Criteria) this;
        }

        public Criteria andAactGreaterThanOrEqualTo(Date value) {
            addCriterion("AACT >=", value, "aact");
            return (Criteria) this;
        }

        public Criteria andAactLessThan(Date value) {
            addCriterion("AACT <", value, "aact");
            return (Criteria) this;
        }

        public Criteria andAactLessThanOrEqualTo(Date value) {
            addCriterion("AACT <=", value, "aact");
            return (Criteria) this;
        }

        public Criteria andAactIn(List<Date> values) {
            addCriterion("AACT in", values, "aact");
            return (Criteria) this;
        }

        public Criteria andAactNotIn(List<Date> values) {
            addCriterion("AACT not in", values, "aact");
            return (Criteria) this;
        }

        public Criteria andAactBetween(Date value1, Date value2) {
            addCriterion("AACT between", value1, value2, "aact");
            return (Criteria) this;
        }

        public Criteria andAactNotBetween(Date value1, Date value2) {
            addCriterion("AACT not between", value1, value2, "aact");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmIsNull() {
            addCriterion("A_GRND_TSF_TM is null");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmIsNotNull() {
            addCriterion("A_GRND_TSF_TM is not null");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmEqualTo(Date value) {
            addCriterion("A_GRND_TSF_TM =", value, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmNotEqualTo(Date value) {
            addCriterion("A_GRND_TSF_TM <>", value, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmGreaterThan(Date value) {
            addCriterion("A_GRND_TSF_TM >", value, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmGreaterThanOrEqualTo(Date value) {
            addCriterion("A_GRND_TSF_TM >=", value, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmLessThan(Date value) {
            addCriterion("A_GRND_TSF_TM <", value, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmLessThanOrEqualTo(Date value) {
            addCriterion("A_GRND_TSF_TM <=", value, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmIn(List<Date> values) {
            addCriterion("A_GRND_TSF_TM in", values, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmNotIn(List<Date> values) {
            addCriterion("A_GRND_TSF_TM not in", values, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmBetween(Date value1, Date value2) {
            addCriterion("A_GRND_TSF_TM between", value1, value2, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andAGrndTsfTmNotBetween(Date value1, Date value2) {
            addCriterion("A_GRND_TSF_TM not between", value1, value2, "aGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmIsNull() {
            addCriterion("D_GRND_TSF_TM is null");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmIsNotNull() {
            addCriterion("D_GRND_TSF_TM is not null");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmEqualTo(Date value) {
            addCriterion("D_GRND_TSF_TM =", value, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmNotEqualTo(Date value) {
            addCriterion("D_GRND_TSF_TM <>", value, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmGreaterThan(Date value) {
            addCriterion("D_GRND_TSF_TM >", value, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmGreaterThanOrEqualTo(Date value) {
            addCriterion("D_GRND_TSF_TM >=", value, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmLessThan(Date value) {
            addCriterion("D_GRND_TSF_TM <", value, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmLessThanOrEqualTo(Date value) {
            addCriterion("D_GRND_TSF_TM <=", value, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmIn(List<Date> values) {
            addCriterion("D_GRND_TSF_TM in", values, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmNotIn(List<Date> values) {
            addCriterion("D_GRND_TSF_TM not in", values, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmBetween(Date value1, Date value2) {
            addCriterion("D_GRND_TSF_TM between", value1, value2, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andDGrndTsfTmNotBetween(Date value1, Date value2) {
            addCriterion("D_GRND_TSF_TM not between", value1, value2, "dGrndTsfTm");
            return (Criteria) this;
        }

        public Criteria andMpbtIsNull() {
            addCriterion("MPBT is null");
            return (Criteria) this;
        }

        public Criteria andMpbtIsNotNull() {
            addCriterion("MPBT is not null");
            return (Criteria) this;
        }

        public Criteria andMpbtEqualTo(Date value) {
            addCriterion("MPBT =", value, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtNotEqualTo(Date value) {
            addCriterion("MPBT <>", value, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtGreaterThan(Date value) {
            addCriterion("MPBT >", value, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtGreaterThanOrEqualTo(Date value) {
            addCriterion("MPBT >=", value, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtLessThan(Date value) {
            addCriterion("MPBT <", value, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtLessThanOrEqualTo(Date value) {
            addCriterion("MPBT <=", value, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtIn(List<Date> values) {
            addCriterion("MPBT in", values, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtNotIn(List<Date> values) {
            addCriterion("MPBT not in", values, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtBetween(Date value1, Date value2) {
            addCriterion("MPBT between", value1, value2, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpbtNotBetween(Date value1, Date value2) {
            addCriterion("MPBT not between", value1, value2, "mpbt");
            return (Criteria) this;
        }

        public Criteria andMpetIsNull() {
            addCriterion("MPET is null");
            return (Criteria) this;
        }

        public Criteria andMpetIsNotNull() {
            addCriterion("MPET is not null");
            return (Criteria) this;
        }

        public Criteria andMpetEqualTo(Date value) {
            addCriterion("MPET =", value, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetNotEqualTo(Date value) {
            addCriterion("MPET <>", value, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetGreaterThan(Date value) {
            addCriterion("MPET >", value, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetGreaterThanOrEqualTo(Date value) {
            addCriterion("MPET >=", value, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetLessThan(Date value) {
            addCriterion("MPET <", value, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetLessThanOrEqualTo(Date value) {
            addCriterion("MPET <=", value, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetIn(List<Date> values) {
            addCriterion("MPET in", values, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetNotIn(List<Date> values) {
            addCriterion("MPET not in", values, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetBetween(Date value1, Date value2) {
            addCriterion("MPET between", value1, value2, "mpet");
            return (Criteria) this;
        }

        public Criteria andMpetNotBetween(Date value1, Date value2) {
            addCriterion("MPET not between", value1, value2, "mpet");
            return (Criteria) this;
        }

        public Criteria andLdbtIsNull() {
            addCriterion("LDBT is null");
            return (Criteria) this;
        }

        public Criteria andLdbtIsNotNull() {
            addCriterion("LDBT is not null");
            return (Criteria) this;
        }

        public Criteria andLdbtEqualTo(Date value) {
            addCriterion("LDBT =", value, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtNotEqualTo(Date value) {
            addCriterion("LDBT <>", value, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtGreaterThan(Date value) {
            addCriterion("LDBT >", value, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtGreaterThanOrEqualTo(Date value) {
            addCriterion("LDBT >=", value, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtLessThan(Date value) {
            addCriterion("LDBT <", value, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtLessThanOrEqualTo(Date value) {
            addCriterion("LDBT <=", value, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtIn(List<Date> values) {
            addCriterion("LDBT in", values, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtNotIn(List<Date> values) {
            addCriterion("LDBT not in", values, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtBetween(Date value1, Date value2) {
            addCriterion("LDBT between", value1, value2, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdbtNotBetween(Date value1, Date value2) {
            addCriterion("LDBT not between", value1, value2, "ldbt");
            return (Criteria) this;
        }

        public Criteria andLdetIsNull() {
            addCriterion("LDET is null");
            return (Criteria) this;
        }

        public Criteria andLdetIsNotNull() {
            addCriterion("LDET is not null");
            return (Criteria) this;
        }

        public Criteria andLdetEqualTo(Date value) {
            addCriterion("LDET =", value, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetNotEqualTo(Date value) {
            addCriterion("LDET <>", value, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetGreaterThan(Date value) {
            addCriterion("LDET >", value, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetGreaterThanOrEqualTo(Date value) {
            addCriterion("LDET >=", value, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetLessThan(Date value) {
            addCriterion("LDET <", value, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetLessThanOrEqualTo(Date value) {
            addCriterion("LDET <=", value, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetIn(List<Date> values) {
            addCriterion("LDET in", values, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetNotIn(List<Date> values) {
            addCriterion("LDET not in", values, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetBetween(Date value1, Date value2) {
            addCriterion("LDET between", value1, value2, "ldet");
            return (Criteria) this;
        }

        public Criteria andLdetNotBetween(Date value1, Date value2) {
            addCriterion("LDET not between", value1, value2, "ldet");
            return (Criteria) this;
        }

        public Criteria andTrdtIsNull() {
            addCriterion("TRDT is null");
            return (Criteria) this;
        }

        public Criteria andTrdtIsNotNull() {
            addCriterion("TRDT is not null");
            return (Criteria) this;
        }

        public Criteria andTrdtEqualTo(Date value) {
            addCriterion("TRDT =", value, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtNotEqualTo(Date value) {
            addCriterion("TRDT <>", value, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtGreaterThan(Date value) {
            addCriterion("TRDT >", value, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtGreaterThanOrEqualTo(Date value) {
            addCriterion("TRDT >=", value, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtLessThan(Date value) {
            addCriterion("TRDT <", value, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtLessThanOrEqualTo(Date value) {
            addCriterion("TRDT <=", value, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtIn(List<Date> values) {
            addCriterion("TRDT in", values, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtNotIn(List<Date> values) {
            addCriterion("TRDT not in", values, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtBetween(Date value1, Date value2) {
            addCriterion("TRDT between", value1, value2, "trdt");
            return (Criteria) this;
        }

        public Criteria andTrdtNotBetween(Date value1, Date value2) {
            addCriterion("TRDT not between", value1, value2, "trdt");
            return (Criteria) this;
        }

        public Criteria andCdptIsNull() {
            addCriterion("CDPT is null");
            return (Criteria) this;
        }

        public Criteria andCdptIsNotNull() {
            addCriterion("CDPT is not null");
            return (Criteria) this;
        }

        public Criteria andCdptEqualTo(Date value) {
            addCriterion("CDPT =", value, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptNotEqualTo(Date value) {
            addCriterion("CDPT <>", value, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptGreaterThan(Date value) {
            addCriterion("CDPT >", value, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptGreaterThanOrEqualTo(Date value) {
            addCriterion("CDPT >=", value, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptLessThan(Date value) {
            addCriterion("CDPT <", value, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptLessThanOrEqualTo(Date value) {
            addCriterion("CDPT <=", value, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptIn(List<Date> values) {
            addCriterion("CDPT in", values, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptNotIn(List<Date> values) {
            addCriterion("CDPT not in", values, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptBetween(Date value1, Date value2) {
            addCriterion("CDPT between", value1, value2, "cdpt");
            return (Criteria) this;
        }

        public Criteria andCdptNotBetween(Date value1, Date value2) {
            addCriterion("CDPT not between", value1, value2, "cdpt");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNull() {
            addCriterion("TERMINAL is null");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNotNull() {
            addCriterion("TERMINAL is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalEqualTo(String value) {
            addCriterion("TERMINAL =", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotEqualTo(String value) {
            addCriterion("TERMINAL <>", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThan(String value) {
            addCriterion("TERMINAL >", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("TERMINAL >=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThan(String value) {
            addCriterion("TERMINAL <", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThanOrEqualTo(String value) {
            addCriterion("TERMINAL <=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLike(String value) {
            addCriterion("TERMINAL like", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotLike(String value) {
            addCriterion("TERMINAL not like", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalIn(List<String> values) {
            addCriterion("TERMINAL in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotIn(List<String> values) {
            addCriterion("TERMINAL not in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalBetween(String value1, String value2) {
            addCriterion("TERMINAL between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotBetween(String value1, String value2) {
            addCriterion("TERMINAL not between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andBagCountIsNull() {
            addCriterion("BAG_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andBagCountIsNotNull() {
            addCriterion("BAG_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBagCountEqualTo(Integer value) {
            addCriterion("BAG_COUNT =", value, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountNotEqualTo(Integer value) {
            addCriterion("BAG_COUNT <>", value, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountGreaterThan(Integer value) {
            addCriterion("BAG_COUNT >", value, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("BAG_COUNT >=", value, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountLessThan(Integer value) {
            addCriterion("BAG_COUNT <", value, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountLessThanOrEqualTo(Integer value) {
            addCriterion("BAG_COUNT <=", value, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountIn(List<Integer> values) {
            addCriterion("BAG_COUNT in", values, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountNotIn(List<Integer> values) {
            addCriterion("BAG_COUNT not in", values, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountBetween(Integer value1, Integer value2) {
            addCriterion("BAG_COUNT between", value1, value2, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagCountNotBetween(Integer value1, Integer value2) {
            addCriterion("BAG_COUNT not between", value1, value2, "bagCount");
            return (Criteria) this;
        }

        public Criteria andBagWeightIsNull() {
            addCriterion("BAG_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andBagWeightIsNotNull() {
            addCriterion("BAG_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andBagWeightEqualTo(Integer value) {
            addCriterion("BAG_WEIGHT =", value, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightNotEqualTo(Integer value) {
            addCriterion("BAG_WEIGHT <>", value, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightGreaterThan(Integer value) {
            addCriterion("BAG_WEIGHT >", value, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("BAG_WEIGHT >=", value, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightLessThan(Integer value) {
            addCriterion("BAG_WEIGHT <", value, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightLessThanOrEqualTo(Integer value) {
            addCriterion("BAG_WEIGHT <=", value, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightIn(List<Integer> values) {
            addCriterion("BAG_WEIGHT in", values, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightNotIn(List<Integer> values) {
            addCriterion("BAG_WEIGHT not in", values, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightBetween(Integer value1, Integer value2) {
            addCriterion("BAG_WEIGHT between", value1, value2, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andBagWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("BAG_WEIGHT not between", value1, value2, "bagWeight");
            return (Criteria) this;
        }

        public Criteria andPaxCountIsNull() {
            addCriterion("PAX_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPaxCountIsNotNull() {
            addCriterion("PAX_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPaxCountEqualTo(Integer value) {
            addCriterion("PAX_COUNT =", value, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountNotEqualTo(Integer value) {
            addCriterion("PAX_COUNT <>", value, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountGreaterThan(Integer value) {
            addCriterion("PAX_COUNT >", value, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAX_COUNT >=", value, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountLessThan(Integer value) {
            addCriterion("PAX_COUNT <", value, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountLessThanOrEqualTo(Integer value) {
            addCriterion("PAX_COUNT <=", value, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountIn(List<Integer> values) {
            addCriterion("PAX_COUNT in", values, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountNotIn(List<Integer> values) {
            addCriterion("PAX_COUNT not in", values, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountBetween(Integer value1, Integer value2) {
            addCriterion("PAX_COUNT between", value1, value2, "paxCount");
            return (Criteria) this;
        }

        public Criteria andPaxCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PAX_COUNT not between", value1, value2, "paxCount");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNull() {
            addCriterion("ISDEL is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("ISDEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(String value) {
            addCriterion("ISDEL =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(String value) {
            addCriterion("ISDEL <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(String value) {
            addCriterion("ISDEL >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(String value) {
            addCriterion("ISDEL >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(String value) {
            addCriterion("ISDEL <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(String value) {
            addCriterion("ISDEL <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLike(String value) {
            addCriterion("ISDEL like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotLike(String value) {
            addCriterion("ISDEL not like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<String> values) {
            addCriterion("ISDEL in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<String> values) {
            addCriterion("ISDEL not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(String value1, String value2) {
            addCriterion("ISDEL between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(String value1, String value2) {
            addCriterion("ISDEL not between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsspecialIsNull() {
            addCriterion("ISSPECIAL is null");
            return (Criteria) this;
        }

        public Criteria andIsspecialIsNotNull() {
            addCriterion("ISSPECIAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsspecialEqualTo(Integer value) {
            addCriterion("ISSPECIAL =", value, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialNotEqualTo(Integer value) {
            addCriterion("ISSPECIAL <>", value, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialGreaterThan(Integer value) {
            addCriterion("ISSPECIAL >", value, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISSPECIAL >=", value, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialLessThan(Integer value) {
            addCriterion("ISSPECIAL <", value, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialLessThanOrEqualTo(Integer value) {
            addCriterion("ISSPECIAL <=", value, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialIn(List<Integer> values) {
            addCriterion("ISSPECIAL in", values, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialNotIn(List<Integer> values) {
            addCriterion("ISSPECIAL not in", values, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialBetween(Integer value1, Integer value2) {
            addCriterion("ISSPECIAL between", value1, value2, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsspecialNotBetween(Integer value1, Integer value2) {
            addCriterion("ISSPECIAL not between", value1, value2, "isspecial");
            return (Criteria) this;
        }

        public Criteria andIsmanualidIsNull() {
            addCriterion("ISMANUALID is null");
            return (Criteria) this;
        }

        public Criteria andIsmanualidIsNotNull() {
            addCriterion("ISMANUALID is not null");
            return (Criteria) this;
        }

        public Criteria andIsmanualidEqualTo(Integer value) {
            addCriterion("ISMANUALID =", value, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidNotEqualTo(Integer value) {
            addCriterion("ISMANUALID <>", value, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidGreaterThan(Integer value) {
            addCriterion("ISMANUALID >", value, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISMANUALID >=", value, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidLessThan(Integer value) {
            addCriterion("ISMANUALID <", value, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidLessThanOrEqualTo(Integer value) {
            addCriterion("ISMANUALID <=", value, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidIn(List<Integer> values) {
            addCriterion("ISMANUALID in", values, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidNotIn(List<Integer> values) {
            addCriterion("ISMANUALID not in", values, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidBetween(Integer value1, Integer value2) {
            addCriterion("ISMANUALID between", value1, value2, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIsmanualidNotBetween(Integer value1, Integer value2) {
            addCriterion("ISMANUALID not between", value1, value2, "ismanualid");
            return (Criteria) this;
        }

        public Criteria andIscontrolIsNull() {
            addCriterion("ISCONTROL is null");
            return (Criteria) this;
        }

        public Criteria andIscontrolIsNotNull() {
            addCriterion("ISCONTROL is not null");
            return (Criteria) this;
        }

        public Criteria andIscontrolEqualTo(Integer value) {
            addCriterion("ISCONTROL =", value, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolNotEqualTo(Integer value) {
            addCriterion("ISCONTROL <>", value, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolGreaterThan(Integer value) {
            addCriterion("ISCONTROL >", value, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISCONTROL >=", value, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolLessThan(Integer value) {
            addCriterion("ISCONTROL <", value, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolLessThanOrEqualTo(Integer value) {
            addCriterion("ISCONTROL <=", value, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolIn(List<Integer> values) {
            addCriterion("ISCONTROL in", values, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolNotIn(List<Integer> values) {
            addCriterion("ISCONTROL not in", values, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolBetween(Integer value1, Integer value2) {
            addCriterion("ISCONTROL between", value1, value2, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIscontrolNotBetween(Integer value1, Integer value2) {
            addCriterion("ISCONTROL not between", value1, value2, "iscontrol");
            return (Criteria) this;
        }

        public Criteria andIsfocusIsNull() {
            addCriterion("ISFOCUS is null");
            return (Criteria) this;
        }

        public Criteria andIsfocusIsNotNull() {
            addCriterion("ISFOCUS is not null");
            return (Criteria) this;
        }

        public Criteria andIsfocusEqualTo(Integer value) {
            addCriterion("ISFOCUS =", value, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusNotEqualTo(Integer value) {
            addCriterion("ISFOCUS <>", value, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusGreaterThan(Integer value) {
            addCriterion("ISFOCUS >", value, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISFOCUS >=", value, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusLessThan(Integer value) {
            addCriterion("ISFOCUS <", value, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusLessThanOrEqualTo(Integer value) {
            addCriterion("ISFOCUS <=", value, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusIn(List<Integer> values) {
            addCriterion("ISFOCUS in", values, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusNotIn(List<Integer> values) {
            addCriterion("ISFOCUS not in", values, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusBetween(Integer value1, Integer value2) {
            addCriterion("ISFOCUS between", value1, value2, "isfocus");
            return (Criteria) this;
        }

        public Criteria andIsfocusNotBetween(Integer value1, Integer value2) {
            addCriterion("ISFOCUS not between", value1, value2, "isfocus");
            return (Criteria) this;
        }

        public Criteria andRmkIsNull() {
            addCriterion("RMK is null");
            return (Criteria) this;
        }

        public Criteria andRmkIsNotNull() {
            addCriterion("RMK is not null");
            return (Criteria) this;
        }

        public Criteria andRmkEqualTo(String value) {
            addCriterion("RMK =", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotEqualTo(String value) {
            addCriterion("RMK <>", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkGreaterThan(String value) {
            addCriterion("RMK >", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkGreaterThanOrEqualTo(String value) {
            addCriterion("RMK >=", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkLessThan(String value) {
            addCriterion("RMK <", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkLessThanOrEqualTo(String value) {
            addCriterion("RMK <=", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkLike(String value) {
            addCriterion("RMK like", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotLike(String value) {
            addCriterion("RMK not like", value, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkIn(List<String> values) {
            addCriterion("RMK in", values, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotIn(List<String> values) {
            addCriterion("RMK not in", values, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkBetween(String value1, String value2) {
            addCriterion("RMK between", value1, value2, "rmk");
            return (Criteria) this;
        }

        public Criteria andRmkNotBetween(String value1, String value2) {
            addCriterion("RMK not between", value1, value2, "rmk");
            return (Criteria) this;
        }

        public Criteria andCreateTmIsNull() {
            addCriterion("CREATE_TM is null");
            return (Criteria) this;
        }

        public Criteria andCreateTmIsNotNull() {
            addCriterion("CREATE_TM is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTmEqualTo(Date value) {
            addCriterion("CREATE_TM =", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotEqualTo(Date value) {
            addCriterion("CREATE_TM <>", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmGreaterThan(Date value) {
            addCriterion("CREATE_TM >", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TM >=", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmLessThan(Date value) {
            addCriterion("CREATE_TM <", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TM <=", value, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmIn(List<Date> values) {
            addCriterion("CREATE_TM in", values, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotIn(List<Date> values) {
            addCriterion("CREATE_TM not in", values, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmBetween(Date value1, Date value2) {
            addCriterion("CREATE_TM between", value1, value2, "createTm");
            return (Criteria) this;
        }

        public Criteria andCreateTmNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TM not between", value1, value2, "createTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIsNull() {
            addCriterion("UPDATE_TM is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIsNotNull() {
            addCriterion("UPDATE_TM is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTmEqualTo(Date value) {
            addCriterion("UPDATE_TM =", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotEqualTo(Date value) {
            addCriterion("UPDATE_TM <>", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmGreaterThan(Date value) {
            addCriterion("UPDATE_TM >", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TM >=", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmLessThan(Date value) {
            addCriterion("UPDATE_TM <", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TM <=", value, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmIn(List<Date> values) {
            addCriterion("UPDATE_TM in", values, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotIn(List<Date> values) {
            addCriterion("UPDATE_TM not in", values, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TM between", value1, value2, "updateTm");
            return (Criteria) this;
        }

        public Criteria andUpdateTmNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TM not between", value1, value2, "updateTm");
            return (Criteria) this;
        }

        public Criteria andCreateUsrIsNull() {
            addCriterion("CREATE_USR is null");
            return (Criteria) this;
        }

        public Criteria andCreateUsrIsNotNull() {
            addCriterion("CREATE_USR is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUsrEqualTo(String value) {
            addCriterion("CREATE_USR =", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotEqualTo(String value) {
            addCriterion("CREATE_USR <>", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrGreaterThan(String value) {
            addCriterion("CREATE_USR >", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USR >=", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrLessThan(String value) {
            addCriterion("CREATE_USR <", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USR <=", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrLike(String value) {
            addCriterion("CREATE_USR like", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotLike(String value) {
            addCriterion("CREATE_USR not like", value, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrIn(List<String> values) {
            addCriterion("CREATE_USR in", values, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotIn(List<String> values) {
            addCriterion("CREATE_USR not in", values, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrBetween(String value1, String value2) {
            addCriterion("CREATE_USR between", value1, value2, "createUsr");
            return (Criteria) this;
        }

        public Criteria andCreateUsrNotBetween(String value1, String value2) {
            addCriterion("CREATE_USR not between", value1, value2, "createUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrIsNull() {
            addCriterion("UPDATE_USR is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrIsNotNull() {
            addCriterion("UPDATE_USR is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrEqualTo(String value) {
            addCriterion("UPDATE_USR =", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotEqualTo(String value) {
            addCriterion("UPDATE_USR <>", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrGreaterThan(String value) {
            addCriterion("UPDATE_USR >", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USR >=", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrLessThan(String value) {
            addCriterion("UPDATE_USR <", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USR <=", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrLike(String value) {
            addCriterion("UPDATE_USR like", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotLike(String value) {
            addCriterion("UPDATE_USR not like", value, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrIn(List<String> values) {
            addCriterion("UPDATE_USR in", values, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotIn(List<String> values) {
            addCriterion("UPDATE_USR not in", values, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrBetween(String value1, String value2) {
            addCriterion("UPDATE_USR between", value1, value2, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andUpdateUsrNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USR not between", value1, value2, "updateUsr");
            return (Criteria) this;
        }

        public Criteria andNode1IsNull() {
            addCriterion("NODE_1 is null");
            return (Criteria) this;
        }

        public Criteria andNode1IsNotNull() {
            addCriterion("NODE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andNode1EqualTo(Date value) {
            addCriterion("NODE_1 =", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotEqualTo(Date value) {
            addCriterion("NODE_1 <>", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1GreaterThan(Date value) {
            addCriterion("NODE_1 >", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_1 >=", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1LessThan(Date value) {
            addCriterion("NODE_1 <", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1LessThanOrEqualTo(Date value) {
            addCriterion("NODE_1 <=", value, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1In(List<Date> values) {
            addCriterion("NODE_1 in", values, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotIn(List<Date> values) {
            addCriterion("NODE_1 not in", values, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1Between(Date value1, Date value2) {
            addCriterion("NODE_1 between", value1, value2, "node1");
            return (Criteria) this;
        }

        public Criteria andNode1NotBetween(Date value1, Date value2) {
            addCriterion("NODE_1 not between", value1, value2, "node1");
            return (Criteria) this;
        }

        public Criteria andNode2IsNull() {
            addCriterion("NODE_2 is null");
            return (Criteria) this;
        }

        public Criteria andNode2IsNotNull() {
            addCriterion("NODE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andNode2EqualTo(Date value) {
            addCriterion("NODE_2 =", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotEqualTo(Date value) {
            addCriterion("NODE_2 <>", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2GreaterThan(Date value) {
            addCriterion("NODE_2 >", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_2 >=", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2LessThan(Date value) {
            addCriterion("NODE_2 <", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2LessThanOrEqualTo(Date value) {
            addCriterion("NODE_2 <=", value, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2In(List<Date> values) {
            addCriterion("NODE_2 in", values, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotIn(List<Date> values) {
            addCriterion("NODE_2 not in", values, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2Between(Date value1, Date value2) {
            addCriterion("NODE_2 between", value1, value2, "node2");
            return (Criteria) this;
        }

        public Criteria andNode2NotBetween(Date value1, Date value2) {
            addCriterion("NODE_2 not between", value1, value2, "node2");
            return (Criteria) this;
        }

        public Criteria andNode3IsNull() {
            addCriterion("NODE_3 is null");
            return (Criteria) this;
        }

        public Criteria andNode3IsNotNull() {
            addCriterion("NODE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andNode3EqualTo(Date value) {
            addCriterion("NODE_3 =", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotEqualTo(Date value) {
            addCriterion("NODE_3 <>", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3GreaterThan(Date value) {
            addCriterion("NODE_3 >", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_3 >=", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3LessThan(Date value) {
            addCriterion("NODE_3 <", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3LessThanOrEqualTo(Date value) {
            addCriterion("NODE_3 <=", value, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3In(List<Date> values) {
            addCriterion("NODE_3 in", values, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotIn(List<Date> values) {
            addCriterion("NODE_3 not in", values, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3Between(Date value1, Date value2) {
            addCriterion("NODE_3 between", value1, value2, "node3");
            return (Criteria) this;
        }

        public Criteria andNode3NotBetween(Date value1, Date value2) {
            addCriterion("NODE_3 not between", value1, value2, "node3");
            return (Criteria) this;
        }

        public Criteria andNode4IsNull() {
            addCriterion("NODE_4 is null");
            return (Criteria) this;
        }

        public Criteria andNode4IsNotNull() {
            addCriterion("NODE_4 is not null");
            return (Criteria) this;
        }

        public Criteria andNode4EqualTo(Date value) {
            addCriterion("NODE_4 =", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotEqualTo(Date value) {
            addCriterion("NODE_4 <>", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4GreaterThan(Date value) {
            addCriterion("NODE_4 >", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_4 >=", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4LessThan(Date value) {
            addCriterion("NODE_4 <", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4LessThanOrEqualTo(Date value) {
            addCriterion("NODE_4 <=", value, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4In(List<Date> values) {
            addCriterion("NODE_4 in", values, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotIn(List<Date> values) {
            addCriterion("NODE_4 not in", values, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4Between(Date value1, Date value2) {
            addCriterion("NODE_4 between", value1, value2, "node4");
            return (Criteria) this;
        }

        public Criteria andNode4NotBetween(Date value1, Date value2) {
            addCriterion("NODE_4 not between", value1, value2, "node4");
            return (Criteria) this;
        }

        public Criteria andNode5IsNull() {
            addCriterion("NODE_5 is null");
            return (Criteria) this;
        }

        public Criteria andNode5IsNotNull() {
            addCriterion("NODE_5 is not null");
            return (Criteria) this;
        }

        public Criteria andNode5EqualTo(Date value) {
            addCriterion("NODE_5 =", value, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5NotEqualTo(Date value) {
            addCriterion("NODE_5 <>", value, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5GreaterThan(Date value) {
            addCriterion("NODE_5 >", value, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_5 >=", value, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5LessThan(Date value) {
            addCriterion("NODE_5 <", value, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5LessThanOrEqualTo(Date value) {
            addCriterion("NODE_5 <=", value, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5In(List<Date> values) {
            addCriterion("NODE_5 in", values, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5NotIn(List<Date> values) {
            addCriterion("NODE_5 not in", values, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5Between(Date value1, Date value2) {
            addCriterion("NODE_5 between", value1, value2, "node5");
            return (Criteria) this;
        }

        public Criteria andNode5NotBetween(Date value1, Date value2) {
            addCriterion("NODE_5 not between", value1, value2, "node5");
            return (Criteria) this;
        }

        public Criteria andNode6IsNull() {
            addCriterion("NODE_6 is null");
            return (Criteria) this;
        }

        public Criteria andNode6IsNotNull() {
            addCriterion("NODE_6 is not null");
            return (Criteria) this;
        }

        public Criteria andNode6EqualTo(Date value) {
            addCriterion("NODE_6 =", value, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6NotEqualTo(Date value) {
            addCriterion("NODE_6 <>", value, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6GreaterThan(Date value) {
            addCriterion("NODE_6 >", value, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_6 >=", value, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6LessThan(Date value) {
            addCriterion("NODE_6 <", value, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6LessThanOrEqualTo(Date value) {
            addCriterion("NODE_6 <=", value, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6In(List<Date> values) {
            addCriterion("NODE_6 in", values, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6NotIn(List<Date> values) {
            addCriterion("NODE_6 not in", values, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6Between(Date value1, Date value2) {
            addCriterion("NODE_6 between", value1, value2, "node6");
            return (Criteria) this;
        }

        public Criteria andNode6NotBetween(Date value1, Date value2) {
            addCriterion("NODE_6 not between", value1, value2, "node6");
            return (Criteria) this;
        }

        public Criteria andNode7IsNull() {
            addCriterion("NODE_7 is null");
            return (Criteria) this;
        }

        public Criteria andNode7IsNotNull() {
            addCriterion("NODE_7 is not null");
            return (Criteria) this;
        }

        public Criteria andNode7EqualTo(Date value) {
            addCriterion("NODE_7 =", value, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7NotEqualTo(Date value) {
            addCriterion("NODE_7 <>", value, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7GreaterThan(Date value) {
            addCriterion("NODE_7 >", value, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_7 >=", value, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7LessThan(Date value) {
            addCriterion("NODE_7 <", value, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7LessThanOrEqualTo(Date value) {
            addCriterion("NODE_7 <=", value, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7In(List<Date> values) {
            addCriterion("NODE_7 in", values, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7NotIn(List<Date> values) {
            addCriterion("NODE_7 not in", values, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7Between(Date value1, Date value2) {
            addCriterion("NODE_7 between", value1, value2, "node7");
            return (Criteria) this;
        }

        public Criteria andNode7NotBetween(Date value1, Date value2) {
            addCriterion("NODE_7 not between", value1, value2, "node7");
            return (Criteria) this;
        }

        public Criteria andNode8IsNull() {
            addCriterion("NODE_8 is null");
            return (Criteria) this;
        }

        public Criteria andNode8IsNotNull() {
            addCriterion("NODE_8 is not null");
            return (Criteria) this;
        }

        public Criteria andNode8EqualTo(Date value) {
            addCriterion("NODE_8 =", value, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8NotEqualTo(Date value) {
            addCriterion("NODE_8 <>", value, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8GreaterThan(Date value) {
            addCriterion("NODE_8 >", value, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_8 >=", value, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8LessThan(Date value) {
            addCriterion("NODE_8 <", value, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8LessThanOrEqualTo(Date value) {
            addCriterion("NODE_8 <=", value, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8In(List<Date> values) {
            addCriterion("NODE_8 in", values, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8NotIn(List<Date> values) {
            addCriterion("NODE_8 not in", values, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8Between(Date value1, Date value2) {
            addCriterion("NODE_8 between", value1, value2, "node8");
            return (Criteria) this;
        }

        public Criteria andNode8NotBetween(Date value1, Date value2) {
            addCriterion("NODE_8 not between", value1, value2, "node8");
            return (Criteria) this;
        }

        public Criteria andNode9IsNull() {
            addCriterion("NODE_9 is null");
            return (Criteria) this;
        }

        public Criteria andNode9IsNotNull() {
            addCriterion("NODE_9 is not null");
            return (Criteria) this;
        }

        public Criteria andNode9EqualTo(Date value) {
            addCriterion("NODE_9 =", value, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9NotEqualTo(Date value) {
            addCriterion("NODE_9 <>", value, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9GreaterThan(Date value) {
            addCriterion("NODE_9 >", value, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9GreaterThanOrEqualTo(Date value) {
            addCriterion("NODE_9 >=", value, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9LessThan(Date value) {
            addCriterion("NODE_9 <", value, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9LessThanOrEqualTo(Date value) {
            addCriterion("NODE_9 <=", value, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9In(List<Date> values) {
            addCriterion("NODE_9 in", values, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9NotIn(List<Date> values) {
            addCriterion("NODE_9 not in", values, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9Between(Date value1, Date value2) {
            addCriterion("NODE_9 between", value1, value2, "node9");
            return (Criteria) this;
        }

        public Criteria andNode9NotBetween(Date value1, Date value2) {
            addCriterion("NODE_9 not between", value1, value2, "node9");
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