Add-Type -AssemblyName System.Data
$conn = New-Object System.Data.SqlClient.SqlConnection("Server=192.168.2.74;Database=office_web_db;User Id=sa;Password=Sqloct@2021")
$conn.Open()
$cmd = $conn.CreateCommand()
$cmd.CommandText = "SELECT TOP 5 EmpId, EmpCode, UserName, FirstName, LastName, IsActive, IsDeleted FROM EmployeeMaster"
$reader = $cmd.ExecuteReader()
while ($reader.Read()) {
    Write-Host "ID:" $reader["EmpId"] "Code:" $reader["EmpCode"] "User:" $reader["UserName"] "Name:" $reader["FirstName"] "Active:" $reader["IsActive"] "Deleted:" $reader["IsDeleted"]
}
$conn.Close()