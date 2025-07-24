package com.hq.acdm.vo.coordinatedOprt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TEdResponseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TEdResponseExample() {
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

        public Criteria andCurdatePlanaIsNull() {
            addCriterion("CURDATE_PLANA is null");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaIsNotNull() {
            addCriterion("CURDATE_PLANA is not null");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaEqualTo(String value) {
            addCriterion("CURDATE_PLANA =", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaNotEqualTo(String value) {
            addCriterion("CURDATE_PLANA <>", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaGreaterThan(String value) {
            addCriterion("CURDATE_PLANA >", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE_PLANA >=", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaLessThan(String value) {
            addCriterion("CURDATE_PLANA <", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaLessThanOrEqualTo(String value) {
            addCriterion("CURDATE_PLANA <=", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaLike(String value) {
            addCriterion("CURDATE_PLANA like", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaNotLike(String value) {
            addCriterion("CURDATE_PLANA not like", value, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaIn(List<String> values) {
            addCriterion("CURDATE_PLANA in", values, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaNotIn(List<String> values) {
            addCriterion("CURDATE_PLANA not in", values, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaBetween(String value1, String value2) {
            addCriterion("CURDATE_PLANA between", value1, value2, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlanaNotBetween(String value1, String value2) {
            addCriterion("CURDATE_PLANA not between", value1, value2, "curdatePlana");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandIsNull() {
            addCriterion("CURDATE_PLAND is null");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandIsNotNull() {
            addCriterion("CURDATE_PLAND is not null");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandEqualTo(String value) {
            addCriterion("CURDATE_PLAND =", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandNotEqualTo(String value) {
            addCriterion("CURDATE_PLAND <>", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandGreaterThan(String value) {
            addCriterion("CURDATE_PLAND >", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE_PLAND >=", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandLessThan(String value) {
            addCriterion("CURDATE_PLAND <", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandLessThanOrEqualTo(String value) {
            addCriterion("CURDATE_PLAND <=", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandLike(String value) {
            addCriterion("CURDATE_PLAND like", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandNotLike(String value) {
            addCriterion("CURDATE_PLAND not like", value, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandIn(List<String> values) {
            addCriterion("CURDATE_PLAND in", values, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandNotIn(List<String> values) {
            addCriterion("CURDATE_PLAND not in", values, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandBetween(String value1, String value2) {
            addCriterion("CURDATE_PLAND between", value1, value2, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurdatePlandNotBetween(String value1, String value2) {
            addCriterion("CURDATE_PLAND not between", value1, value2, "curdatePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaIsNull() {
            addCriterion("CURTIME_PLANA is null");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaIsNotNull() {
            addCriterion("CURTIME_PLANA is not null");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaEqualTo(String value) {
            addCriterion("CURTIME_PLANA =", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaNotEqualTo(String value) {
            addCriterion("CURTIME_PLANA <>", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaGreaterThan(String value) {
            addCriterion("CURTIME_PLANA >", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaGreaterThanOrEqualTo(String value) {
            addCriterion("CURTIME_PLANA >=", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaLessThan(String value) {
            addCriterion("CURTIME_PLANA <", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaLessThanOrEqualTo(String value) {
            addCriterion("CURTIME_PLANA <=", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaLike(String value) {
            addCriterion("CURTIME_PLANA like", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaNotLike(String value) {
            addCriterion("CURTIME_PLANA not like", value, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaIn(List<String> values) {
            addCriterion("CURTIME_PLANA in", values, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaNotIn(List<String> values) {
            addCriterion("CURTIME_PLANA not in", values, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaBetween(String value1, String value2) {
            addCriterion("CURTIME_PLANA between", value1, value2, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlanaNotBetween(String value1, String value2) {
            addCriterion("CURTIME_PLANA not between", value1, value2, "curtimePlana");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandIsNull() {
            addCriterion("CURTIME_PLAND is null");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandIsNotNull() {
            addCriterion("CURTIME_PLAND is not null");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandEqualTo(String value) {
            addCriterion("CURTIME_PLAND =", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandNotEqualTo(String value) {
            addCriterion("CURTIME_PLAND <>", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandGreaterThan(String value) {
            addCriterion("CURTIME_PLAND >", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandGreaterThanOrEqualTo(String value) {
            addCriterion("CURTIME_PLAND >=", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandLessThan(String value) {
            addCriterion("CURTIME_PLAND <", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandLessThanOrEqualTo(String value) {
            addCriterion("CURTIME_PLAND <=", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandLike(String value) {
            addCriterion("CURTIME_PLAND like", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandNotLike(String value) {
            addCriterion("CURTIME_PLAND not like", value, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandIn(List<String> values) {
            addCriterion("CURTIME_PLAND in", values, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandNotIn(List<String> values) {
            addCriterion("CURTIME_PLAND not in", values, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandBetween(String value1, String value2) {
            addCriterion("CURTIME_PLAND between", value1, value2, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andCurtimePlandNotBetween(String value1, String value2) {
            addCriterion("CURTIME_PLAND not between", value1, value2, "curtimePland");
            return (Criteria) this;
        }

        public Criteria andExecutedAIsNull() {
            addCriterion("EXECUTED_A is null");
            return (Criteria) this;
        }

        public Criteria andExecutedAIsNotNull() {
            addCriterion("EXECUTED_A is not null");
            return (Criteria) this;
        }

        public Criteria andExecutedAEqualTo(String value) {
            addCriterion("EXECUTED_A =", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedANotEqualTo(String value) {
            addCriterion("EXECUTED_A <>", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedAGreaterThan(String value) {
            addCriterion("EXECUTED_A >", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedAGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTED_A >=", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedALessThan(String value) {
            addCriterion("EXECUTED_A <", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedALessThanOrEqualTo(String value) {
            addCriterion("EXECUTED_A <=", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedALike(String value) {
            addCriterion("EXECUTED_A like", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedANotLike(String value) {
            addCriterion("EXECUTED_A not like", value, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedAIn(List<String> values) {
            addCriterion("EXECUTED_A in", values, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedANotIn(List<String> values) {
            addCriterion("EXECUTED_A not in", values, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedABetween(String value1, String value2) {
            addCriterion("EXECUTED_A between", value1, value2, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedANotBetween(String value1, String value2) {
            addCriterion("EXECUTED_A not between", value1, value2, "executedA");
            return (Criteria) this;
        }

        public Criteria andExecutedDIsNull() {
            addCriterion("EXECUTED_D is null");
            return (Criteria) this;
        }

        public Criteria andExecutedDIsNotNull() {
            addCriterion("EXECUTED_D is not null");
            return (Criteria) this;
        }

        public Criteria andExecutedDEqualTo(String value) {
            addCriterion("EXECUTED_D =", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDNotEqualTo(String value) {
            addCriterion("EXECUTED_D <>", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDGreaterThan(String value) {
            addCriterion("EXECUTED_D >", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTED_D >=", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDLessThan(String value) {
            addCriterion("EXECUTED_D <", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDLessThanOrEqualTo(String value) {
            addCriterion("EXECUTED_D <=", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDLike(String value) {
            addCriterion("EXECUTED_D like", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDNotLike(String value) {
            addCriterion("EXECUTED_D not like", value, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDIn(List<String> values) {
            addCriterion("EXECUTED_D in", values, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDNotIn(List<String> values) {
            addCriterion("EXECUTED_D not in", values, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDBetween(String value1, String value2) {
            addCriterion("EXECUTED_D between", value1, value2, "executedD");
            return (Criteria) this;
        }

        public Criteria andExecutedDNotBetween(String value1, String value2) {
            addCriterion("EXECUTED_D not between", value1, value2, "executedD");
            return (Criteria) this;
        }

        public Criteria andCanceledAIsNull() {
            addCriterion("CANCELED_A is null");
            return (Criteria) this;
        }

        public Criteria andCanceledAIsNotNull() {
            addCriterion("CANCELED_A is not null");
            return (Criteria) this;
        }

        public Criteria andCanceledAEqualTo(String value) {
            addCriterion("CANCELED_A =", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledANotEqualTo(String value) {
            addCriterion("CANCELED_A <>", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledAGreaterThan(String value) {
            addCriterion("CANCELED_A >", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledAGreaterThanOrEqualTo(String value) {
            addCriterion("CANCELED_A >=", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledALessThan(String value) {
            addCriterion("CANCELED_A <", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledALessThanOrEqualTo(String value) {
            addCriterion("CANCELED_A <=", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledALike(String value) {
            addCriterion("CANCELED_A like", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledANotLike(String value) {
            addCriterion("CANCELED_A not like", value, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledAIn(List<String> values) {
            addCriterion("CANCELED_A in", values, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledANotIn(List<String> values) {
            addCriterion("CANCELED_A not in", values, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledABetween(String value1, String value2) {
            addCriterion("CANCELED_A between", value1, value2, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledANotBetween(String value1, String value2) {
            addCriterion("CANCELED_A not between", value1, value2, "canceledA");
            return (Criteria) this;
        }

        public Criteria andCanceledDIsNull() {
            addCriterion("CANCELED_D is null");
            return (Criteria) this;
        }

        public Criteria andCanceledDIsNotNull() {
            addCriterion("CANCELED_D is not null");
            return (Criteria) this;
        }

        public Criteria andCanceledDEqualTo(String value) {
            addCriterion("CANCELED_D =", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDNotEqualTo(String value) {
            addCriterion("CANCELED_D <>", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDGreaterThan(String value) {
            addCriterion("CANCELED_D >", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDGreaterThanOrEqualTo(String value) {
            addCriterion("CANCELED_D >=", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDLessThan(String value) {
            addCriterion("CANCELED_D <", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDLessThanOrEqualTo(String value) {
            addCriterion("CANCELED_D <=", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDLike(String value) {
            addCriterion("CANCELED_D like", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDNotLike(String value) {
            addCriterion("CANCELED_D not like", value, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDIn(List<String> values) {
            addCriterion("CANCELED_D in", values, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDNotIn(List<String> values) {
            addCriterion("CANCELED_D not in", values, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDBetween(String value1, String value2) {
            addCriterion("CANCELED_D between", value1, value2, "canceledD");
            return (Criteria) this;
        }

        public Criteria andCanceledDNotBetween(String value1, String value2) {
            addCriterion("CANCELED_D not between", value1, value2, "canceledD");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateIsNull() {
            addCriterion("RETURN_ALTERNATE is null");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateIsNotNull() {
            addCriterion("RETURN_ALTERNATE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateEqualTo(String value) {
            addCriterion("RETURN_ALTERNATE =", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateNotEqualTo(String value) {
            addCriterion("RETURN_ALTERNATE <>", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateGreaterThan(String value) {
            addCriterion("RETURN_ALTERNATE >", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateGreaterThanOrEqualTo(String value) {
            addCriterion("RETURN_ALTERNATE >=", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateLessThan(String value) {
            addCriterion("RETURN_ALTERNATE <", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateLessThanOrEqualTo(String value) {
            addCriterion("RETURN_ALTERNATE <=", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateLike(String value) {
            addCriterion("RETURN_ALTERNATE like", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateNotLike(String value) {
            addCriterion("RETURN_ALTERNATE not like", value, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateIn(List<String> values) {
            addCriterion("RETURN_ALTERNATE in", values, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateNotIn(List<String> values) {
            addCriterion("RETURN_ALTERNATE not in", values, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateBetween(String value1, String value2) {
            addCriterion("RETURN_ALTERNATE between", value1, value2, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andReturnAlternateNotBetween(String value1, String value2) {
            addCriterion("RETURN_ALTERNATE not between", value1, value2, "returnAlternate");
            return (Criteria) this;
        }

        public Criteria andHourPlanaIsNull() {
            addCriterion("HOUR_PLANA is null");
            return (Criteria) this;
        }

        public Criteria andHourPlanaIsNotNull() {
            addCriterion("HOUR_PLANA is not null");
            return (Criteria) this;
        }

        public Criteria andHourPlanaEqualTo(String value) {
            addCriterion("HOUR_PLANA =", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaNotEqualTo(String value) {
            addCriterion("HOUR_PLANA <>", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaGreaterThan(String value) {
            addCriterion("HOUR_PLANA >", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaGreaterThanOrEqualTo(String value) {
            addCriterion("HOUR_PLANA >=", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaLessThan(String value) {
            addCriterion("HOUR_PLANA <", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaLessThanOrEqualTo(String value) {
            addCriterion("HOUR_PLANA <=", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaLike(String value) {
            addCriterion("HOUR_PLANA like", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaNotLike(String value) {
            addCriterion("HOUR_PLANA not like", value, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaIn(List<String> values) {
            addCriterion("HOUR_PLANA in", values, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaNotIn(List<String> values) {
            addCriterion("HOUR_PLANA not in", values, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaBetween(String value1, String value2) {
            addCriterion("HOUR_PLANA between", value1, value2, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourPlanaNotBetween(String value1, String value2) {
            addCriterion("HOUR_PLANA not between", value1, value2, "hourPlana");
            return (Criteria) this;
        }

        public Criteria andHourActualaIsNull() {
            addCriterion("HOUR_ACTUALA is null");
            return (Criteria) this;
        }

        public Criteria andHourActualaIsNotNull() {
            addCriterion("HOUR_ACTUALA is not null");
            return (Criteria) this;
        }

        public Criteria andHourActualaEqualTo(String value) {
            addCriterion("HOUR_ACTUALA =", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaNotEqualTo(String value) {
            addCriterion("HOUR_ACTUALA <>", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaGreaterThan(String value) {
            addCriterion("HOUR_ACTUALA >", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaGreaterThanOrEqualTo(String value) {
            addCriterion("HOUR_ACTUALA >=", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaLessThan(String value) {
            addCriterion("HOUR_ACTUALA <", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaLessThanOrEqualTo(String value) {
            addCriterion("HOUR_ACTUALA <=", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaLike(String value) {
            addCriterion("HOUR_ACTUALA like", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaNotLike(String value) {
            addCriterion("HOUR_ACTUALA not like", value, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaIn(List<String> values) {
            addCriterion("HOUR_ACTUALA in", values, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaNotIn(List<String> values) {
            addCriterion("HOUR_ACTUALA not in", values, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaBetween(String value1, String value2) {
            addCriterion("HOUR_ACTUALA between", value1, value2, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourActualaNotBetween(String value1, String value2) {
            addCriterion("HOUR_ACTUALA not between", value1, value2, "hourActuala");
            return (Criteria) this;
        }

        public Criteria andHourPlandIsNull() {
            addCriterion("HOUR_PLAND is null");
            return (Criteria) this;
        }

        public Criteria andHourPlandIsNotNull() {
            addCriterion("HOUR_PLAND is not null");
            return (Criteria) this;
        }

        public Criteria andHourPlandEqualTo(String value) {
            addCriterion("HOUR_PLAND =", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandNotEqualTo(String value) {
            addCriterion("HOUR_PLAND <>", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandGreaterThan(String value) {
            addCriterion("HOUR_PLAND >", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandGreaterThanOrEqualTo(String value) {
            addCriterion("HOUR_PLAND >=", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandLessThan(String value) {
            addCriterion("HOUR_PLAND <", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandLessThanOrEqualTo(String value) {
            addCriterion("HOUR_PLAND <=", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandLike(String value) {
            addCriterion("HOUR_PLAND like", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandNotLike(String value) {
            addCriterion("HOUR_PLAND not like", value, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandIn(List<String> values) {
            addCriterion("HOUR_PLAND in", values, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandNotIn(List<String> values) {
            addCriterion("HOUR_PLAND not in", values, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandBetween(String value1, String value2) {
            addCriterion("HOUR_PLAND between", value1, value2, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourPlandNotBetween(String value1, String value2) {
            addCriterion("HOUR_PLAND not between", value1, value2, "hourPland");
            return (Criteria) this;
        }

        public Criteria andHourActualdIsNull() {
            addCriterion("HOUR_ACTUALD is null");
            return (Criteria) this;
        }

        public Criteria andHourActualdIsNotNull() {
            addCriterion("HOUR_ACTUALD is not null");
            return (Criteria) this;
        }

        public Criteria andHourActualdEqualTo(String value) {
            addCriterion("HOUR_ACTUALD =", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdNotEqualTo(String value) {
            addCriterion("HOUR_ACTUALD <>", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdGreaterThan(String value) {
            addCriterion("HOUR_ACTUALD >", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdGreaterThanOrEqualTo(String value) {
            addCriterion("HOUR_ACTUALD >=", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdLessThan(String value) {
            addCriterion("HOUR_ACTUALD <", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdLessThanOrEqualTo(String value) {
            addCriterion("HOUR_ACTUALD <=", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdLike(String value) {
            addCriterion("HOUR_ACTUALD like", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdNotLike(String value) {
            addCriterion("HOUR_ACTUALD not like", value, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdIn(List<String> values) {
            addCriterion("HOUR_ACTUALD in", values, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdNotIn(List<String> values) {
            addCriterion("HOUR_ACTUALD not in", values, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdBetween(String value1, String value2) {
            addCriterion("HOUR_ACTUALD between", value1, value2, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andHourActualdNotBetween(String value1, String value2) {
            addCriterion("HOUR_ACTUALD not between", value1, value2, "hourActuald");
            return (Criteria) this;
        }

        public Criteria andFreeStandIsNull() {
            addCriterion("FREE_STAND is null");
            return (Criteria) this;
        }

        public Criteria andFreeStandIsNotNull() {
            addCriterion("FREE_STAND is not null");
            return (Criteria) this;
        }

        public Criteria andFreeStandEqualTo(String value) {
            addCriterion("FREE_STAND =", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandNotEqualTo(String value) {
            addCriterion("FREE_STAND <>", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandGreaterThan(String value) {
            addCriterion("FREE_STAND >", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandGreaterThanOrEqualTo(String value) {
            addCriterion("FREE_STAND >=", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandLessThan(String value) {
            addCriterion("FREE_STAND <", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandLessThanOrEqualTo(String value) {
            addCriterion("FREE_STAND <=", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandLike(String value) {
            addCriterion("FREE_STAND like", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandNotLike(String value) {
            addCriterion("FREE_STAND not like", value, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandIn(List<String> values) {
            addCriterion("FREE_STAND in", values, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandNotIn(List<String> values) {
            addCriterion("FREE_STAND not in", values, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandBetween(String value1, String value2) {
            addCriterion("FREE_STAND between", value1, value2, "freeStand");
            return (Criteria) this;
        }

        public Criteria andFreeStandNotBetween(String value1, String value2) {
            addCriterion("FREE_STAND not between", value1, value2, "freeStand");
            return (Criteria) this;
        }

        public Criteria andDelayRatioIsNull() {
            addCriterion("DELAY_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andDelayRatioIsNotNull() {
            addCriterion("DELAY_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andDelayRatioEqualTo(String value) {
            addCriterion("DELAY_RATIO =", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioNotEqualTo(String value) {
            addCriterion("DELAY_RATIO <>", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioGreaterThan(String value) {
            addCriterion("DELAY_RATIO >", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_RATIO >=", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioLessThan(String value) {
            addCriterion("DELAY_RATIO <", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioLessThanOrEqualTo(String value) {
            addCriterion("DELAY_RATIO <=", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioLike(String value) {
            addCriterion("DELAY_RATIO like", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioNotLike(String value) {
            addCriterion("DELAY_RATIO not like", value, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioIn(List<String> values) {
            addCriterion("DELAY_RATIO in", values, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioNotIn(List<String> values) {
            addCriterion("DELAY_RATIO not in", values, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioBetween(String value1, String value2) {
            addCriterion("DELAY_RATIO between", value1, value2, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayRatioNotBetween(String value1, String value2) {
            addCriterion("DELAY_RATIO not between", value1, value2, "delayRatio");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoIsNull() {
            addCriterion("DELAY_FLNO is null");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoIsNotNull() {
            addCriterion("DELAY_FLNO is not null");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoEqualTo(String value) {
            addCriterion("DELAY_FLNO =", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoNotEqualTo(String value) {
            addCriterion("DELAY_FLNO <>", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoGreaterThan(String value) {
            addCriterion("DELAY_FLNO >", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoGreaterThanOrEqualTo(String value) {
            addCriterion("DELAY_FLNO >=", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoLessThan(String value) {
            addCriterion("DELAY_FLNO <", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoLessThanOrEqualTo(String value) {
            addCriterion("DELAY_FLNO <=", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoLike(String value) {
            addCriterion("DELAY_FLNO like", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoNotLike(String value) {
            addCriterion("DELAY_FLNO not like", value, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoIn(List<String> values) {
            addCriterion("DELAY_FLNO in", values, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoNotIn(List<String> values) {
            addCriterion("DELAY_FLNO not in", values, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoBetween(String value1, String value2) {
            addCriterion("DELAY_FLNO between", value1, value2, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDelayFlnoNotBetween(String value1, String value2) {
            addCriterion("DELAY_FLNO not between", value1, value2, "delayFlno");
            return (Criteria) this;
        }

        public Criteria andDclsRatioIsNull() {
            addCriterion("DCLS_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andDclsRatioIsNotNull() {
            addCriterion("DCLS_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andDclsRatioEqualTo(String value) {
            addCriterion("DCLS_RATIO =", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioNotEqualTo(String value) {
            addCriterion("DCLS_RATIO <>", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioGreaterThan(String value) {
            addCriterion("DCLS_RATIO >", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioGreaterThanOrEqualTo(String value) {
            addCriterion("DCLS_RATIO >=", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioLessThan(String value) {
            addCriterion("DCLS_RATIO <", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioLessThanOrEqualTo(String value) {
            addCriterion("DCLS_RATIO <=", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioLike(String value) {
            addCriterion("DCLS_RATIO like", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioNotLike(String value) {
            addCriterion("DCLS_RATIO not like", value, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioIn(List<String> values) {
            addCriterion("DCLS_RATIO in", values, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioNotIn(List<String> values) {
            addCriterion("DCLS_RATIO not in", values, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioBetween(String value1, String value2) {
            addCriterion("DCLS_RATIO between", value1, value2, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsRatioNotBetween(String value1, String value2) {
            addCriterion("DCLS_RATIO not between", value1, value2, "dclsRatio");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoIsNull() {
            addCriterion("DCLS_FLNO is null");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoIsNotNull() {
            addCriterion("DCLS_FLNO is not null");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoEqualTo(String value) {
            addCriterion("DCLS_FLNO =", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoNotEqualTo(String value) {
            addCriterion("DCLS_FLNO <>", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoGreaterThan(String value) {
            addCriterion("DCLS_FLNO >", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoGreaterThanOrEqualTo(String value) {
            addCriterion("DCLS_FLNO >=", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoLessThan(String value) {
            addCriterion("DCLS_FLNO <", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoLessThanOrEqualTo(String value) {
            addCriterion("DCLS_FLNO <=", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoLike(String value) {
            addCriterion("DCLS_FLNO like", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoNotLike(String value) {
            addCriterion("DCLS_FLNO not like", value, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoIn(List<String> values) {
            addCriterion("DCLS_FLNO in", values, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoNotIn(List<String> values) {
            addCriterion("DCLS_FLNO not in", values, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoBetween(String value1, String value2) {
            addCriterion("DCLS_FLNO between", value1, value2, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andDclsFlnoNotBetween(String value1, String value2) {
            addCriterion("DCLS_FLNO not between", value1, value2, "dclsFlno");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnIsNull() {
            addCriterion("EXECUTIVE_CDTN is null");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnIsNotNull() {
            addCriterion("EXECUTIVE_CDTN is not null");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnEqualTo(String value) {
            addCriterion("EXECUTIVE_CDTN =", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnNotEqualTo(String value) {
            addCriterion("EXECUTIVE_CDTN <>", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnGreaterThan(String value) {
            addCriterion("EXECUTIVE_CDTN >", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTIVE_CDTN >=", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnLessThan(String value) {
            addCriterion("EXECUTIVE_CDTN <", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnLessThanOrEqualTo(String value) {
            addCriterion("EXECUTIVE_CDTN <=", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnLike(String value) {
            addCriterion("EXECUTIVE_CDTN like", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnNotLike(String value) {
            addCriterion("EXECUTIVE_CDTN not like", value, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnIn(List<String> values) {
            addCriterion("EXECUTIVE_CDTN in", values, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnNotIn(List<String> values) {
            addCriterion("EXECUTIVE_CDTN not in", values, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnBetween(String value1, String value2) {
            addCriterion("EXECUTIVE_CDTN between", value1, value2, "executiveCdtn");
            return (Criteria) this;
        }

        public Criteria andExecutiveCdtnNotBetween(String value1, String value2) {
            addCriterion("EXECUTIVE_CDTN not between", value1, value2, "executiveCdtn");
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

        public Criteria andTerminalOrderIsNull() {
            addCriterion("TERMINAL_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderIsNotNull() {
            addCriterion("TERMINAL_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderEqualTo(String value) {
            addCriterion("TERMINAL_ORDER =", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderNotEqualTo(String value) {
            addCriterion("TERMINAL_ORDER <>", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderGreaterThan(String value) {
            addCriterion("TERMINAL_ORDER >", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderGreaterThanOrEqualTo(String value) {
            addCriterion("TERMINAL_ORDER >=", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderLessThan(String value) {
            addCriterion("TERMINAL_ORDER <", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderLessThanOrEqualTo(String value) {
            addCriterion("TERMINAL_ORDER <=", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderLike(String value) {
            addCriterion("TERMINAL_ORDER like", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderNotLike(String value) {
            addCriterion("TERMINAL_ORDER not like", value, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderIn(List<String> values) {
            addCriterion("TERMINAL_ORDER in", values, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderNotIn(List<String> values) {
            addCriterion("TERMINAL_ORDER not in", values, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderBetween(String value1, String value2) {
            addCriterion("TERMINAL_ORDER between", value1, value2, "terminalOrder");
            return (Criteria) this;
        }

        public Criteria andTerminalOrderNotBetween(String value1, String value2) {
            addCriterion("TERMINAL_ORDER not between", value1, value2, "terminalOrder");
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

        public Criteria andCurdateManagerIsNull() {
            addCriterion("CURDATE_MANAGER is null");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerIsNotNull() {
            addCriterion("CURDATE_MANAGER is not null");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerEqualTo(String value) {
            addCriterion("CURDATE_MANAGER =", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerNotEqualTo(String value) {
            addCriterion("CURDATE_MANAGER <>", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerGreaterThan(String value) {
            addCriterion("CURDATE_MANAGER >", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE_MANAGER >=", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerLessThan(String value) {
            addCriterion("CURDATE_MANAGER <", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerLessThanOrEqualTo(String value) {
            addCriterion("CURDATE_MANAGER <=", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerLike(String value) {
            addCriterion("CURDATE_MANAGER like", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerNotLike(String value) {
            addCriterion("CURDATE_MANAGER not like", value, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerIn(List<String> values) {
            addCriterion("CURDATE_MANAGER in", values, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerNotIn(List<String> values) {
            addCriterion("CURDATE_MANAGER not in", values, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerBetween(String value1, String value2) {
            addCriterion("CURDATE_MANAGER between", value1, value2, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerNotBetween(String value1, String value2) {
            addCriterion("CURDATE_MANAGER not between", value1, value2, "curdateManager");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneIsNull() {
            addCriterion("CURDATE_MANAGER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneIsNotNull() {
            addCriterion("CURDATE_MANAGER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneEqualTo(String value) {
            addCriterion("CURDATE_MANAGER_PHONE =", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneNotEqualTo(String value) {
            addCriterion("CURDATE_MANAGER_PHONE <>", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneGreaterThan(String value) {
            addCriterion("CURDATE_MANAGER_PHONE >", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE_MANAGER_PHONE >=", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneLessThan(String value) {
            addCriterion("CURDATE_MANAGER_PHONE <", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneLessThanOrEqualTo(String value) {
            addCriterion("CURDATE_MANAGER_PHONE <=", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneLike(String value) {
            addCriterion("CURDATE_MANAGER_PHONE like", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneNotLike(String value) {
            addCriterion("CURDATE_MANAGER_PHONE not like", value, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneIn(List<String> values) {
            addCriterion("CURDATE_MANAGER_PHONE in", values, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneNotIn(List<String> values) {
            addCriterion("CURDATE_MANAGER_PHONE not in", values, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneBetween(String value1, String value2) {
            addCriterion("CURDATE_MANAGER_PHONE between", value1, value2, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateManagerPhoneNotBetween(String value1, String value2) {
            addCriterion("CURDATE_MANAGER_PHONE not between", value1, value2, "curdateManagerPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngIsNull() {
            addCriterion("CURDATE_APMNG is null");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngIsNotNull() {
            addCriterion("CURDATE_APMNG is not null");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngEqualTo(String value) {
            addCriterion("CURDATE_APMNG =", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngNotEqualTo(String value) {
            addCriterion("CURDATE_APMNG <>", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngGreaterThan(String value) {
            addCriterion("CURDATE_APMNG >", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngGreaterThanOrEqualTo(String value) {
            addCriterion("CURDATE_APMNG >=", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngLessThan(String value) {
            addCriterion("CURDATE_APMNG <", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngLessThanOrEqualTo(String value) {
            addCriterion("CURDATE_APMNG <=", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngLike(String value) {
            addCriterion("CURDATE_APMNG like", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngNotLike(String value) {
            addCriterion("CURDATE_APMNG not like", value, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngIn(List<String> values) {
            addCriterion("CURDATE_APMNG in", values, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngNotIn(List<String> values) {
            addCriterion("CURDATE_APMNG not in", values, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngBetween(String value1, String value2) {
            addCriterion("CURDATE_APMNG between", value1, value2, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngNotBetween(String value1, String value2) {
            addCriterion("CURDATE_APMNG not between", value1, value2, "curdateApmng");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneIsNull() {
            addCriterion("CURDATE_APMNG_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneIsNotNull() {
            addCriterion("CURDATE_APMNG_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneEqualTo(Date value) {
            addCriterion("CURDATE_APMNG_PHONE =", value, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneNotEqualTo(Date value) {
            addCriterion("CURDATE_APMNG_PHONE <>", value, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneGreaterThan(Date value) {
            addCriterion("CURDATE_APMNG_PHONE >", value, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneGreaterThanOrEqualTo(Date value) {
            addCriterion("CURDATE_APMNG_PHONE >=", value, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneLessThan(Date value) {
            addCriterion("CURDATE_APMNG_PHONE <", value, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneLessThanOrEqualTo(Date value) {
            addCriterion("CURDATE_APMNG_PHONE <=", value, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneIn(List<Date> values) {
            addCriterion("CURDATE_APMNG_PHONE in", values, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneNotIn(List<Date> values) {
            addCriterion("CURDATE_APMNG_PHONE not in", values, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneBetween(Date value1, Date value2) {
            addCriterion("CURDATE_APMNG_PHONE between", value1, value2, "curdateApmngPhone");
            return (Criteria) this;
        }

        public Criteria andCurdateApmngPhoneNotBetween(Date value1, Date value2) {
            addCriterion("CURDATE_APMNG_PHONE not between", value1, value2, "curdateApmngPhone");
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