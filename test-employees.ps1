$body = @{
    compId = 1
} | ConvertTo-Json

$response = Invoke-RestMethod -Uri "http://localhost:8080/Employee/GetAllEmployee" -Method Post -ContentType "application/json" -Body $body
$response | ConvertTo-Json -Depth 3