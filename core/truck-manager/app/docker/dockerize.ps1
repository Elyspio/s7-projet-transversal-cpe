$origin=Get-Location

$DIR=$PSScriptRoot

cp "$DIR/Dockerfile" "$DIR/../Dockerfile"

cd "$DIR/.." ; npm run build ;  docker buildx build --platform "linux/amd64,linux/arm64"  -f ./Dockerfile -t elyspio/cpe-s7-project:truck-manager --push .

rm -Recurse -Force "$DIR/../build/"
rm "$DIR/../Dockerfile"

cd $origin

