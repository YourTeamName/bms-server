#!/usr/bin/env bash

echo "-- Killing process on port 5000"
lsof -i :5000 | awk '{print $2}' | xargs kill -9
mvn clean install -DskipTests
heroku local