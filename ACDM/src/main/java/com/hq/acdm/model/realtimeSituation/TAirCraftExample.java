package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TAirCraftExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAirCraftExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdIsNull() {
            addCriterion("CRAFT_TYPE_ICAO_CD is null");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdIsNotNull() {
            addCriterion("CRAFT_TYPE_ICAO_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD =", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdNotEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD <>", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdGreaterThan(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD >", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdGreaterThanOrEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD >=", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdLessThan(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD <", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdLessThanOrEqualTo(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD <=", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdLike(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD like", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdNotLike(String value) {
            addCriterion("CRAFT_TYPE_ICAO_CD not like", value, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdIn(List<String> values) {
            addCriterion("CRAFT_TYPE_ICAO_CD in", values, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdNotIn(List<String> values) {
            addCriterion("CRAFT_TYPE_ICAO_CD not in", values, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdBetween(String value1, String value2) {
            addCriterion("CRAFT_TYPE_ICAO_CD between", value1, value2, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andCraftTypeIcaoCdNotBetween(String value1, String value2) {
            addCriterion("CRAFT_TYPE_ICAO_CD not between", value1, value2, "craftTypeIcaoCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdIsNull() {
            addCriterion("AIRLINE_TWO_CHAR_CD is null");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdIsNotNull() {
            addCriterion("AIRLINE_TWO_CHAR_CD is not null");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdEqualTo(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD =", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdNotEqualTo(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD <>", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdGreaterThan(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD >", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdGreaterThanOrEqualTo(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD >=", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdLessThan(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD <", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdLessThanOrEqualTo(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD <=", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdLike(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD like", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdNotLike(String value) {
            addCriterion("AIRLINE_TWO_CHAR_CD not like", value, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdIn(List<String> values) {
            addCriterion("AIRLINE_TWO_CHAR_CD in", values, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdNotIn(List<String> values) {
            addCriterion("AIRLINE_TWO_CHAR_CD not in", values, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdBetween(String value1, String value2) {
            addCriterion("AIRLINE_TWO_CHAR_CD between", value1, value2, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andAirlineTwoCharCdNotBetween(String value1, String value2) {
            addCriterion("AIRLINE_TWO_CHAR_CD not between", value1, value2, "airlineTwoCharCd");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberIsNull() {
            addCriterion("SEAT_MAX_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberIsNotNull() {
            addCriterion("SEAT_MAX_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberEqualTo(Integer value) {
            addCriterion("SEAT_MAX_NUMBER =", value, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberNotEqualTo(Integer value) {
            addCriterion("SEAT_MAX_NUMBER <>", value, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberGreaterThan(Integer value) {
            addCriterion("SEAT_MAX_NUMBER >", value, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEAT_MAX_NUMBER >=", value, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberLessThan(Integer value) {
            addCriterion("SEAT_MAX_NUMBER <", value, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberLessThanOrEqualTo(Integer value) {
            addCriterion("SEAT_MAX_NUMBER <=", value, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberIn(List<Integer> values) {
            addCriterion("SEAT_MAX_NUMBER in", values, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberNotIn(List<Integer> values) {
            addCriterion("SEAT_MAX_NUMBER not in", values, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberBetween(Integer value1, Integer value2) {
            addCriterion("SEAT_MAX_NUMBER between", value1, value2, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSeatMaxNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SEAT_MAX_NUMBER not between", value1, value2, "seatMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberIsNull() {
            addCriterion("SUPPORT_SEAT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberIsNotNull() {
            addCriterion("SUPPORT_SEAT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberEqualTo(Integer value) {
            addCriterion("SUPPORT_SEAT_NUMBER =", value, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberNotEqualTo(Integer value) {
            addCriterion("SUPPORT_SEAT_NUMBER <>", value, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberGreaterThan(Integer value) {
            addCriterion("SUPPORT_SEAT_NUMBER >", value, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUPPORT_SEAT_NUMBER >=", value, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberLessThan(Integer value) {
            addCriterion("SUPPORT_SEAT_NUMBER <", value, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberLessThanOrEqualTo(Integer value) {
            addCriterion("SUPPORT_SEAT_NUMBER <=", value, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberIn(List<Integer> values) {
            addCriterion("SUPPORT_SEAT_NUMBER in", values, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberNotIn(List<Integer> values) {
            addCriterion("SUPPORT_SEAT_NUMBER not in", values, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberBetween(Integer value1, Integer value2) {
            addCriterion("SUPPORT_SEAT_NUMBER between", value1, value2, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andSupportSeatNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SUPPORT_SEAT_NUMBER not between", value1, value2, "supportSeatNumber");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchIsNull() {
            addCriterion("AIRLINE_BRANCH is null");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchIsNotNull() {
            addCriterion("AIRLINE_BRANCH is not null");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchEqualTo(String value) {
            addCriterion("AIRLINE_BRANCH =", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchNotEqualTo(String value) {
            addCriterion("AIRLINE_BRANCH <>", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchGreaterThan(String value) {
            addCriterion("AIRLINE_BRANCH >", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchGreaterThanOrEqualTo(String value) {
            addCriterion("AIRLINE_BRANCH >=", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchLessThan(String value) {
            addCriterion("AIRLINE_BRANCH <", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchLessThanOrEqualTo(String value) {
            addCriterion("AIRLINE_BRANCH <=", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchLike(String value) {
            addCriterion("AIRLINE_BRANCH like", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchNotLike(String value) {
            addCriterion("AIRLINE_BRANCH not like", value, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchIn(List<String> values) {
            addCriterion("AIRLINE_BRANCH in", values, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchNotIn(List<String> values) {
            addCriterion("AIRLINE_BRANCH not in", values, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchBetween(String value1, String value2) {
            addCriterion("AIRLINE_BRANCH between", value1, value2, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andAirlineBranchNotBetween(String value1, String value2) {
            addCriterion("AIRLINE_BRANCH not between", value1, value2, "airlineBranch");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightIsNull() {
            addCriterion("MAX_TAKEOFF_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightIsNotNull() {
            addCriterion("MAX_TAKEOFF_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightEqualTo(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT =", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightNotEqualTo(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT <>", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightGreaterThan(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT >", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT >=", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightLessThan(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT <", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightLessThanOrEqualTo(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT <=", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightLike(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT like", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightNotLike(String value) {
            addCriterion("MAX_TAKEOFF_WEIGHT not like", value, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightIn(List<String> values) {
            addCriterion("MAX_TAKEOFF_WEIGHT in", values, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightNotIn(List<String> values) {
            addCriterion("MAX_TAKEOFF_WEIGHT not in", values, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightBetween(String value1, String value2) {
            addCriterion("MAX_TAKEOFF_WEIGHT between", value1, value2, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxTakeoffWeightNotBetween(String value1, String value2) {
            addCriterion("MAX_TAKEOFF_WEIGHT not between", value1, value2, "maxTakeoffWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightIsNull() {
            addCriterion("MAX_LOAD_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightIsNotNull() {
            addCriterion("MAX_LOAD_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightEqualTo(String value) {
            addCriterion("MAX_LOAD_WEIGHT =", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightNotEqualTo(String value) {
            addCriterion("MAX_LOAD_WEIGHT <>", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightGreaterThan(String value) {
            addCriterion("MAX_LOAD_WEIGHT >", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_LOAD_WEIGHT >=", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightLessThan(String value) {
            addCriterion("MAX_LOAD_WEIGHT <", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightLessThanOrEqualTo(String value) {
            addCriterion("MAX_LOAD_WEIGHT <=", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightLike(String value) {
            addCriterion("MAX_LOAD_WEIGHT like", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightNotLike(String value) {
            addCriterion("MAX_LOAD_WEIGHT not like", value, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightIn(List<String> values) {
            addCriterion("MAX_LOAD_WEIGHT in", values, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightNotIn(List<String> values) {
            addCriterion("MAX_LOAD_WEIGHT not in", values, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightBetween(String value1, String value2) {
            addCriterion("MAX_LOAD_WEIGHT between", value1, value2, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andMaxLoadWeightNotBetween(String value1, String value2) {
            addCriterion("MAX_LOAD_WEIGHT not between", value1, value2, "maxLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightIsNull() {
            addCriterion("SUPPORT_LOAD_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightIsNotNull() {
            addCriterion("SUPPORT_LOAD_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightEqualTo(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT =", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightNotEqualTo(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT <>", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightGreaterThan(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT >", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT >=", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightLessThan(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT <", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightLessThanOrEqualTo(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT <=", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightLike(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT like", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightNotLike(String value) {
            addCriterion("SUPPORT_LOAD_WEIGHT not like", value, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightIn(List<String> values) {
            addCriterion("SUPPORT_LOAD_WEIGHT in", values, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightNotIn(List<String> values) {
            addCriterion("SUPPORT_LOAD_WEIGHT not in", values, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightBetween(String value1, String value2) {
            addCriterion("SUPPORT_LOAD_WEIGHT between", value1, value2, "supportLoadWeight");
            return (Criteria) this;
        }

        public Criteria andSupportLoadWeightNotBetween(String value1, String value2) {
            addCriterion("SUPPORT_LOAD_WEIGHT not between", value1, value2, "supportLoadWeight");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
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