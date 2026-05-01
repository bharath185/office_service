Add-Type -AssemblyName System.Data
$conn = New-Object System.Data.SqlClient.SqlConnection("Server=192.168.2.74;Database=office_web_db;User Id=sa;Password=Sqloct@2021")
$conn.Open()
$cmd = $conn.CreateCommand()
$cmd.CommandText = "SELECT TOP 5 EmpId, EmpCode, UserName, Password, IsActive, IsDeleted FROM EmployeeMaster WHERE UserName = 'admin'"
$reader = $cmd.ExecuteReader()
Write-Host "=== Checking for 'admin' user ===" -ForegroundColor Cyan
while ($reader.Read()) {
    Write-Host "EmpId: " -NoNewline; Write-Host $reader["EmpId"]
    Write-Host "EmpCode: " -NoNewline; Write-Host $reader["EmpCode"]
    Write-Host "UserName: " -NoNewline; Write-Host $reader["UserName"]
    Write-Host "Password: " -NoNewline; Write-Host $reader["Password"]
    Write-Host "IsActive: " -NoNewline; Write-Host $reader["IsActive"]
    Write-Host "IsDeleted: " -NoNewline; Write-Host $reader["IsDeleted"]
}
$conn.Close()
if ($reader.HasRows -eq $false) {
    Write-Host "User 'admin' NOT FOUND in database!" -ForegroundColor Red
}