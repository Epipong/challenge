
package com.wedoogift.challenge.pojo;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "amount",
    "start_date",
    "end_date",
    "company_id",
    "user_id"
})
public class Distribution {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("start_date")
    private Calendar startDate;
    @JsonProperty("end_date")
    private Calendar endDate;
    @JsonProperty("company_id")
    private Integer companyId;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("start_date")
    public Calendar getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public Calendar getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    @JsonProperty("company_id")
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
