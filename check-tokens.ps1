Add-Type -AssemblyName System.Data
$conn = New-Object System.Data.SqlClient.SqlConnection("Server=192.168.2.74;Database=office_web_db;User Id=sa;Password=Sqloct@2021")
$conn.Open()
$cmd = $conn.CreateCommand()
$cmd.CommandText = "SELECT TOP 10 Username, TockenId, AuthKey, RoleId, Status, Expired, IsActive, IsDeleted, CreatedDate FROM SessionMaster"
$reader = $cmd.ExecuteReader()
Write-Host "=== SessionMaster Table Data ===" -ForegroundColor Cyan
while ($reader.Read()) {
    Write-Host "`nUsername: " -NoNewline; Write-Host $reader["Username"] -ForegroundColor Yellow
    Write-Host "TokenId: " -NoNewline; Write-Host $reader["TockenId"] -ForegroundColor Green
    Write-Host "AuthKey: " -NoNewline; Write-Host $reader["AuthKey"] -ForegroundColor Green
    Write-Host "RoleId: " -NoNewline; Write-Host $reader["RoleId"]
    Write-Host "Status: " -NoNewline; Write-Host $reader["Status"]
    Write-Host "Expired: " -NoNewline; Write-Host $reader["Expired"]
    Write-Host "CreatedDate: " -NoNewline; Write-Host $reader["CreatedDate"]
}
$conn.Close()
if ($reader.HasRows -eq $false) {
    Write-Host "`nNo sessions found!" -ForegroundColor Red
}