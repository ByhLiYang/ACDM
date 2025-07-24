package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TFlightSupportRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFlightSupportRecordExample() {
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

        public Criteria andCleanIsNull() {
            addCriterion("CLEAN is null");
            return (Criteria) this;
        }

        public Criteria andCleanIsNotNull() {
            addCriterion("CLEAN is not null");
            return (Criteria) this;
        }

        public Criteria andCleanEqualTo(String value) {
            addCriterion("CLEAN =", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanNotEqualTo(String value) {
            addCriterion("CLEAN <>", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanGreaterThan(String value) {
            addCriterion("CLEAN >", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanGreaterThanOrEqualTo(String value) {
            addCriterion("CLEAN >=", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanLessThan(String value) {
            addCriterion("CLEAN <", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanLessThanOrEqualTo(String value) {
            addCriterion("CLEAN <=", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanLike(String value) {
            addCriterion("CLEAN like", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanNotLike(String value) {
            addCriterion("CLEAN not like", value, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanIn(List<String> values) {
            addCriterion("CLEAN in", values, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanNotIn(List<String> values) {
            addCriterion("CLEAN not in", values, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanBetween(String value1, String value2) {
            addCriterion("CLEAN between", value1, value2, "clean");
            return (Criteria) this;
        }

        public Criteria andCleanNotBetween(String value1, String value2) {
            addCriterion("CLEAN not between", value1, value2, "clean");
            return (Criteria) this;
        }

        public Criteria andBoardingIsNull() {
            addCriterion("BOARDING is null");
            return (Criteria) this;
        }

        public Criteria andBoardingIsNotNull() {
            addCriterion("BOARDING is not null");
            return (Criteria) this;
        }

        public Criteria andBoardingEqualTo(String value) {
            addCriterion("BOARDING =", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingNotEqualTo(String value) {
            addCriterion("BOARDING <>", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingGreaterThan(String value) {
            addCriterion("BOARDING >", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingGreaterThanOrEqualTo(String value) {
            addCriterion("BOARDING >=", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingLessThan(String value) {
            addCriterion("BOARDING <", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingLessThanOrEqualTo(String value) {
            addCriterion("BOARDING <=", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingLike(String value) {
            addCriterion("BOARDING like", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingNotLike(String value) {
            addCriterion("BOARDING not like", value, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingIn(List<String> values) {
            addCriterion("BOARDING in", values, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingNotIn(List<String> values) {
            addCriterion("BOARDING not in", values, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingBetween(String value1, String value2) {
            addCriterion("BOARDING between", value1, value2, "boarding");
            return (Criteria) this;
        }

        public Criteria andBoardingNotBetween(String value1, String value2) {
            addCriterion("BOARDING not between", value1, value2, "boarding");
            return (Criteria) this;
        }

        public Criteria andCloseDoorIsNull() {
            addCriterion("CLOSE_DOOR is null");
            return (Criteria) this;
        }

        public Criteria andCloseDoorIsNotNull() {
            addCriterion("CLOSE_DOOR is not null");
            return (Criteria) this;
        }

        public Criteria andCloseDoorEqualTo(String value) {
            addCriterion("CLOSE_DOOR =", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorNotEqualTo(String value) {
            addCriterion("CLOSE_DOOR <>", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorGreaterThan(String value) {
            addCriterion("CLOSE_DOOR >", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorGreaterThanOrEqualTo(String value) {
            addCriterion("CLOSE_DOOR >=", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorLessThan(String value) {
            addCriterion("CLOSE_DOOR <", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorLessThanOrEqualTo(String value) {
            addCriterion("CLOSE_DOOR <=", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorLike(String value) {
            addCriterion("CLOSE_DOOR like", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorNotLike(String value) {
            addCriterion("CLOSE_DOOR not like", value, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorIn(List<String> values) {
            addCriterion("CLOSE_DOOR in", values, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorNotIn(List<String> values) {
            addCriterion("CLOSE_DOOR not in", values, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorBetween(String value1, String value2) {
            addCriterion("CLOSE_DOOR between", value1, value2, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andCloseDoorNotBetween(String value1, String value2) {
            addCriterion("CLOSE_DOOR not between", value1, value2, "closeDoor");
            return (Criteria) this;
        }

        public Criteria andRollOutIsNull() {
            addCriterion("ROLL_OUT is null");
            return (Criteria) this;
        }

        public Criteria andRollOutIsNotNull() {
            addCriterion("ROLL_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andRollOutEqualTo(String value) {
            addCriterion("ROLL_OUT =", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutNotEqualTo(String value) {
            addCriterion("ROLL_OUT <>", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutGreaterThan(String value) {
            addCriterion("ROLL_OUT >", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutGreaterThanOrEqualTo(String value) {
            addCriterion("ROLL_OUT >=", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutLessThan(String value) {
            addCriterion("ROLL_OUT <", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutLessThanOrEqualTo(String value) {
            addCriterion("ROLL_OUT <=", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutLike(String value) {
            addCriterion("ROLL_OUT like", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutNotLike(String value) {
            addCriterion("ROLL_OUT not like", value, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutIn(List<String> values) {
            addCriterion("ROLL_OUT in", values, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutNotIn(List<String> values) {
            addCriterion("ROLL_OUT not in", values, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutBetween(String value1, String value2) {
            addCriterion("ROLL_OUT between", value1, value2, "rollOut");
            return (Criteria) this;
        }

        public Criteria andRollOutNotBetween(String value1, String value2) {
            addCriterion("ROLL_OUT not between", value1, value2, "rollOut");
            return (Criteria) this;
        }

        public Criteria andDelayReasonIsNull() {
            addCriterion("DELAY_REASON is null");
            return (Criteria) this;
        }

        public Criteria andDelayReasonIsNotNull() {
            addCriterion("DELAY_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andDelayReasonEqualTo(String value) {
            addCriterion("DELAY_REASON =", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonNotEqualTo(String value) {
            addCriterion("DELAY_REASON <>", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonGreaterThan(String value) {
            addCriterion("DELAY_REASON >", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_REASON >=", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonLessThan(String value) {
            addCriterion("DELAY_REASON <", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonLessThanOrEqualTo(String value) {
            addCriterion("DELAY_REASON <=", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonLike(String value) {
            addCriterion("DELAY_REASON like", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonNotLike(String value) {
            addCriterion("DELAY_REASON not like", value, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonIn(List<String> values) {
            addCriterion("DELAY_REASON in", values, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonNotIn(List<String> values) {
            addCriterion("DELAY_REASON not in", values, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonBetween(String value1, String value2) {
            addCriterion("DELAY_REASON between", value1, value2, "delayReason");
            return (Criteria) this;
        }

        public Criteria andDelayReasonNotBetween(String value1, String value2) {
            addCriterion("DELAY_REASON not between", value1, value2, "delayReason");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNull() {
            addCriterion("CREATE_EMP is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIsNotNull() {
            addCriterion("CREATE_EMP is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpEqualTo(String value) {
            addCriterion("CREATE_EMP =", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotEqualTo(String value) {
            addCriterion("CREATE_EMP <>", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThan(String value) {
            addCriterion("CREATE_EMP >", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_EMP >=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThan(String value) {
            addCriterion("CREATE_EMP <", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLessThanOrEqualTo(String value) {
            addCriterion("CREATE_EMP <=", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpLike(String value) {
            addCriterion("CREATE_EMP like", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotLike(String value) {
            addCriterion("CREATE_EMP not like", value, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIn(List<String> values) {
            addCriterion("CREATE_EMP in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotIn(List<String> values) {
            addCriterion("CREATE_EMP not in", values, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpBetween(String value1, String value2) {
            addCriterion("CREATE_EMP between", value1, value2, "createEmp");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNotBetween(String value1, String value2) {
            addCriterion("CREATE_EMP not between", value1, value2, "createEmp");
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

        public Criteria andUpdateEmpIsNull() {
            addCriterion("UPDATE_EMP is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIsNotNull() {
            addCriterion("UPDATE_EMP is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpEqualTo(String value) {
            addCriterion("UPDATE_EMP =", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotEqualTo(String value) {
            addCriterion("UPDATE_EMP <>", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpGreaterThan(String value) {
            addCriterion("UPDATE_EMP >", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_EMP >=", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpLessThan(String value) {
            addCriterion("UPDATE_EMP <", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_EMP <=", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpLike(String value) {
            addCriterion("UPDATE_EMP like", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotLike(String value) {
            addCriterion("UPDATE_EMP not like", value, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIn(List<String> values) {
            addCriterion("UPDATE_EMP in", values, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotIn(List<String> values) {
            addCriterion("UPDATE_EMP not in", values, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpBetween(String value1, String value2) {
            addCriterion("UPDATE_EMP between", value1, value2, "updateEmp");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNotBetween(String value1, String value2) {
            addCriterion("UPDATE_EMP not between", value1, value2, "updateEmp");
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