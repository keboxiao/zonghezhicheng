package com.chinatelecom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkOrderExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNull() {
            addCriterion("groupid is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupid is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(Long value) {
            addCriterion("groupid =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(Long value) {
            addCriterion("groupid <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(Long value) {
            addCriterion("groupid >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(Long value) {
            addCriterion("groupid >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(Long value) {
            addCriterion("groupid <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(Long value) {
            addCriterion("groupid <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<Long> values) {
            addCriterion("groupid in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<Long> values) {
            addCriterion("groupid not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(Long value1, Long value2) {
            addCriterion("groupid between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(Long value1, Long value2) {
            addCriterion("groupid not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andAffectScopeIsNull() {
            addCriterion("affect_scope is null");
            return (Criteria) this;
        }

        public Criteria andAffectScopeIsNotNull() {
            addCriterion("affect_scope is not null");
            return (Criteria) this;
        }

        public Criteria andAffectScopeEqualTo(String value) {
            addCriterion("affect_scope =", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeNotEqualTo(String value) {
            addCriterion("affect_scope <>", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeGreaterThan(String value) {
            addCriterion("affect_scope >", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeGreaterThanOrEqualTo(String value) {
            addCriterion("affect_scope >=", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeLessThan(String value) {
            addCriterion("affect_scope <", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeLessThanOrEqualTo(String value) {
            addCriterion("affect_scope <=", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeLike(String value) {
            addCriterion("affect_scope like", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeNotLike(String value) {
            addCriterion("affect_scope not like", value, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeIn(List<String> values) {
            addCriterion("affect_scope in", values, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeNotIn(List<String> values) {
            addCriterion("affect_scope not in", values, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeBetween(String value1, String value2) {
            addCriterion("affect_scope between", value1, value2, "affectScope");
            return (Criteria) this;
        }

        public Criteria andAffectScopeNotBetween(String value1, String value2) {
            addCriterion("affect_scope not between", value1, value2, "affectScope");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andFirstSystemIsNull() {
            addCriterion("first_system is null");
            return (Criteria) this;
        }

        public Criteria andFirstSystemIsNotNull() {
            addCriterion("first_system is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSystemEqualTo(String value) {
            addCriterion("first_system =", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemNotEqualTo(String value) {
            addCriterion("first_system <>", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemGreaterThan(String value) {
            addCriterion("first_system >", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemGreaterThanOrEqualTo(String value) {
            addCriterion("first_system >=", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemLessThan(String value) {
            addCriterion("first_system <", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemLessThanOrEqualTo(String value) {
            addCriterion("first_system <=", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemLike(String value) {
            addCriterion("first_system like", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemNotLike(String value) {
            addCriterion("first_system not like", value, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemIn(List<String> values) {
            addCriterion("first_system in", values, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemNotIn(List<String> values) {
            addCriterion("first_system not in", values, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemBetween(String value1, String value2) {
            addCriterion("first_system between", value1, value2, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andFirstSystemNotBetween(String value1, String value2) {
            addCriterion("first_system not between", value1, value2, "firstSystem");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIsNull() {
            addCriterion("happen_time is null");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIsNotNull() {
            addCriterion("happen_time is not null");
            return (Criteria) this;
        }

        public Criteria andHappenTimeEqualTo(Date value) {
            addCriterion("happen_time =", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotEqualTo(Date value) {
            addCriterion("happen_time <>", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeGreaterThan(Date value) {
            addCriterion("happen_time >", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("happen_time >=", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeLessThan(Date value) {
            addCriterion("happen_time <", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeLessThanOrEqualTo(Date value) {
            addCriterion("happen_time <=", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIn(List<Date> values) {
            addCriterion("happen_time in", values, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotIn(List<Date> values) {
            addCriterion("happen_time not in", values, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeBetween(Date value1, Date value2) {
            addCriterion("happen_time between", value1, value2, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotBetween(Date value1, Date value2) {
            addCriterion("happen_time not between", value1, value2, "happenTime");
            return (Criteria) this;
        }

        public Criteria andAppearanceIsNull() {
            addCriterion("appearance is null");
            return (Criteria) this;
        }

        public Criteria andAppearanceIsNotNull() {
            addCriterion("appearance is not null");
            return (Criteria) this;
        }

        public Criteria andAppearanceEqualTo(String value) {
            addCriterion("appearance =", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceNotEqualTo(String value) {
            addCriterion("appearance <>", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceGreaterThan(String value) {
            addCriterion("appearance >", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceGreaterThanOrEqualTo(String value) {
            addCriterion("appearance >=", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceLessThan(String value) {
            addCriterion("appearance <", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceLessThanOrEqualTo(String value) {
            addCriterion("appearance <=", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceLike(String value) {
            addCriterion("appearance like", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceNotLike(String value) {
            addCriterion("appearance not like", value, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceIn(List<String> values) {
            addCriterion("appearance in", values, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceNotIn(List<String> values) {
            addCriterion("appearance not in", values, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceBetween(String value1, String value2) {
            addCriterion("appearance between", value1, value2, "appearance");
            return (Criteria) this;
        }

        public Criteria andAppearanceNotBetween(String value1, String value2) {
            addCriterion("appearance not between", value1, value2, "appearance");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andInfluenceIsNull() {
            addCriterion("influence is null");
            return (Criteria) this;
        }

        public Criteria andInfluenceIsNotNull() {
            addCriterion("influence is not null");
            return (Criteria) this;
        }

        public Criteria andInfluenceEqualTo(String value) {
            addCriterion("influence =", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceNotEqualTo(String value) {
            addCriterion("influence <>", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceGreaterThan(String value) {
            addCriterion("influence >", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceGreaterThanOrEqualTo(String value) {
            addCriterion("influence >=", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceLessThan(String value) {
            addCriterion("influence <", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceLessThanOrEqualTo(String value) {
            addCriterion("influence <=", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceLike(String value) {
            addCriterion("influence like", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceNotLike(String value) {
            addCriterion("influence not like", value, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceIn(List<String> values) {
            addCriterion("influence in", values, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceNotIn(List<String> values) {
            addCriterion("influence not in", values, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceBetween(String value1, String value2) {
            addCriterion("influence between", value1, value2, "influence");
            return (Criteria) this;
        }

        public Criteria andInfluenceNotBetween(String value1, String value2) {
            addCriterion("influence not between", value1, value2, "influence");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanIsNull() {
            addCriterion("shoulirenyuan is null");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanIsNotNull() {
            addCriterion("shoulirenyuan is not null");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanEqualTo(String value) {
            addCriterion("shoulirenyuan =", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanNotEqualTo(String value) {
            addCriterion("shoulirenyuan <>", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanGreaterThan(String value) {
            addCriterion("shoulirenyuan >", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanGreaterThanOrEqualTo(String value) {
            addCriterion("shoulirenyuan >=", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanLessThan(String value) {
            addCriterion("shoulirenyuan <", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanLessThanOrEqualTo(String value) {
            addCriterion("shoulirenyuan <=", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanLike(String value) {
            addCriterion("shoulirenyuan like", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanNotLike(String value) {
            addCriterion("shoulirenyuan not like", value, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanIn(List<String> values) {
            addCriterion("shoulirenyuan in", values, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanNotIn(List<String> values) {
            addCriterion("shoulirenyuan not in", values, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanBetween(String value1, String value2) {
            addCriterion("shoulirenyuan between", value1, value2, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuanNotBetween(String value1, String value2) {
            addCriterion("shoulirenyuan not between", value1, value2, "shoulirenyuan");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaIsNull() {
            addCriterion("shoulirenyuandianhua is null");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaIsNotNull() {
            addCriterion("shoulirenyuandianhua is not null");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaEqualTo(String value) {
            addCriterion("shoulirenyuandianhua =", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaNotEqualTo(String value) {
            addCriterion("shoulirenyuandianhua <>", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaGreaterThan(String value) {
            addCriterion("shoulirenyuandianhua >", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaGreaterThanOrEqualTo(String value) {
            addCriterion("shoulirenyuandianhua >=", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaLessThan(String value) {
            addCriterion("shoulirenyuandianhua <", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaLessThanOrEqualTo(String value) {
            addCriterion("shoulirenyuandianhua <=", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaLike(String value) {
            addCriterion("shoulirenyuandianhua like", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaNotLike(String value) {
            addCriterion("shoulirenyuandianhua not like", value, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaIn(List<String> values) {
            addCriterion("shoulirenyuandianhua in", values, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaNotIn(List<String> values) {
            addCriterion("shoulirenyuandianhua not in", values, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaBetween(String value1, String value2) {
            addCriterion("shoulirenyuandianhua between", value1, value2, "shoulirenyuandianhua");
            return (Criteria) this;
        }

        public Criteria andShoulirenyuandianhuaNotBetween(String value1, String value2) {
            addCriterion("shoulirenyuandianhua not between", value1, value2, "shoulirenyuandianhua");
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