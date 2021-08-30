FROM tomcat:8.0-jre8
COPY metacat-functional-tests/build/metacat-war-expanded/ROOT /usr/local/tomcat/webapps/ROOT
COPY metacat-functional-tests/metacat-test-cluster/resources/logging.properties /usr/local/tomcat/conf/logging.properties
