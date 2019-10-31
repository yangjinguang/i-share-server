install:
	 mvn clean install -DskipTests -DskipDocker
build:
	mvn clean install -DskipTests
flyway:
	mvn clean install -DskipTests -DskipDocker -Pflyway
jooq:
	mvn clean install -DskipTests -DskipDocker -Pjooq
release:
	rm -f release.properties pom.xml.releaseBackup
	mvn release:prepare -B
rollback:
	mvn release:rollback
