all: clean
	@echo "Building program..."
	javac -d target ProcessBuilderExample.java

run: all
	java -cp target ProcessBuilderExample

clean:
	@echo "Deleting all class files..."
	find . -name "*.class" -type f -delete