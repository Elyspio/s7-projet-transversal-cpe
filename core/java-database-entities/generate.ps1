$dir = $PSScriptRoot

Remove-Item -Recurse -Force -ErrorAction SilentlyContinue "$dir/lib/build/"

./gradlew.bat build

Copy-Item -Force -Recurse "$dir/lib/build/libs" "$dir/../emergency-manager/app"
Copy-Item -Force -Recurse "$dir/lib/build/libs" "$dir/../simulator/app"


Remove-Item -Recurse -Force "$dir/lib/build"