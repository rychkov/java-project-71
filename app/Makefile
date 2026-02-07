run: clean build test run-dist

clean:
	./gradlew clean

build: lint test
	./gradlew installDist

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew spotlessApply

run-dist:
	./build/install/app/bin/app

help: build
	./build/install/app/bin/app --help

diff: build
	./build/install/app/bin/app ../file1.json ../file2.json
	./build/install/app/bin/app ../file1.json ../file2.json -f=plain
	./build/install/app/bin/app ../file1.json ../file2.json -f=json
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json -f=plain
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json -f=json



.PHONY: run build test