#!/usr/bin/env bash
set -euo pipefail

LOG="/opt/devops-project/scripts/setup_versions.log"
sudo apt-get update -y
sudo apt-get install -y git curl unzip ca-certificates

# Java 17
sudo apt-get install -y openjdk-17-jdk

{
  echo "==== DATE ===="
  date
  echo "==== JAVA ===="
  java -version
  echo "==== GIT ===="
  git --version
} | tee "$LOG"
