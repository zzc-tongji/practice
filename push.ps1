Set-Location $PSScriptRoot
git add .
git commit -m "commit"
if (-not $?) {
  exit 1
}
git log -n 1
git push
