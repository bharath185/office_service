$body = @{
    userName = "admin"
    password = "admin123"
} | ConvertTo-Json

$response = Invoke-RestMethod -Uri "http://localhost:8080/Login/Login" -Method Post -ContentType "application/json" -Body $body
$response | ConvertTo-Json