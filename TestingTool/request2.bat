
echo FILE2

for /l %%x in (1, 1, 100) do (
@echo off
curl -X PUT  http://localhost:8000/weather-api/weather/VAR/18.3 >> txt2.txt) 
exit 