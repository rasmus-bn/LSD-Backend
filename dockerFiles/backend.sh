#!/bin/bash
docker run -d -p 8082:8080 --name "backend" \
--restart on-failure \
rasmusbn/lsd-backend:latest
