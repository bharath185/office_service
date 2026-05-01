$body = @{
    tokenId = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoiYWRtaW4iLCJpYXQiOjE3NzY3MDQ3MDd9.Ct2nBiNWj1gez7Doe4T77lzJs_zNdD_uXG1PoUZV7Bk"
} | ConvertTo-Json
$response = Invoke-RestMethod -Uri "http://localhost:8080/Holiday/GetAllHolidays" -Method Post -ContentType "application/json" -Body $body
$response | ConvertTo-Json -Depth 3