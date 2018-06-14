//Step0：chrome浏览器中直接请求https://localhost:8443/wsserver，向websocket发送http请求,以建立websocket连接


//Step1：chrome控制台先引入sockjs.min.js文件，引入js代码如下
var script = document.createElement('script');
script.src = "https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js";
document.getElementsByTagName('head')[0].appendChild(script);

//Step2：利用SockJS与java websocket进行通信，建立连接代码如下
//（1）初始websocket连接对象SockJS
var url = "https://localhost:8443/wsserver";
var sock = new SockJS(url);
//(2)定义各个js函数
//初始化发送内容
function sayMarco(){
    console.log("Sending hello to wsserver!");
    // sock.send("{\"reqKey\": \"Hello\",\"resResult\":null}");
    sock.send("{\"reqKey\": \"HelloSecond\",\"resResult\":null}");
};
//打开websocket连接，并发送消息
sock.onopen = function(){
    console.log("Opening websocket connection");
    sayMarco();
};
//接收消息返回内容并继续发送消息
sock.onmessage = function(e){
    console.log("From wsserver receive message: " , e.data);
    setTimeout(function(){sayMarco()},2000);
};
//关闭连接
sock.onclose = function(){
    console.log("Closing websocket connection");
    sock.close();
};
//(3)console中分别调用函数方法sock.onopen()发送消息，sock.onclose()关闭连接


//Step3: 启动WsServerApplication项目，以debug模式执行，在Chrome - console中执行Step2中的代码，可以看到MarcoHandler中的断点处效果
