#!/bin/bash

# abort script if something fails
set -e

if [ ! $(which brew) ]; then
    echo "-- Installing homebrew - a package manager for OS X"
    ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
fi

echo "-- Updating homebrew package list"
brew update

if [[ ! $(brew ls --versions brew-cask) ]]; then
    echo "-- Installing homebrew cask"
    brew install caskroom/cask/brew-cask
fi

#  needed for the app
echo "-- Installing maven through homebrew"
brew install maven

echo "-- Installing heroku-toolbelt through homebrew"
brew install heroku-toolbelt

# set environment variables
echo "-- Setting heroku evironment variables"
heroku config:get DATABASE_URL -s --app buzz-movie-selector >> .env