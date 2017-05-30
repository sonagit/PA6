#!/bin/bash

echo $'\n\n\n\n\n'

javac -cp .:tester.jar *.java

# Run TestTweetServer if test is passed
if [ "$1" == "test" ]; then
  java -cp .:tester.jar tester.Main TestTweetServer
fi

# Run TweetServerMain if server is passed
if [ "$1" == "server" ]; then
  java TweetServerMain
fi
