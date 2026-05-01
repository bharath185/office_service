package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class DashboardViewModel {
    @JsonProperty("LoginId")
    private Integer loginId;
    @JsonProperty("LEId")
    private Integer leId;
    @JsonProperty("lstofbirthday")
    private Map<String, Object> lstofbirthday;
    @JsonProperty("lstofholiday")
    private List<Map<String, Object>> lstofholiday;
    @JsonProperty("lstofemp")
    private List<Map<String, Object>> lstofemp;
    @JsonProperty("Msg")
    private String msg;

    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public Integer getLeId() { return leId; }
    public void setLeId(Integer leId) { this.leId = leId; }

    public Map<String, Object> getLstofbirthday() { return lstofbirthday; }
    public void setLstofbirthday(Map<String, Object> lstofbirthday) { this.lstofbirthday = lstofbirthday; }

    public List<Map<String, Object>> getLstofholiday() { return lstofholiday; }
    public void setLstofholiday(List<Map<String, Object>> lstofholiday) { this.lstofholiday = lstofholiday; }

    public List<Map<String, Object>> getLstofemp() { return lstofemp; }
    public void setLstofemp(List<Map<String, Object>> lstofemp) { this.lstofemp = lstofemp; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}