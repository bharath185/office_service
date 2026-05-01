Add-Type -AssemblyName System.Data
$conn = New-Object System.Data.SqlClient.SqlConnection("Server=192.168.2.74;Database=office_web_db;User Id=sa;Password=Sqloct@2021")
$conn.Open()
$cmd = $conn.CreateCommand()
$cmd.CommandText = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' ORDER BY TABLE_NAME"
$reader = $cmd.ExecuteReader()
Write-Host "=== DATABASE TABLES ===" -ForegroundColor Cyan
$tables = @()
while ($reader.Read()) {
    $tableName = $reader["TABLE_NAME"]
    $tables += $tableName
    Write-Host $tableName
}
$conn.Close()
Write-Host "`n=== Total: " $tables.Count " tables ===" -ForegroundColor Yellow