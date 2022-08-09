function jQuery(selector){
    // 根据选择器切换代码
    if(typeof selector == "string"){
        if(selector.charAt(0) == "#"){
            // 变成全局变量
            domObj=document.getElementById(selector.substring(1))
            // 返回Dom对象
            // return domObj
            // 返回jQuery对象
            return new jQuery();
        }
    }
    if(typeof selector == "function"){
        window.onload = selector
    }

    // 定义一个html函()数，代替domObj.html()
    this.html = function (a){
        domObj.innerHTML = a;
    }

    // 定义click函数，代替dom对象的onclick() （如果直接用onclick，由于上边返回的是jQuery对象，但是onclick是DOM对象的函数）
    this.click = function (fun){
        domObj.onclick = fun;
    }

    // 扩展 eg
    this.focus = function (fun){
        domObj.onfocus = fun;
    }
    // ...

    this.change = function (fun){
        domObj.onchange = fun;
    }

    this.val = function (v){
        if(!(v == undefined))
            domObj.value = v;
        return domObj.value;
    }

    jQuery.ajax = function (args){
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function (){
            if(this.readyState == 4){
                if(this.status == 200){
                    args.success(JSON.parse(this.responseText))
                }
                else{
                    alert(this.status)
                }
            }
        }
        if(args.type.toUpperCase() == "POST"){
            xhr.open("POST", args.url, args.async);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send(args.data)
        }
        if(args.type.toUpperCase() == "GET"){
            xhr.open("GET", args.url + "?" + args.data, args.async);
            xhr.send()
        }
    }
}

$ = jQuery

// $(function (){
//     $("#btn").click(function (){
//         $("#div").html("jquery2");
//
//         // 获取文本框内容
//         var username = $('#username').val();
//         alert(username)
//
//         // 修改文本框内容
//         $('#username').val('张三')
//         alert($('#username').val())
//     })
// })
// 细节，此方法是为了让静态方法生效
new jQuery()