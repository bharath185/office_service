# Database Schema Verification Needed

For the migration to work completely, we need to verify the actual table and column names in your database.

Please check your SQL Server database (office_web_db at 192.168.2.74) and provide:

## Issues Found

### 1. EmployeeMaster ✅ WORKS
- 977 records found
- Table exists and working

### 2. LeaveTypeMaster
- Error: "Invalid column name 'LeaveCount'"
- Need actual column name in LeaveTypeMaster table

### 3. EmpLeaveApplication  
- Error: "Invalid column name 'Id'"  
- Need actual primary key column name

### 4. VisitorManagement
- Error: "Invalid column name 'Id'"
- Need actual primary key column name

### 5. ShiftMaster
- Error: "Invalid column name 'Id'"  
- Need actual primary key column name

### 6. Notification
- Error: "Invalid object name 'Notification'"
- Table may not exist

### 7. PayrollComponent
- Error: "Invalid column name 'CompId'"
- Need actual column name

### 8. PerGoal
- Error: "Invalid object name 'Per_Goal'"
- Table may not exist

### 9. AccessPolicy
- Error: "Invalid column name 'PolicyId'"
- Need actual primary key column name

## What You Need To Do

1. Open SQL Server Management Studio
2. Connect to 192.168.2.74 
3. Check database office_web_db
4. Run: SELECT * FROM information_schema.tables WHERE table_type='BASE TABLE'
5. For each table, run: EXEC sp_columns 'TableName'

Or tell me which tables should be created in the database.