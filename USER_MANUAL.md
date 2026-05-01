# OfficeConnect Web - Migration Report (ASP.NET to Spring Boot)
## User Manual & Technical Documentation

---

## Quick Summary

| Item | Status |
|------|--------|
| Application URL | http://localhost:8080 |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |
| Login | ✅ Working |
| Employees | ✅ 977 records found |
| Other Tables | ⚠️ Need verification |

---

## 1. Test Credentials

```
Username: admin
Password: admin123
```

---

## 2. How to Test via Swagger

1. Open: http://localhost:8080/swagger-ui/index.html
2. Click on **Login/Login** endpoint
3. Click **Try it out**
4. Enter: `{"userName":"admin","password":"admin123"}`
5. Click **Execute**
6. Copy the `tokenId` from response for other endpoints

---

## 3. API Endpoints (71 Total)

### Login (6)
- POST /Login/Login
- POST /Login/LogOut
- POST /Login/CheckAuth
- POST /Login/ChangePassword
- POST /Login/ForgetPassword
- POST /Login/FPwdVerify

### Employee (11)
- POST /Employee/SaveEmployee
- POST /Employee/UpdateEmployee
- POST /Employee/GetAllEmployee ⭐ (Working - 977 records)
- POST /Employee/GetEmployeeById
- POST /Employee/DeleteEmployee
- POST /Employee/DDCompany
- POST /Employee/DDLegalEntity
- POST /Employee/DDBusinessUnit
- POST /Employee/DDLocation
- POST /Employee/DDAuthorisedEntity
- POST /Employee/NewDD* (4 endpoints)

### Leave (13)
- POST /Leave/ApplyLeave
- POST /Leave/GetAllLeave ⚠️
- POST /Leave/GetAllManagerLeave ⚠️
- POST /Leave/ApproveLeaveByManager
- POST /Leave/ApproveLeaveByHR
- POST /Leave/CancelLeave
- POST /Leave/WithDrawLeave
- POST /Leave/DraftLeave
- POST /Leave/CompOffLeave
- POST /Leave/ApproveCompOff
- POST /Leave/AddLeaveType
- POST /Leave/UpdateLeaveType
- POST /Leave/DeleteLeaveType
- POST /Leave/DDLeaveType

### Visitor (5)
- POST /Visitor/CreateVisitor ⚠️
- POST /Visitor/UpdateVisitor ⚠️
- POST /Visitor/GetAllVisitor ⚠️
- POST /Visitor/DeleteVisitor ⚠️
- POST /Visitor/ApproveVisitor ⚠️

### Shift (4)
- POST /Shift/AddShift ⚠️
- POST /Shift/UpdateShift ⚠️
- POST /Shift/GetAllShift ⚠️
- POST /Shift/DeleteShift ⚠️

### Notification (4)
- POST /Notification/CreateNotification ⚠️
- POST /Notification/GetAllNotifications ⚠️
- POST /Notification/DeleteNotification ⚠️
- POST /Notification/MarkAsRead ⚠️

### Payroll (4)
- POST /Payroll/AddComponent ⚠️
- POST /Payroll/GetAllComponents ⚠️
- POST /Payroll/UpdateComponent ⚠️
- POST /Payroll/DeleteComponent ⚠️

### Performance (4)
- POST /Performance/CreateGoal ⚠️
- POST /Performance/GetAllGoals ⚠️
- POST /Performance/UpdateGoalStatus ⚠️
- POST /Performance/DeleteGoal ⚠️

### Dashboard (2)
- POST /Dashboard/GetAllHRcount ✅
- POST /Dashboard/GetEmployeeEvents

### BusinessEntity (4)
- POST /BusinessEntity/DDCompany
- POST /BusinessEntity/DDLegalEntity
- POST /BusinessEntity/DDBusinessUnit
- POST /BusinessEntity/DDLocation

### Access (4)
- POST /Access/CreatePolicy
- POST /Access/GetAllPolicies
- POST /Access/UpdatePolicy
- POST /Access/DeletePolicy

### WFHLogin (2)
- POST /WFHLogin/Login
- POST /WFHLogin/LogOut

---

## 4. Database Status

### Working Tables
| Table | Records | Status |
|-------|---------|--------|
| EmployeeMaster | 977 | ✅ Working |
| CompanyMaster | - | ✅ (referenced) |
| SessionMaster | - | ✅ (for login) |

### Tables Needing Verification
| Table | Issue |
|-------|-------|
| EmpLeaveApplication | Column name mismatch |
| VisitorManagement | Table may not exist |
| ShiftMaster | Column name mismatch |
| Notification | Table may not exist |
| PayrollComponent | Table may not exist |
| PerGoal | Table may not exist |
| AccessPolicy | Table may not exist |

---

## 5. Frontend Integration

### Option 1: Local Development
Update frontend API URL to:
```
http://localhost:8080
```

### Option 2: Deploy to Server
1. Build JAR: `mvnw.cmd package`
2. Deploy to server
3. Configure port in application.properties

### Configuration
```properties
# Current
server.port=8080
spring.datasource.url=jdbc:sqlserver://192.168.2.74:1433;databaseName=office_web_db
spring.datasource.username=sa
spring.datasource.password=Sqloct@2021
```

---

## 6. Known Issues & Fixes

### Issue 1: Some tables return column errors
**Cause:** Database table column names may differ from entity definitions  
**Fix:** Need to check actual database schema

### Issue 2: Token not returned in login response
**Cause:** Entity column mismatch  
**Fix:** Working on fix

---

## 7. Recommendations

1. **Verify Database Schema**: Compare .NET EDMX model with actual database tables
2. **Test with Real Data**: Create test records in each table
3. **Check Column Names**: Match with SQL Server actual column names

---

## 8. Testing Commands

### Login Test
```bash
curl -X POST http://localhost:8080/Login/Login \
  -H "Content-Type: application/json" \
  -d '{"userName":"admin","password":"admin123"}'
```

### Get All Employees
```bash
curl -X POST http://localhost:8080/Employee/GetAllEmployee \
  -H "Content-Type: application/json" \
  -d '{}'
```

---

## Contact & Support

For issues:
1. Check Swagger UI for all endpoints
2. Verify database connectivity
3. Check application logs

---

*Document generated: 2026-04-19*
*Version: Spring Boot 3.2.0 | Java 17*