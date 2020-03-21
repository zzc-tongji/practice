set -e
set -u
set -x
SCRIPT_PATH=`cd "$(dirname "$0")"; pwd -P`
cd "${SCRIPT_PATH}"
git pull
