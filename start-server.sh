port_array=(9991 9992 9993)

for ((i = 0; i < ${#port_array[@]}; i++)); do
  port=${port_array[$i]}
  nohup java -jar "deploy/server$((i+1))/rpc-server.jar" "$port" >"deploy/server$((i+1)).log" 2>&1 &

  if [ $i -eq 0 ]; then
    echo $! >pid
  else
    echo $! >>pid
  fi
done

echo "server started."
