$loc = Get-Location

" "
"--- Starting Emergency Manager containers ---"
Set-Location $PSScriptRoot/emergency-manager
docker-compose pull
docker-compose down
docker-compose up -d

" "
"--- Starting Truck Manager containers ---"
Set-Location $PSScriptRoot/truck-manager
docker-compose pull
docker-compose down
docker-compose up -d

" "
"--- Starting Simulator containers ---"
Set-Location $PSScriptRoot/simulator
docker-compose pull
docker-compose down
docker-compose up -d

" "
"--- Starting MQTT containers ---"
Set-Location $PSScriptRoot/mqtt
docker-compose pull
docker-compose down
docker-compose up -d

Set-Location $loc