#!/bin/sh

SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE:-$0}")" && pwd)
PARENT_DIR=$(cd "$(dirname "${BASH_SOURCE:-$0}")/.." && pwd)

OUTPUT_DIR="${SCRIPT_DIR}/_build"

DOC_ROOT="${SCRIPT_DIR}"
DOC_INDEX="index.adoc"

rm -rf "${OUTPUT_DIR}"

asciidoctor \
  -r asciidoctor-diagram \
  -D "${OUTPUT_DIR}" \
  -R "${DOC_ROOT}" \
  -a skip-front-matter \
  -a docinfo=shared \
  -a docinfodir="${DOC_ROOT}" \
  "${DOC_ROOT}/index.adoc"


# plantuml を使うと謎のディレクトリが作成されるため、削除
if [ -d ${SCRIPT_DIR}/\? ]; then
  rm -rf ${SCRIPT_DIR}/\?/
fi


exit 0
