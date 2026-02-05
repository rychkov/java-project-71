run: clean build run-dist

clean:
	./gradlew clean

build:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app

help: build
	./build/install/app/bin/app --help

.PHONY: run build