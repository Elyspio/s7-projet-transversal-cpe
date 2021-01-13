$origin=Get-Location



$DIR = $PSScriptRoot
$ROOT = "$DIR/.."
Copy-Item "$DIR/Dockerfile" "$DIR/../Dockerfile"

Set-Location $ROOT
npm run build

mkdir -Force $ROOT/build2
Copy-Item -Recurse -Force $ROOT/build/mqtt/app/src/* $ROOT/build2
Remove-Item -Recurse -Force $ROOT/build
Copy-Item -Recurse -Force $ROOT/build2/ $ROOT/build
Remove-Item -Recurse -Force $ROOT/build2

cp "$DIR/Dockerfile" "$DIR/../Dockerfile"

docker buildx build --platform "linux/amd64,linux/arm64"  -f ./Dockerfile -t elyspio/cpe-s7-project:mqtt-app --push .

rm -Recurse -Force "$DIR/../build/"
rm "$DIR/../Dockerfile"

cd $origin

