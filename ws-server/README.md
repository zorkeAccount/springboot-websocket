# ws-server
##### 一、基于springboot的websocket服务端的实现，提供以下几项能力：
1. 提供websocket服务，且http端口8080，https端口8443
2. js代码测试客户端与该服务连接的建立

##### 二、测试教程：
1. 自定义本地https证书：</br>
命令执行 - keytool -genkey -alias tomcat  -storetype PKCS12 -keyalg RSA -keysize 2048  -keystore keystore.p12 -validity 3650
</br>输入密码 - 如admin123 
</br>其他参数 - 留空即可，确认即可在当前目录生成 keystore.p12 文件，并替换掉src/main/resources下的keystore.p12文件
2. IDE中直接run执行WsServerApplication. java或者mvn install and java -jar ws-server-0.0.1-SNAPSHOT.jar启动即可
3. chrome浏览器发送http请求https://localhost:8443/wsserver，，建立websocket连接；并且在该页面的控制台console中引入sockjs.min.js文件，命令如下</br>
var script = document.createElement('script');</br>
script.src = "https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js";</br>
document.getElementsByTagName('head')[0].appendChild(script);
4. chrome浏览器控制台console中输入js测试客户端代码，具体见ws-server/scr/test/rescources/jsScripts/sockJs-client.js文件中代码