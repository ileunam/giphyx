FROM openjdk:11-jdk-slim

#ENV DEBIAN_FRONTEND=noninteractive
#
#WORKDIR /opt
#RUN apt-get update \
#    && apt-get install -y --no-install-recommends \
#        ca-certificates \
#        curl \
#    && curl \
#        -L \
#        -o openjdk.tar.gz \
#        https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_linux-x64_bin.tar.gz \
#    && mkdir jdk \
#    && tar zxf openjdk.tar.gz -C jdk --strip-components=1 \
#    && rm -rf openjdk.tar.gz \
#    && apt-get -y --purge autoremove curl \
#    && ln -sf /opt/jdk/bin/* /usr/local/bin/ \
#    && rm -rf /var/lib/apt/lists/* \
#    && java  --version \
#    && javac --version \
#    && jlink --version
#
#CMD ["/bin/bash"]

RUN mkdir /usr/microservices
#
COPY ./ms-eureka/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./gif-app/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-gateway/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-oauth/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-users/build/libs/*-SNAPSHOT.jar /usr/microservices
COPY ./ms-zuul/build/libs/*-SNAPSHOT.jar /usr/microservices
#
COPY ./run.sh /usr/microservices
#
WORKDIR /usr/microservices
#
RUN ./run.sh
#
CMD ["/bin/bash"]