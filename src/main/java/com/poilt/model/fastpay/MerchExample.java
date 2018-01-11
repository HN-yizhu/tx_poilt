package com.poilt.model.fastpay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMerNameIsNull() {
            addCriterion("mer_name is null");
            return (Criteria) this;
        }

        public Criteria andMerNameIsNotNull() {
            addCriterion("mer_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerNameEqualTo(String value) {
            addCriterion("mer_name =", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotEqualTo(String value) {
            addCriterion("mer_name <>", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameGreaterThan(String value) {
            addCriterion("mer_name >", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameGreaterThanOrEqualTo(String value) {
            addCriterion("mer_name >=", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameLessThan(String value) {
            addCriterion("mer_name <", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameLessThanOrEqualTo(String value) {
            addCriterion("mer_name <=", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameLike(String value) {
            addCriterion("mer_name like", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotLike(String value) {
            addCriterion("mer_name not like", value, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameIn(List<String> values) {
            addCriterion("mer_name in", values, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotIn(List<String> values) {
            addCriterion("mer_name not in", values, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameBetween(String value1, String value2) {
            addCriterion("mer_name between", value1, value2, "merName");
            return (Criteria) this;
        }

        public Criteria andMerNameNotBetween(String value1, String value2) {
            addCriterion("mer_name not between", value1, value2, "merName");
            return (Criteria) this;
        }

        public Criteria andMerAbbrIsNull() {
            addCriterion("mer_abbr is null");
            return (Criteria) this;
        }

        public Criteria andMerAbbrIsNotNull() {
            addCriterion("mer_abbr is not null");
            return (Criteria) this;
        }

        public Criteria andMerAbbrEqualTo(String value) {
            addCriterion("mer_abbr =", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrNotEqualTo(String value) {
            addCriterion("mer_abbr <>", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrGreaterThan(String value) {
            addCriterion("mer_abbr >", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("mer_abbr >=", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrLessThan(String value) {
            addCriterion("mer_abbr <", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrLessThanOrEqualTo(String value) {
            addCriterion("mer_abbr <=", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrLike(String value) {
            addCriterion("mer_abbr like", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrNotLike(String value) {
            addCriterion("mer_abbr not like", value, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrIn(List<String> values) {
            addCriterion("mer_abbr in", values, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrNotIn(List<String> values) {
            addCriterion("mer_abbr not in", values, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrBetween(String value1, String value2) {
            addCriterion("mer_abbr between", value1, value2, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andMerAbbrNotBetween(String value1, String value2) {
            addCriterion("mer_abbr not between", value1, value2, "merAbbr");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNull() {
            addCriterion("id_card_no is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIsNotNull() {
            addCriterion("id_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNoEqualTo(String value) {
            addCriterion("id_card_no =", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotEqualTo(String value) {
            addCriterion("id_card_no <>", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThan(String value) {
            addCriterion("id_card_no >", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_no >=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThan(String value) {
            addCriterion("id_card_no <", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLessThanOrEqualTo(String value) {
            addCriterion("id_card_no <=", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoLike(String value) {
            addCriterion("id_card_no like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotLike(String value) {
            addCriterion("id_card_no not like", value, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoIn(List<String> values) {
            addCriterion("id_card_no in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotIn(List<String> values) {
            addCriterion("id_card_no not in", values, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoBetween(String value1, String value2) {
            addCriterion("id_card_no between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andIdCardNoNotBetween(String value1, String value2) {
            addCriterion("id_card_no not between", value1, value2, "idCardNo");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNull() {
            addCriterion("credit_rate is null");
            return (Criteria) this;
        }

        public Criteria andCreditRateIsNotNull() {
            addCriterion("credit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCreditRateEqualTo(String value) {
            addCriterion("credit_rate =", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotEqualTo(String value) {
            addCriterion("credit_rate <>", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThan(String value) {
            addCriterion("credit_rate >", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateGreaterThanOrEqualTo(String value) {
            addCriterion("credit_rate >=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThan(String value) {
            addCriterion("credit_rate <", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLessThanOrEqualTo(String value) {
            addCriterion("credit_rate <=", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateLike(String value) {
            addCriterion("credit_rate like", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotLike(String value) {
            addCriterion("credit_rate not like", value, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateIn(List<String> values) {
            addCriterion("credit_rate in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotIn(List<String> values) {
            addCriterion("credit_rate not in", values, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateBetween(String value1, String value2) {
            addCriterion("credit_rate between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andCreditRateNotBetween(String value1, String value2) {
            addCriterion("credit_rate not between", value1, value2, "creditRate");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalIsNull() {
            addCriterion("history_total is null");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalIsNotNull() {
            addCriterion("history_total is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalEqualTo(Integer value) {
            addCriterion("history_total =", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalNotEqualTo(Integer value) {
            addCriterion("history_total <>", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalGreaterThan(Integer value) {
            addCriterion("history_total >", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_total >=", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalLessThan(Integer value) {
            addCriterion("history_total <", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalLessThanOrEqualTo(Integer value) {
            addCriterion("history_total <=", value, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalIn(List<Integer> values) {
            addCriterion("history_total in", values, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalNotIn(List<Integer> values) {
            addCriterion("history_total not in", values, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalBetween(Integer value1, Integer value2) {
            addCriterion("history_total between", value1, value2, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andHistoryTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("history_total not between", value1, value2, "historyTotal");
            return (Criteria) this;
        }

        public Criteria andCreditFeeIsNull() {
            addCriterion("credit_fee is null");
            return (Criteria) this;
        }

        public Criteria andCreditFeeIsNotNull() {
            addCriterion("credit_fee is not null");
            return (Criteria) this;
        }

        public Criteria andCreditFeeEqualTo(Integer value) {
            addCriterion("credit_fee =", value, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeNotEqualTo(Integer value) {
            addCriterion("credit_fee <>", value, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeGreaterThan(Integer value) {
            addCriterion("credit_fee >", value, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_fee >=", value, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeLessThan(Integer value) {
            addCriterion("credit_fee <", value, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeLessThanOrEqualTo(Integer value) {
            addCriterion("credit_fee <=", value, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeIn(List<Integer> values) {
            addCriterion("credit_fee in", values, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeNotIn(List<Integer> values) {
            addCriterion("credit_fee not in", values, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeBetween(Integer value1, Integer value2) {
            addCriterion("credit_fee between", value1, value2, "creditFee");
            return (Criteria) this;
        }

        public Criteria andCreditFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_fee not between", value1, value2, "creditFee");
            return (Criteria) this;
        }

        public Criteria andReferrerIsNull() {
            addCriterion("referrer is null");
            return (Criteria) this;
        }

        public Criteria andReferrerIsNotNull() {
            addCriterion("referrer is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerEqualTo(String value) {
            addCriterion("referrer =", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotEqualTo(String value) {
            addCriterion("referrer <>", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerGreaterThan(String value) {
            addCriterion("referrer >", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerGreaterThanOrEqualTo(String value) {
            addCriterion("referrer >=", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLessThan(String value) {
            addCriterion("referrer <", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLessThanOrEqualTo(String value) {
            addCriterion("referrer <=", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLike(String value) {
            addCriterion("referrer like", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotLike(String value) {
            addCriterion("referrer not like", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerIn(List<String> values) {
            addCriterion("referrer in", values, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotIn(List<String> values) {
            addCriterion("referrer not in", values, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerBetween(String value1, String value2) {
            addCriterion("referrer between", value1, value2, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotBetween(String value1, String value2) {
            addCriterion("referrer not between", value1, value2, "referrer");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andMerUuidIsNull() {
            addCriterion("mer_uuid is null");
            return (Criteria) this;
        }

        public Criteria andMerUuidIsNotNull() {
            addCriterion("mer_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andMerUuidEqualTo(String value) {
            addCriterion("mer_uuid =", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidNotEqualTo(String value) {
            addCriterion("mer_uuid <>", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidGreaterThan(String value) {
            addCriterion("mer_uuid >", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidGreaterThanOrEqualTo(String value) {
            addCriterion("mer_uuid >=", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidLessThan(String value) {
            addCriterion("mer_uuid <", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidLessThanOrEqualTo(String value) {
            addCriterion("mer_uuid <=", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidLike(String value) {
            addCriterion("mer_uuid like", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidNotLike(String value) {
            addCriterion("mer_uuid not like", value, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidIn(List<String> values) {
            addCriterion("mer_uuid in", values, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidNotIn(List<String> values) {
            addCriterion("mer_uuid not in", values, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidBetween(String value1, String value2) {
            addCriterion("mer_uuid between", value1, value2, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerUuidNotBetween(String value1, String value2) {
            addCriterion("mer_uuid not between", value1, value2, "merUuid");
            return (Criteria) this;
        }

        public Criteria andMerNoIsNull() {
            addCriterion("mer_no is null");
            return (Criteria) this;
        }

        public Criteria andMerNoIsNotNull() {
            addCriterion("mer_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerNoEqualTo(String value) {
            addCriterion("mer_no =", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotEqualTo(String value) {
            addCriterion("mer_no <>", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoGreaterThan(String value) {
            addCriterion("mer_no >", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoGreaterThanOrEqualTo(String value) {
            addCriterion("mer_no >=", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoLessThan(String value) {
            addCriterion("mer_no <", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoLessThanOrEqualTo(String value) {
            addCriterion("mer_no <=", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoLike(String value) {
            addCriterion("mer_no like", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotLike(String value) {
            addCriterion("mer_no not like", value, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoIn(List<String> values) {
            addCriterion("mer_no in", values, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotIn(List<String> values) {
            addCriterion("mer_no not in", values, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoBetween(String value1, String value2) {
            addCriterion("mer_no between", value1, value2, "merNo");
            return (Criteria) this;
        }

        public Criteria andMerNoNotBetween(String value1, String value2) {
            addCriterion("mer_no not between", value1, value2, "merNo");
            return (Criteria) this;
        }

        public Criteria andAttenStateIsNull() {
            addCriterion("atten_state is null");
            return (Criteria) this;
        }

        public Criteria andAttenStateIsNotNull() {
            addCriterion("atten_state is not null");
            return (Criteria) this;
        }

        public Criteria andAttenStateEqualTo(String value) {
            addCriterion("atten_state =", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateNotEqualTo(String value) {
            addCriterion("atten_state <>", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateGreaterThan(String value) {
            addCriterion("atten_state >", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateGreaterThanOrEqualTo(String value) {
            addCriterion("atten_state >=", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateLessThan(String value) {
            addCriterion("atten_state <", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateLessThanOrEqualTo(String value) {
            addCriterion("atten_state <=", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateLike(String value) {
            addCriterion("atten_state like", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateNotLike(String value) {
            addCriterion("atten_state not like", value, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateIn(List<String> values) {
            addCriterion("atten_state in", values, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateNotIn(List<String> values) {
            addCriterion("atten_state not in", values, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateBetween(String value1, String value2) {
            addCriterion("atten_state between", value1, value2, "attenState");
            return (Criteria) this;
        }

        public Criteria andAttenStateNotBetween(String value1, String value2) {
            addCriterion("atten_state not between", value1, value2, "attenState");
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