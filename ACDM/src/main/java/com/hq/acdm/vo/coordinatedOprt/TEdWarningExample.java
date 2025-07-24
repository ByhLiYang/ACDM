package com.hq.acdm.vo.coordinatedOprt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TEdWarningExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEdWarningExample() {
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

        public Criteria andEdIdIsNull() {
            addCriterion("ED_ID is null");
            return (Criteria) this;
        }

        public Criteria andEdIdIsNotNull() {
            addCriterion("ED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEdIdEqualTo(String value) {
            addCriterion("ED_ID =", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdNotEqualTo(String value) {
            addCriterion("ED_ID <>", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdGreaterThan(String value) {
            addCriterion("ED_ID >", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdGreaterThanOrEqualTo(String value) {
            addCriterion("ED_ID >=", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdLessThan(String value) {
            addCriterion("ED_ID <", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdLessThanOrEqualTo(String value) {
            addCriterion("ED_ID <=", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdLike(String value) {
            addCriterion("ED_ID like", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdNotLike(String value) {
            addCriterion("ED_ID not like", value, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdIn(List<String> values) {
            addCriterion("ED_ID in", values, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdNotIn(List<String> values) {
            addCriterion("ED_ID not in", values, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdBetween(String value1, String value2) {
            addCriterion("ED_ID between", value1, value2, "edId");
            return (Criteria) this;
        }

        public Criteria andEdIdNotBetween(String value1, String value2) {
            addCriterion("ED_ID not between", value1, value2, "edId");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("LEVEL =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("LEVEL <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("LEVEL >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("LEVEL >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("LEVEL <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("LEVEL <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("LEVEL like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("LEVEL not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("LEVEL in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("LEVEL not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("LEVEL between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("LEVEL not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodIsNull() {
            addCriterion("FACTORS_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodIsNotNull() {
            addCriterion("FACTORS_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodEqualTo(String value) {
            addCriterion("FACTORS_PERIOD =", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodNotEqualTo(String value) {
            addCriterion("FACTORS_PERIOD <>", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodGreaterThan(String value) {
            addCriterion("FACTORS_PERIOD >", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("FACTORS_PERIOD >=", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodLessThan(String value) {
            addCriterion("FACTORS_PERIOD <", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodLessThanOrEqualTo(String value) {
            addCriterion("FACTORS_PERIOD <=", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodLike(String value) {
            addCriterion("FACTORS_PERIOD like", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodNotLike(String value) {
            addCriterion("FACTORS_PERIOD not like", value, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodIn(List<String> values) {
            addCriterion("FACTORS_PERIOD in", values, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodNotIn(List<String> values) {
            addCriterion("FACTORS_PERIOD not in", values, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodBetween(String value1, String value2) {
            addCriterion("FACTORS_PERIOD between", value1, value2, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andFactorsPeriodNotBetween(String value1, String value2) {
            addCriterion("FACTORS_PERIOD not between", value1, value2, "factorsPeriod");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityIsNull() {
            addCriterion("DESCEND_CAPACITY is null");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityIsNotNull() {
            addCriterion("DESCEND_CAPACITY is not null");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityEqualTo(String value) {
            addCriterion("DESCEND_CAPACITY =", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityNotEqualTo(String value) {
            addCriterion("DESCEND_CAPACITY <>", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityGreaterThan(String value) {
            addCriterion("DESCEND_CAPACITY >", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("DESCEND_CAPACITY >=", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityLessThan(String value) {
            addCriterion("DESCEND_CAPACITY <", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityLessThanOrEqualTo(String value) {
            addCriterion("DESCEND_CAPACITY <=", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityLike(String value) {
            addCriterion("DESCEND_CAPACITY like", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityNotLike(String value) {
            addCriterion("DESCEND_CAPACITY not like", value, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityIn(List<String> values) {
            addCriterion("DESCEND_CAPACITY in", values, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityNotIn(List<String> values) {
            addCriterion("DESCEND_CAPACITY not in", values, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityBetween(String value1, String value2) {
            addCriterion("DESCEND_CAPACITY between", value1, value2, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andDescendCapacityNotBetween(String value1, String value2) {
            addCriterion("DESCEND_CAPACITY not between", value1, value2, "descendCapacity");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedIsNull() {
            addCriterion("IS_COORDINATED is null");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedIsNotNull() {
            addCriterion("IS_COORDINATED is not null");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedEqualTo(String value) {
            addCriterion("IS_COORDINATED =", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedNotEqualTo(String value) {
            addCriterion("IS_COORDINATED <>", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedGreaterThan(String value) {
            addCriterion("IS_COORDINATED >", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_COORDINATED >=", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedLessThan(String value) {
            addCriterion("IS_COORDINATED <", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedLessThanOrEqualTo(String value) {
            addCriterion("IS_COORDINATED <=", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedLike(String value) {
            addCriterion("IS_COORDINATED like", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedNotLike(String value) {
            addCriterion("IS_COORDINATED not like", value, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedIn(List<String> values) {
            addCriterion("IS_COORDINATED in", values, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedNotIn(List<String> values) {
            addCriterion("IS_COORDINATED not in", values, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedBetween(String value1, String value2) {
            addCriterion("IS_COORDINATED between", value1, value2, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsCoordinatedNotBetween(String value1, String value2) {
            addCriterion("IS_COORDINATED not between", value1, value2, "isCoordinated");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetIsNull() {
            addCriterion("IS_SCHEDULE_ADJUSTMNET is null");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetIsNotNull() {
            addCriterion("IS_SCHEDULE_ADJUSTMNET is not null");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetEqualTo(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET =", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetNotEqualTo(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET <>", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetGreaterThan(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET >", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET >=", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetLessThan(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET <", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetLessThanOrEqualTo(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET <=", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetLike(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET like", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetNotLike(String value) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET not like", value, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetIn(List<String> values) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET in", values, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetNotIn(List<String> values) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET not in", values, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetBetween(String value1, String value2) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET between", value1, value2, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andIsScheduleAdjustmnetNotBetween(String value1, String value2) {
            addCriterion("IS_SCHEDULE_ADJUSTMNET not between", value1, value2, "isScheduleAdjustmnet");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodIsNull() {
            addCriterion("ADJUST_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodIsNotNull() {
            addCriterion("ADJUST_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodEqualTo(String value) {
            addCriterion("ADJUST_PERIOD =", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodNotEqualTo(String value) {
            addCriterion("ADJUST_PERIOD <>", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodGreaterThan(String value) {
            addCriterion("ADJUST_PERIOD >", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PERIOD >=", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodLessThan(String value) {
            addCriterion("ADJUST_PERIOD <", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PERIOD <=", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodLike(String value) {
            addCriterion("ADJUST_PERIOD like", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodNotLike(String value) {
            addCriterion("ADJUST_PERIOD not like", value, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodIn(List<String> values) {
            addCriterion("ADJUST_PERIOD in", values, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodNotIn(List<String> values) {
            addCriterion("ADJUST_PERIOD not in", values, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodBetween(String value1, String value2) {
            addCriterion("ADJUST_PERIOD between", value1, value2, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustPeriodNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PERIOD not between", value1, value2, "adjustPeriod");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioIsNull() {
            addCriterion("ADJUST_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioIsNotNull() {
            addCriterion("ADJUST_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioEqualTo(String value) {
            addCriterion("ADJUST_RATIO =", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioNotEqualTo(String value) {
            addCriterion("ADJUST_RATIO <>", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioGreaterThan(String value) {
            addCriterion("ADJUST_RATIO >", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_RATIO >=", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioLessThan(String value) {
            addCriterion("ADJUST_RATIO <", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_RATIO <=", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioLike(String value) {
            addCriterion("ADJUST_RATIO like", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioNotLike(String value) {
            addCriterion("ADJUST_RATIO not like", value, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioIn(List<String> values) {
            addCriterion("ADJUST_RATIO in", values, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioNotIn(List<String> values) {
            addCriterion("ADJUST_RATIO not in", values, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioBetween(String value1, String value2) {
            addCriterion("ADJUST_RATIO between", value1, value2, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andAdjustRatioNotBetween(String value1, String value2) {
            addCriterion("ADJUST_RATIO not between", value1, value2, "adjustRatio");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsIsNull() {
            addCriterion("ORIGINAL_PLAN_GS is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsIsNotNull() {
            addCriterion("ORIGINAL_PLAN_GS is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_GS =", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsNotEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_GS <>", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsGreaterThan(String value) {
            addCriterion("ORIGINAL_PLAN_GS >", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_GS >=", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsLessThan(String value) {
            addCriterion("ORIGINAL_PLAN_GS <", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_GS <=", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsLike(String value) {
            addCriterion("ORIGINAL_PLAN_GS like", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsNotLike(String value) {
            addCriterion("ORIGINAL_PLAN_GS not like", value, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_GS in", values, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsNotIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_GS not in", values, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_GS between", value1, value2, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanGsNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_GS not between", value1, value2, "originalPlanGs");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuIsNull() {
            addCriterion("ORIGINAL_PLAN_MU is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuIsNotNull() {
            addCriterion("ORIGINAL_PLAN_MU is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_MU =", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuNotEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_MU <>", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuGreaterThan(String value) {
            addCriterion("ORIGINAL_PLAN_MU >", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_MU >=", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuLessThan(String value) {
            addCriterion("ORIGINAL_PLAN_MU <", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_MU <=", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuLike(String value) {
            addCriterion("ORIGINAL_PLAN_MU like", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuNotLike(String value) {
            addCriterion("ORIGINAL_PLAN_MU not like", value, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_MU in", values, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuNotIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_MU not in", values, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_MU between", value1, value2, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanMuNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_MU not between", value1, value2, "originalPlanMu");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzIsNull() {
            addCriterion("ORIGINAL_PLAN_CZ is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzIsNotNull() {
            addCriterion("ORIGINAL_PLAN_CZ is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CZ =", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzNotEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CZ <>", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzGreaterThan(String value) {
            addCriterion("ORIGINAL_PLAN_CZ >", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CZ >=", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzLessThan(String value) {
            addCriterion("ORIGINAL_PLAN_CZ <", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CZ <=", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzLike(String value) {
            addCriterion("ORIGINAL_PLAN_CZ like", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzNotLike(String value) {
            addCriterion("ORIGINAL_PLAN_CZ not like", value, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_CZ in", values, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzNotIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_CZ not in", values, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_CZ between", value1, value2, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCzNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_CZ not between", value1, value2, "originalPlanCz");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaIsNull() {
            addCriterion("ORIGINAL_PLAN_CA is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaIsNotNull() {
            addCriterion("ORIGINAL_PLAN_CA is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CA =", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaNotEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CA <>", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaGreaterThan(String value) {
            addCriterion("ORIGINAL_PLAN_CA >", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CA >=", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaLessThan(String value) {
            addCriterion("ORIGINAL_PLAN_CA <", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_CA <=", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaLike(String value) {
            addCriterion("ORIGINAL_PLAN_CA like", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaNotLike(String value) {
            addCriterion("ORIGINAL_PLAN_CA not like", value, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_CA in", values, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaNotIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_CA not in", values, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_CA between", value1, value2, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanCaNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_CA not between", value1, value2, "originalPlanCa");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkIsNull() {
            addCriterion("ORIGINAL_PLAN_BK is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkIsNotNull() {
            addCriterion("ORIGINAL_PLAN_BK is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_BK =", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkNotEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_BK <>", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkGreaterThan(String value) {
            addCriterion("ORIGINAL_PLAN_BK >", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_BK >=", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkLessThan(String value) {
            addCriterion("ORIGINAL_PLAN_BK <", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_BK <=", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkLike(String value) {
            addCriterion("ORIGINAL_PLAN_BK like", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkNotLike(String value) {
            addCriterion("ORIGINAL_PLAN_BK not like", value, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_BK in", values, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkNotIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_BK not in", values, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_BK between", value1, value2, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanBkNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_BK not between", value1, value2, "originalPlanBk");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjIsNull() {
            addCriterion("ORIGINAL_PLAN_HJ is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjIsNotNull() {
            addCriterion("ORIGINAL_PLAN_HJ is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_HJ =", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjNotEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_HJ <>", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjGreaterThan(String value) {
            addCriterion("ORIGINAL_PLAN_HJ >", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_HJ >=", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjLessThan(String value) {
            addCriterion("ORIGINAL_PLAN_HJ <", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjLessThanOrEqualTo(String value) {
            addCriterion("ORIGINAL_PLAN_HJ <=", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjLike(String value) {
            addCriterion("ORIGINAL_PLAN_HJ like", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjNotLike(String value) {
            addCriterion("ORIGINAL_PLAN_HJ not like", value, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_HJ in", values, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjNotIn(List<String> values) {
            addCriterion("ORIGINAL_PLAN_HJ not in", values, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_HJ between", value1, value2, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andOriginalPlanHjNotBetween(String value1, String value2) {
            addCriterion("ORIGINAL_PLAN_HJ not between", value1, value2, "originalPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsIsNull() {
            addCriterion("ADJUST_PLAN_GS is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsIsNotNull() {
            addCriterion("ADJUST_PLAN_GS is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsEqualTo(String value) {
            addCriterion("ADJUST_PLAN_GS =", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsNotEqualTo(String value) {
            addCriterion("ADJUST_PLAN_GS <>", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsGreaterThan(String value) {
            addCriterion("ADJUST_PLAN_GS >", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_GS >=", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsLessThan(String value) {
            addCriterion("ADJUST_PLAN_GS <", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_GS <=", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsLike(String value) {
            addCriterion("ADJUST_PLAN_GS like", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsNotLike(String value) {
            addCriterion("ADJUST_PLAN_GS not like", value, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsIn(List<String> values) {
            addCriterion("ADJUST_PLAN_GS in", values, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsNotIn(List<String> values) {
            addCriterion("ADJUST_PLAN_GS not in", values, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_GS between", value1, value2, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanGsNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_GS not between", value1, value2, "adjustPlanGs");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuIsNull() {
            addCriterion("ADJUST_PLAN_MU is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuIsNotNull() {
            addCriterion("ADJUST_PLAN_MU is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuEqualTo(String value) {
            addCriterion("ADJUST_PLAN_MU =", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuNotEqualTo(String value) {
            addCriterion("ADJUST_PLAN_MU <>", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuGreaterThan(String value) {
            addCriterion("ADJUST_PLAN_MU >", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_MU >=", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuLessThan(String value) {
            addCriterion("ADJUST_PLAN_MU <", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_MU <=", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuLike(String value) {
            addCriterion("ADJUST_PLAN_MU like", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuNotLike(String value) {
            addCriterion("ADJUST_PLAN_MU not like", value, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuIn(List<String> values) {
            addCriterion("ADJUST_PLAN_MU in", values, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuNotIn(List<String> values) {
            addCriterion("ADJUST_PLAN_MU not in", values, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_MU between", value1, value2, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanMuNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_MU not between", value1, value2, "adjustPlanMu");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzIsNull() {
            addCriterion("ADJUST_PLAN_CZ is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzIsNotNull() {
            addCriterion("ADJUST_PLAN_CZ is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CZ =", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzNotEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CZ <>", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzGreaterThan(String value) {
            addCriterion("ADJUST_PLAN_CZ >", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CZ >=", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzLessThan(String value) {
            addCriterion("ADJUST_PLAN_CZ <", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CZ <=", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzLike(String value) {
            addCriterion("ADJUST_PLAN_CZ like", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzNotLike(String value) {
            addCriterion("ADJUST_PLAN_CZ not like", value, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzIn(List<String> values) {
            addCriterion("ADJUST_PLAN_CZ in", values, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzNotIn(List<String> values) {
            addCriterion("ADJUST_PLAN_CZ not in", values, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_CZ between", value1, value2, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCzNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_CZ not between", value1, value2, "adjustPlanCz");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaIsNull() {
            addCriterion("ADJUST_PLAN_CA is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaIsNotNull() {
            addCriterion("ADJUST_PLAN_CA is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CA =", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaNotEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CA <>", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaGreaterThan(String value) {
            addCriterion("ADJUST_PLAN_CA >", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CA >=", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaLessThan(String value) {
            addCriterion("ADJUST_PLAN_CA <", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_CA <=", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaLike(String value) {
            addCriterion("ADJUST_PLAN_CA like", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaNotLike(String value) {
            addCriterion("ADJUST_PLAN_CA not like", value, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaIn(List<String> values) {
            addCriterion("ADJUST_PLAN_CA in", values, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaNotIn(List<String> values) {
            addCriterion("ADJUST_PLAN_CA not in", values, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_CA between", value1, value2, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanCaNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_CA not between", value1, value2, "adjustPlanCa");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkIsNull() {
            addCriterion("ADJUST_PLAN_BK is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkIsNotNull() {
            addCriterion("ADJUST_PLAN_BK is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkEqualTo(String value) {
            addCriterion("ADJUST_PLAN_BK =", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkNotEqualTo(String value) {
            addCriterion("ADJUST_PLAN_BK <>", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkGreaterThan(String value) {
            addCriterion("ADJUST_PLAN_BK >", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_BK >=", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkLessThan(String value) {
            addCriterion("ADJUST_PLAN_BK <", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_BK <=", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkLike(String value) {
            addCriterion("ADJUST_PLAN_BK like", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkNotLike(String value) {
            addCriterion("ADJUST_PLAN_BK not like", value, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkIn(List<String> values) {
            addCriterion("ADJUST_PLAN_BK in", values, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkNotIn(List<String> values) {
            addCriterion("ADJUST_PLAN_BK not in", values, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_BK between", value1, value2, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanBkNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_BK not between", value1, value2, "adjustPlanBk");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjIsNull() {
            addCriterion("ADJUST_PLAN_HJ is null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjIsNotNull() {
            addCriterion("ADJUST_PLAN_HJ is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjEqualTo(String value) {
            addCriterion("ADJUST_PLAN_HJ =", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjNotEqualTo(String value) {
            addCriterion("ADJUST_PLAN_HJ <>", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjGreaterThan(String value) {
            addCriterion("ADJUST_PLAN_HJ >", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_HJ >=", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjLessThan(String value) {
            addCriterion("ADJUST_PLAN_HJ <", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjLessThanOrEqualTo(String value) {
            addCriterion("ADJUST_PLAN_HJ <=", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjLike(String value) {
            addCriterion("ADJUST_PLAN_HJ like", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjNotLike(String value) {
            addCriterion("ADJUST_PLAN_HJ not like", value, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjIn(List<String> values) {
            addCriterion("ADJUST_PLAN_HJ in", values, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjNotIn(List<String> values) {
            addCriterion("ADJUST_PLAN_HJ not in", values, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_HJ between", value1, value2, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustPlanHjNotBetween(String value1, String value2) {
            addCriterion("ADJUST_PLAN_HJ not between", value1, value2, "adjustPlanHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsIsNull() {
            addCriterion("ADJUSTED_GS is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsIsNotNull() {
            addCriterion("ADJUSTED_GS is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsEqualTo(String value) {
            addCriterion("ADJUSTED_GS =", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsNotEqualTo(String value) {
            addCriterion("ADJUSTED_GS <>", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsGreaterThan(String value) {
            addCriterion("ADJUSTED_GS >", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_GS >=", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsLessThan(String value) {
            addCriterion("ADJUSTED_GS <", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_GS <=", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsLike(String value) {
            addCriterion("ADJUSTED_GS like", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsNotLike(String value) {
            addCriterion("ADJUSTED_GS not like", value, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsIn(List<String> values) {
            addCriterion("ADJUSTED_GS in", values, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsNotIn(List<String> values) {
            addCriterion("ADJUSTED_GS not in", values, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsBetween(String value1, String value2) {
            addCriterion("ADJUSTED_GS between", value1, value2, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedGsNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_GS not between", value1, value2, "adjustedGs");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuIsNull() {
            addCriterion("ADJUSTED_MU is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuIsNotNull() {
            addCriterion("ADJUSTED_MU is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuEqualTo(String value) {
            addCriterion("ADJUSTED_MU =", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuNotEqualTo(String value) {
            addCriterion("ADJUSTED_MU <>", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuGreaterThan(String value) {
            addCriterion("ADJUSTED_MU >", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_MU >=", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuLessThan(String value) {
            addCriterion("ADJUSTED_MU <", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_MU <=", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuLike(String value) {
            addCriterion("ADJUSTED_MU like", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuNotLike(String value) {
            addCriterion("ADJUSTED_MU not like", value, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuIn(List<String> values) {
            addCriterion("ADJUSTED_MU in", values, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuNotIn(List<String> values) {
            addCriterion("ADJUSTED_MU not in", values, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuBetween(String value1, String value2) {
            addCriterion("ADJUSTED_MU between", value1, value2, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedMuNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_MU not between", value1, value2, "adjustedMu");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzIsNull() {
            addCriterion("ADJUSTED_CZ is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzIsNotNull() {
            addCriterion("ADJUSTED_CZ is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzEqualTo(String value) {
            addCriterion("ADJUSTED_CZ =", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzNotEqualTo(String value) {
            addCriterion("ADJUSTED_CZ <>", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzGreaterThan(String value) {
            addCriterion("ADJUSTED_CZ >", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_CZ >=", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzLessThan(String value) {
            addCriterion("ADJUSTED_CZ <", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_CZ <=", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzLike(String value) {
            addCriterion("ADJUSTED_CZ like", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzNotLike(String value) {
            addCriterion("ADJUSTED_CZ not like", value, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzIn(List<String> values) {
            addCriterion("ADJUSTED_CZ in", values, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzNotIn(List<String> values) {
            addCriterion("ADJUSTED_CZ not in", values, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzBetween(String value1, String value2) {
            addCriterion("ADJUSTED_CZ between", value1, value2, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCzNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_CZ not between", value1, value2, "adjustedCz");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaIsNull() {
            addCriterion("ADJUSTED_CA is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaIsNotNull() {
            addCriterion("ADJUSTED_CA is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaEqualTo(String value) {
            addCriterion("ADJUSTED_CA =", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaNotEqualTo(String value) {
            addCriterion("ADJUSTED_CA <>", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaGreaterThan(String value) {
            addCriterion("ADJUSTED_CA >", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_CA >=", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaLessThan(String value) {
            addCriterion("ADJUSTED_CA <", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_CA <=", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaLike(String value) {
            addCriterion("ADJUSTED_CA like", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaNotLike(String value) {
            addCriterion("ADJUSTED_CA not like", value, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaIn(List<String> values) {
            addCriterion("ADJUSTED_CA in", values, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaNotIn(List<String> values) {
            addCriterion("ADJUSTED_CA not in", values, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaBetween(String value1, String value2) {
            addCriterion("ADJUSTED_CA between", value1, value2, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedCaNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_CA not between", value1, value2, "adjustedCa");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkIsNull() {
            addCriterion("ADJUSTED_BK is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkIsNotNull() {
            addCriterion("ADJUSTED_BK is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkEqualTo(String value) {
            addCriterion("ADJUSTED_BK =", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkNotEqualTo(String value) {
            addCriterion("ADJUSTED_BK <>", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkGreaterThan(String value) {
            addCriterion("ADJUSTED_BK >", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_BK >=", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkLessThan(String value) {
            addCriterion("ADJUSTED_BK <", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_BK <=", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkLike(String value) {
            addCriterion("ADJUSTED_BK like", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkNotLike(String value) {
            addCriterion("ADJUSTED_BK not like", value, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkIn(List<String> values) {
            addCriterion("ADJUSTED_BK in", values, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkNotIn(List<String> values) {
            addCriterion("ADJUSTED_BK not in", values, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkBetween(String value1, String value2) {
            addCriterion("ADJUSTED_BK between", value1, value2, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedBkNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_BK not between", value1, value2, "adjustedBk");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjIsNull() {
            addCriterion("ADJUSTED_HJ is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjIsNotNull() {
            addCriterion("ADJUSTED_HJ is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjEqualTo(String value) {
            addCriterion("ADJUSTED_HJ =", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjNotEqualTo(String value) {
            addCriterion("ADJUSTED_HJ <>", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjGreaterThan(String value) {
            addCriterion("ADJUSTED_HJ >", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_HJ >=", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjLessThan(String value) {
            addCriterion("ADJUSTED_HJ <", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_HJ <=", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjLike(String value) {
            addCriterion("ADJUSTED_HJ like", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjNotLike(String value) {
            addCriterion("ADJUSTED_HJ not like", value, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjIn(List<String> values) {
            addCriterion("ADJUSTED_HJ in", values, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjNotIn(List<String> values) {
            addCriterion("ADJUSTED_HJ not in", values, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjBetween(String value1, String value2) {
            addCriterion("ADJUSTED_HJ between", value1, value2, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedHjNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_HJ not between", value1, value2, "adjustedHj");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumIsNull() {
            addCriterion("ADJUSTED_PLAN_SUM is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumIsNotNull() {
            addCriterion("ADJUSTED_PLAN_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumEqualTo(String value) {
            addCriterion("ADJUSTED_PLAN_SUM =", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumNotEqualTo(String value) {
            addCriterion("ADJUSTED_PLAN_SUM <>", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumGreaterThan(String value) {
            addCriterion("ADJUSTED_PLAN_SUM >", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_PLAN_SUM >=", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumLessThan(String value) {
            addCriterion("ADJUSTED_PLAN_SUM <", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_PLAN_SUM <=", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumLike(String value) {
            addCriterion("ADJUSTED_PLAN_SUM like", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumNotLike(String value) {
            addCriterion("ADJUSTED_PLAN_SUM not like", value, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumIn(List<String> values) {
            addCriterion("ADJUSTED_PLAN_SUM in", values, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumNotIn(List<String> values) {
            addCriterion("ADJUSTED_PLAN_SUM not in", values, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumBetween(String value1, String value2) {
            addCriterion("ADJUSTED_PLAN_SUM between", value1, value2, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanSumNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_PLAN_SUM not between", value1, value2, "adjustedPlanSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumIsNull() {
            addCriterion("ADJUSTED_PLAND_SUM is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumIsNotNull() {
            addCriterion("ADJUSTED_PLAND_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumEqualTo(String value) {
            addCriterion("ADJUSTED_PLAND_SUM =", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumNotEqualTo(String value) {
            addCriterion("ADJUSTED_PLAND_SUM <>", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumGreaterThan(String value) {
            addCriterion("ADJUSTED_PLAND_SUM >", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_PLAND_SUM >=", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumLessThan(String value) {
            addCriterion("ADJUSTED_PLAND_SUM <", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_PLAND_SUM <=", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumLike(String value) {
            addCriterion("ADJUSTED_PLAND_SUM like", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumNotLike(String value) {
            addCriterion("ADJUSTED_PLAND_SUM not like", value, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumIn(List<String> values) {
            addCriterion("ADJUSTED_PLAND_SUM in", values, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumNotIn(List<String> values) {
            addCriterion("ADJUSTED_PLAND_SUM not in", values, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumBetween(String value1, String value2) {
            addCriterion("ADJUSTED_PLAND_SUM between", value1, value2, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlandSumNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_PLAND_SUM not between", value1, value2, "adjustedPlandSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumIsNull() {
            addCriterion("ADJUSTED_PLANA_SUM is null");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumIsNotNull() {
            addCriterion("ADJUSTED_PLANA_SUM is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumEqualTo(String value) {
            addCriterion("ADJUSTED_PLANA_SUM =", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumNotEqualTo(String value) {
            addCriterion("ADJUSTED_PLANA_SUM <>", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumGreaterThan(String value) {
            addCriterion("ADJUSTED_PLANA_SUM >", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumGreaterThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_PLANA_SUM >=", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumLessThan(String value) {
            addCriterion("ADJUSTED_PLANA_SUM <", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumLessThanOrEqualTo(String value) {
            addCriterion("ADJUSTED_PLANA_SUM <=", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumLike(String value) {
            addCriterion("ADJUSTED_PLANA_SUM like", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumNotLike(String value) {
            addCriterion("ADJUSTED_PLANA_SUM not like", value, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumIn(List<String> values) {
            addCriterion("ADJUSTED_PLANA_SUM in", values, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumNotIn(List<String> values) {
            addCriterion("ADJUSTED_PLANA_SUM not in", values, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumBetween(String value1, String value2) {
            addCriterion("ADJUSTED_PLANA_SUM between", value1, value2, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andAdjustedPlanaSumNotBetween(String value1, String value2) {
            addCriterion("ADJUSTED_PLANA_SUM not between", value1, value2, "adjustedPlanaSum");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneIsNull() {
            addCriterion("SPECIAL_PLANE is null");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneIsNotNull() {
            addCriterion("SPECIAL_PLANE is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneEqualTo(String value) {
            addCriterion("SPECIAL_PLANE =", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneNotEqualTo(String value) {
            addCriterion("SPECIAL_PLANE <>", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneGreaterThan(String value) {
            addCriterion("SPECIAL_PLANE >", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIAL_PLANE >=", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneLessThan(String value) {
            addCriterion("SPECIAL_PLANE <", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneLessThanOrEqualTo(String value) {
            addCriterion("SPECIAL_PLANE <=", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneLike(String value) {
            addCriterion("SPECIAL_PLANE like", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneNotLike(String value) {
            addCriterion("SPECIAL_PLANE not like", value, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneIn(List<String> values) {
            addCriterion("SPECIAL_PLANE in", values, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneNotIn(List<String> values) {
            addCriterion("SPECIAL_PLANE not in", values, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneBetween(String value1, String value2) {
            addCriterion("SPECIAL_PLANE between", value1, value2, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andSpecialPlaneNotBetween(String value1, String value2) {
            addCriterion("SPECIAL_PLANE not between", value1, value2, "specialPlane");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedIsNull() {
            addCriterion("MATTERS_COORDINATED is null");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedIsNotNull() {
            addCriterion("MATTERS_COORDINATED is not null");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedEqualTo(String value) {
            addCriterion("MATTERS_COORDINATED =", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedNotEqualTo(String value) {
            addCriterion("MATTERS_COORDINATED <>", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedGreaterThan(String value) {
            addCriterion("MATTERS_COORDINATED >", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedGreaterThanOrEqualTo(String value) {
            addCriterion("MATTERS_COORDINATED >=", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedLessThan(String value) {
            addCriterion("MATTERS_COORDINATED <", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedLessThanOrEqualTo(String value) {
            addCriterion("MATTERS_COORDINATED <=", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedLike(String value) {
            addCriterion("MATTERS_COORDINATED like", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedNotLike(String value) {
            addCriterion("MATTERS_COORDINATED not like", value, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedIn(List<String> values) {
            addCriterion("MATTERS_COORDINATED in", values, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedNotIn(List<String> values) {
            addCriterion("MATTERS_COORDINATED not in", values, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedBetween(String value1, String value2) {
            addCriterion("MATTERS_COORDINATED between", value1, value2, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andMattersCoordinatedNotBetween(String value1, String value2) {
            addCriterion("MATTERS_COORDINATED not between", value1, value2, "mattersCoordinated");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialIsNull() {
            addCriterion("OTHER_SPECIAL is null");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialIsNotNull() {
            addCriterion("OTHER_SPECIAL is not null");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialEqualTo(String value) {
            addCriterion("OTHER_SPECIAL =", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialNotEqualTo(String value) {
            addCriterion("OTHER_SPECIAL <>", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialGreaterThan(String value) {
            addCriterion("OTHER_SPECIAL >", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialGreaterThanOrEqualTo(String value) {
            addCriterion("OTHER_SPECIAL >=", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialLessThan(String value) {
            addCriterion("OTHER_SPECIAL <", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialLessThanOrEqualTo(String value) {
            addCriterion("OTHER_SPECIAL <=", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialLike(String value) {
            addCriterion("OTHER_SPECIAL like", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialNotLike(String value) {
            addCriterion("OTHER_SPECIAL not like", value, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialIn(List<String> values) {
            addCriterion("OTHER_SPECIAL in", values, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialNotIn(List<String> values) {
            addCriterion("OTHER_SPECIAL not in", values, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialBetween(String value1, String value2) {
            addCriterion("OTHER_SPECIAL between", value1, value2, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andOtherSpecialNotBetween(String value1, String value2) {
            addCriterion("OTHER_SPECIAL not between", value1, value2, "otherSpecial");
            return (Criteria) this;
        }

        public Criteria andNdManagerIsNull() {
            addCriterion("ND_MANAGER is null");
            return (Criteria) this;
        }

        public Criteria andNdManagerIsNotNull() {
            addCriterion("ND_MANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andNdManagerEqualTo(String value) {
            addCriterion("ND_MANAGER =", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerNotEqualTo(String value) {
            addCriterion("ND_MANAGER <>", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerGreaterThan(String value) {
            addCriterion("ND_MANAGER >", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerGreaterThanOrEqualTo(String value) {
            addCriterion("ND_MANAGER >=", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerLessThan(String value) {
            addCriterion("ND_MANAGER <", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerLessThanOrEqualTo(String value) {
            addCriterion("ND_MANAGER <=", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerLike(String value) {
            addCriterion("ND_MANAGER like", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerNotLike(String value) {
            addCriterion("ND_MANAGER not like", value, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerIn(List<String> values) {
            addCriterion("ND_MANAGER in", values, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerNotIn(List<String> values) {
            addCriterion("ND_MANAGER not in", values, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerBetween(String value1, String value2) {
            addCriterion("ND_MANAGER between", value1, value2, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerNotBetween(String value1, String value2) {
            addCriterion("ND_MANAGER not between", value1, value2, "ndManager");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneIsNull() {
            addCriterion("ND_MANAGER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneIsNotNull() {
            addCriterion("ND_MANAGER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneEqualTo(String value) {
            addCriterion("ND_MANAGER_PHONE =", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneNotEqualTo(String value) {
            addCriterion("ND_MANAGER_PHONE <>", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneGreaterThan(String value) {
            addCriterion("ND_MANAGER_PHONE >", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ND_MANAGER_PHONE >=", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneLessThan(String value) {
            addCriterion("ND_MANAGER_PHONE <", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneLessThanOrEqualTo(String value) {
            addCriterion("ND_MANAGER_PHONE <=", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneLike(String value) {
            addCriterion("ND_MANAGER_PHONE like", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneNotLike(String value) {
            addCriterion("ND_MANAGER_PHONE not like", value, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneIn(List<String> values) {
            addCriterion("ND_MANAGER_PHONE in", values, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneNotIn(List<String> values) {
            addCriterion("ND_MANAGER_PHONE not in", values, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneBetween(String value1, String value2) {
            addCriterion("ND_MANAGER_PHONE between", value1, value2, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdManagerPhoneNotBetween(String value1, String value2) {
            addCriterion("ND_MANAGER_PHONE not between", value1, value2, "ndManagerPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngIsNull() {
            addCriterion("ND_APMNG is null");
            return (Criteria) this;
        }

        public Criteria andNdApmngIsNotNull() {
            addCriterion("ND_APMNG is not null");
            return (Criteria) this;
        }

        public Criteria andNdApmngEqualTo(String value) {
            addCriterion("ND_APMNG =", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngNotEqualTo(String value) {
            addCriterion("ND_APMNG <>", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngGreaterThan(String value) {
            addCriterion("ND_APMNG >", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngGreaterThanOrEqualTo(String value) {
            addCriterion("ND_APMNG >=", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngLessThan(String value) {
            addCriterion("ND_APMNG <", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngLessThanOrEqualTo(String value) {
            addCriterion("ND_APMNG <=", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngLike(String value) {
            addCriterion("ND_APMNG like", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngNotLike(String value) {
            addCriterion("ND_APMNG not like", value, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngIn(List<String> values) {
            addCriterion("ND_APMNG in", values, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngNotIn(List<String> values) {
            addCriterion("ND_APMNG not in", values, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngBetween(String value1, String value2) {
            addCriterion("ND_APMNG between", value1, value2, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngNotBetween(String value1, String value2) {
            addCriterion("ND_APMNG not between", value1, value2, "ndApmng");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneIsNull() {
            addCriterion("ND_APMNG_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneIsNotNull() {
            addCriterion("ND_APMNG_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneEqualTo(String value) {
            addCriterion("ND_APMNG_PHONE =", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneNotEqualTo(String value) {
            addCriterion("ND_APMNG_PHONE <>", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneGreaterThan(String value) {
            addCriterion("ND_APMNG_PHONE >", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ND_APMNG_PHONE >=", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneLessThan(String value) {
            addCriterion("ND_APMNG_PHONE <", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneLessThanOrEqualTo(String value) {
            addCriterion("ND_APMNG_PHONE <=", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneLike(String value) {
            addCriterion("ND_APMNG_PHONE like", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneNotLike(String value) {
            addCriterion("ND_APMNG_PHONE not like", value, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneIn(List<String> values) {
            addCriterion("ND_APMNG_PHONE in", values, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneNotIn(List<String> values) {
            addCriterion("ND_APMNG_PHONE not in", values, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneBetween(String value1, String value2) {
            addCriterion("ND_APMNG_PHONE between", value1, value2, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andNdApmngPhoneNotBetween(String value1, String value2) {
            addCriterion("ND_APMNG_PHONE not between", value1, value2, "ndApmngPhone");
            return (Criteria) this;
        }

        public Criteria andPreparerIsNull() {
            addCriterion("PREPARER is null");
            return (Criteria) this;
        }

        public Criteria andPreparerIsNotNull() {
            addCriterion("PREPARER is not null");
            return (Criteria) this;
        }

        public Criteria andPreparerEqualTo(String value) {
            addCriterion("PREPARER =", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotEqualTo(String value) {
            addCriterion("PREPARER <>", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerGreaterThan(String value) {
            addCriterion("PREPARER >", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerGreaterThanOrEqualTo(String value) {
            addCriterion("PREPARER >=", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLessThan(String value) {
            addCriterion("PREPARER <", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLessThanOrEqualTo(String value) {
            addCriterion("PREPARER <=", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerLike(String value) {
            addCriterion("PREPARER like", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotLike(String value) {
            addCriterion("PREPARER not like", value, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerIn(List<String> values) {
            addCriterion("PREPARER in", values, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotIn(List<String> values) {
            addCriterion("PREPARER not in", values, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerBetween(String value1, String value2) {
            addCriterion("PREPARER between", value1, value2, "preparer");
            return (Criteria) this;
        }

        public Criteria andPreparerNotBetween(String value1, String value2) {
            addCriterion("PREPARER not between", value1, value2, "preparer");
            return (Criteria) this;
        }

        public Criteria andFillingTimeIsNull() {
            addCriterion("FILLING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFillingTimeIsNotNull() {
            addCriterion("FILLING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFillingTimeEqualTo(Date value) {
            addCriterion("FILLING_TIME =", value, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeNotEqualTo(Date value) {
            addCriterion("FILLING_TIME <>", value, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeGreaterThan(Date value) {
            addCriterion("FILLING_TIME >", value, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FILLING_TIME >=", value, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeLessThan(Date value) {
            addCriterion("FILLING_TIME <", value, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeLessThanOrEqualTo(Date value) {
            addCriterion("FILLING_TIME <=", value, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeIn(List<Date> values) {
            addCriterion("FILLING_TIME in", values, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeNotIn(List<Date> values) {
            addCriterion("FILLING_TIME not in", values, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeBetween(Date value1, Date value2) {
            addCriterion("FILLING_TIME between", value1, value2, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andFillingTimeNotBetween(Date value1, Date value2) {
            addCriterion("FILLING_TIME not between", value1, value2, "fillingTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeIsNull() {
            addCriterion("CUTOFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeIsNotNull() {
            addCriterion("CUTOFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeEqualTo(Date value) {
            addCriterion("CUTOFF_TIME =", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeNotEqualTo(Date value) {
            addCriterion("CUTOFF_TIME <>", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeGreaterThan(Date value) {
            addCriterion("CUTOFF_TIME >", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CUTOFF_TIME >=", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeLessThan(Date value) {
            addCriterion("CUTOFF_TIME <", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeLessThanOrEqualTo(Date value) {
            addCriterion("CUTOFF_TIME <=", value, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeIn(List<Date> values) {
            addCriterion("CUTOFF_TIME in", values, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeNotIn(List<Date> values) {
            addCriterion("CUTOFF_TIME not in", values, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeBetween(Date value1, Date value2) {
            addCriterion("CUTOFF_TIME between", value1, value2, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andCutoffTimeNotBetween(Date value1, Date value2) {
            addCriterion("CUTOFF_TIME not between", value1, value2, "cutoffTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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