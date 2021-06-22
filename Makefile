all:
	javac -d out/ src/*.java
run:
	cd out
	java Main
	cd ..
	
