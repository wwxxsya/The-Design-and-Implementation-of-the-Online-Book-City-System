function time(){
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth()+1;//月从0开始要加一
    month = month<10?"0"+month:month;//用三目运算符将1变为01，2变02等等。
    var day = date.getDate();
    day = day<10?"0"+day:day;
    var week = "日一二三四五六".charAt(date.getDay());//星期也是从0开始
    var hour = date.getHours();
    hour = hour<10?"0"+hour:hour;
    var minute = date.getMinutes();
    minute = minute<10?"0"+minute:minute;
    var second = date.getSeconds();
    second = second<10?"0"+second:second;
    
    var current = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+" 星期"+week;
    document.getElementById("time").innerHTML = current;//将current插入id为time的HTML语句中间。
}
time();
setInterval("time()",1000);