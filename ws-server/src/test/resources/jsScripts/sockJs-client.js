//Step1：chrome控制台先引入sockjs.min.js文件，引入js代码如下
var script = document.createElement('script');
script.src = "https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js";
document.getElementsByTagName('head')[0].appendChild(script);

//Step2：利用SockJS与java websocket建立连接，建立连接代码如下
var url = "https://localhost:8443/wsserver";
var sock = new SockJS(url);
sock.onopen = function(){
    console.log("Opening websocket connection");
    sayMarco();
};
sock.onmessage = function(e){
    console.log("From wsserver receive message: " , e.data);
    setTimeout(function(){sayMarco()},2000);
};
sock.onclose = function(){
    console.log("Closing websocket connection");
};
function sayMarco(){
    console.log("Sending hello to wsserver!");
    // sock.send("{\"reqKey\": \"Hello\",\"resResult\":null}");
    sock.send("{\"reqKey\": \"HelloSecond\",\"resResult\":null}");
};

//Step3: 启动WsServerApplication项目，以debug模式执行，在Chrome - console中执行Step2中的代码，可以看到MarcoHandler中的断点处效果
