#!/bin/bash
docker run -e LSD_FE_PROD="1" -d -p 8083:8080 --rm rasmusbn/lsd-frontend:latest