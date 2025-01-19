FROM maven:3.9

ARG GID=1000
ARG GRPNAME=devgroup
ARG UID=1000
ARG USERNAME=devuser

RUN groupadd -g ${GID} ${GRPNAME} \
    && useradd -m -s /bin/bash -u ${UID} -g ${GID} ${USERNAME}

USER ${USERNAME}
