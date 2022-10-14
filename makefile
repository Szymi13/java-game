make:
	javac -d ./classes -cp . ./src/*.java
  
play:
	java -cp ./classes Main
