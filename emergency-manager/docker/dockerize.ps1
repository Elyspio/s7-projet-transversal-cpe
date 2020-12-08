#!/bin/bash

$origin=Get-Location

$DIR=$PSScriptRoot

cp "$DIR/DockerFile" "$DIR/../DockerFile"

gradle build
jar -cvf "$DIR/../site.war" "$DIR/../build"
cd "$DIR/.." ;  docker buildx build --platform linux/amd64,linux/arm64  -f ./DockerFile -t elyspio/cpe-s7-project:emergency-manager --push .
rm "$DIR/../site.war"
rm -Recurse -Force "$DIR/../build/"
rm "$DIR/../DockerFile"

cd $origin

