package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSchedulingNoticeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSchedulingNoticeInfoExample() {
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("TASK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TASK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("TASK_TYPE =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("TASK_TYPE <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("TASK_TYPE >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("TASK_TYPE <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("TASK_TYPE like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("TASK_TYPE not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("TASK_TYPE in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("TASK_TYPE not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("TASK_TYPE between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("TASK_TYPE not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("DEVICE_NO is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("DEVICE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("DEVICE_NO =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("DEVICE_NO <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("DEVICE_NO >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICE_NO >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("DEVICE_NO <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("DEVICE_NO <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("DEVICE_NO like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("DEVICE_NO not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("DEVICE_NO in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("DEVICE_NO not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("DEVICE_NO between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("DEVICE_NO not between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDispatcherIsNull() {
            addCriterion("DISPATCHER is null");
            return (Criteria) this;
        }

        public Criteria andDispatcherIsNotNull() {
            addCriterion("DISPATCHER is not null");
            return (Criteria) this;
        }

        public Criteria andDispatcherEqualTo(String value) {
            addCriterion("DISPATCHER =", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherNotEqualTo(String value) {
            addCriterion("DISPATCHER <>", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherGreaterThan(String value) {
            addCriterion("DISPATCHER >", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherGreaterThanOrEqualTo(String value) {
            addCriterion("DISPATCHER >=", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherLessThan(String value) {
            addCriterion("DISPATCHER <", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherLessThanOrEqualTo(String value) {
            addCriterion("DISPATCHER <=", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherLike(String value) {
            addCriterion("DISPATCHER like", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherNotLike(String value) {
            addCriterion("DISPATCHER not like", value, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherIn(List<String> values) {
            addCriterion("DISPATCHER in", values, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherNotIn(List<String> values) {
            addCriterion("DISPATCHER not in", values, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherBetween(String value1, String value2) {
            addCriterion("DISPATCHER between", value1, value2, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andDispatcherNotBetween(String value1, String value2) {
            addCriterion("DISPATCHER not between", value1, value2, "dispatcher");
            return (Criteria) this;
        }

        public Criteria andExecEmpIsNull() {
            addCriterion("EXEC_EMP is null");
            return (Criteria) this;
        }

        public Criteria andExecEmpIsNotNull() {
            addCriterion("EXEC_EMP is not null");
            return (Criteria) this;
        }

        public Criteria andExecEmpEqualTo(String value) {
            addCriterion("EXEC_EMP =", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpNotEqualTo(String value) {
            addCriterion("EXEC_EMP <>", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpGreaterThan(String value) {
            addCriterion("EXEC_EMP >", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpGreaterThanOrEqualTo(String value) {
            addCriterion("EXEC_EMP >=", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpLessThan(String value) {
            addCriterion("EXEC_EMP <", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpLessThanOrEqualTo(String value) {
            addCriterion("EXEC_EMP <=", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpLike(String value) {
            addCriterion("EXEC_EMP like", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpNotLike(String value) {
            addCriterion("EXEC_EMP not like", value, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpIn(List<String> values) {
            addCriterion("EXEC_EMP in", values, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpNotIn(List<String> values) {
            addCriterion("EXEC_EMP not in", values, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpBetween(String value1, String value2) {
            addCriterion("EXEC_EMP between", value1, value2, "execEmp");
            return (Criteria) this;
        }

        public Criteria andExecEmpNotBetween(String value1, String value2) {
            addCriterion("EXEC_EMP not between", value1, value2, "execEmp");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("MSG is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("MSG is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("MSG =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("MSG <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("MSG >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("MSG >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("MSG <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("MSG <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("MSG like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("MSG not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("MSG in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("MSG not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("MSG between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("MSG not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMsgTimeIsNull() {
            addCriterion("MSG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMsgTimeIsNotNull() {
            addCriterion("MSG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTimeEqualTo(Date value) {
            addCriterion("MSG_TIME =", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotEqualTo(Date value) {
            addCriterion("MSG_TIME <>", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeGreaterThan(Date value) {
            addCriterion("MSG_TIME >", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MSG_TIME >=", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeLessThan(Date value) {
            addCriterion("MSG_TIME <", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeLessThanOrEqualTo(Date value) {
            addCriterion("MSG_TIME <=", value, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeIn(List<Date> values) {
            addCriterion("MSG_TIME in", values, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotIn(List<Date> values) {
            addCriterion("MSG_TIME not in", values, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeBetween(Date value1, Date value2) {
            addCriterion("MSG_TIME between", value1, value2, "msgTime");
            return (Criteria) this;
        }

        public Criteria andMsgTimeNotBetween(Date value1, Date value2) {
            addCriterion("MSG_TIME not between", value1, value2, "msgTime");
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