Add-Type -AssemblyName System.Data
$tables = @(
    "EmployeeMaster", "SessionMaster", "CompanyMaster", "LeaveTypeMaster", "EmpLeaveApplication", 
    "ShiftMaster", "PayrollComponent", "Notification", "AccessPolicy", "VisitorManagement",
    "LegalEntityMaster", "BusinessUnitMaster", "LocationMaster", "CompOffRequest", "PerGoal",
    "PassHistoryManagement", "FPwdManagement", "CPwdManagement", "EmailSetUp", "Attendance",
    "HolidayMaster", "Holidays", "DepartmentMaster", "CategoryMaster", "DesignationMaster",
    "EmpTypeMaster", "RoleMaster", "GenderMaster", "SalutationMaster", "GradeMaster",
    "CompanySettingMaster", "ConfigMaster", "ConfigSetup", "ModuleMaster", "PageModuleMaster",
    "SubModuleMaster", "FinanceMaster", "FinancialYearMaster", "ServiceMaster",
    "VendorMaster", "ProjectMaster", "SiteMaster", "BannerMaster", "EmailConfigMaster",
    "DocumentMaster", "CareerMaster", "EducationMaster", "EmployeeEducation", "EmployeeGovtDoc",
    "EmployeeCareer", "EmployeeAccDetails", "EmployeeNomineeMaster", "EmployeeSalaryDetails",
    "EmployeeDoc", "EmpShiftDetails", "DailyAttendanceRecords", "ManualAttendance",
    "ContractAttendance", "AttendanceProcessingLog", "PayrollPayoutType", "PayrollSegment",
    "PayrollFrequencyMaster", "PayrollComponentCondition", "PayrollComponentLogic",
    "PayoutMappingMaster", "PayslipSection", "PayslipSectionComponents", "WorkTypeMaster",
    "ShiftGroupingMaster", "ReviewList", "QuaterMaster", "UserNotifications", "NotificationTemplates",
    "VisitorInviteHistory", "Loginlog", "WFHLoginlog", "OnSiteLoginlog", "EmployeeMasterLogs",
    "PassHistoryManagement", "LeaveCarryForwardMaster", "EmpProbationTrackingHistory",
    "TempManualAttendance", "Quarter", "Goal", "BehaviourDetail"
)

foreach ($table in $tables) {
    $query = @"
Add-Type -AssemblyName System.Data
`$conn = New-Object System.Data.SqlClient.SqlConnection("Server=192.168.2.74;Database=office_web_db;User Id=sa;Password=Sqloct@2021")
`$conn.Open()
`$cmd = `$conn.CreateCommand()
`$cmd.CommandText = "SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '$table'"
`$reader = `$cmd.ExecuteReader()
Write-Host "=== $table ==="
while (`$reader.Read()) {
    Write-Host "`$(`$reader['COLUMN_NAME']) : `$(`$reader['DATA_TYPE']) (`$reader['IS_NULLABLE'])"
}
`$conn.Close()
"@
    Write-Host $query
}