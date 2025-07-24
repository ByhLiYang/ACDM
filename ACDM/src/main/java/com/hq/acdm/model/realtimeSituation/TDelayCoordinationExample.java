package com.hq.acdm.model.realtimeSituation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TDelayCoordinationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDelayCoordinationExample() {
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

        public Criteria andYwljIsNull() {
            addCriterion("YWLJ is null");
            return (Criteria) this;
        }

        public Criteria andYwljIsNotNull() {
            addCriterion("YWLJ is not null");
            return (Criteria) this;
        }

        public Criteria andYwljEqualTo(Date value) {
            addCriterion("YWLJ =", value, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljNotEqualTo(Date value) {
            addCriterion("YWLJ <>", value, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljGreaterThan(Date value) {
            addCriterion("YWLJ >", value, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljGreaterThanOrEqualTo(Date value) {
            addCriterion("YWLJ >=", value, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljLessThan(Date value) {
            addCriterion("YWLJ <", value, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljLessThanOrEqualTo(Date value) {
            addCriterion("YWLJ <=", value, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljIn(List<Date> values) {
            addCriterion("YWLJ in", values, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljNotIn(List<Date> values) {
            addCriterion("YWLJ not in", values, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljBetween(Date value1, Date value2) {
            addCriterion("YWLJ between", value1, value2, "ywlj");
            return (Criteria) this;
        }

        public Criteria andYwljNotBetween(Date value1, Date value2) {
            addCriterion("YWLJ not between", value1, value2, "ywlj");
            return (Criteria) this;
        }

        public Criteria andFxljIsNull() {
            addCriterion("FXLJ is null");
            return (Criteria) this;
        }

        public Criteria andFxljIsNotNull() {
            addCriterion("FXLJ is not null");
            return (Criteria) this;
        }

        public Criteria andFxljEqualTo(Date value) {
            addCriterion("FXLJ =", value, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljNotEqualTo(Date value) {
            addCriterion("FXLJ <>", value, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljGreaterThan(Date value) {
            addCriterion("FXLJ >", value, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljGreaterThanOrEqualTo(Date value) {
            addCriterion("FXLJ >=", value, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljLessThan(Date value) {
            addCriterion("FXLJ <", value, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljLessThanOrEqualTo(Date value) {
            addCriterion("FXLJ <=", value, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljIn(List<Date> values) {
            addCriterion("FXLJ in", values, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljNotIn(List<Date> values) {
            addCriterion("FXLJ not in", values, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljBetween(Date value1, Date value2) {
            addCriterion("FXLJ between", value1, value2, "fxlj");
            return (Criteria) this;
        }

        public Criteria andFxljNotBetween(Date value1, Date value2) {
            addCriterion("FXLJ not between", value1, value2, "fxlj");
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

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("PRIORITY like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("PRIORITY not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
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