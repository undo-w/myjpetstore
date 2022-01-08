var xhr;
function checkUsername(){
    var username = document.getElementById("username").value;
    //alert(username);
    xhr = new XMLHttpRequest();
    xhr.onreadystatechange = fun1;  //这里的fun1不加括号

    //因为服务器端使用doGet
    xhr.open("GET","usernameExist?username="+username,true);
    xhr.send(null);  // 因为是get的方式发送请求，没有值需要发送
}

function fun1(){  //回调函数
    if(xhr.readyState === 4){
        if(xhr.status === 200){
            var responseInfo = xhr.responseText;  // 因为服务器端servlet设置的响应的格式是text/plain,所以这里要设置成text
            console.log(responseInfo);
            var tips = document.getElementById("usernameTips");
            if(responseInfo=="Not Exist"){
                tips.className = "okTips";
                tips.innerText = "Available";

            }else if(responseInfo == "Exist"){
                tips.className = "errorTips";
                tips.innerText = "Invalid";
            }
        }
    }

}