#!/bin/bash
docker run -d -p 8082:8080 --name "backend" \
--restart on-failure \
davidcarl/lsd-backend:0.2.0
