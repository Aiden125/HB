# !/bin/bash
# jar 위치 변수 지정
BUILD_JAR=$(ls /home/ec2-user/app/jenkins/build/libs/*.jar)
JAR_NAME=$(basename $BUILD_JAR)
REPOSITORY=/home/ec2-user/app/step1
PROJECT_NAME=hakjumbank2

# 빌드 파일 복사
echo ">>> build 파일명: $JAR_NAME" >> $REPOSITORY/deploy_info.log
echo ">>> build 파일 다음 위치에 복사: $REPOSITORY" >> $REPOSITORY/deploy_info.log
cp $BUILD_JAR $REPOSITORY # jar 복사(젠킨스 위치에서 현재 레파지토리로)

# 실행중인 process 제거
CURRENT_PID=$(pgrep -f $JAR_NAME)
echo ">>> 현재 실행중인 애플리케이션 pid: $CURRENT_PID}" >> $REPOSITORY/deploy_info.log

if [ -z $CURRENT_PID ]
then
  echo ">>> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다." >> $REPOSITORY/deploy_info.log
else
  echo ">>> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

# 새로운 jar 배포
JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)
echo "> 새 애플리케이션 배포 > JAR Name: $JAR_NAME" >> $REPOSITORY/deploy_info.log

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,\
/home/ec2-user/app/application-oauth.properties,\
/home/ec2-user/app/application-real-db.properties,\
classpath:/application-real.properties \
  -Dspring.profiles.active=real \
  $REPOSITORY/$JAR_NAME > $REPOSITORY/nohup.out 2>&1 &