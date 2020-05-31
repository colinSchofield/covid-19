#!/bin/sh
# Script used to deploy the Covid-19 application to the EC-2 server

scp target/covid19-0.0.1-SNAPSHOT.jar ec2-user@3.25.58.73:.
ssh ec2-user@3.25.58.73 "./run.sh"
