#!/bin/bash

$origin = Get-Location

$DIR = $PSScriptRoot

cp "$DIR/Dockerfile" "$DIR/../Dockerfile"

cd "$DIR/..";
gradle build;
mv "$DIR/../build/libs/*.war" "$DIR/../build/libs/ROOT.war"
docker buildx build --platform "linux/amd64,linux/arm64"  -f ./DockerFile -t elyspio/cpe-s7-project:simulator --push .

rm -Recurse -Force "$DIR/../build/"
rm "$DIR/../Dockerfile"

cd $origin

