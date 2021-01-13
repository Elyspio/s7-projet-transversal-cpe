$origin=Get-Location

$DIR=$PSScriptRoot

cp "$DIR/DockerFile" "$DIR/../DockerFile"

cd "$DIR/.." ; npm run build ;  docker buildx build --platform "linux/amd64,linux/arm64"  -f ./DockerFile -t elyspio/cpe-s7-project:mqtt-app --push .

rm -Recurse -Force "$DIR/../build/"
rm "$DIR/../DockerFile"

cd $origin

