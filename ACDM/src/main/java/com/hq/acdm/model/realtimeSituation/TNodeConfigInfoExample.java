package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TNodeConfigInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TNodeConfigInfoExample() {
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

        public Criteria andNodeCodeIsNull() {
            addCriterion("NODE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("NODE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("NODE_CODE =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("NODE_CODE <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("NODE_CODE >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_CODE >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("NODE_CODE <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("NODE_CODE <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("NODE_CODE like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("NODE_CODE not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(List<String> values) {
            addCriterion("NODE_CODE in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(List<String> values) {
            addCriterion("NODE_CODE not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("NODE_CODE between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("NODE_CODE not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeSeqIsNull() {
            addCriterion("NODE_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andNodeSeqIsNotNull() {
            addCriterion("NODE_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andNodeSeqEqualTo(Integer value) {
            addCriterion("NODE_SEQ =", value, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqNotEqualTo(Integer value) {
            addCriterion("NODE_SEQ <>", value, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqGreaterThan(Integer value) {
            addCriterion("NODE_SEQ >", value, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("NODE_SEQ >=", value, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqLessThan(Integer value) {
            addCriterion("NODE_SEQ <", value, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqLessThanOrEqualTo(Integer value) {
            addCriterion("NODE_SEQ <=", value, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqIn(List<Integer> values) {
            addCriterion("NODE_SEQ in", values, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqNotIn(List<Integer> values) {
            addCriterion("NODE_SEQ not in", values, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqBetween(Integer value1, Integer value2) {
            addCriterion("NODE_SEQ between", value1, value2, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("NODE_SEQ not between", value1, value2, "nodeSeq");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("NODE_NAME =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("NODE_NAME <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("NODE_NAME >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_NAME >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("NODE_NAME <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("NODE_NAME <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("NODE_NAME like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("NODE_NAME not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("NODE_NAME in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("NODE_NAME not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("NODE_NAME between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("NODE_NAME not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeColumnIsNull() {
            addCriterion("NODE_COLUMN is null");
            return (Criteria) this;
        }

        public Criteria andNodeColumnIsNotNull() {
            addCriterion("NODE_COLUMN is not null");
            return (Criteria) this;
        }

        public Criteria andNodeColumnEqualTo(String value) {
            addCriterion("NODE_COLUMN =", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnNotEqualTo(String value) {
            addCriterion("NODE_COLUMN <>", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnGreaterThan(String value) {
            addCriterion("NODE_COLUMN >", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_COLUMN >=", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnLessThan(String value) {
            addCriterion("NODE_COLUMN <", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnLessThanOrEqualTo(String value) {
            addCriterion("NODE_COLUMN <=", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnLike(String value) {
            addCriterion("NODE_COLUMN like", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnNotLike(String value) {
            addCriterion("NODE_COLUMN not like", value, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnIn(List<String> values) {
            addCriterion("NODE_COLUMN in", values, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnNotIn(List<String> values) {
            addCriterion("NODE_COLUMN not in", values, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnBetween(String value1, String value2) {
            addCriterion("NODE_COLUMN between", value1, value2, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeColumnNotBetween(String value1, String value2) {
            addCriterion("NODE_COLUMN not between", value1, value2, "nodeColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnIsNull() {
            addCriterion("NODE_ESTIMATE_COLUMN is null");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnIsNotNull() {
            addCriterion("NODE_ESTIMATE_COLUMN is not null");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnEqualTo(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN =", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnNotEqualTo(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN <>", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnGreaterThan(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN >", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN >=", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnLessThan(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN <", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnLessThanOrEqualTo(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN <=", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnLike(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN like", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnNotLike(String value) {
            addCriterion("NODE_ESTIMATE_COLUMN not like", value, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnIn(List<String> values) {
            addCriterion("NODE_ESTIMATE_COLUMN in", values, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnNotIn(List<String> values) {
            addCriterion("NODE_ESTIMATE_COLUMN not in", values, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnBetween(String value1, String value2) {
            addCriterion("NODE_ESTIMATE_COLUMN between", value1, value2, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeEstimateColumnNotBetween(String value1, String value2) {
            addCriterion("NODE_ESTIMATE_COLUMN not between", value1, value2, "nodeEstimateColumn");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpIsNull() {
            addCriterion("NODE_SUBEXP is null");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpIsNotNull() {
            addCriterion("NODE_SUBEXP is not null");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpEqualTo(String value) {
            addCriterion("NODE_SUBEXP =", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpNotEqualTo(String value) {
            addCriterion("NODE_SUBEXP <>", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpGreaterThan(String value) {
            addCriterion("NODE_SUBEXP >", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_SUBEXP >=", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpLessThan(String value) {
            addCriterion("NODE_SUBEXP <", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpLessThanOrEqualTo(String value) {
            addCriterion("NODE_SUBEXP <=", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpLike(String value) {
            addCriterion("NODE_SUBEXP like", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpNotLike(String value) {
            addCriterion("NODE_SUBEXP not like", value, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpIn(List<String> values) {
            addCriterion("NODE_SUBEXP in", values, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpNotIn(List<String> values) {
            addCriterion("NODE_SUBEXP not in", values, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpBetween(String value1, String value2) {
            addCriterion("NODE_SUBEXP between", value1, value2, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andNodeSubexpNotBetween(String value1, String value2) {
            addCriterion("NODE_SUBEXP not between", value1, value2, "nodeSubexp");
            return (Criteria) this;
        }

        public Criteria andIsavailablIsNull() {
            addCriterion("ISAVAILABL is null");
            return (Criteria) this;
        }

        public Criteria andIsavailablIsNotNull() {
            addCriterion("ISAVAILABL is not null");
            return (Criteria) this;
        }

        public Criteria andIsavailablEqualTo(Integer value) {
            addCriterion("ISAVAILABL =", value, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablNotEqualTo(Integer value) {
            addCriterion("ISAVAILABL <>", value, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablGreaterThan(Integer value) {
            addCriterion("ISAVAILABL >", value, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISAVAILABL >=", value, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablLessThan(Integer value) {
            addCriterion("ISAVAILABL <", value, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablLessThanOrEqualTo(Integer value) {
            addCriterion("ISAVAILABL <=", value, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablIn(List<Integer> values) {
            addCriterion("ISAVAILABL in", values, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablNotIn(List<Integer> values) {
            addCriterion("ISAVAILABL not in", values, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablBetween(Integer value1, Integer value2) {
            addCriterion("ISAVAILABL between", value1, value2, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsavailablNotBetween(Integer value1, Integer value2) {
            addCriterion("ISAVAILABL not between", value1, value2, "isavailabl");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryIsNull() {
            addCriterion("ISNECESSARY is null");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryIsNotNull() {
            addCriterion("ISNECESSARY is not null");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryEqualTo(Integer value) {
            addCriterion("ISNECESSARY =", value, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryNotEqualTo(Integer value) {
            addCriterion("ISNECESSARY <>", value, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryGreaterThan(Integer value) {
            addCriterion("ISNECESSARY >", value, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISNECESSARY >=", value, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryLessThan(Integer value) {
            addCriterion("ISNECESSARY <", value, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryLessThanOrEqualTo(Integer value) {
            addCriterion("ISNECESSARY <=", value, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryIn(List<Integer> values) {
            addCriterion("ISNECESSARY in", values, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryNotIn(List<Integer> values) {
            addCriterion("ISNECESSARY not in", values, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryBetween(Integer value1, Integer value2) {
            addCriterion("ISNECESSARY between", value1, value2, "isnecessary");
            return (Criteria) this;
        }

        public Criteria andIsnecessaryNotBetween(Integer value1, Integer value2) {
            addCriterion("ISNECESSARY not between", value1, value2, "isnecessary");
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