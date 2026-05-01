$json = @{
    userName = "admin"
    password = "admin123"
} | ConvertTo-Json

$loginResp = Invoke-RestMethod -Uri "http://localhost:8080/Login/Login" -Method Post -ContentType "application/json" -Body $json
$token = $loginResp.tokenId

Write-Host "Token: $token"

$body = @{} | ConvertTo-Json

$headers = @{
    "Authorization" = $token
}

$response = Invoke-RestMethod -Uri "http://localhost:8080/Employee/DDCompany" -Method Post -ContentType "application/json" -Body $body -Headers $headers
$response | ConvertTo-Json -Depth 3