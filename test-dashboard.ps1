$body = @{} | ConvertTo-Json
$response = Invoke-RestMethod -Uri "http://localhost:8080/Dashboard/GetAllHRcount" -Method Post -ContentType "application/json" -Body $body
$response | ConvertTo-Json -Depth 3