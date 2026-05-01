# .NET vs Java Endpoints Comparison

## .NET Controllers (15)
1. LoginController - 7 endpoints
2. EmployeeController - 100+ endpoints
3. LeaveController - 20+ endpoints
4. DashboardController - 3 endpoints
5. VisitorController - 18 endpoints
6. ShiftController - 4 endpoints
7. NotificationController - 4 endpoints
8. PayrollController - 4 endpoints
9. PerformanceController - 18 endpoints (Goal)
10. BusinessEntityController - 4 endpoints
11. AccessController - 4 endpoints
12. WFHLoginController - 2 endpoints

## Java Controllers (12)
1. LoginController - 8 endpoints
2. EmployeeController - 80 endpoints
3. LeaveController - 19 endpoints
4. DashboardController - 2 endpoints
5. VisitorController - 5 endpoints
6. ShiftController - 4 endpoints
7. NotificationController - 4 endpoints
8. PayrollController - 4 endpoints
9. PerformanceController - 4 endpoints
10. BusinessEntityController - 4 endpoints
11. AccessController - 4 endpoints
12. WFHLoginController - 2 endpoints

## Database Tables vs Entities

| Table | Entity | Status |
|-------|--------|--------|
| EmployeeMaster | EmployeeMaster.java | ✅ |
| SessionMaster | SessionMaster.java | ✅ |
| CompanyMaster | CompanyMaster.java | ✅ |
| LeaveTypeMaster | LeaveTypeMaster.java | ✅ |
| EmpLeaveApplication | EmpLeaveApplication.java | ✅ |
| ShiftMaster | ShiftMaster.java | ✅ |
| PayrollComponent | PayrollComponent.java | ✅ |
| Notification | Notification.java | ✅ |
| AccessPolicy | AccessPolicy.java | ✅ |
| VisitorManagement | VisitorManagement.java | ✅ |
| LegalEntityMaster | LegalEntityMaster.java | ✅ |
| BusinessUnitMaster | BusinessUnitMaster.java | ✅ |
| LocationMaster | LocationMaster.java | ✅ |
| CompOffRequest | CompOffRequest.java | ✅ |
| PerGoal | PerGoal.java | ✅ |
| PassHistoryManagement | PassHistoryManagement.java | ✅ |
| FPwdManagement | FPwdManagement.java | ✅ |
| CPwdManagement | CPwdManagement.java | ✅ |
| EmailSetUp | EmailSetUp.java | ✅ |
| Attendance | Attendance.java | ✅ |
| HolidayMaster | HolidayMaster.java | ✅ |
| Holidays | Holiday.java | ✅ |
| DailyAttendanceRecords | DailyAttendanceRecords.java | ✅ |
| ManualAttendance | ManualAttendance.java | ✅ |
| ContractAttendance | ContractAttendance.java | ✅ |
| AttendanceProcessingLog | AttendanceProcessingLog.java | ✅ |
| EmployeeEducation | EmployeeEducation.java | ✅ |
| EmployeeGovtDoc | EmployeeGovtDoc.java | ✅ |
| EmployeeDoc | EmployeeDoc.java | ✅ |
| EmployeeCareer | EmployeeCareer.java | ✅ |
| EmployeeNomineeMaster | EmployeeNomineeMaster.java | ✅ |
| EmployeeSalaryDetails | EmployeeSalaryDetails.java | ✅ |
| EmployeeAccDetails | EmployeeAccDetails.java | ✅ |
| DeptMaster | DeptMaster.java | ✅ |
| CategoryMaster | CategoryMaster.java | ✅ |
| DesignationMaster | DesignationMaster.java | ✅ |
| EmpTypeMaster | EmpTypeMaster.java | ✅ |
| RoleMaster | RoleMaster.java | ✅ |
| GenderMaster | GenderMaster.java | ✅ |
| SalutationMaster | SalutationMaster.java | ✅ |
| GradeMaster | GradeMaster.java | ✅ |
| HolidayMaster | HolidayMaster.java | ✅ |
| ServiceMaster | ServiceMaster.java | ✅ |
| VendorMaster | VendorMaster.java | ✅ |
| ProjectMaster | ProjectMaster.java | ✅ |
| SiteMaster | SiteMaster.java | ✅ |
| BannerMaster | BannerMaster.java | ✅ |
| ModuleMaster | ModuleMaster.java | ✅ |
| PageModuleMaster | PageModuleMaster.java | ✅ |
| SubModuleMaster | SubModuleMaster.java | ✅ |
| ConfigMaster | ConfigMaster.java | ✅ |
| ConfigSetup | ConfigSetup.java | ✅ |
| FinanceMaster | FinanceMaster.java | ✅ |
| FinancialYearMaster | FinancialYearMaster.java | ✅ |
| EmailConfigMaster | EmailConfigMaster.java | ✅ |
| NotificationTemplate | NotificationTemplate.java | ✅ |
| UserNotifications | UserNotifications.java | ✅ |
| PayrollPayoutType | PayrollPayoutType.java | ✅ |
| PayrollSegment | PayrollSegment.java | ✅ |
| PayrollFrequencyMaster | PayrollFrequencyMaster.java | ✅ |
| PayrollComponentCondition | PayrollComponentCondition.java | ✅ |
| PayrollComponentLogic | PayrollComponentLogic.java | ✅ |
| PayoutMappingMaster | PayoutMappingMaster.java | ✅ |
| PayslipSection | PayslipSection.java | ✅ |
| PayslipSectionComponents | PayslipSectionComponents.java | ✅ |
| WorkTypeMaster | WorkTypeMaster.java | ✅ |
| EmpProbationTrackingHistory | EmpProbationTrackingHistory.java | ✅ |
| TempManualAttendance | TempManualAttendance.java | ✅ |
| ReviewList | ReviewList.java | ✅ |
| QuaterMaster | QuaterMaster.java | ✅ |
| PerBehaviourDetail | PerBehaviourDetail.java | ✅ |
| VisitorInviteHistory | VisitorInviteHistory.java | ✅ |
| Loginlog | Loginlog.java | ✅ |
| WFHLoginlog | WFHLoginlog.java | ✅ |
| OnSiteLoginlog | OnSiteLoginlog.java | ✅ |
| EmployeeMasterLogs | EmployeeMasterLogs.java | ✅ |
| LeaveCarryForwardMaster | LeaveCarryForwardMaster.java | ✅ |
| ShiftGroupingMaster | ShiftGroupingMaster.java | ✅ |

## Summary
- .NET Endpoints: ~300+
- Java Endpoints: 156
- Database Tables: 96
- Java Entities: 81

## Missing Endpoints to Add (~150)
Need to implement remaining EmployeeController methods (~60)
Need to implement remaining LeaveController methods (~20)
Need to implement Attendance/DailyAttendance endpoints (~30)
Need to implement Payroll components (~20)
Need to implement Document/Upload endpoints (~20)

## Request/Response Format
- .NET uses camelCase JSON
- Java uses camelCase JSON
- Both match the database column names