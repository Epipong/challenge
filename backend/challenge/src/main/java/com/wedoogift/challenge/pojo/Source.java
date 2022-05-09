
package com.wedoogift.challenge.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "companies",
    "users",
    "distributions"
})
public class Source {

    @JsonProperty("companies")
    private List<Company> companies = null;
    @JsonProperty("users")
    private List<User> users = null;
    @JsonProperty("distributions")
    private List<Distribution> distributions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("companies")
    public List<Company> getCompanies() {
        return companies;
    }

    @JsonProperty("companies")
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @JsonProperty("users")
    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @JsonProperty("distributions")
    public List<Distribution> getDistributions() {
        return distributions;
    }

    @JsonProperty("distributions")
    public void setDistributions(List<Distribution> distributions) {
        this.distributions = distributions;
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
