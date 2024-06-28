# !/bin/bash
# jar 위치 변수 지정
BUILD_JAR=$(ls /home/ec2-user/app/step1/*.jar)
JAR_NAME=$(basename $BUILD_JAR)
echo ">>> build 파일명: $JAR_NAME" >> /home/ec2-user/app/step1/deploy_info.log

echo ">>> build 파일 복사" >> /home/ec2-user/app/step1/deploy_info.log
DEPLOY_PATH=/home/ec2-user/
cp $BUILD_JAR $DEPLOY_PATH

echo ">>> 현재 실행중인 애플리케이션 pid 확인" >> /home/ec2-user/app/step1/deploy_info.log
CURRENT_PID=$(pgrep -f $JAR_NAME)

if [ -z $CURRENT_PID ]
then
  echo ">>> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다." >> /home/ec2-user/app/step1/deploy_info.log
else
  echo ">>> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포" >> /home/ec2-user/app/step1/deploy_info.log

REPOSITORY=/home/ec2-user/app/step1
PROJECT_NAME=hakjumbank2

cd $REPOSITORY/$PROJECT_NAME/
JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)

echo "> JAR Name: $JAR_NAME" >> /home/ec2-user/app/step1/deploy_info.log

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,\
/home/ec2-user/app/application-oauth.properties,\
/home/ec2-user/app/application-real-db.properties,\
classpath:/application-real.properties \
  -Dspring.profiles.active=real \
  $REPOSITORY/$JAR_NAME > $REPOSITORY/nohup.out 2>&1 &