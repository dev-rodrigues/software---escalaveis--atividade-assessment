# cloning repository activity--assessment
# git clone git@github.com:dev-rodrigues/software---escalaveis--atividade-assessment.git

# cloning repository evaluation--assessment
# git clone git@github.com:dev-rodrigues/software---escalaveis--avaliacao-assessment.git

# running rabbitmq
docker-compose up -d

# running application activity--assessment
# https://hub.docker.com/repository/docker/httpsantos/activity-service
docker run -d --network=host httpsantos/activity-service:final

# running application evaluation--assessment
# https://hub.docker.com/repository/docker/httpsantos/evaluation-service
docker run  -d --network=host httpsantos/evaluation-service:final
