fetch('/getSessionType')
    .then((response) => response.json())
    .then(function(data) {
        console.log(data);
        if (data && data == 1) {
            window.location.href = "/managerViewAll";
        } else if (data && data == 2) {
            window.location.href = "/employee";
        }
    })

var button = document.querySelector('#btnLogin');
button.addEventListener('click', attemptLogin);
function attemptLogin(e) {
    e.preventDefault();
    var username = document.querySelector("#username").value;
    var password = document.querySelector("#password").value;
    fetch('/getAccount',{
        method: "post",
        body: JSON.stringify({
            'username': username,
            'password': password
        })
    }).then((response) => response.json())
        .then(function(data) {
            document.querySelector("#username").value = "";
            document.querySelector("#password").value = "";
            if(data) {
                if (data["user_role_id"] == 2){
                    window.location.href = "/employee";
                }
                else{
                    window.location.href = "/managerViewAll";
                }
            } else {
                document.querySelector("#badlogin").innerText = "Invalid Username or Password. Please try again.";
            }
        })

}
