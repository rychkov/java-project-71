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
	clear
	printf "File file1.json\n"
	cat ../file1.json
	printf "File file2.json\n"
	cat ../file2.json
	printf "\nDiff\n"
	./build/install/app/bin/app ../file1.json ../file2.json
	printf "\nDiff in plain format\n"
	./build/install/app/bin/app ../file1.json ../file2.json -f=plain
	printf "\nDiff in JSON\n"
	./build/install/app/bin/app ../file1.json ../file2.json -f=json
	printf "\nComplex case\n"
	printf "\nFile file1.json\n"
	cat src/test/resources/fixtures/complex/file1.json
	printf "\nFile file2.json\n"
	cat src/test/resources/fixtures/complex/file1.json
	printf "\nDiff\n"
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json
	printf "\nDiff in plain format\n"
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json -f=plain
	printf "\nDiff in JSON format\n"
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json -f=json

.PHONY: run build test