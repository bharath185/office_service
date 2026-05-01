package com.officeconnect.controller;

import com.officeconnect.dto.*;
import com.officeconnect.dto.EmployeeMasterViewModel;
import com.officeconnect.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/CreateGoal")
    public ResponseEntity<?> createGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.createGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllGoals")
    public ResponseEntity<?> getAllGoals(@RequestBody PerformanceViewModel model) {
        try {
            List<PerformanceViewModel> result = performanceService.getAllGoals(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateGoalStatus")
    public ResponseEntity<?> updateGoalStatus(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.updateGoalStatus(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetBehaviouralGoal")
    public ResponseEntity<?> getBehaviouralGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.getBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddBehaviouralGoal")
    public ResponseEntity<?> addBehaviouralGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.addBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateBehaviouralGoal")
    public ResponseEntity<?> updateBehaviouralGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.updateBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteBehaviouralGoal")
    public ResponseEntity<?> deleteBehaviouralGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.deleteBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllBehaviouralGoal")
    public ResponseEntity<?> getAllBehaviouralGoal(@RequestBody PerformanceViewModel model) {
        try {
            List<PerformanceViewModel> result = performanceService.getAllBehaviouralGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeGoalHistory")
    public ResponseEntity<?> getEmployeeGoalHistory(@RequestBody PerformanceViewModel model) {
        try {
            List<PerformanceViewModel> result = performanceService.getEmployeeGoalHistory(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GoalApproval")
    public ResponseEntity<?> goalApproval(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.goalApproval(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

@PostMapping("/GoalReject")
    public ResponseEntity<?> goalReject(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.goalReject(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeDetails")
    public ResponseEntity<?> getEmployeeDetails(@RequestBody EmployeeMasterViewModel model) {
        try {
            List<EmployeeMasterViewModel> result = performanceService.getEmployeeDetails(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetGoalByEmpId")
    public ResponseEntity<?> getGoalByEmpId(@RequestBody PerformanceViewModel model) {
        try {
            List<PerformanceViewModel> result = performanceService.getGoalByEmpId(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetQuarterGoal")
    public ResponseEntity<?> getQuarterGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.getQuarterGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddQuarterGoal")
    public ResponseEntity<?> addQuarterGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.addQuarterGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateQuarterGoal")
    public ResponseEntity<?> updateQuarterGoal(@RequestBody PerformanceViewModel model) {
        try {
            PerformanceViewModel result = performanceService.updateQuarterGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllQuarterGoal")
    public ResponseEntity<?> getAllQuarterGoal(@RequestBody PerformanceViewModel model) {
        try {
            List<PerformanceViewModel> result = performanceService.getAllQuarterGoal(model);
            return ResponseEntity.ok(result);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDFYear")
    public ResponseEntity<?> ddFYear(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getDDFYear(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDQuater")
    public ResponseEntity<?> ddQuater(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getDDQuater(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DDReviewStatus")
    public ResponseEntity<?> ddReviewStatus(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getDDReviewStatus(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetQuaterDetails")
    public ResponseEntity<?> getQuaterDetails(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getQuaterDetails(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetFYearDetails")
    public ResponseEntity<?> getFYearDetails(@RequestBody Map<String, Object> model) {
        try {
            var result = performanceService.getFYearDetails(model);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("StatusCode", 500, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/SubmitConfigSetup")
    public ResponseEntity<?> submitConfigSetup(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.submitConfigSetup(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateConfigSetup")
    public ResponseEntity<?> updateConfigSetup(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.updateConfigSetup(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllConfigSetup")
    public ResponseEntity<?> getAllConfigSetup(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllConfigSetup(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/PerformanceReport")
    public ResponseEntity<?> performanceReport(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.performanceReport(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllGoal")
    public ResponseEntity<?> getAllGoal(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllGoal(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllGoalEmployee")
    public ResponseEntity<?> getAllGoalEmployee(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllGoalEmployee(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetGoal")
    public ResponseEntity<?> getGoal(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getGoal(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddAllGoal")
    public ResponseEntity<?> addAllGoal(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.addAllGoal(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/ApproveAllGoal")
    public ResponseEntity<?> approveAllGoal(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.approveAllGoal(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddGoal")
    public ResponseEntity<?> addGoal(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.addGoal(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateGoal")
    public ResponseEntity<?> updateGoal(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.updateGoal(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteGoal")
    public ResponseEntity<?> deleteGoalEndpoint(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.deleteGoalEndpoint(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllTask")
    public ResponseEntity<?> getAllTask(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllTask(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetTask")
    public ResponseEntity<?> getTask(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getTask(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddTask")
    public ResponseEntity<?> addTask(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.addTask(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateTask")
    public ResponseEntity<?> updateTask(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.updateTask(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteTask")
    public ResponseEntity<?> deleteTask(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.deleteTask(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllBehaviour")
    public ResponseEntity<?> getAllBehaviour(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllBehaviour(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetBehaviour")
    public ResponseEntity<?> getBehaviour(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getBehaviour(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddBehaviour")
    public ResponseEntity<?> addBehaviour(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.addBehaviour(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateBehaviour")
    public ResponseEntity<?> updateBehaviour(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.updateBehaviour(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteBehaviour")
    public ResponseEntity<?> deleteBehaviour(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.deleteBehaviour(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllBehaviourDetail")
    public ResponseEntity<?> getAllBehaviourDetail(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllBehaviourDetail(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetBehaviourDetail")
    public ResponseEntity<?> getBehaviourDetail(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getBehaviourDetail(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddBehaviourDetail")
    public ResponseEntity<?> addBehaviourDetail(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.addBehaviourDetail(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateBehaviourDetail")
    public ResponseEntity<?> updateBehaviourDetail(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.updateBehaviourDetail(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteBehaviourDetail")
    public ResponseEntity<?> deleteBehaviourDetail(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.deleteBehaviourDetail(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllSelfDevelopment")
    public ResponseEntity<?> getAllSelfDevelopment(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllSelfDevelopment(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetSelfDevelopment")
    public ResponseEntity<?> getSelfDevelopment(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getSelfDevelopment(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/AddSelfDevelopment")
    public ResponseEntity<?> addSelfDevelopment(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.addSelfDevelopment(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/UpdateSelfDevelopment")
    public ResponseEntity<?> updateSelfDevelopment(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.updateSelfDevelopment(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/DeleteSelfDevelopment")
    public ResponseEntity<?> deleteSelfDevelopment(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.deleteSelfDevelopment(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/SaveEmployeeReview")
    public ResponseEntity<?> saveEmployeeReview(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.saveEmployeeReview(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetAllEmployeeReviewList")
    public ResponseEntity<?> getAllEmployeeReviewList(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getAllEmployeeReviewList(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/GetEmployeeReviewList")
    public ResponseEntity<?> getEmployeeReviewList(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.getEmployeeReviewList(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }

    @PostMapping("/SaveManagerReview")
    public ResponseEntity<?> saveManagerReview(@RequestBody Map<String, Object> model) {
        try {
            return ResponseEntity.ok(performanceService.saveManagerReview(model));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("StatusCode", 404, "Message", ex.getMessage()));
        }
    }
}