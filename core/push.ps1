
" "
"--- Pushing Truck Manager containers ---"
Start-Process   powershell $PSScriptRoot/truck-manager/app/docker/dockerize.ps1

"--- Pushing Simulator containers ---"
Start-Process  powershell $PSScriptRoot/simulator/app/docker/dockerize.ps1
Start-Process powershell $PSScriptRoot/simulator/microbit-simulator-link/docker/dockerize.ps1
Start-Process powershell $PSScriptRoot/simulator/view/docker/dockerize.ps1


" "
"--- Pushing Emergency Manager containers ---"
Start-Process powershell $PSScriptRoot/emergency-manager/app/docker/dockerize.ps1 
Start-Process  powershell $PSScriptRoot/emergency-manager/microbit-emergency-link/docker/dockerize.ps1 
Start-Process  powershell $PSScriptRoot/emergency-manager/view/docker/dockerize.ps1 


" "
"--- Pushing MQTT containers ---"
Start-Process  powershell $PSScriptRoot/mqtt/app/docker/dockerize.ps1

