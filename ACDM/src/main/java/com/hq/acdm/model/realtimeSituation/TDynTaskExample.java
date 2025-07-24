package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDynTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDynTaskExample() {
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

        public Criteria andTaskCodeIsNull() {
            addCriterion("TASK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIsNotNull() {
            addCriterion("TASK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCodeEqualTo(String value) {
            addCriterion("TASK_CODE =", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotEqualTo(String value) {
            addCriterion("TASK_CODE <>", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThan(String value) {
            addCriterion("TASK_CODE >", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_CODE >=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThan(String value) {
            addCriterion("TASK_CODE <", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLessThanOrEqualTo(String value) {
            addCriterion("TASK_CODE <=", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeLike(String value) {
            addCriterion("TASK_CODE like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotLike(String value) {
            addCriterion("TASK_CODE not like", value, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeIn(List<String> values) {
            addCriterion("TASK_CODE in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotIn(List<String> values) {
            addCriterion("TASK_CODE not in", values, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeBetween(String value1, String value2) {
            addCriterion("TASK_CODE between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskCodeNotBetween(String value1, String value2) {
            addCriterion("TASK_CODE not between", value1, value2, "taskCode");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("TASK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("TASK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("TASK_NAME =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("TASK_NAME <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("TASK_NAME >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_NAME >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("TASK_NAME <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("TASK_NAME <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("TASK_NAME like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("TASK_NAME not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("TASK_NAME in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("TASK_NAME not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("TASK_NAME between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("TASK_NAME not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("TASK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("TASK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("TASK_STATUS =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("TASK_STATUS <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("TASK_STATUS >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATUS >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("TASK_STATUS <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATUS <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("TASK_STATUS in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("TASK_STATUS not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATUS between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATUS not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskEstmIsNull() {
            addCriterion("TASK_ESTM is null");
            return (Criteria) this;
        }

        public Criteria andTaskEstmIsNotNull() {
            addCriterion("TASK_ESTM is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEstmEqualTo(Date value) {
            addCriterion("TASK_ESTM =", value, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmNotEqualTo(Date value) {
            addCriterion("TASK_ESTM <>", value, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmGreaterThan(Date value) {
            addCriterion("TASK_ESTM >", value, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_ESTM >=", value, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmLessThan(Date value) {
            addCriterion("TASK_ESTM <", value, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmLessThanOrEqualTo(Date value) {
            addCriterion("TASK_ESTM <=", value, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmIn(List<Date> values) {
            addCriterion("TASK_ESTM in", values, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmNotIn(List<Date> values) {
            addCriterion("TASK_ESTM not in", values, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmBetween(Date value1, Date value2) {
            addCriterion("TASK_ESTM between", value1, value2, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskEstmNotBetween(Date value1, Date value2) {
            addCriterion("TASK_ESTM not between", value1, value2, "taskEstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmIsNull() {
            addCriterion("TASK_ASTM is null");
            return (Criteria) this;
        }

        public Criteria andTaskAstmIsNotNull() {
            addCriterion("TASK_ASTM is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAstmEqualTo(Date value) {
            addCriterion("TASK_ASTM =", value, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmNotEqualTo(Date value) {
            addCriterion("TASK_ASTM <>", value, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmGreaterThan(Date value) {
            addCriterion("TASK_ASTM >", value, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_ASTM >=", value, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmLessThan(Date value) {
            addCriterion("TASK_ASTM <", value, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmLessThanOrEqualTo(Date value) {
            addCriterion("TASK_ASTM <=", value, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmIn(List<Date> values) {
            addCriterion("TASK_ASTM in", values, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmNotIn(List<Date> values) {
            addCriterion("TASK_ASTM not in", values, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmBetween(Date value1, Date value2) {
            addCriterion("TASK_ASTM between", value1, value2, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskAstmNotBetween(Date value1, Date value2) {
            addCriterion("TASK_ASTM not between", value1, value2, "taskAstm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmIsNull() {
            addCriterion("TASK_EETM is null");
            return (Criteria) this;
        }

        public Criteria andTaskEetmIsNotNull() {
            addCriterion("TASK_EETM is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEetmEqualTo(Date value) {
            addCriterion("TASK_EETM =", value, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmNotEqualTo(Date value) {
            addCriterion("TASK_EETM <>", value, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmGreaterThan(Date value) {
            addCriterion("TASK_EETM >", value, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_EETM >=", value, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmLessThan(Date value) {
            addCriterion("TASK_EETM <", value, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmLessThanOrEqualTo(Date value) {
            addCriterion("TASK_EETM <=", value, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmIn(List<Date> values) {
            addCriterion("TASK_EETM in", values, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmNotIn(List<Date> values) {
            addCriterion("TASK_EETM not in", values, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmBetween(Date value1, Date value2) {
            addCriterion("TASK_EETM between", value1, value2, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskEetmNotBetween(Date value1, Date value2) {
            addCriterion("TASK_EETM not between", value1, value2, "taskEetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmIsNull() {
            addCriterion("TASK_AETM is null");
            return (Criteria) this;
        }

        public Criteria andTaskAetmIsNotNull() {
            addCriterion("TASK_AETM is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAetmEqualTo(Date value) {
            addCriterion("TASK_AETM =", value, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmNotEqualTo(Date value) {
            addCriterion("TASK_AETM <>", value, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmGreaterThan(Date value) {
            addCriterion("TASK_AETM >", value, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_AETM >=", value, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmLessThan(Date value) {
            addCriterion("TASK_AETM <", value, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmLessThanOrEqualTo(Date value) {
            addCriterion("TASK_AETM <=", value, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmIn(List<Date> values) {
            addCriterion("TASK_AETM in", values, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmNotIn(List<Date> values) {
            addCriterion("TASK_AETM not in", values, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmBetween(Date value1, Date value2) {
            addCriterion("TASK_AETM between", value1, value2, "taskAetm");
            return (Criteria) this;
        }

        public Criteria andTaskAetmNotBetween(Date value1, Date value2) {
            addCriterion("TASK_AETM not between", value1, value2, "taskAetm");
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