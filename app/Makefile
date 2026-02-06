run: clean build run-dist

clean:
	./gradlew clean

build:
	./gradlew installDist

run-dist:
	./build/install/app/bin/app

help: build
	./build/install/app/bin/app --help

diff: build
	./build/install/app/bin/app ../file1.json ../file2.json

.PHONY: run build