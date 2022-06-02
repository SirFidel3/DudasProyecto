const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});
signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});
//registro *.*.*.*.*.*.*..**.*..*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.**.*.*.*
function register() {
    var sxmlhttp;
    var emailv = document.getElementByName("email").value;
    sxmlhttp=new XMLHttpRequest();
    
    sxmlhttp.onreadystatechange = function() {
        if (sxmlhttp.readyState==4 && sxmlhttp.status==200) {
            location.href("http://127.0.0.1:5500/inicio/inicio.html");
        }
    }


    sxmlhttp.open("POST","http://localhost:7070/proyectoProgramac/UsuarioPr",true);
    sxmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    sxmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    sxmlhttp.send(  "dni="+document.getElementById('dni').value+
                    "&&name="+document.getElementById('name').value+ 
                    "&&surnames="+document.getElementById('surnames').value+ 
                    "&&email="+document.getElementById('email').value+
                    "&&password="+document.getElementById('password').value+
                    "&&date="+document.getElementById('date').value+
                    "&&address="+document.getElementById('address').value+
                    "&&card="+document.getElementById('card').value);
}
//*.*.*.*.**.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*

function login() {
    if(document.getElementById("emaillog")== "admin@si" && document.getElementById("passwordlog")=="12345"){
        var sxmlhttp;
        sxmlhttp=new XMLHttpRequest();
        var email;
        email = document.getElementById("emaillog").value;

        sxmlhttp.onreadystatechange = function() {
            if (sxmlhttp.readyState==4 && sxmlhttp.status==200) {
                location.href("http://127.0.0.1:5500/admin/admin.html");
            }
        }


        sxmlhttp.open("GET","http://localhost:7070/proyectoProgramac/UsuarioPr",true);
        sxmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        sxmlhttp.send(  "emaillog="+document-getElementById("emaillog").value+
                        "&&passwordlog="+document.getElementById('passwordlog').value);
    }else{
        var sxmlhttp;
        sxmlhttp=new XMLHttpRequest();
        var email;
        email = document.getElementById("emaillog").value;

        sxmlhttp.onreadystatechange = function() {
            if (sxmlhttp.readyState==4 && sxmlhttp.status==200) {
                location.href("http://127.0.0.1:5500/inicio/inicio.html");
            }
        }


        sxmlhttp.open("GET","http://localhost:7070/proyectoProgramac/UsuarioPr",true);
        sxmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        sxmlhttp.send(  "emaillog="+document-getElementById("emaillog").value+
                        "&&passwordlog="+document.getElementById('passwordlog').value);
    }
}



