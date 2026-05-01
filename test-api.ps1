$body = '{"UserName": "ADMINCAD-1", "Password": "ADMINCAD-1"}'
$response = Invoke-RestMethod -Uri 'http://localhost:8080/Login/Login' -Method POST -Body $body -ContentType 'application/json'
$response | ConvertTo-Json