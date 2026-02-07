run: clean build test run-dist

clean:
	./gradlew clean

build: lint test
	./gradlew installDist

test:
	./gradlew test

lint:
	./gradlew checkstyleMain

run-dist:
	./build/install/app/bin/app

help: build
	./build/install/app/bin/app --help

diff: build
	./build/install/app/bin/app ../file1.json ../file2.json

.PHONY: run build test