fetch('/getSessionType')
    .then((response) => response.json())
    .then(function(data) {
        console.log(data);
        if (data && data == 2) {
            window.location.href = "/employee";
        } else if (!data) {
            window.location.href = "/login";
        }
    })

window.onload = function() {
    var table = document.querySelector("#allReimbursements");
    fetch('/getAllReimbursements')
        .then((response) => response.json())
        .then(function(data) {
            console.log(data);
            if(data) {
                for(r of data) {
                    var status;
                    switch(r["status_id"]) {
                        case 1:
                            status = "pending";
                            break;
                        case 2:
                            status = "approved";
                            break
                        case 3:
                            status = "denied";
                            break;
                    }
                    var type;
                    switch(r["type_id"]) {
                        case 1:
                            type = "lodging";
                            break;
                        case 2:
                            type = "travel";
                            break
                        case 3:
                            type = "food";
                            break;
                        case 4:
                            type = "other";
                            break;
                    }

                    var submitted = r["submitted"];
                    console.log(r["resolved"])
                    if (r["resolved"]){
                        var resolved = r["resolved"];
                    } else {
                        var resolved = "";
                    }
                    if (!r["description"]) {
                        r["description"] = "";
                    }
                    table.innerHTML += `
					<tr>	
						<td>${r["id"]}</td>
						<td>${r["author_id"]}</td>
						<td>${r["amt"]}</td>
						<td>${submitted}</td>
						<td>${resolved}</td>
						<td>${r["description"]}</td>
						<td>${status}</td>
						<td>${type}</td>
					</tr>	
					`;
                }
            } else {

            }
        })
}
document.querySelector('#logout').addEventListener('click', function() {
    fetch('/logout');
    window.location.href = "/login";
});
document.querySelector("#btnViewApproved").addEventListener('click', function(){
    window.location.href = "/managerViewApproved";
})
document.querySelector("#btnViewDenied").addEventListener('click', function(){
    window.location.href = "/managerViewDenied";
})
document.querySelector("#btnViewPending").addEventListener('click', function(){
    window.location.href = "/managerViewPending";
})