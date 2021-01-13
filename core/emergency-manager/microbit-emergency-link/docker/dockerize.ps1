$origin = Get-Location

$DIR = $PSScriptRoot
$ROOT = "$DIR/.."
Copy-Item "$DIR/Dockerfile" "$DIR/../Dockerfile"

Set-Location $ROOT
npm run build

mkdir -Force $ROOT/build2
Copy-Item -Recurse -Force $ROOT/build/emergency-manager/microbit-emergency-link/src/* $ROOT/build2
Remove-Item -Recurse -Force $ROOT/build
Copy-Item -Recurse -Force $ROOT/build2/ $ROOT/build
Remove-Item -Recurse -Force $ROOT/build2


docker buildx build --platform "linux/amd64,linux/arm64,linux/arm/v7,linux/arm/v6" -f ./Dockerfile -t elyspio/cpe-s7-project:emergency-microbit --push .

Remove-Item -Recurse -Force "$ROOT/build/"
Remove-Item "$ROOT/Dockerfile"

Set-Location $origin

