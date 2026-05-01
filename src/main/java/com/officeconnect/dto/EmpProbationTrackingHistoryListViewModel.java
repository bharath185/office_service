package com.officeconnect.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EmpProbationTrackingHistoryListViewModel {
    @JsonProperty("PendingProbationList")
    private List<EmpProbationTrackingHistoryViewModel> pendingProbationList;
    
    @JsonProperty("ProbationHistoryList")
    private List<EmpProbationTrackingHistoryViewModel> probationHistoryList;

    public List<EmpProbationTrackingHistoryViewModel> getPendingProbationList() { return pendingProbationList; }
    public void setPendingProbationList(List<EmpProbationTrackingHistoryViewModel> pendingProbationList) { this.pendingProbationList = pendingProbationList; }

    public List<EmpProbationTrackingHistoryViewModel> getProbationHistoryList() { return probationHistoryList; }
    public void setProbationHistoryList(List<EmpProbationTrackingHistoryViewModel> probationHistoryList) { this.probationHistoryList = probationHistoryList; }
}
