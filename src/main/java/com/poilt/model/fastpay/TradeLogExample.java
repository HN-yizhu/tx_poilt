package com.poilt.model.fastpay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradeLogExample() {
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

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeAmtIsNull() {
            addCriterion("trade_amt is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmtIsNotNull() {
            addCriterion("trade_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmtEqualTo(Integer value) {
            addCriterion("trade_amt =", value, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtNotEqualTo(Integer value) {
            addCriterion("trade_amt <>", value, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtGreaterThan(Integer value) {
            addCriterion("trade_amt >", value, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_amt >=", value, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtLessThan(Integer value) {
            addCriterion("trade_amt <", value, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtLessThanOrEqualTo(Integer value) {
            addCriterion("trade_amt <=", value, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtIn(List<Integer> values) {
            addCriterion("trade_amt in", values, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtNotIn(List<Integer> values) {
            addCriterion("trade_amt not in", values, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtBetween(Integer value1, Integer value2) {
            addCriterion("trade_amt between", value1, value2, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andTradeAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_amt not between", value1, value2, "tradeAmt");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserCertNoIsNull() {
            addCriterion("user_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andUserCertNoIsNotNull() {
            addCriterion("user_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserCertNoEqualTo(String value) {
            addCriterion("user_cert_no =", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotEqualTo(String value) {
            addCriterion("user_cert_no <>", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoGreaterThan(String value) {
            addCriterion("user_cert_no >", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_cert_no >=", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoLessThan(String value) {
            addCriterion("user_cert_no <", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoLessThanOrEqualTo(String value) {
            addCriterion("user_cert_no <=", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoLike(String value) {
            addCriterion("user_cert_no like", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotLike(String value) {
            addCriterion("user_cert_no not like", value, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoIn(List<String> values) {
            addCriterion("user_cert_no in", values, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotIn(List<String> values) {
            addCriterion("user_cert_no not in", values, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoBetween(String value1, String value2) {
            addCriterion("user_cert_no between", value1, value2, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andUserCertNoNotBetween(String value1, String value2) {
            addCriterion("user_cert_no not between", value1, value2, "userCertNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoIsNull() {
            addCriterion("pay_card_no is null");
            return (Criteria) this;
        }

        public Criteria andPayCardNoIsNotNull() {
            addCriterion("pay_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayCardNoEqualTo(String value) {
            addCriterion("pay_card_no =", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoNotEqualTo(String value) {
            addCriterion("pay_card_no <>", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoGreaterThan(String value) {
            addCriterion("pay_card_no >", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_card_no >=", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoLessThan(String value) {
            addCriterion("pay_card_no <", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoLessThanOrEqualTo(String value) {
            addCriterion("pay_card_no <=", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoLike(String value) {
            addCriterion("pay_card_no like", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoNotLike(String value) {
            addCriterion("pay_card_no not like", value, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoIn(List<String> values) {
            addCriterion("pay_card_no in", values, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoNotIn(List<String> values) {
            addCriterion("pay_card_no not in", values, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoBetween(String value1, String value2) {
            addCriterion("pay_card_no between", value1, value2, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andPayCardNoNotBetween(String value1, String value2) {
            addCriterion("pay_card_no not between", value1, value2, "payCardNo");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("trade_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Date value) {
            addCriterion("trade_time =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Date value) {
            addCriterion("trade_time <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Date value) {
            addCriterion("trade_time >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trade_time >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Date value) {
            addCriterion("trade_time <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Date value) {
            addCriterion("trade_time <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Date> values) {
            addCriterion("trade_time in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Date> values) {
            addCriterion("trade_time not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Date value1, Date value2) {
            addCriterion("trade_time between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Date value1, Date value2) {
            addCriterion("trade_time not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTraceNoIsNull() {
            addCriterion("trace_no is null");
            return (Criteria) this;
        }

        public Criteria andTraceNoIsNotNull() {
            addCriterion("trace_no is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNoEqualTo(String value) {
            addCriterion("trace_no =", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotEqualTo(String value) {
            addCriterion("trace_no <>", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoGreaterThan(String value) {
            addCriterion("trace_no >", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoGreaterThanOrEqualTo(String value) {
            addCriterion("trace_no >=", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLessThan(String value) {
            addCriterion("trace_no <", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLessThanOrEqualTo(String value) {
            addCriterion("trace_no <=", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoLike(String value) {
            addCriterion("trace_no like", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotLike(String value) {
            addCriterion("trace_no not like", value, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoIn(List<String> values) {
            addCriterion("trace_no in", values, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotIn(List<String> values) {
            addCriterion("trace_no not in", values, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoBetween(String value1, String value2) {
            addCriterion("trace_no between", value1, value2, "traceNo");
            return (Criteria) this;
        }

        public Criteria andTraceNoNotBetween(String value1, String value2) {
            addCriterion("trace_no not between", value1, value2, "traceNo");
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