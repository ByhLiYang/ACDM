package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDynAirBridgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDynAirBridgeExample() {
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

        public Criteria andAirBridgeCd1IsNull() {
            addCriterion("AIR_BRIDGE_CD_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1IsNotNull() {
            addCriterion("AIR_BRIDGE_CD_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1EqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_1 =", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1NotEqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_1 <>", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1GreaterThan(String value) {
            addCriterion("AIR_BRIDGE_CD_1 >", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1GreaterThanOrEqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_1 >=", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1LessThan(String value) {
            addCriterion("AIR_BRIDGE_CD_1 <", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1LessThanOrEqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_1 <=", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1Like(String value) {
            addCriterion("AIR_BRIDGE_CD_1 like", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1NotLike(String value) {
            addCriterion("AIR_BRIDGE_CD_1 not like", value, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1In(List<String> values) {
            addCriterion("AIR_BRIDGE_CD_1 in", values, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1NotIn(List<String> values) {
            addCriterion("AIR_BRIDGE_CD_1 not in", values, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1Between(String value1, String value2) {
            addCriterion("AIR_BRIDGE_CD_1 between", value1, value2, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd1NotBetween(String value1, String value2) {
            addCriterion("AIR_BRIDGE_CD_1 not between", value1, value2, "airBridgeCd1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1IsNull() {
            addCriterion("AIR_BRIDGE_START_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1IsNotNull() {
            addCriterion("AIR_BRIDGE_START_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1EqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_1 =", value, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1NotEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_1 <>", value, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1GreaterThan(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_1 >", value, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_1 >=", value, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1LessThan(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_1 <", value, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1LessThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_1 <=", value, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1In(List<Date> values) {
            addCriterion("AIR_BRIDGE_START_TIME_1 in", values, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1NotIn(List<Date> values) {
            addCriterion("AIR_BRIDGE_START_TIME_1 not in", values, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1Between(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_START_TIME_1 between", value1, value2, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime1NotBetween(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_START_TIME_1 not between", value1, value2, "airBridgeStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1IsNull() {
            addCriterion("AIR_BRIDGE_END_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1IsNotNull() {
            addCriterion("AIR_BRIDGE_END_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1EqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_1 =", value, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1NotEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_1 <>", value, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1GreaterThan(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_1 >", value, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_1 >=", value, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1LessThan(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_1 <", value, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1LessThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_1 <=", value, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1In(List<Date> values) {
            addCriterion("AIR_BRIDGE_END_TIME_1 in", values, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1NotIn(List<Date> values) {
            addCriterion("AIR_BRIDGE_END_TIME_1 not in", values, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1Between(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_END_TIME_1 between", value1, value2, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime1NotBetween(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_END_TIME_1 not between", value1, value2, "airBridgeEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1IsNull() {
            addCriterion("AIR_BRIDGE_DURATION_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1IsNotNull() {
            addCriterion("AIR_BRIDGE_DURATION_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1EqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_1 =", value, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1NotEqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_1 <>", value, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1GreaterThan(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_1 >", value, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1GreaterThanOrEqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_1 >=", value, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1LessThan(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_1 <", value, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1LessThanOrEqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_1 <=", value, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1In(List<Integer> values) {
            addCriterion("AIR_BRIDGE_DURATION_1 in", values, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1NotIn(List<Integer> values) {
            addCriterion("AIR_BRIDGE_DURATION_1 not in", values, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1Between(Integer value1, Integer value2) {
            addCriterion("AIR_BRIDGE_DURATION_1 between", value1, value2, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration1NotBetween(Integer value1, Integer value2) {
            addCriterion("AIR_BRIDGE_DURATION_1 not between", value1, value2, "airBridgeDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1IsNull() {
            addCriterion("POWER_SUPPLY_START_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1IsNotNull() {
            addCriterion("POWER_SUPPLY_START_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1EqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_1 =", value, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1NotEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_1 <>", value, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1GreaterThan(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_1 >", value, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_1 >=", value, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1LessThan(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_1 <", value, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1LessThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_1 <=", value, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1In(List<Date> values) {
            addCriterion("POWER_SUPPLY_START_TIME_1 in", values, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1NotIn(List<Date> values) {
            addCriterion("POWER_SUPPLY_START_TIME_1 not in", values, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1Between(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_START_TIME_1 between", value1, value2, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime1NotBetween(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_START_TIME_1 not between", value1, value2, "powerSupplyStartTime1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1IsNull() {
            addCriterion("POWER_SUPPLY_END_TIMR_1 is null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1IsNotNull() {
            addCriterion("POWER_SUPPLY_END_TIMR_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1EqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 =", value, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1NotEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 <>", value, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1GreaterThan(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 >", value, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1GreaterThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 >=", value, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1LessThan(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 <", value, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1LessThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 <=", value, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1In(List<Date> values) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 in", values, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1NotIn(List<Date> values) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 not in", values, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1Between(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 between", value1, value2, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr1NotBetween(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_END_TIMR_1 not between", value1, value2, "powerSupplyEndTimr1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1IsNull() {
            addCriterion("POWER_SUPPLY_DURATION_1 is null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1IsNotNull() {
            addCriterion("POWER_SUPPLY_DURATION_1 is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1EqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_1 =", value, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1NotEqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_1 <>", value, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1GreaterThan(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_1 >", value, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1GreaterThanOrEqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_1 >=", value, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1LessThan(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_1 <", value, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1LessThanOrEqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_1 <=", value, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1In(List<Integer> values) {
            addCriterion("POWER_SUPPLY_DURATION_1 in", values, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1NotIn(List<Integer> values) {
            addCriterion("POWER_SUPPLY_DURATION_1 not in", values, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1Between(Integer value1, Integer value2) {
            addCriterion("POWER_SUPPLY_DURATION_1 between", value1, value2, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration1NotBetween(Integer value1, Integer value2) {
            addCriterion("POWER_SUPPLY_DURATION_1 not between", value1, value2, "powerSupplyDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1IsNull() {
            addCriterion("AIR_CONDITIONING_START_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1IsNotNull() {
            addCriterion("AIR_CONDITIONING_START_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1EqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 =", value, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1NotEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 <>", value, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1GreaterThan(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 >", value, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 >=", value, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1LessThan(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 <", value, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1LessThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 <=", value, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1In(List<Date> values) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 in", values, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1NotIn(List<Date> values) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 not in", values, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1Between(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 between", value1, value2, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime1NotBetween(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_START_TIME_1 not between", value1, value2, "airConditioningStartTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1IsNull() {
            addCriterion("AIR_CONDITIONING_END_TIME_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1IsNotNull() {
            addCriterion("AIR_CONDITIONING_END_TIME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1EqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 =", value, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1NotEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 <>", value, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1GreaterThan(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 >", value, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 >=", value, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1LessThan(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 <", value, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1LessThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 <=", value, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1In(List<Date> values) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 in", values, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1NotIn(List<Date> values) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 not in", values, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1Between(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 between", value1, value2, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime1NotBetween(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_END_TIME_1 not between", value1, value2, "airConditioningEndTime1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1IsNull() {
            addCriterion("AIR_CONDITIONING_DURATION_1 is null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1IsNotNull() {
            addCriterion("AIR_CONDITIONING_DURATION_1 is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1EqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_1 =", value, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1NotEqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_1 <>", value, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1GreaterThan(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_1 >", value, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1GreaterThanOrEqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_1 >=", value, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1LessThan(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_1 <", value, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1LessThanOrEqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_1 <=", value, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1In(List<Integer> values) {
            addCriterion("AIR_CONDITIONING_DURATION_1 in", values, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1NotIn(List<Integer> values) {
            addCriterion("AIR_CONDITIONING_DURATION_1 not in", values, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1Between(Integer value1, Integer value2) {
            addCriterion("AIR_CONDITIONING_DURATION_1 between", value1, value2, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration1NotBetween(Integer value1, Integer value2) {
            addCriterion("AIR_CONDITIONING_DURATION_1 not between", value1, value2, "airConditioningDuration1");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2IsNull() {
            addCriterion("AIR_BRIDGE_CD_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2IsNotNull() {
            addCriterion("AIR_BRIDGE_CD_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2EqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_2 =", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2NotEqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_2 <>", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2GreaterThan(String value) {
            addCriterion("AIR_BRIDGE_CD_2 >", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2GreaterThanOrEqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_2 >=", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2LessThan(String value) {
            addCriterion("AIR_BRIDGE_CD_2 <", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2LessThanOrEqualTo(String value) {
            addCriterion("AIR_BRIDGE_CD_2 <=", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2Like(String value) {
            addCriterion("AIR_BRIDGE_CD_2 like", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2NotLike(String value) {
            addCriterion("AIR_BRIDGE_CD_2 not like", value, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2In(List<String> values) {
            addCriterion("AIR_BRIDGE_CD_2 in", values, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2NotIn(List<String> values) {
            addCriterion("AIR_BRIDGE_CD_2 not in", values, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2Between(String value1, String value2) {
            addCriterion("AIR_BRIDGE_CD_2 between", value1, value2, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeCd2NotBetween(String value1, String value2) {
            addCriterion("AIR_BRIDGE_CD_2 not between", value1, value2, "airBridgeCd2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2IsNull() {
            addCriterion("AIR_BRIDGE_START_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2IsNotNull() {
            addCriterion("AIR_BRIDGE_START_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2EqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_2 =", value, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2NotEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_2 <>", value, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2GreaterThan(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_2 >", value, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_2 >=", value, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2LessThan(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_2 <", value, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2LessThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_START_TIME_2 <=", value, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2In(List<Date> values) {
            addCriterion("AIR_BRIDGE_START_TIME_2 in", values, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2NotIn(List<Date> values) {
            addCriterion("AIR_BRIDGE_START_TIME_2 not in", values, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2Between(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_START_TIME_2 between", value1, value2, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeStartTime2NotBetween(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_START_TIME_2 not between", value1, value2, "airBridgeStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2IsNull() {
            addCriterion("AIR_BRIDGE_END_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2IsNotNull() {
            addCriterion("AIR_BRIDGE_END_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2EqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_2 =", value, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2NotEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_2 <>", value, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2GreaterThan(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_2 >", value, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_2 >=", value, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2LessThan(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_2 <", value, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2LessThanOrEqualTo(Date value) {
            addCriterion("AIR_BRIDGE_END_TIME_2 <=", value, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2In(List<Date> values) {
            addCriterion("AIR_BRIDGE_END_TIME_2 in", values, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2NotIn(List<Date> values) {
            addCriterion("AIR_BRIDGE_END_TIME_2 not in", values, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2Between(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_END_TIME_2 between", value1, value2, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeEndTime2NotBetween(Date value1, Date value2) {
            addCriterion("AIR_BRIDGE_END_TIME_2 not between", value1, value2, "airBridgeEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2IsNull() {
            addCriterion("AIR_BRIDGE_DURATION_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2IsNotNull() {
            addCriterion("AIR_BRIDGE_DURATION_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2EqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_2 =", value, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2NotEqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_2 <>", value, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2GreaterThan(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_2 >", value, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2GreaterThanOrEqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_2 >=", value, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2LessThan(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_2 <", value, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2LessThanOrEqualTo(Integer value) {
            addCriterion("AIR_BRIDGE_DURATION_2 <=", value, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2In(List<Integer> values) {
            addCriterion("AIR_BRIDGE_DURATION_2 in", values, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2NotIn(List<Integer> values) {
            addCriterion("AIR_BRIDGE_DURATION_2 not in", values, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2Between(Integer value1, Integer value2) {
            addCriterion("AIR_BRIDGE_DURATION_2 between", value1, value2, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andAirBridgeDuration2NotBetween(Integer value1, Integer value2) {
            addCriterion("AIR_BRIDGE_DURATION_2 not between", value1, value2, "airBridgeDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2IsNull() {
            addCriterion("POWER_SUPPLY_START_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2IsNotNull() {
            addCriterion("POWER_SUPPLY_START_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2EqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_2 =", value, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2NotEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_2 <>", value, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2GreaterThan(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_2 >", value, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_2 >=", value, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2LessThan(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_2 <", value, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2LessThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_START_TIME_2 <=", value, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2In(List<Date> values) {
            addCriterion("POWER_SUPPLY_START_TIME_2 in", values, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2NotIn(List<Date> values) {
            addCriterion("POWER_SUPPLY_START_TIME_2 not in", values, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2Between(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_START_TIME_2 between", value1, value2, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyStartTime2NotBetween(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_START_TIME_2 not between", value1, value2, "powerSupplyStartTime2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2IsNull() {
            addCriterion("POWER_SUPPLY_END_TIMR_2 is null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2IsNotNull() {
            addCriterion("POWER_SUPPLY_END_TIMR_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2EqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 =", value, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2NotEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 <>", value, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2GreaterThan(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 >", value, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2GreaterThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 >=", value, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2LessThan(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 <", value, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2LessThanOrEqualTo(Date value) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 <=", value, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2In(List<Date> values) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 in", values, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2NotIn(List<Date> values) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 not in", values, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2Between(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 between", value1, value2, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyEndTimr2NotBetween(Date value1, Date value2) {
            addCriterion("POWER_SUPPLY_END_TIMR_2 not between", value1, value2, "powerSupplyEndTimr2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2IsNull() {
            addCriterion("POWER_SUPPLY_DURATION_2 is null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2IsNotNull() {
            addCriterion("POWER_SUPPLY_DURATION_2 is not null");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2EqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_2 =", value, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2NotEqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_2 <>", value, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2GreaterThan(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_2 >", value, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2GreaterThanOrEqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_2 >=", value, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2LessThan(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_2 <", value, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2LessThanOrEqualTo(Integer value) {
            addCriterion("POWER_SUPPLY_DURATION_2 <=", value, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2In(List<Integer> values) {
            addCriterion("POWER_SUPPLY_DURATION_2 in", values, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2NotIn(List<Integer> values) {
            addCriterion("POWER_SUPPLY_DURATION_2 not in", values, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2Between(Integer value1, Integer value2) {
            addCriterion("POWER_SUPPLY_DURATION_2 between", value1, value2, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andPowerSupplyDuration2NotBetween(Integer value1, Integer value2) {
            addCriterion("POWER_SUPPLY_DURATION_2 not between", value1, value2, "powerSupplyDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2IsNull() {
            addCriterion("AIR_CONDITIONING_START_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2IsNotNull() {
            addCriterion("AIR_CONDITIONING_START_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2EqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 =", value, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2NotEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 <>", value, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2GreaterThan(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 >", value, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 >=", value, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2LessThan(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 <", value, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2LessThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 <=", value, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2In(List<Date> values) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 in", values, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2NotIn(List<Date> values) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 not in", values, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2Between(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 between", value1, value2, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningStartTime2NotBetween(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_START_TIME_2 not between", value1, value2, "airConditioningStartTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2IsNull() {
            addCriterion("AIR_CONDITIONING_END_TIME_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2IsNotNull() {
            addCriterion("AIR_CONDITIONING_END_TIME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2EqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 =", value, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2NotEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 <>", value, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2GreaterThan(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 >", value, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 >=", value, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2LessThan(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 <", value, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2LessThanOrEqualTo(Date value) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 <=", value, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2In(List<Date> values) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 in", values, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2NotIn(List<Date> values) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 not in", values, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2Between(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 between", value1, value2, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningEndTime2NotBetween(Date value1, Date value2) {
            addCriterion("AIR_CONDITIONING_END_TIME_2 not between", value1, value2, "airConditioningEndTime2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2IsNull() {
            addCriterion("AIR_CONDITIONING_DURATION_2 is null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2IsNotNull() {
            addCriterion("AIR_CONDITIONING_DURATION_2 is not null");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2EqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_2 =", value, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2NotEqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_2 <>", value, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2GreaterThan(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_2 >", value, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2GreaterThanOrEqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_2 >=", value, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2LessThan(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_2 <", value, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2LessThanOrEqualTo(Integer value) {
            addCriterion("AIR_CONDITIONING_DURATION_2 <=", value, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2In(List<Integer> values) {
            addCriterion("AIR_CONDITIONING_DURATION_2 in", values, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2NotIn(List<Integer> values) {
            addCriterion("AIR_CONDITIONING_DURATION_2 not in", values, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2Between(Integer value1, Integer value2) {
            addCriterion("AIR_CONDITIONING_DURATION_2 between", value1, value2, "airConditioningDuration2");
            return (Criteria) this;
        }

        public Criteria andAirConditioningDuration2NotBetween(Integer value1, Integer value2) {
            addCriterion("AIR_CONDITIONING_DURATION_2 not between", value1, value2, "airConditioningDuration2");
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