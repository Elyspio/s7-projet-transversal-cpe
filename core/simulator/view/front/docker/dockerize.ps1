$here = Get-Location
$dir = $PSScriptRoot 
cd $dir/..

yarn build


cp $dir/Dockerfile $dir/../Dockerfile
docker buildx build --platform "linux/amd64,linux/arm64"  -f ./Dockerfile -t elyspio/cpe-s7-project:simulator-front --push .
rm $dir/../Dockerfile

cd $here

