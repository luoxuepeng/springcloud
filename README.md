sed -i 's/\r//' register.sh
sed -i 's/\r//' order.sh

ps -ef | grep order-system.jar | grep -v grep | awk '{print $2}'