set -e
set -u
set -x
SCRIPT_PATH=`cd "$(dirname "$0")"; pwd -P`
cd "${SCRIPT_PATH}"
git add .
git commit -m "commit"
git log -n 1
git push
