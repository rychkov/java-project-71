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
	echo "File file1.json"
	cat ../file1.json
	echo "File file2.json"
	cat ../file2.json
	echo "Diff"
	./build/install/app/bin/app ../file1.json ../file2.json
	echo "Diff in plain format"
	./build/install/app/bin/app ../file1.json ../file2.json -f=plain
	echo "Diff in JSON"
	./build/install/app/bin/app ../file1.json ../file2.json -f=json

	echo "Complex case"
	echo "File file1.json"
	cat src/test/resources/fixtures/complex/file1.json
	echo "File file2.json"
	cat src/test/resources/fixtures/complex/file1.json
	echo "Diff"
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json
	echo "Diff in plain format"
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json -f=plain
	echo "Diff in JSON format"
	./build/install/app/bin/app src/test/resources/fixtures/complex/file1.json src/test/resources/fixtures/complex/file2.json -f=json



.PHONY: run build test